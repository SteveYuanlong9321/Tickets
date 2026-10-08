package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbm extends AbstractSafeParcelable implements zzbo {
    public static final Parcelable.Creator<zzbm> CREATOR = new zzbn();
    private final String zza;

    public zzbm(String str) {
        Preconditions.checkArgument(str.length() <= 32, "Cast id should be at most 32 characters.");
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbm) {
            return Objects.equals(this.zza, ((zzbm) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(17, this.zza);
    }

    public final String toString() {
        return String.format(Locale.US, "DataElement<type: %s, Id: %s>", zzbo.zza(17), this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
