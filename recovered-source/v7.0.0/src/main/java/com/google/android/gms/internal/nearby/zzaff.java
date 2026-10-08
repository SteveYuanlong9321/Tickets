package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaff extends zzafh {
    zzaff(zzagx zzagxVar, zzafq zzafqVar) {
        super(zzagxVar, zzafqVar);
    }

    @Override // com.google.android.gms.internal.nearby.zzafh
    final /* synthetic */ void zzf(Object obj) {
        zze((zzagx) obj);
    }

    @Override // com.google.android.gms.internal.nearby.zzafh
    final /* bridge */ /* synthetic */ Object zzg(Object obj, Object obj2) throws Exception {
        zzafq zzafqVar = (zzafq) obj;
        zzagx zzagxVarZza = zzafqVar.zza(obj2);
        zzxd.zzh(zzagxVarZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzafqVar);
        return zzagxVarZza;
    }
}
