package com.google.android.gms.internal.nearby;

import android.os.ParcelUuid;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.util.Hex;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.UByte;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaz {
    private static final ParcelUuid zza = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    private final int zzb;
    private final List zzc;
    private final SparseArray zzd;
    private final Map zze;
    private final int zzf;
    private final String zzg;
    private final byte[] zzh;

    private zzaz(List list, SparseArray sparseArray, Map map, int i, int i2, String str, byte[] bArr) {
        this.zzc = list;
        this.zzd = sparseArray;
        this.zze = map;
        this.zzg = str;
        this.zzb = i;
        this.zzf = i2;
        this.zzh = bArr;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0091  */
    /* JADX WARN: Code duplicated, block: B:28:0x0093  */
    public static zzaz zza(byte[] bArr) {
        byte[] bArr2;
        ArrayList arrayList;
        if (bArr == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        HashMap map = new HashMap();
        int i = -1;
        int i2 = 0;
        String str = null;
        byte b = -2147483648;
        try {
            while (i2 < bArr.length) {
                try {
                    int i3 = i2 + 1;
                    int i4 = bArr[i2] & UByte.MAX_VALUE;
                    if (i4 == 0) {
                        if (true != arrayList2.isEmpty()) {
                            arrayList = arrayList2;
                        } else {
                            arrayList = null;
                        }
                        bArr2 = bArr;
                        return new zzaz(arrayList, sparseArray, map, i, b, str, bArr2);
                    }
                    int i5 = i4 - 1;
                    int i6 = i2 + 2;
                    int i7 = bArr[i3] & UByte.MAX_VALUE;
                    if (i7 == 22) {
                        map.put(zzd(zzc(bArr, i6, 2)), zzc(bArr, i2 + 4, i4 - 3));
                    } else if (i7 != 255) {
                        switch (i7) {
                            case 1:
                                i = bArr[i6] & UByte.MAX_VALUE;
                                break;
                            case 2:
                            case 3:
                                zzb(bArr, i6, i5, 2, arrayList2);
                                break;
                            case 4:
                            case 5:
                                zzb(bArr, i6, i5, 4, arrayList2);
                                break;
                            case 6:
                            case 7:
                                zzb(bArr, i6, i5, 16, arrayList2);
                                break;
                            case 8:
                            case 9:
                                str = new String(zzc(bArr, i6, i5));
                                break;
                            case 10:
                                b = bArr[i6];
                                break;
                        }
                    } else {
                        sparseArray.put(((bArr[i2 + 3] & UByte.MAX_VALUE) << 8) + (255 & bArr[i6]), zzc(bArr, i2 + 4, i4 - 3));
                    }
                    i2 = i6 + i5;
                } catch (Exception e) {
                    e = e;
                    bArr2 = bArr;
                }
            }
            return new zzaz(arrayList, sparseArray, map, i, b, str, bArr2);
        } catch (Exception e2) {
            e = e2;
            String string = Arrays.toString(bArr2);
            String.valueOf(string);
            Log.w("BleRecord", "Unable to parse scan record: ".concat(String.valueOf(string)), e);
            return null;
        }
        if (true != arrayList2.isEmpty()) {
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        bArr2 = bArr;
    }

    private static int zzb(byte[] bArr, int i, int i2, int i3, List list) {
        while (i2 > 0) {
            list.add(zzd(zzc(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private static byte[] zzc(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    private static ParcelUuid zzd(byte[] bArr) {
        long j;
        int length = bArr.length;
        if (length != 2 && length != 4 && length != 16) {
            StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 27);
            sb.append("uuidBytes length invalid - ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        }
        if (length == 16) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new ParcelUuid(new UUID(byteBufferOrder.getLong(8), byteBufferOrder.getLong(0)));
        }
        if (length == 2) {
            j = ((long) (bArr[0] & UByte.MAX_VALUE)) + ((long) ((bArr[1] & UByte.MAX_VALUE) << 8));
        } else {
            j = ((long) ((bArr[3] & UByte.MAX_VALUE) << 24)) + ((long) (bArr[0] & UByte.MAX_VALUE)) + ((long) ((bArr[1] & UByte.MAX_VALUE) << 8)) + ((long) ((bArr[2] & UByte.MAX_VALUE) << 16));
        }
        ParcelUuid parcelUuid = zza;
        return new ParcelUuid(new UUID(parcelUuid.getUuid().getMostSignificantBits() + (j << 32), parcelUuid.getUuid().getLeastSignificantBits()));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzaz) {
            return Arrays.equals(this.zzh, ((zzaz) obj).zzh);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzh);
    }

    public final String toString() {
        String string;
        String strValueOf = String.valueOf(this.zzc);
        StringBuilder sb = new StringBuilder();
        SparseArray sparseArray = this.zzd;
        String string2 = "{}";
        int i = 0;
        if (sparseArray.size() <= 0) {
            string = "{}";
        } else {
            sb.append('{');
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (i2 > 0) {
                    sb.append(", ");
                }
                int iKeyAt = sparseArray.keyAt(i2);
                byte[] bArr = (byte[]) sparseArray.valueAt(i2);
                sb.append(iKeyAt);
                sb.append('=');
                sb.append(bArr == null ? null : Hex.bytesToStringUppercase(bArr));
            }
            sb.append('}');
            string = sb.toString();
        }
        Map map = this.zze;
        StringBuilder sb2 = new StringBuilder();
        if (!map.keySet().isEmpty()) {
            sb2.append('{');
            for (Map.Entry entry : map.entrySet()) {
                if (i > 0) {
                    sb2.append(", ");
                }
                sb2.append(entry.getKey());
                sb2.append('=');
                byte[] bArr2 = (byte[]) entry.getValue();
                sb2.append(bArr2 == null ? null : Hex.bytesToStringUppercase(bArr2));
                i++;
            }
            sb2.append('}');
            string2 = sb2.toString();
        }
        int i3 = this.zzb;
        int i4 = this.zzf;
        String str = this.zzg;
        StringBuilder sb3 = new StringBuilder(String.valueOf(i3).length() + 43 + String.valueOf(strValueOf).length() + 28 + string.length() + 15 + string2.length() + 16 + String.valueOf(i4).length() + 14 + String.valueOf(str).length() + 1);
        sb3.append("BleRecord [mAdvertiseFlags=");
        sb3.append(i3);
        sb3.append(", mServiceUuids=");
        sb3.append(strValueOf);
        sb3.append(", mManufacturerSpecificData=");
        sb3.append(string);
        sb3.append(", mServiceData=");
        sb3.append(string2);
        sb3.append(", mTxPowerLevel=");
        sb3.append(i4);
        sb3.append(", mDeviceName=");
        sb3.append(str);
        sb3.append("]");
        return sb3.toString();
    }
}
