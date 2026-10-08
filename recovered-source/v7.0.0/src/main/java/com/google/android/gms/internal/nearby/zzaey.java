package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaey extends zzafa {
    zzaey(zzagx zzagxVar, Class cls, zzafq zzafqVar) {
        super(zzagxVar, cls, zzafqVar);
    }

    @Override // com.google.android.gms.internal.nearby.zzafa
    final /* synthetic */ void zzf(Object obj) {
        zze((zzagx) obj);
    }

    @Override // com.google.android.gms.internal.nearby.zzafa
    final /* bridge */ /* synthetic */ Object zzg(Object obj, Throwable th) throws Exception {
        zzafq zzafqVar = (zzafq) obj;
        zzagx zzagxVarZza = zzafqVar.zza(th);
        zzxd.zzh(zzagxVarZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzafqVar);
        return zzagxVarZza;
    }
}
