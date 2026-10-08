package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzad extends zzan {
    final /* synthetic */ zzfn zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzad(zzaf zzafVar, zzfn zzfnVar) {
        super(null);
        this.zza = zzfnVar;
        Objects.requireNonNull(zzafVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((EndpointDiscoveryCallback) obj).onEndpointLost(this.zza.zza());
    }
}
