package com.google.android.gms.nearby.connection;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzab implements zzq {
    private final byte[] zza;
    private final byte[] zzb;
    private final int zzc;

    public zzab(byte[] bArr, byte[] bArr2, int i) {
        this.zza = bArr;
        this.zzb = bArr2;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzab) {
            zzab zzabVar = (zzab) obj;
            if (Arrays.equals(this.zza, zzabVar.zza) && Arrays.equals(this.zzb, zzabVar.zzb) && this.zzc == zzabVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(this.zza)), Integer.valueOf(Arrays.hashCode(this.zzb)), Integer.valueOf(this.zzc));
    }

    public final String toString() {
        return String.format("WifiAwareConnectivityInfo: <serviceInfo hash: %s>, <password hash: %s>, <port hash: %s>", Integer.valueOf(Arrays.hashCode(this.zza)), Integer.valueOf(Arrays.hashCode(this.zzb)), Integer.valueOf(this.zzc));
    }
}
