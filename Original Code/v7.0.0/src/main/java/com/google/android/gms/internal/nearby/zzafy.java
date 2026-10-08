package com.google.android.gms.internal.nearby;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzafy implements zzafp {
    final /* synthetic */ zzagb zza;
    final /* synthetic */ zzafp zzb;

    zzafy(zzagd zzagdVar, zzagb zzagbVar, zzafp zzafpVar) {
        this.zza = zzagbVar;
        this.zzb = zzafpVar;
        Objects.requireNonNull(zzagdVar);
    }

    public final String toString() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzafp
    public final zzagx zza() throws Exception {
        return !this.zza.compareAndSet(zzaga.NOT_RUN, zzaga.STARTED) ? zzagn.zzd() : this.zzb.zza();
    }
}
