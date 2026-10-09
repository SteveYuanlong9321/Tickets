package com.example.tickets;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TicketNotificationListenerService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"Lcom/example/tickets/TicketNotificationListenerService;", "Landroid/service/notification/NotificationListenerService;", "<init>", "()V", "onListenerConnected", "", "onListenerDisconnected", "onNotificationPosted", "sbn", "Landroid/service/notification/StatusBarNotification;", "onNotificationRemoved", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TicketNotificationListenerService extends NotificationListenerService {
    private static final String LIVE_UPDATE_CHANNEL = "ticket_live_updates";
    private static final String SAMSUNG_CHANNEL = "ticket_samsung_now_bar";
    private static final String TAG = "TicketsSamsungLive";
    private static final String TICKETS_PACKAGE = "com.example.tickets";
    public static final int $stable = 8;

    @Override // android.service.notification.NotificationListenerService
    public void onListenerConnected() {
        super.onListenerConnected();
        Log.d(TAG, "NotificationListener connected");
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerDisconnected() {
        Log.d(TAG, "NotificationListener disconnected");
        super.onListenerDisconnected();
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification sbn) {
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        if (Intrinsics.areEqual(sbn.getPackageName(), TICKETS_PACKAGE)) {
            String channelId = sbn.getNotification().getChannelId();
            if (channelId == null) {
                channelId = "";
            }
            if (Intrinsics.areEqual(channelId, LIVE_UPDATE_CHANNEL) || Intrinsics.areEqual(channelId, SAMSUNG_CHANNEL)) {
                Log.d(TAG, "Tickets realtime notification posted: id=" + sbn.getId() + ", channel=" + channelId);
            }
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification sbn) {
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        if (Intrinsics.areEqual(sbn.getPackageName(), TICKETS_PACKAGE)) {
            String channelId = sbn.getNotification().getChannelId();
            if (channelId == null) {
                channelId = "";
            }
            if (Intrinsics.areEqual(channelId, LIVE_UPDATE_CHANNEL) || Intrinsics.areEqual(channelId, SAMSUNG_CHANNEL)) {
                Log.d(TAG, "Tickets realtime notification removed: id=" + sbn.getId() + ", channel=" + channelId);
            }
        }
    }
}
