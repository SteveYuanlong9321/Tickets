package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzjk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjk> CREATOR = new zzjn();
    private final zzjo zza;
    private final long zzb;
    private final int zzc;

    public zzjk(zzjo zzjoVar, long j, int i) {
        String strValueOf = String.valueOf(zzjoVar);
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 22 + String.valueOf(strValueOf).length());
        sb.append("State is ");
        sb.append(i);
        sb.append(" but pose is ");
        sb.append(strValueOf);
        zzxd.zzb((i == 0) == (zzjoVar != null), sb.toString());
        this.zza = zzjoVar;
        this.zzb = j;
        this.zzc = i;
    }

    public final String toString() {
        return String.format(Locale.US, "Odometry<pose=%s, timeNanos=%d, state=%d>", this.zza, Long.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzjo zzjoVar = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, zzjoVar, i, false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
