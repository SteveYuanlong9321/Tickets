package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.UwbDevice;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgu extends zzbi {
    final /* synthetic */ zzef zza;

    zzgu(zzgy zzgyVar, zzef zzefVar) {
        this.zza = zzefVar;
        Objects.requireNonNull(zzgyVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        zzef zzefVar = this.zza;
        UwbDevice.createForAddress(zzefVar.zza().zza().zza());
        zzefVar.zzb();
    }
}
