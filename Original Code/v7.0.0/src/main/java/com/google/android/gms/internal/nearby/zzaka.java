package com.google.android.gms.internal.nearby;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaka {
    public static final byte[] zza;

    static {
        byte[] bArr = new byte[0];
        zza = bArr;
        ByteBuffer.wrap(bArr);
        zzaio.zzM(bArr, 0, 0, false);
    }

    public static int zza() {
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static int zzb(boolean z) {
        return z ? 1231 : 1237;
    }

    static int zzc(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }
}
