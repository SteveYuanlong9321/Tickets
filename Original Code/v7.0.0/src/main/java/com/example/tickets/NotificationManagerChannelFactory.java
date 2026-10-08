package com.example.tickets;

import android.app.NotificationChannel;
import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RealtimeNotificationVisibilityController.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/example/tickets/NotificationManagerChannelFactory;", "", "<init>", "()V", "create", "Landroid/app/NotificationChannel;", "id", "", HintConstants.AUTOFILL_HINT_NAME, "importance", "", "description", "showBadge", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class NotificationManagerChannelFactory {
    public static final NotificationManagerChannelFactory INSTANCE = new NotificationManagerChannelFactory();

    private NotificationManagerChannelFactory() {
    }

    public final NotificationChannel create(String id, String name, int importance, String description, boolean showBadge) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        NotificationChannel notificationChannel = new NotificationChannel(id, name, importance);
        notificationChannel.setDescription(description);
        notificationChannel.setShowBadge(showBadge);
        return notificationChannel;
    }
}
