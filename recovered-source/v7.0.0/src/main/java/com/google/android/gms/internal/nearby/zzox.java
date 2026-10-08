package com.google.android.gms.internal.nearby;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzox implements Runnable {
    final /* synthetic */ Runnable zza;
    final /* synthetic */ zzaha zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ TimeUnit zzd;

    zzox(zzpa zzpaVar, Runnable runnable, zzaha zzahaVar, long j, TimeUnit timeUnit) {
        this.zza = runnable;
        this.zzb = zzahaVar;
        this.zzc = j;
        this.zzd = timeUnit;
        Objects.requireNonNull(zzpaVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.run();
        zzop.zza(this.zzb.schedule(this, this.zzc, this.zzd));
    }
}
