package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbr> CREATOR = new zzbs();
    private final int zza;

    public zzbr(int i) {
        this.zza = i;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzbr) && this.zza == ((zzbr) obj).zza;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.zza));
    }

    public final String toString() {
        int i = this.zza;
        if (i == 0) {
            return "DeviceCapability<INTERNET_CONNECTIVITY>";
        }
        if (i == 1) {
            return "DeviceCapability<CAST_RECEIVER>";
        }
        if (i != 2) {
            return i != 3 ? "DeviceCapability<UNKNOWN>" : "DeviceCapability<SPEAKER>";
        }
        return "DeviceCapability<CAMERA>";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
