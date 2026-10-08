package com.google.android.gms.internal.nearby;

import androidx.compose.foundation.style.StylePropertiesKt;
import okio.Utf8;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalu {
    static /* synthetic */ boolean zza(byte b) {
        return b >= 0;
    }

    static /* synthetic */ void zzb(byte b, byte b2, char[] cArr, int i) throws zzakf {
        if (b < -62 || zze(b2)) {
            throw new zzakf("Protocol message had invalid UTF-8.");
        }
        cArr[i] = (char) (((b & StylePropertiesKt.ClipId) << 6) | (b2 & Utf8.REPLACEMENT_BYTE));
    }

    static /* synthetic */ void zzd(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws zzakf {
        if (zze(b2) || (((b << StylePropertiesKt.RotationZId) + (b2 + 112)) >> 30) != 0 || zze(b3) || zze(b4)) {
            throw new zzakf("Protocol message had invalid UTF-8.");
        }
        int i2 = ((b & 7) << 18) | ((b2 & Utf8.REPLACEMENT_BYTE) << 12) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
        cArr[i] = (char) ((i2 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i + 1] = (char) ((i2 & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }

    private static boolean zze(byte b) {
        return b > -65;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0013 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:11:0x0015  */
    /* JADX WARN: Code duplicated, block: B:12:0x0016 A[PHI: r2
      0x0016: PHI (r2v3 byte) = (r2v2 byte), (r2v9 byte) binds: [B:9:0x0011, B:11:0x0015] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:14:0x001c  */
    static /* synthetic */ void zzc(byte b, byte b2, byte b3, char[] cArr, int i) throws zzakf {
        if (!zze(b2)) {
            if (b != -32) {
                if (b != -19) {
                    if (!zze(b3)) {
                        cArr[i] = (char) (((b & StylePropertiesKt.RightId) << 12) | ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
                        return;
                    }
                } else if (b2 < -96) {
                    b = -19;
                    if (!zze(b3)) {
                        cArr[i] = (char) (((b & StylePropertiesKt.RightId) << 12) | ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
                        return;
                    }
                }
            } else if (b2 >= -96) {
                b = -32;
                if (b != -19) {
                    if (!zze(b3)) {
                        cArr[i] = (char) (((b & StylePropertiesKt.RightId) << 12) | ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
                        return;
                    }
                } else if (b2 < -96) {
                    b = -19;
                    if (!zze(b3)) {
                        cArr[i] = (char) (((b & StylePropertiesKt.RightId) << 12) | ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
                        return;
                    }
                }
            }
        }
        throw new zzakf("Protocol message had invalid UTF-8.");
    }
}
