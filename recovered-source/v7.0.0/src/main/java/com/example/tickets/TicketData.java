package com.example.tickets;

import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\bK\b\u0081\b\u0018\u00002\u00020\u0001B©\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001f\u001a\u00020 \u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010\"\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b$\u0010%J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0007HÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\t\u0010L\u001a\u00020\u0007HÆ\u0003J\t\u0010M\u001a\u00020\u0007HÆ\u0003J\t\u0010N\u001a\u00020\u0007HÆ\u0003J\t\u0010O\u001a\u00020\u0007HÆ\u0003J\t\u0010P\u001a\u00020\u0007HÆ\u0003J\t\u0010Q\u001a\u00020\u0007HÆ\u0003J\t\u0010R\u001a\u00020\u0007HÆ\u0003J\t\u0010S\u001a\u00020\u0007HÆ\u0003J\t\u0010T\u001a\u00020\u0007HÆ\u0003J\t\u0010U\u001a\u00020\u0007HÆ\u0003J\t\u0010V\u001a\u00020\u0007HÆ\u0003J\t\u0010W\u001a\u00020\u0007HÆ\u0003J\t\u0010X\u001a\u00020\u0007HÆ\u0003J\t\u0010Y\u001a\u00020\u0007HÆ\u0003J\t\u0010Z\u001a\u00020\u0007HÆ\u0003J\t\u0010[\u001a\u00020\u0007HÆ\u0003J\t\u0010\\\u001a\u00020\u0007HÆ\u0003J\t\u0010]\u001a\u00020\u0007HÆ\u0003J\t\u0010^\u001a\u00020\u0007HÆ\u0003J\t\u0010_\u001a\u00020\u0007HÆ\u0003J\t\u0010`\u001a\u00020\u0007HÆ\u0003J\t\u0010a\u001a\u00020\u0007HÆ\u0003J\t\u0010b\u001a\u00020 HÆ\u0003J\t\u0010c\u001a\u00020 HÆ\u0003J\t\u0010d\u001a\u00020 HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J·\u0002\u0010f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020 2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010g\u001a\u00020 2\b\u0010h\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010i\u001a\u00020\u0003HÖ\u0001J\t\u0010j\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010+R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010+R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u0010+R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u0010+R\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u0010+R\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b4\u0010+R\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b5\u0010+R\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b6\u0010+R\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b7\u0010+R\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b8\u0010+R\u0011\u0010\u0015\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b9\u0010+R\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u0010+R\u0011\u0010\u0017\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b;\u0010+R\u0011\u0010\u0018\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u0011\u0010\u0019\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R\u0011\u0010\u001a\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b>\u0010+R\u0011\u0010\u001b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b?\u0010+R\u0011\u0010\u001c\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b@\u0010+R\u0011\u0010\u001d\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u0010+R\u0011\u0010\u001e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bB\u0010+R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0011\u0010!\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\bE\u0010DR\u0011\u0010\"\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\bF\u0010DR\u0013\u0010#\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bG\u0010+¨\u0006k"}, d2 = {"Lcom/example/tickets/TicketData;", "", "id", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Lcom/example/tickets/TicketType;", "title", "", "code", "barcodeValue", "barcodeFormat", "date", "time", "departureDate", "arrivalDate", Constants.MessagePayloadKeys.FROM, "to", "departurePlatform", "arrivalPlatform", "departureGate", "arrivalGate", "hall", "seat", "area", "entry", "venue", "startTime", "endTime", "takeoffTime", "landingTime", "brand", "manuallyUsed", "", "favorite", "archived", "imageUri", "<init>", "(ILcom/example/tickets/TicketType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;)V", "getId", "()I", "getType", "()Lcom/example/tickets/TicketType;", "getTitle", "()Ljava/lang/String;", "getCode", "getBarcodeValue", "getBarcodeFormat", "getDate", "getTime", "getDepartureDate", "getArrivalDate", "getFrom", "getTo", "getDeparturePlatform", "getArrivalPlatform", "getDepartureGate", "getArrivalGate", "getHall", "getSeat", "getArea", "getEntry", "getVenue", "getStartTime", "getEndTime", "getTakeoffTime", "getLandingTime", "getBrand", "getManuallyUsed", "()Z", "getFavorite", "getArchived", "getImageUri", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "copy", "equals", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TicketData {
    public static final int $stable = 0;
    private final boolean archived;
    private final String area;
    private final String arrivalDate;
    private final String arrivalGate;
    private final String arrivalPlatform;
    private final String barcodeFormat;
    private final String barcodeValue;
    private final String brand;
    private final String code;
    private final String date;
    private final String departureDate;
    private final String departureGate;
    private final String departurePlatform;
    private final String endTime;
    private final String entry;
    private final boolean favorite;
    private final String from;
    private final String hall;
    private final int id;
    private final String imageUri;
    private final String landingTime;
    private final boolean manuallyUsed;
    private final String seat;
    private final String startTime;
    private final String takeoffTime;
    private final String time;
    private final String title;
    private final String to;
    private final TicketType type;
    private final String venue;

    public static /* synthetic */ TicketData copy$default(TicketData ticketData, int i, TicketType ticketType, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, boolean z, boolean z2, boolean z3, String str25, int i2, Object obj) {
        String str26;
        boolean z4;
        int i3 = (i2 & 1) != 0 ? ticketData.id : i;
        TicketType ticketType2 = (i2 & 2) != 0 ? ticketData.type : ticketType;
        String str27 = (i2 & 4) != 0 ? ticketData.title : str;
        String str28 = (i2 & 8) != 0 ? ticketData.code : str2;
        String str29 = (i2 & 16) != 0 ? ticketData.barcodeValue : str3;
        String str30 = (i2 & 32) != 0 ? ticketData.barcodeFormat : str4;
        String str31 = (i2 & 64) != 0 ? ticketData.date : str5;
        String str32 = (i2 & 128) != 0 ? ticketData.time : str6;
        String str33 = (i2 & 256) != 0 ? ticketData.departureDate : str7;
        String str34 = (i2 & 512) != 0 ? ticketData.arrivalDate : str8;
        String str35 = (i2 & 1024) != 0 ? ticketData.from : str9;
        String str36 = (i2 & 2048) != 0 ? ticketData.to : str10;
        String str37 = (i2 & 4096) != 0 ? ticketData.departurePlatform : str11;
        String str38 = (i2 & 8192) != 0 ? ticketData.arrivalPlatform : str12;
        int i4 = i3;
        String str39 = (i2 & 16384) != 0 ? ticketData.departureGate : str13;
        String str40 = (i2 & 32768) != 0 ? ticketData.arrivalGate : str14;
        String str41 = (i2 & 65536) != 0 ? ticketData.hall : str15;
        String str42 = (i2 & 131072) != 0 ? ticketData.seat : str16;
        String str43 = (i2 & 262144) != 0 ? ticketData.area : str17;
        String str44 = (i2 & 524288) != 0 ? ticketData.entry : str18;
        String str45 = (i2 & 1048576) != 0 ? ticketData.venue : str19;
        String str46 = (i2 & 2097152) != 0 ? ticketData.startTime : str20;
        String str47 = (i2 & 4194304) != 0 ? ticketData.endTime : str21;
        String str48 = (i2 & 8388608) != 0 ? ticketData.takeoffTime : str22;
        String str49 = (i2 & 16777216) != 0 ? ticketData.landingTime : str23;
        String str50 = (i2 & GroupFlagsKt.HasAuxSlotFlag) != 0 ? ticketData.brand : str24;
        boolean z5 = (i2 & 67108864) != 0 ? ticketData.manuallyUsed : z;
        boolean z6 = (i2 & GroupFlagsKt.HasRecompositionRequiredFlag) != 0 ? ticketData.favorite : z2;
        boolean z7 = (i2 & GroupFlagsKt.IsMovableContentFlag) != 0 ? ticketData.archived : z3;
        if ((i2 & GroupFlagsKt.HasMovableContentFlag) != 0) {
            z4 = z7;
            str26 = ticketData.imageUri;
        } else {
            str26 = str25;
            z4 = z7;
        }
        return ticketData.copy(i4, ticketType2, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, str43, str44, str45, str46, str47, str48, str49, str50, z5, z6, z4, str26);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getArrivalDate() {
        return this.arrivalDate;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getFrom() {
        return this.from;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getTo() {
        return this.to;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getDeparturePlatform() {
        return this.departurePlatform;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getArrivalPlatform() {
        return this.arrivalPlatform;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getDepartureGate() {
        return this.departureGate;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getArrivalGate() {
        return this.arrivalGate;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getHall() {
        return this.hall;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getSeat() {
        return this.seat;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getArea() {
        return this.area;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TicketType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getEntry() {
        return this.entry;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getVenue() {
        return this.venue;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getTakeoffTime() {
        return this.takeoffTime;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getLandingTime() {
        return this.landingTime;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final String getBrand() {
        return this.brand;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final boolean getManuallyUsed() {
        return this.manuallyUsed;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final boolean getFavorite() {
        return this.favorite;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final boolean getArchived() {
        return this.archived;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final String getImageUri() {
        return this.imageUri;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBarcodeValue() {
        return this.barcodeValue;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getBarcodeFormat() {
        return this.barcodeFormat;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDepartureDate() {
        return this.departureDate;
    }

    public final TicketData copy(int id, TicketType type, String title, String code, String barcodeValue, String barcodeFormat, String date, String time, String departureDate, String arrivalDate, String from, String to, String departurePlatform, String arrivalPlatform, String departureGate, String arrivalGate, String hall, String seat, String area, String entry, String venue, String startTime, String endTime, String takeoffTime, String landingTime, String brand, boolean manuallyUsed, boolean favorite, boolean archived, String imageUri) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(barcodeValue, "barcodeValue");
        Intrinsics.checkNotNullParameter(barcodeFormat, "barcodeFormat");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(departureDate, "departureDate");
        Intrinsics.checkNotNullParameter(arrivalDate, "arrivalDate");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(departurePlatform, "departurePlatform");
        Intrinsics.checkNotNullParameter(arrivalPlatform, "arrivalPlatform");
        Intrinsics.checkNotNullParameter(departureGate, "departureGate");
        Intrinsics.checkNotNullParameter(arrivalGate, "arrivalGate");
        Intrinsics.checkNotNullParameter(hall, "hall");
        Intrinsics.checkNotNullParameter(seat, "seat");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(venue, "venue");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(takeoffTime, "takeoffTime");
        Intrinsics.checkNotNullParameter(landingTime, "landingTime");
        Intrinsics.checkNotNullParameter(brand, "brand");
        return new TicketData(id, type, title, code, barcodeValue, barcodeFormat, date, time, departureDate, arrivalDate, from, to, departurePlatform, arrivalPlatform, departureGate, arrivalGate, hall, seat, area, entry, venue, startTime, endTime, takeoffTime, landingTime, brand, manuallyUsed, favorite, archived, imageUri);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TicketData)) {
            return false;
        }
        TicketData ticketData = (TicketData) other;
        return this.id == ticketData.id && this.type == ticketData.type && Intrinsics.areEqual(this.title, ticketData.title) && Intrinsics.areEqual(this.code, ticketData.code) && Intrinsics.areEqual(this.barcodeValue, ticketData.barcodeValue) && Intrinsics.areEqual(this.barcodeFormat, ticketData.barcodeFormat) && Intrinsics.areEqual(this.date, ticketData.date) && Intrinsics.areEqual(this.time, ticketData.time) && Intrinsics.areEqual(this.departureDate, ticketData.departureDate) && Intrinsics.areEqual(this.arrivalDate, ticketData.arrivalDate) && Intrinsics.areEqual(this.from, ticketData.from) && Intrinsics.areEqual(this.to, ticketData.to) && Intrinsics.areEqual(this.departurePlatform, ticketData.departurePlatform) && Intrinsics.areEqual(this.arrivalPlatform, ticketData.arrivalPlatform) && Intrinsics.areEqual(this.departureGate, ticketData.departureGate) && Intrinsics.areEqual(this.arrivalGate, ticketData.arrivalGate) && Intrinsics.areEqual(this.hall, ticketData.hall) && Intrinsics.areEqual(this.seat, ticketData.seat) && Intrinsics.areEqual(this.area, ticketData.area) && Intrinsics.areEqual(this.entry, ticketData.entry) && Intrinsics.areEqual(this.venue, ticketData.venue) && Intrinsics.areEqual(this.startTime, ticketData.startTime) && Intrinsics.areEqual(this.endTime, ticketData.endTime) && Intrinsics.areEqual(this.takeoffTime, ticketData.takeoffTime) && Intrinsics.areEqual(this.landingTime, ticketData.landingTime) && Intrinsics.areEqual(this.brand, ticketData.brand) && this.manuallyUsed == ticketData.manuallyUsed && this.favorite == ticketData.favorite && this.archived == ticketData.archived && Intrinsics.areEqual(this.imageUri, ticketData.imageUri);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((Integer.hashCode(this.id) * 31) + this.type.hashCode()) * 31) + this.title.hashCode()) * 31) + this.code.hashCode()) * 31) + this.barcodeValue.hashCode()) * 31) + this.barcodeFormat.hashCode()) * 31) + this.date.hashCode()) * 31) + this.time.hashCode()) * 31) + this.departureDate.hashCode()) * 31) + this.arrivalDate.hashCode()) * 31) + this.from.hashCode()) * 31) + this.to.hashCode()) * 31) + this.departurePlatform.hashCode()) * 31) + this.arrivalPlatform.hashCode()) * 31) + this.departureGate.hashCode()) * 31) + this.arrivalGate.hashCode()) * 31) + this.hall.hashCode()) * 31) + this.seat.hashCode()) * 31) + this.area.hashCode()) * 31) + this.entry.hashCode()) * 31) + this.venue.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.takeoffTime.hashCode()) * 31) + this.landingTime.hashCode()) * 31) + this.brand.hashCode()) * 31) + Boolean.hashCode(this.manuallyUsed)) * 31) + Boolean.hashCode(this.favorite)) * 31) + Boolean.hashCode(this.archived)) * 31;
        String str = this.imageUri;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "TicketData(id=" + this.id + ", type=" + this.type + ", title=" + this.title + ", code=" + this.code + ", barcodeValue=" + this.barcodeValue + ", barcodeFormat=" + this.barcodeFormat + ", date=" + this.date + ", time=" + this.time + ", departureDate=" + this.departureDate + ", arrivalDate=" + this.arrivalDate + ", from=" + this.from + ", to=" + this.to + ", departurePlatform=" + this.departurePlatform + ", arrivalPlatform=" + this.arrivalPlatform + ", departureGate=" + this.departureGate + ", arrivalGate=" + this.arrivalGate + ", hall=" + this.hall + ", seat=" + this.seat + ", area=" + this.area + ", entry=" + this.entry + ", venue=" + this.venue + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", takeoffTime=" + this.takeoffTime + ", landingTime=" + this.landingTime + ", brand=" + this.brand + ", manuallyUsed=" + this.manuallyUsed + ", favorite=" + this.favorite + ", archived=" + this.archived + ", imageUri=" + this.imageUri + ")";
    }

    public TicketData(int i, TicketType type, String title, String code, String barcodeValue, String barcodeFormat, String date, String time, String departureDate, String arrivalDate, String from, String to, String departurePlatform, String arrivalPlatform, String departureGate, String arrivalGate, String hall, String seat, String area, String entry, String venue, String startTime, String endTime, String takeoffTime, String landingTime, String brand, boolean z, boolean z2, boolean z3, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(barcodeValue, "barcodeValue");
        Intrinsics.checkNotNullParameter(barcodeFormat, "barcodeFormat");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(departureDate, "departureDate");
        Intrinsics.checkNotNullParameter(arrivalDate, "arrivalDate");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(departurePlatform, "departurePlatform");
        Intrinsics.checkNotNullParameter(arrivalPlatform, "arrivalPlatform");
        Intrinsics.checkNotNullParameter(departureGate, "departureGate");
        Intrinsics.checkNotNullParameter(arrivalGate, "arrivalGate");
        Intrinsics.checkNotNullParameter(hall, "hall");
        Intrinsics.checkNotNullParameter(seat, "seat");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(venue, "venue");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(takeoffTime, "takeoffTime");
        Intrinsics.checkNotNullParameter(landingTime, "landingTime");
        Intrinsics.checkNotNullParameter(brand, "brand");
        this.id = i;
        this.type = type;
        this.title = title;
        this.code = code;
        this.barcodeValue = barcodeValue;
        this.barcodeFormat = barcodeFormat;
        this.date = date;
        this.time = time;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.from = from;
        this.to = to;
        this.departurePlatform = departurePlatform;
        this.arrivalPlatform = arrivalPlatform;
        this.departureGate = departureGate;
        this.arrivalGate = arrivalGate;
        this.hall = hall;
        this.seat = seat;
        this.area = area;
        this.entry = entry;
        this.venue = venue;
        this.startTime = startTime;
        this.endTime = endTime;
        this.takeoffTime = takeoffTime;
        this.landingTime = landingTime;
        this.brand = brand;
        this.manuallyUsed = z;
        this.favorite = z2;
        this.archived = z3;
        this.imageUri = str;
    }

    public /* synthetic */ TicketData(int i, TicketType ticketType, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, boolean z, boolean z2, boolean z3, String str25, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, ticketType, str, str2, (i2 & 16) != 0 ? "" : str3, (i2 & 32) != 0 ? "二维码" : str4, str5, str6, (i2 & 256) != 0 ? "" : str7, (i2 & 512) != 0 ? "" : str8, (i2 & 1024) != 0 ? "" : str9, (i2 & 2048) != 0 ? "" : str10, (i2 & 4096) != 0 ? "" : str11, (i2 & 8192) != 0 ? "" : str12, (i2 & 16384) != 0 ? "" : str13, (32768 & i2) != 0 ? "" : str14, (65536 & i2) != 0 ? "" : str15, (131072 & i2) != 0 ? "" : str16, (262144 & i2) != 0 ? "" : str17, (524288 & i2) != 0 ? "" : str18, (1048576 & i2) != 0 ? "" : str19, (2097152 & i2) != 0 ? "" : str20, (4194304 & i2) != 0 ? "" : str21, (8388608 & i2) != 0 ? "" : str22, (16777216 & i2) != 0 ? "" : str23, (33554432 & i2) != 0 ? "" : str24, (67108864 & i2) != 0 ? false : z, (134217728 & i2) != 0 ? false : z2, (268435456 & i2) != 0 ? false : z3, (i2 & GroupFlagsKt.HasMovableContentFlag) != 0 ? null : str25);
    }

    public final int getId() {
        return this.id;
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

    public final String getBarcodeValue() {
        return this.barcodeValue;
    }

    public final String getBarcodeFormat() {
        return this.barcodeFormat;
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

    public final String getDepartureGate() {
        return this.departureGate;
    }

    public final String getArrivalGate() {
        return this.arrivalGate;
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

    public final String getBrand() {
        return this.brand;
    }

    public final boolean getManuallyUsed() {
        return this.manuallyUsed;
    }

    public final boolean getFavorite() {
        return this.favorite;
    }

    public final boolean getArchived() {
        return this.archived;
    }

    public final String getImageUri() {
        return this.imageUri;
    }
}
