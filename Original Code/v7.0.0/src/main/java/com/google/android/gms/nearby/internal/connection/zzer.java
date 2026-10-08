package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.v3.dct.DctDevice;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzer extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzer> CREATOR = new zzes();
    private String zza;
    private int zzb;
    private final int zzc;
    private final int zzd;
    private com.google.android.gms.internal.nearby.zzbz zze;
    private com.google.android.gms.nearby.connection.zzo zzf;
    private DctDevice zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private String zzn;
    private String zzo;
    private final int zzp;
    private int zzq;

    private zzer() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = -1;
        this.zzi = 0;
        this.zzj = 0;
        this.zzk = 0;
        this.zzl = 0;
        this.zzm = 0;
        this.zzp = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzer) {
            zzer zzerVar = (zzer) obj;
            if (Objects.equal(this.zza, zzerVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzerVar.zzb)) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzerVar.zzc)) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzerVar.zzd)) && Objects.equal(this.zze, zzerVar.zze) && Objects.equal(this.zzf, zzerVar.zzf) && Objects.equal(this.zzg, zzerVar.zzg) && Objects.equal(Integer.valueOf(this.zzh), Integer.valueOf(zzerVar.zzh)) && Objects.equal(Integer.valueOf(this.zzi), Integer.valueOf(zzerVar.zzi)) && Objects.equal(Integer.valueOf(this.zzj), Integer.valueOf(zzerVar.zzj)) && Objects.equal(Integer.valueOf(this.zzk), Integer.valueOf(zzerVar.zzk)) && Objects.equal(Integer.valueOf(this.zzl), Integer.valueOf(zzerVar.zzl)) && Objects.equal(Integer.valueOf(this.zzm), Integer.valueOf(zzerVar.zzm)) && Objects.equal(this.zzn, zzerVar.zzn) && Objects.equal(this.zzo, zzerVar.zzo) && Objects.equal(Integer.valueOf(this.zzp), Integer.valueOf(zzerVar.zzp)) && Objects.equal(Integer.valueOf(this.zzq), Integer.valueOf(zzerVar.zzq))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf, this.zzg, Integer.valueOf(this.zzh), Integer.valueOf(this.zzi), Integer.valueOf(this.zzj), Integer.valueOf(this.zzk), Integer.valueOf(this.zzl), Integer.valueOf(this.zzm), this.zzn, this.zzo, Integer.valueOf(this.zzp), Integer.valueOf(this.zzq));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzh);
        SafeParcelWriter.writeInt(parcel, 8, this.zzi);
        SafeParcelWriter.writeInt(parcel, 9, this.zzj);
        SafeParcelWriter.writeInt(parcel, 10, this.zzk);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzg, i, false);
        SafeParcelWriter.writeInt(parcel, 12, this.zzl);
        SafeParcelWriter.writeInt(parcel, 13, this.zzm);
        SafeParcelWriter.writeString(parcel, 14, this.zzn, false);
        SafeParcelWriter.writeString(parcel, 15, this.zzo, false);
        SafeParcelWriter.writeInt(parcel, 16, this.zzp);
        SafeParcelWriter.writeInt(parcel, 17, this.zzq);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzh;
    }

    public final int zze() {
        return this.zzi;
    }

    public final int zzf() {
        return this.zzj;
    }

    public final int zzg() {
        return this.zzk;
    }

    public final int zzh() {
        return this.zzl;
    }

    public final int zzi() {
        return this.zzm;
    }

    public final String zzj() {
        return this.zzn;
    }

    public final String zzk() {
        return this.zzo;
    }

    public final int zzl() {
        return this.zzp;
    }

    public final int zzm() {
        return this.zzq;
    }

    zzer(String str, int i, int i2, int i3, com.google.android.gms.internal.nearby.zzbz zzbzVar, com.google.android.gms.nearby.connection.zzo zzoVar, DctDevice dctDevice, int i4, int i5, int i6, int i7, int i8, int i9, String str2, String str3, int i10, int i11) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = zzbzVar;
        this.zzf = zzoVar;
        this.zzg = dctDevice;
        this.zzh = i4;
        this.zzi = i5;
        this.zzj = i6;
        this.zzk = i7;
        this.zzl = i8;
        this.zzm = i9;
        this.zzn = str2;
        this.zzo = str3;
        this.zzp = i10;
        this.zzq = i11;
    }
}
