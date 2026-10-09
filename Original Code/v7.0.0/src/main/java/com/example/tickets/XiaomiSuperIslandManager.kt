package com.example.tickets;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: XiaomiSuperIslandManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\u001d\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u001d\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0018J#\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u001bH\u0000¢\u0006\u0002\b\u001cJ\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u001d\u0010 \u001a\u00020!2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0002\b\"J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010)\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J \u0010*\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0010\u0010-\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010.\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0018\u0010/\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0005H\u0002J\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\u0005H\u0002J\u0010\u00105\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J \u00106\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00107\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u00108\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0010\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020;H\u0002J\u001d\u0010<\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010=\u001a\u00020>H\u0000¢\u0006\u0002\b?J\u0010\u0010@\u001a\u00020\u00052\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005H\u0002J\u0010\u0010C\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005H\u0002J\u0010\u0010D\u001a\u00020\u00052\u0006\u0010=\u001a\u00020>H\u0002J\u0018\u0010E\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00107\u001a\u00020!H\u0002J\u0015\u0010F\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\bGR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/example/tickets/XiaomiSuperIslandManager;", "", "<init>", "()V", "EXTRA_XIAOMI_MODE", "", "CHANNEL_BASE_ID", "CHANNEL_NAME", "BASE_NOTIFICATION_ID", "", "isXiaomiDevice", "", "notificationId", "ticketId", "createNotificationChannel", "", "context", "Landroid/content/Context;", "createNotificationChannel$app", "showTicket", "ticket", "Lcom/example/tickets/TicketData;", "showTicket$app", "cancelTicket", "cancelTicket$app", "cancelAll", "tickets", "", "cancelAll$app", "postFallbackNotification", "payload", "Lcom/example/tickets/LiveUpdatePayload;", "buildNotification", "Landroid/app/Notification;", "buildNotification$app", "payloadFromTicket", "ticketTypeName", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Lcom/example/tickets/TicketType;", "selectSmallIcon", "Landroidx/core/graphics/drawable/IconCompat;", "selectSmallIconResource", "createTicketIcon", "iconRes", "ticketType", "selectAirplaneIcon", "notificationAccentColor", "buildIslandParams", NotificationCompat.CATEGORY_STATUS, "buildOfficialProgressInfo", "Lorg/json/JSONObject;", NotificationCompat.CATEGORY_PROGRESS, "color", "realtimeProgress", "attachFocusResources", "notification", "ticketTypeNameFromPayload", "formatClock", "millis", "", "showSmartSubway", "state", "Lcom/example/tickets/SmartSubwayRealtimeState;", "showSmartSubway$app", "buildSmartSubwayIslandParams", "normalizeSmartSubwayStationName", "value", "normalizeSmartSubwayLineName", "smartSubwayDisplayTransferStation", "attachSmartSubwayFocusResources", "cancelSmartSubway", "cancelSmartSubway$app", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class XiaomiSuperIslandManager {
    public static final int $stable = 0;
    private static final int BASE_NOTIFICATION_ID = 51000;
    private static final String CHANNEL_BASE_ID = "ticket_xiaomi_super_island";
    private static final String CHANNEL_NAME = "票据 · 小米超级岛";
    public static final String EXTRA_XIAOMI_MODE = "ticket_xiaomi_mode";
    public static final XiaomiSuperIslandManager INSTANCE = new XiaomiSuperIslandManager();

    /* JADX INFO: compiled from: XiaomiSuperIslandManager.kt */
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

    public final int notificationId(int ticketId) {
        return ticketId + BASE_NOTIFICATION_ID;
    }

    private XiaomiSuperIslandManager() {
    }

    public final boolean isXiaomiDevice() {
        String str = Build.MANUFACTURER;
        if (str == null) {
            str = "";
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str2 = Build.BRAND;
        String lowerCase2 = (str2 != null ? str2 : "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        String str3 = lowerCase;
        if (StringsKt.contains$default((CharSequence) str3, (CharSequence) "xiaomi", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str3, (CharSequence) "redmi", false, 2, (Object) null)) {
            return true;
        }
        String str4 = lowerCase2;
        return StringsKt.contains$default((CharSequence) str4, (CharSequence) "xiaomi", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str4, (CharSequence) "redmi", false, 2, (Object) null);
    }

    public final void createNotificationChannel$app(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        RealtimeNotificationVisibilityController.INSTANCE.createVisibilityChannels((NotificationManager) systemService, CHANNEL_BASE_ID, CHANNEL_NAME, "票据在小米 HyperOS 上的实时行程显示", true);
    }

    public final void showTicket$app(Context context, TicketData ticket) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        createNotificationChannel$app(context);
        LiveUpdatePayload liveUpdatePayloadPayloadFromTicket = payloadFromTicket(ticket);
        if (Intrinsics.areEqual(liveUpdatePayloadPayloadFromTicket.getTicketType(), "取餐码") || Intrinsics.areEqual(liveUpdatePayloadPayloadFromTicket.getTicketType(), "取件码") || Intrinsics.areEqual(liveUpdatePayloadPayloadFromTicket.getTicketType(), "演出") || Intrinsics.areEqual(liveUpdatePayloadPayloadFromTicket.getTicketType(), "门票")) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Pair<Long, Long> pairResolveWindow = LiveUpdateManager.INSTANCE.resolveWindow(liveUpdatePayloadPayloadFromTicket);
            if (pairResolveWindow.getFirst().longValue() == Long.MAX_VALUE || jCurrentTimeMillis >= pairResolveWindow.getSecond().longValue()) {
                cancelTicket$app(context, ticket.getId());
                return;
            } else if (jCurrentTimeMillis < pairResolveWindow.getFirst().longValue()) {
                cancelTicket$app(context, ticket.getId());
                return;
            }
        }
        if (!isXiaomiDevice()) {
            postFallbackNotification(context, liveUpdatePayloadPayloadFromTicket);
            return;
        }
        if (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
            NotificationManagerCompat.from(context).notify(notificationId(ticket.getId()), buildNotification$app(context, liveUpdatePayloadPayloadFromTicket));
            Intent intent = new Intent(context, (Class<?>) LiveUpdateService.class);
            intent.setAction(LiveUpdateManager.ACTION_START);
            intent.putExtra("ticket_id", liveUpdatePayloadPayloadFromTicket.getTicketId());
            intent.putExtra("ticket_type", liveUpdatePayloadPayloadFromTicket.getTicketType());
            intent.putExtra("ticket_title", liveUpdatePayloadPayloadFromTicket.getTitle());
            intent.putExtra(LiveUpdateManager.EXTRA_CODE, liveUpdatePayloadPayloadFromTicket.getCode());
            intent.putExtra("ticket_date", liveUpdatePayloadPayloadFromTicket.getDate());
            intent.putExtra("ticket_time", liveUpdatePayloadPayloadFromTicket.getTime());
            intent.putExtra(LiveUpdateManager.EXTRA_FROM, liveUpdatePayloadPayloadFromTicket.getFrom());
            intent.putExtra(LiveUpdateManager.EXTRA_TO, liveUpdatePayloadPayloadFromTicket.getTo());
            intent.putExtra(LiveUpdateManager.EXTRA_HALL, liveUpdatePayloadPayloadFromTicket.getHall());
            intent.putExtra(LiveUpdateManager.EXTRA_AREA, liveUpdatePayloadPayloadFromTicket.getArea());
            intent.putExtra(LiveUpdateManager.EXTRA_ENTRY, liveUpdatePayloadPayloadFromTicket.getEntry());
            intent.putExtra(LiveUpdateManager.EXTRA_SEAT, liveUpdatePayloadPayloadFromTicket.getSeat());
            intent.putExtra(LiveUpdateManager.EXTRA_VENUE, liveUpdatePayloadPayloadFromTicket.getVenue());
            intent.putExtra(LiveUpdateManager.EXTRA_START_TIME, liveUpdatePayloadPayloadFromTicket.getStartTime());
            intent.putExtra(LiveUpdateManager.EXTRA_END_TIME, liveUpdatePayloadPayloadFromTicket.getEndTime());
            intent.putExtra(LiveUpdateManager.EXTRA_TAKEOFF_TIME, liveUpdatePayloadPayloadFromTicket.getTakeoffTime());
            intent.putExtra(LiveUpdateManager.EXTRA_LANDING_TIME, liveUpdatePayloadPayloadFromTicket.getLandingTime());
            intent.putExtra(EXTRA_XIAOMI_MODE, true);
            try {
                if (Build.VERSION.SDK_INT < 34 || (ContextCompat.checkSelfPermission(context, "android.permission.FOREGROUND_SERVICE") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.FOREGROUND_SERVICE_SPECIAL_USE") == 0)) {
                    ContextCompat.startForegroundService(context, intent);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void cancelTicket$app(Context context, int ticketId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, (Class<?>) LiveUpdateService.class);
        intent.setAction(LiveUpdateManager.ACTION_STOP);
        intent.putExtra("ticket_id", ticketId);
        try {
            context.startService(intent);
        } catch (Exception unused) {
        }
        NotificationManagerCompat.from(context).cancel(notificationId(ticketId));
    }

    public final void cancelAll$app(Context context, List<TicketData> tickets) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tickets, "tickets");
        Iterator<T> it = tickets.iterator();
        while (it.hasNext()) {
            INSTANCE.cancelTicket$app(context, ((TicketData) it.next()).getId());
        }
    }

    private final void postFallbackNotification(Context context, LiveUpdatePayload payload) {
        RealtimeNotificationState realtimeNotificationStateCalculate$default = RealtimeNotificationStateCalculator.calculate$default(RealtimeNotificationStateCalculator.INSTANCE, payload, 0L, 2, null);
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{realtimeNotificationStateCalculate$default.getTimeText(), realtimeNotificationStateCalculate$default.getSeatText()});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        List listListOf2 = CollectionsKt.listOf((Object[]) new String[]{realtimeNotificationStateCalculate$default.getStatusText(), realtimeNotificationStateCalculate$default.getRouteText(), CollectionsKt.joinToString$default(arrayList, "  ·  ", null, null, 0, null, null, 62, null)});
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : listListOf2) {
            if (!StringsKt.isBlank((String) obj2)) {
                arrayList2.add(obj2);
            }
        }
        Notification notificationBuild = new NotificationCompat.Builder(context, RealtimeNotificationVisibilityController.channelId$default(RealtimeNotificationVisibilityController.INSTANCE, CHANNEL_BASE_ID, null, null, 6, null)).setSmallIcon(selectSmallIcon(context, payload)).setColor(notificationAccentColor(payload.getTicketType())).setColorized(Intrinsics.areEqual(payload.getTicketType(), "机票") || Intrinsics.areEqual(payload.getTicketType(), "取餐码") || Intrinsics.areEqual(payload.getTicketType(), "取件码")).setSubText(realtimeNotificationStateCalculate$default.getTicketType()).setContentTitle(realtimeNotificationStateCalculate$default.getTitle()).setContentText(realtimeNotificationStateCalculate$default.getStatusText()).setStyle(new NotificationCompat.BigTextStyle().setBigContentTitle(realtimeNotificationStateCalculate$default.getTitle()).bigText(CollectionsKt.joinToString$default(arrayList2, "\n", null, null, 0, null, null, 62, null)).setSummaryText(realtimeNotificationStateCalculate$default.getTicketType())).setPriority(-1).setOngoing(true).setOnlyAlertOnce(true).setAutoCancel(false).setLocalOnly(true).setWhen(System.currentTimeMillis()).setShowWhen(true).setProgress(100, realtimeNotificationStateCalculate$default.getProgress(), false).build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        try {
            NotificationManagerCompat.from(context).notify(notificationId(payload.getTicketId()), notificationBuild);
        } catch (SecurityException unused) {
        }
    }

    public final Notification buildNotification$app(Context context, LiveUpdatePayload payload) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(payload, "payload");
        Notification notificationBuildNotification = LiveUpdateManager.INSTANCE.buildNotification(context, payload);
        if (Intrinsics.areEqual(payload.getTicketType(), "取餐码") || Intrinsics.areEqual(payload.getTicketType(), "取件码") || Intrinsics.areEqual(payload.getTicketType(), "演出") || Intrinsics.areEqual(payload.getTicketType(), "门票")) {
            CharSequence charSequence = notificationBuildNotification.extras.getCharSequence(NotificationCompat.EXTRA_TEXT);
            string = charSequence != null ? charSequence.toString() : null;
            if (string == null) {
                string = "";
            }
        } else {
            string = RealtimeNotificationStateCalculator.INSTANCE.calculate(payload, System.currentTimeMillis()).getStatusText();
        }
        notificationBuildNotification.extras.putString("miui.focus.param", buildIslandParams(payload, string));
        attachFocusResources(context, notificationBuildNotification, payload);
        try {
            Intent intent = new Intent(context, (Class<?>) MainActivity.class);
            intent.setAction(LiveUpdateManager.ACTION_OPEN_TICKET_V2);
            intent.putExtra("ticket_id", payload.getTicketId());
            intent.setFlags(603979776);
            notificationBuildNotification.contentIntent = PendingIntent.getActivity(context, payload.getTicketId() + 172000, intent, 201326592);
        } catch (Throwable unused) {
        }
        return notificationBuildNotification;
    }

    private final LiveUpdatePayload payloadFromTicket(TicketData ticket) {
        int id = ticket.getId();
        String strTicketTypeName = ticketTypeName(ticket.getType());
        String title = ticket.getTitle();
        String code = ticket.getCode();
        String date = ticket.getDate();
        String time = ticket.getTime();
        String departureDate = ticket.getDepartureDate();
        if (StringsKt.isBlank(departureDate)) {
            departureDate = ticket.getDate();
        }
        String str = departureDate;
        String arrivalDate = ticket.getArrivalDate();
        if (StringsKt.isBlank(arrivalDate)) {
            String departureDate2 = ticket.getDepartureDate();
            if (StringsKt.isBlank(departureDate2)) {
                departureDate2 = ticket.getDate();
            }
            arrivalDate = departureDate2;
        }
        return new LiveUpdatePayload(id, strTicketTypeName, title, code, date, time, str, arrivalDate, ticket.getFrom(), ticket.getTo(), null, null, ticket.getHall(), ticket.getSeat(), ticket.getVenue(), ticket.getArea(), ticket.getEntry(), ticket.getStartTime(), ticket.getEndTime(), ticket.getTakeoffTime(), ticket.getLandingTime(), ticket.getBrand(), 3072, null);
    }

    private final String ticketTypeName(TicketType type) {
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return "电影票";
            case 2:
                return "车票";
            case 3:
                return "机票";
            case 4:
                return "演出";
            case 5:
                return "门票";
            case 6:
                return "取餐码";
            case 7:
                return "取件码";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final IconCompat selectSmallIcon(Context context, LiveUpdatePayload payload) {
        return createTicketIcon(context, selectSmallIconResource(payload), payload.getTicketType());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        if (r0.equals("火车票") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004b, code lost:
    
        if (r0.equals("车票") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0050, code lost:
    
        return com.example.tickets.R.drawable.ic_live_train;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int selectSmallIconResource(LiveUpdatePayload payload) {
        String ticketType = payload.getTicketType();
        switch (ticketType.hashCode()) {
            case 850286:
                if (ticketType.equals("机票")) {
                    return selectAirplaneIcon(payload);
                }
                return R.drawable.ic_live_movie;
            case 902502:
                if (ticketType.equals("演出")) {
                    return R.drawable.ic_live_event;
                }
                return R.drawable.ic_live_movie;
            case 1169090:
                break;
            case 1220736:
                if (ticketType.equals("门票")) {
                    return R.drawable.ic_live_admission;
                }
                return R.drawable.ic_live_movie;
            case 21282337:
                if (ticketType.equals("取件码")) {
                    return R.drawable.ic_live_pickup;
                }
                return R.drawable.ic_live_movie;
            case 21870407:
                if (ticketType.equals("取餐码")) {
                    return R.drawable.ic_live_takeout;
                }
                return R.drawable.ic_live_movie;
            case 28825709:
                break;
            case 29623308:
                if (ticketType.equals("电影票")) {
                    return R.drawable.ic_live_movie;
                }
                return R.drawable.ic_live_movie;
            default:
                return R.drawable.ic_live_movie;
        }
    }

    private final IconCompat createTicketIcon(Context context, int iconRes, String ticketType) {
        if (!Intrinsics.areEqual(ticketType, "机票") && !Intrinsics.areEqual(ticketType, "取餐码") && !Intrinsics.areEqual(ticketType, "取件码")) {
            IconCompat iconCompatCreateWithResource = IconCompat.createWithResource(context, iconRes);
            Intrinsics.checkNotNullExpressionValue(iconCompatCreateWithResource, "createWithResource(...)");
            return iconCompatCreateWithResource;
        }
        Drawable drawable = ContextCompat.getDrawable(context, iconRes);
        if (drawable == null) {
            IconCompat iconCompatCreateWithResource2 = IconCompat.createWithResource(context, iconRes);
            Intrinsics.checkNotNullExpressionValue(iconCompatCreateWithResource2, "createWithResource(...)");
            return iconCompatCreateWithResource2;
        }
        int iMax = Math.max(drawable.getIntrinsicWidth(), Math.max(drawable.getIntrinsicHeight(), 64));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        int iSave = canvas.save();
        float f = iMax / 2.0f;
        canvas.scale(1.04f, 1.04f, f, f);
        drawable.setBounds(0, 0, iMax, iMax);
        drawable.draw(canvas);
        canvas.restoreToCount(iSave);
        IconCompat iconCompatCreateWithBitmap = IconCompat.createWithBitmap(bitmapCreateBitmap);
        Intrinsics.checkNotNullExpressionValue(iconCompatCreateWithBitmap, "createWithBitmap(...)");
        return iconCompatCreateWithBitmap;
    }

    private final int selectAirplaneIcon(LiveUpdatePayload payload) {
        Pair<Long, Long> pairResolveWindow = LiveUpdateManager.INSTANCE.resolveWindow(payload);
        long jLongValue = pairResolveWindow.component1().longValue();
        long jLongValue2 = pairResolveWindow.component2().longValue();
        Long dateTime = LiveUpdateManager.INSTANCE.parseDateTime(payload.getDate(), payload.getTakeoffTime());
        if (dateTime != null) {
            jLongValue = dateTime.longValue();
        }
        Long dateTime2 = LiveUpdateManager.INSTANCE.parseDateTime(payload.getDate(), payload.getLandingTime());
        if (dateTime2 != null) {
            if (dateTime2.longValue() <= jLongValue) {
                dateTime2 = null;
            }
            if (dateTime2 != null) {
                jLongValue2 = dateTime2.longValue();
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < jLongValue) {
            return R.drawable.ic_live_plane_departure;
        }
        if (jCurrentTimeMillis < jLongValue2) {
            return R.drawable.ic_live_plane_airborne;
        }
        return R.drawable.ic_live_plane_arrival;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        if (r2.equals("火车票") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
    
        if (r2.equals("车票") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
    
        return android.graphics.Color.rgb(90, 145, 213);
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int notificationAccentColor(String ticketType) {
        switch (ticketType.hashCode()) {
            case 850286:
                if (ticketType.equals("机票")) {
                    return Color.rgb(67, 184, 162);
                }
                return Color.rgb(74, 140, 255);
            case 902502:
                if (ticketType.equals("演出")) {
                    return Color.rgb(161, 129, 215);
                }
                return Color.rgb(74, 140, 255);
            case 1169090:
                break;
            case 1220736:
                if (ticketType.equals("门票")) {
                    return Color.rgb(211, 154, 84);
                }
                return Color.rgb(74, 140, 255);
            case 28825709:
                break;
            case 29623308:
                if (ticketType.equals("电影票")) {
                    return Color.rgb(232, 120, LocationRequestCompat.QUALITY_LOW_POWER);
                }
                return Color.rgb(74, 140, 255);
            default:
                return Color.rgb(74, 140, 255);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:215:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:217:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:221:0x0402  */
    /* JADX WARN: Code duplicated, block: B:224:0x0407  */
    /* JADX WARN: Code duplicated, block: B:225:0x0416  */
    /* JADX WARN: Code duplicated, block: B:228:0x0423  */
    /* JADX WARN: Code duplicated, block: B:230:0x042f  */
    /* JADX WARN: Code duplicated, block: B:235:0x0441  */
    /* JADX WARN: Code duplicated, block: B:238:0x0446  */
    /* JADX WARN: Code duplicated, block: B:239:0x0455  */
    /* JADX WARN: Code duplicated, block: B:242:0x0462  */
    /* JADX WARN: Code duplicated, block: B:246:0x0472  */
    /* JADX WARN: Code duplicated, block: B:249:0x0477  */
    /* JADX WARN: Code duplicated, block: B:250:0x0486  */
    /* JADX WARN: Code duplicated, block: B:254:0x0495  */
    /* JADX WARN: Code duplicated, block: B:256:0x0498  */
    /* JADX WARN: Code duplicated, block: B:257:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:261:0x04b6  */
    /* JADX WARN: Code duplicated, block: B:263:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:264:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:266:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:294:0x06c0  */
    /* JADX WARN: Code duplicated, block: B:330:0x080e  */
    /* JADX WARN: Code duplicated, block: B:332:0x0827  */
    /* JADX WARN: Code duplicated, block: B:335:0x0860  */
    /* JADX WARN: Code duplicated, block: B:338:0x086c  */
    /* JADX WARN: Code duplicated, block: B:347:0x090d  */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x06d7, code lost:
    
        if (r5.equals("火车票") == false) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x07f5, code lost:
    
        if (r5.equals("车票") == false) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x07f9, code lost:
    
        r11 = r29;
        r19 = "picInfo";
        r8 = r6;
        r5 = 2;
        r20 = "miui.focus.pic_ticket";
     */
    /* JADX WARN: Instruction removed from duplicated block: B:224:0x0407, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:238:0x0446, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:249:0x0477, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:256:0x0498, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:263:0x04b9, please report this as an issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String buildIslandParams(LiveUpdatePayload payload, String status) throws JSONException {
        String title;
        List listEmptyList;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String startTime;
        String str11;
        String str12;
        if (Intrinsics.areEqual(payload.getTicketType(), "车票") || Intrinsics.areEqual(payload.getTicketType(), "机票")) {
            String code = payload.getCode();
            if (StringsKt.isBlank(code)) {
                code = payload.getTitle();
            }
            title = code;
        } else {
            title = payload.getTitle();
        }
        String str13 = title;
        if (StringsKt.isBlank(str13)) {
            str13 = "票据";
        }
        String str14 = str13;
        String str15 = (StringsKt.isBlank(payload.getFrom()) || StringsKt.isBlank(payload.getTo())) ? "" : payload.getFrom() + " → " + payload.getTo();
        switch (payload.getTicketType()) {
            case "机票":
                String departureDate = payload.getDepartureDate();
                if (StringsKt.isBlank(departureDate)) {
                    departureDate = payload.getDate();
                }
                if (StringsKt.isBlank(departureDate)) {
                    departureDate = null;
                }
                String str16 = departureDate;
                if (str16 != null) {
                    str = "出发日期 " + str16;
                } else {
                    str = null;
                }
                String arrivalDate = payload.getArrivalDate();
                if (StringsKt.isBlank(arrivalDate)) {
                    String departureDate2 = payload.getDepartureDate();
                    if (StringsKt.isBlank(departureDate2)) {
                        departureDate2 = payload.getDate();
                    }
                    arrivalDate = departureDate2;
                }
                if (StringsKt.isBlank(arrivalDate)) {
                    arrivalDate = null;
                }
                String str17 = arrivalDate;
                if (str17 != null) {
                    str2 = "到达日期 " + str17;
                } else {
                    str2 = null;
                }
                String startTime2 = payload.getStartTime();
                if (StringsKt.isBlank(startTime2)) {
                    startTime2 = payload.getTime();
                }
                if (StringsKt.isBlank(startTime2)) {
                    startTime2 = null;
                }
                String str18 = startTime2;
                if (str18 != null) {
                    str3 = "出发 " + str18;
                } else {
                    str3 = null;
                }
                String endTime = payload.getEndTime();
                if (StringsKt.isBlank(endTime)) {
                    endTime = null;
                }
                if (endTime != null) {
                    str4 = "到达 " + endTime;
                } else {
                    str4 = null;
                }
                String seat = payload.getSeat();
                if (StringsKt.isBlank(seat)) {
                    seat = null;
                }
                if (seat != null) {
                    str5 = "座位 " + seat;
                } else {
                    str5 = null;
                }
                listEmptyList = CollectionsKt.listOf((Object[]) new String[]{str, str2, str3, str4, str5});
                break;
            case "演出":
                String startTime3 = payload.getStartTime();
                if (StringsKt.isBlank(startTime3)) {
                    startTime3 = payload.getTime();
                }
                if (StringsKt.isBlank(startTime3)) {
                    startTime3 = null;
                }
                String str19 = startTime3;
                String str20 = str19 != null ? "时间 " + str19 : null;
                String venue = payload.getVenue();
                if (StringsKt.isBlank(venue)) {
                    venue = null;
                }
                String str21 = venue != null ? "地点 " + venue : null;
                String area = payload.getArea();
                if (StringsKt.isBlank(area)) {
                    area = null;
                }
                String str22 = area != null ? "区域 " + area : null;
                String seat2 = payload.getSeat();
                if (StringsKt.isBlank(seat2)) {
                    seat2 = null;
                }
                listEmptyList = CollectionsKt.listOf((Object[]) new String[]{str20, str21, str22, seat2 != null ? "座位 " + seat2 : null});
                break;
            case "车票":
                String departureDate3 = payload.getDepartureDate();
                if (StringsKt.isBlank(departureDate3)) {
                    departureDate3 = payload.getDate();
                }
                if (StringsKt.isBlank(departureDate3)) {
                    departureDate3 = null;
                }
                String str110 = departureDate3;
                if (str110 != null) {
                    str = "出发日期 " + str110;
                } else {
                    str = null;
                }
                String arrivalDate2 = payload.getArrivalDate();
                if (StringsKt.isBlank(arrivalDate2)) {
                    String departureDate4 = payload.getDepartureDate();
                    if (StringsKt.isBlank(departureDate4)) {
                        departureDate4 = payload.getDate();
                    }
                    arrivalDate2 = departureDate4;
                }
                if (StringsKt.isBlank(arrivalDate2)) {
                    arrivalDate2 = null;
                }
                String str111 = arrivalDate2;
                if (str111 != null) {
                    str2 = "到达日期 " + str111;
                } else {
                    str2 = null;
                }
                String startTime4 = payload.getStartTime();
                if (StringsKt.isBlank(startTime4)) {
                    startTime4 = payload.getTime();
                }
                if (StringsKt.isBlank(startTime4)) {
                    startTime4 = null;
                }
                String str112 = startTime4;
                if (str112 != null) {
                    str3 = "出发 " + str112;
                } else {
                    str3 = null;
                }
                String endTime2 = payload.getEndTime();
                if (StringsKt.isBlank(endTime2)) {
                    endTime2 = null;
                }
                if (endTime2 != null) {
                    str4 = "到达 " + endTime2;
                } else {
                    str4 = null;
                }
                String seat3 = payload.getSeat();
                if (StringsKt.isBlank(seat3)) {
                    seat3 = null;
                }
                if (seat3 != null) {
                    str5 = "座位 " + seat3;
                } else {
                    str5 = null;
                }
                listEmptyList = CollectionsKt.listOf((Object[]) new String[]{str, str2, str3, str4, str5});
                break;
            case "门票":
                String time = payload.getTime();
                if (StringsKt.isBlank(time)) {
                    time = null;
                }
                String str23 = time != null ? "时间 " + time : null;
                String venue2 = payload.getVenue();
                if (StringsKt.isBlank(venue2)) {
                    venue2 = null;
                }
                String str24 = venue2 != null ? "地点 " + venue2 : null;
                String entry = payload.getEntry();
                if (StringsKt.isBlank(entry)) {
                    entry = null;
                }
                String str25 = entry != null ? "入口 " + entry : null;
                String seat4 = payload.getSeat();
                if (StringsKt.isBlank(seat4)) {
                    seat4 = null;
                }
                listEmptyList = CollectionsKt.listOf((Object[]) new String[]{str23, str24, str25, seat4 != null ? "座位 " + seat4 : null});
                break;
            case "取件码":
                String brand = payload.getBrand();
                if (StringsKt.isBlank(brand)) {
                    brand = null;
                }
                String str26 = brand != null ? "品牌 " + brand : null;
                String code2 = payload.getCode();
                if (StringsKt.isBlank(code2)) {
                    code2 = null;
                }
                String str27 = code2 != null ? "取码 " + code2 : null;
                String date = payload.getDate();
                if (StringsKt.isBlank(date)) {
                    date = null;
                }
                String str28 = date != null ? "日期 " + date : null;
                String venue3 = payload.getVenue();
                if (StringsKt.isBlank(venue3)) {
                    venue3 = null;
                }
                listEmptyList = CollectionsKt.listOf((Object[]) new String[]{str26, str27, str28, venue3 != null ? "地点 " + venue3 : null});
                break;
            case "取餐码":
                String brand2 = payload.getBrand();
                if (StringsKt.isBlank(brand2)) {
                    brand2 = null;
                }
                String str29 = brand2 != null ? "品牌 " + brand2 : null;
                String code3 = payload.getCode();
                if (StringsKt.isBlank(code3)) {
                    code3 = null;
                }
                String str30 = code3 != null ? "取码 " + code3 : null;
                String date2 = payload.getDate();
                if (StringsKt.isBlank(date2)) {
                    date2 = null;
                }
                String str31 = date2 != null ? "日期 " + date2 : null;
                String time2 = payload.getTime();
                if (StringsKt.isBlank(time2)) {
                    time2 = null;
                }
                String str32 = time2 != null ? "时间 " + time2 : null;
                String venue4 = payload.getVenue();
                if (StringsKt.isBlank(venue4)) {
                    venue4 = null;
                }
                listEmptyList = CollectionsKt.listOf((Object[]) new String[]{str29, str30, str31, str32, venue4 != null ? "地点 " + venue4 : null});
                break;
            case "火车票":
                String departureDate5 = payload.getDepartureDate();
                if (StringsKt.isBlank(departureDate5)) {
                    departureDate5 = payload.getDate();
                }
                if (StringsKt.isBlank(departureDate5)) {
                    departureDate5 = null;
                }
                String str113 = departureDate5;
                if (str113 != null) {
                    str = "出发日期 " + str113;
                } else {
                    str = null;
                }
                String arrivalDate3 = payload.getArrivalDate();
                if (StringsKt.isBlank(arrivalDate3)) {
                    String departureDate6 = payload.getDepartureDate();
                    if (StringsKt.isBlank(departureDate6)) {
                        departureDate6 = payload.getDate();
                    }
                    arrivalDate3 = departureDate6;
                }
                if (StringsKt.isBlank(arrivalDate3)) {
                    arrivalDate3 = null;
                }
                String str114 = arrivalDate3;
                if (str114 != null) {
                    str2 = "到达日期 " + str114;
                } else {
                    str2 = null;
                }
                String startTime5 = payload.getStartTime();
                if (StringsKt.isBlank(startTime5)) {
                    startTime5 = payload.getTime();
                }
                if (StringsKt.isBlank(startTime5)) {
                    startTime5 = null;
                }
                String str115 = startTime5;
                if (str115 != null) {
                    str3 = "出发 " + str115;
                } else {
                    str3 = null;
                }
                String endTime3 = payload.getEndTime();
                if (StringsKt.isBlank(endTime3)) {
                    endTime3 = null;
                }
                if (endTime3 != null) {
                    str4 = "到达 " + endTime3;
                } else {
                    str4 = null;
                }
                String seat5 = payload.getSeat();
                if (StringsKt.isBlank(seat5)) {
                    seat5 = null;
                }
                if (seat5 != null) {
                    str5 = "座位 " + seat5;
                } else {
                    str5 = null;
                }
                listEmptyList = CollectionsKt.listOf((Object[]) new String[]{str, str2, str3, str4, str5});
                break;
            case "电影票":
                String date3 = payload.getDate();
                if (StringsKt.isBlank(date3)) {
                    date3 = null;
                }
                String str33 = date3 != null ? "日期 " + date3 : null;
                String startTime6 = payload.getStartTime();
                if (StringsKt.isBlank(startTime6)) {
                    startTime6 = payload.getTime();
                }
                if (StringsKt.isBlank(startTime6)) {
                    startTime6 = null;
                }
                String str34 = startTime6;
                String str35 = str34 != null ? "开始 " + str34 : null;
                String endTime4 = payload.getEndTime();
                if (StringsKt.isBlank(endTime4)) {
                    endTime4 = null;
                }
                String str36 = endTime4 != null ? "结束 " + endTime4 : null;
                String hall = payload.getHall();
                if (StringsKt.isBlank(hall)) {
                    hall = null;
                }
                String str37 = hall != null ? "影厅 " + hall : null;
                String seat6 = payload.getSeat();
                if (StringsKt.isBlank(seat6)) {
                    seat6 = null;
                }
                listEmptyList = CollectionsKt.listOf((Object[]) new String[]{str33, str35, str36, str37, seat6 != null ? "座位 " + seat6 : null});
                break;
            default:
                listEmptyList = CollectionsKt.emptyList();
                break;
        }
        List listFilterNotNull = CollectionsKt.filterNotNull(listEmptyList);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listFilterNotNull) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, "  ·  ", null, null, 0, null, null, 62, null);
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{status, str15, strJoinToString$default});
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : listListOf) {
            if (!StringsKt.isBlank((String) obj2)) {
                arrayList2.add(obj2);
            }
        }
        String strJoinToString$default2 = CollectionsKt.joinToString$default(arrayList2, "  ·  ", null, null, 0, null, null, 62, null);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectPut = new JSONObject().put("protocol", 1).put("business", "ticket").put("enableFloat", true).put("updatable", true).put("timeout", 720);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str38 = String.format(Locale.US, "#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(notificationAccentColor(payload.getTicketType()) & ViewCompat.MEASURED_SIZE_MASK)}, 1));
        Intrinsics.checkNotNullExpressionValue(str38, "format(...)");
        JSONObject jSONObjectPut2 = new JSONObject().put("islandProperty", 1).put("islandTimeout", 3600);
        String ticketType = payload.getTicketType();
        if (Intrinsics.areEqual(ticketType, "取餐码")) {
            String code4 = payload.getCode();
            if (StringsKt.isBlank(code4)) {
                code4 = str14;
            }
            str6 = code4;
        } else if (Intrinsics.areEqual(ticketType, "取件码")) {
            String code5 = payload.getCode();
            if (StringsKt.isBlank(code5)) {
                code5 = str14;
            }
            str6 = code5;
        } else {
            str6 = str14;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        String str39 = str15;
        jSONObject3.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 6);
        String str40 = "miui.focus.pic_ticket";
        jSONObject3.put("picInfo", new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1).put("pic", "miui.focus.pic_ticket"));
        jSONObject3.put("textInfo", new JSONObject().put("title", str6).put("showHighlightColor", true));
        Unit unit = Unit.INSTANCE;
        jSONObject2.put("imageTextInfoRight", jSONObject3);
        Unit unit2 = Unit.INSTANCE;
        jSONObjectPut2.put("smallIslandArea", jSONObject2);
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
        jSONObject5.put("picInfo", new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1).put("pic", "miui.focus.pic_ticket"));
        jSONObject5.put("textInfo", new JSONObject().put("title", str14).put("content", strJoinToString$default2).put("showHighlightColor", true));
        Unit unit3 = Unit.INSTANCE;
        jSONObject4.put("imageTextInfoLeft", jSONObject5);
        Unit unit4 = Unit.INSTANCE;
        jSONObjectPut2.put("bigIslandArea", jSONObject4);
        JSONObject jSONObject6 = new JSONObject();
        String ticketType2 = payload.getTicketType();
        switch (ticketType2.hashCode()) {
            case 850286:
                String str41 = "miui.focus.pic_ticket";
                String str42 = "picInfo";
                str7 = strJoinToString$default;
                str8 = status;
                if (ticketType2.equals("机票")) {
                    int i = 2;
                    jSONObject6.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, i).put("title", str14).put("subTitle", str8).put("content", str39).put("subContent", str7).put("colorTitle", str38);
                    jSONObjectPut.put("baseInfo", jSONObject6);
                    jSONObjectPut.put(str42, new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1).put("pic", str41));
                    jSONObjectPut.put("progressInfo", buildOfficialProgressInfo(realtimeProgress(payload), str38));
                } else {
                    str9 = str42;
                    str40 = str41;
                    JSONObject jSONObjectPut3 = jSONObject6.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2).put("title", str14).put("subTitle", str8);
                    str12 = str7;
                    if (StringsKt.isBlank(str12)) {
                        str12 = strJoinToString$default2;
                    }
                    jSONObjectPut3.put("content", str12).put("colorTitle", str38);
                    jSONObjectPut.put("baseInfo", jSONObject6);
                    jSONObjectPut.put(str9, new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1).put("pic", str40));
                }
                break;
            case 902502:
                if (ticketType2.equals("演出")) {
                    JSONObject jSONObjectPut4 = jSONObject6.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2).put("title", str14).put("subTitle", status);
                    str10 = str39;
                    if (StringsKt.isBlank(str10)) {
                        str10 = strJoinToString$default;
                    }
                    jSONObjectPut4.put("content", str10).put("subContent", strJoinToString$default).put("colorTitle", str38);
                    jSONObjectPut.put("baseInfo", jSONObject6);
                    jSONObjectPut.put("picInfo", new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1).put("pic", "miui.focus.pic_ticket"));
                    JSONObject jSONObjectPut5 = new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                    startTime = payload.getStartTime();
                    if (StringsKt.isBlank(startTime)) {
                        startTime = payload.getTime();
                    }
                    str11 = startTime;
                    if (StringsKt.isBlank(str11)) {
                        str11 = status;
                    }
                    jSONObjectPut.put("hintInfo", jSONObjectPut5.put("title", str11).put("subTitle", payload.getSeat()).put("content", "时间").put("subContent", "座位").put("actionInfo", new JSONObject().put("action", "miui.focus.action_ticket")));
                } else {
                    str8 = status;
                    str9 = "picInfo";
                    str7 = strJoinToString$default;
                    JSONObject jSONObjectPut6 = jSONObject6.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2).put("title", str14).put("subTitle", str8);
                    str12 = str7;
                    if (StringsKt.isBlank(str12)) {
                        str12 = strJoinToString$default2;
                    }
                    jSONObjectPut6.put("content", str12).put("colorTitle", str38);
                    jSONObjectPut.put("baseInfo", jSONObject6);
                    jSONObjectPut.put(str9, new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1).put("pic", str40));
                }
                break;
            case 1169090:
                break;
            case 21282337:
                if (ticketType2.equals("取件码")) {
                    JSONObject jSONObjectPut7 = jSONObject6.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                    String str43 = status;
                    if (StringsKt.isBlank(str43)) {
                        str43 = "待取件";
                    }
                    jSONObjectPut7.put("title", str43).put("subTitle", payload.getCode()).put("content", payload.getBrand()).put("subContent", payload.getVenue()).put("colorTitle", str38);
                    jSONObjectPut.put("baseInfo", jSONObject6);
                    jSONObjectPut.put("picInfo", new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1).put("pic", "miui.focus.pic_ticket"));
                    JSONObject jSONObjectPut8 = new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
                    String code6 = payload.getCode();
                    JSONObject jSONObjectPut9 = jSONObjectPut8.put("title", StringsKt.isBlank(code6) ? "取件码" : code6);
                    String brand3 = payload.getBrand();
                    if (StringsKt.isBlank(brand3)) {
                        String venue5 = payload.getVenue();
                        if (StringsKt.isBlank(venue5)) {
                            venue5 = "取件";
                        }
                        brand3 = venue5;
                    }
                    jSONObjectPut.put("hintInfo", jSONObjectPut9.put("content", brand3).put("colorTitle", str38).put("colorTitleDark", "#FFFFFF").put("colorContent", str38).put("colorContentDark", "#FFFFFF").put("actionInfo", new JSONObject().put("action", "miui.focus.action_ticket")));
                } else {
                    str8 = status;
                    str9 = "picInfo";
                    str7 = strJoinToString$default;
                    JSONObject jSONObjectPut10 = jSONObject6.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2).put("title", str14).put("subTitle", str8);
                    str12 = str7;
                    if (StringsKt.isBlank(str12)) {
                        str12 = strJoinToString$default2;
                    }
                    jSONObjectPut10.put("content", str12).put("colorTitle", str38);
                    jSONObjectPut.put("baseInfo", jSONObject6);
                    jSONObjectPut.put(str9, new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1).put("pic", str40));
                }
                break;
            case 21870407:
                if (ticketType2.equals("取餐码")) {
                    jSONObject6.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1).put("title", str14).put("subTitle", payload.getCode()).put("content", payload.getBrand()).put("colorTitle", str38);
                    jSONObjectPut.put("baseInfo", jSONObject6);
                    jSONObjectPut.put("picInfo", new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1).put("pic", "miui.focus.pic_ticket"));
                    jSONObjectPut.put("progressInfo", new JSONObject().put(NotificationCompat.CATEGORY_PROGRESS, realtimeProgress(payload)).put("colorProgress", str38).put("colorProgressEnd", str38));
                } else {
                    str8 = status;
                    str9 = "picInfo";
                    str7 = strJoinToString$default;
                    JSONObject jSONObjectPut11 = jSONObject6.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2).put("title", str14).put("subTitle", str8);
                    str12 = str7;
                    if (StringsKt.isBlank(str12)) {
                        str12 = strJoinToString$default2;
                    }
                    jSONObjectPut11.put("content", str12).put("colorTitle", str38);
                    jSONObjectPut.put("baseInfo", jSONObject6);
                    jSONObjectPut.put(str9, new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1).put("pic", str40));
                }
                break;
            case 28825709:
                break;
            case 29623308:
                if (ticketType2.equals("电影票")) {
                    JSONObject jSONObjectPut12 = jSONObject6.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2).put("title", str14).put("subTitle", status);
                    str10 = str39;
                    if (StringsKt.isBlank(str10)) {
                        str10 = strJoinToString$default;
                    }
                    jSONObjectPut12.put("content", str10).put("subContent", strJoinToString$default).put("colorTitle", str38);
                    jSONObjectPut.put("baseInfo", jSONObject6);
                    jSONObjectPut.put("picInfo", new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1).put("pic", "miui.focus.pic_ticket"));
                    JSONObject jSONObjectPut13 = new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                    startTime = payload.getStartTime();
                    if (StringsKt.isBlank(startTime)) {
                        startTime = payload.getTime();
                    }
                    str11 = startTime;
                    if (StringsKt.isBlank(str11)) {
                        str11 = status;
                    }
                    jSONObjectPut.put("hintInfo", jSONObjectPut13.put("title", str11).put("subTitle", payload.getSeat()).put("content", "时间").put("subContent", "座位").put("actionInfo", new JSONObject().put("action", "miui.focus.action_ticket")));
                } else {
                    str8 = status;
                    str9 = "picInfo";
                    str7 = strJoinToString$default;
                    JSONObject jSONObjectPut14 = jSONObject6.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2).put("title", str14).put("subTitle", str8);
                    str12 = str7;
                    if (StringsKt.isBlank(str12)) {
                        str12 = strJoinToString$default2;
                    }
                    jSONObjectPut14.put("content", str12).put("colorTitle", str38);
                    jSONObjectPut.put("baseInfo", jSONObject6);
                    jSONObjectPut.put(str9, new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1).put("pic", str40));
                }
                break;
            default:
                str8 = status;
                str9 = "picInfo";
                str7 = strJoinToString$default;
                JSONObject jSONObjectPut15 = jSONObject6.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2).put("title", str14).put("subTitle", str8);
                str12 = str7;
                if (StringsKt.isBlank(str12)) {
                    str12 = strJoinToString$default2;
                }
                jSONObjectPut15.put("content", str12).put("colorTitle", str38);
                jSONObjectPut.put("baseInfo", jSONObject6);
                jSONObjectPut.put(str9, new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1).put("pic", str40));
                break;
        }
        jSONObjectPut.put("param_island", jSONObjectPut2);
        jSONObject.put("param_v2", jSONObjectPut);
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final JSONObject buildOfficialProgressInfo(int progress, String color) throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put(NotificationCompat.CATEGORY_PROGRESS, RangesKt.coerceIn(progress, 0, 100)).put("colorProgress", color).put("colorProgressEnd", color).put("picForward", "miui.focus.pic_forward_v2").put("picMiddle", "miui.focus.pic_middle_v2").put("picMiddleUnselected", "miui.focus.pic_middle_unselected_v2").put("picEnd", "miui.focus.pic_end_v2").put("picEndUnselected", "miui.focus.pic_end_unselected_v2");
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "put(...)");
        return jSONObjectPut;
    }

    private final int realtimeProgress(LiveUpdatePayload payload) {
        return RangesKt.coerceIn(RealtimeNotificationStateCalculator.INSTANCE.calculate(payload, System.currentTimeMillis()).getProgress(), 0, 100);
    }

    private final void attachFocusResources(Context context, Notification notification, LiveUpdatePayload payload) {
        int iSelectSmallIconResource = selectSmallIconResource(payload);
        Bundle bundle = notification.extras.getBundle("miui.focus.pics");
        if (bundle == null) {
            bundle = new Bundle();
        }
        attachFocusResources$addPic(bundle, context, "miui.focus.pic_ticket", iSelectSmallIconResource);
        if (Intrinsics.areEqual(payload.getTicketType(), "车票") || Intrinsics.areEqual(payload.getTicketType(), "火车票") || Intrinsics.areEqual(payload.getTicketType(), "机票")) {
            attachFocusResources$addPic(bundle, context, "miui.focus.pic_forward_v2", iSelectSmallIconResource);
            attachFocusResources$addPic(bundle, context, "miui.focus.pic_middle_v2", iSelectSmallIconResource);
            attachFocusResources$addPic(bundle, context, "miui.focus.pic_middle_unselected_v2", iSelectSmallIconResource);
            attachFocusResources$addPic(bundle, context, "miui.focus.pic_end_v2", iSelectSmallIconResource);
            attachFocusResources$addPic(bundle, context, "miui.focus.pic_end_unselected_v2", iSelectSmallIconResource);
        }
        notification.extras.putBundle("miui.focus.pics", bundle);
        if (Intrinsics.areEqual(payload.getTicketType(), "电影票") || Intrinsics.areEqual(payload.getTicketType(), "演出") || Intrinsics.areEqual(payload.getTicketType(), "取件码")) {
            Bundle bundle2 = notification.extras.getBundle("miui.focus.actions");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            Intent intent = new Intent(context, (Class<?>) MainActivity.class);
            intent.setAction(LiveUpdateManager.ACTION_OPEN_TICKET_V2);
            intent.putExtra("ticket_id", payload.getTicketId());
            intent.setFlags(603979776);
            bundle2.putParcelable("miui.focus.action_ticket", new Notification.Action.Builder(Icon.createWithResource(context, selectSmallIconResource(payload)), Intrinsics.areEqual(payload.getTicketType(), "取件码") ? "打开取件码" : "打开票据", PendingIntent.getActivity(context, payload.getTicketId() + 183000, intent, 201326592)).build());
            notification.extras.putBundle("miui.focus.actions", bundle2);
        }
    }

    private static final void attachFocusResources$addPic(Bundle bundle, Context context, String str, int i) {
        bundle.putParcelable(str, Icon.createWithResource(context, i));
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002e A[RETURN] */
    private final String ticketTypeNameFromPayload(String ticketType) {
        switch (ticketType.hashCode()) {
            case 850286:
                return !ticketType.equals("机票") ? "票据" : "机票";
            case 902502:
                return !ticketType.equals("演出") ? "票据" : "演出";
            case 1169090:
                if (ticketType.equals("车票")) {
                    return "车票";
                }
                return "票据";
            case 1220736:
                return !ticketType.equals("门票") ? "票据" : "门票";
            case 28825709:
                if (ticketType.equals("火车票")) {
                    return "车票";
                }
                return "票据";
            case 29623308:
                return !ticketType.equals("电影票") ? "票据" : "电影票";
            default:
                return "票据";
        }
    }

    private final String formatClock(long millis) {
        String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(millis));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final boolean showSmartSubway$app(Context context, SmartSubwayRealtimeState state) {
        Object objM9536constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(state, "state");
        if (!isXiaomiDevice()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 33 && ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") != 0) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            XiaomiSuperIslandManager xiaomiSuperIslandManager = this;
            Object systemService = context.getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            RealtimeNotificationVisibilityController.INSTANCE.createVisibilityChannels((NotificationManager) systemService, CHANNEL_BASE_ID, CHANNEL_NAME, "智能地铁 · 小米超级岛实时通知", false);
            SmartSubwayHorizontalCardContent smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent = SmartSubwayRealtimeKt.buildSmartSubwayHorizontalCardContent(state);
            NotificationCompat.Builder category = new NotificationCompat.Builder(context, RealtimeNotificationVisibilityController.channelId$default(RealtimeNotificationVisibilityController.INSTANCE, CHANNEL_BASE_ID, null, null, 6, null)).setSmallIcon(R.mipmap.ic_launcher).setContentTitle(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getCurrentStation()).setContentText(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getLineSummary()).setOngoing(true).setOnlyAlertOnce(true).setShowWhen(false).setCategory(NotificationCompat.CATEGORY_NAVIGATION);
            if (!state.isDestination() && !StringsKt.isBlank(state.getNextStation()) && !StringsKt.equals(state.getNextStation(), state.getCurrentStation(), true)) {
                category.addAction(R.drawable.ic_live_train, "我已到达下一站", SmartSubwayManualAdvance.INSTANCE.createPendingIntent(context));
            }
            Notification notificationBuild = category.build();
            Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
            notificationBuild.extras.putString("miui.focus.param", buildSmartSubwayIslandParams(state));
            attachSmartSubwayFocusResources(context, notificationBuild);
            NotificationManagerCompat.from(context).notify(SmartSubwayNotificationSpec.NOTIFICATION_ID, notificationBuild);
            objM9536constructorimpl = Result.m9536constructorimpl(true);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
            objM9536constructorimpl = false;
        }
        return ((Boolean) objM9536constructorimpl).booleanValue();
    }

    private final String buildSmartSubwayIslandParams(SmartSubwayRealtimeState state) throws JSONException {
        String str;
        int primaryLineColor;
        String currentStation = state.getCurrentStation();
        if (StringsKt.isBlank(currentStation)) {
            currentStation = "等待定位";
        }
        String str2 = currentStation;
        String lineName = state.getLineName();
        String destination = state.getDestination();
        if (StringsKt.isBlank(destination)) {
            destination = null;
        }
        List listFilterNotNull = CollectionsKt.filterNotNull(CollectionsKt.listOf((Object[]) new String[]{lineName, destination != null ? "→ " + destination : null}));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listFilterNotNull) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, "  ·  ", null, null, 0, null, null, 62, null);
        String strSmartSubwayDisplayTransferStation = smartSubwayDisplayTransferStation(state);
        boolean z = !StringsKt.isBlank(strSmartSubwayDisplayTransferStation) && Intrinsics.areEqual(normalizeSmartSubwayStationName(str2), normalizeSmartSubwayStationName(strSmartSubwayDisplayTransferStation));
        if (state.isDestination()) {
            str = "已到达目的地";
        } else if (z && !StringsKt.isBlank(state.getTransferLineName())) {
            str = "准备换乘" + state.getTransferLineName();
        } else if (z) {
            str = "准备换乘";
        } else {
            str = "行程进行中";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        if (SmartSubwayRealtimeKt.isAfterTransfer(state)) {
            primaryLineColor = state.getSecondaryLineColor();
        } else {
            primaryLineColor = state.getPrimaryLineColor();
        }
        String str3 = String.format(locale, "#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(primaryLineColor & ViewCompat.MEASURED_SIZE_MASK)}, 1));
        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectPut = new JSONObject().put("protocol", 1).put("business", "travel").put("enableFloat", true).put("updatable", true).put("timeout", 720);
        JSONObject jSONObjectPut2 = new JSONObject().put("islandProperty", 1).put("islandTimeout", 3600);
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 6);
        jSONObject3.put("picInfo", new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1).put("pic", "miui.focus.pic_smart_subway"));
        jSONObject3.put("textInfo", new JSONObject().put("title", str2).put("showHighlightColor", true));
        Unit unit = Unit.INSTANCE;
        jSONObject2.put("imageTextInfoRight", jSONObject3);
        Unit unit2 = Unit.INSTANCE;
        jSONObjectPut2.put("smallIslandArea", jSONObject2);
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
        jSONObject5.put("picInfo", new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1).put("pic", "miui.focus.pic_smart_subway"));
        jSONObject5.put("textInfo", new JSONObject().put("title", str2).put("content", strJoinToString$default).put("showHighlightColor", true));
        Unit unit3 = Unit.INSTANCE;
        jSONObject4.put("imageTextInfoLeft", jSONObject5);
        Unit unit4 = Unit.INSTANCE;
        jSONObjectPut2.put("bigIslandArea", jSONObject4);
        jSONObjectPut.put("baseInfo", new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2).put("title", str2).put("subTitle", strJoinToString$default).put("content", str).put("colorTitle", str3));
        jSONObjectPut.put("picInfo", new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1).put("pic", "miui.focus.pic_smart_subway"));
        int iRint = state.isDestination() ? 100 : ((int) Math.rint(RangesKt.coerceIn(state.getSegmentProgress(), 0.0f, 1.0f) * 50.0f)) + 50;
        JSONObject jSONObject6 = new JSONObject();
        if (!StringsKt.isBlank(str)) {
            str2 = str2 + " · " + str;
        }
        jSONObjectPut.put("multiProgressInfo", jSONObject6.put("title", str2).put(NotificationCompat.CATEGORY_PROGRESS, RangesKt.coerceIn(iRint, 0, 100)).put("color", str3).put("points", 3));
        jSONObjectPut.put("param_island", jSONObjectPut2);
        jSONObject.put("param_v2", jSONObjectPut);
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final String normalizeSmartSubwayStationName(String value) {
        return new Regex("\\s+").replace(StringsKt.trim((CharSequence) value).toString(), "");
    }

    private final String normalizeSmartSubwayLineName(String value) {
        return StringsKt.trim((CharSequence) StringsKt.replace(StringsKt.removeSuffix(StringsKt.trim((CharSequence) value).toString(), (CharSequence) "号线"), "Line", "", true)).toString();
    }

    private final String smartSubwayDisplayTransferStation(SmartSubwayRealtimeState state) {
        if (!Intrinsics.areEqual(state.getCityId(), "wuhan")) {
            return state.getTransferStation();
        }
        Set of = SetsKt.setOf((Object[]) new String[]{normalizeSmartSubwayLineName(state.getLineName()), normalizeSmartSubwayLineName(state.getTransferLineName())});
        if (Intrinsics.areEqual(of, SetsKt.setOf((Object[]) new String[]{"5", ExifInterface.GPS_MEASUREMENT_2D}))) {
            return "积玉桥";
        }
        if (Intrinsics.areEqual(of, SetsKt.setOf((Object[]) new String[]{"5", "4"}))) {
            return "复兴路";
        }
        if (Intrinsics.areEqual(of, SetsKt.setOf((Object[]) new String[]{"5", "7"})) || Intrinsics.areEqual(of, SetsKt.setOf((Object[]) new String[]{"5", "8"}))) {
            return "徐家棚";
        }
        if (Intrinsics.areEqual(of, SetsKt.setOf((Object[]) new String[]{"5", "12"}))) {
            return "科普公园";
        }
        return Intrinsics.areEqual(of, SetsKt.setOf((Object[]) new String[]{"5", "19"})) ? "武汉站东广场" : state.getTransferStation();
    }

    private final void attachSmartSubwayFocusResources(Context context, Notification notification) {
        Bundle bundle = notification.extras.getBundle("miui.focus.pics");
        if (bundle == null) {
            bundle = new Bundle();
        }
        int i = R.mipmap.ic_launcher;
        Iterator it = CollectionsKt.listOf((Object[]) new String[]{"miui.focus.pic_smart_subway", "miui.focus.pic_forward_v2", "miui.focus.pic_middle_v2", "miui.focus.pic_middle_unselected_v2", "miui.focus.pic_end_v2", "miui.focus.pic_end_unselected_v2"}).iterator();
        while (it.hasNext()) {
            bundle.putParcelable((String) it.next(), Icon.createWithResource(context, i));
        }
        notification.extras.putBundle("miui.focus.pics", bundle);
    }

    public final void cancelSmartSubway$app(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            XiaomiSuperIslandManager xiaomiSuperIslandManager = this;
            NotificationManagerCompat.from(context).cancel(SmartSubwayNotificationSpec.NOTIFICATION_ID);
            Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
    }
}
