package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();
    private int zza;
    private int zzb;
    private int zzc;
    private boolean zzd;

    private zzx() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzx) {
            zzx zzxVar = (zzx) obj;
            if (Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(zzxVar.zza)) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzxVar.zzb)) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzxVar.zzc)) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(zzxVar.zzd))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Boolean.valueOf(this.zzd));
    }

    public final String toString() {
        int i = this.zza;
        int i2 = this.zzb;
        int i3 = this.zzc;
        boolean z = this.zzd;
        int length = String.valueOf(i).length();
        int length2 = String.valueOf(i2).length();
        StringBuilder sb = new StringBuilder(length + 54 + length2 + 25 + String.valueOf(i3).length() + 28 + String.valueOf(z).length() + 1);
        sb.append("UwbRangingData{rawDistance=");
        sb.append(i);
        sb.append(", rawAngleOfArrivalAzimuth=");
        sb.append(i2);
        sb.append(", rawAngleOfArrivalPolar=");
        sb.append(i3);
        sb.append(", isValidAngleOfArrivalData=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zzx(int i, int i2, int i3, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = z;
    }
}
