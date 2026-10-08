package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzif extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzif> CREATOR = new zzig();
    public final String zza;
    public final String zzb;
    public final zzid zzc;
    public final boolean zzd;

    public zzif(String str, String str2, zzid zzidVar, boolean z) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzidVar;
        this.zzd = z;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzif)) {
            return false;
        }
        zzif zzifVar = (zzif) obj;
        return zziz.zza(this.zza, zzifVar.zza) && zziz.zza(this.zzb, zzifVar.zzb) && zziz.zza(this.zzc, zzifVar.zzc) && this.zzd == zzifVar.zzd;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        zza(sb);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, str, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final void zza(StringBuilder sb) {
        sb.append("FlagOverride(");
        sb.append(this.zza);
        sb.append(", ");
        sb.append(this.zzb);
        sb.append(", ");
        this.zzc.zzf(sb);
        sb.append(", ");
        sb.append(this.zzd);
        sb.append(")");
    }
}
