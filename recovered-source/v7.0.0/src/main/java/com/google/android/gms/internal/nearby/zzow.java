package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.util.Log;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzow {
    private final Context zza;
    private final zzxn zzb;
    private final zzxn zzc;
    private final zzxn zzd;
    private volatile int zze = 0;
    private final CopyOnWriteArrayList zzf = new CopyOnWriteArrayList();
    private final Object zzg = new Object();
    private volatile zzagx zzh = null;

    public zzow(Context context, zzxn zzxnVar, zzxn zzxnVar2, zzxn zzxnVar3) {
        this.zza = context;
        this.zzb = zzxnVar;
        this.zzc = zzxnVar2;
        this.zzd = zzxnVar3;
    }

    public final zzagx zza(zzahs zzahsVar, boolean z, zzou zzouVar) {
        final zzagx zzagxVarZze;
        final zzpe zzpeVar = (zzpe) this.zzc.zzbh();
        if (zzpeVar == null && !z) {
            return zzagn.zzb();
        }
        int iZza = 1 << zzahsVar.zza();
        if ((this.zze & iZza) == 0) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.zzf;
            synchronized (copyOnWriteArrayList) {
                int i = this.zze;
                if ((i & iZza) == 0) {
                    copyOnWriteArrayList.add(zzouVar);
                    this.zze = iZza | i;
                }
            }
        }
        zzagx zzagxVar = this.zzh;
        if (zzagxVar != null) {
            return zzagxVar;
        }
        synchronized (this.zzg) {
            zzagxVarZze = this.zzh;
            if (zzagxVarZze == null) {
                if (zzpeVar == null) {
                    zzpeVar = zzot.zza;
                }
                Context context = this.zza;
                if (zzkf.zza(context)) {
                    zzor zzorVar = zzor.zza;
                    zzxn zzxnVar = this.zzb;
                    zzagxVarZze = zzagn.zzi(zzkf.zzc(context, Executors.callable(zzorVar, null), (Executor) zzxnVar.zzbh()), new zzafq() { // from class: com.google.android.gms.internal.nearby.zzos
                        @Override // com.google.android.gms.internal.nearby.zzafq
                        public final /* synthetic */ zzagx zza(Object obj) {
                            return this.zza.zzb(zzpeVar, (Void) obj);
                        }
                    }, (Executor) zzxnVar.zzbh());
                    this.zzh = zzagxVarZze;
                } else {
                    zzagxVarZze = ((zzlj) this.zzd.zzbh()).zze(new zzov(this, zzpeVar));
                    zzagx zzagxVar2 = zzagxVarZze;
                    this.zzh = zzagxVarZze;
                }
                zzagxVarZze.zzl(new Runnable() { // from class: com.google.android.gms.internal.nearby.zzoq
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        try {
                            zzagn.zzn(zzagxVarZze);
                        } catch (Exception e) {
                            Log.i("PhFlagUpdateRegistry", "Failed to register flag update listener which may lead to stale flags.", e);
                        }
                    }
                }, (Executor) this.zzb.zzbh());
            }
        }
        return zzagxVarZze;
    }

    final /* synthetic */ zzagx zzb(zzpe zzpeVar, Void r3) {
        return ((zzlj) this.zzd.zzbh()).zze(new zzov(this, zzpeVar));
    }

    final /* synthetic */ CopyOnWriteArrayList zzc() {
        return this.zzf;
    }
}
