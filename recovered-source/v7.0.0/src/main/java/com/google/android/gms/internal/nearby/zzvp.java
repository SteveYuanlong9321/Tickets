package com.google.android.gms.internal.nearby;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzvp implements zzafq {
    final /* synthetic */ zzvj zza;
    final /* synthetic */ zzafq zzb;

    zzvp(zzvj zzvjVar, zzafq zzafqVar) {
        this.zza = zzvjVar;
        this.zzb = zzafqVar;
    }

    public final String toString() {
        zzafq zzafqVar = this.zzb;
        StringBuilder sb = new StringBuilder(zzafqVar.toString().length() + 14);
        sb.append("propagating=[");
        sb.append(zzafqVar);
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzafq
    public final zzagx zza(Object obj) {
        zzvj zzvjVar = this.zza;
        Intrinsics.checkNotNull(zzvjVar);
        zzvh zzvhVarZzd = zzup.zzd();
        zzvj zzvjVarZzc = zzup.zzc(zzvhVarZzd, zzvjVar);
        try {
            zzagx zzagxVarZza = this.zzb.zza(obj);
            if (zzagxVarZza == null) {
                throw new IllegalStateException("AsyncFunction should return a ListenableFuture instead of null.");
            }
            zzup.zzc(zzvhVarZzd, zzvjVarZzc);
            return zzagxVarZza;
        } catch (Throwable th) {
            try {
                zzul.zza(th);
                throw th;
            } catch (Throwable th2) {
                zzup.zzc(zzvhVarZzd, zzvjVarZzc);
                throw th2;
            }
        }
    }
}
