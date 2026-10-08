package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.ApiException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzll implements zzafq {
    static final /* synthetic */ zzll zza = new zzll();

    private /* synthetic */ zzll() {
    }

    @Override // com.google.android.gms.internal.nearby.zzafq
    public final /* synthetic */ zzagx zza(Object obj) {
        ApiException apiException = (ApiException) obj;
        throw new zzlk(apiException.getStatusCode(), apiException.getMessage(), apiException);
    }
}
