package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.messages.Distance;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zze extends AbstractSafeParcelable implements Distance {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();
    final int zza;
    public final int zzb;
    public final double zzc;

    public zze(int i, double d) {
        this(1, 1, Double.NaN);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.nearby.messages.Distance, java.lang.Comparable
    public final int compareTo(Distance distance) {
        double d = this.zzc;
        if (Double.isNaN(d) && Double.isNaN(distance.getMeters())) {
            return 0;
        }
        return Double.compare(d, distance.getMeters());
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zze)) {
            return false;
        }
        zze zzeVar = (zze) obj;
        return this.zzb == zzeVar.zzb && compareTo((Distance) zzeVar) == 0;
    }

    @Override // com.google.android.gms.nearby.messages.Distance
    public final int getAccuracy() {
        return this.zzb;
    }

    @Override // com.google.android.gms.nearby.messages.Distance
    public final double getMeters() {
        return this.zzc;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.zzb), Double.valueOf(this.zzc));
    }

    public final String toString() {
        return String.format(Locale.US, "(%.1fm, %s)", Double.valueOf(this.zzc), this.zzb != 1 ? "UNKNOWN" : "LOW");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeDouble(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zze(int i, int i2, double d) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = d;
    }
}
