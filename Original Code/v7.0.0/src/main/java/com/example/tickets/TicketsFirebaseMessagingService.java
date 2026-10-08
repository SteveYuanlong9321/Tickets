package com.example.tickets;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TicketsFirebaseMessagingService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/example/tickets/TicketsFirebaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "<init>", "()V", "onNewToken", "", "token", "", "onMessageReceived", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TicketsFirebaseMessagingService extends FirebaseMessagingService {
    public static final int $stable = 8;

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        super.onNewToken(token);
        getSharedPreferences("tickets_fcm", 0).edit().putString("fcm_token", token).apply();
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage message) {
        Integer intOrNull;
        Integer intOrNull2;
        Intrinsics.checkNotNullParameter(message, "message");
        super.onMessageReceived(message);
        Map<String, String> data = message.getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        String str = data.get(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        if (str == null) {
            str = "";
        }
        int iHashCode = str.hashCode();
        if (iHashCode == -982719620 ? str.equals("live_update") : iHashCode == -123122681 ? str.equals("realtime_refresh") : !(iHashCode != 2111715161 || !str.equals("super_island"))) {
            if (Boolean.parseBoolean(OnlineRecognitionStore.INSTANCE.loadString$app(this, "fcm_integration_enabled", "false"))) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    TicketsFirebaseMessagingService ticketsFirebaseMessagingService = this;
                    RealtimeBackgroundPublisher.INSTANCE.refresh(this);
                    Result.m9536constructorimpl(Unit.INSTANCE);
                    return;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m9536constructorimpl(ResultKt.createFailure(th));
                    return;
                }
            }
            return;
        }
        String title = data.get("title");
        if (title == null) {
            RemoteMessage.Notification notification = message.getNotification();
            title = notification != null ? notification.getTitle() : null;
            if (title == null) {
                title = "票据提醒";
            }
        }
        String str2 = data.get("body");
        if (str2 == null) {
            RemoteMessage.Notification notification2 = message.getNotification();
            String body = notification2 != null ? notification2.getBody() : null;
            str2 = body == null ? "有新的票据提醒" : body;
        }
        String str3 = data.get("notificationId");
        int iIntValue = (str3 == null || (intOrNull2 = StringsKt.toIntOrNull(str3)) == null) ? 74000 : intOrNull2.intValue();
        String str4 = data.get("ticketId");
        int iIntValue2 = iIntValue + ((str4 == null || (intOrNull = StringsKt.toIntOrNull(str4)) == null) ? 0 : intOrNull.intValue());
        TicketsFirebaseMessagingService ticketsFirebaseMessagingService2 = this;
        Intent intent = new Intent(ticketsFirebaseMessagingService2, (Class<?>) MainActivity.class);
        intent.setFlags(335544320);
        String str5 = data.get("ticketId");
        intent.putExtra("fcm_ticket_id", str5 != null ? str5 : "");
        intent.putExtra("fcm_event_type", str);
        PendingIntent activity = PendingIntent.getActivity(ticketsFirebaseMessagingService2, iIntValue2, intent, 201326592);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(new NotificationChannel("ticket_fcm", "FCM提醒", 4));
        String str6 = str2;
        NotificationCompat.Builder priority = new NotificationCompat.Builder(ticketsFirebaseMessagingService2, "ticket_fcm").setSmallIcon(R.mipmap.ic_launcher).setContentTitle(title).setContentText(str6).setStyle(new NotificationCompat.BigTextStyle().bigText(str6)).setAutoCancel(true).setContentIntent(activity).setPriority(1);
        Intrinsics.checkNotNullExpressionValue(priority, "setPriority(...)");
        if (ContextCompat.checkSelfPermission(ticketsFirebaseMessagingService2, "android.permission.POST_NOTIFICATIONS") == 0 || Build.VERSION.SDK_INT < 33) {
            notificationManager.notify(iIntValue2, priority.build());
        }
    }
}
