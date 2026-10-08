package com.google.android.gms.nearby.connection;

import android.os.Parcelable;
import android.util.Log;
import androidx.compose.foundation.style.StylePropertiesKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.nearby.zzame;
import com.google.android.gms.internal.nearby.zzau;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public interface zzq {
    /* JADX WARN: Multi-variable type inference failed */
    static zzq zza(byte[] bArr) {
        if (zzr.zzd(bArr, 0) != 20) {
            Log.i("NC_ConnInfo", "Failed to parse ConnectivityInfo due to incorrect data element type");
            return null;
        }
        byte b = bArr[zzr.zza(bArr, 0)];
        if (b == 0) {
            Parcelable.Creator<zzj> creator = zzj.CREATOR;
            zzi zziVar = new zzi();
            if (zzr.zzc(bArr, 0) <= 0) {
                throw new IllegalArgumentException("The length is 0");
            }
            if (zzr.zzd(bArr, 0) != 20) {
                throw new IllegalArgumentException(String.format("The field type is not %d", 20));
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            int iZza = zzr.zza(bArr, 0);
            if (byteArrayInputStream.read(new byte[iZza], 0, iZza) != iZza) {
                throw new IllegalArgumentException("Failed to read header.");
            }
            if (byteArrayInputStream.read() != 0) {
                throw new IllegalArgumentException(String.format("The medium type is not %d", 0));
            }
            byte b2 = (byte) byteArrayInputStream.read();
            if ((b2 & 64) == 64) {
                byte[] bArr2 = new byte[6];
                if (byteArrayInputStream.read(bArr2, 0, 6) != 6) {
                    throw new IllegalArgumentException("Failed to read MAC address.");
                }
                zziVar.zza(bArr2);
            }
            if ((b2 & StylePropertiesKt.ZIndexId) == 32) {
                byte[] bArr3 = new byte[4];
                if (byteArrayInputStream.read(bArr3, 0, 4) != 4) {
                    throw new IllegalArgumentException("Failed to read UUID.");
                }
                zziVar.zzb(bArr3);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Log.i("NearbyConnections", "Reading actions");
            while (true) {
                int i = byteArrayInputStream.read();
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write((byte) i);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            int length = byteArray.length;
            Log.i("NearbyConnections", String.format("Read %d action(s)", Integer.valueOf(length)));
            Log.i("NearbyConnections", String.format("Actions: %s", zzl.zza(byteArray)));
            if (byteArray != null && length > 0) {
                zziVar.zzc(byteArray);
            }
            return zziVar.zzd();
        }
        if (b == 1) {
            Parcelable.Creator<zzg> creator2 = zzg.CREATOR;
            zzf zzfVar = new zzf();
            if (zzr.zzc(bArr, 0) <= 0) {
                throw new IllegalArgumentException("The length is 0");
            }
            if (zzr.zzd(bArr, 0) != 20) {
                throw new IllegalArgumentException(String.format("The field type is not %d", 20));
            }
            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
            int iZza2 = zzr.zza(bArr, 0);
            if (byteArrayInputStream2.read(new byte[iZza2], 0, iZza2) != iZza2) {
                throw new IllegalArgumentException("Failed to read header.");
            }
            if (byteArrayInputStream2.read() != 1) {
                throw new IllegalArgumentException(String.format("The medium type is not %d", 1));
            }
            byte b3 = (byte) byteArrayInputStream2.read();
            if ((b3 & 64) == 64) {
                byte[] bArr4 = new byte[6];
                if (byteArrayInputStream2.read(bArr4, 0, 6) != 6) {
                    throw new IllegalArgumentException("Failed to read MAC address.");
                }
                zzfVar.zza(bArr4);
            }
            if ((b3 & StylePropertiesKt.ZIndexId) == 32) {
                int i2 = (byte) byteArrayInputStream2.read();
                byte[] bArr5 = new byte[i2];
                if (byteArrayInputStream2.read(bArr5, 0, i2) != i2) {
                    throw new IllegalArgumentException("Failed to read GATT characteristic.");
                }
                zzfVar.zzd(bArr5);
            }
            if ((b3 & StylePropertiesKt.BottomId) == 16) {
                byte[] bArr6 = new byte[2];
                if (byteArrayInputStream2.read(bArr6, 0, 2) != 2) {
                    throw new IllegalArgumentException("Failed to read PSM value.");
                }
                zzfVar.zzb(bArr6);
            }
            if ((b3 & 8) == 8) {
                byte[] bArr7 = new byte[2];
                if (byteArrayInputStream2.read(bArr7, 0, 2) != 2) {
                    throw new IllegalArgumentException("Failed to read device token.");
                }
                zzfVar.zzc(bArr7);
            }
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (true) {
                int i3 = byteArrayInputStream2.read();
                if (i3 == -1) {
                    break;
                }
                byteArrayOutputStream2.write((byte) i3);
            }
            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
            if (byteArray2 != null && byteArray2.length > 0) {
                zzfVar.zze(byteArray2);
            }
            return zzfVar.zzf();
        }
        if (b != 2 && b != 3) {
            if (b == 5) {
                zzal zzalVarZzb = zzac.zzb(bArr);
                if (zzalVarZzb == null) {
                    return null;
                }
                return new zzac(zzalVarZzb.zza(), zzalVarZzb.zzb(), zzalVarZzb.zzc(), zzalVarZzb.zzd());
            }
            if (b == 4) {
                zzal zzalVarZzb2 = zzad.zzb(bArr);
                if (zzalVarZzb2 == null) {
                    return null;
                }
                return new zzad(zzalVarZzb2.zza(), zzalVarZzb2.zzb(), zzalVarZzb2.zzc(), zzalVarZzb2.zzd());
            }
            if (b != 6) {
                Log.i("NC_ConnInfo", String.format("Failed to parse ConnectivityInfo due to wrong medium type: %X.", Byte.valueOf(b)));
                return null;
            }
            if (zzr.zzc(bArr, 0) != 15) {
                zzau.zza.zza().zzb("%s Incorrect size for WiFi Aware Connectivity Info.", "[NC_WifiAwareConnInfo]");
                return null;
            }
            if (zzr.zzd(bArr, 0) != 20) {
                zzau.zza.zza().zzc("%s %s", "[NC_WifiAwareConnInfo]", String.format("Failed to parse connectivity info due to incorrect data element type: %X.", Integer.valueOf(zzr.zzd(bArr, 0))));
                return null;
            }
            int iZza3 = zzr.zza(bArr, 0);
            Preconditions.checkArgument(bArr[iZza3] == 6);
            int i4 = iZza3 + 5;
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, iZza3 + 1, i4);
            if (bArrCopyOfRange.length != 4) {
                zzau.zza.zza().zzb("%s Failed to read service info.", "[NC_WifiAwareConnInfo]");
                return null;
            }
            int i5 = iZza3 + 13;
            byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, i4, i5);
            if (bArrCopyOfRange2.length != 8) {
                zzau.zza.zza().zzb("%s Failed to read password.", "[NC_WifiAwareConnInfo]");
                return null;
            }
            byte[] bArrCopyOfRange3 = Arrays.copyOfRange(bArr, i5, iZza3 + 15);
            if (bArrCopyOfRange3.length == 2) {
                return new zzab(bArrCopyOfRange, bArrCopyOfRange2, zzl.zzb(bArrCopyOfRange3));
            }
            zzau.zza.zza().zzb("%s Failed to read port.", "[NC_WifiAwareConnInfo]");
            return null;
        }
        if (!zzame.zzb()) {
            Parcelable.Creator<zzaf> creator3 = zzaf.CREATOR;
            zzae zzaeVar = new zzae();
            if (zzr.zzc(bArr, 0) <= 0) {
                throw new IllegalArgumentException("The length is 0");
            }
            if (zzr.zzd(bArr, 0) != 20) {
                throw new IllegalArgumentException(String.format("The field type is not %d", 20));
            }
            ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr);
            int iZza4 = zzr.zza(bArr, 0);
            if (byteArrayInputStream3.read(new byte[iZza4], 0, iZza4) != iZza4) {
                throw new IllegalArgumentException("Failed to read header.");
            }
            if (((byte) byteArrayInputStream3.read()) != 2) {
                throw new IllegalArgumentException(String.format("The medium type is not %d", 2));
            }
            byte b4 = (byte) byteArrayInputStream3.read();
            if ((b4 & 64) == 64) {
                byte[] bArr8 = new byte[4];
                if (byteArrayInputStream3.read(bArr8, 0, 4) != 4) {
                    throw new IllegalArgumentException("Failed to read the IP address.");
                }
                zzaeVar.zzb(bArr8);
            }
            if ((b4 & StylePropertiesKt.ZIndexId) == 32) {
                byte[] bArr9 = new byte[16];
                if (byteArrayInputStream3.read(bArr9, 0, 16) != 16) {
                    throw new IllegalArgumentException("Failed to read the IP address.");
                }
                zzaeVar.zzb(bArr9);
            }
            if ((b4 & StylePropertiesKt.BottomId) == 16) {
                byte[] bArr10 = new byte[2];
                if (byteArrayInputStream3.read(bArr10, 0, 2) != 2) {
                    throw new IllegalArgumentException("Failed to read the port.");
                }
                zzaeVar.zza(bArr10);
            }
            if ((b4 & 8) == 8) {
                byte[] bArr11 = new byte[6];
                if (byteArrayInputStream3.read(bArr11, 0, 6) != 6) {
                    throw new IllegalArgumentException("Failed to read the BSSID.");
                }
                zzaeVar.zzc(bArr11);
            }
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            while (true) {
                int i6 = byteArrayInputStream3.read();
                if (i6 == -1) {
                    break;
                }
                byteArrayOutputStream3.write((byte) i6);
            }
            byte[] byteArray3 = byteArrayOutputStream3.toByteArray();
            if (byteArray3 != null && byteArray3.length > 0) {
                zzaeVar.zzd(byteArray3);
            }
            return zzaeVar.zze();
        }
        Parcelable.Creator<zzai> creator4 = zzai.CREATOR;
        zzah zzahVar = new zzah();
        if (zzr.zzc(bArr, 0) <= 0) {
            throw new IllegalArgumentException("The length is 0");
        }
        if (zzr.zzd(bArr, 0) != 20) {
            throw new IllegalArgumentException(String.format("The field type is not %d", 20));
        }
        ByteArrayInputStream byteArrayInputStream4 = new ByteArrayInputStream(bArr);
        int iZza5 = zzr.zza(bArr, 0);
        if (byteArrayInputStream4.read(new byte[iZza5], 0, iZza5) != iZza5) {
            throw new IllegalArgumentException("Failed to read header.");
        }
        byte b5 = (byte) byteArrayInputStream4.read();
        if (b5 == 2) {
            byte[] bArr12 = new byte[4];
            if (byteArrayInputStream4.read(bArr12, 0, 4) != 4) {
                throw new IllegalArgumentException("Failed to read the IPV4 address.");
            }
            zzahVar.zzb(bArr12);
        } else {
            if (b5 != 3) {
                throw new IllegalArgumentException("The medium type is not WIFI_LAN_IPV4 or WIFI_LAN_IPV6");
            }
            byte[] bArr13 = new byte[16];
            if (byteArrayInputStream4.read(bArr13, 0, 16) != 16) {
                throw new IllegalArgumentException("Failed to read the IPV6 address.");
            }
            zzahVar.zzb(bArr13);
        }
        byte[] bArr14 = new byte[2];
        if (byteArrayInputStream4.read(bArr14, 0, 2) != 2) {
            throw new IllegalArgumentException("Failed to read the port.");
        }
        zzahVar.zza(bArr14);
        byte[] bArr15 = new byte[6];
        if (byteArrayInputStream4.read(bArr15, 0, 6) != 6) {
            throw new IllegalArgumentException("Failed to read the BSSID.");
        }
        Object[] array = zzai.zza.toArray();
        int length2 = array.length;
        byte[] bArr16 = new byte[length2];
        for (int i7 = 0; i7 < length2; i7++) {
            Object obj = array[i7];
            obj.getClass();
            bArr16[i7] = ((Number) obj).byteValue();
        }
        if (!Arrays.equals(bArr15, bArr16)) {
            zzahVar.zzc(bArr15);
        }
        ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
        while (true) {
            int i8 = byteArrayInputStream4.read();
            if (i8 == -1) {
                break;
            }
            byteArrayOutputStream4.write((byte) i8);
        }
        byte[] byteArray4 = byteArrayOutputStream4.toByteArray();
        if (byteArray4 != null && byteArray4.length > 0) {
            zzahVar.zzd(byteArray4);
        }
        return zzahVar.zze();
    }
}
