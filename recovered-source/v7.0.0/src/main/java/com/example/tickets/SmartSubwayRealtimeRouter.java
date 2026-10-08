package com.example.tickets;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmartSubwayRealtimeRouter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\r"}, d2 = {"Lcom/example/tickets/SmartSubwayRealtimeRouter;", "", "<init>", "()V", "publish", "", "context", "Landroid/content/Context;", "mode", "", "state", "Lcom/example/tickets/SmartSubwayRealtimeState;", "cancel", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SmartSubwayRealtimeRouter {
    public static final int $stable = 0;
    public static final SmartSubwayRealtimeRouter INSTANCE = new SmartSubwayRealtimeRouter();

    private SmartSubwayRealtimeRouter() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void publish(Context context, String mode, SmartSubwayRealtimeState state) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(state, "state");
        try {
            Result.Companion companion = Result.INSTANCE;
            SmartSubwayRealtimeRouter smartSubwayRealtimeRouter = this;
            switch (mode.hashCode()) {
                case -309140867:
                    if (!mode.equals("Live Update")) {
                        RealtimeOngoingNotificationManager.INSTANCE.cancelSmartSubway(context);
                        RealtimeOngoingNotificationManager.INSTANCE.showSmartSubway(context, state);
                    } else {
                        RealtimeOngoingNotificationManager.INSTANCE.cancelSmartSubway(context);
                        if (!LiveUpdateManager.INSTANCE.showSmartSubway(context, state)) {
                            RealtimeOngoingNotificationManager.INSTANCE.showSmartSubway(context, state);
                        }
                    }
                    break;
                case 23379839:
                    if (!mode.equals("实时窗")) {
                        RealtimeOngoingNotificationManager.INSTANCE.cancelSmartSubway(context);
                        RealtimeOngoingNotificationManager.INSTANCE.showSmartSubway(context, state);
                    } else {
                        RealtimeOngoingNotificationManager.INSTANCE.cancelSmartSubway(context);
                        if (!SamsungNowBarManager.INSTANCE.showSmartSubway$app(context, state)) {
                            RealtimeOngoingNotificationManager.INSTANCE.showSmartSubway(context, state);
                        }
                    }
                    break;
                case 27527839:
                    if (!mode.equals("流体云")) {
                        RealtimeOngoingNotificationManager.INSTANCE.cancelSmartSubway(context);
                        RealtimeOngoingNotificationManager.INSTANCE.showSmartSubway(context, state);
                    } else {
                        RealtimeOngoingNotificationManager.INSTANCE.cancelSmartSubway(context);
                        RealtimeOngoingNotificationManager.INSTANCE.showSmartSubway(context, state);
                    }
                    break;
                case 35844889:
                    if (!mode.equals("超级岛")) {
                        RealtimeOngoingNotificationManager.INSTANCE.cancelSmartSubway(context);
                        RealtimeOngoingNotificationManager.INSTANCE.showSmartSubway(context, state);
                    } else {
                        RealtimeOngoingNotificationManager.INSTANCE.cancelSmartSubway(context);
                        if (!XiaomiSuperIslandManager.INSTANCE.showSmartSubway$app(context, state)) {
                            RealtimeOngoingNotificationManager.INSTANCE.showSmartSubway(context, state);
                        }
                    }
                    break;
                default:
                    RealtimeOngoingNotificationManager.INSTANCE.cancelSmartSubway(context);
                    RealtimeOngoingNotificationManager.INSTANCE.showSmartSubway(context, state);
                    break;
            }
            Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void cancel(Context context, String mode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mode, "mode");
        try {
            Result.Companion companion = Result.INSTANCE;
            SmartSubwayRealtimeRouter smartSubwayRealtimeRouter = this;
            XiaomiSuperIslandManager.INSTANCE.cancelSmartSubway$app(context);
            Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            SmartSubwayRealtimeRouter smartSubwayRealtimeRouter2 = this;
            SamsungNowBarManager.INSTANCE.cancelSmartSubway$app(context);
            Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th2));
        }
        try {
            Result.Companion companion5 = Result.INSTANCE;
            SmartSubwayRealtimeRouter smartSubwayRealtimeRouter3 = this;
            RealtimeOngoingNotificationManager.INSTANCE.cancelSmartSubway(context);
            Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th3));
        }
        try {
            Result.Companion companion7 = Result.INSTANCE;
            SmartSubwayRealtimeRouter smartSubwayRealtimeRouter4 = this;
            LiveUpdateManager.INSTANCE.cancelSmartSubway(context);
            Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th4) {
            Result.Companion companion8 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th4));
        }
    }
}
