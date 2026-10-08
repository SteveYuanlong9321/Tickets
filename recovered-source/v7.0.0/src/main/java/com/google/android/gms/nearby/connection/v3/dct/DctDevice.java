package com.google.android.gms.nearby.connection.v3.dct;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.zzs;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class DctDevice extends AbstractSafeParcelable implements zzs {
    public static final Parcelable.Creator<DctDevice> CREATOR = new zza();
    private final String zza;
    private final List zzb;
    private final String zzc;
    private final String zzd;

    DctDevice(String str, List list, String str2, String str3) {
        this.zza = str;
        this.zzb = list;
        this.zzc = str2;
        this.zzd = str3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof DctDevice) {
            DctDevice dctDevice = (DctDevice) obj;
            if (Objects.equals(this.zza, dctDevice.zza) && Objects.equals(this.zzb, dctDevice.zzb) && Objects.equals(this.zzc, dctDevice.zzc) && Objects.equals(this.zzd, dctDevice.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zzb);
    }

    public final String toString() {
        return String.format("DctDevice:<endpointId: %s, deviceDataElements: %s, deviceModel: %s, manufacturer: %s>", this.zza, this.zzb, this.zzc, this.zzd);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
