package com.google.android.gms.internal.nearby;

import androidx.collection.SieveCacheKt;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzlr extends InputStream {
    final /* synthetic */ zzaio zza;

    zzlr(zzlt zzltVar, zzaio zzaioVar) {
        this.zza = zzaioVar;
        Objects.requireNonNull(zzltVar);
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        byte[] bArr = new byte[1];
        if (this.zza.zzJ(bArr, 0, 1) == -1) {
            return -1;
        }
        return bArr[0];
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws IOException {
        if (j <= 0) {
            return 0L;
        }
        int i = j > SieveCacheKt.NodeLinkMask ? Integer.MAX_VALUE : (int) j;
        this.zza.zzK(i);
        return i;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return this.zza.zzJ(bArr, i, i2);
    }
}
