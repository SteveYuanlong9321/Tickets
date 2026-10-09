package com.example.tickets;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LiveUpdateManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\bF\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BÅ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003Jå\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0005HÆ\u0001J\u0013\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010N\u001a\u00020\u0003HÖ\u0001J\t\u0010O\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001fR\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001f¨\u0006P"}, d2 = {"Lcom/example/tickets/LiveUpdatePayload;", "", "ticketId", "", "ticketType", "", "title", "code", "date", "time", "departureDate", "arrivalDate", Constants.MessagePayloadKeys.FROM, "to", "departurePlatform", "arrivalPlatform", "hall", "seat", "venue", "area", "entry", "startTime", "endTime", "takeoffTime", "landingTime", "brand", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTicketId", "()I", "getTicketType", "()Ljava/lang/String;", "getTitle", "getCode", "getDate", "getTime", "getDepartureDate", "getArrivalDate", "getFrom", "getTo", "getDeparturePlatform", "getArrivalPlatform", "getHall", "getSeat", "getVenue", "getArea", "getEntry", "getStartTime", "getEndTime", "getTakeoffTime", "getLandingTime", "getBrand", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class LiveUpdatePayload {
    public static final int $stable = 0;
    private final String area;
    private final String arrivalDate;
    private final String arrivalPlatform;
    private final String brand;
    private final String code;
    private final String date;
    private final String departureDate;
    private final String departurePlatform;
    private final String endTime;
    private final String entry;
    private final String from;
    private final String hall;
    private final String landingTime;
    private final String seat;
    private final String startTime;
    private final String takeoffTime;
    private final int ticketId;
    private final String ticketType;
    private final String time;
    private final String title;
    private final String to;
    private final String venue;

    public static /* synthetic */ LiveUpdatePayload copy$default(LiveUpdatePayload liveUpdatePayload, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, int i2, Object obj) {
        String str22;
        String str23;
        int i3 = (i2 & 1) != 0 ? liveUpdatePayload.ticketId : i;
        String str24 = (i2 & 2) != 0 ? liveUpdatePayload.ticketType : str;
        String str25 = (i2 & 4) != 0 ? liveUpdatePayload.title : str2;
        String str26 = (i2 & 8) != 0 ? liveUpdatePayload.code : str3;
        String str27 = (i2 & 16) != 0 ? liveUpdatePayload.date : str4;
        String str28 = (i2 & 32) != 0 ? liveUpdatePayload.time : str5;
        String str29 = (i2 & 64) != 0 ? liveUpdatePayload.departureDate : str6;
        String str30 = (i2 & 128) != 0 ? liveUpdatePayload.arrivalDate : str7;
        String str31 = (i2 & 256) != 0 ? liveUpdatePayload.from : str8;
        String str32 = (i2 & 512) != 0 ? liveUpdatePayload.to : str9;
        String str33 = (i2 & 1024) != 0 ? liveUpdatePayload.departurePlatform : str10;
        String str34 = (i2 & 2048) != 0 ? liveUpdatePayload.arrivalPlatform : str11;
        String str35 = (i2 & 4096) != 0 ? liveUpdatePayload.hall : str12;
        String str36 = (i2 & 8192) != 0 ? liveUpdatePayload.seat : str13;
        int i4 = i3;
        String str37 = (i2 & 16384) != 0 ? liveUpdatePayload.venue : str14;
        String str38 = (i2 & 32768) != 0 ? liveUpdatePayload.area : str15;
        String str39 = (i2 & 65536) != 0 ? liveUpdatePayload.entry : str16;
        String str40 = (i2 & 131072) != 0 ? liveUpdatePayload.startTime : str17;
        String str41 = (i2 & 262144) != 0 ? liveUpdatePayload.endTime : str18;
        String str42 = (i2 & 524288) != 0 ? liveUpdatePayload.takeoffTime : str19;
        String str43 = (i2 & 1048576) != 0 ? liveUpdatePayload.landingTime : str20;
        if ((i2 & 2097152) != 0) {
            str23 = str43;
            str22 = liveUpdatePayload.brand;
        } else {
            str22 = str21;
            str23 = str43;
        }
        return liveUpdatePayload.copy(i4, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, str23, str22);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTicketId() {
        return this.ticketId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getTo() {
        return this.to;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getDeparturePlatform() {
        return this.departurePlatform;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getArrivalPlatform() {
        return this.arrivalPlatform;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getHall() {
        return this.hall;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getSeat() {
        return this.seat;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getVenue() {
        return this.venue;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getArea() {
        return this.area;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getEntry() {
        return this.entry;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTicketType() {
        return this.ticketType;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getTakeoffTime() {
        return this.takeoffTime;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getLandingTime() {
        return this.landingTime;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getBrand() {
        return this.brand;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDepartureDate() {
        return this.departureDate;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getArrivalDate() {
        return this.arrivalDate;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getFrom() {
        return this.from;
    }

    public final LiveUpdatePayload copy(int ticketId, String ticketType, String title, String code, String date, String time, String departureDate, String arrivalDate, String from, String to, String departurePlatform, String arrivalPlatform, String hall, String seat, String venue, String area, String entry, String startTime, String endTime, String takeoffTime, String landingTime, String brand) {
        Intrinsics.checkNotNullParameter(ticketType, "ticketType");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(departureDate, "departureDate");
        Intrinsics.checkNotNullParameter(arrivalDate, "arrivalDate");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(departurePlatform, "departurePlatform");
        Intrinsics.checkNotNullParameter(arrivalPlatform, "arrivalPlatform");
        Intrinsics.checkNotNullParameter(hall, "hall");
        Intrinsics.checkNotNullParameter(seat, "seat");
        Intrinsics.checkNotNullParameter(venue, "venue");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(takeoffTime, "takeoffTime");
        Intrinsics.checkNotNullParameter(landingTime, "landingTime");
        Intrinsics.checkNotNullParameter(brand, "brand");
        return new LiveUpdatePayload(ticketId, ticketType, title, code, date, time, departureDate, arrivalDate, from, to, departurePlatform, arrivalPlatform, hall, seat, venue, area, entry, startTime, endTime, takeoffTime, landingTime, brand);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveUpdatePayload)) {
            return false;
        }
        LiveUpdatePayload liveUpdatePayload = (LiveUpdatePayload) other;
        return this.ticketId == liveUpdatePayload.ticketId && Intrinsics.areEqual(this.ticketType, liveUpdatePayload.ticketType) && Intrinsics.areEqual(this.title, liveUpdatePayload.title) && Intrinsics.areEqual(this.code, liveUpdatePayload.code) && Intrinsics.areEqual(this.date, liveUpdatePayload.date) && Intrinsics.areEqual(this.time, liveUpdatePayload.time) && Intrinsics.areEqual(this.departureDate, liveUpdatePayload.departureDate) && Intrinsics.areEqual(this.arrivalDate, liveUpdatePayload.arrivalDate) && Intrinsics.areEqual(this.from, liveUpdatePayload.from) && Intrinsics.areEqual(this.to, liveUpdatePayload.to) && Intrinsics.areEqual(this.departurePlatform, liveUpdatePayload.departurePlatform) && Intrinsics.areEqual(this.arrivalPlatform, liveUpdatePayload.arrivalPlatform) && Intrinsics.areEqual(this.hall, liveUpdatePayload.hall) && Intrinsics.areEqual(this.seat, liveUpdatePayload.seat) && Intrinsics.areEqual(this.venue, liveUpdatePayload.venue) && Intrinsics.areEqual(this.area, liveUpdatePayload.area) && Intrinsics.areEqual(this.entry, liveUpdatePayload.entry) && Intrinsics.areEqual(this.startTime, liveUpdatePayload.startTime) && Intrinsics.areEqual(this.endTime, liveUpdatePayload.endTime) && Intrinsics.areEqual(this.takeoffTime, liveUpdatePayload.takeoffTime) && Intrinsics.areEqual(this.landingTime, liveUpdatePayload.landingTime) && Intrinsics.areEqual(this.brand, liveUpdatePayload.brand);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((Integer.hashCode(this.ticketId) * 31) + this.ticketType.hashCode()) * 31) + this.title.hashCode()) * 31) + this.code.hashCode()) * 31) + this.date.hashCode()) * 31) + this.time.hashCode()) * 31) + this.departureDate.hashCode()) * 31) + this.arrivalDate.hashCode()) * 31) + this.from.hashCode()) * 31) + this.to.hashCode()) * 31) + this.departurePlatform.hashCode()) * 31) + this.arrivalPlatform.hashCode()) * 31) + this.hall.hashCode()) * 31) + this.seat.hashCode()) * 31) + this.venue.hashCode()) * 31) + this.area.hashCode()) * 31) + this.entry.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.takeoffTime.hashCode()) * 31) + this.landingTime.hashCode()) * 31) + this.brand.hashCode();
    }

    public String toString() {
        return "LiveUpdatePayload(ticketId=" + this.ticketId + ", ticketType=" + this.ticketType + ", title=" + this.title + ", code=" + this.code + ", date=" + this.date + ", time=" + this.time + ", departureDate=" + this.departureDate + ", arrivalDate=" + this.arrivalDate + ", from=" + this.from + ", to=" + this.to + ", departurePlatform=" + this.departurePlatform + ", arrivalPlatform=" + this.arrivalPlatform + ", hall=" + this.hall + ", seat=" + this.seat + ", venue=" + this.venue + ", area=" + this.area + ", entry=" + this.entry + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", takeoffTime=" + this.takeoffTime + ", landingTime=" + this.landingTime + ", brand=" + this.brand + ")";
    }

    public LiveUpdatePayload(int i, String ticketType, String title, String code, String date, String time, String departureDate, String arrivalDate, String from, String to, String departurePlatform, String arrivalPlatform, String hall, String seat, String venue, String area, String entry, String startTime, String endTime, String takeoffTime, String landingTime, String brand) {
        Intrinsics.checkNotNullParameter(ticketType, "ticketType");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(departureDate, "departureDate");
        Intrinsics.checkNotNullParameter(arrivalDate, "arrivalDate");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(departurePlatform, "departurePlatform");
        Intrinsics.checkNotNullParameter(arrivalPlatform, "arrivalPlatform");
        Intrinsics.checkNotNullParameter(hall, "hall");
        Intrinsics.checkNotNullParameter(seat, "seat");
        Intrinsics.checkNotNullParameter(venue, "venue");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(takeoffTime, "takeoffTime");
        Intrinsics.checkNotNullParameter(landingTime, "landingTime");
        Intrinsics.checkNotNullParameter(brand, "brand");
        this.ticketId = i;
        this.ticketType = ticketType;
        this.title = title;
        this.code = code;
        this.date = date;
        this.time = time;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.from = from;
        this.to = to;
        this.departurePlatform = departurePlatform;
        this.arrivalPlatform = arrivalPlatform;
        this.hall = hall;
        this.seat = seat;
        this.venue = venue;
        this.area = area;
        this.entry = entry;
        this.startTime = startTime;
        this.endTime = endTime;
        this.takeoffTime = takeoffTime;
        this.landingTime = landingTime;
        this.brand = brand;
    }

    public /* synthetic */ LiveUpdatePayload(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, str3, str4, str5, (i2 & 64) != 0 ? "" : str6, (i2 & 128) != 0 ? "" : str7, str8, str9, (i2 & 1024) != 0 ? "" : str10, (i2 & 2048) != 0 ? "" : str11, str12, str13, str14, (32768 & i2) != 0 ? "" : str15, (65536 & i2) != 0 ? "" : str16, str17, str18, str19, str20, (i2 & 2097152) != 0 ? "" : str21);
    }

    public final int getTicketId() {
        return this.ticketId;
    }

    public final String getTicketType() {
        return this.ticketType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getDepartureDate() {
        return this.departureDate;
    }

    public final String getArrivalDate() {
        return this.arrivalDate;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getTo() {
        return this.to;
    }

    public final String getDeparturePlatform() {
        return this.departurePlatform;
    }

    public final String getArrivalPlatform() {
        return this.arrivalPlatform;
    }

    public final String getHall() {
        return this.hall;
    }

    public final String getSeat() {
        return this.seat;
    }

    public final String getVenue() {
        return this.venue;
    }

    public final String getArea() {
        return this.area;
    }

    public final String getEntry() {
        return this.entry;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getTakeoffTime() {
        return this.takeoffTime;
    }

    public final String getLandingTime() {
        return this.landingTime;
    }

    public final String getBrand() {
        return this.brand;
    }
}
