package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzao extends zzan {
    final /* synthetic */ zzfr zza;
    final /* synthetic */ Payload zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzao(zzas zzasVar, zzfr zzfrVar, Payload payload) {
        super(null);
        this.zza = zzfrVar;
        this.zzb = payload;
        Objects.requireNonNull(zzasVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((PayloadCallback) obj).onPayloadReceived(this.zza.zza(), this.zzb);
    }
}
