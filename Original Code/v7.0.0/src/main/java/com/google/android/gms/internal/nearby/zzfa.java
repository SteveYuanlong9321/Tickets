package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfa> CREATOR = new zzfb();
    private zzgb zza;
    private int zzb;
    private byte[] zzc;

    private zzfa() {
        throw null;
    }

    zzfa(zzgb zzgbVar, int i, byte[] bArr) {
        this.zza = zzgbVar;
        this.zzb = i;
        this.zzc = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfa) {
            zzfa zzfaVar = (zzfa) obj;
            if (Objects.equal(this.zza, zzfaVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzfaVar.zzb)) && Arrays.equals(this.zzc, zzfaVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), Integer.valueOf(Arrays.hashCode(this.zzc)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ void zza(zzgb zzgbVar) {
        this.zza = zzgbVar;
    }

    final /* synthetic */ void zzb(int i) {
        this.zzb = i;
    }

    final /* synthetic */ void zzc(byte[] bArr) {
        this.zzc = bArr;
    }

    /* synthetic */ zzfa(byte[] bArr) {
    }
}
