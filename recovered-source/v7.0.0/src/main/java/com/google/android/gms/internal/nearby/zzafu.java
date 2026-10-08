package com.google.android.gms.internal.nearby;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzafu extends zzafv {
    final /* synthetic */ zzafw zza;
    private final Callable zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzafu(zzafw zzafwVar, Callable callable, Executor executor) {
        super(zzafwVar, executor);
        Objects.requireNonNull(zzafwVar);
        this.zza = zzafwVar;
        this.zzc = callable;
    }

    @Override // com.google.android.gms.internal.nearby.zzagv
    final String zza() {
        return this.zzc.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzafv
    final void zzb(Object obj) {
        this.zza.zza(obj);
    }

    @Override // com.google.android.gms.internal.nearby.zzagv
    final Object zzc() throws Exception {
        return this.zzc.call();
    }
}
