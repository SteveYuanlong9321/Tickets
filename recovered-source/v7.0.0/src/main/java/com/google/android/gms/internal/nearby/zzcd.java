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
public final class zzcd extends AbstractSafeParcelable implements zzbo {
    public static final Parcelable.Creator<zzcd> CREATOR = new zzce();
    private final int zza;

    public zzcd(int i) {
        boolean z = false;
        if (i >= 0 && i <= 15) {
            z = true;
        }
        Preconditions.checkArgument(z, "Sequence number should be 4 bits.");
        this.zza = i;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzcd) && this.zza == ((zzcd) obj).zza;
    }

    public final int hashCode() {
        return Objects.hash(19, Integer.valueOf(this.zza));
    }

    public final String toString() {
        return String.format(Locale.US, "DataElement<type: %s, value: %d>", zzbo.zza(19), Integer.valueOf(this.zza));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
