package com.google.android.gms.nearby.internal.connection;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcm extends zzdf {
    final /* synthetic */ long zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcm(zzdg zzdgVar, GoogleApiClient googleApiClient, long j) {
        super(googleApiClient, null);
        this.zza = j;
        Objects.requireNonNull(zzdgVar);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzaw) anyClient).zzF(this, this.zza);
    }
}
