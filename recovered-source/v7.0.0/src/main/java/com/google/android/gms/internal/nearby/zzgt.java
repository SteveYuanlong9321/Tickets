package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.RangingSessionCallback;
import com.google.android.gms.nearby.uwb.UwbDevice;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgt extends zzbi {
    final /* synthetic */ zzen zza;
    final /* synthetic */ zzgy zzb;

    zzgt(zzgy zzgyVar, zzen zzenVar) {
        this.zza = zzenVar;
        Objects.requireNonNull(zzgyVar);
        this.zzb = zzgyVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        zzen zzenVar = this.zza;
        RangingSessionCallback rangingSessionCallback = (RangingSessionCallback) obj;
        rangingSessionCallback.onRangingSuspended(UwbDevice.createForAddress(zzenVar.zza().zza().zza()), zzenVar.zzb());
        this.zzb.zza.zzd(rangingSessionCallback);
    }

    @Override // com.google.android.gms.internal.nearby.zzbi, com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
        zzen zzenVar = this.zza;
        this.zzb.zzi().onRangingSuspended(UwbDevice.createForAddress(zzenVar.zza().zza().zza()), zzenVar.zzb());
    }
}
