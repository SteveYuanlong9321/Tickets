package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.RangingCapabilities;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgm extends zzdl {
    final /* synthetic */ TaskCompletionSource zza;

    zzgm(zzhq zzhqVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
        Objects.requireNonNull(zzhqVar);
    }

    @Override // com.google.android.gms.internal.nearby.zzdm
    public final void zzd(zzex zzexVar) {
        this.zza.setResult(new RangingCapabilities(zzexVar.zza(), zzexVar.zzb(), zzexVar.zzc(), zzexVar.zzj(), zzexVar.zzd(), zzhq.zzi(zzexVar.zze()), zzhq.zzi(zzexVar.zzg()), zzhq.zzi(zzexVar.zzf()), zzhq.zzi(zzexVar.zzh()), zzhq.zzi(zzexVar.zzi()), zzexVar.zzk()));
    }
}
