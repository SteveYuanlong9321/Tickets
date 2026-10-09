package com.example.tickets;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RealtimeNotificationState.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u000fHÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\u0095\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0005HÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0003HÖ\u0001J\t\u0010;\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019¨\u0006<"}, d2 = {"Lcom/example/tickets/RealtimeNotificationState;", "", "ticketId", "", "ticketType", "", "title", "code", "date", "startTime", "", "endTime", NotificationCompat.CATEGORY_PROGRESS, "progressPermille", NotificationCompat.CATEGORY_STATUS, "Lcom/example/tickets/RealtimeNotificationStatus;", "statusText", "routeText", "timeText", "seatText", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJIILcom/example/tickets/RealtimeNotificationStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTicketId", "()I", "getTicketType", "()Ljava/lang/String;", "getTitle", "getCode", "getDate", "getStartTime", "()J", "getEndTime", "getProgress", "getProgressPermille", "getStatus", "()Lcom/example/tickets/RealtimeNotificationStatus;", "getStatusText", "getRouteText", "getTimeText", "getSeatText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RealtimeNotificationState {
    public static final int $stable = 0;
    private final String code;
    private final String date;
    private final long endTime;
    private final int progress;
    private final int progressPermille;
    private final String routeText;
    private final String seatText;
    private final long startTime;
    private final RealtimeNotificationStatus status;
    private final String statusText;
    private final int ticketId;
    private final String ticketType;
    private final String timeText;
    private final String title;

    public static /* synthetic */ RealtimeNotificationState copy$default(RealtimeNotificationState realtimeNotificationState, int i, String str, String str2, String str3, String str4, long j, long j2, int i2, int i3, RealtimeNotificationStatus realtimeNotificationStatus, String str5, String str6, String str7, String str8, int i4, Object obj) {
        int i5 = (i4 & 1) != 0 ? realtimeNotificationState.ticketId : i;
        return realtimeNotificationState.copy(i5, (i4 & 2) != 0 ? realtimeNotificationState.ticketType : str, (i4 & 4) != 0 ? realtimeNotificationState.title : str2, (i4 & 8) != 0 ? realtimeNotificationState.code : str3, (i4 & 16) != 0 ? realtimeNotificationState.date : str4, (i4 & 32) != 0 ? realtimeNotificationState.startTime : j, (i4 & 64) != 0 ? realtimeNotificationState.endTime : j2, (i4 & 128) != 0 ? realtimeNotificationState.progress : i2, (i4 & 256) != 0 ? realtimeNotificationState.progressPermille : i3, (i4 & 512) != 0 ? realtimeNotificationState.status : realtimeNotificationStatus, (i4 & 1024) != 0 ? realtimeNotificationState.statusText : str5, (i4 & 2048) != 0 ? realtimeNotificationState.routeText : str6, (i4 & 4096) != 0 ? realtimeNotificationState.timeText : str7, (i4 & 8192) != 0 ? realtimeNotificationState.seatText : str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTicketId() {
        return this.ticketId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final RealtimeNotificationStatus getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getStatusText() {
        return this.statusText;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getRouteText() {
        return this.routeText;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getTimeText() {
        return this.timeText;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getSeatText() {
        return this.seatText;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTicketType() {
        return this.ticketType;
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
    public final long getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getProgress() {
        return this.progress;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getProgressPermille() {
        return this.progressPermille;
    }

    public final RealtimeNotificationState copy(int ticketId, String ticketType, String title, String code, String date, long startTime, long endTime, int progress, int progressPermille, RealtimeNotificationStatus status, String statusText, String routeText, String timeText, String seatText) {
        Intrinsics.checkNotNullParameter(ticketType, "ticketType");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        Intrinsics.checkNotNullParameter(routeText, "routeText");
        Intrinsics.checkNotNullParameter(timeText, "timeText");
        Intrinsics.checkNotNullParameter(seatText, "seatText");
        return new RealtimeNotificationState(ticketId, ticketType, title, code, date, startTime, endTime, progress, progressPermille, status, statusText, routeText, timeText, seatText);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RealtimeNotificationState)) {
            return false;
        }
        RealtimeNotificationState realtimeNotificationState = (RealtimeNotificationState) other;
        return this.ticketId == realtimeNotificationState.ticketId && Intrinsics.areEqual(this.ticketType, realtimeNotificationState.ticketType) && Intrinsics.areEqual(this.title, realtimeNotificationState.title) && Intrinsics.areEqual(this.code, realtimeNotificationState.code) && Intrinsics.areEqual(this.date, realtimeNotificationState.date) && this.startTime == realtimeNotificationState.startTime && this.endTime == realtimeNotificationState.endTime && this.progress == realtimeNotificationState.progress && this.progressPermille == realtimeNotificationState.progressPermille && this.status == realtimeNotificationState.status && Intrinsics.areEqual(this.statusText, realtimeNotificationState.statusText) && Intrinsics.areEqual(this.routeText, realtimeNotificationState.routeText) && Intrinsics.areEqual(this.timeText, realtimeNotificationState.timeText) && Intrinsics.areEqual(this.seatText, realtimeNotificationState.seatText);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((Integer.hashCode(this.ticketId) * 31) + this.ticketType.hashCode()) * 31) + this.title.hashCode()) * 31) + this.code.hashCode()) * 31) + this.date.hashCode()) * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.endTime)) * 31) + Integer.hashCode(this.progress)) * 31) + Integer.hashCode(this.progressPermille)) * 31) + this.status.hashCode()) * 31) + this.statusText.hashCode()) * 31) + this.routeText.hashCode()) * 31) + this.timeText.hashCode()) * 31) + this.seatText.hashCode();
    }

    public String toString() {
        return "RealtimeNotificationState(ticketId=" + this.ticketId + ", ticketType=" + this.ticketType + ", title=" + this.title + ", code=" + this.code + ", date=" + this.date + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", progress=" + this.progress + ", progressPermille=" + this.progressPermille + ", status=" + this.status + ", statusText=" + this.statusText + ", routeText=" + this.routeText + ", timeText=" + this.timeText + ", seatText=" + this.seatText + ")";
    }

    public RealtimeNotificationState(int i, String ticketType, String title, String code, String date, long j, long j2, int i2, int i3, RealtimeNotificationStatus status, String statusText, String routeText, String timeText, String seatText) {
        Intrinsics.checkNotNullParameter(ticketType, "ticketType");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        Intrinsics.checkNotNullParameter(routeText, "routeText");
        Intrinsics.checkNotNullParameter(timeText, "timeText");
        Intrinsics.checkNotNullParameter(seatText, "seatText");
        this.ticketId = i;
        this.ticketType = ticketType;
        this.title = title;
        this.code = code;
        this.date = date;
        this.startTime = j;
        this.endTime = j2;
        this.progress = i2;
        this.progressPermille = i3;
        this.status = status;
        this.statusText = statusText;
        this.routeText = routeText;
        this.timeText = timeText;
        this.seatText = seatText;
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

    public final long getStartTime() {
        return this.startTime;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getProgressPermille() {
        return this.progressPermille;
    }

    public final RealtimeNotificationStatus getStatus() {
        return this.status;
    }

    public final String getStatusText() {
        return this.statusText;
    }

    public final String getRouteText() {
        return this.routeText;
    }

    public final String getTimeText() {
        return this.timeText;
    }

    public final String getSeatText() {
        return this.seatText;
    }
}
