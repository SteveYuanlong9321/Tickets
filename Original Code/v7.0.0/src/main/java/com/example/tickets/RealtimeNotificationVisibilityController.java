package com.example.tickets;

import android.app.NotificationManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RealtimeNotificationVisibilityController.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\fJ0\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u0005R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/example/tickets/RealtimeNotificationVisibilityController;", "", "<init>", "()V", "value", "", "isAppForeground", "()Z", "setAppForeground", "", "foreground", "channelId", "", "baseId", "foregroundIdSuffix", "backgroundIdSuffix", "createVisibilityChannels", "manager", "Landroid/app/NotificationManager;", "channelName", "description", "showBadge", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RealtimeNotificationVisibilityController {
    private static volatile boolean isAppForeground;
    public static final RealtimeNotificationVisibilityController INSTANCE = new RealtimeNotificationVisibilityController();
    public static final int $stable = 8;

    private RealtimeNotificationVisibilityController() {
    }

    public final boolean isAppForeground() {
        return isAppForeground;
    }

    public final void setAppForeground(boolean foreground) {
        isAppForeground = foreground;
    }

    public static /* synthetic */ String channelId$default(RealtimeNotificationVisibilityController realtimeNotificationVisibilityController, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "_foreground";
        }
        if ((i & 4) != 0) {
            str3 = "_background";
        }
        return realtimeNotificationVisibilityController.channelId(str, str2, str3);
    }

    public final String channelId(String baseId, String foregroundIdSuffix, String backgroundIdSuffix) {
        Intrinsics.checkNotNullParameter(baseId, "baseId");
        Intrinsics.checkNotNullParameter(foregroundIdSuffix, "foregroundIdSuffix");
        Intrinsics.checkNotNullParameter(backgroundIdSuffix, "backgroundIdSuffix");
        if (isAppForeground) {
            return baseId + foregroundIdSuffix;
        }
        return baseId + backgroundIdSuffix;
    }

    public static /* synthetic */ void createVisibilityChannels$default(RealtimeNotificationVisibilityController realtimeNotificationVisibilityController, NotificationManager notificationManager, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            z = false;
        }
        realtimeNotificationVisibilityController.createVisibilityChannels(notificationManager, str, str2, str3, z);
    }

    public final void createVisibilityChannels(NotificationManager manager, String baseId, String channelName, String description, boolean showBadge) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(baseId, "baseId");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(description, "description");
        manager.createNotificationChannel(NotificationManagerChannelFactory.INSTANCE.create(baseId + "_foreground", channelName, 1, description, showBadge));
        manager.createNotificationChannel(NotificationManagerChannelFactory.INSTANCE.create(baseId + "_background", channelName, 2, description, showBadge));
    }
}
