package com.example.tickets;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.compose.material3.internal.CalendarModelKt;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J+\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u001dJ%\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b J\u001d\u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u000eH\u0000¢\u0006\u0002\b#J#\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0000¢\u0006\u0002\b%J=\u0010&\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0000¢\u0006\u0002\b+J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001f\u00100\u001a\u0004\u0018\u00010-2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0002¢\u0006\u0002\u00101R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/example/tickets/ReminderManager;", "", "<init>", "()V", "CHANNEL_ID", "", "CHANNEL_NAME", "ACTION_REMINDER", "EXTRA_TICKET_ID", "EXTRA_TITLE", "EXTRA_TYPE", "EXTRA_DATE", "EXTRA_TIME", "REQUEST_BASE", "", "NOTIFICATION_BASE", "createNotificationChannel", "", "context", "Landroid/content/Context;", "createNotificationChannel$app", "scheduleAll", "tickets", "", "Lcom/example/tickets/TicketData;", "settings", "Lcom/example/tickets/AppSettings;", "scheduleAll$app", "rescheduleStoredReminders", "rescheduleStoredReminders$app", "scheduleTicketReminder", "ticket", "scheduleTicketReminder$app", "cancelTicketReminder", "ticketId", "cancelTicketReminder$app", "cancelAll", "cancelAll$app", "showReminderNotification", "title", "ticketType", "date", "time", "showReminderNotification$app", "reminderLeadMillis", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Lcom/example/tickets/TicketType;", "parseReminderDateTime", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReminderManager {
    public static final int $stable = 0;
    private static final String ACTION_REMINDER = "com.example.tickets.action.REMINDER";
    private static final String CHANNEL_ID = "ticket_reminders";
    private static final String CHANNEL_NAME = "票据提醒";
    public static final String EXTRA_DATE = "ticket_date";
    public static final String EXTRA_TICKET_ID = "ticket_id";
    public static final String EXTRA_TIME = "ticket_time";
    public static final String EXTRA_TITLE = "ticket_title";
    public static final String EXTRA_TYPE = "ticket_type";
    public static final ReminderManager INSTANCE = new ReminderManager();
    private static final int NOTIFICATION_BASE = 62000;
    private static final int REQUEST_BASE = 52000;

    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TicketType.values().length];
            try {
                iArr[TicketType.Airplane.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TicketType.Train.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TicketType.Event.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ReminderManager() {
    }

    public final void createNotificationChannel$app(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, 4);
        notificationChannel.setDescription("票据行程开始前提醒");
        notificationChannel.setShowBadge(true);
        ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
    }

    public final void scheduleAll$app(Context context, List<TicketData> tickets, AppSettings settings) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tickets, "tickets");
        Intrinsics.checkNotNullParameter(settings, "settings");
        if (settings.getReminderEnabled()) {
            Iterator<T> it = tickets.iterator();
            while (it.hasNext()) {
                INSTANCE.scheduleTicketReminder$app(context, (TicketData) it.next(), settings);
            }
        }
    }

    public final void rescheduleStoredReminders$app(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppSettings appSettingsLoadReminderSettings = MainActivityKt.loadReminderSettings(context);
        if (appSettingsLoadReminderSettings.getReminderEnabled()) {
            scheduleAll$app(context, MainActivityKt.loadTicketsFromLocal(context), appSettingsLoadReminderSettings);
        }
    }

    public final void scheduleTicketReminder$app(Context context, TicketData ticket, AppSettings settings) {
        Long reminderDateTime;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        Intrinsics.checkNotNullParameter(settings, "settings");
        cancelTicketReminder$app(context, ticket.getId());
        if (!settings.getReminderEnabled() || StringsKt.isBlank(ticket.getDate()) || StringsKt.isBlank(ticket.getTime())) {
            return;
        }
        if ((Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) && (reminderDateTime = parseReminderDateTime(ticket.getDate(), ticket.getTime())) != null) {
            long jLongValue = reminderDateTime.longValue() - reminderLeadMillis(ticket.getType(), settings);
            if (jLongValue <= System.currentTimeMillis()) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) ReminderReceiver.class);
            intent.setAction("com.example.tickets.action.REMINDER");
            intent.putExtra("ticket_id", ticket.getId());
            String title = ticket.getTitle();
            if (StringsKt.isBlank(title)) {
                title = ticket.getCode();
            }
            String str = title;
            if (StringsKt.isBlank(str)) {
                str = "票据";
            }
            intent.putExtra("ticket_title", str);
            intent.putExtra("ticket_type", MainActivityKt.ticketTypeName(ticket.getType()));
            intent.putExtra("ticket_date", ticket.getDate());
            intent.putExtra("ticket_time", ticket.getTime());
            PendingIntent broadcast = PendingIntent.getBroadcast(context, ticket.getId() + REQUEST_BASE, intent, 201326592);
            Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
            AlarmManager alarmManager = (AlarmManager) systemService;
            try {
                if (Build.VERSION.SDK_INT >= 31) {
                    if (alarmManager.canScheduleExactAlarms()) {
                        alarmManager.setExactAndAllowWhileIdle(0, jLongValue, broadcast);
                        return;
                    } else {
                        alarmManager.setAndAllowWhileIdle(0, jLongValue, broadcast);
                        return;
                    }
                }
                alarmManager.setAndAllowWhileIdle(0, jLongValue, broadcast);
            } catch (SecurityException unused) {
            }
        }
    }

    public final void cancelTicketReminder$app(Context context, int ticketId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, (Class<?>) ReminderReceiver.class);
        intent.setAction("com.example.tickets.action.REMINDER");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, REQUEST_BASE + ticketId, intent, 201326592);
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        ((AlarmManager) systemService).cancel(broadcast);
        broadcast.cancel();
        NotificationManagerCompat.from(context).cancel(ticketId + NOTIFICATION_BASE);
    }

    public final void cancelAll$app(Context context, List<TicketData> tickets) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tickets, "tickets");
        Iterator<T> it = tickets.iterator();
        while (it.hasNext()) {
            INSTANCE.cancelTicketReminder$app(context, ((TicketData) it.next()).getId());
        }
    }

    public final void showReminderNotification$app(Context context, int ticketId, String title, String ticketType, String date, String time) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(ticketType, "ticketType");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        if (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
            createNotificationChannel$app(context);
            Notification notificationBuild = new NotificationCompat.Builder(context, CHANNEL_ID).setSmallIcon(context.getApplicationInfo().icon != 0 ? context.getApplicationInfo().icon : android.R.drawable.ic_dialog_info).setContentTitle("行程即将开始").setContentText(title + "  ·  " + ticketType + "  ·  " + date + " " + time).setStyle(new NotificationCompat.BigTextStyle().bigText(title + "\n" + ticketType + "  ·  " + date + " " + time)).setPriority(1).setAutoCancel(true).setDefaults(-1).build();
            Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
            NotificationManagerCompat.from(context).notify(ticketId + NOTIFICATION_BASE, notificationBuild);
        }
    }

    private final long reminderLeadMillis(TicketType type, AppSettings settings) {
        String flightReminder;
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            flightReminder = settings.getFlightReminder();
        } else if (i == 2) {
            flightReminder = settings.getTrainReminder();
        } else if (i == 3) {
            flightReminder = settings.getEventReminder();
        } else {
            flightReminder = settings.getDefaultReminder();
        }
        if (StringsKt.startsWith$default(flightReminder, "自定义:", false, 2, (Object) null)) {
            MatchResult matchResultMatchEntire = new Regex("^(\\d+)(分钟|小时|天)$").matchEntire(StringsKt.trim((CharSequence) StringsKt.removePrefix(flightReminder, (CharSequence) "自定义:")).toString());
            if (matchResultMatchEntire != null) {
                Long longOrNull = StringsKt.toLongOrNull(matchResultMatchEntire.getGroupValues().get(1));
                long jLongValue = longOrNull != null ? longOrNull.longValue() : 0L;
                if (jLongValue > 0) {
                    String str = matchResultMatchEntire.getGroupValues().get(2);
                    int iHashCode = str.hashCode();
                    if (iHashCode != 22825) {
                        if (iHashCode != 688985) {
                            if (iHashCode == 756679 && str.equals("小时")) {
                                return jLongValue * 3600000;
                            }
                        } else if (str.equals("分钟")) {
                            return jLongValue * 60000;
                        }
                    } else if (str.equals("天")) {
                        return jLongValue * CalendarModelKt.MillisecondsIn24Hours;
                    }
                    return 7200000L;
                }
            }
        }
        String str2 = flightReminder;
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "1小时", false, 2, (Object) null)) {
            return 3600000L;
        }
        if (!StringsKt.contains$default((CharSequence) str2, (CharSequence) "2小时", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str2, (CharSequence) "1天", false, 2, (Object) null)) {
            return CalendarModelKt.MillisecondsIn24Hours;
        }
        return 7200000L;
    }

    private final Long parseReminderDateTime(String date, String time) {
        Iterator it = CollectionsKt.listOf((Object[]) new String[]{"yyyy/MM/dd HH:mm", "yyyy-MM-dd HH:mm", "yyyy年M月d日 HH:mm", "yyyy/M/d HH:mm"}).iterator();
        while (it.hasNext()) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat((String) it.next(), Locale.CHINA);
                simpleDateFormat.setLenient(false);
                Date date2 = simpleDateFormat.parse(date + " " + time);
                if (date2 != null) {
                    return Long.valueOf(date2.getTime());
                }
                continue;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
