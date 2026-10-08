package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.connection.Payload;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzck extends zzdf {
    final /* synthetic */ String zza;
    final /* synthetic */ Payload zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzck(zzdg zzdgVar, GoogleApiClient googleApiClient, String str, Payload payload) {
        super(googleApiClient, null);
        this.zza = str;
        this.zzb = payload;
        Objects.requireNonNull(zzdgVar);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws Throwable {
        ((zzaw) anyClient).zzB(this, new String[]{this.zza}, this.zzb, false);
    }
}
