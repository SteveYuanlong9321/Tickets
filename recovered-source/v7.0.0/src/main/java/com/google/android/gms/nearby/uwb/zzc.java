package com.google.android.gms.nearby.uwb;

import com.google.android.gms.common.api.Api;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzc implements Api.ApiOptions.HasOptions {
    private final int zzb;
    private final int zzd;
    private final boolean zzc = false;
    private final String zza = null;

    /* synthetic */ zzc(int i, boolean z, String str, int i2, byte[] bArr) {
        this.zzb = i;
        this.zzd = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc zzcVar = (zzc) obj;
        boolean z = zzcVar.zzc;
        if (Objects.equals(Integer.valueOf(this.zzb), Integer.valueOf(zzcVar.zzb))) {
            String str = zzcVar.zza;
            if (Objects.equals(Integer.valueOf(this.zzd), Integer.valueOf(zzcVar.zzd))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.zzb), false, null, Integer.valueOf(this.zzd));
    }

    public final int zza() {
        return this.zzb;
    }
}
