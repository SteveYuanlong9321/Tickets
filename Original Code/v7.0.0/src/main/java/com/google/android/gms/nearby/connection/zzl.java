package com.google.android.gms.nearby.connection;

import androidx.compose.foundation.style.StylePropertiesKt;
import com.google.android.gms.common.internal.Preconditions;
import java.nio.charset.StandardCharsets;
import kotlin.UByte;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzl {
    static final byte[] zza = "0123456789ABCDEF".getBytes(StandardCharsets.US_ASCII);
    public static final /* synthetic */ int zzb = 0;

    public static String zza(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) == 0) {
            return null;
        }
        byte[] bArr2 = new byte[length * 5];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = b & UByte.MAX_VALUE;
            int i3 = i * 5;
            bArr2[i3] = StylePropertiesKt.LetterSpacingId;
            bArr2[i3 + 1] = 120;
            byte[] bArr3 = zza;
            bArr2[i3 + 2] = bArr3[i2 >>> 4];
            bArr2[i3 + 3] = bArr3[b & StylePropertiesKt.RightId];
            bArr2[i3 + 4] = StylePropertiesKt.ZIndexId;
        }
        String str = new String(bArr2, StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder(str.length() + 3);
        sb.append("[ ");
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }

    public static int zzb(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 2);
        return (bArr[1] & UByte.MAX_VALUE) | ((bArr[0] & UByte.MAX_VALUE) << 8);
    }
}
