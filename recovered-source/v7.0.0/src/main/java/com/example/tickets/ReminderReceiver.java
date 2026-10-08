package com.example.tickets;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ReminderReceiver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\f"}, d2 = {"Lcom/example/tickets/ReminderReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_INTENT, "Landroid/content/Intent;", "createNotificationChannel", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReminderReceiver extends BroadcastReceiver {
    public static final String ACTION_REMINDER = "com.example.tickets.action.REMINDER";
    private static final String CHANNEL_ID = "ticket_reminders";
    private static final String CHANNEL_NAME = "票据提醒";
    public static final String EXTRA_DATE = "ticket_date";
    public static final String EXTRA_TICKET_ID = "ticket_id";
    public static final String EXTRA_TIME = "ticket_time";
    public static final String EXTRA_TITLE = "ticket_title";
    public static final String EXTRA_TYPE = "ticket_type";
    private static final int NOTIFICATION_BASE = 62000;
    private static final String TAG = "TicketsReminder";
    public static final int $stable = 8;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!Intrinsics.areEqual(intent != null ? intent.getAction() : null, ACTION_REMINDER)) {
            Log.d(TAG, "Ignored broadcast: action=" + (intent != null ? intent.getAction() : null));
            return;
        }
        int intExtra = intent.getIntExtra("ticket_id", 0);
        if (intExtra == 0) {
            Log.e(TAG, "Reminder received without ticketId");
            return;
        }
        String stringExtra = intent.getStringExtra("ticket_title");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String str2 = stringExtra;
        if (StringsKt.isBlank(str2)) {
            str2 = "票据";
        }
        String str3 = str2;
        String stringExtra2 = intent.getStringExtra("ticket_type");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        String str4 = stringExtra2;
        if (StringsKt.isBlank(str4)) {
            str4 = "行程";
        }
        String str5 = str4;
        String stringExtra3 = intent.getStringExtra("ticket_date");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        String stringExtra4 = intent.getStringExtra("ticket_time");
        String str6 = stringExtra4 != null ? stringExtra4 : "";
        Log.d(TAG, "ReminderReceiver fired: ticketId=" + intExtra + ", title=" + str3);
        if (Build.VERSION.SDK_INT >= 33 && context.checkSelfPermission("android.permission.POST_NOTIFICATIONS") != 0) {
            Log.e(TAG, "POST_NOTIFICATIONS not granted");
            return;
        }
        createNotificationChannel(context);
        if (StringsKt.isBlank(stringExtra3) && StringsKt.isBlank(str6)) {
            str = str5 + " · 请查看票据详情";
        } else {
            str = str5 + " · " + stringExtra3 + " " + str6;
        }
        Notification notificationBuild = new NotificationCompat.Builder(context, CHANNEL_ID).setSmallIcon(context.getApplicationInfo().icon != 0 ? context.getApplicationInfo().icon : android.R.drawable.ic_dialog_info).setContentTitle("行程即将开始").setContentText(str3 + " · " + str).setStyle(new NotificationCompat.BigTextStyle().bigText(str3 + "\n" + str)).setPriority(1).setAutoCancel(true).setDefaults(-1).build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        try {
            NotificationManagerCompat.from(context).notify(NOTIFICATION_BASE + intExtra, notificationBuild);
            Log.d(TAG, "Reminder notification posted: ticketId=" + intExtra);
        } catch (SecurityException e) {
            Log.e(TAG, "Reminder notification SecurityException", e);
        }
    }

    private final void createNotificationChannel(Context context) {
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, 4);
        notificationChannel.setDescription("票据行程开始前提醒");
        notificationChannel.setShowBadge(true);
        ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
    }
}
