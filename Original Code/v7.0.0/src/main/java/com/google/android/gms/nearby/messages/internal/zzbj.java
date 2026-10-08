package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.Message;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbj extends zzbs {
    final /* synthetic */ Message zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbj(zzbv zzbvVar, GoogleApiClient googleApiClient, Message message) {
        super(googleApiClient);
        this.zza = message;
        Objects.requireNonNull(zzbvVar);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzah) anyClient).zzy(zza(), new zzae(1, this.zza));
    }
}
