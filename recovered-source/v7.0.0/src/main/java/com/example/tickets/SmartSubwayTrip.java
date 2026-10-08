package com.example.tickets;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b0\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B³\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\rHÆ\u0003J\t\u00109\u001a\u00020\rHÆ\u0003J\u0010\u0010:\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b;\u0010\u001fJ\u0010\u0010<\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b=\u0010\u001fJ\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0015HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018HÆ\u0003JÀ\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018HÆ\u0001¢\u0006\u0004\bD\u0010EJ\u0013\u0010F\u001a\u00020\r2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020IHÖ\u0001J\t\u0010J\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010%R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010%R\u0013\u0010\u000f\u001a\u00020\u0010¢\u0006\n\n\u0002\u0010'\u001a\u0004\b&\u0010\u001fR\u0013\u0010\u0011\u001a\u00020\u0010¢\u0006\n\n\u0002\u0010'\u001a\u0004\b(\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006K"}, d2 = {"Lcom/example/tickets/SmartSubwayTrip;", "", "cityId", "", "cityName", "tripSessionId", "", "origin", "destination", "currentStation", "nextStation", "lineName", "isTransferRequired", "", "isDestination", "primaryLineColor", "Landroidx/compose/ui/graphics/Color;", "secondaryLineColor", "transferStation", "previousStation", "segmentProgress", "", "transferLineName", "transferOptions", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJJLjava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCityId", "()Ljava/lang/String;", "getCityName", "getTripSessionId", "()J", "getOrigin", "getDestination", "getCurrentStation", "getNextStation", "getLineName", "()Z", "getPrimaryLineColor-0d7_KjU", "J", "getSecondaryLineColor-0d7_KjU", "getTransferStation", "getPreviousStation", "getSegmentProgress", "()F", "getTransferLineName", "getTransferOptions", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component11-0d7_KjU", "component12", "component12-0d7_KjU", "component13", "component14", "component15", "component16", "component17", "copy", "copy-dOtcBKo", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJJLjava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/util/List;)Lcom/example/tickets/SmartSubwayTrip;", "equals", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SmartSubwayTrip {
    public static final int $stable = 8;
    private final String cityId;
    private final String cityName;
    private final String currentStation;
    private final String destination;
    private final boolean isDestination;
    private final boolean isTransferRequired;
    private final String lineName;
    private final String nextStation;
    private final String origin;
    private final String previousStation;
    private final long primaryLineColor;
    private final long secondaryLineColor;
    private final float segmentProgress;
    private final String transferLineName;
    private final List<String> transferOptions;
    private final String transferStation;
    private final long tripSessionId;

    public /* synthetic */ SmartSubwayTrip(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, boolean z, boolean z2, long j2, long j3, String str8, String str9, float f, String str10, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, str3, str4, str5, str6, str7, z, z2, j2, j3, str8, str9, f, str10, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-dOtcBKo$default, reason: not valid java name */
    public static /* synthetic */ SmartSubwayTrip m9308copydOtcBKo$default(SmartSubwayTrip smartSubwayTrip, String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, boolean z, boolean z2, long j2, long j3, String str8, String str9, float f, String str10, List list, int i, Object obj) {
        List list2;
        String str11;
        String str12 = (i & 1) != 0 ? smartSubwayTrip.cityId : str;
        String str13 = (i & 2) != 0 ? smartSubwayTrip.cityName : str2;
        long j4 = (i & 4) != 0 ? smartSubwayTrip.tripSessionId : j;
        String str14 = (i & 8) != 0 ? smartSubwayTrip.origin : str3;
        String str15 = (i & 16) != 0 ? smartSubwayTrip.destination : str4;
        String str16 = (i & 32) != 0 ? smartSubwayTrip.currentStation : str5;
        String str17 = (i & 64) != 0 ? smartSubwayTrip.nextStation : str6;
        String str18 = (i & 128) != 0 ? smartSubwayTrip.lineName : str7;
        boolean z3 = (i & 256) != 0 ? smartSubwayTrip.isTransferRequired : z;
        boolean z4 = (i & 512) != 0 ? smartSubwayTrip.isDestination : z2;
        long j5 = (i & 1024) != 0 ? smartSubwayTrip.primaryLineColor : j2;
        String str19 = str12;
        String str20 = str13;
        long j6 = (i & 2048) != 0 ? smartSubwayTrip.secondaryLineColor : j3;
        String str21 = (i & 4096) != 0 ? smartSubwayTrip.transferStation : str8;
        long j7 = j6;
        String str22 = (i & 8192) != 0 ? smartSubwayTrip.previousStation : str9;
        float f2 = (i & 16384) != 0 ? smartSubwayTrip.segmentProgress : f;
        String str23 = (i & 32768) != 0 ? smartSubwayTrip.transferLineName : str10;
        if ((i & 65536) != 0) {
            str11 = str23;
            list2 = smartSubwayTrip.transferOptions;
        } else {
            list2 = list;
            str11 = str23;
        }
        return smartSubwayTrip.m9311copydOtcBKo(str19, str20, j4, str14, str15, str16, str17, str18, z3, z4, j5, j7, str21, str22, f2, str11, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCityId() {
        return this.cityId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsDestination() {
        return this.isDestination;
    }

    /* JADX INFO: renamed from: component11-0d7_KjU, reason: not valid java name and from getter */
    public final long getPrimaryLineColor() {
        return this.primaryLineColor;
    }

    /* JADX INFO: renamed from: component12-0d7_KjU, reason: not valid java name and from getter */
    public final long getSecondaryLineColor() {
        return this.secondaryLineColor;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getTransferStation() {
        return this.transferStation;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getPreviousStation() {
        return this.previousStation;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final float getSegmentProgress() {
        return this.segmentProgress;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getTransferLineName() {
        return this.transferLineName;
    }

    public final List<String> component17() {
        return this.transferOptions;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCityName() {
        return this.cityName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getTripSessionId() {
        return this.tripSessionId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOrigin() {
        return this.origin;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDestination() {
        return this.destination;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCurrentStation() {
        return this.currentStation;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getNextStation() {
        return this.nextStation;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getLineName() {
        return this.lineName;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsTransferRequired() {
        return this.isTransferRequired;
    }

    /* JADX INFO: renamed from: copy-dOtcBKo, reason: not valid java name */
    public final SmartSubwayTrip m9311copydOtcBKo(String cityId, String cityName, long tripSessionId, String origin, String destination, String currentStation, String nextStation, String lineName, boolean isTransferRequired, boolean isDestination, long primaryLineColor, long secondaryLineColor, String transferStation, String previousStation, float segmentProgress, String transferLineName, List<String> transferOptions) {
        Intrinsics.checkNotNullParameter(cityId, "cityId");
        Intrinsics.checkNotNullParameter(cityName, "cityName");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(currentStation, "currentStation");
        Intrinsics.checkNotNullParameter(nextStation, "nextStation");
        Intrinsics.checkNotNullParameter(lineName, "lineName");
        Intrinsics.checkNotNullParameter(transferStation, "transferStation");
        Intrinsics.checkNotNullParameter(previousStation, "previousStation");
        Intrinsics.checkNotNullParameter(transferLineName, "transferLineName");
        Intrinsics.checkNotNullParameter(transferOptions, "transferOptions");
        return new SmartSubwayTrip(cityId, cityName, tripSessionId, origin, destination, currentStation, nextStation, lineName, isTransferRequired, isDestination, primaryLineColor, secondaryLineColor, transferStation, previousStation, segmentProgress, transferLineName, transferOptions, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SmartSubwayTrip)) {
            return false;
        }
        SmartSubwayTrip smartSubwayTrip = (SmartSubwayTrip) other;
        return Intrinsics.areEqual(this.cityId, smartSubwayTrip.cityId) && Intrinsics.areEqual(this.cityName, smartSubwayTrip.cityName) && this.tripSessionId == smartSubwayTrip.tripSessionId && Intrinsics.areEqual(this.origin, smartSubwayTrip.origin) && Intrinsics.areEqual(this.destination, smartSubwayTrip.destination) && Intrinsics.areEqual(this.currentStation, smartSubwayTrip.currentStation) && Intrinsics.areEqual(this.nextStation, smartSubwayTrip.nextStation) && Intrinsics.areEqual(this.lineName, smartSubwayTrip.lineName) && this.isTransferRequired == smartSubwayTrip.isTransferRequired && this.isDestination == smartSubwayTrip.isDestination && Color.m5839equalsimpl0(this.primaryLineColor, smartSubwayTrip.primaryLineColor) && Color.m5839equalsimpl0(this.secondaryLineColor, smartSubwayTrip.secondaryLineColor) && Intrinsics.areEqual(this.transferStation, smartSubwayTrip.transferStation) && Intrinsics.areEqual(this.previousStation, smartSubwayTrip.previousStation) && Float.compare(this.segmentProgress, smartSubwayTrip.segmentProgress) == 0 && Intrinsics.areEqual(this.transferLineName, smartSubwayTrip.transferLineName) && Intrinsics.areEqual(this.transferOptions, smartSubwayTrip.transferOptions);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.cityId.hashCode() * 31) + this.cityName.hashCode()) * 31) + Long.hashCode(this.tripSessionId)) * 31) + this.origin.hashCode()) * 31) + this.destination.hashCode()) * 31) + this.currentStation.hashCode()) * 31) + this.nextStation.hashCode()) * 31) + this.lineName.hashCode()) * 31) + Boolean.hashCode(this.isTransferRequired)) * 31) + Boolean.hashCode(this.isDestination)) * 31) + Color.m5845hashCodeimpl(this.primaryLineColor)) * 31) + Color.m5845hashCodeimpl(this.secondaryLineColor)) * 31) + this.transferStation.hashCode()) * 31) + this.previousStation.hashCode()) * 31) + Float.hashCode(this.segmentProgress)) * 31) + this.transferLineName.hashCode()) * 31) + this.transferOptions.hashCode();
    }

    public String toString() {
        return "SmartSubwayTrip(cityId=" + this.cityId + ", cityName=" + this.cityName + ", tripSessionId=" + this.tripSessionId + ", origin=" + this.origin + ", destination=" + this.destination + ", currentStation=" + this.currentStation + ", nextStation=" + this.nextStation + ", lineName=" + this.lineName + ", isTransferRequired=" + this.isTransferRequired + ", isDestination=" + this.isDestination + ", primaryLineColor=" + Color.m5846toStringimpl(this.primaryLineColor) + ", secondaryLineColor=" + Color.m5846toStringimpl(this.secondaryLineColor) + ", transferStation=" + this.transferStation + ", previousStation=" + this.previousStation + ", segmentProgress=" + this.segmentProgress + ", transferLineName=" + this.transferLineName + ", transferOptions=" + this.transferOptions + ")";
    }

    private SmartSubwayTrip(String cityId, String cityName, long j, String origin, String destination, String currentStation, String nextStation, String lineName, boolean z, boolean z2, long j2, long j3, String transferStation, String previousStation, float f, String transferLineName, List<String> transferOptions) {
        Intrinsics.checkNotNullParameter(cityId, "cityId");
        Intrinsics.checkNotNullParameter(cityName, "cityName");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(currentStation, "currentStation");
        Intrinsics.checkNotNullParameter(nextStation, "nextStation");
        Intrinsics.checkNotNullParameter(lineName, "lineName");
        Intrinsics.checkNotNullParameter(transferStation, "transferStation");
        Intrinsics.checkNotNullParameter(previousStation, "previousStation");
        Intrinsics.checkNotNullParameter(transferLineName, "transferLineName");
        Intrinsics.checkNotNullParameter(transferOptions, "transferOptions");
        this.cityId = cityId;
        this.cityName = cityName;
        this.tripSessionId = j;
        this.origin = origin;
        this.destination = destination;
        this.currentStation = currentStation;
        this.nextStation = nextStation;
        this.lineName = lineName;
        this.isTransferRequired = z;
        this.isDestination = z2;
        this.primaryLineColor = j2;
        this.secondaryLineColor = j3;
        this.transferStation = transferStation;
        this.previousStation = previousStation;
        this.segmentProgress = f;
        this.transferLineName = transferLineName;
        this.transferOptions = transferOptions;
    }

    public /* synthetic */ SmartSubwayTrip(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, boolean z, boolean z2, long j2, long j3, String str8, String str9, float f, String str10, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "nyc" : str, (i & 2) != 0 ? "纽约" : str2, (i & 4) != 0 ? System.currentTimeMillis() : j, str3, str4, (i & 32) != 0 ? "等待定位" : str5, (i & 64) != 0 ? "等待定位" : str6, (i & 128) != 0 ? "地铁" : str7, (i & 256) != 0 ? false : z, (i & 512) != 0 ? false : z2, (i & 1024) != 0 ? ColorKt.Color(4284125653L) : j2, (i & 2048) != 0 ? ColorKt.Color(4288774615L) : j3, (i & 4096) != 0 ? "" : str8, (i & 8192) != 0 ? "" : str9, (i & 16384) != 0 ? 0.0f : f, (32768 & i) != 0 ? "" : str10, (i & 65536) != 0 ? CollectionsKt.emptyList() : list, null);
    }

    public final String getCityId() {
        return this.cityId;
    }

    public final String getCityName() {
        return this.cityName;
    }

    public final long getTripSessionId() {
        return this.tripSessionId;
    }

    public final String getOrigin() {
        return this.origin;
    }

    public final String getDestination() {
        return this.destination;
    }

    public final String getCurrentStation() {
        return this.currentStation;
    }

    public final String getNextStation() {
        return this.nextStation;
    }

    public final String getLineName() {
        return this.lineName;
    }

    public final boolean isTransferRequired() {
        return this.isTransferRequired;
    }

    public final boolean isDestination() {
        return this.isDestination;
    }

    /* JADX INFO: renamed from: getPrimaryLineColor-0d7_KjU, reason: not valid java name */
    public final long m9312getPrimaryLineColor0d7_KjU() {
        return this.primaryLineColor;
    }

    /* JADX INFO: renamed from: getSecondaryLineColor-0d7_KjU, reason: not valid java name */
    public final long m9313getSecondaryLineColor0d7_KjU() {
        return this.secondaryLineColor;
    }

    public final String getTransferStation() {
        return this.transferStation;
    }

    public final String getPreviousStation() {
        return this.previousStation;
    }

    public final float getSegmentProgress() {
        return this.segmentProgress;
    }

    public final String getTransferLineName() {
        return this.transferLineName;
    }

    public final List<String> getTransferOptions() {
        return this.transferOptions;
    }
}
