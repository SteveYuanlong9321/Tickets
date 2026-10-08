package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzae extends zzan {
    final /* synthetic */ String zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzae(zzaf zzafVar, String str) {
        super(null);
        this.zza = str;
        Objects.requireNonNull(zzafVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((EndpointDiscoveryCallback) obj).onEndpointLost(this.zza);
    }
}
