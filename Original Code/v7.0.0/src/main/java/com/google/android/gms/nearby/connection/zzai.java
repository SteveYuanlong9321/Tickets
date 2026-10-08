package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.nearby.zzyg;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzai extends AbstractSafeParcelable implements zzq {
    public static final Parcelable.Creator<zzai> CREATOR = new zzaj();
    public static final zzyg zza = zzyg.zzp((byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
    private final byte[] zzb;
    private final byte[] zzc;
    private final byte[] zzd;
    private final byte[] zze;

    zzai(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.zzb = bArr;
        this.zzc = bArr2;
        this.zzd = bArr3;
        this.zze = bArr4;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzai) {
            zzai zzaiVar = (zzai) obj;
            if (Arrays.equals(this.zzb, zzaiVar.zzb) && Arrays.equals(this.zzc, zzaiVar.zzc) && Arrays.equals(this.zzd, zzaiVar.zzd) && Arrays.equals(this.zze, zzaiVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(this.zzb)), Integer.valueOf(Arrays.hashCode(this.zzc)), Integer.valueOf(Arrays.hashCode(this.zzd)), Integer.valueOf(Arrays.hashCode(this.zze)));
    }

    public final String toString() {
        return String.format("WifiLanConnectivityInfoV2:<wifiLanPort hash: %s>, <wifiLanIp hash: %s>, <BSSID hash: %s>, <actions hash: %s>", Integer.valueOf(Arrays.hashCode(this.zzb)), Integer.valueOf(Arrays.hashCode(this.zzc)), Integer.valueOf(Arrays.hashCode(this.zzd)), Integer.valueOf(Arrays.hashCode(this.zze)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        byte[] bArr = this.zzb;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, (byte[]) bArr.clone(), false);
        SafeParcelWriter.writeByteArray(parcel, 2, (byte[]) this.zzc.clone(), false);
        byte[] bArr2 = this.zzd;
        SafeParcelWriter.writeByteArray(parcel, 3, bArr2 == null ? null : (byte[]) bArr2.clone(), false);
        byte[] bArr3 = this.zze;
        SafeParcelWriter.writeByteArray(parcel, 4, bArr3 != null ? (byte[]) bArr3.clone() : null, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
