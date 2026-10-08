package com.example.tickets;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmartSubwayRealtime.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006$"}, d2 = {"Lcom/example/tickets/SmartSubwayTimelineStop;", "", "stationName", "", "caption", "lineName", "lineColor", "", "active", "", "transferFromLine", "transferToLine", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;)V", "getStationName", "()Ljava/lang/String;", "getCaption", "getLineName", "getLineColor", "()I", "getActive", "()Z", "getTransferFromLine", "getTransferToLine", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SmartSubwayTimelineStop {
    public static final int $stable = 0;
    private final boolean active;
    private final String caption;
    private final int lineColor;
    private final String lineName;
    private final String stationName;
    private final String transferFromLine;
    private final String transferToLine;

    public static /* synthetic */ SmartSubwayTimelineStop copy$default(SmartSubwayTimelineStop smartSubwayTimelineStop, String str, String str2, String str3, int i, boolean z, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = smartSubwayTimelineStop.stationName;
        }
        if ((i2 & 2) != 0) {
            str2 = smartSubwayTimelineStop.caption;
        }
        if ((i2 & 4) != 0) {
            str3 = smartSubwayTimelineStop.lineName;
        }
        if ((i2 & 8) != 0) {
            i = smartSubwayTimelineStop.lineColor;
        }
        if ((i2 & 16) != 0) {
            z = smartSubwayTimelineStop.active;
        }
        if ((i2 & 32) != 0) {
            str4 = smartSubwayTimelineStop.transferFromLine;
        }
        if ((i2 & 64) != 0) {
            str5 = smartSubwayTimelineStop.transferToLine;
        }
        String str6 = str4;
        String str7 = str5;
        boolean z2 = z;
        String str8 = str3;
        return smartSubwayTimelineStop.copy(str, str2, str8, i, z2, str6, str7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStationName() {
        return this.stationName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCaption() {
        return this.caption;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLineName() {
        return this.lineName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getLineColor() {
        return this.lineColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getActive() {
        return this.active;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTransferFromLine() {
        return this.transferFromLine;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTransferToLine() {
        return this.transferToLine;
    }

    public final SmartSubwayTimelineStop copy(String stationName, String caption, String lineName, int lineColor, boolean active, String transferFromLine, String transferToLine) {
        Intrinsics.checkNotNullParameter(stationName, "stationName");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(lineName, "lineName");
        Intrinsics.checkNotNullParameter(transferFromLine, "transferFromLine");
        Intrinsics.checkNotNullParameter(transferToLine, "transferToLine");
        return new SmartSubwayTimelineStop(stationName, caption, lineName, lineColor, active, transferFromLine, transferToLine);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SmartSubwayTimelineStop)) {
            return false;
        }
        SmartSubwayTimelineStop smartSubwayTimelineStop = (SmartSubwayTimelineStop) other;
        return Intrinsics.areEqual(this.stationName, smartSubwayTimelineStop.stationName) && Intrinsics.areEqual(this.caption, smartSubwayTimelineStop.caption) && Intrinsics.areEqual(this.lineName, smartSubwayTimelineStop.lineName) && this.lineColor == smartSubwayTimelineStop.lineColor && this.active == smartSubwayTimelineStop.active && Intrinsics.areEqual(this.transferFromLine, smartSubwayTimelineStop.transferFromLine) && Intrinsics.areEqual(this.transferToLine, smartSubwayTimelineStop.transferToLine);
    }

    public int hashCode() {
        return (((((((((((this.stationName.hashCode() * 31) + this.caption.hashCode()) * 31) + this.lineName.hashCode()) * 31) + Integer.hashCode(this.lineColor)) * 31) + Boolean.hashCode(this.active)) * 31) + this.transferFromLine.hashCode()) * 31) + this.transferToLine.hashCode();
    }

    public String toString() {
        return "SmartSubwayTimelineStop(stationName=" + this.stationName + ", caption=" + this.caption + ", lineName=" + this.lineName + ", lineColor=" + this.lineColor + ", active=" + this.active + ", transferFromLine=" + this.transferFromLine + ", transferToLine=" + this.transferToLine + ")";
    }

    public SmartSubwayTimelineStop(String stationName, String caption, String lineName, int i, boolean z, String transferFromLine, String transferToLine) {
        Intrinsics.checkNotNullParameter(stationName, "stationName");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(lineName, "lineName");
        Intrinsics.checkNotNullParameter(transferFromLine, "transferFromLine");
        Intrinsics.checkNotNullParameter(transferToLine, "transferToLine");
        this.stationName = stationName;
        this.caption = caption;
        this.lineName = lineName;
        this.lineColor = i;
        this.active = z;
        this.transferFromLine = transferFromLine;
        this.transferToLine = transferToLine;
    }

    public /* synthetic */ SmartSubwayTimelineStop(String str, String str2, String str3, int i, boolean z, String str4, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? "" : str4, (i2 & 64) != 0 ? "" : str5);
    }

    public final String getStationName() {
        return this.stationName;
    }

    public final String getCaption() {
        return this.caption;
    }

    public final String getLineName() {
        return this.lineName;
    }

    public final int getLineColor() {
        return this.lineColor;
    }

    public final boolean getActive() {
        return this.active;
    }

    public final String getTransferFromLine() {
        return this.transferFromLine;
    }

    public final String getTransferToLine() {
        return this.transferToLine;
    }
}
