package com.google.android.gms.nearby.messages.internal;

import androidx.compose.foundation.style.StylePropertiesKt;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class zzc {
    private static final char[] zza = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private final byte[] zzb;

    protected zzc(byte[] bArr) {
        this.zzb = bArr;
    }

    public static String zza(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b : bArr) {
            char[] cArr = zza;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & StylePropertiesKt.RightId]);
        }
        return sb.toString();
    }

    public static byte[] zzb(String str) {
        int length = str.length() >> 1;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i + i;
            bArr[i] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass().isAssignableFrom(getClass())) {
            return Arrays.equals(this.zzb, ((zzc) obj).zzb);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzb);
    }

    public String toString() {
        return zza(this.zzb);
    }

    public final byte[] zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return zza(this.zzb);
    }
}
