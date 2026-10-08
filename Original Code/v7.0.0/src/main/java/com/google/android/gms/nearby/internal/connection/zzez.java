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
public final class zzez extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzez> CREATOR = new zzfa();
    private String zza;
    private int zzb;
    private byte[] zzc;
    private final int zzd;
    private com.google.android.gms.internal.nearby.zzbz zze;
    private com.google.android.gms.nearby.connection.zzo zzf;
    private DctDevice zzg;

    private zzez() {
        this.zzd = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzez) {
            zzez zzezVar = (zzez) obj;
            if (Objects.equal(this.zza, zzezVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzezVar.zzb)) && Arrays.equals(this.zzc, zzezVar.zzc) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzezVar.zzd)) && Objects.equal(this.zze, zzezVar.zze) && Objects.equal(this.zzf, zzezVar.zzf) && Objects.equal(this.zzg, zzezVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), Integer.valueOf(Arrays.hashCode(this.zzc)), Integer.valueOf(this.zzd), this.zze, this.zzf, this.zzg);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    zzez(String str, int i, byte[] bArr, int i2, com.google.android.gms.internal.nearby.zzbz zzbzVar, com.google.android.gms.nearby.connection.zzo zzoVar, DctDevice dctDevice) {
        this.zza = str;
        this.zzb = i;
        this.zzc = bArr;
        this.zzd = i2;
        this.zze = zzbzVar;
        this.zzf = zzoVar;
        this.zzg = dctDevice;
    }
}
