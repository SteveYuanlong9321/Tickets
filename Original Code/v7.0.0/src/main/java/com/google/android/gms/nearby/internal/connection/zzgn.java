package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgn> CREATOR = new zzgo();
    private String zza;
    private ParcelByteArray zzb;

    private zzgn() {
        throw null;
    }

    zzgn(String str, ParcelByteArray parcelByteArray) {
        this.zza = str;
        this.zzb = parcelByteArray;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgn) {
            zzgn zzgnVar = (zzgn) obj;
            if (Objects.equal(this.zza, zzgnVar.zza) && Objects.equal(this.zzb, zzgnVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zza() {
        return this.zza;
    }

    public final ParcelByteArray zzb() {
        return this.zzb;
    }

    final /* synthetic */ void zzc(String str) {
        this.zza = str;
    }

    final /* synthetic */ void zzd(ParcelByteArray parcelByteArray) {
        this.zzb = parcelByteArray;
    }

    /* synthetic */ zzgn(byte[] bArr) {
    }
}
