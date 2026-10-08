package com.google.android.gms.nearby.connection;

import androidx.compose.foundation.style.StylePropertiesKt;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzr {
    public static int zza(byte[] bArr, int i) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(bArr.length > 0);
        int i2 = 0;
        for (byte b : bArr) {
            i2++;
            if ((b & ByteCompanionObject.MIN_VALUE) == 0) {
                return i2;
            }
        }
        return i2;
    }

    public static byte[] zzb(byte[] bArr, int i) {
        Preconditions.checkArgument(true);
        return Arrays.copyOfRange(bArr, 0, zza(bArr, 0));
    }

    public static int zzc(byte[] bArr, int i) {
        byte[] bArrZzb = zzb(bArr, 0);
        return bArrZzb.length == 1 ? (bArrZzb[0] & 112) >> 4 : bArrZzb[0] & ByteCompanionObject.MAX_VALUE;
    }

    protected static int zzd(byte[] bArr, int i) {
        int i2 = 0;
        byte[] bArrZzb = zzb(bArr, 0);
        if (bArrZzb.length == 1) {
            return bArrZzb[0] & StylePropertiesKt.RightId;
        }
        for (int i3 = 1; i3 < bArrZzb.length; i3++) {
            i2 = (i2 << 7) | (bArrZzb[i3] & ByteCompanionObject.MAX_VALUE);
        }
        return i2;
    }
}
