package com.google.android.gms.internal.nearby;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzahg {
    public static Executor zza() {
        return zzafx.INSTANCE;
    }

    public static Executor zzb(Executor executor) {
        return new zzahk(executor);
    }

    public static zzaha zzc(ScheduledExecutorService scheduledExecutorService) {
        return scheduledExecutorService instanceof zzaha ? (zzaha) scheduledExecutorService : new zzahf(scheduledExecutorService);
    }

    static Executor zzd(final Executor executor, final zzafb zzafbVar) {
        executor.getClass();
        return executor == zzafx.INSTANCE ? executor : new Executor() { // from class: com.google.android.gms.internal.nearby.zzahc
            @Override // java.util.concurrent.Executor
            public final /* synthetic */ void execute(Runnable runnable) {
                zzahg.zzf(executor, zzafbVar, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void zzf(Executor executor, zzafb zzafbVar, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (RejectedExecutionException e) {
            zzafbVar.zzb(e);
        }
    }
}
