package com.google.android.gms.internal.nearby;

import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzti implements zzry {
    final /* synthetic */ zztj zza;

    /* synthetic */ zzti(zztj zztjVar, byte[] bArr) {
        Objects.requireNonNull(zztjVar);
        this.zza = zztjVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzry
    public final zzagx zza(final zzafq zzafqVar, final Executor executor) {
        return zzto.zza(zzagn.zzi(zzagn.zzm(this.zza.zzg().zza()), zzvr.zzc(new zzafq() { // from class: com.google.android.gms.internal.nearby.zzth
            @Override // com.google.android.gms.internal.nearby.zzafq
            public final /* synthetic */ zzagx zza(Object obj) {
                return this.zza.zza.zzf().zzb(zzafqVar, executor, null);
            }
        }), zzahg.zza()));
    }
}
