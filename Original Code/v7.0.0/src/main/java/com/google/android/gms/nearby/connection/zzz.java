package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzz> CREATOR = new zzaa();
    private byte[] zza;
    private int zzb;
    private int zzc;

    private zzz() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzz) {
            zzz zzzVar = (zzz) obj;
            if (Arrays.equals(this.zza, zzzVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzzVar.zzb)) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzzVar.zzc))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zza)), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    public final String toString() {
        String string = Arrays.toString(this.zza);
        int i = this.zzb;
        int i2 = this.zzc;
        int length = String.valueOf(string).length();
        StringBuilder sb = new StringBuilder(length + 32 + String.valueOf(i).length() + 16 + String.valueOf(i2).length() + 1);
        sb.append("UwbSenderInfo{address=");
        sb.append(string);
        sb.append(", channel=");
        sb.append(i);
        sb.append(", preambleIndex=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zzz(byte[] bArr, int i, int i2) {
        this.zza = bArr;
        this.zzb = i;
        this.zzc = i2;
    }
}
