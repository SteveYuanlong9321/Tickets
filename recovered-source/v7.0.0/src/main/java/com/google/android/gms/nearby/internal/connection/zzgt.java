package com.google.android.gms.nearby.internal.connection;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgt> CREATOR = new zzgu();
    private long zza;
    private Uri zzb;
    private String zzc;
    private zzgh[] zzd;

    private zzgt() {
        throw null;
    }

    zzgt(long j, Uri uri, String str, zzgh[] zzghVarArr) {
        this.zza = j;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = zzghVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgt) {
            zzgt zzgtVar = (zzgt) obj;
            if (Objects.equal(Long.valueOf(this.zza), Long.valueOf(zzgtVar.zza)) && Objects.equal(this.zzb, zzgtVar.zzb) && Objects.equal(this.zzc, zzgtVar.zzc) && Arrays.equals(this.zzd, zzgtVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), this.zzb, this.zzc, Integer.valueOf(Arrays.hashCode(this.zzd)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final long zza() {
        return this.zza;
    }

    public final Uri zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final zzgh[] zzd() {
        return this.zzd;
    }

    final /* synthetic */ void zze(long j) {
        this.zza = j;
    }

    final /* synthetic */ void zzf(Uri uri) {
        this.zzb = uri;
    }

    final /* synthetic */ void zzg(String str) {
        this.zzc = str;
    }

    final /* synthetic */ void zzh(zzgh[] zzghVarArr) {
        this.zzd = zzghVarArr;
    }

    /* synthetic */ zzgt(byte[] bArr) {
    }
}
