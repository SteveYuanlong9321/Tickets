package com.google.android.gms.internal.nearby;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzahf extends zzahb implements zzaha {
    final ScheduledExecutorService zza;

    zzahf(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.nearby.zzaha, java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzd */
    public final zzagy schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.zza;
        zzaho zzahoVarZzf = zzaho.zzf(runnable, null);
        return new zzahd(zzahoVarZzf, scheduledExecutorService.schedule(zzahoVarZzf, j, timeUnit));
    }

    @Override // com.google.android.gms.internal.nearby.zzaha, java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zze */
    public final zzagy schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzaho zzahoVar = new zzaho(callable);
        return new zzahd(zzahoVar, this.zza.schedule(zzahoVar, j, timeUnit));
    }

    @Override // com.google.android.gms.internal.nearby.zzaha, java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzf */
    public final zzagy scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzahe zzaheVar = new zzahe(runnable);
        return new zzahd(zzaheVar, this.zza.scheduleAtFixedRate(zzaheVar, j, j2, timeUnit));
    }

    @Override // com.google.android.gms.internal.nearby.zzaha, java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzg */
    public final zzagy scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzahe zzaheVar = new zzahe(runnable);
        return new zzahd(zzaheVar, this.zza.scheduleWithFixedDelay(zzaheVar, j, j2, timeUnit));
    }
}
