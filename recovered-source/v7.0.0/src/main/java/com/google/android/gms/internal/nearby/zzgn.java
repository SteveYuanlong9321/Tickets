package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.UwbAddress;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgn extends zzdu {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzhq zzb;

    zzgn(zzhq zzhqVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
        Objects.requireNonNull(zzhqVar);
        this.zzb = zzhqVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzdv
    public final void zzd(zzgb zzgbVar) {
        UwbAddress uwbAddress = new UwbAddress(zzgbVar.zza());
        zzhq zzhqVar = this.zzb;
        zzhqVar.zzf(uwbAddress);
        this.zza.setResult(zzhqVar.zze());
    }
}
