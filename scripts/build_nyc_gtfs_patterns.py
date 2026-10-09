#!/usr/bin/env python3
import csv
import hashlib
import json
import os
import tempfile
import urllib.request
import zipfile
from collections import defaultdict
from datetime import datetime, timezone

SOURCE_URL = "https://rrgtfsfeeds.s3.amazonaws.com/gtfs_supplemented.zip"
OUTPUT_PATH = "docs/data/nyc-gtfs-patterns.json"

def canonical_route_id(short_name: str, route_id: str) -> str:
    short = (short_name or "").strip()
    raw = (route_id or "").strip()
    key = short.lower().replace(" ", "").replace("_", "").replace("-", "")

    if key in {"sir", "si"}:
        return "us:nyc:sir"
    if key in {"s", "gs"} or raw.upper() == "GS":
        return "us:nyc:s:gs"

    normalized = "".join(ch for ch in key if ch.isalnum())
    return f"us:nyc:{normalized or raw.lower()}"

def read_csv_from_zip(zf: zipfile.ZipFile, name: str):
    with zf.open(name, "r") as raw:
        text = (line.decode("utf-8-sig") for line in raw)
        yield from csv.DictReader(text)

def station_id_from_row(stop: dict) -> str:
    parent = (stop.get("parent_station") or "").strip()
    stop_id = (stop.get("stop_id") or "").strip()
    return parent or stop_id

def main() -> None:
    os.makedirs(os.path.dirname(OUTPUT_PATH), exist_ok=True)

    with tempfile.NamedTemporaryFile(suffix=".zip", delete=False) as tmp:
        zip_path = tmp.name

    try:
        print(f"Downloading official MTA supplemented GTFS: {SOURCE_URL}")
        request = urllib.request.Request(
            SOURCE_URL,
            headers={"User-Agent": "Tickets-NYC-GTFS-Pattern-Builder/1.1"},
        )
        with urllib.request.urlopen(request, timeout=120) as response, open(zip_path, "wb") as out:
            while True:
                chunk = response.read(1024 * 1024)
                if not chunk:
                    break
                out.write(chunk)

        with open(zip_path, "rb") as fh:
            source_sha256 = hashlib.sha256(fh.read()).hexdigest()

        with zipfile.ZipFile(zip_path, "r") as zf:
            required = {"routes.txt", "stops.txt", "trips.txt", "stop_times.txt"}
            names = {name.split("/")[-1] for name in zf.namelist()}
            missing = required - names
            if missing:
                raise RuntimeError(f"Official GTFS is missing required files: {sorted(missing)}")

            source_routes = {}
            routes = {}

            for row in read_csv_from_zip(zf, "routes.txt"):
                raw_route_id = (row.get("route_id") or "").strip()
                short_name = (row.get("route_short_name") or "").strip()
                route_type = int((row.get("route_type") or "0").strip() or "0")
                special_rail = (
                    raw_route_id.upper() in {"GS", "SI"}
                    or short_name.upper() in {"S", "SIR"}
                )
                if not raw_route_id or (route_type != 1 and not special_rail):
                    continue

                canonical = canonical_route_id(short_name, raw_route_id)
                source_routes[raw_route_id] = canonical
                routes[canonical] = {
                    "routeId": canonical,
                    "shortName": short_name or raw_route_id,
                    "longName": (row.get("route_long_name") or short_name or raw_route_id).strip(),
                    "sourceRouteId": raw_route_id,
                }

            stops = {}
            for row in read_csv_from_zip(zf, "stops.txt"):
                stop_id = (row.get("stop_id") or "").strip()
                if stop_id:
                    stops[stop_id] = station_id_from_row(row)

            trips_in_order = []
            trips = {}
            for row in read_csv_from_zip(zf, "trips.txt"):
                trip_id = (row.get("trip_id") or "").strip()
                source_route_id = (row.get("route_id") or "").strip()
                if not trip_id or source_route_id not in source_routes:
                    continue

                trip = {
                    "routeId": source_routes[source_route_id],
                    "directionId": (row.get("direction_id") or "").strip(),
                }
                trips[trip_id] = trip
                trips_in_order.append(trip_id)

            trip_stops = defaultdict(list)
            for row in read_csv_from_zip(zf, "stop_times.txt"):
                trip_id = (row.get("trip_id") or "").strip()
                if trip_id not in trips:
                    continue

                stop_id = (row.get("stop_id") or "").strip()
                station_id = stops.get(stop_id)
                if not station_id:
                    continue

                try:
                    sequence = int((row.get("stop_sequence") or "").strip())
                except ValueError:
                    continue

                trip_stops[trip_id].append((sequence, station_id))

        pattern_to_index = {}
        pattern_details = []
        pattern_indexes = []

        for trip_id in trips_in_order:
            trip = trips[trip_id]
            rows = trip_stops.get(trip_id, [])

            rows.sort(key=lambda item: item[0])
            station_ids = []
            seen = set()

            for _, station_id in rows:
                if station_id in seen:
                    continue
                seen.add(station_id)
                station_ids.append(station_id)

            if len(station_ids) < 2:
                pattern_indexes.append(-1)
                continue

            route_id = trip["routeId"]
            direction = trip["directionId"]
            pattern_key = f'{route_id}|{direction}|{",".join(station_ids)}'

            index = pattern_to_index.get(pattern_key)
            if index is None:
                index = len(pattern_details)
                pattern_to_index[pattern_key] = index
                pattern_details.append({
                    "r": route_id,
                    "d": direction,
                    "s": station_ids,
                })

            pattern_indexes.append(index)

        matched_trips = sum(1 for value in pattern_indexes if value >= 0)
        total_trips = len(trips_in_order)
        coverage = matched_trips / total_trips if total_trips else 0.0

        if len(routes) < 20:
            raise RuntimeError(f"Unexpected NYC route count: {len(routes)}")
        if total_trips < 10000:
            raise RuntimeError(f"Unexpected NYC trip count: {total_trips}")
        if coverage < 0.80:
            raise RuntimeError(
                f"Official GTFS pattern coverage too low: {matched_trips}/{total_trips} ({coverage:.1%})"
            )

        payload = {
            "schemaVersion": 2,
            "cityId": "nyc",
            "sourceUrl": SOURCE_URL,
            "sourceSha256": source_sha256,
            "generatedAt": datetime.now(timezone.utc).isoformat(),
            "routeCount": len(routes),
            "tripCount": total_trips,
            "matchedTripCount": matched_trips,
            "coverage": coverage,
            "patterns": pattern_details,
            "tripPatternIndexes": pattern_indexes,
        }

        with open(OUTPUT_PATH, "w", encoding="utf-8", newline="") as out:
            json.dump(payload, out, ensure_ascii=False, separators=(",", ":"))
            out.write("\n")

        file_size = os.path.getsize(OUTPUT_PATH)
        print(
            "NYC GTFS pattern data generated:",
            f"routes={len(routes)}",
            f"trips={total_trips}",
            f"matchedTrips={matched_trips}",
            f"patterns={len(pattern_details)}",
            f"coverage={coverage:.1%}",
            f"size={file_size} bytes",
        )
    finally:
        try:
            os.remove(zip_path)
        except FileNotFoundError:
            pass

if __name__ == "__main__":
    main()
