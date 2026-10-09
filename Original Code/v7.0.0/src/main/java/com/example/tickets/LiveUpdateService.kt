package com.example.tickets;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.ServiceCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.lifecycle.CoroutineLiveDataKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LiveUpdateService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\"\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\u0014\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006!"}, d2 = {"Lcom/example/tickets/LiveUpdateService;", "Landroid/app/Service;", "<init>", "()V", "handler", "Landroid/os/Handler;", "active", "Ljava/util/LinkedHashMap;", "", "Lcom/example/tickets/LiveUpdatePayload;", "Lkotlin/collections/LinkedHashMap;", "xiaomiMode", "", "updater", "com/example/tickets/LiveUpdateService$updater$1", "Lcom/example/tickets/LiveUpdateService$updater$1;", "onCreate", "", "onStartCommand", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_INTENT, "Landroid/content/Intent;", "flags", "startId", "promoteFirstPayload", "refresh", "updateForegroundNotification", "notificationId", "notification", "Landroid/app/Notification;", "stopIdle", "onDestroy", "onBind", "Landroid/os/IBinder;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LiveUpdateService extends Service {
    public static final int $stable = 8;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final LinkedHashMap<Integer, LiveUpdatePayload> active = new LinkedHashMap<>();
    private final Set<Integer> xiaomiMode = new LinkedHashSet();
    private final LiveUpdateService$updater$1 updater = new Runnable() { // from class: com.example.tickets.LiveUpdateService$updater$1
        @Override // java.lang.Runnable
        public void run() {
            this.this$0.refresh();
            if (this.this$0.active.isEmpty()) {
                return;
            }
            this.this$0.handler.postDelayed(this, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        LiveUpdateManager.INSTANCE.createNotificationChannel(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        int intExtra;
        int iNotificationId;
        if (intent == null) {
            return 2;
        }
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != 653312063) {
                if (iHashCode == 1003297151 && action.equals(LiveUpdateManager.ACTION_STOP) && (intExtra = intent.getIntExtra("ticket_id", 0)) != 0) {
                    this.active.remove(Integer.valueOf(intExtra));
                    boolean zRemove = this.xiaomiMode.remove(Integer.valueOf(intExtra));
                    NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(this);
                    if (zRemove) {
                        iNotificationId = XiaomiSuperIslandManager.INSTANCE.notificationId(intExtra);
                    } else {
                        iNotificationId = LiveUpdateManager.INSTANCE.notificationId(intExtra);
                    }
                    notificationManagerCompatFrom.cancel(iNotificationId);
                    if (this.active.isEmpty()) {
                        stopIdle();
                    } else {
                        promoteFirstPayload();
                    }
                }
            } else if (action.equals(LiveUpdateManager.ACTION_START)) {
                LiveUpdatePayload liveUpdatePayloadBuildPayload = LiveUpdateManager.INSTANCE.buildPayload(intent);
                if (liveUpdatePayloadBuildPayload.getTicketId() != 0) {
                    this.active.put(Integer.valueOf(liveUpdatePayloadBuildPayload.getTicketId()), liveUpdatePayloadBuildPayload);
                    boolean booleanExtra = intent.getBooleanExtra(XiaomiSuperIslandManager.EXTRA_XIAOMI_MODE, false);
                    Set<Integer> set = this.xiaomiMode;
                    if (booleanExtra) {
                        set.add(Integer.valueOf(liveUpdatePayloadBuildPayload.getTicketId()));
                    } else {
                        set.remove(Integer.valueOf(liveUpdatePayloadBuildPayload.getTicketId()));
                    }
                    promoteFirstPayload();
                    refresh();
                }
            }
        }
        this.handler.removeCallbacks(this.updater);
        if (!this.active.isEmpty()) {
            this.handler.post(this.updater);
        }
        return 2;
    }

    private final void promoteFirstPayload() {
        Notification notificationBuildNotification;
        int iNotificationId;
        Collection<LiveUpdatePayload> collectionValues = this.active.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        LiveUpdatePayload liveUpdatePayload = (LiveUpdatePayload) CollectionsKt.firstOrNull(collectionValues);
        if (liveUpdatePayload == null) {
            return;
        }
        boolean zContains = this.xiaomiMode.contains(Integer.valueOf(liveUpdatePayload.getTicketId()));
        if (zContains) {
            notificationBuildNotification = XiaomiSuperIslandManager.INSTANCE.buildNotification$app(this, liveUpdatePayload);
        } else {
            notificationBuildNotification = LiveUpdateManager.INSTANCE.buildNotification(this, liveUpdatePayload);
        }
        if (zContains) {
            iNotificationId = XiaomiSuperIslandManager.INSTANCE.notificationId(liveUpdatePayload.getTicketId());
        } else {
            iNotificationId = LiveUpdateManager.INSTANCE.notificationId(liveUpdatePayload.getTicketId());
        }
        boolean z = Build.VERSION.SDK_INT < 28 || checkSelfPermission("android.permission.FOREGROUND_SERVICE") == 0;
        boolean z2 = Build.VERSION.SDK_INT < 34 || checkSelfPermission("android.permission.FOREGROUND_SERVICE_SPECIAL_USE") == 0;
        if (z && z2) {
            try {
                if (Build.VERSION.SDK_INT >= 34) {
                    ServiceCompat.startForeground(this, iNotificationId, notificationBuildNotification, GroupFlagsKt.IsSubcompositionContextFlag);
                } else {
                    startForeground(iNotificationId, notificationBuildNotification);
                }
            } catch (SecurityException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:45:0x010e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0115  */
    /* JADX WARN: Code duplicated, block: B:78:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x00f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0160, code lost:
    
        if (r10 != (r7 != null && r21.xiaomiMode.contains(r7))) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void refresh() {
        Pair<Long, Long> pair;
        int iNotificationId;
        Notification notificationBuildNotification;
        LiveUpdateService liveUpdateService = this;
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(liveUpdateService);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatFrom, "from(...)");
        long jCurrentTimeMillis = System.currentTimeMillis();
        Collection<LiveUpdatePayload> collectionValues = this.active.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        LiveUpdatePayload liveUpdatePayload = (LiveUpdatePayload) CollectionsKt.firstOrNull(collectionValues);
        Integer numValueOf = liveUpdatePayload != null ? Integer.valueOf(liveUpdatePayload.getTicketId()) : null;
        boolean z = numValueOf != null && this.xiaomiMode.contains(numValueOf);
        Iterator<Map.Entry<Integer, LiveUpdatePayload>> it = this.active.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, LiveUpdatePayload> next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            LiveUpdatePayload value = next.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
            LiveUpdatePayload liveUpdatePayload2 = value;
            boolean z2 = Intrinsics.areEqual(liveUpdatePayload2.getTicketType(), "取餐码") || Intrinsics.areEqual(liveUpdatePayload2.getTicketType(), "取件码");
            if (z2) {
                pair = LiveUpdateManager.INSTANCE.resolveWindow(liveUpdatePayload2);
            } else {
                pair = new Pair<>(0L, 0L);
            }
            RealtimeNotificationState realtimeNotificationStateCalculate = z2 ? null : RealtimeNotificationStateCalculator.INSTANCE.calculate(liveUpdatePayload2, jCurrentTimeMillis);
            boolean zContains = this.xiaomiMode.contains(Integer.valueOf(liveUpdatePayload2.getTicketId()));
            if (zContains) {
                iNotificationId = XiaomiSuperIslandManager.INSTANCE.notificationId(liveUpdatePayload2.getTicketId());
            } else {
                iNotificationId = LiveUpdateManager.INSTANCE.notificationId(liveUpdatePayload2.getTicketId());
            }
            if (!z2) {
                if ((realtimeNotificationStateCalculate != null ? realtimeNotificationStateCalculate.getStatus() : null) == RealtimeNotificationStatus.FINISHED) {
                    notificationManagerCompatFrom.cancel(iNotificationId);
                    this.xiaomiMode.remove(Integer.valueOf(liveUpdatePayload2.getTicketId()));
                    it.remove();
                } else {
                    if (zContains) {
                        notificationBuildNotification = XiaomiSuperIslandManager.INSTANCE.buildNotification$app(liveUpdateService, liveUpdatePayload2);
                    } else {
                        notificationBuildNotification = LiveUpdateManager.INSTANCE.buildNotification(liveUpdateService, liveUpdatePayload2);
                    }
                    if (Build.VERSION.SDK_INT >= 33) {
                        notificationManagerCompatFrom.notify(iNotificationId, notificationBuildNotification);
                    } else {
                        notificationManagerCompatFrom.notify(iNotificationId, notificationBuildNotification);
                    }
                }
            } else if (pair.getFirst().longValue() == Long.MAX_VALUE || jCurrentTimeMillis >= pair.getSecond().longValue()) {
                try {
                    notificationManagerCompatFrom.cancel(iNotificationId);
                } catch (SecurityException unused) {
                }
                this.xiaomiMode.remove(Integer.valueOf(liveUpdatePayload2.getTicketId()));
                it.remove();
            } else {
                if (zContains) {
                    notificationBuildNotification = XiaomiSuperIslandManager.INSTANCE.buildNotification$app(liveUpdateService, liveUpdatePayload2);
                } else {
                    notificationBuildNotification = LiveUpdateManager.INSTANCE.buildNotification(liveUpdateService, liveUpdatePayload2);
                }
                if (Build.VERSION.SDK_INT >= 33 || checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
                    try {
                        notificationManagerCompatFrom.notify(iNotificationId, notificationBuildNotification);
                    } catch (SecurityException unused2) {
                    }
                }
            }
        }
        Collection<LiveUpdatePayload> collectionValues2 = this.active.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues2, "<get-values>(...)");
        LiveUpdatePayload liveUpdatePayload3 = (LiveUpdatePayload) CollectionsKt.firstOrNull(collectionValues2);
        Integer numValueOf2 = liveUpdatePayload3 != null ? Integer.valueOf(liveUpdatePayload3.getTicketId()) : null;
        if (numValueOf != null) {
            if (Intrinsics.areEqual(numValueOf2, numValueOf)) {
            }
            try {
                if (z) {
                    notificationManagerCompatFrom.cancel(XiaomiSuperIslandManager.INSTANCE.notificationId(numValueOf.intValue()));
                } else {
                    notificationManagerCompatFrom.cancel(LiveUpdateManager.INSTANCE.notificationId(numValueOf.intValue()));
                }
            } catch (SecurityException unused3) {
            }
            if (numValueOf2 != null) {
                promoteFirstPayload();
                return;
            } else {
                stopIdle();
                return;
            }
        }
        if (numValueOf2 == null) {
            stopIdle();
        }
    }

    private final void updateForegroundNotification(int notificationId, Notification notification) {
        if (RealtimeNotificationVisibilityController.INSTANCE.isAppForeground()) {
            return;
        }
        boolean z = Build.VERSION.SDK_INT < 28 || checkSelfPermission("android.permission.FOREGROUND_SERVICE") == 0;
        boolean z2 = Build.VERSION.SDK_INT < 34 || checkSelfPermission("android.permission.FOREGROUND_SERVICE_SPECIAL_USE") == 0;
        if (z && z2) {
            try {
                if (Build.VERSION.SDK_INT >= 34) {
                    ServiceCompat.startForeground(this, notificationId, notification, GroupFlagsKt.IsSubcompositionContextFlag);
                } else {
                    startForeground(notificationId, notification);
                }
            } catch (SecurityException unused) {
            }
        }
    }

    private final void stopIdle() {
        this.handler.removeCallbacks(this.updater);
        stopForeground(1);
        stopSelf();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.handler.removeCallbacks(this.updater);
        super.onDestroy();
    }
}
