package com.google.android.gms.internal.nearby;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzahm extends zzagv {
    final /* synthetic */ zzaho zza;
    private final zzafp zzb;

    zzahm(zzaho zzahoVar, zzafp zzafpVar) {
        Objects.requireNonNull(zzahoVar);
        this.zza = zzahoVar;
        this.zzb = zzafpVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzagv
    final String zza() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzagv
    final /* bridge */ /* synthetic */ Object zzc() throws Exception {
        zzafp zzafpVar = this.zzb;
        zzagx zzagxVarZza = zzafpVar.zza();
        zzxd.zzh(zzagxVarZza, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzafpVar);
        return zzagxVarZza;
    }

    @Override // com.google.android.gms.internal.nearby.zzagv
    final boolean zzd() {
        return this.zza.isDone();
    }

    @Override // com.google.android.gms.internal.nearby.zzagv
    final /* synthetic */ void zzf(Object obj) {
        this.zza.zze((zzagx) obj);
    }

    @Override // com.google.android.gms.internal.nearby.zzagv
    final void zzg(Throwable th) {
        this.zza.zzb(th);
    }
}
