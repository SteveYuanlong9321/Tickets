package com.google.android.gms.internal.nearby;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzwm implements Runnable {
    final /* synthetic */ zzahl zza;
    final /* synthetic */ Runnable zzb;
    final /* synthetic */ AtomicReference zzc;
    final /* synthetic */ zzaha zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ long zzf;

    zzwm(zzahl zzahlVar, Runnable runnable, AtomicReference atomicReference, zzaha zzahaVar, long j, long j2, zzkb zzkbVar) {
        this.zza = zzahlVar;
        this.zzb = runnable;
        this.zzc = atomicReference;
        this.zzd = zzahaVar;
        this.zze = j;
        this.zzf = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzahl zzahlVar = this.zza;
            if (zzahlVar.isDone()) {
                return;
            }
            this.zzb.run();
            zzahl zzahlVarZzf = zzahl.zzf();
            this.zzc.set(zzahlVarZzf);
            if (zzahlVar.isDone()) {
                return;
            }
            zzaha zzahaVar = this.zzd;
            long j = this.zze;
            long j2 = this.zzf;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            zzahlVarZzf.zze(zzahaVar.schedule(this, jElapsedRealtime < j ? (j + j2) - jElapsedRealtime : j2 - ((jElapsedRealtime - j) % j2), TimeUnit.MILLISECONDS));
        } catch (Throwable th) {
            this.zza.zzb(th);
        }
    }

    public final String toString() {
        return this.zzb.toString();
    }
}
