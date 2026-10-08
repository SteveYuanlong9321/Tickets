package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaq extends zzan {
    final /* synthetic */ String zza;
    final /* synthetic */ PayloadTransferUpdate zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaq(zzas zzasVar, String str, PayloadTransferUpdate payloadTransferUpdate) {
        super(null);
        this.zza = str;
        this.zzb = payloadTransferUpdate;
        Objects.requireNonNull(zzasVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        PayloadTransferUpdate.Builder builder = new PayloadTransferUpdate.Builder(this.zzb);
        builder.setStatus(2);
        ((PayloadCallback) obj).onPayloadTransferUpdate(this.zza, builder.build());
    }
}
