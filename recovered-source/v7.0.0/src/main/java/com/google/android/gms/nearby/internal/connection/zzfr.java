package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.v3.dct.DctDevice;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfr> CREATOR = new zzfs();
    private String zza;
    private zzgq zzb;
    private boolean zzc;
    private final int zzd;
    private com.google.android.gms.internal.nearby.zzbz zze;
    private com.google.android.gms.nearby.connection.zzo zzf;
    private DctDevice zzg;

    private zzfr() {
        this.zzd = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfr) {
            zzfr zzfrVar = (zzfr) obj;
            if (Objects.equal(this.zza, zzfrVar.zza) && Objects.equal(this.zzb, zzfrVar.zzb) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(zzfrVar.zzc)) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzfrVar.zzd)) && Objects.equal(this.zze, zzfrVar.zze) && Objects.equal(this.zzf, zzfrVar.zzf) && Objects.equal(this.zzg, zzfrVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Boolean.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf, this.zzg);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zza() {
        return this.zza;
    }

    public final zzgq zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zzc;
    }

    zzfr(String str, zzgq zzgqVar, boolean z, int i, com.google.android.gms.internal.nearby.zzbz zzbzVar, com.google.android.gms.nearby.connection.zzo zzoVar, DctDevice dctDevice) {
        this.zza = str;
        this.zzb = zzgqVar;
        this.zzc = z;
        this.zzd = i;
        this.zze = zzbzVar;
        this.zzf = zzoVar;
        this.zzg = dctDevice;
    }
}
