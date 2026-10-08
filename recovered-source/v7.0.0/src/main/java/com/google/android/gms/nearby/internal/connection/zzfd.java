package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.v3.dct.DctDevice;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfd> CREATOR = new zzfe();
    private String zza;
    private final int zzb;
    private com.google.android.gms.internal.nearby.zzbz zzc;
    private com.google.android.gms.nearby.connection.zzo zzd;
    private DctDevice zze;
    private final int zzf;

    private zzfd() {
        this.zzb = 0;
        this.zzf = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfd) {
            zzfd zzfdVar = (zzfd) obj;
            if (Objects.equal(this.zza, zzfdVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzfdVar.zzb)) && Objects.equal(this.zzc, zzfdVar.zzc) && Objects.equal(this.zzd, zzfdVar.zzd) && Objects.equal(this.zze, zzfdVar.zze) && Objects.equal(Integer.valueOf(this.zzf), Integer.valueOf(zzfdVar.zzf))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze, Integer.valueOf(this.zzf));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zza() {
        return this.zza;
    }

    zzfd(String str, int i, com.google.android.gms.internal.nearby.zzbz zzbzVar, com.google.android.gms.nearby.connection.zzo zzoVar, DctDevice dctDevice, int i2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = zzbzVar;
        this.zzd = zzoVar;
        this.zze = dctDevice;
        this.zzf = i2;
    }
}
