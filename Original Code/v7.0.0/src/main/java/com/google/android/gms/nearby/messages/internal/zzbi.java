package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.PublishOptions;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbi extends zzbs {
    final /* synthetic */ Message zza;
    final /* synthetic */ zzbr zzb;
    final /* synthetic */ PublishOptions zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbi(zzbv zzbvVar, GoogleApiClient googleApiClient, Message message, zzbr zzbrVar, PublishOptions publishOptions) {
        super(googleApiClient);
        this.zza = message;
        this.zzb = zzbrVar;
        this.zzc = publishOptions;
        Objects.requireNonNull(zzbvVar);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzah) anyClient).zzx(zza(), new zzae(1, this.zza), this.zzb, this.zzc);
    }
}
