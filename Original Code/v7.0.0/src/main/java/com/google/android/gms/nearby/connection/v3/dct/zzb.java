package com.google.android.gms.nearby.connection.v3.dct;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.zzl;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzb extends AbstractSafeParcelable {
    private final int zzb;
    private final int zzc;
    private final byte[] zzd;
    private static final Charset zza = StandardCharsets.UTF_8;
    public static final Parcelable.Creator<zzb> CREATOR = new zzc();

    public zzb(int i, int i2, byte[] bArr) {
        this.zzb = i;
        this.zzd = bArr;
        this.zzc = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zzb;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String toString() {
        String str;
        int i = this.zzb;
        String str2 = "UNKNOWN";
        switch (i) {
            case 1:
                str = new String(this.zzd, zza);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                str = zzl.zza(this.zzd);
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        switch (i) {
            case 1:
                str2 = "SESSION_ID";
                break;
            case 2:
                str2 = "DEVICE_PLATFORM";
                break;
            case 3:
                str2 = "TX_POWER";
                break;
            case 4:
                str2 = "BLE_L2_CAP_PSM";
                break;
            case 5:
                str2 = "SERVICE_ID_HASH";
                break;
            case 6:
                str2 = "SUPPORTED_SERVICES";
                break;
            case 7:
                str2 = "DEVICE_INFO";
                break;
        }
        return String.format("DctDataElement{type=%s, length=%s, value=%s}", str2, Integer.valueOf(this.zzc), str);
    }
}
