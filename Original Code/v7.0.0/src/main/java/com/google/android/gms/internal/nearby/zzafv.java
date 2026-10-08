package com.google.android.gms.internal.nearby;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzafv extends zzagv {
    private final Executor zza;
    final /* synthetic */ zzafw zzb;

    zzafv(zzafw zzafwVar, Executor executor) {
        Objects.requireNonNull(zzafwVar);
        this.zzb = zzafwVar;
        this.zza = executor;
    }

    abstract void zzb(Object obj);

    @Override // com.google.android.gms.internal.nearby.zzagv
    final boolean zzd() {
        return this.zzb.isDone();
    }

    final void zze() {
        try {
            this.zza.execute(this);
        } catch (RejectedExecutionException e) {
            this.zzb.zzb(e);
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzagv
    final void zzf(Object obj) {
        this.zzb.zzD(null);
        zzb(obj);
    }

    @Override // com.google.android.gms.internal.nearby.zzagv
    final void zzg(Throwable th) {
        zzafw zzafwVar = this.zzb;
        zzafwVar.zzD(null);
        if (th instanceof ExecutionException) {
            zzafwVar.zzb(((ExecutionException) th).getCause());
        } else if (th instanceof CancellationException) {
            zzafwVar.cancel(false);
        } else {
            zzafwVar.zzb(th);
        }
    }
}
