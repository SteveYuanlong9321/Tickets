package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcf extends AbstractSafeParcelable implements zzbo {
    public static final Parcelable.Creator<zzcf> CREATOR;
    private final boolean zza;
    private final boolean zzb;

    static {
        new zzcf(false, false);
        CREATOR = new zzcg();
    }

    public zzcf(boolean z, boolean z2) {
        this.zza = z;
        this.zzb = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcf)) {
            return false;
        }
        zzcf zzcfVar = (zzcf) obj;
        return this.zza == zzcfVar.zza && this.zzb == zzcfVar.zzb;
    }

    public final int hashCode() {
        return Objects.hash(Boolean.valueOf(this.zza), Boolean.valueOf(this.zzb));
    }

    public final String toString() {
        return String.format(Locale.US, "UwbConnectivityCapability<S-STS: %s, P-STS: %s>", Boolean.valueOf(this.zza), Boolean.valueOf(this.zzb));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        boolean z = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, z);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
