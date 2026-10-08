package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbo extends zzbs {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbo(zzbv zzbvVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        Objects.requireNonNull(zzbvVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzs) ((zzah) anyClient).getService()).zzh(new zzh(1, new com.google.android.gms.internal.nearby.zzbh(zza()), null, null));
    }
}
