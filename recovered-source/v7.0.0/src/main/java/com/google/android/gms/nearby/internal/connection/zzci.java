package com.google.android.gms.nearby.internal.connection;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzci extends zzdf {
    final /* synthetic */ String zza;
    final /* synthetic */ ListenerHolder zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzci(zzdg zzdgVar, GoogleApiClient googleApiClient, String str, ListenerHolder listenerHolder) {
        super(googleApiClient, null);
        this.zza = str;
        this.zzb = listenerHolder;
        Objects.requireNonNull(zzdgVar);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzaw) anyClient).zzz(this, this.zza, this.zzb);
    }
}
