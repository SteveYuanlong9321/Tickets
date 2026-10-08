package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.nearby.connection.PayloadCallback;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzap extends zzan {
    final /* synthetic */ zzft zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzap(zzas zzasVar, zzft zzftVar) {
        super(null);
        this.zza = zzftVar;
        Objects.requireNonNull(zzasVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        zzft zzftVar = this.zza;
        ((PayloadCallback) obj).onPayloadTransferUpdate(zzftVar.zza(), zzftVar.zzb());
    }
}
