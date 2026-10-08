package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.RangingSessionCallback;
import com.google.android.gms.nearby.uwb.UwbDevice;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgr extends zzbi {
    final /* synthetic */ zzej zza;

    zzgr(zzgy zzgyVar, zzej zzejVar) {
        this.zza = zzejVar;
        Objects.requireNonNull(zzgyVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((RangingSessionCallback) obj).onRangingInitialized(UwbDevice.createForAddress(this.zza.zza().zza().zza()));
    }
}
