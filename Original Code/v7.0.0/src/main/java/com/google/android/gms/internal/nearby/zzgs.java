package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.RangingSessionCallback;
import com.google.android.gms.nearby.uwb.UwbDevice;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgs extends zzbi {
    final /* synthetic */ zzel zza;
    final /* synthetic */ zzgy zzb;

    zzgs(zzgy zzgyVar, zzel zzelVar) {
        this.zza = zzelVar;
        Objects.requireNonNull(zzgyVar);
        this.zzb = zzgyVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        zzel zzelVar = this.zza;
        ((RangingSessionCallback) obj).onRangingResult(UwbDevice.createForAddress(zzelVar.zza().zza().zza()), this.zzb.zzc(zzelVar.zzb()));
    }
}
