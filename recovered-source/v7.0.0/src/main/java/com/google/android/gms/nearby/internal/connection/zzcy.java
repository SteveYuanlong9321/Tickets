package com.google.android.gms.nearby.internal.connection;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcy extends zzdf {
    final /* synthetic */ String zza;
    final /* synthetic */ ListenerHolder zzb;
    final /* synthetic */ DiscoveryOptions zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcy(zzdg zzdgVar, GoogleApiClient googleApiClient, String str, ListenerHolder listenerHolder, DiscoveryOptions discoveryOptions) {
        super(googleApiClient, null);
        this.zza = str;
        this.zzb = listenerHolder;
        this.zzc = discoveryOptions;
        Objects.requireNonNull(zzdgVar);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzaw) anyClient).zzE(this, this.zza, this.zzb, zzdl.zza(this.zzc));
    }
}
