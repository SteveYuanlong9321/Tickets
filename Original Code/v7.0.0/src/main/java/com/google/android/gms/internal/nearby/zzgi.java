package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgi> CREATOR = new zzgj();
    private int zza;
    private int zzb;
    private int zzc;

    private zzgi() {
        throw null;
    }

    zzgi(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgi) {
            zzgi zzgiVar = (zzgi) obj;
            if (Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(zzgiVar.zza)) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzgiVar.zzb)) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzgiVar.zzc))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    final /* synthetic */ void zzc(int i) {
        this.zza = i;
    }

    final /* synthetic */ void zzd(int i) {
        this.zzb = i;
    }

    /* synthetic */ zzgi(byte[] bArr) {
    }
}
