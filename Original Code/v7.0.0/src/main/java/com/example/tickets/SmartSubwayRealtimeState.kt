package com.example.tickets;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmartSubwayRealtime.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b6\b\u0087\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\fHÆ\u0003J\t\u0010=\u001a\u00020\fHÆ\u0003J\t\u0010>\u001a\u00020\u000fHÆ\u0003J\t\u0010?\u001a\u00020\u000fHÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0014HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J×\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00032\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u0003HÆ\u0001J\u0013\u0010I\u001a\u00020\u000f2\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\fHÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010)R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010)R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001eR\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001e¨\u0006M"}, d2 = {"Lcom/example/tickets/SmartSubwayRealtimeState;", "", "routeId", "", "cityId", "cityName", "origin", "currentStation", "nextStation", "destination", "lineName", "primaryLineColor", "", "secondaryLineColor", "isTransferRequired", "", "isDestination", "transferStation", "previousStation", "segmentProgress", "", "transferLineName", "transferOptions", "", "etaText", "statusText", "nextActionText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZZLjava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRouteId", "()Ljava/lang/String;", "getCityId", "getCityName", "getOrigin", "getCurrentStation", "getNextStation", "getDestination", "getLineName", "getPrimaryLineColor", "()I", "getSecondaryLineColor", "()Z", "getTransferStation", "getPreviousStation", "getSegmentProgress", "()F", "getTransferLineName", "getTransferOptions", "()Ljava/util/List;", "getEtaText", "getStatusText", "getNextActionText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "equals", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SmartSubwayRealtimeState {
    public static final int $stable = 8;
    private final String cityId;
    private final String cityName;
    private final String currentStation;
    private final String destination;
    private final String etaText;
    private final boolean isDestination;
    private final boolean isTransferRequired;
    private final String lineName;
    private final String nextActionText;
    private final String nextStation;
    private final String origin;
    private final String previousStation;
    private final int primaryLineColor;
    private final String routeId;
    private final int secondaryLineColor;
    private final float segmentProgress;
    private final String statusText;
    private final String transferLineName;
    private final List<String> transferOptions;
    private final String transferStation;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SmartSubwayRealtimeState copy$default(SmartSubwayRealtimeState smartSubwayRealtimeState, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, boolean z, boolean z2, String str9, String str10, float f, String str11, List list, String str12, String str13, String str14, int i3, Object obj) {
        String str15;
        String str16;
        String str17 = (i3 & 1) != 0 ? smartSubwayRealtimeState.routeId : str;
        String str18 = (i3 & 2) != 0 ? smartSubwayRealtimeState.cityId : str2;
        String str19 = (i3 & 4) != 0 ? smartSubwayRealtimeState.cityName : str3;
        String str20 = (i3 & 8) != 0 ? smartSubwayRealtimeState.origin : str4;
        String str21 = (i3 & 16) != 0 ? smartSubwayRealtimeState.currentStation : str5;
        String str22 = (i3 & 32) != 0 ? smartSubwayRealtimeState.nextStation : str6;
        String str23 = (i3 & 64) != 0 ? smartSubwayRealtimeState.destination : str7;
        String str24 = (i3 & 128) != 0 ? smartSubwayRealtimeState.lineName : str8;
        int i4 = (i3 & 256) != 0 ? smartSubwayRealtimeState.primaryLineColor : i;
        int i5 = (i3 & 512) != 0 ? smartSubwayRealtimeState.secondaryLineColor : i2;
        boolean z3 = (i3 & 1024) != 0 ? smartSubwayRealtimeState.isTransferRequired : z;
        boolean z4 = (i3 & 2048) != 0 ? smartSubwayRealtimeState.isDestination : z2;
        String str25 = (i3 & 4096) != 0 ? smartSubwayRealtimeState.transferStation : str9;
        String str26 = (i3 & 8192) != 0 ? smartSubwayRealtimeState.previousStation : str10;
        String str27 = str17;
        float f2 = (i3 & 16384) != 0 ? smartSubwayRealtimeState.segmentProgress : f;
        String str28 = (i3 & 32768) != 0 ? smartSubwayRealtimeState.transferLineName : str11;
        List list2 = (i3 & 65536) != 0 ? smartSubwayRealtimeState.transferOptions : list;
        String str29 = (i3 & 131072) != 0 ? smartSubwayRealtimeState.etaText : str12;
        String str30 = (i3 & 262144) != 0 ? smartSubwayRealtimeState.statusText : str13;
        if ((i3 & 524288) != 0) {
            str16 = str30;
            str15 = smartSubwayRealtimeState.nextActionText;
        } else {
            str15 = str14;
            str16 = str30;
        }
        return smartSubwayRealtimeState.copy(str27, str18, str19, str20, str21, str22, str23, str24, i4, i5, z3, z4, str25, str26, f2, str28, list2, str29, str16, str15);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRouteId() {
        return this.routeId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getSecondaryLineColor() {
        return this.secondaryLineColor;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsTransferRequired() {
        return this.isTransferRequired;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsDestination() {
        return this.isDestination;
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

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getEtaText() {
        return this.etaText;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getStatusText() {
        return this.statusText;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCityId() {
        return this.cityId;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getNextActionText() {
        return this.nextActionText;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCityName() {
        return this.cityName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOrigin() {
        return this.origin;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCurrentStation() {
        return this.currentStation;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getNextStation() {
        return this.nextStation;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDestination() {
        return this.destination;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getLineName() {
        return this.lineName;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getPrimaryLineColor() {
        return this.primaryLineColor;
    }

    public final SmartSubwayRealtimeState copy(String routeId, String cityId, String cityName, String origin, String currentStation, String nextStation, String destination, String lineName, int primaryLineColor, int secondaryLineColor, boolean isTransferRequired, boolean isDestination, String transferStation, String previousStation, float segmentProgress, String transferLineName, List<String> transferOptions, String etaText, String statusText, String nextActionText) {
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        Intrinsics.checkNotNullParameter(cityId, "cityId");
        Intrinsics.checkNotNullParameter(cityName, "cityName");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(currentStation, "currentStation");
        Intrinsics.checkNotNullParameter(nextStation, "nextStation");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(lineName, "lineName");
        Intrinsics.checkNotNullParameter(transferStation, "transferStation");
        Intrinsics.checkNotNullParameter(previousStation, "previousStation");
        Intrinsics.checkNotNullParameter(transferLineName, "transferLineName");
        Intrinsics.checkNotNullParameter(transferOptions, "transferOptions");
        Intrinsics.checkNotNullParameter(etaText, "etaText");
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        Intrinsics.checkNotNullParameter(nextActionText, "nextActionText");
        return new SmartSubwayRealtimeState(routeId, cityId, cityName, origin, currentStation, nextStation, destination, lineName, primaryLineColor, secondaryLineColor, isTransferRequired, isDestination, transferStation, previousStation, segmentProgress, transferLineName, transferOptions, etaText, statusText, nextActionText);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SmartSubwayRealtimeState)) {
            return false;
        }
        SmartSubwayRealtimeState smartSubwayRealtimeState = (SmartSubwayRealtimeState) other;
        return Intrinsics.areEqual(this.routeId, smartSubwayRealtimeState.routeId) && Intrinsics.areEqual(this.cityId, smartSubwayRealtimeState.cityId) && Intrinsics.areEqual(this.cityName, smartSubwayRealtimeState.cityName) && Intrinsics.areEqual(this.origin, smartSubwayRealtimeState.origin) && Intrinsics.areEqual(this.currentStation, smartSubwayRealtimeState.currentStation) && Intrinsics.areEqual(this.nextStation, smartSubwayRealtimeState.nextStation) && Intrinsics.areEqual(this.destination, smartSubwayRealtimeState.destination) && Intrinsics.areEqual(this.lineName, smartSubwayRealtimeState.lineName) && this.primaryLineColor == smartSubwayRealtimeState.primaryLineColor && this.secondaryLineColor == smartSubwayRealtimeState.secondaryLineColor && this.isTransferRequired == smartSubwayRealtimeState.isTransferRequired && this.isDestination == smartSubwayRealtimeState.isDestination && Intrinsics.areEqual(this.transferStation, smartSubwayRealtimeState.transferStation) && Intrinsics.areEqual(this.previousStation, smartSubwayRealtimeState.previousStation) && Float.compare(this.segmentProgress, smartSubwayRealtimeState.segmentProgress) == 0 && Intrinsics.areEqual(this.transferLineName, smartSubwayRealtimeState.transferLineName) && Intrinsics.areEqual(this.transferOptions, smartSubwayRealtimeState.transferOptions) && Intrinsics.areEqual(this.etaText, smartSubwayRealtimeState.etaText) && Intrinsics.areEqual(this.statusText, smartSubwayRealtimeState.statusText) && Intrinsics.areEqual(this.nextActionText, smartSubwayRealtimeState.nextActionText);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((this.routeId.hashCode() * 31) + this.cityId.hashCode()) * 31) + this.cityName.hashCode()) * 31) + this.origin.hashCode()) * 31) + this.currentStation.hashCode()) * 31) + this.nextStation.hashCode()) * 31) + this.destination.hashCode()) * 31) + this.lineName.hashCode()) * 31) + Integer.hashCode(this.primaryLineColor)) * 31) + Integer.hashCode(this.secondaryLineColor)) * 31) + Boolean.hashCode(this.isTransferRequired)) * 31) + Boolean.hashCode(this.isDestination)) * 31) + this.transferStation.hashCode()) * 31) + this.previousStation.hashCode()) * 31) + Float.hashCode(this.segmentProgress)) * 31) + this.transferLineName.hashCode()) * 31) + this.transferOptions.hashCode()) * 31) + this.etaText.hashCode()) * 31) + this.statusText.hashCode()) * 31) + this.nextActionText.hashCode();
    }

    public String toString() {
        return "SmartSubwayRealtimeState(routeId=" + this.routeId + ", cityId=" + this.cityId + ", cityName=" + this.cityName + ", origin=" + this.origin + ", currentStation=" + this.currentStation + ", nextStation=" + this.nextStation + ", destination=" + this.destination + ", lineName=" + this.lineName + ", primaryLineColor=" + this.primaryLineColor + ", secondaryLineColor=" + this.secondaryLineColor + ", isTransferRequired=" + this.isTransferRequired + ", isDestination=" + this.isDestination + ", transferStation=" + this.transferStation + ", previousStation=" + this.previousStation + ", segmentProgress=" + this.segmentProgress + ", transferLineName=" + this.transferLineName + ", transferOptions=" + this.transferOptions + ", etaText=" + this.etaText + ", statusText=" + this.statusText + ", nextActionText=" + this.nextActionText + ")";
    }

    public SmartSubwayRealtimeState(String routeId, String cityId, String cityName, String origin, String currentStation, String nextStation, String destination, String lineName, int i, int i2, boolean z, boolean z2, String transferStation, String previousStation, float f, String transferLineName, List<String> transferOptions, String etaText, String statusText, String nextActionText) {
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        Intrinsics.checkNotNullParameter(cityId, "cityId");
        Intrinsics.checkNotNullParameter(cityName, "cityName");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(currentStation, "currentStation");
        Intrinsics.checkNotNullParameter(nextStation, "nextStation");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(lineName, "lineName");
        Intrinsics.checkNotNullParameter(transferStation, "transferStation");
        Intrinsics.checkNotNullParameter(previousStation, "previousStation");
        Intrinsics.checkNotNullParameter(transferLineName, "transferLineName");
        Intrinsics.checkNotNullParameter(transferOptions, "transferOptions");
        Intrinsics.checkNotNullParameter(etaText, "etaText");
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        Intrinsics.checkNotNullParameter(nextActionText, "nextActionText");
        this.routeId = routeId;
        this.cityId = cityId;
        this.cityName = cityName;
        this.origin = origin;
        this.currentStation = currentStation;
        this.nextStation = nextStation;
        this.destination = destination;
        this.lineName = lineName;
        this.primaryLineColor = i;
        this.secondaryLineColor = i2;
        this.isTransferRequired = z;
        this.isDestination = z2;
        this.transferStation = transferStation;
        this.previousStation = previousStation;
        this.segmentProgress = f;
        this.transferLineName = transferLineName;
        this.transferOptions = transferOptions;
        this.etaText = etaText;
        this.statusText = statusText;
        this.nextActionText = nextActionText;
    }

    public /* synthetic */ SmartSubwayRealtimeState(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, boolean z, boolean z2, String str9, String str10, float f, String str11, List list, String str12, String str13, String str14, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "smart_subway" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, str4, str5, str6, str7, str8, i, (i3 & 512) != 0 ? i : i2, (i3 & 1024) != 0 ? false : z, (i3 & 2048) != 0 ? false : z2, (i3 & 4096) != 0 ? "" : str9, (i3 & 8192) != 0 ? "" : str10, (i3 & 16384) != 0 ? 0.0f : f, (32768 & i3) != 0 ? "" : str11, (65536 & i3) != 0 ? CollectionsKt.emptyList() : list, (131072 & i3) != 0 ? "" : str12, (262144 & i3) != 0 ? "行程进行中" : str13, (i3 & 524288) != 0 ? "正在前往下一站" : str14);
    }

    public final String getRouteId() {
        return this.routeId;
    }

    public final String getCityId() {
        return this.cityId;
    }

    public final String getCityName() {
        return this.cityName;
    }

    public final String getOrigin() {
        return this.origin;
    }

    public final String getCurrentStation() {
        return this.currentStation;
    }

    public final String getNextStation() {
        return this.nextStation;
    }

    public final String getDestination() {
        return this.destination;
    }

    public final String getLineName() {
        return this.lineName;
    }

    public final int getPrimaryLineColor() {
        return this.primaryLineColor;
    }

    public final int getSecondaryLineColor() {
        return this.secondaryLineColor;
    }

    public final boolean isTransferRequired() {
        return this.isTransferRequired;
    }

    public final boolean isDestination() {
        return this.isDestination;
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

    public final String getEtaText() {
        return this.etaText;
    }

    public final String getStatusText() {
        return this.statusText;
    }

    public final String getNextActionText() {
        return this.nextActionText;
    }
}
