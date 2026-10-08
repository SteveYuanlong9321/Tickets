package com.example.tickets;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.material3.internal.CalendarModelKt;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.messaging.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LiveUpdateManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)JÔ\u0001\u0010*\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00052\b\b\u0002\u00105\u001a\u00020\u00052\b\b\u0002\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00052\b\b\u0002\u0010:\u001a\u00020\u00052\b\b\u0002\u0010;\u001a\u00020\u00052\b\b\u0002\u0010<\u001a\u00020\u00052\b\b\u0002\u0010=\u001a\u00020\u00052\b\b\u0002\u0010>\u001a\u00020\u00052\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u0005J \u0010A\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0002J\u0018\u0010F\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010+\u001a\u00020#H\u0002J\u0018\u0010G\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010B\u001a\u00020CH\u0002J\u0016\u0010H\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010+\u001a\u00020#J\u001c\u0010I\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020#0KJ\u000e\u0010L\u001a\u00020#2\u0006\u0010+\u001a\u00020#J\u000e\u0010M\u001a\u00020N2\u0006\u0010,\u001a\u00020\u0005J\u000e\u0010O\u001a\u00020C2\u0006\u0010P\u001a\u00020QJ\u0010\u0010R\u001a\u00020N2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u001a\u0010S\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020E0T2\u0006\u0010B\u001a\u00020CJ\u0016\u0010U\u001a\u00020V2\u0006\u0010(\u001a\u00020)2\u0006\u0010B\u001a\u00020CJ\u001d\u0010W\u001a\u0004\u0018\u00010E2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005¢\u0006\u0002\u0010XJ\u001f\u0010Y\u001a\u0004\u0018\u00010E2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010XJ\u0010\u0010Z\u001a\u00020N2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0010\u0010[\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0018\u0010\\\u001a\u00020#2\u0006\u0010(\u001a\u00020)2\u0006\u0010B\u001a\u00020CH\u0002J\u0018\u0010]\u001a\u00020#2\u0006\u0010(\u001a\u00020)2\u0006\u0010@\u001a\u00020\u0005H\u0002J\u0010\u0010^\u001a\u00020#2\u0006\u0010B\u001a\u00020CH\u0002J\u001f\u0010_\u001a\u0004\u0018\u00010E2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010XJ\u0010\u0010`\u001a\u00020\u00052\u0006\u0010a\u001a\u00020EH\u0002J\u0016\u0010b\u001a\u00020N2\u0006\u0010(\u001a\u00020)2\u0006\u0010c\u001a\u00020dJ\u001a\u0010e\u001a\u00020f2\u0006\u0010c\u001a\u00020d2\b\b\u0002\u0010g\u001a\u00020#H\u0002J\u0018\u0010h\u001a\u00020f2\u0006\u0010(\u001a\u00020)2\u0006\u0010i\u001a\u00020\u0005H\u0002J\u0010\u0010j\u001a\u00020\u00052\u0006\u0010i\u001a\u00020\u0005H\u0002J\u0010\u0010k\u001a\u00020\u00052\u0006\u0010i\u001a\u00020\u0005H\u0002J\u0010\u0010l\u001a\u00020#2\u0006\u0010m\u001a\u00020#H\u0002J\u0010\u0010n\u001a\u00020o2\u0006\u0010c\u001a\u00020dH\u0002J\u000e\u0010p\u001a\u00020'2\u0006\u0010(\u001a\u00020)R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Lcom/example/tickets/LiveUpdateManager;", "", "<init>", "()V", "ACTION_START", "", "ACTION_STOP", "ACTION_OPEN_TICKET", "ACTION_OPEN_TICKET_V2", "ACTION_MARK_TICKET_USED", "EXTRA_TICKET_ID", "EXTRA_TICKET_TYPE", "EXTRA_TITLE", "EXTRA_CODE", "EXTRA_DATE", "EXTRA_DEPARTURE_DATE", "EXTRA_ARRIVAL_DATE", "EXTRA_TIME", "EXTRA_FROM", "EXTRA_TO", "EXTRA_DEPARTURE_PLATFORM", "EXTRA_ARRIVAL_PLATFORM", "EXTRA_HALL", "EXTRA_AREA", "EXTRA_ENTRY", "EXTRA_SEAT", "EXTRA_VENUE", "EXTRA_START_TIME", "EXTRA_END_TIME", "EXTRA_TAKEOFF_TIME", "EXTRA_LANDING_TIME", "EXTRA_BRAND", "CHANNEL_BASE_ID", "CHANNEL_NAME", "BASE_NOTIFICATION_ID", "", "REQUEST_SCHEDULE_BASE", "ACTION_SCHEDULED_START", "createNotificationChannel", "", "context", "Landroid/content/Context;", "showTicketLiveUpdate", "ticketId", "ticketType", "title", "code", "date", "time", "departureDate", "arrivalDate", Constants.MessagePayloadKeys.FROM, "to", "departurePlatform", "arrivalPlatform", "hall", "seat", "venue", "area", "entry", "startTime", "endTime", "takeoffTime", "landingTime", "brand", "scheduleLiveUpdateStart", "payload", "Lcom/example/tickets/LiveUpdatePayload;", "triggerAtMillis", "", "cancelScheduledLiveUpdate", "startLiveUpdateService", "cancelTicketLiveUpdate", "cancelAll", "ticketIds", "", "notificationId", "isSupportedType", "", "buildPayload", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_INTENT, "Landroid/content/Intent;", "isDayCountdownTicket", "resolveWindow", "Lkotlin/Pair;", "buildNotification", "Landroid/app/Notification;", "parseDateTime", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "parseFlexibleDateTime", "isCodeTicket", "notificationAccentColor", "selectSmallIcon", "selectTakeoutNotificationIconRes", "selectAirplaneIcon", "parseFlightPhaseDateTime", "formatClock", "millis", "showSmartSubway", "state", "Lcom/example/tickets/SmartSubwayRealtimeState;", "buildSmartSubwayAutoMatchedServiceIcon", "Landroid/graphics/Bitmap;", "sizePx", "buildSmartSubwayStatusBarIcon", "lineName", "smartSubwayServiceBadgeLabel", "smartSubwayPatternBadge", "smartSubwayIconTextColor", "backgroundColor", "buildSmartSubwayLiveUpdateProgressStyle", "Landroidx/core/app/NotificationCompat$ProgressStyle;", "cancelSmartSubway", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LiveUpdateManager {
    public static final int $stable = 0;
    public static final String ACTION_MARK_TICKET_USED = "com.example.tickets.action.MARK_TICKET_USED";
    public static final String ACTION_OPEN_TICKET = "com.example.tickets.action.OPEN_TICKET_FROM_NOTIFICATION";
    public static final String ACTION_OPEN_TICKET_V2 = "com.example.tickets.action.OPEN_TICKET_FROM_NOTIFICATION_V2";
    public static final String ACTION_SCHEDULED_START = "com.example.tickets.action.SCHEDULED_START_LIVE_UPDATE";
    public static final String ACTION_START = "com.example.tickets.action.START_LIVE_UPDATE";
    public static final String ACTION_STOP = "com.example.tickets.action.STOP_LIVE_UPDATE";
    private static final int BASE_NOTIFICATION_ID = 41000;
    private static final String CHANNEL_BASE_ID = "ticket_live_updates";
    private static final String CHANNEL_NAME = "票据实时动态";
    public static final String EXTRA_AREA = "ticket_area";
    public static final String EXTRA_ARRIVAL_DATE = "ticket_arrival_date";
    public static final String EXTRA_ARRIVAL_PLATFORM = "ticket_arrival_platform";
    public static final String EXTRA_BRAND = "ticket_brand";
    public static final String EXTRA_CODE = "ticket_code";
    public static final String EXTRA_DATE = "ticket_date";
    public static final String EXTRA_DEPARTURE_DATE = "ticket_departure_date";
    public static final String EXTRA_DEPARTURE_PLATFORM = "ticket_departure_platform";
    public static final String EXTRA_END_TIME = "ticket_end_time";
    public static final String EXTRA_ENTRY = "ticket_entry";
    public static final String EXTRA_FROM = "ticket_from";
    public static final String EXTRA_HALL = "ticket_hall";
    public static final String EXTRA_LANDING_TIME = "ticket_landing_time";
    public static final String EXTRA_SEAT = "ticket_seat";
    public static final String EXTRA_START_TIME = "ticket_start_time";
    public static final String EXTRA_TAKEOFF_TIME = "ticket_takeoff_time";
    public static final String EXTRA_TICKET_ID = "ticket_id";
    public static final String EXTRA_TICKET_TYPE = "ticket_type";
    public static final String EXTRA_TIME = "ticket_time";
    public static final String EXTRA_TITLE = "ticket_title";
    public static final String EXTRA_TO = "ticket_to";
    public static final String EXTRA_VENUE = "ticket_venue";
    public static final LiveUpdateManager INSTANCE = new LiveUpdateManager();
    private static final int REQUEST_SCHEDULE_BASE = 83000;

    public final int notificationId(int ticketId) {
        return ticketId + BASE_NOTIFICATION_ID;
    }

    private LiveUpdateManager() {
    }

    public final void createNotificationChannel(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        RealtimeNotificationVisibilityController.INSTANCE.createVisibilityChannels((NotificationManager) systemService, CHANNEL_BASE_ID, CHANNEL_NAME, "显示票据实时进度与状态", true);
    }

    public final void showTicketLiveUpdate(Context context, int ticketId, String ticketType, String title, String code, String date, String time, String departureDate, String arrivalDate, String from, String to, String departurePlatform, String arrivalPlatform, String hall, String seat, String venue, String area, String entry, String startTime, String endTime, String takeoffTime, String landingTime, String brand) {
        long jDisplayStartAt;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ticketType, "ticketType");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(departureDate, "departureDate");
        Intrinsics.checkNotNullParameter(arrivalDate, "arrivalDate");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(departurePlatform, "departurePlatform");
        Intrinsics.checkNotNullParameter(arrivalPlatform, "arrivalPlatform");
        Intrinsics.checkNotNullParameter(hall, "hall");
        Intrinsics.checkNotNullParameter(seat, "seat");
        Intrinsics.checkNotNullParameter(venue, "venue");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(takeoffTime, "takeoffTime");
        Intrinsics.checkNotNullParameter(landingTime, "landingTime");
        Intrinsics.checkNotNullParameter(brand, "brand");
        if (isSupportedType(ticketType)) {
            if (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
                createNotificationChannel(context);
                String str = departureDate;
                String str2 = StringsKt.isBlank(str) ? date : str;
                String str3 = arrivalDate;
                if (StringsKt.isBlank(str3)) {
                    if (StringsKt.isBlank(str)) {
                        str = date;
                    }
                    str3 = str;
                }
                LiveUpdatePayload liveUpdatePayload = new LiveUpdatePayload(ticketId, ticketType, title, code, date, time, str2, str3, from, to, departurePlatform, arrivalPlatform, hall, seat, venue, area, entry, startTime, endTime, takeoffTime, landingTime, brand);
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (isDayCountdownTicket(ticketType)) {
                    jDisplayStartAt = resolveWindow(liveUpdatePayload).getFirst().longValue();
                } else {
                    jDisplayStartAt = RealtimeNotificationStateCalculator.INSTANCE.displayStartAt(liveUpdatePayload);
                }
                if (jDisplayStartAt != Long.MAX_VALUE && jCurrentTimeMillis < jDisplayStartAt) {
                    scheduleLiveUpdateStart(context, liveUpdatePayload, jDisplayStartAt);
                    return;
                }
                cancelScheduledLiveUpdate(context, ticketId);
                try {
                    NotificationManagerCompat.from(context).notify(notificationId(ticketId), buildNotification(context, liveUpdatePayload));
                    startLiveUpdateService(context, liveUpdatePayload);
                } catch (SecurityException unused) {
                }
            }
        }
    }

    private final void scheduleLiveUpdateStart(Context context, LiveUpdatePayload payload, long triggerAtMillis) {
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager alarmManager = (AlarmManager) systemService;
        Intent intent = new Intent(context, (Class<?>) LiveUpdateService.class);
        intent.setAction(ACTION_SCHEDULED_START);
        intent.putExtra("ticket_id", payload.getTicketId());
        intent.putExtra("ticket_type", payload.getTicketType());
        intent.putExtra("ticket_title", payload.getTitle());
        intent.putExtra(EXTRA_CODE, payload.getCode());
        intent.putExtra("ticket_date", payload.getDate());
        intent.putExtra(EXTRA_DEPARTURE_DATE, payload.getDepartureDate());
        intent.putExtra(EXTRA_ARRIVAL_DATE, payload.getArrivalDate());
        intent.putExtra("ticket_time", payload.getTime());
        intent.putExtra(EXTRA_FROM, payload.getFrom());
        intent.putExtra(EXTRA_TO, payload.getTo());
        intent.putExtra(EXTRA_DEPARTURE_PLATFORM, payload.getDeparturePlatform());
        intent.putExtra(EXTRA_ARRIVAL_PLATFORM, payload.getArrivalPlatform());
        intent.putExtra(EXTRA_HALL, payload.getHall());
        intent.putExtra(EXTRA_AREA, payload.getArea());
        intent.putExtra(EXTRA_ENTRY, payload.getEntry());
        intent.putExtra(EXTRA_SEAT, payload.getSeat());
        intent.putExtra(EXTRA_VENUE, payload.getVenue());
        intent.putExtra(EXTRA_START_TIME, payload.getStartTime());
        intent.putExtra(EXTRA_END_TIME, payload.getEndTime());
        intent.putExtra(EXTRA_TAKEOFF_TIME, payload.getTakeoffTime());
        intent.putExtra(EXTRA_LANDING_TIME, payload.getLandingTime());
        intent.putExtra(EXTRA_BRAND, payload.getBrand());
        try {
            alarmManager.setAndAllowWhileIdle(0, triggerAtMillis, PendingIntent.getService(context, payload.getTicketId() + REQUEST_SCHEDULE_BASE, intent, 201326592));
        } catch (SecurityException unused) {
        }
    }

    private final void cancelScheduledLiveUpdate(Context context, int ticketId) {
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager alarmManager = (AlarmManager) systemService;
        Intent intent = new Intent(context, (Class<?>) LiveUpdateService.class);
        intent.setAction(ACTION_SCHEDULED_START);
        PendingIntent service = PendingIntent.getService(context, ticketId + REQUEST_SCHEDULE_BASE, intent, 201326592);
        try {
            alarmManager.cancel(service);
        } catch (Exception unused) {
        }
        service.cancel();
    }

    private final void startLiveUpdateService(Context context, LiveUpdatePayload payload) {
        if (RealtimeNotificationVisibilityController.INSTANCE.isAppForeground()) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) LiveUpdateService.class);
        intent.setAction(ACTION_START);
        intent.putExtra("ticket_id", payload.getTicketId());
        intent.putExtra("ticket_type", payload.getTicketType());
        intent.putExtra("ticket_title", payload.getTitle());
        intent.putExtra(EXTRA_CODE, payload.getCode());
        intent.putExtra("ticket_date", payload.getDate());
        intent.putExtra(EXTRA_DEPARTURE_DATE, payload.getDepartureDate());
        intent.putExtra(EXTRA_ARRIVAL_DATE, payload.getArrivalDate());
        intent.putExtra("ticket_time", payload.getTime());
        intent.putExtra(EXTRA_FROM, payload.getFrom());
        intent.putExtra(EXTRA_TO, payload.getTo());
        intent.putExtra(EXTRA_DEPARTURE_PLATFORM, payload.getDeparturePlatform());
        intent.putExtra(EXTRA_ARRIVAL_PLATFORM, payload.getArrivalPlatform());
        intent.putExtra(EXTRA_HALL, payload.getHall());
        intent.putExtra(EXTRA_SEAT, payload.getSeat());
        intent.putExtra(EXTRA_VENUE, payload.getVenue());
        intent.putExtra(EXTRA_START_TIME, payload.getStartTime());
        intent.putExtra(EXTRA_END_TIME, payload.getEndTime());
        intent.putExtra(EXTRA_TAKEOFF_TIME, payload.getTakeoffTime());
        intent.putExtra(EXTRA_LANDING_TIME, payload.getLandingTime());
        try {
            if (Build.VERSION.SDK_INT < 34 || (ContextCompat.checkSelfPermission(context, "android.permission.FOREGROUND_SERVICE") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.FOREGROUND_SERVICE_SPECIAL_USE") == 0)) {
                ContextCompat.startForegroundService(context, intent);
            }
        } catch (Exception unused) {
        }
    }

    public final void cancelTicketLiveUpdate(Context context, int ticketId) {
        Intrinsics.checkNotNullParameter(context, "context");
        cancelScheduledLiveUpdate(context, ticketId);
        Intent intent = new Intent(context, (Class<?>) LiveUpdateService.class);
        intent.setAction(ACTION_STOP);
        intent.putExtra("ticket_id", ticketId);
        try {
            context.startService(intent);
        } catch (Exception unused) {
        }
        NotificationManagerCompat.from(context).cancel(notificationId(ticketId));
    }

    public final void cancelAll(Context context, List<Integer> ticketIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ticketIds, "ticketIds");
        Iterator<T> it = ticketIds.iterator();
        while (it.hasNext()) {
            INSTANCE.cancelTicketLiveUpdate(context, ((Number) it.next()).intValue());
        }
    }

    public final boolean isSupportedType(String ticketType) {
        Intrinsics.checkNotNullParameter(ticketType, "ticketType");
        return Intrinsics.areEqual(ticketType, "电影票") || Intrinsics.areEqual(ticketType, "车票") || Intrinsics.areEqual(ticketType, "火车票") || Intrinsics.areEqual(ticketType, "机票") || Intrinsics.areEqual(ticketType, "演出") || Intrinsics.areEqual(ticketType, "门票") || Intrinsics.areEqual(ticketType, "取餐码") || Intrinsics.areEqual(ticketType, "取件码");
    }

    public final LiveUpdatePayload buildPayload(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        int intExtra = intent.getIntExtra("ticket_id", 0);
        String stringExtra = intent.getStringExtra("ticket_type");
        String str = stringExtra == null ? "" : stringExtra;
        String stringExtra2 = intent.getStringExtra("ticket_title");
        String str2 = stringExtra2 == null ? "" : stringExtra2;
        String stringExtra3 = intent.getStringExtra(EXTRA_CODE);
        String str3 = stringExtra3 == null ? "" : stringExtra3;
        String stringExtra4 = intent.getStringExtra("ticket_date");
        String str4 = stringExtra4 == null ? "" : stringExtra4;
        String stringExtra5 = intent.getStringExtra(EXTRA_DEPARTURE_DATE);
        if (stringExtra5 == null) {
            stringExtra5 = "";
        }
        String stringExtra6 = stringExtra5;
        if (StringsKt.isBlank(stringExtra6) && (stringExtra6 = intent.getStringExtra("ticket_date")) == null) {
            stringExtra6 = "";
        }
        String str5 = stringExtra6;
        String stringExtra7 = intent.getStringExtra(EXTRA_ARRIVAL_DATE);
        if (stringExtra7 == null) {
            stringExtra7 = "";
        }
        String str6 = stringExtra7;
        if (StringsKt.isBlank(str6)) {
            String stringExtra8 = intent.getStringExtra(EXTRA_DEPARTURE_DATE);
            if (stringExtra8 == null) {
                stringExtra8 = "";
            }
            String str7 = stringExtra8;
            if (StringsKt.isBlank(str7)) {
                String stringExtra9 = intent.getStringExtra("ticket_date");
                str7 = stringExtra9 == null ? "" : stringExtra9;
            }
            str6 = str7;
        }
        String str8 = str6;
        String stringExtra10 = intent.getStringExtra("ticket_time");
        String str9 = stringExtra10 == null ? "" : stringExtra10;
        String stringExtra11 = intent.getStringExtra(EXTRA_FROM);
        String str10 = stringExtra11 == null ? "" : stringExtra11;
        String stringExtra12 = intent.getStringExtra(EXTRA_TO);
        String str11 = stringExtra12 == null ? "" : stringExtra12;
        String stringExtra13 = intent.getStringExtra(EXTRA_DEPARTURE_PLATFORM);
        String str12 = stringExtra13 == null ? "" : stringExtra13;
        String stringExtra14 = intent.getStringExtra(EXTRA_ARRIVAL_PLATFORM);
        String str13 = stringExtra14 == null ? "" : stringExtra14;
        String stringExtra15 = intent.getStringExtra(EXTRA_HALL);
        String str14 = stringExtra15 == null ? "" : stringExtra15;
        String stringExtra16 = intent.getStringExtra(EXTRA_AREA);
        String str15 = stringExtra16 == null ? "" : stringExtra16;
        String stringExtra17 = intent.getStringExtra(EXTRA_ENTRY);
        String str16 = stringExtra17 == null ? "" : stringExtra17;
        String stringExtra18 = intent.getStringExtra(EXTRA_SEAT);
        String str17 = stringExtra18 == null ? "" : stringExtra18;
        String stringExtra19 = intent.getStringExtra(EXTRA_VENUE);
        String str18 = stringExtra19 == null ? "" : stringExtra19;
        String stringExtra20 = intent.getStringExtra(EXTRA_START_TIME);
        String str19 = stringExtra20 == null ? "" : stringExtra20;
        String stringExtra21 = intent.getStringExtra(EXTRA_END_TIME);
        String str20 = stringExtra21 == null ? "" : stringExtra21;
        String stringExtra22 = intent.getStringExtra(EXTRA_TAKEOFF_TIME);
        String str21 = stringExtra22 == null ? "" : stringExtra22;
        String stringExtra23 = intent.getStringExtra(EXTRA_LANDING_TIME);
        String str22 = stringExtra23 == null ? "" : stringExtra23;
        String stringExtra24 = intent.getStringExtra(EXTRA_BRAND);
        return new LiveUpdatePayload(intExtra, str, str2, str3, str4, str9, str5, str8, str10, str11, str12, str13, str14, str17, str18, str15, str16, str19, str20, str21, str22, stringExtra24 == null ? "" : stringExtra24);
    }

    private final boolean isDayCountdownTicket(String ticketType) {
        return Intrinsics.areEqual(ticketType, "取餐码") || Intrinsics.areEqual(ticketType, "取件码") || Intrinsics.areEqual(ticketType, "演出") || Intrinsics.areEqual(ticketType, "门票");
    }

    /* JADX WARN: Code duplicated, block: B:62:0x0110  */
    public final Pair<Long, Long> resolveWindow(LiveUpdatePayload payload) {
        String date;
        String date2;
        Intrinsics.checkNotNullParameter(payload, "payload");
        long jLongValue = Long.MAX_VALUE;
        if (Intrinsics.areEqual(payload.getTicketType(), "取餐码") || Intrinsics.areEqual(payload.getTicketType(), "取件码") || Intrinsics.areEqual(payload.getTicketType(), "演出") || Intrinsics.areEqual(payload.getTicketType(), "门票")) {
            Long dateTime = parseDateTime(payload.getDate(), "00:00");
            if (dateTime == null) {
                return new Pair<>(Long.MAX_VALUE, Long.MAX_VALUE);
            }
            return new Pair<>(dateTime, Long.valueOf(dateTime.longValue() + CalendarModelKt.MillisecondsIn24Hours));
        }
        boolean z = Intrinsics.areEqual(payload.getTicketType(), "车票") || Intrinsics.areEqual(payload.getTicketType(), "火车票") || Intrinsics.areEqual(payload.getTicketType(), "机票");
        if (z) {
            String departureDate = payload.getDepartureDate();
            if (StringsKt.isBlank(departureDate)) {
                departureDate = payload.getDate();
            }
            date = departureDate;
        } else {
            date = payload.getDate();
        }
        if (z) {
            String arrivalDate = payload.getArrivalDate();
            if (StringsKt.isBlank(arrivalDate)) {
                String departureDate2 = payload.getDepartureDate();
                if (StringsKt.isBlank(departureDate2)) {
                    departureDate2 = payload.getDate();
                }
                arrivalDate = departureDate2;
            }
            date2 = arrivalDate;
        } else {
            date2 = payload.getDate();
        }
        String startTime = payload.getStartTime();
        if (StringsKt.isBlank(startTime)) {
            startTime = payload.getTime();
        }
        Long dateTime2 = parseDateTime(date, startTime);
        long jLongValue2 = dateTime2 != null ? dateTime2.longValue() : Long.MAX_VALUE;
        Long dateTime3 = parseDateTime(date2, payload.getEndTime());
        String ticketType = payload.getTicketType();
        long j = 7200000;
        switch (ticketType.hashCode()) {
            case 850286:
                ticketType.equals("机票");
                break;
            case 1169090:
                ticketType.equals("车票");
                break;
            case 28825709:
                ticketType.equals("火车票");
                break;
            case 29623308:
                if (ticketType.equals("电影票")) {
                    j = 9000000;
                }
                break;
        }
        if (jLongValue2 != Long.MAX_VALUE) {
            if (dateTime3 == null) {
                jLongValue = jLongValue2 + j;
            } else {
                if (dateTime3.longValue() <= jLongValue2) {
                    dateTime3 = null;
                }
                if (dateTime3 != null) {
                    jLongValue = dateTime3.longValue();
                } else {
                    jLongValue = jLongValue2 + j;
                }
            }
        }
        return new Pair<>(Long.valueOf(jLongValue2), Long.valueOf(jLongValue));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:230:0x0416  */
    /* JADX WARN: Code duplicated, block: B:232:0x0422  */
    /* JADX WARN: Code duplicated, block: B:236:0x0432  */
    /* JADX WARN: Code duplicated, block: B:239:0x0437  */
    /* JADX WARN: Code duplicated, block: B:240:0x0444  */
    /* JADX WARN: Code duplicated, block: B:242:0x0447  */
    /* JADX WARN: Code duplicated, block: B:243:0x044a  */
    /* JADX WARN: Code duplicated, block: B:246:0x0458  */
    /* JADX WARN: Code duplicated, block: B:248:0x0464  */
    /* JADX WARN: Code duplicated, block: B:253:0x0476  */
    /* JADX WARN: Code duplicated, block: B:256:0x047b  */
    /* JADX WARN: Code duplicated, block: B:257:0x048a  */
    /* JADX WARN: Code duplicated, block: B:259:0x048d  */
    /* JADX WARN: Code duplicated, block: B:260:0x0490  */
    /* JADX WARN: Code duplicated, block: B:263:0x049e  */
    /* JADX WARN: Code duplicated, block: B:267:0x04ae  */
    /* JADX WARN: Code duplicated, block: B:270:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:271:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:273:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:274:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:278:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:280:0x04db  */
    /* JADX WARN: Code duplicated, block: B:281:0x04ea  */
    /* JADX WARN: Code duplicated, block: B:283:0x04ed  */
    /* JADX WARN: Code duplicated, block: B:284:0x04f0  */
    /* JADX WARN: Code duplicated, block: B:288:0x0500  */
    /* JADX WARN: Code duplicated, block: B:290:0x0503  */
    /* JADX WARN: Code duplicated, block: B:291:0x0512  */
    /* JADX WARN: Code duplicated, block: B:293:0x0515  */
    /* JADX WARN: Code duplicated, block: B:294:0x0518  */
    /* JADX WARN: Code duplicated, block: B:298:0x0528  */
    /* JADX WARN: Code duplicated, block: B:300:0x052b  */
    /* JADX WARN: Code duplicated, block: B:301:0x053a  */
    /* JADX WARN: Code duplicated, block: B:303:0x053d  */
    /* JADX WARN: Code duplicated, block: B:304:0x0540  */
    /* JADX WARN: Code duplicated, block: B:308:0x0550  */
    /* JADX WARN: Code duplicated, block: B:310:0x0553  */
    /* JADX WARN: Code duplicated, block: B:311:0x0560  */
    /* JADX WARN: Code duplicated, block: B:313:0x0563  */
    /* JADX WARN: Code duplicated, block: B:314:0x0566  */
    /* JADX WARN: Code duplicated, block: B:450:0x078b  */
    /* JADX WARN: Code duplicated, block: B:512:0x09c0  */
    /* JADX WARN: Instruction removed from duplicated block: B:239:0x0437, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:256:0x047b, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:270:0x04b3, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:280:0x04db, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:290:0x0503, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:300:0x052b, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:310:0x0553, please report this as an issue */
    public final Notification buildNotification(Context context, LiveUpdatePayload payload) {
        boolean z;
        int progressPermille;
        String statusText;
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
        String str11;
        String str12;
        String str13;
        String str14;
        String title;
        int iSelectTakeoutNotificationIconRes;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(payload, "payload");
        createNotificationChannel(context);
        boolean z2 = Intrinsics.areEqual(payload.getTicketType(), "取餐码") || Intrinsics.areEqual(payload.getTicketType(), "取件码");
        boolean zIsDayCountdownTicket = isDayCountdownTicket(payload.getTicketType());
        Pair<Long, Long> pairResolveWindow = resolveWindow(payload);
        long jLongValue = pairResolveWindow.getFirst().longValue();
        long jLongValue2 = pairResolveWindow.getSecond().longValue();
        long jCurrentTimeMillis = System.currentTimeMillis();
        RealtimeNotificationState realtimeNotificationStateCalculate = zIsDayCountdownTicket ? null : RealtimeNotificationStateCalculator.INSTANCE.calculate(payload, jCurrentTimeMillis);
        if (!zIsDayCountdownTicket || jLongValue == Long.MAX_VALUE || jLongValue2 <= jLongValue) {
            z = z2;
            progressPermille = realtimeNotificationStateCalculate != null ? realtimeNotificationStateCalculate.getProgressPermille() : 0;
        } else {
            z = z2;
            progressPermille = (int) RangesKt.coerceIn((RangesKt.coerceAtLeast(jCurrentTimeMillis - jLongValue, 0L) * 1000) / RangesKt.coerceAtLeast(jLongValue2 - jLongValue, 1L), 0L, 1000L);
        }
        if (zIsDayCountdownTicket) {
            long jCoerceAtLeast = RangesKt.coerceAtLeast(jLongValue2 - jCurrentTimeMillis, 0L) / 60000;
            long j = jCoerceAtLeast / 60;
            long j2 = jCoerceAtLeast % 60;
            statusText = j > 0 ? "今日有效 · 距今天结束还有 " + j + "小时" + j2 + "分" : "今日有效 · 距今天结束还有 " + j2 + "分";
        } else {
            statusText = realtimeNotificationStateCalculate != null ? realtimeNotificationStateCalculate.getStatusText() : null;
            if (statusText == null) {
                statusText = "";
            }
        }
        int i = progressPermille;
        switch (payload.getTicketType()) {
            case "机票":
                String departureDate = payload.getDepartureDate();
                if (StringsKt.isBlank(departureDate)) {
                    departureDate = payload.getDate();
                }
                if (StringsKt.isBlank(departureDate)) {
                    departureDate = null;
                }
                String str15 = departureDate;
                String str16 = str15 != null ? "出发日期 " + str15 : null;
                String str17 = str16 == null ? "" : str16;
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
                String str18 = arrivalDate;
                String str19 = str18 != null ? "到达日期 " + str18 : null;
                String str20 = str19 == null ? "" : str19;
                String startTime = payload.getStartTime();
                if (StringsKt.isBlank(startTime)) {
                    startTime = payload.getTime();
                }
                if (StringsKt.isBlank(startTime)) {
                    startTime = null;
                }
                String str21 = startTime;
                String str22 = str21 != null ? "出发 " + str21 : null;
                String str23 = str22 == null ? "" : str22;
                String endTime = payload.getEndTime();
                if (StringsKt.isBlank(endTime)) {
                    endTime = null;
                }
                String str24 = endTime != null ? "到达 " + endTime : null;
                String str25 = str24 == null ? "" : str24;
                String departurePlatform = payload.getDeparturePlatform();
                if (StringsKt.isBlank(departurePlatform)) {
                    departurePlatform = null;
                }
                String str26 = departurePlatform != null ? "出发站台 " + departurePlatform : null;
                String str27 = str26 == null ? "" : str26;
                String arrivalPlatform = payload.getArrivalPlatform();
                if (StringsKt.isBlank(arrivalPlatform)) {
                    arrivalPlatform = null;
                }
                String str28 = arrivalPlatform != null ? "到达站台 " + arrivalPlatform : null;
                String str29 = str28 == null ? "" : str28;
                String seat = payload.getSeat();
                if (StringsKt.isBlank(seat)) {
                    seat = null;
                }
                String str30 = seat != null ? "座位 " + seat : null;
                listEmptyList = CollectionsKt.listOf((Object[]) new String[]{str17, str20, str23, str25, str27, str29, str30 == null ? "" : str30});
                break;
            case "演出":
                String startTime2 = payload.getStartTime();
                if (StringsKt.isBlank(startTime2)) {
                    startTime2 = payload.getTime();
                }
                if (StringsKt.isBlank(startTime2)) {
                    startTime2 = null;
                }
                String str31 = startTime2;
                String str32 = str31 != null ? "时间 " + str31 : null;
                if (str32 == null) {
                    str32 = "";
                }
                String venue = payload.getVenue();
                if (StringsKt.isBlank(venue)) {
                    venue = null;
                }
                String str33 = venue != null ? "地点 " + venue : null;
                if (str33 == null) {
                    str33 = "";
                }
                String area = payload.getArea();
                if (StringsKt.isBlank(area)) {
                    area = null;
                }
                String str34 = area != null ? "区域 " + area : null;
                if (str34 == null) {
                    str34 = "";
                }
                String seat2 = payload.getSeat();
                if (StringsKt.isBlank(seat2)) {
                    seat2 = null;
                }
                String str35 = seat2 != null ? "座位 " + seat2 : null;
                listEmptyList = CollectionsKt.listOf((Object[]) new String[]{str32, str33, str34, str35 == null ? "" : str35});
                break;
            case "车票":
                String departureDate3 = payload.getDepartureDate();
                if (StringsKt.isBlank(departureDate3)) {
                    departureDate3 = payload.getDate();
                }
                if (StringsKt.isBlank(departureDate3)) {
                    departureDate3 = null;
                }
                String str36 = departureDate3;
                if (str36 != null) {
                    str = "出发日期 " + str36;
                } else {
                    str = null;
                }
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str;
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
                String str37 = arrivalDate2;
                if (str37 != null) {
                    str3 = "到达日期 " + str37;
                } else {
                    str3 = null;
                }
                if (str3 == null) {
                    str4 = "";
                } else {
                    str4 = str3;
                }
                String startTime3 = payload.getStartTime();
                if (StringsKt.isBlank(startTime3)) {
                    startTime3 = payload.getTime();
                }
                if (StringsKt.isBlank(startTime3)) {
                    startTime3 = null;
                }
                String str38 = startTime3;
                if (str38 != null) {
                    str5 = "出发 " + str38;
                } else {
                    str5 = null;
                }
                if (str5 == null) {
                    str6 = "";
                } else {
                    str6 = str5;
                }
                String endTime2 = payload.getEndTime();
                if (StringsKt.isBlank(endTime2)) {
                    endTime2 = null;
                }
                if (endTime2 != null) {
                    str7 = "到达 " + endTime2;
                } else {
                    str7 = null;
                }
                if (str7 == null) {
                    str8 = "";
                } else {
                    str8 = str7;
                }
                String departurePlatform2 = payload.getDeparturePlatform();
                if (StringsKt.isBlank(departurePlatform2)) {
                    departurePlatform2 = null;
                }
                if (departurePlatform2 != null) {
                    str9 = "出发站台 " + departurePlatform2;
                } else {
                    str9 = null;
                }
                if (str9 == null) {
                    str10 = "";
                } else {
                    str10 = str9;
                }
                String arrivalPlatform2 = payload.getArrivalPlatform();
                if (StringsKt.isBlank(arrivalPlatform2)) {
                    arrivalPlatform2 = null;
                }
                if (arrivalPlatform2 != null) {
                    str11 = "到达站台 " + arrivalPlatform2;
                } else {
                    str11 = null;
                }
                if (str11 == null) {
                    str12 = "";
                } else {
                    str12 = str11;
                }
                String seat3 = payload.getSeat();
                if (StringsKt.isBlank(seat3)) {
                    seat3 = null;
                }
                if (seat3 != null) {
                    str13 = "座位 " + seat3;
                } else {
                    str13 = null;
                }
                if (str13 == null) {
                    str14 = "";
                } else {
                    str14 = str13;
                }
                listEmptyList = CollectionsKt.listOf((Object[]) new String[]{str2, str4, str6, str8, str10, str12, str14});
                break;
            case "门票":
                String time = payload.getTime();
                if (StringsKt.isBlank(time)) {
                    time = null;
                }
                String str39 = time != null ? "时间 " + time : null;
                if (str39 == null) {
                    str39 = "";
                }
                String venue2 = payload.getVenue();
                if (StringsKt.isBlank(venue2)) {
                    venue2 = null;
                }
                String str40 = venue2 != null ? "地点 " + venue2 : null;
                if (str40 == null) {
                    str40 = "";
                }
                String entry = payload.getEntry();
                if (StringsKt.isBlank(entry)) {
                    entry = null;
                }
                String str41 = entry != null ? "入口 " + entry : null;
                if (str41 == null) {
                    str41 = "";
                }
                String seat4 = payload.getSeat();
                if (StringsKt.isBlank(seat4)) {
                    seat4 = null;
                }
                String str42 = seat4 != null ? "座位 " + seat4 : null;
                listEmptyList = CollectionsKt.listOf((Object[]) new String[]{str39, str40, str41, str42 == null ? "" : str42});
                break;
            case "取件码":
                String title2 = payload.getTitle();
                if (StringsKt.isBlank(title2)) {
                    title2 = null;
                }
                String str43 = title2 != null ? "名称 " + title2 : null;
                if (str43 == null) {
                    str43 = "";
                }
                String brand = payload.getBrand();
                if (StringsKt.isBlank(brand)) {
                    brand = null;
                }
                String str44 = brand != null ? "品牌 " + brand : null;
                if (str44 == null) {
                    str44 = "";
                }
                String venue3 = payload.getVenue();
                if (StringsKt.isBlank(venue3)) {
                    venue3 = null;
                }
                String str45 = venue3 != null ? "地点 " + venue3 : null;
                if (str45 == null) {
                    str45 = "";
                }
                String date = payload.getDate();
                if (StringsKt.isBlank(date)) {
                    date = null;
                }
                String str46 = date != null ? "日期 " + date : null;
                listEmptyList = CollectionsKt.listOf((Object[]) new String[]{str43, str44, str45, str46 == null ? "" : str46});
                break;
            case "取餐码":
                String title3 = payload.getTitle();
                if (StringsKt.isBlank(title3)) {
                    title3 = null;
                }
                String str47 = title3 != null ? "名称 " + title3 : null;
                if (str47 == null) {
                    str47 = "";
                }
                String brand2 = payload.getBrand();
                if (StringsKt.isBlank(brand2)) {
                    brand2 = null;
                }
                String str48 = brand2 != null ? "品牌 " + brand2 : null;
                if (str48 == null) {
                    str48 = "";
                }
                String venue4 = payload.getVenue();
                if (StringsKt.isBlank(venue4)) {
                    venue4 = null;
                }
                String str49 = venue4 != null ? "地点 " + venue4 : null;
                if (str49 == null) {
                    str49 = "";
                }
                String date2 = payload.getDate();
                if (StringsKt.isBlank(date2)) {
                    date2 = null;
                }
                String str50 = date2 != null ? "日期 " + date2 : null;
                if (str50 == null) {
                    str50 = "";
                }
                String time2 = payload.getTime();
                if (StringsKt.isBlank(time2)) {
                    time2 = null;
                }
                String str51 = time2 != null ? "时间 " + time2 : null;
                listEmptyList = CollectionsKt.listOf((Object[]) new String[]{str47, str48, str49, str50, str51 == null ? "" : str51});
                break;
            case "火车票":
                String departureDate5 = payload.getDepartureDate();
                if (StringsKt.isBlank(departureDate5)) {
                    departureDate5 = payload.getDate();
                }
                if (StringsKt.isBlank(departureDate5)) {
                    departureDate5 = null;
                }
                String str310 = departureDate5;
                if (str310 != null) {
                    str = "出发日期 " + str310;
                } else {
                    str = null;
                }
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str;
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
                String str311 = arrivalDate3;
                if (str311 != null) {
                    str3 = "到达日期 " + str311;
                } else {
                    str3 = null;
                }
                if (str3 == null) {
                    str4 = "";
                } else {
                    str4 = str3;
                }
                String startTime4 = payload.getStartTime();
                if (StringsKt.isBlank(startTime4)) {
                    startTime4 = payload.getTime();
                }
                if (StringsKt.isBlank(startTime4)) {
                    startTime4 = null;
                }
                String str312 = startTime4;
                if (str312 != null) {
                    str5 = "出发 " + str312;
                } else {
                    str5 = null;
                }
                if (str5 == null) {
                    str6 = "";
                } else {
                    str6 = str5;
                }
                String endTime3 = payload.getEndTime();
                if (StringsKt.isBlank(endTime3)) {
                    endTime3 = null;
                }
                if (endTime3 != null) {
                    str7 = "到达 " + endTime3;
                } else {
                    str7 = null;
                }
                if (str7 == null) {
                    str8 = "";
                } else {
                    str8 = str7;
                }
                String departurePlatform3 = payload.getDeparturePlatform();
                if (StringsKt.isBlank(departurePlatform3)) {
                    departurePlatform3 = null;
                }
                if (departurePlatform3 != null) {
                    str9 = "出发站台 " + departurePlatform3;
                } else {
                    str9 = null;
                }
                if (str9 == null) {
                    str10 = "";
                } else {
                    str10 = str9;
                }
                String arrivalPlatform3 = payload.getArrivalPlatform();
                if (StringsKt.isBlank(arrivalPlatform3)) {
                    arrivalPlatform3 = null;
                }
                if (arrivalPlatform3 != null) {
                    str11 = "到达站台 " + arrivalPlatform3;
                } else {
                    str11 = null;
                }
                if (str11 == null) {
                    str12 = "";
                } else {
                    str12 = str11;
                }
                String seat5 = payload.getSeat();
                if (StringsKt.isBlank(seat5)) {
                    seat5 = null;
                }
                if (seat5 != null) {
                    str13 = "座位 " + seat5;
                } else {
                    str13 = null;
                }
                if (str13 == null) {
                    str14 = "";
                } else {
                    str14 = str13;
                }
                listEmptyList = CollectionsKt.listOf((Object[]) new String[]{str2, str4, str6, str8, str10, str12, str14});
                break;
            case "电影票":
                String date3 = payload.getDate();
                if (StringsKt.isBlank(date3)) {
                    date3 = null;
                }
                String str52 = date3 != null ? "日期 " + date3 : null;
                if (str52 == null) {
                    str52 = "";
                }
                String startTime5 = payload.getStartTime();
                if (StringsKt.isBlank(startTime5)) {
                    startTime5 = payload.getTime();
                }
                if (StringsKt.isBlank(startTime5)) {
                    startTime5 = null;
                }
                String str53 = startTime5;
                String str54 = str53 != null ? "开始 " + str53 : null;
                if (str54 == null) {
                    str54 = "";
                }
                String endTime4 = payload.getEndTime();
                if (StringsKt.isBlank(endTime4)) {
                    endTime4 = null;
                }
                String str55 = endTime4 != null ? "结束 " + endTime4 : null;
                if (str55 == null) {
                    str55 = "";
                }
                String hall = payload.getHall();
                if (StringsKt.isBlank(hall)) {
                    hall = null;
                }
                String str56 = hall != null ? "影厅 " + hall : null;
                if (str56 == null) {
                    str56 = "";
                }
                String seat6 = payload.getSeat();
                if (StringsKt.isBlank(seat6)) {
                    seat6 = null;
                }
                String str57 = seat6 != null ? "座位 " + seat6 : null;
                listEmptyList = CollectionsKt.listOf((Object[]) new String[]{str52, str54, str55, str56, str57 == null ? "" : str57});
                break;
            default:
                listEmptyList = CollectionsKt.emptyList();
                break;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listEmptyList) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, "  ·  ", null, null, 0, null, null, 62, null);
        StringsKt.isBlank(strJoinToString$default);
        if (Intrinsics.areEqual(payload.getTicketType(), "车票") || Intrinsics.areEqual(payload.getTicketType(), "机票") || z) {
            String code = payload.getCode();
            if (StringsKt.isBlank(code)) {
                code = payload.getTitle();
            }
            title = code;
        } else {
            title = payload.getTitle();
        }
        String str58 = title;
        if (StringsKt.isBlank(str58)) {
            str58 = "票据";
        }
        String str59 = str58;
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{statusText, (StringsKt.isBlank(payload.getFrom()) || StringsKt.isBlank(payload.getTo())) ? "" : payload.getFrom() + " → " + payload.getTo(), strJoinToString$default});
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : listListOf) {
            if (!StringsKt.isBlank((String) obj2)) {
                arrayList2.add(obj2);
            }
        }
        String str60 = str59;
        NotificationCompat.Builder progress = new NotificationCompat.Builder(context, RealtimeNotificationVisibilityController.channelId$default(RealtimeNotificationVisibilityController.INSTANCE, CHANNEL_BASE_ID, null, null, 6, null)).setSmallIcon(selectSmallIcon(context, payload)).setColor(notificationAccentColor(payload.getTicketType())).setColorized(false).setSubText(payload.getTicketType()).setContentTitle(str60).setContentText(statusText).setStyle(new NotificationCompat.BigTextStyle().setBigContentTitle(str60).bigText(CollectionsKt.joinToString$default(arrayList2, "\n", null, null, 0, null, null, 62, null)).setSummaryText(payload.getTicketType())).setPriority(-1).setOngoing(true).setOnlyAlertOnce(true).setAutoCancel(false).setLocalOnly(true).setVisibility(1).setWhen(jCurrentTimeMillis).setShowWhen(true).setProgress(1000, i, false);
        Intrinsics.checkNotNullExpressionValue(progress, "setProgress(...)");
        if (RealtimeNotificationVisibilityController.INSTANCE.isAppForeground() && Build.VERSION.SDK_INT >= 36) {
            progress.setStyle(new NotificationCompat.ProgressStyle().setStyledByProgress(true).setProgress(RangesKt.coerceIn(i, 0, 1000)));
        }
        if (z) {
            Intent intent = new Intent(context, (Class<?>) MainActivity.class);
            intent.setAction("com.example.tickets.action.MARK_TICKET_USED");
            intent.putExtra("ticket_id", payload.getTicketId());
            intent.setFlags(603979776);
            PendingIntent activity = PendingIntent.getActivity(context, payload.getTicketId() + 91000, intent, 335544320);
            String str61 = Intrinsics.areEqual(payload.getTicketType(), "取餐码") ? "我已取餐" : "我已取件";
            switch (payload.getTicketType()) {
                case "演出":
                    iSelectTakeoutNotificationIconRes = R.drawable.ic_live_event;
                    break;
                case "门票":
                    iSelectTakeoutNotificationIconRes = R.drawable.ic_live_admission;
                    break;
                case "取件码":
                    iSelectTakeoutNotificationIconRes = R.drawable.ic_live_pickup;
                    break;
                case "取餐码":
                    iSelectTakeoutNotificationIconRes = selectTakeoutNotificationIconRes(context, payload.getBrand());
                    break;
                default:
                    iSelectTakeoutNotificationIconRes = R.drawable.ic_live_movie;
                    break;
            }
            progress.addAction(iSelectTakeoutNotificationIconRes, str61, activity);
        }
        Intent intent2 = new Intent(context, (Class<?>) MainActivity.class);
        intent2.setAction(ACTION_OPEN_TICKET_V2);
        intent2.putExtra("ticket_id", payload.getTicketId());
        intent2.setFlags(603979776);
        PendingIntent activity2 = PendingIntent.getActivity(context, payload.getTicketId() + 92000, intent2, 201326592);
        progress.setContentIntent(activity2);
        progress.addAction(android.R.drawable.ic_menu_view, "打开票据", activity2);
        if (Build.VERSION.SDK_INT >= 36 && !RealtimeNotificationVisibilityController.INSTANCE.isAppForeground()) {
            progress.setRequestPromotedOngoing(true);
        }
        Notification notificationBuild = progress.build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        return notificationBuild;
    }

    public final Long parseDateTime(String date, String time) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        return parseFlexibleDateTime(date, time);
    }

    private final Long parseFlexibleDateTime(String date, String time) {
        MatchResult matchResultFind$default;
        Integer intOrNull;
        String upperCase;
        Integer intOrNull2;
        int iIntValue;
        List<String> groupValues;
        String str;
        String str2 = date;
        if (!StringsKt.isBlank(str2)) {
            String str3 = time;
            if (!StringsKt.isBlank(str3) && (matchResultFind$default = Regex.find$default(new Regex("(\\d{4})\\D+(\\d{1,2})\\D+(\\d{1,2})"), StringsKt.trim((CharSequence) str2).toString(), 0, 2, null)) != null && (intOrNull = StringsKt.toIntOrNull(matchResultFind$default.getGroupValues().get(1))) != null) {
                int iIntValue2 = intOrNull.intValue();
                Integer intOrNull3 = StringsKt.toIntOrNull(matchResultFind$default.getGroupValues().get(2));
                if (intOrNull3 != null) {
                    int iIntValue3 = intOrNull3.intValue();
                    Integer intOrNull4 = StringsKt.toIntOrNull(matchResultFind$default.getGroupValues().get(3));
                    if (intOrNull4 != null) {
                        int iIntValue4 = intOrNull4.intValue();
                        String strReplace = new Regex("\\s+").replace(StringsKt.replace(StringsKt.replace(StringsKt.replace(StringsKt.replace(StringsKt.replace(StringsKt.replace(StringsKt.replace$default(StringsKt.replace$default(StringsKt.trim((CharSequence) str3).toString(), "：", ":", false, 4, (Object) null), "．", ".", false, 4, (Object) null), "a.m.", "AM", true), "p.m.", "PM", true), "a.m", "AM", true), "p.m", "PM", true), "上午", "AM", true), "下午", "PM", true), "");
                        if (StringsKt.contains$default((CharSequence) str3, (CharSequence) "下午", false, 2, (Object) null)) {
                            upperCase = "PM";
                        } else {
                            upperCase = StringsKt.contains$default((CharSequence) str3, (CharSequence) "上午", false, 2, (Object) null) ? "AM" : null;
                        }
                        if (upperCase == null) {
                            MatchResult matchResultFind$default2 = Regex.find$default(new Regex("(?i)(AM|PM)$"), strReplace, 0, 2, null);
                            if (matchResultFind$default2 == null || (groupValues = matchResultFind$default2.getGroupValues()) == null || (str = (String) CollectionsKt.getOrNull(groupValues, 1)) == null) {
                                upperCase = null;
                            } else {
                                Locale US = Locale.US;
                                Intrinsics.checkNotNullExpressionValue(US, "US");
                                upperCase = str.toUpperCase(US);
                                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                            }
                        }
                        if (upperCase != null) {
                            strReplace = StringsKt.removeSuffix(strReplace, (CharSequence) upperCase);
                        }
                        MatchResult matchResultMatchEntire = new Regex("^(\\d{1,2}):(\\d{2})$").matchEntire(strReplace);
                        if (matchResultMatchEntire != null && (intOrNull2 = StringsKt.toIntOrNull(matchResultMatchEntire.getGroupValues().get(1))) != null) {
                            int iIntValue5 = intOrNull2.intValue();
                            Integer intOrNull5 = StringsKt.toIntOrNull(matchResultMatchEntire.getGroupValues().get(2));
                            if (intOrNull5 != null && (iIntValue = intOrNull5.intValue()) >= 0 && iIntValue < 60) {
                                if (upperCase == null) {
                                    if (iIntValue5 < 0 || iIntValue5 >= 24) {
                                        return null;
                                    }
                                } else if (1 <= iIntValue5 && iIntValue5 < 13) {
                                    if (Intrinsics.areEqual(upperCase, "AM")) {
                                        if (iIntValue5 == 12) {
                                            iIntValue5 = 0;
                                        }
                                    } else if (Intrinsics.areEqual(upperCase, "PM")) {
                                        iIntValue5 = iIntValue5 == 12 ? 12 : iIntValue5 + 12;
                                    }
                                }
                                try {
                                    Calendar calendar = Calendar.getInstance();
                                    calendar.clear();
                                    calendar.set(1, iIntValue2);
                                    calendar.set(2, iIntValue3 - 1);
                                    calendar.set(5, iIntValue4);
                                    calendar.set(11, iIntValue5);
                                    calendar.set(12, iIntValue);
                                    calendar.set(13, 0);
                                    calendar.set(14, 0);
                                    return Long.valueOf(calendar.getTimeInMillis());
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private final boolean isCodeTicket(String ticketType) {
        return Intrinsics.areEqual(ticketType, "取餐码") || Intrinsics.areEqual(ticketType, "取件码");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r3.equals("火车票") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        if (r3.equals("车票") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006f, code lost:
    
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
            case 21282337:
                if (ticketType.equals("取件码")) {
                    return Color.rgb(154, 154, 154);
                }
                return Color.rgb(74, 140, 255);
            case 21870407:
                if (ticketType.equals("取餐码")) {
                    return Color.rgb(123, 183, 232);
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
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        if (r0.equals("火车票") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
    
        if (r0.equals("车票") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        return com.example.tickets.R.drawable.ic_live_train;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int selectSmallIcon(Context context, LiveUpdatePayload payload) {
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
                    return selectTakeoutNotificationIconRes(context, payload.getBrand());
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

    private final int selectTakeoutNotificationIconRes(Context context, String brand) {
        Integer numResolveBrandNotificationRes;
        String string = StringsKt.trim((CharSequence) brand).toString();
        if (!StringsKt.isBlank(string) && (numResolveBrandNotificationRes = TicketBrandIconResolver.INSTANCE.resolveBrandNotificationRes(context, string)) != null) {
            return numResolveBrandNotificationRes.intValue();
        }
        return R.drawable.ic_live_takeout;
    }

    private final int selectAirplaneIcon(LiveUpdatePayload payload) {
        Pair<Long, Long> pairResolveWindow = resolveWindow(payload);
        long jLongValue = pairResolveWindow.component1().longValue();
        long jLongValue2 = pairResolveWindow.component2().longValue();
        if (jLongValue == Long.MAX_VALUE) {
            return R.drawable.ic_live_plane_departure;
        }
        Long flightPhaseDateTime = parseFlightPhaseDateTime(payload.getDate(), payload.getTakeoffTime());
        Long flightPhaseDateTime2 = parseFlightPhaseDateTime(payload.getDate(), payload.getLandingTime());
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (flightPhaseDateTime == null && flightPhaseDateTime2 == null) {
            long jMin = Math.min(jLongValue + 1200000, jLongValue2);
            long jMax = Math.max(jLongValue, jLongValue2 - 1200000);
            if (jCurrentTimeMillis < jMin) {
                return R.drawable.ic_live_plane_departure;
            }
            if (jCurrentTimeMillis >= jMax) {
                return R.drawable.ic_live_plane_arrival;
            }
            return R.drawable.ic_live_plane_airborne;
        }
        if (flightPhaseDateTime != null) {
            jLongValue = flightPhaseDateTime.longValue();
        }
        if (flightPhaseDateTime2 != null) {
            if (flightPhaseDateTime2.longValue() <= jLongValue) {
                flightPhaseDateTime2 = null;
            }
            if (flightPhaseDateTime2 != null) {
                jLongValue2 = flightPhaseDateTime2.longValue();
            }
        }
        if (jCurrentTimeMillis < jLongValue) {
            return R.drawable.ic_live_plane_departure;
        }
        if (jCurrentTimeMillis >= jLongValue2) {
            return R.drawable.ic_live_plane_arrival;
        }
        return R.drawable.ic_live_plane_airborne;
    }

    private final Long parseFlightPhaseDateTime(String date, String time) {
        return parseFlexibleDateTime(date, time);
    }

    private final String formatClock(long millis) {
        String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(millis));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final boolean showSmartSubway(Context context, SmartSubwayRealtimeState state) {
        Object objM9536constructorimpl;
        int primaryLineColor;
        String lineName;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(state, "state");
        try {
            Result.Companion companion = Result.INSTANCE;
            LiveUpdateManager liveUpdateManager = this;
            createNotificationChannel(context);
            SmartSubwayHorizontalCardContent smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent = SmartSubwayRealtimeKt.buildSmartSubwayHorizontalCardContent(state);
            if (SmartSubwayRealtimeKt.isAfterTransfer(state)) {
                primaryLineColor = state.getSecondaryLineColor();
            } else {
                primaryLineColor = state.getPrimaryLineColor();
            }
            if (SmartSubwayRealtimeKt.isAfterTransfer(state) && !StringsKt.isBlank(state.getTransferLineName())) {
                lineName = state.getTransferLineName();
            } else {
                lineName = state.getLineName();
            }
            String str3 = lineName;
            if (StringsKt.isBlank(str3)) {
                str3 = "地铁";
            }
            String str4 = str3;
            String statusText = smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText();
            if (StringsKt.isBlank(statusText)) {
                if (state.isDestination()) {
                    statusText = "带齐物品准备下车";
                } else {
                    statusText = "正在前往下一站";
                }
            }
            String str5 = statusText;
            String string = StringsKt.trim((CharSequence) state.getDestination()).toString();
            if (StringsKt.isBlank(string)) {
                str = str4;
            } else {
                str = str4 + "  ·  → " + string;
            }
            String previousStation = smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getPreviousStation();
            if (StringsKt.isBlank(previousStation)) {
                String origin = state.getOrigin();
                if (StringsKt.isBlank(origin)) {
                    origin = "上一站";
                }
                previousStation = origin;
            }
            String str6 = previousStation;
            String currentStation = smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getCurrentStation();
            if (StringsKt.isBlank(currentStation)) {
                currentStation = "当前站";
            }
            String str7 = currentStation;
            String nextStation = smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getNextStation();
            if (StringsKt.isBlank(nextStation)) {
                nextStation = "下一站";
            }
            String str8 = nextStation;
            String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new String[]{str + "  ·  " + str5, str6 + "  →  " + str7 + "  →  " + str8}), "\n", null, null, 0, null, null, 62, null);
            NotificationCompat.Builder colorized = new NotificationCompat.Builder(context, RealtimeNotificationVisibilityController.channelId$default(RealtimeNotificationVisibilityController.INSTANCE, CHANNEL_BASE_ID, null, null, 6, null)).setSmallIcon(IconCompat.createWithBitmap(buildSmartSubwayStatusBarIcon(context, str4))).setLargeIcon(buildSmartSubwayAutoMatchedServiceIcon(state, 96)).setColor(primaryLineColor).setColorized(false);
            if (state.isDestination()) {
                str2 = "智能地铁 · 已到达";
            } else {
                str2 = "智能地铁 · 行程中";
            }
            NotificationCompat.Builder style = colorized.setSubText(str2).setContentTitle(str7).setContentText(strJoinToString$default).setStyle(buildSmartSubwayLiveUpdateProgressStyle(state));
            boolean z = true;
            NotificationCompat.Builder visibility = style.setOngoing(true).setOnlyAlertOnce(true).setShowWhen(false).setLocalOnly(true).setCategory(NotificationCompat.CATEGORY_NAVIGATION).setVisibility(1);
            if (!state.isDestination() && !StringsKt.isBlank(str8) && !Intrinsics.areEqual(str8, str7)) {
                visibility.addAction(0, "我已到达下一站", SmartSubwayManualAdvance.INSTANCE.createPendingIntent(context));
            }
            Intrinsics.checkNotNullExpressionValue(visibility, "apply(...)");
            if (Build.VERSION.SDK_INT >= 36) {
                visibility.setRequestPromotedOngoing(true);
            } else {
                visibility.setProgress(200, RangesKt.coerceIn(state.isDestination() ? 200 : ((int) Math.rint(RangesKt.coerceIn(state.getSegmentProgress(), 0.0f, 1.0f) * 100.0f)) + 100, 0, 200), false);
            }
            Notification notificationBuild = visibility.build();
            Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
            if (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
                NotificationManagerCompat.from(context).notify(SmartSubwayNotificationSpec.NOTIFICATION_ID, notificationBuild);
            } else {
                z = false;
            }
            objM9536constructorimpl = Result.m9536constructorimpl(Boolean.valueOf(z));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
            objM9536constructorimpl = false;
        }
        return ((Boolean) objM9536constructorimpl).booleanValue();
    }

    static /* synthetic */ Bitmap buildSmartSubwayAutoMatchedServiceIcon$default(LiveUpdateManager liveUpdateManager, SmartSubwayRealtimeState smartSubwayRealtimeState, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 96;
        }
        return liveUpdateManager.buildSmartSubwayAutoMatchedServiceIcon(smartSubwayRealtimeState, i);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00f2  */
    private final Bitmap buildSmartSubwayAutoMatchedServiceIcon(SmartSubwayRealtimeState state, int sizePx) {
        int primaryLineColor;
        String lineName;
        float f;
        float f2;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(sizePx, 64);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iCoerceAtLeast, iCoerceAtLeast, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(0);
        if (SmartSubwayRealtimeKt.isAfterTransfer(state)) {
            primaryLineColor = state.getSecondaryLineColor();
        } else {
            primaryLineColor = state.getPrimaryLineColor();
        }
        if (SmartSubwayRealtimeKt.isAfterTransfer(state) && !StringsKt.isBlank(state.getTransferLineName())) {
            lineName = state.getTransferLineName();
        } else {
            lineName = state.getLineName();
        }
        String str = lineName;
        if (StringsKt.isBlank(str)) {
            str = "地铁";
        }
        String str2 = str;
        String strSmartSubwayServiceBadgeLabel = smartSubwayServiceBadgeLabel(str2);
        String strSmartSubwayPatternBadge = smartSubwayPatternBadge(str2);
        float f3 = iCoerceAtLeast;
        float f4 = 0.07f * f3;
        float f5 = f3 - f4;
        RectF rectF = new RectF(f4, f4, f5, f5);
        Paint paint = new Paint(1);
        paint.setColor(primaryLineColor);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        paint2.setColor(-1);
        paint2.setAlpha(95);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(0.025f * f3);
        Paint paint3 = new Paint(129);
        paint3.setColor(INSTANCE.smartSubwayIconTextColor(primaryLineColor));
        paint3.setTextAlign(Paint.Align.CENTER);
        if (strSmartSubwayServiceBadgeLabel.length() != 1) {
            if (strSmartSubwayServiceBadgeLabel.length() == 2) {
                f2 = 0.31f;
            } else {
                f = f3 * 0.25f;
            }
            paint3.setTextSize(f);
            paint3.setTypeface(Typeface.create("sans-serif", 1));
            float f6 = 0.24f * f3;
            canvas.drawRoundRect(rectF, f6, f6, paint);
            canvas.drawRoundRect(rectF, f6, f6, paint2);
            float f7 = f3 / 2.0f;
            Paint.FontMetrics fontMetrics = paint3.getFontMetrics();
            canvas.drawText(strSmartSubwayServiceBadgeLabel, f7, (f7 - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f)) - (0.015f * f3), paint3);
            if (!StringsKt.isBlank(strSmartSubwayPatternBadge)) {
                Paint paint4 = new Paint(1);
                paint4.setColor(paint3.getColor());
                paint4.setTextAlign(Paint.Align.CENTER);
                paint4.setTextSize(0.15f * f3);
                paint4.setTypeface(Typeface.create("sans-serif", 1));
                canvas.drawText(strSmartSubwayPatternBadge, 0.82f * f3, f3 * 0.25f, paint4);
            }
            return bitmapCreateBitmap;
        }
        f2 = 0.4f;
        f = f2 * f3;
        paint3.setTextSize(f);
        paint3.setTypeface(Typeface.create("sans-serif", 1));
        float f8 = 0.24f * f3;
        canvas.drawRoundRect(rectF, f8, f8, paint);
        canvas.drawRoundRect(rectF, f8, f8, paint2);
        float f9 = f3 / 2.0f;
        Paint.FontMetrics fontMetrics2 = paint3.getFontMetrics();
        canvas.drawText(strSmartSubwayServiceBadgeLabel, f9, (f9 - ((fontMetrics2.ascent + fontMetrics2.descent) / 2.0f)) - (0.015f * f3), paint3);
        if (!StringsKt.isBlank(strSmartSubwayPatternBadge)) {
            Paint paint5 = new Paint(1);
            paint5.setColor(paint3.getColor());
            paint5.setTextAlign(Paint.Align.CENTER);
            paint5.setTextSize(0.15f * f3);
            paint5.setTypeface(Typeface.create("sans-serif", 1));
            canvas.drawText(strSmartSubwayPatternBadge, 0.82f * f3, f3 * 0.25f, paint5);
        }
        return bitmapCreateBitmap;
    }

    private final Bitmap buildSmartSubwayStatusBarIcon(Context context, String lineName) {
        float f;
        float f2;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(MathKt.roundToInt(context.getResources().getDisplayMetrics().density * 24.0f), 24);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iCoerceAtLeast, iCoerceAtLeast, Bitmap.Config.ALPHA_8);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(0);
        String strSmartSubwayServiceBadgeLabel = smartSubwayServiceBadgeLabel(lineName);
        Paint paint = new Paint(129);
        paint.setColor(-1);
        paint.setTextAlign(Paint.Align.CENTER);
        if (strSmartSubwayServiceBadgeLabel.length() == 1) {
            f = iCoerceAtLeast;
            f2 = 0.76f;
        } else if (strSmartSubwayServiceBadgeLabel.length() == 2) {
            f = iCoerceAtLeast;
            f2 = 0.62f;
        } else {
            f = iCoerceAtLeast;
            f2 = 0.48f;
        }
        paint.setTextSize(f * f2);
        paint.setTypeface(Typeface.create("sans-serif", 1));
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f3 = iCoerceAtLeast / 2.0f;
        canvas.drawText(strSmartSubwayServiceBadgeLabel, f3, f3 - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), paint);
        return bitmapCreateBitmap;
    }

    private final String smartSubwayServiceBadgeLabel(String lineName) {
        String string = StringsKt.trim((CharSequence) new Regex("(?i)\\bline\\b").replace(StringsKt.removeSuffix(StringsKt.trim((CharSequence) lineName).toString(), (CharSequence) "号线"), "")).toString();
        if (StringsKt.isBlank(string)) {
            string = "M";
        }
        String str = string;
        String str2 = (String) CollectionsKt.firstOrNull((List) new Regex("\\s+").split(str, 0));
        String str3 = str2 != null ? str2 : "";
        if (!StringsKt.isBlank(str3) && (StringsKt.contains((CharSequence) str, (CharSequence) "Local", true) || StringsKt.contains((CharSequence) str, (CharSequence) "Express", true))) {
            string = str3;
        }
        return StringsKt.take(string, 3);
    }

    private final String smartSubwayPatternBadge(String lineName) {
        String str = lineName;
        if (StringsKt.contains((CharSequence) str, (CharSequence) "Express", true)) {
            return ExifInterface.LONGITUDE_EAST;
        }
        return StringsKt.contains((CharSequence) str, (CharSequence) "Local", true) ? "L" : "";
    }

    private final int smartSubwayIconTextColor(int backgroundColor) {
        return (((((float) Color.red(backgroundColor)) / 255.0f) * 0.2126f) + ((((float) Color.green(backgroundColor)) / 255.0f) * 0.7152f)) + ((((float) Color.blue(backgroundColor)) / 255.0f) * 0.0722f) > 0.6f ? -16777216 : -1;
    }

    private final NotificationCompat.ProgressStyle buildSmartSubwayLiveUpdateProgressStyle(SmartSubwayRealtimeState state) {
        int secondaryLineColor = SmartSubwayRealtimeKt.isAfterTransfer(state) ? state.getSecondaryLineColor() : state.getPrimaryLineColor();
        NotificationCompat.ProgressStyle.Segment id = new NotificationCompat.ProgressStyle.Segment(100).setColor(state.getPrimaryLineColor()).setId(1);
        Intrinsics.checkNotNullExpressionValue(id, "setId(...)");
        NotificationCompat.ProgressStyle.Segment id2 = new NotificationCompat.ProgressStyle.Segment(100).setColor(secondaryLineColor).setId(2);
        Intrinsics.checkNotNullExpressionValue(id2, "setId(...)");
        NotificationCompat.ProgressStyle progressPoints = new NotificationCompat.ProgressStyle().setStyledByProgress(true).setProgress(RangesKt.coerceIn(state.isDestination() ? 180 : ((int) Math.rint(RangesKt.coerceIn(state.getSegmentProgress(), 0.0f, 1.0f) * 80.0f)) + 100, 0, 200)).setProgressSegments(CollectionsKt.listOf((Object[]) new NotificationCompat.ProgressStyle.Segment[]{id, id2})).setProgressPoints(CollectionsKt.listOf((Object[]) new NotificationCompat.ProgressStyle.Point[]{new NotificationCompat.ProgressStyle.Point(20).setId(1).setColor(Color.rgb(142, 145, 151)), new NotificationCompat.ProgressStyle.Point(100).setId(2).setColor(state.getPrimaryLineColor()), new NotificationCompat.ProgressStyle.Point(180).setId(3).setColor(secondaryLineColor)}));
        Intrinsics.checkNotNullExpressionValue(progressPoints, "setProgressPoints(...)");
        return progressPoints;
    }

    public final void cancelSmartSubway(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            LiveUpdateManager liveUpdateManager = this;
            NotificationManagerCompat.from(context).cancel(SmartSubwayNotificationSpec.NOTIFICATION_ID);
            Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
    }
}
