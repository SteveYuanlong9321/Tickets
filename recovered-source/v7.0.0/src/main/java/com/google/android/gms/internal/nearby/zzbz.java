package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbz extends AbstractSafeParcelable implements com.google.android.gms.nearby.connection.zzs {
    public static final Parcelable.Creator<zzbz> CREATOR = new zzca();
    private static final String[] zza = {"UNKNOWN", "PHONE", "TABLET", "DISPLAY", "LAPTOP", "TV", "WATCH", "CHROMEOS", "FOLDABLE", "AUTOMOTIVE", "SPEAKER"};
    private final long zzb;
    private final String zzc;
    private final int zzd;
    private final String zze;
    private final long zzf;
    private final String zzg;
    private final byte[] zzh;
    private final byte[] zzi;
    private final List zzj;
    private final zzcb zzk;
    private final byte[] zzl;
    private final zzbp zzm;
    private final int zzn;
    private final int zzo;
    private final String zzp;
    private final String zzq;
    private final String zzr;
    private final List zzs;

    zzbz(long j, String str, int i, String str2, long j2, String str3, byte[] bArr, byte[] bArr2, List list, zzcb zzcbVar, byte[] bArr3, zzbp zzbpVar, int i2, int i3, String str4, String str5, String str6, List list2) {
        this.zzb = j;
        this.zzc = str;
        this.zzd = i;
        this.zze = str2;
        this.zzf = j2;
        this.zzg = str3;
        this.zzh = bArr;
        this.zzi = bArr2;
        this.zzj = list;
        this.zzk = zzcbVar;
        this.zzl = bArr3;
        this.zzm = zzbpVar;
        this.zzn = i2;
        this.zzo = i3;
        this.zzp = str4;
        this.zzq = str5;
        this.zzr = str6;
        if (list2 != null) {
            this.zzs = list2;
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.zzs = arrayList;
        if (i2 != 0) {
            arrayList.add(Integer.valueOf(i2));
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbz) {
            zzbz zzbzVar = (zzbz) obj;
            if (Objects.equals(Long.valueOf(this.zzb), Long.valueOf(zzbzVar.zzb)) && Objects.equals(this.zzc, zzbzVar.zzc) && Objects.equals(Integer.valueOf(this.zzd), Integer.valueOf(zzbzVar.zzd)) && Objects.equals(this.zze, zzbzVar.zze) && Objects.equals(this.zzg, zzbzVar.zzg) && Arrays.equals(this.zzh, zzbzVar.zzh) && Arrays.equals(this.zzi, zzbzVar.zzi) && Objects.equals(this.zzj, zzbzVar.zzj) && Objects.equals(this.zzk, zzbzVar.zzk) && Arrays.equals(this.zzl, zzbzVar.zzl) && Objects.equals(this.zzm, zzbzVar.zzm) && Objects.equals(Integer.valueOf(this.zzn), Integer.valueOf(zzbzVar.zzn)) && Objects.equals(Integer.valueOf(this.zzo), Integer.valueOf(zzbzVar.zzo)) && Objects.equals(this.zzp, zzbzVar.zzp) && Objects.equals(this.zzq, zzbzVar.zzq) && Objects.equals(this.zzr, zzbzVar.zzr)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zzb), this.zzc, Integer.valueOf(this.zzd), this.zze, this.zzg, Integer.valueOf(Arrays.hashCode(this.zzh)), Integer.valueOf(Arrays.hashCode(this.zzi)), this.zzj, this.zzk, Integer.valueOf(Arrays.hashCode(this.zzl)), this.zzm, Integer.valueOf(this.zzn), Integer.valueOf(this.zzo), this.zzp, this.zzq, this.zzr);
    }

    public final String toString() {
        char c;
        String string;
        Long lValueOf = Long.valueOf(this.zzb);
        String str = this.zzc;
        int i = this.zzd;
        String[] strArr = zza;
        switch (i) {
            case 1:
                c = 1;
                break;
            case 2:
                c = 2;
                break;
            case 3:
                c = 3;
                break;
            case 4:
                c = 4;
                break;
            case 5:
                c = 5;
                break;
            case 6:
                c = 6;
                break;
            case 7:
                c = 7;
                break;
            case 8:
                c = '\b';
                break;
            case 9:
                c = '\t';
                break;
            case 10:
                c = '\n';
                break;
            default:
                c = 0;
                break;
        }
        String str2 = strArr[c];
        String str3 = this.zze;
        Long lValueOf2 = Long.valueOf(this.zzf);
        String str4 = this.zzg;
        byte[] bArr = this.zzh;
        String string2 = bArr == null ? null : Arrays.toString(bArr);
        byte[] bArr2 = this.zzi;
        Integer numValueOf = bArr2 == null ? null : Integer.valueOf(Arrays.hashCode(bArr2));
        List list = this.zzj;
        zzcb zzcbVar = this.zzk;
        byte[] bArr3 = this.zzl;
        String string3 = bArr3 != null ? Arrays.toString(bArr3) : null;
        zzbp zzbpVar = this.zzm;
        int i2 = this.zzn;
        if (i2 != 0) {
            switch (i2) {
                case 2:
                    string = "BLUETOOTH";
                    break;
                case 3:
                    string = "WIFI_HOTSPOT";
                    break;
                case 4:
                    string = "BLE";
                    break;
                case 5:
                    string = "WIFI_LAN";
                    break;
                case 6:
                    string = "WIFI_AWARE";
                    break;
                case 7:
                    string = "NFC";
                    break;
                case 8:
                    string = "WIFI_DIRECT";
                    break;
                case 9:
                    string = "WEB_RTC";
                    break;
                case 10:
                    string = "BLE_L2CAP";
                    break;
                case 11:
                    string = "USB";
                    break;
                case 12:
                    string = "WEB_RTC_NON_CELLULAR";
                    break;
                case 13:
                    string = "AWDL";
                    break;
                default:
                    StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 9);
                    sb.append("UNKNOWN(");
                    sb.append(i2);
                    sb.append(")");
                    string = sb.toString();
                    break;
            }
        } else {
            string = "UNKNOWN_MEDIUM";
        }
        return String.format("PresenceDevice:<deviceId: %s, deviceName: %s, deviceType: %s, deviceImageUrl: %s, discoveryTimestampMillis: %s, endpointId: %s, endpointInfo: %s, bluetoothMacAddress hash: %s, actions: %s, identityType: %s, connectivityBytes hash: %s, dataElements: %s, discoveryMedium: %s, instance type %s, Dusi: %s, modelName: %s, manufacturer: %s>", lValueOf, str, str2, str3, lValueOf2, str4, string2, numValueOf, list, zzcbVar, string3, zzbpVar, string, com.google.android.gms.nearby.connection.zzs.zza(this.zzo), this.zzp, this.zzq, this.zzr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        long j = this.zzb;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, j);
        SafeParcelWriter.writeString(parcel, 2, this.zzc, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeString(parcel, 4, this.zze, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzf);
        SafeParcelWriter.writeString(parcel, 6, this.zzg, false);
        byte[] bArr = this.zzh;
        SafeParcelWriter.writeByteArray(parcel, 7, bArr == null ? null : (byte[]) bArr.clone(), false);
        byte[] bArr2 = this.zzi;
        SafeParcelWriter.writeByteArray(parcel, 8, bArr2 != null ? (byte[]) bArr2.clone() : null, false);
        List list = this.zzj;
        SafeParcelWriter.writeTypedList(parcel, 9, list == null ? zzyg.zzj() : zzyg.zzs(list), false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzk, i, false);
        SafeParcelWriter.writeByteArray(parcel, 11, this.zzl, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzm, i, false);
        SafeParcelWriter.writeInt(parcel, 13, this.zzn);
        SafeParcelWriter.writeInt(parcel, 14, this.zzo);
        SafeParcelWriter.writeString(parcel, 15, this.zzp, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzq, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzr, false);
        List list2 = this.zzs;
        SafeParcelWriter.writeIntegerList(parcel, 18, list2 == null ? zzyg.zzj() : zzyg.zzs(list2), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
