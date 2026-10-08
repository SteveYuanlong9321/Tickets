package com.example.tickets;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.google.firebase.messaging.ServiceStarter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RealtimeOngoingNotificationManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001d\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u001aJ\u0016\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/example/tickets/RealtimeOngoingNotificationManager;", "", "<init>", "()V", "CHANNEL_BASE_ID", "", "CHANNEL_NAME", "BASE_TICKET_ID", "", "SMART_SUBWAY_ID", "REALTIME_BRAND_COLOR", "REALTIME_PROGRESS_MAX", "hasNotificationPermission", "", "context", "Landroid/content/Context;", "createChannel", "", "channelId", "contentIntent", "Landroid/app/PendingIntent;", "ticketId", "progressForTicket", "ticket", "Lcom/example/tickets/TicketData;", "showTicket", "showTicket$app", "showSmartSubway", "state", "Lcom/example/tickets/SmartSubwayRealtimeState;", "cancelTicket", "cancelSmartSubway", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RealtimeOngoingNotificationManager {
    public static final int $stable = 0;
    private static final int BASE_TICKET_ID = 68000;
    private static final String CHANNEL_BASE_ID = "ticket_realtime_ongoing_fallback";
    private static final String CHANNEL_NAME = "票据 · 实时通知";
    public static final RealtimeOngoingNotificationManager INSTANCE = new RealtimeOngoingNotificationManager();
    private static final int REALTIME_BRAND_COLOR = -14949188;
    private static final int REALTIME_PROGRESS_MAX = 1000;
    private static final int SMART_SUBWAY_ID = 68999;

    /* JADX INFO: compiled from: RealtimeOngoingNotificationManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TicketType.values().length];
            try {
                iArr[TicketType.Movie.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TicketType.Train.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TicketType.Airplane.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TicketType.Event.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TicketType.Admission.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TicketType.TakeoutCode.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TicketType.PickupCode.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private RealtimeOngoingNotificationManager() {
    }

    private final boolean hasNotificationPermission(Context context) {
        return Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0;
    }

    private final void createChannel(Context context) {
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        RealtimeNotificationVisibilityController.INSTANCE.createVisibilityChannels((NotificationManager) systemService, CHANNEL_BASE_ID, CHANNEL_NAME, "厂商实时通知通道不可用时的标准持续通知", false);
    }

    private final String channelId() {
        return RealtimeNotificationVisibilityController.channelId$default(RealtimeNotificationVisibilityController.INSTANCE, CHANNEL_BASE_ID, null, null, 6, null);
    }

    private final PendingIntent contentIntent(Context context, int ticketId) {
        Intent intent = new Intent(context, (Class<?>) MainActivity.class);
        intent.setAction(LiveUpdateManager.ACTION_OPEN_TICKET_V2);
        intent.putExtra("ticket_id", ticketId);
        intent.setFlags(603979776);
        PendingIntent activity = PendingIntent.getActivity(context, ticketId + 680000, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return activity;
    }

    private final int progressForTicket(TicketData ticket) {
        String str;
        Object objM9536constructorimpl;
        int id = ticket.getId();
        switch (WhenMappings.$EnumSwitchMapping$0[ticket.getType().ordinal()]) {
            case 1:
                str = "电影票";
                break;
            case 2:
                str = "车票";
                break;
            case 3:
                str = "机票";
                break;
            case 4:
                str = "演出";
                break;
            case 5:
                str = "门票";
                break;
            case 6:
                str = "取餐码";
                break;
            case 7:
                str = "取件码";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        LiveUpdatePayload liveUpdatePayload = new LiveUpdatePayload(id, str, ticket.getTitle(), ticket.getCode(), ticket.getDate(), ticket.getTime(), ticket.getDepartureDate(), ticket.getArrivalDate(), ticket.getFrom(), ticket.getTo(), ticket.getDeparturePlatform(), ticket.getArrivalPlatform(), ticket.getHall(), ticket.getSeat(), ticket.getVenue(), ticket.getArea(), ticket.getEntry(), ticket.getStartTime(), ticket.getEndTime(), ticket.getTakeoffTime(), ticket.getLandingTime(), ticket.getBrand());
        try {
            Result.Companion companion = Result.INSTANCE;
            RealtimeOngoingNotificationManager realtimeOngoingNotificationManager = this;
            objM9536constructorimpl = Result.m9536constructorimpl(LiveUpdateManager.INSTANCE.resolveWindow(liveUpdatePayload));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        Pair pair = TuplesKt.to(Long.MAX_VALUE, Long.MAX_VALUE);
        if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
            objM9536constructorimpl = pair;
        }
        Pair pair2 = (Pair) objM9536constructorimpl;
        return (((Number) pair2.getFirst()).longValue() == Long.MAX_VALUE || ((Number) pair2.getSecond()).longValue() <= ((Number) pair2.getFirst()).longValue()) ? ServiceStarter.ERROR_UNKNOWN : RangesKt.coerceIn((int) ((RangesKt.coerceIn(System.currentTimeMillis() - ((Number) pair2.getFirst()).longValue(), 0L, ((Number) pair2.getSecond()).longValue() - ((Number) pair2.getFirst()).longValue()) * 1000) / (((Number) pair2.getSecond()).longValue() - ((Number) pair2.getFirst()).longValue())), 0, 1000);
    }

    public final void showTicket$app(Context context, TicketData ticket) {
        String str;
        String title;
        String time;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        if (hasNotificationPermission(context)) {
            createChannel(context);
            switch (WhenMappings.$EnumSwitchMapping$0[ticket.getType().ordinal()]) {
                case 1:
                    str = "电影票";
                    break;
                case 2:
                    str = "车票";
                    break;
                case 3:
                    str = "机票";
                    break;
                case 4:
                    str = "演出";
                    break;
                case 5:
                    str = "门票";
                    break;
                case 6:
                    str = "取餐码";
                    break;
                case 7:
                    str = "取件码";
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            int i = WhenMappings.$EnumSwitchMapping$0[ticket.getType().ordinal()];
            if (i == 2 || i == 3 || i == 6 || i == 7) {
                String code = ticket.getCode();
                if (StringsKt.isBlank(code)) {
                    code = ticket.getTitle();
                }
                title = code;
            } else {
                title = ticket.getTitle();
            }
            String str2 = title;
            if (StringsKt.isBlank(str2)) {
                str2 = str;
            }
            String str3 = str2;
            List listListOf = CollectionsKt.listOf((Object[]) new String[]{ticket.getFrom(), ticket.getTo()});
            ArrayList arrayList = new ArrayList();
            for (Object obj : listListOf) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
            if (StringsKt.isBlank(strJoinToString$default)) {
                time = !StringsKt.isBlank(ticket.getTime()) ? ticket.getTime() : str;
            } else {
                time = strJoinToString$default;
            }
            String str4 = str3;
            NotificationCompat.Builder visibility = new NotificationCompat.Builder(context, channelId()).setSmallIcon(R.drawable.ic_live_train).setColor(REALTIME_BRAND_COLOR).setContentTitle(str4).setContentText(time).setContentIntent(contentIntent(context, ticket.getId())).setOngoing(true).setOnlyAlertOnce(true).setShowWhen(false).setLocalOnly(true).setCategory(NotificationCompat.CATEGORY_NAVIGATION).setVisibility(1);
            NotificationCompat.BigTextStyle bigContentTitle = new NotificationCompat.BigTextStyle().setBigContentTitle(str4);
            List listListOf2 = CollectionsKt.listOf((Object[]) new String[]{str, strJoinToString$default, ticket.getTime(), ticket.getVenue(), ticket.getSeat()});
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : listListOf2) {
                if (!StringsKt.isBlank((String) obj2)) {
                    arrayList2.add(obj2);
                }
            }
            NotificationCompat.Builder progress = visibility.setStyle(bigContentTitle.bigText(CollectionsKt.joinToString$default(arrayList2, "\n", null, null, 0, null, null, 62, null))).setProgress(1000, progressForTicket(ticket), false);
            Intrinsics.checkNotNullExpressionValue(progress, "setProgress(...)");
            Notification notificationBuild = progress.build();
            Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
            try {
                NotificationManagerCompat.from(context).notify(ticket.getId() + BASE_TICKET_ID, notificationBuild);
            } catch (SecurityException unused) {
            }
        }
    }

    public final void showSmartSubway(Context context, SmartSubwayRealtimeState state) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(state, "state");
        if (hasNotificationPermission(context)) {
            createChannel(context);
            String currentStation = state.getCurrentStation();
            if (StringsKt.isBlank(currentStation)) {
                currentStation = null;
            }
            String nextStation = state.getNextStation();
            if (StringsKt.isBlank(nextStation)) {
                nextStation = null;
            }
            String etaText = state.getEtaText();
            String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new String[]{currentStation, nextStation, StringsKt.isBlank(etaText) ? null : etaText}), " · ", null, null, 0, null, null, 62, null);
            NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(context, channelId()).setSmallIcon(R.drawable.ic_live_train).setColor(REALTIME_BRAND_COLOR).setContentTitle("当前站 " + state.getCurrentStation());
            String nextActionText = strJoinToString$default;
            if (StringsKt.isBlank(nextActionText)) {
                nextActionText = state.getNextActionText();
            }
            NotificationCompat.Builder visibility = contentTitle.setContentText(nextActionText).setOngoing(true).setOnlyAlertOnce(true).setShowWhen(false).setLocalOnly(true).setCategory(NotificationCompat.CATEGORY_NAVIGATION).setVisibility(1);
            if (!state.isDestination() && !StringsKt.isBlank(state.getNextStation()) && !Intrinsics.areEqual(state.getNextStation(), state.getCurrentStation())) {
                visibility.addAction(0, "我已到达下一站", SmartSubwayManualAdvance.INSTANCE.createPendingIntent(context));
            }
            NotificationCompat.BigTextStyle bigContentTitle = new NotificationCompat.BigTextStyle().setBigContentTitle("当前站 " + state.getCurrentStation());
            List listListOf = CollectionsKt.listOf((Object[]) new String[]{state.getStatusText(), state.getOrigin() + " → " + state.getCurrentStation() + " → " + state.getNextStation() + " → " + state.getDestination(), state.getNextActionText()});
            ArrayList arrayList = new ArrayList();
            for (Object obj : listListOf) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            NotificationCompat.Builder progress = visibility.setStyle(bigContentTitle.bigText(CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, null, 62, null))).setProgress(1000, state.isDestination() ? 1000 : ServiceStarter.ERROR_UNKNOWN, false);
            Intrinsics.checkNotNullExpressionValue(progress, "setProgress(...)");
            Notification notificationBuild = progress.build();
            Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
            try {
                NotificationManagerCompat.from(context).notify(SMART_SUBWAY_ID, notificationBuild);
            } catch (SecurityException unused) {
            }
        }
    }

    public final void cancelTicket(Context context, int ticketId) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManagerCompat.from(context).cancel(ticketId + BASE_TICKET_ID);
    }

    public final void cancelSmartSubway(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManagerCompat.from(context).cancel(SMART_SUBWAY_ID);
    }
}
