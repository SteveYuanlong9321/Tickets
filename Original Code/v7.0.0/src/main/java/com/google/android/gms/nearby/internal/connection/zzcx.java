package com.google.android.gms.nearby.internal.connection;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcx extends zzdf {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcx(zzdg zzdgVar, GoogleApiClient googleApiClient) {
        super(googleApiClient, null);
        Objects.requireNonNull(zzdgVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzee) ((zzaw) anyClient).getService()).zze(new zzho().zzb());
    }
}
