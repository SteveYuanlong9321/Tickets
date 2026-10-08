package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzhs> CREATOR = new zzht();
    private zzgb zza;

    private zzhs() {
        throw null;
    }

    zzhs(zzgb zzgbVar) {
        this.zza = zzgbVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzhs) {
            return Objects.equal(this.zza, ((zzhs) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final zzgb zza() {
        return this.zza;
    }

    final /* synthetic */ void zzb(zzgb zzgbVar) {
        this.zza = zzgbVar;
    }

    /* synthetic */ zzhs(byte[] bArr) {
    }
}
