package com.example.tickets;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OnlineRecognitionClient.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\bL\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001Bõ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003Jù\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010T\u001a\u00020UHÖ\u0001J\t\u0010V\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010!R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010!R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010!R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010!R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010!R\u0011\u0010\u001b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010!¨\u0006W"}, d2 = {"Lcom/example/tickets/OnlineRecognitionResult;", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Lcom/example/tickets/TicketType;", "title", "", "code", "date", "departureDate", "arrivalDate", "time", Constants.MessagePayloadKeys.FROM, "to", "departurePlatform", "arrivalPlatform", "departureGate", "arrivalGate", "venue", "hall", "seat", "area", "entry", "startTime", "endTime", "takeoffTime", "landingTime", "brand", "rawResponse", "<init>", "(Lcom/example/tickets/TicketType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Lcom/example/tickets/TicketType;", "getTitle", "()Ljava/lang/String;", "getCode", "getDate", "getDepartureDate", "getArrivalDate", "getTime", "getFrom", "getTo", "getDeparturePlatform", "getArrivalPlatform", "getDepartureGate", "getArrivalGate", "getVenue", "getHall", "getSeat", "getArea", "getEntry", "getStartTime", "getEndTime", "getTakeoffTime", "getLandingTime", "getBrand", "getRawResponse", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class OnlineRecognitionResult {
    public static final int $stable = 0;
    private final String area;
    private final String arrivalDate;
    private final String arrivalGate;
    private final String arrivalPlatform;
    private final String brand;
    private final String code;
    private final String date;
    private final String departureDate;
    private final String departureGate;
    private final String departurePlatform;
    private final String endTime;
    private final String entry;
    private final String from;
    private final String hall;
    private final String landingTime;
    private final String rawResponse;
    private final String seat;
    private final String startTime;
    private final String takeoffTime;
    private final String time;
    private final String title;
    private final String to;
    private final TicketType type;
    private final String venue;

    public static /* synthetic */ OnlineRecognitionResult copy$default(OnlineRecognitionResult onlineRecognitionResult, TicketType ticketType, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, int i, Object obj) {
        String str24;
        String str25;
        TicketType ticketType2 = (i & 1) != 0 ? onlineRecognitionResult.type : ticketType;
        String str26 = (i & 2) != 0 ? onlineRecognitionResult.title : str;
        String str27 = (i & 4) != 0 ? onlineRecognitionResult.code : str2;
        String str28 = (i & 8) != 0 ? onlineRecognitionResult.date : str3;
        String str29 = (i & 16) != 0 ? onlineRecognitionResult.departureDate : str4;
        String str30 = (i & 32) != 0 ? onlineRecognitionResult.arrivalDate : str5;
        String str31 = (i & 64) != 0 ? onlineRecognitionResult.time : str6;
        String str32 = (i & 128) != 0 ? onlineRecognitionResult.from : str7;
        String str33 = (i & 256) != 0 ? onlineRecognitionResult.to : str8;
        String str34 = (i & 512) != 0 ? onlineRecognitionResult.departurePlatform : str9;
        String str35 = (i & 1024) != 0 ? onlineRecognitionResult.arrivalPlatform : str10;
        String str36 = (i & 2048) != 0 ? onlineRecognitionResult.departureGate : str11;
        String str37 = (i & 4096) != 0 ? onlineRecognitionResult.arrivalGate : str12;
        String str38 = (i & 8192) != 0 ? onlineRecognitionResult.venue : str13;
        TicketType ticketType3 = ticketType2;
        String str39 = (i & 16384) != 0 ? onlineRecognitionResult.hall : str14;
        String str40 = (i & 32768) != 0 ? onlineRecognitionResult.seat : str15;
        String str41 = (i & 65536) != 0 ? onlineRecognitionResult.area : str16;
        String str42 = (i & 131072) != 0 ? onlineRecognitionResult.entry : str17;
        String str43 = (i & 262144) != 0 ? onlineRecognitionResult.startTime : str18;
        String str44 = (i & 524288) != 0 ? onlineRecognitionResult.endTime : str19;
        String str45 = (i & 1048576) != 0 ? onlineRecognitionResult.takeoffTime : str20;
        String str46 = (i & 2097152) != 0 ? onlineRecognitionResult.landingTime : str21;
        String str47 = (i & 4194304) != 0 ? onlineRecognitionResult.brand : str22;
        if ((i & 8388608) != 0) {
            str25 = str47;
            str24 = onlineRecognitionResult.rawResponse;
        } else {
            str24 = str23;
            str25 = str47;
        }
        return onlineRecognitionResult.copy(ticketType3, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, str43, str44, str45, str46, str25, str24);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TicketType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getDeparturePlatform() {
        return this.departurePlatform;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getArrivalPlatform() {
        return this.arrivalPlatform;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getDepartureGate() {
        return this.departureGate;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getArrivalGate() {
        return this.arrivalGate;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getVenue() {
        return this.venue;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getHall() {
        return this.hall;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getSeat() {
        return this.seat;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getArea() {
        return this.area;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getEntry() {
        return this.entry;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getTakeoffTime() {
        return this.takeoffTime;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getLandingTime() {
        return this.landingTime;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getBrand() {
        return this.brand;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getRawResponse() {
        return this.rawResponse;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDepartureDate() {
        return this.departureDate;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getArrivalDate() {
        return this.arrivalDate;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getFrom() {
        return this.from;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTo() {
        return this.to;
    }

    public final OnlineRecognitionResult copy(TicketType type, String title, String code, String date, String departureDate, String arrivalDate, String time, String from, String to, String departurePlatform, String arrivalPlatform, String departureGate, String arrivalGate, String venue, String hall, String seat, String area, String entry, String startTime, String endTime, String takeoffTime, String landingTime, String brand, String rawResponse) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(departureDate, "departureDate");
        Intrinsics.checkNotNullParameter(arrivalDate, "arrivalDate");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(departurePlatform, "departurePlatform");
        Intrinsics.checkNotNullParameter(arrivalPlatform, "arrivalPlatform");
        Intrinsics.checkNotNullParameter(departureGate, "departureGate");
        Intrinsics.checkNotNullParameter(arrivalGate, "arrivalGate");
        Intrinsics.checkNotNullParameter(venue, "venue");
        Intrinsics.checkNotNullParameter(hall, "hall");
        Intrinsics.checkNotNullParameter(seat, "seat");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(takeoffTime, "takeoffTime");
        Intrinsics.checkNotNullParameter(landingTime, "landingTime");
        Intrinsics.checkNotNullParameter(brand, "brand");
        Intrinsics.checkNotNullParameter(rawResponse, "rawResponse");
        return new OnlineRecognitionResult(type, title, code, date, departureDate, arrivalDate, time, from, to, departurePlatform, arrivalPlatform, departureGate, arrivalGate, venue, hall, seat, area, entry, startTime, endTime, takeoffTime, landingTime, brand, rawResponse);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnlineRecognitionResult)) {
            return false;
        }
        OnlineRecognitionResult onlineRecognitionResult = (OnlineRecognitionResult) other;
        return this.type == onlineRecognitionResult.type && Intrinsics.areEqual(this.title, onlineRecognitionResult.title) && Intrinsics.areEqual(this.code, onlineRecognitionResult.code) && Intrinsics.areEqual(this.date, onlineRecognitionResult.date) && Intrinsics.areEqual(this.departureDate, onlineRecognitionResult.departureDate) && Intrinsics.areEqual(this.arrivalDate, onlineRecognitionResult.arrivalDate) && Intrinsics.areEqual(this.time, onlineRecognitionResult.time) && Intrinsics.areEqual(this.from, onlineRecognitionResult.from) && Intrinsics.areEqual(this.to, onlineRecognitionResult.to) && Intrinsics.areEqual(this.departurePlatform, onlineRecognitionResult.departurePlatform) && Intrinsics.areEqual(this.arrivalPlatform, onlineRecognitionResult.arrivalPlatform) && Intrinsics.areEqual(this.departureGate, onlineRecognitionResult.departureGate) && Intrinsics.areEqual(this.arrivalGate, onlineRecognitionResult.arrivalGate) && Intrinsics.areEqual(this.venue, onlineRecognitionResult.venue) && Intrinsics.areEqual(this.hall, onlineRecognitionResult.hall) && Intrinsics.areEqual(this.seat, onlineRecognitionResult.seat) && Intrinsics.areEqual(this.area, onlineRecognitionResult.area) && Intrinsics.areEqual(this.entry, onlineRecognitionResult.entry) && Intrinsics.areEqual(this.startTime, onlineRecognitionResult.startTime) && Intrinsics.areEqual(this.endTime, onlineRecognitionResult.endTime) && Intrinsics.areEqual(this.takeoffTime, onlineRecognitionResult.takeoffTime) && Intrinsics.areEqual(this.landingTime, onlineRecognitionResult.landingTime) && Intrinsics.areEqual(this.brand, onlineRecognitionResult.brand) && Intrinsics.areEqual(this.rawResponse, onlineRecognitionResult.rawResponse);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((this.type.hashCode() * 31) + this.title.hashCode()) * 31) + this.code.hashCode()) * 31) + this.date.hashCode()) * 31) + this.departureDate.hashCode()) * 31) + this.arrivalDate.hashCode()) * 31) + this.time.hashCode()) * 31) + this.from.hashCode()) * 31) + this.to.hashCode()) * 31) + this.departurePlatform.hashCode()) * 31) + this.arrivalPlatform.hashCode()) * 31) + this.departureGate.hashCode()) * 31) + this.arrivalGate.hashCode()) * 31) + this.venue.hashCode()) * 31) + this.hall.hashCode()) * 31) + this.seat.hashCode()) * 31) + this.area.hashCode()) * 31) + this.entry.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.takeoffTime.hashCode()) * 31) + this.landingTime.hashCode()) * 31) + this.brand.hashCode()) * 31) + this.rawResponse.hashCode();
    }

    public String toString() {
        return "OnlineRecognitionResult(type=" + this.type + ", title=" + this.title + ", code=" + this.code + ", date=" + this.date + ", departureDate=" + this.departureDate + ", arrivalDate=" + this.arrivalDate + ", time=" + this.time + ", from=" + this.from + ", to=" + this.to + ", departurePlatform=" + this.departurePlatform + ", arrivalPlatform=" + this.arrivalPlatform + ", departureGate=" + this.departureGate + ", arrivalGate=" + this.arrivalGate + ", venue=" + this.venue + ", hall=" + this.hall + ", seat=" + this.seat + ", area=" + this.area + ", entry=" + this.entry + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", takeoffTime=" + this.takeoffTime + ", landingTime=" + this.landingTime + ", brand=" + this.brand + ", rawResponse=" + this.rawResponse + ")";
    }

    public OnlineRecognitionResult(TicketType type, String title, String code, String date, String departureDate, String arrivalDate, String time, String from, String to, String departurePlatform, String arrivalPlatform, String departureGate, String arrivalGate, String venue, String hall, String seat, String area, String entry, String startTime, String endTime, String takeoffTime, String landingTime, String brand, String rawResponse) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(departureDate, "departureDate");
        Intrinsics.checkNotNullParameter(arrivalDate, "arrivalDate");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(departurePlatform, "departurePlatform");
        Intrinsics.checkNotNullParameter(arrivalPlatform, "arrivalPlatform");
        Intrinsics.checkNotNullParameter(departureGate, "departureGate");
        Intrinsics.checkNotNullParameter(arrivalGate, "arrivalGate");
        Intrinsics.checkNotNullParameter(venue, "venue");
        Intrinsics.checkNotNullParameter(hall, "hall");
        Intrinsics.checkNotNullParameter(seat, "seat");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(takeoffTime, "takeoffTime");
        Intrinsics.checkNotNullParameter(landingTime, "landingTime");
        Intrinsics.checkNotNullParameter(brand, "brand");
        Intrinsics.checkNotNullParameter(rawResponse, "rawResponse");
        this.type = type;
        this.title = title;
        this.code = code;
        this.date = date;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.time = time;
        this.from = from;
        this.to = to;
        this.departurePlatform = departurePlatform;
        this.arrivalPlatform = arrivalPlatform;
        this.departureGate = departureGate;
        this.arrivalGate = arrivalGate;
        this.venue = venue;
        this.hall = hall;
        this.seat = seat;
        this.area = area;
        this.entry = entry;
        this.startTime = startTime;
        this.endTime = endTime;
        this.takeoffTime = takeoffTime;
        this.landingTime = landingTime;
        this.brand = brand;
        this.rawResponse = rawResponse;
    }

    public /* synthetic */ OnlineRecognitionResult(TicketType ticketType, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ticketType, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? "" : str7, (i & 256) != 0 ? "" : str8, (i & 512) != 0 ? "" : str9, (i & 1024) != 0 ? "" : str10, (i & 2048) != 0 ? "" : str11, (i & 4096) != 0 ? "" : str12, (i & 8192) != 0 ? "" : str13, (i & 16384) != 0 ? "" : str14, (i & 32768) != 0 ? "" : str15, (i & 65536) != 0 ? "" : str16, (i & 131072) != 0 ? "" : str17, (i & 262144) != 0 ? "" : str18, (i & 524288) != 0 ? "" : str19, (i & 1048576) != 0 ? "" : str20, (i & 2097152) != 0 ? "" : str21, (i & 4194304) != 0 ? "" : str22, (i & 8388608) != 0 ? "" : str23);
    }

    public final TicketType getType() {
        return this.type;
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

    public final String getDepartureDate() {
        return this.departureDate;
    }

    public final String getArrivalDate() {
        return this.arrivalDate;
    }

    public final String getTime() {
        return this.time;
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

    public final String getDepartureGate() {
        return this.departureGate;
    }

    public final String getArrivalGate() {
        return this.arrivalGate;
    }

    public final String getVenue() {
        return this.venue;
    }

    public final String getHall() {
        return this.hall;
    }

    public final String getSeat() {
        return this.seat;
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

    public final String getRawResponse() {
        return this.rawResponse;
    }
}
