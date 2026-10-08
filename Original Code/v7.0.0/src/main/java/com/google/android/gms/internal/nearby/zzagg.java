package com.google.android.gms.internal.nearby;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzagg extends zzagf {
    private final zzagx zza;

    @Override // com.google.android.gms.internal.nearby.zzafb, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.zza.cancel(z);
    }

    @Override // com.google.android.gms.internal.nearby.zzafb, java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        return this.zza.get();
    }

    @Override // com.google.android.gms.internal.nearby.zzafb, java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zza.isCancelled();
    }

    @Override // com.google.android.gms.internal.nearby.zzafb, java.util.concurrent.Future
    public final boolean isDone() {
        return this.zza.isDone();
    }

    @Override // com.google.android.gms.internal.nearby.zzafb
    public final String toString() {
        return this.zza.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzafb, com.google.android.gms.internal.nearby.zzagx
    public final void zzl(Runnable runnable, Executor executor) {
        this.zza.zzl(runnable, executor);
    }

    zzagg(zzagx zzagxVar) {
        zzagxVar.getClass();
        this.zza = zzagxVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzafb, java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.zza.get(j, timeUnit);
    }
}
