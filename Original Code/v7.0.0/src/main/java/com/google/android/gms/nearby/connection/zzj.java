package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzj extends AbstractSafeParcelable implements zzq {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();
    private final byte[] zza;
    private final byte[] zzb;
    private final byte[] zzc;

    zzj(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.zza = bArr;
        this.zzb = bArr2;
        this.zzc = bArr3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzj) {
            zzj zzjVar = (zzj) obj;
            if (Arrays.equals(this.zza, zzjVar.zza) && Arrays.equals(this.zzb, zzjVar.zzb) && Arrays.equals(this.zzc, zzjVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(this.zza)), Integer.valueOf(Arrays.hashCode(this.zzb)), Integer.valueOf(Arrays.hashCode(this.zzc)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        byte[] bArr = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, bArr == null ? null : (byte[]) bArr.clone(), false);
        byte[] bArr2 = this.zzb;
        SafeParcelWriter.writeByteArray(parcel, 2, bArr2 == null ? null : (byte[]) bArr2.clone(), false);
        byte[] bArr3 = this.zzc;
        SafeParcelWriter.writeByteArray(parcel, 3, bArr3 != null ? (byte[]) bArr3.clone() : null, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String toString() {
        byte[] bArr = this.zza;
        Integer numValueOf = bArr == null ? null : Integer.valueOf(Arrays.hashCode(bArr));
        byte[] bArr2 = this.zzb;
        Integer numValueOf2 = bArr2 == null ? null : Integer.valueOf(Arrays.hashCode(bArr2));
        byte[] bArr3 = this.zzc;
        return String.format("BluetoothConnectivityInfo:<bluetoothMacAddress hash: %s, bluetoothUuid hash: %s, actions hash: %s>", numValueOf, numValueOf2, bArr3 != null ? Integer.valueOf(Arrays.hashCode(bArr3)) : null);
    }
}
