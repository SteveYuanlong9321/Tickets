package com.google.android.gms.nearby.connection;

import android.util.Log;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class zzam implements zzq {
    private final int zza;
    private final byte[] zzb;
    private final byte[] zzc;
    private final int zzd;
    private final int zze;

    public zzam(int i, byte[] bArr, byte[] bArr2, int i2, int i3) {
        this.zza = i;
        this.zzb = bArr;
        this.zzc = bArr2;
        this.zzd = i2;
        this.zze = i3;
    }

    protected static zzal zzb(byte[] bArr) {
        if (zzr.zzc(bArr, 0) != 17) {
            Log.i("NC_WifiMOConnInfo", "Incorrect size for WiFi Medium Owner Connectivity Info.");
            return null;
        }
        if (zzr.zzd(bArr, 0) != 20) {
            Log.i("NC_WifiMOConnInfo", String.format("Failed to parse connectivity info due to incorrect data element type: %X.", Integer.valueOf(zzr.zzd(bArr, 0))));
            return null;
        }
        int iZza = zzr.zza(bArr, 0);
        byte b = bArr[iZza];
        int i = iZza + 5;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, iZza + 1, i);
        if (bArrCopyOfRange.length != 4) {
            Log.i("NC_WifiMOConnInfo", "Failed to read SSID.");
            return null;
        }
        int i2 = iZza + 13;
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, i, i2);
        if (bArrCopyOfRange2.length != 8) {
            Log.i("NC_WifiMOConnInfo", "Failed to read password.");
            return null;
        }
        int i3 = iZza + 15;
        byte[] bArrCopyOfRange3 = Arrays.copyOfRange(bArr, i2, i3);
        if (bArrCopyOfRange3.length != 2) {
            Log.i("NC_WifiMOConnInfo", "Failed to read port.");
            return null;
        }
        int iZzb = zzl.zzb(bArrCopyOfRange3);
        byte[] bArrCopyOfRange4 = Arrays.copyOfRange(bArr, i3, iZza + 17);
        if (bArrCopyOfRange4.length != 2) {
            Log.i("NC_WifiMOConnInfo", "Failed to read channelMhz.");
            return null;
        }
        int iZzb2 = zzl.zzb(bArrCopyOfRange4);
        zzak zzakVar = new zzak();
        zzakVar.zza(bArrCopyOfRange);
        zzakVar.zzb(bArrCopyOfRange2);
        zzakVar.zzc(iZzb);
        zzakVar.zzd(iZzb2);
        return zzakVar.zze();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzam) {
            zzam zzamVar = (zzam) obj;
            if (this.zza == zzamVar.zza && Arrays.equals(this.zzb, zzamVar.zzb) && Arrays.equals(this.zzc, zzamVar.zzc) && this.zzd == zzamVar.zzd && this.zze == zzamVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.zza), Integer.valueOf(Arrays.hashCode(this.zzb)), Integer.valueOf(Arrays.hashCode(this.zzc)), Integer.valueOf(this.zzd), Integer.valueOf(this.zze));
    }

    public final String toString() {
        return String.format("WifiMediumOwnerConnectivityInfo: <medium type: %s>, <ssid hash: %s>, <password hash: %s>, <port hash: %s>, <channelMhz hash: %s>", this.zza != 4 ? "WIFI_DIRECT" : "WIFI_HOTSPOT", Integer.valueOf(Arrays.hashCode(this.zzb)), Integer.valueOf(Arrays.hashCode(this.zzc)), Integer.valueOf(this.zzd), Integer.valueOf(this.zze));
    }
}
