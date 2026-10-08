package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.UwbComplexChannel;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgo extends zzea {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzhq zzb;

    zzgo(zzhq zzhqVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
        Objects.requireNonNull(zzhqVar);
        this.zzb = zzhqVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzeb
    public final void zzd(zzgi zzgiVar) {
        UwbComplexChannel.Builder builder = new UwbComplexChannel.Builder();
        builder.setChannel(zzgiVar.zza());
        builder.setPreambleIndex(zzgiVar.zzb());
        UwbComplexChannel uwbComplexChannelBuild = builder.build();
        zzhq zzhqVar = this.zzb;
        zzhqVar.zzh(uwbComplexChannelBuild);
        this.zza.setResult(zzhqVar.zzg());
    }
}
