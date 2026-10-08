package com.google.android.gms.internal.nearby;

import android.content.Context;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzim {

    @Deprecated
    public static final Api zza;
    private static final Api.ClientKey zzb;
    private static final Api.AbstractClientBuilder zzc;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zzb = clientKey;
        zzil zzilVar = new zzil();
        zzc = zzilVar;
        zza = new Api("Phenotype.API", zzilVar, clientKey);
    }

    public static zziy zza(Context context) {
        return new zziy(context);
    }
}
