package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.uwb.PrecisionFindingConfig;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzff extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzff> CREATOR = new zzfg();
    private int zza;
    private int zzb;
    private byte[] zzc;
    private zzgi zzd;
    private int zze;
    private zzhs[] zzf;
    private int zzg;
    private byte[] zzh;
    private zzhs zzi;
    private zzes zzj;
    private int zzk;
    private int zzl;
    private boolean zzm;
    private zzev zzn;
    private PrecisionFindingConfig zzo;

    private zzff() {
        throw null;
    }

    zzff(int i, int i2, byte[] bArr, zzgi zzgiVar, int i3, zzhs[] zzhsVarArr, int i4, byte[] bArr2, zzhs zzhsVar, zzes zzesVar, int i5, int i6, boolean z, zzev zzevVar, PrecisionFindingConfig precisionFindingConfig) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = bArr;
        this.zzd = zzgiVar;
        this.zze = i3;
        this.zzf = zzhsVarArr;
        this.zzg = i4;
        this.zzh = bArr2;
        this.zzi = zzhsVar;
        this.zzj = zzesVar;
        this.zzk = i5;
        this.zzl = i6;
        this.zzm = z;
        this.zzn = zzevVar;
        this.zzo = precisionFindingConfig;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzff) {
            zzff zzffVar = (zzff) obj;
            if (Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(zzffVar.zza)) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzffVar.zzb)) && Arrays.equals(this.zzc, zzffVar.zzc) && Objects.equal(this.zzd, zzffVar.zzd) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(zzffVar.zze)) && Arrays.equals(this.zzf, zzffVar.zzf) && Objects.equal(Integer.valueOf(this.zzg), Integer.valueOf(zzffVar.zzg)) && Arrays.equals(this.zzh, zzffVar.zzh) && Objects.equal(this.zzi, zzffVar.zzi) && Objects.equal(this.zzj, zzffVar.zzj) && Objects.equal(Integer.valueOf(this.zzk), Integer.valueOf(zzffVar.zzk)) && Objects.equal(Integer.valueOf(this.zzl), Integer.valueOf(zzffVar.zzl)) && Objects.equal(Boolean.valueOf(this.zzm), Boolean.valueOf(zzffVar.zzm)) && Objects.equal(this.zzn, zzffVar.zzn) && Objects.equal(this.zzo, zzffVar.zzo)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(Arrays.hashCode(this.zzc)), this.zzd, Integer.valueOf(this.zze), Integer.valueOf(Arrays.hashCode(this.zzf)), Integer.valueOf(this.zzg), Integer.valueOf(Arrays.hashCode(this.zzh)), this.zzi, this.zzj, Integer.valueOf(this.zzk), Integer.valueOf(this.zzl), Boolean.valueOf(this.zzm), this.zzn, this.zzo);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeTypedArray(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzg);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzh, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzk);
        SafeParcelWriter.writeInt(parcel, 12, this.zzl);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzm);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzn, i, false);
        SafeParcelWriter.writeParcelable(parcel, 15, this.zzo, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ void zza(int i) {
        this.zza = i;
    }

    final /* synthetic */ void zzb(int i) {
        this.zzb = i;
    }

    final /* synthetic */ void zzc(byte[] bArr) {
        this.zzc = bArr;
    }

    final /* synthetic */ void zzd(zzgi zzgiVar) {
        this.zzd = zzgiVar;
    }

    final /* synthetic */ void zze(int i) {
        this.zze = i;
    }

    final /* synthetic */ void zzf(zzhs[] zzhsVarArr) {
        this.zzf = zzhsVarArr;
    }

    final /* synthetic */ void zzg(int i) {
        this.zzg = i;
    }

    final /* synthetic */ void zzh(byte[] bArr) {
        this.zzh = bArr;
    }

    final /* synthetic */ void zzi(zzhs zzhsVar) {
        this.zzi = zzhsVar;
    }

    final /* synthetic */ void zzj(zzes zzesVar) {
        this.zzj = zzesVar;
    }

    final /* synthetic */ void zzk(int i) {
        this.zzk = i;
    }

    final /* synthetic */ void zzl(boolean z) {
        this.zzm = z;
    }

    final /* synthetic */ void zzm(zzev zzevVar) {
        this.zzn = zzevVar;
    }

    final /* synthetic */ void zzn(PrecisionFindingConfig precisionFindingConfig) {
        this.zzo = precisionFindingConfig;
    }
}
