package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgw> CREATOR = new zzgx();
    private boolean zza;
    private long zzb;
    private String zzc;
    private byte[][] zzd;
    private zzgk[] zze;
    private boolean zzf;
    private ParcelByteArray[] zzg;

    private zzgw() {
        throw null;
    }

    zzgw(boolean z, long j, String str, byte[][] bArr, zzgk[] zzgkVarArr, boolean z2, ParcelByteArray[] parcelByteArrayArr) {
        this.zza = z;
        this.zzb = j;
        this.zzc = str;
        this.zzd = bArr;
        this.zze = zzgkVarArr;
        this.zzf = z2;
        this.zzg = parcelByteArrayArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgw) {
            zzgw zzgwVar = (zzgw) obj;
            if (Objects.equal(Boolean.valueOf(this.zza), Boolean.valueOf(zzgwVar.zza)) && Objects.equal(Long.valueOf(this.zzb), Long.valueOf(zzgwVar.zzb)) && Objects.equal(this.zzc, zzgwVar.zzc) && Arrays.equals(this.zzd, zzgwVar.zzd) && Arrays.equals(this.zze, zzgwVar.zze) && Objects.equal(Boolean.valueOf(this.zzf), Boolean.valueOf(zzgwVar.zzf)) && Arrays.equals(this.zzg, zzgwVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zza), Long.valueOf(this.zzb), this.zzc, Integer.valueOf(Arrays.deepHashCode(this.zzd)), Integer.valueOf(Arrays.hashCode(this.zze)), Boolean.valueOf(this.zzf), Integer.valueOf(Arrays.hashCode(this.zzg)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.writeTypedArray(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final boolean zza() {
        return this.zza;
    }

    public final long zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final zzgk[] zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return this.zzf;
    }

    public final ParcelByteArray[] zzf() {
        return this.zzg;
    }

    final /* synthetic */ void zzg(boolean z) {
        this.zza = z;
    }

    final /* synthetic */ void zzh(long j) {
        this.zzb = j;
    }

    final /* synthetic */ void zzi(String str) {
        this.zzc = str;
    }

    final /* synthetic */ void zzj(zzgk[] zzgkVarArr) {
        this.zze = zzgkVarArr;
    }

    final /* synthetic */ void zzk(boolean z) {
        this.zzf = z;
    }

    final /* synthetic */ void zzl(ParcelByteArray[] parcelByteArrayArr) {
        this.zzg = parcelByteArrayArr;
    }

    /* synthetic */ zzgw(byte[] bArr) {
    }
}
