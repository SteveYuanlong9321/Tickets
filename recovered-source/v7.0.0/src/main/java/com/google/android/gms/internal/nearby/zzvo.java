package com.google.android.gms.internal.nearby;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzvo implements zzafp {
    final /* synthetic */ zzvj zza;
    final /* synthetic */ zzafp zzb;

    zzvo(zzvj zzvjVar, zzafp zzafpVar) {
        this.zza = zzvjVar;
        this.zzb = zzafpVar;
    }

    public final String toString() {
        zzafp zzafpVar = this.zzb;
        StringBuilder sb = new StringBuilder(zzafpVar.toString().length() + 14);
        sb.append("propagating=[");
        sb.append(zzafpVar);
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzafp
    public final zzagx zza() {
        zzvj zzvjVar = this.zza;
        Intrinsics.checkNotNull(zzvjVar);
        zzvh zzvhVarZzd = zzup.zzd();
        zzvj zzvjVarZzc = zzup.zzc(zzvhVarZzd, zzvjVar);
        try {
            zzagx zzagxVarZza = this.zzb.zza();
            zzup.zzc(zzvhVarZzd, zzvjVarZzc);
            Intrinsics.checkNotNullExpressionValue(zzagxVarZza, "wrapInTrace(...)");
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
