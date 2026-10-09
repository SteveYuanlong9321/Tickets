package com.example.tickets;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TicketOcrParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b7\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÏ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003JÓ\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020@HÖ\u0001J\t\u0010A\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001a¨\u0006B"}, d2 = {"Lcom/example/tickets/OcrTicketDraft;", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Lcom/example/tickets/OcrTicketType;", "title", "", "code", "brand", "date", "time", Constants.MessagePayloadKeys.FROM, "to", "hall", "seat", "area", "entry", "venue", "startTime", "endTime", "takeoffTime", "landingTime", "<init>", "(Lcom/example/tickets/OcrTicketType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Lcom/example/tickets/OcrTicketType;", "getTitle", "()Ljava/lang/String;", "getCode", "getBrand", "getDate", "getTime", "getFrom", "getTo", "getHall", "getSeat", "getArea", "getEntry", "getVenue", "getStartTime", "getEndTime", "getTakeoffTime", "getLandingTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class OcrTicketDraft {
    public static final int $stable = 0;
    private final String area;
    private final String brand;
    private final String code;
    private final String date;
    private final String endTime;
    private final String entry;
    private final String from;
    private final String hall;
    private final String landingTime;
    private final String seat;
    private final String startTime;
    private final String takeoffTime;
    private final String time;
    private final String title;
    private final String to;
    private final OcrTicketType type;
    private final String venue;

    public static /* synthetic */ OcrTicketDraft copy$default(OcrTicketDraft ocrTicketDraft, OcrTicketType ocrTicketType, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i, Object obj) {
        String str17;
        String str18;
        OcrTicketType ocrTicketType2 = (i & 1) != 0 ? ocrTicketDraft.type : ocrTicketType;
        String str19 = (i & 2) != 0 ? ocrTicketDraft.title : str;
        String str20 = (i & 4) != 0 ? ocrTicketDraft.code : str2;
        String str21 = (i & 8) != 0 ? ocrTicketDraft.brand : str3;
        String str22 = (i & 16) != 0 ? ocrTicketDraft.date : str4;
        String str23 = (i & 32) != 0 ? ocrTicketDraft.time : str5;
        String str24 = (i & 64) != 0 ? ocrTicketDraft.from : str6;
        String str25 = (i & 128) != 0 ? ocrTicketDraft.to : str7;
        String str26 = (i & 256) != 0 ? ocrTicketDraft.hall : str8;
        String str27 = (i & 512) != 0 ? ocrTicketDraft.seat : str9;
        String str28 = (i & 1024) != 0 ? ocrTicketDraft.area : str10;
        String str29 = (i & 2048) != 0 ? ocrTicketDraft.entry : str11;
        String str30 = (i & 4096) != 0 ? ocrTicketDraft.venue : str12;
        String str31 = (i & 8192) != 0 ? ocrTicketDraft.startTime : str13;
        OcrTicketType ocrTicketType3 = ocrTicketType2;
        String str32 = (i & 16384) != 0 ? ocrTicketDraft.endTime : str14;
        String str33 = (i & 32768) != 0 ? ocrTicketDraft.takeoffTime : str15;
        if ((i & 65536) != 0) {
            str18 = str33;
            str17 = ocrTicketDraft.landingTime;
        } else {
            str17 = str16;
            str18 = str33;
        }
        return ocrTicketDraft.copy(ocrTicketType3, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str18, str17);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final OcrTicketType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSeat() {
        return this.seat;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getArea() {
        return this.area;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getEntry() {
        return this.entry;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getVenue() {
        return this.venue;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getTakeoffTime() {
        return this.takeoffTime;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getLandingTime() {
        return this.landingTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBrand() {
        return this.brand;
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
    public final String getFrom() {
        return this.from;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTo() {
        return this.to;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getHall() {
        return this.hall;
    }

    public final OcrTicketDraft copy(OcrTicketType type, String title, String code, String brand, String date, String time, String from, String to, String hall, String seat, String area, String entry, String venue, String startTime, String endTime, String takeoffTime, String landingTime) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new OcrTicketDraft(type, title, code, brand, date, time, from, to, hall, seat, area, entry, venue, startTime, endTime, takeoffTime, landingTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OcrTicketDraft)) {
            return false;
        }
        OcrTicketDraft ocrTicketDraft = (OcrTicketDraft) other;
        return this.type == ocrTicketDraft.type && Intrinsics.areEqual(this.title, ocrTicketDraft.title) && Intrinsics.areEqual(this.code, ocrTicketDraft.code) && Intrinsics.areEqual(this.brand, ocrTicketDraft.brand) && Intrinsics.areEqual(this.date, ocrTicketDraft.date) && Intrinsics.areEqual(this.time, ocrTicketDraft.time) && Intrinsics.areEqual(this.from, ocrTicketDraft.from) && Intrinsics.areEqual(this.to, ocrTicketDraft.to) && Intrinsics.areEqual(this.hall, ocrTicketDraft.hall) && Intrinsics.areEqual(this.seat, ocrTicketDraft.seat) && Intrinsics.areEqual(this.area, ocrTicketDraft.area) && Intrinsics.areEqual(this.entry, ocrTicketDraft.entry) && Intrinsics.areEqual(this.venue, ocrTicketDraft.venue) && Intrinsics.areEqual(this.startTime, ocrTicketDraft.startTime) && Intrinsics.areEqual(this.endTime, ocrTicketDraft.endTime) && Intrinsics.areEqual(this.takeoffTime, ocrTicketDraft.takeoffTime) && Intrinsics.areEqual(this.landingTime, ocrTicketDraft.landingTime);
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.code;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.brand;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.date;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.time;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.from;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.to;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.hall;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.seat;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.area;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.entry;
        int iHashCode12 = (iHashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.venue;
        int iHashCode13 = (iHashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.startTime;
        int iHashCode14 = (iHashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.endTime;
        int iHashCode15 = (iHashCode14 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.takeoffTime;
        int iHashCode16 = (iHashCode15 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.landingTime;
        return iHashCode16 + (str16 != null ? str16.hashCode() : 0);
    }

    public String toString() {
        return "OcrTicketDraft(type=" + this.type + ", title=" + this.title + ", code=" + this.code + ", brand=" + this.brand + ", date=" + this.date + ", time=" + this.time + ", from=" + this.from + ", to=" + this.to + ", hall=" + this.hall + ", seat=" + this.seat + ", area=" + this.area + ", entry=" + this.entry + ", venue=" + this.venue + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", takeoffTime=" + this.takeoffTime + ", landingTime=" + this.landingTime + ")";
    }

    public OcrTicketDraft(OcrTicketType type, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.title = str;
        this.code = str2;
        this.brand = str3;
        this.date = str4;
        this.time = str5;
        this.from = str6;
        this.to = str7;
        this.hall = str8;
        this.seat = str9;
        this.area = str10;
        this.entry = str11;
        this.venue = str12;
        this.startTime = str13;
        this.endTime = str14;
        this.takeoffTime = str15;
        this.landingTime = str16;
    }

    public /* synthetic */ OcrTicketDraft(OcrTicketType ocrTicketType, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ocrTicketType, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : str11, (i & 4096) != 0 ? null : str12, (i & 8192) != 0 ? null : str13, (i & 16384) != 0 ? null : str14, (i & 32768) != 0 ? null : str15, (i & 65536) != 0 ? null : str16);
    }

    public final OcrTicketType getType() {
        return this.type;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final String getDate() {
        return this.date;
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

    public final String getVenue() {
        return this.venue;
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
}
