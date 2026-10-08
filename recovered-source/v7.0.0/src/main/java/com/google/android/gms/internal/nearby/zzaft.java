package com.google.android.gms.internal.nearby;

import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaft extends zzafv {
    final /* synthetic */ zzafw zza;
    private final zzafp zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaft(zzafw zzafwVar, zzafp zzafpVar, Executor executor) {
        super(zzafwVar, executor);
        Objects.requireNonNull(zzafwVar);
        this.zza = zzafwVar;
        this.zzc = zzafpVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzagv
    final String zza() {
        return this.zzc.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzafv
    final /* synthetic */ void zzb(Object obj) {
        this.zza.zze((zzagx) obj);
    }

    @Override // com.google.android.gms.internal.nearby.zzagv
    final /* bridge */ /* synthetic */ Object zzc() throws Exception {
        zzafp zzafpVar = this.zzc;
        zzagx zzagxVarZza = zzafpVar.zza();
        zzxd.zzh(zzagxVarZza, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzafpVar);
        return zzagxVarZza;
    }
}
