package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new zzbd();
    final int zza;
    final int zzb;
    final byte[] zzc;
    final boolean zzd;

    zzbc(int i, int i2, byte[] bArr, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = bArr;
        this.zzd = z;
    }

    public static zzbc zza(String str, String str2) {
        String.valueOf(str);
        if (str2 == null) {
            str2 = "";
        }
        return new zzbc(1, 2, new com.google.android.gms.nearby.messages.internal.zzg(com.google.android.gms.nearby.messages.internal.zzg.zzb(String.valueOf(str).concat(str2))).zzc(), false);
    }

    public static zzbc zzb(UUID uuid, Short sh, Short sh2) {
        return new zzbc(1, 3, new com.google.android.gms.nearby.messages.internal.zzl(uuid, sh, sh2).zzc(), false);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zzb;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
