package com.google.android.gms.internal.nearby;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzahn extends zzagv {
    final /* synthetic */ zzaho zza;
    private final Callable zzb;

    zzahn(zzaho zzahoVar, Callable callable) {
        Objects.requireNonNull(zzahoVar);
        this.zza = zzahoVar;
        callable.getClass();
        this.zzb = callable;
    }

    @Override // com.google.android.gms.internal.nearby.zzagv
    final String zza() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzagv
    final Object zzc() throws Exception {
        return this.zzb.call();
    }

    @Override // com.google.android.gms.internal.nearby.zzagv
    final boolean zzd() {
        return this.zza.isDone();
    }

    @Override // com.google.android.gms.internal.nearby.zzagv
    final void zzf(Object obj) {
        this.zza.zza(obj);
    }

    @Override // com.google.android.gms.internal.nearby.zzagv
    final void zzg(Throwable th) {
        this.zza.zzb(th);
    }
}
