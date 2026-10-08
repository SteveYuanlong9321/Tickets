package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import com.google.android.gms.nearby.connection.v3.dct.DctDevice;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzft extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzft> CREATOR = new zzfu();
    private String zza;
    private PayloadTransferUpdate zzb;
    private final int zzc;
    private com.google.android.gms.internal.nearby.zzbz zzd;
    private com.google.android.gms.nearby.connection.zzo zze;
    private DctDevice zzf;

    private zzft() {
        this.zzc = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzft) {
            zzft zzftVar = (zzft) obj;
            if (Objects.equal(this.zza, zzftVar.zza) && Objects.equal(this.zzb, zzftVar.zzb) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzftVar.zzc)) && Objects.equal(this.zzd, zzftVar.zzd) && Objects.equal(this.zze, zzftVar.zze) && Objects.equal(this.zzf, zzftVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(this.zzc), this.zzd, this.zze, this.zzf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zza() {
        return this.zza;
    }

    public final PayloadTransferUpdate zzb() {
        return this.zzb;
    }

    zzft(String str, PayloadTransferUpdate payloadTransferUpdate, int i, com.google.android.gms.internal.nearby.zzbz zzbzVar, com.google.android.gms.nearby.connection.zzo zzoVar, DctDevice dctDevice) {
        this.zza = str;
        this.zzb = payloadTransferUpdate;
        this.zzc = i;
        this.zzd = zzbzVar;
        this.zze = zzoVar;
        this.zzf = dctDevice;
    }
}
