package com.google.android.gms.internal.nearby;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzags implements zzagx {
    static final zzagx zza = new zzags(null);
    private static final zzagw zzb = new zzagw(zzags.class);
    private final Object zzc;

    zzags(Object obj) {
        this.zzc = obj;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.zzc;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        timeUnit.getClass();
        return this.zzc;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return true;
    }

    public final String toString() {
        Object obj = this.zzc;
        String string = super.toString();
        String strValueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 25 + String.valueOf(strValueOf).length() + 2);
        sb.append(string);
        sb.append("[status=SUCCESS, result=[");
        sb.append(strValueOf);
        sb.append("]]");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzagx
    public final void zzl(Runnable runnable, Executor executor) {
        zzxd.zzg(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            Logger loggerZza = zzb.zza();
            Level level = Level.SEVERE;
            String string = runnable.toString();
            String strValueOf = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(string.length() + 57 + String.valueOf(strValueOf).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(string);
            sb.append(" with executor ");
            sb.append(strValueOf);
            loggerZza.logp(level, "com.google.common.util.concurrent.ImmediateFuture", "addListener", sb.toString(), (Throwable) e);
        }
    }
}
