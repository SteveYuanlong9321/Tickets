package com.google.android.gms.internal.nearby;

import android.os.Process;
import android.util.Log;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzpa implements zzpe {
    private static boolean zza;
    private final zzxn zzb;
    private final int zzc;
    private final zzxn zzd;

    public zzpa(zzxn zzxnVar, int i) {
        zzoz zzozVar = zzoz.zza;
        this.zzb = zzxnVar;
        this.zzc = Math.max(5, 10);
        this.zzd = zzozVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzpe
    public final void zza() {
        synchronized (zzpa.class) {
            if (!zza) {
                Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.nearby.zzoy
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzb();
                    }
                };
                long j = this.zzc;
                TimeUnit timeUnit = TimeUnit.MINUTES;
                zzaha zzahaVar = (zzaha) this.zzb.zzbh();
                zzop.zza(zzahaVar.schedule(new zzox(this, runnable, zzahaVar, j, timeUnit), j, timeUnit));
                zza = true;
            }
        }
    }

    final /* synthetic */ void zzb() {
        if (((Boolean) this.zzd.zzbh()).booleanValue()) {
            Log.i("PhenotypeProcessReaper", "Killing process to refresh experiment configuration");
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }
}
