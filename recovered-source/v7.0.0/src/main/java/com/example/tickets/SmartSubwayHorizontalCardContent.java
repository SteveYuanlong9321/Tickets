package com.example.tickets;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmartSubwayRealtime.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/example/tickets/SmartSubwayHorizontalCardContent;", "", "lineSummary", "", "statusText", "previousStation", "currentStation", "nextStation", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLineSummary", "()Ljava/lang/String;", "getStatusText", "getPreviousStation", "getCurrentStation", "getNextStation", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SmartSubwayHorizontalCardContent {
    public static final int $stable = 0;
    private final String currentStation;
    private final String lineSummary;
    private final String nextStation;
    private final String previousStation;
    private final String statusText;

    public static /* synthetic */ SmartSubwayHorizontalCardContent copy$default(SmartSubwayHorizontalCardContent smartSubwayHorizontalCardContent, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = smartSubwayHorizontalCardContent.lineSummary;
        }
        if ((i & 2) != 0) {
            str2 = smartSubwayHorizontalCardContent.statusText;
        }
        if ((i & 4) != 0) {
            str3 = smartSubwayHorizontalCardContent.previousStation;
        }
        if ((i & 8) != 0) {
            str4 = smartSubwayHorizontalCardContent.currentStation;
        }
        if ((i & 16) != 0) {
            str5 = smartSubwayHorizontalCardContent.nextStation;
        }
        String str6 = str5;
        String str7 = str3;
        return smartSubwayHorizontalCardContent.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLineSummary() {
        return this.lineSummary;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStatusText() {
        return this.statusText;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPreviousStation() {
        return this.previousStation;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCurrentStation() {
        return this.currentStation;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getNextStation() {
        return this.nextStation;
    }

    public final SmartSubwayHorizontalCardContent copy(String lineSummary, String statusText, String previousStation, String currentStation, String nextStation) {
        Intrinsics.checkNotNullParameter(lineSummary, "lineSummary");
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        Intrinsics.checkNotNullParameter(previousStation, "previousStation");
        Intrinsics.checkNotNullParameter(currentStation, "currentStation");
        Intrinsics.checkNotNullParameter(nextStation, "nextStation");
        return new SmartSubwayHorizontalCardContent(lineSummary, statusText, previousStation, currentStation, nextStation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SmartSubwayHorizontalCardContent)) {
            return false;
        }
        SmartSubwayHorizontalCardContent smartSubwayHorizontalCardContent = (SmartSubwayHorizontalCardContent) other;
        return Intrinsics.areEqual(this.lineSummary, smartSubwayHorizontalCardContent.lineSummary) && Intrinsics.areEqual(this.statusText, smartSubwayHorizontalCardContent.statusText) && Intrinsics.areEqual(this.previousStation, smartSubwayHorizontalCardContent.previousStation) && Intrinsics.areEqual(this.currentStation, smartSubwayHorizontalCardContent.currentStation) && Intrinsics.areEqual(this.nextStation, smartSubwayHorizontalCardContent.nextStation);
    }

    public int hashCode() {
        return (((((((this.lineSummary.hashCode() * 31) + this.statusText.hashCode()) * 31) + this.previousStation.hashCode()) * 31) + this.currentStation.hashCode()) * 31) + this.nextStation.hashCode();
    }

    public String toString() {
        return "SmartSubwayHorizontalCardContent(lineSummary=" + this.lineSummary + ", statusText=" + this.statusText + ", previousStation=" + this.previousStation + ", currentStation=" + this.currentStation + ", nextStation=" + this.nextStation + ")";
    }

    public SmartSubwayHorizontalCardContent(String lineSummary, String statusText, String previousStation, String currentStation, String nextStation) {
        Intrinsics.checkNotNullParameter(lineSummary, "lineSummary");
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        Intrinsics.checkNotNullParameter(previousStation, "previousStation");
        Intrinsics.checkNotNullParameter(currentStation, "currentStation");
        Intrinsics.checkNotNullParameter(nextStation, "nextStation");
        this.lineSummary = lineSummary;
        this.statusText = statusText;
        this.previousStation = previousStation;
        this.currentStation = currentStation;
        this.nextStation = nextStation;
    }

    public final String getLineSummary() {
        return this.lineSummary;
    }

    public final String getStatusText() {
        return this.statusText;
    }

    public final String getPreviousStation() {
        return this.previousStation;
    }

    public final String getCurrentStation() {
        return this.currentStation;
    }

    public final String getNextStation() {
        return this.nextStation;
    }
}
