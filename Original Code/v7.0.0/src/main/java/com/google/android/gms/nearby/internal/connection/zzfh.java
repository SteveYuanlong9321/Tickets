package com.google.android.gms.nearby.internal.connection;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.v3.dct.DctDevice;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfh> CREATOR = new zzfi();
    private String zza;
    private String zzb;
    private String zzc;
    private BluetoothDevice zzd;
    private byte[] zze;
    private final int zzf;
    private com.google.android.gms.nearby.connection.zzo zzg;
    private DctDevice zzh;

    private zzfh() {
        this.zzf = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfh) {
            zzfh zzfhVar = (zzfh) obj;
            if (Objects.equal(this.zza, zzfhVar.zza) && Objects.equal(this.zzb, zzfhVar.zzb) && Objects.equal(this.zzc, zzfhVar.zzc) && Objects.equal(this.zzd, zzfhVar.zzd) && Arrays.equals(this.zze, zzfhVar.zze) && Objects.equal(Integer.valueOf(this.zzf), Integer.valueOf(zzfhVar.zzf)) && Objects.equal(this.zzg, zzfhVar.zzg) && Objects.equal(this.zzh, zzfhVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, Integer.valueOf(Arrays.hashCode(this.zze)), Integer.valueOf(this.zzf), this.zzg, this.zzh);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeByteArray(parcel, 5, this.zze, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final BluetoothDevice zzd() {
        return this.zzd;
    }

    public final byte[] zze() {
        return this.zze;
    }

    zzfh(String str, String str2, String str3, BluetoothDevice bluetoothDevice, byte[] bArr, int i, com.google.android.gms.nearby.connection.zzo zzoVar, DctDevice dctDevice) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = bluetoothDevice;
        this.zze = bArr;
        this.zzf = i;
        this.zzg = zzoVar;
        this.zzh = dctDevice;
    }
}
