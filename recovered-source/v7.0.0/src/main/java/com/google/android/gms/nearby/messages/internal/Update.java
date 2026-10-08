package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArraySet;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class Update extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Update> CREATOR = new zzcg();
    final int zza;
    final int zzb;
    public final Message zzc;
    public final zze zzd;
    public final zza zze;
    public final com.google.android.gms.internal.nearby.zzba zzf;
    public final byte[] zzg;

    Update(int i, int i2, Message message, zze zzeVar, zza zzaVar, com.google.android.gms.internal.nearby.zzba zzbaVar, byte[] bArr) {
        this.zza = i;
        boolean zZzb = zzb(i2, 2);
        this.zzb = true == zZzb ? 2 : i2;
        this.zzc = message;
        this.zzd = true == zZzb ? null : zzeVar;
        this.zze = true == zZzb ? null : zzaVar;
        this.zzf = true == zZzb ? null : zzbaVar;
        this.zzg = true == zZzb ? null : bArr;
    }

    public static boolean zzb(int i, int i2) {
        return (i & i2) != 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Update)) {
            return false;
        }
        Update update = (Update) obj;
        return this.zzb == update.zzb && Objects.equals(this.zzc, update.zzc) && Objects.equals(this.zzd, update.zzd) && Objects.equals(this.zze, update.zze) && Objects.equals(this.zzf, update.zzf) && Arrays.equals(this.zzg, update.zzg);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze, this.zzf, Integer.valueOf(Arrays.hashCode(this.zzg)));
    }

    public final String toString() {
        ArraySet arraySet = new ArraySet();
        int i = this.zzb;
        if (zzb(i, 1)) {
            arraySet.add("FOUND");
        }
        if (zzb(i, 2)) {
            arraySet.add("LOST");
        }
        if (zzb(i, 4)) {
            arraySet.add("DISTANCE");
        }
        if (zzb(i, 8)) {
            arraySet.add("BLE_SIGNAL");
        }
        if (zzb(i, 16)) {
            arraySet.add("DEVICE");
        }
        if (zzb(i, 32)) {
            arraySet.add("BLE_RECORD");
        }
        String string = arraySet.toString();
        Message message = this.zzc;
        zze zzeVar = this.zzd;
        zza zzaVar = this.zze;
        com.google.android.gms.internal.nearby.zzba zzbaVar = this.zzf;
        byte[] bArr = this.zzg;
        String strValueOf = String.valueOf(message);
        String strValueOf2 = String.valueOf(zzeVar);
        String strValueOf3 = String.valueOf(zzaVar);
        String strValueOf4 = String.valueOf(zzbaVar);
        String strValueOf5 = String.valueOf(com.google.android.gms.internal.nearby.zzaz.zza(bArr));
        int length = string.length();
        StringBuilder sb = new StringBuilder(length + 23 + String.valueOf(strValueOf).length() + 11 + String.valueOf(strValueOf2).length() + 12 + String.valueOf(strValueOf3).length() + 9 + String.valueOf(strValueOf4).length() + 12 + String.valueOf(strValueOf5).length() + 1);
        sb.append("Update{types=");
        sb.append(string);
        sb.append(", message=");
        sb.append(strValueOf);
        sb.append(", distance=");
        sb.append(strValueOf2);
        sb.append(", bleSignal=");
        sb.append(strValueOf3);
        sb.append(", device=");
        sb.append(strValueOf4);
        sb.append(", bleRecord=");
        sb.append(strValueOf5);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeByteArray(parcel, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final boolean zza(int i) {
        return zzb(this.zzb, i);
    }
}
