package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.v3.dct.DctDevice;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzet extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzet> CREATOR = new zzeu();
    private String zza;
    private String zzb;
    private String zzc;
    private boolean zzd;
    private byte[] zze;
    private byte[] zzf;
    private byte[] zzg;
    private boolean zzh;
    private final int zzi;
    private com.google.android.gms.internal.nearby.zzbz zzj;
    private com.google.android.gms.nearby.connection.zzo zzk;
    private DctDevice zzl;
    private final int zzm;

    private zzet() {
        this.zzi = 0;
        this.zzm = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzet) {
            zzet zzetVar = (zzet) obj;
            if (Objects.equal(this.zza, zzetVar.zza) && Objects.equal(this.zzb, zzetVar.zzb) && Objects.equal(this.zzc, zzetVar.zzc) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(zzetVar.zzd)) && Arrays.equals(this.zze, zzetVar.zze) && Arrays.equals(this.zzf, zzetVar.zzf) && Arrays.equals(this.zzg, zzetVar.zzg) && Objects.equal(Boolean.valueOf(this.zzh), Boolean.valueOf(zzetVar.zzh)) && Objects.equal(Integer.valueOf(this.zzi), Integer.valueOf(zzetVar.zzi)) && Objects.equal(this.zzj, zzetVar.zzj) && Objects.equal(this.zzk, zzetVar.zzk) && Objects.equal(this.zzl, zzetVar.zzl) && Objects.equal(Integer.valueOf(this.zzm), Integer.valueOf(zzetVar.zzm))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Boolean.valueOf(this.zzd), Integer.valueOf(Arrays.hashCode(this.zze)), Integer.valueOf(Arrays.hashCode(this.zzf)), Integer.valueOf(Arrays.hashCode(this.zzg)), Boolean.valueOf(this.zzh), Integer.valueOf(this.zzi), this.zzj, this.zzk, this.zzl, Integer.valueOf(this.zzm));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeByteArray(parcel, 5, this.zze, false);
        SafeParcelWriter.writeByteArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeByteArray(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeInt(parcel, 12, this.zzm);
        SafeParcelWriter.writeParcelable(parcel, 13, this.zzl, i, false);
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

    public final boolean zzd() {
        return this.zzd;
    }

    public final byte[] zze() {
        return this.zzf;
    }

    public final byte[] zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return this.zzh;
    }

    public final int zzh() {
        return this.zzm;
    }

    zzet(String str, String str2, String str3, boolean z, byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z2, int i, com.google.android.gms.internal.nearby.zzbz zzbzVar, com.google.android.gms.nearby.connection.zzo zzoVar, DctDevice dctDevice, int i2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = z;
        this.zze = bArr;
        this.zzf = bArr2;
        this.zzg = bArr3;
        this.zzh = z2;
        this.zzi = i;
        this.zzj = zzbzVar;
        this.zzk = zzoVar;
        this.zzl = dctDevice;
        this.zzm = i2;
    }
}
