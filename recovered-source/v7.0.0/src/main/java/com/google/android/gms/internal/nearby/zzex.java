package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzex extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzex> CREATOR = new zzey();
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private int zzd;
    private int zze;
    private int[] zzf;
    private int[] zzg;
    private float zzh;
    private int[] zzi;
    private int[] zzj;
    private int[] zzk;
    private boolean zzl;
    private boolean zzm;

    private zzex() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzex) {
            zzex zzexVar = (zzex) obj;
            if (Objects.equal(Boolean.valueOf(this.zza), Boolean.valueOf(zzexVar.zza)) && Objects.equal(Boolean.valueOf(this.zzb), Boolean.valueOf(zzexVar.zzb)) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(zzexVar.zzc)) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzexVar.zzd)) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(zzexVar.zze)) && Arrays.equals(this.zzf, zzexVar.zzf) && Arrays.equals(this.zzg, zzexVar.zzg) && Objects.equal(Float.valueOf(this.zzh), Float.valueOf(zzexVar.zzh)) && Arrays.equals(this.zzi, zzexVar.zzi) && Arrays.equals(this.zzj, zzexVar.zzj) && Arrays.equals(this.zzk, zzexVar.zzk) && Objects.equal(Boolean.valueOf(this.zzl), Boolean.valueOf(zzexVar.zzl)) && Objects.equal(Boolean.valueOf(this.zzm), Boolean.valueOf(zzexVar.zzm))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zza), Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), Integer.valueOf(Arrays.hashCode(this.zzf)), Integer.valueOf(Arrays.hashCode(this.zzg)), Float.valueOf(this.zzh), Integer.valueOf(Arrays.hashCode(this.zzi)), Integer.valueOf(Arrays.hashCode(this.zzj)), Integer.valueOf(Arrays.hashCode(this.zzk)), Boolean.valueOf(this.zzl), Boolean.valueOf(this.zzm));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeIntArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeIntArray(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeFloat(parcel, 8, this.zzh);
        SafeParcelWriter.writeIntArray(parcel, 9, this.zzi, false);
        SafeParcelWriter.writeIntArray(parcel, 10, this.zzj, false);
        SafeParcelWriter.writeIntArray(parcel, 11, this.zzk, false);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzl);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzm);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final boolean zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zze;
    }

    public final int[] zze() {
        return this.zzf;
    }

    public final int[] zzf() {
        return this.zzg;
    }

    public final int[] zzg() {
        return this.zzi;
    }

    public final int[] zzh() {
        return this.zzj;
    }

    public final int[] zzi() {
        return this.zzk;
    }

    public final boolean zzj() {
        return this.zzl;
    }

    public final boolean zzk() {
        return this.zzm;
    }

    zzex(boolean z, boolean z2, boolean z3, int i, int i2, int[] iArr, int[] iArr2, float f, int[] iArr3, int[] iArr4, int[] iArr5, boolean z4, boolean z5) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = i;
        this.zze = i2;
        this.zzf = iArr;
        this.zzg = iArr2;
        this.zzh = f;
        this.zzi = iArr3;
        this.zzj = iArr4;
        this.zzk = iArr5;
        this.zzl = z4;
        this.zzm = z5;
    }
}
