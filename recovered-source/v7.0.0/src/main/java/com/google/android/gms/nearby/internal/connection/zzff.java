package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.v3.dct.DctDevice;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzff extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzff> CREATOR = new zzfg();
    private String zza;
    private int zzb;
    private com.google.android.gms.nearby.connection.zzx zzc;
    private final int zzd;
    private com.google.android.gms.nearby.connection.zzo zze;
    private DctDevice zzf;

    private zzff() {
        this.zzd = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzff) {
            zzff zzffVar = (zzff) obj;
            if (Objects.equal(this.zza, zzffVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzffVar.zzb)) && Objects.equal(this.zzc, zzffVar.zzc) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzffVar.zzd)) && Objects.equal(this.zze, zzffVar.zze) && Objects.equal(this.zzf, zzffVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), this.zzc, Integer.valueOf(this.zzd), this.zze, this.zzf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final com.google.android.gms.nearby.connection.zzx zzc() {
        return this.zzc;
    }

    zzff(String str, int i, com.google.android.gms.nearby.connection.zzx zzxVar, int i2, com.google.android.gms.nearby.connection.zzo zzoVar, DctDevice dctDevice) {
        this.zza = str;
        this.zzb = i;
        this.zzc = zzxVar;
        this.zzd = i2;
        this.zze = zzoVar;
        this.zzf = dctDevice;
    }
}
