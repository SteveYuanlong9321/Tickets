package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzas {
    private final Class zza;

    zzas(GoogleApi googleApi, Api.ApiOptions apiOptions) {
        this.zza = googleApi.getClass();
    }

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof zzas) && Objects.equals(this.zza, ((zzas) obj).zza);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, null);
    }
}
