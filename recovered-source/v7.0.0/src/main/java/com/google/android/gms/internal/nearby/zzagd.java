package com.google.android.gms.internal.nearby;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzagd {
    private final AtomicReference zza = new AtomicReference(zzags.zza);
    private zzagc zzb = new zzagc(null);

    private zzagd() {
    }

    public static zzagd zza() {
        return new zzagd();
    }

    public final zzagx zzb(zzafp zzafpVar, Executor executor) {
        final zzagb zzagbVar = new zzagb(executor, this, null);
        zzafy zzafyVar = new zzafy(this, zzagbVar, zzafpVar);
        AtomicReference atomicReference = this.zza;
        final zzahl zzahlVarZzf = zzahl.zzf();
        final zzagx zzagxVar = (zzagx) atomicReference.getAndSet(zzahlVarZzf);
        final zzaho zzahoVar = new zzaho(zzafyVar);
        zzagxVar.zzl(zzahoVar, zzagbVar);
        final zzagx zzagxVarZzm = zzagn.zzm(zzahoVar);
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.nearby.zzafz
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzaho zzahoVar2 = zzahoVar;
                if (zzahoVar2.isDone()) {
                    zzahlVarZzf.zze(zzagxVar);
                } else if (zzagxVarZzm.isCancelled() && zzagbVar.compareAndSet(zzaga.NOT_RUN, zzaga.CANCELLED)) {
                    zzahoVar2.cancel(false);
                }
            }
        };
        zzafx zzafxVar = zzafx.INSTANCE;
        zzagxVarZzm.zzl(runnable, zzafxVar);
        zzahoVar.zzl(runnable, zzafxVar);
        return zzagxVarZzm;
    }

    final /* synthetic */ zzagc zzc() {
        return this.zzb;
    }

    final /* synthetic */ void zzd(zzagc zzagcVar) {
        this.zzb = zzagcVar;
    }
}
