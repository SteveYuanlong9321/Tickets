package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.DataFormatException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzlq extends InputStream {
    final /* synthetic */ zzlt zza;

    zzlq(zzlt zzltVar) {
        Objects.requireNonNull(zzltVar);
        this.zza = zzltVar;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr, 0, 1) == -1) {
            return -1;
        }
        return bArr[0];
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            zzlt zzltVar = this.zza;
            int iInflate = zzltVar.zzd().inflate(bArr, i, i2);
            if (iInflate > 0) {
                return iInflate;
            }
            if (i2 == 0) {
                return 0;
            }
            if (zzltVar.zzd().getRemaining() == 0) {
                return -1;
            }
            int remaining = this.zza.zzd().getRemaining();
            StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 70 + String.valueOf(remaining).length());
            sb.append("Read no bytes (requested up to ");
            sb.append(i2);
            sb.append(") but did not reach end of stream, had ");
            sb.append(remaining);
            throw new IOException(sb.toString());
        } catch (DataFormatException e) {
            throw new IOException(e);
        }
    }
}
