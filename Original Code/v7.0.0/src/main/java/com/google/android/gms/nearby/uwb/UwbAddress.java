package com.google.android.gms.nearby.uwb;

import com.google.android.gms.internal.nearby.zzaet;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class UwbAddress {
    private static final zzaet zza = zzaet.zzk().zzf(":", 2);
    private final byte[] zzb;

    public UwbAddress(String str) {
        this.zzb = zza.zzi(str);
    }

    public UwbAddress(byte[] bArr) {
        this.zzb = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UwbAddress) {
            return Arrays.equals(this.zzb, ((UwbAddress) obj).zzb);
        }
        return false;
    }

    public byte[] getAddress() {
        return this.zzb;
    }

    public int hashCode() {
        return Arrays.hashCode(this.zzb);
    }

    public String toString() {
        zzaet zzaetVar = zza;
        byte[] bArr = this.zzb;
        return zzaetVar.zzh(bArr, 0, bArr.length);
    }
}
