package com.google.android.gms.internal.nearby;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzqj extends zzrh {
    private final List zza;

    private zzqj(InputStream inputStream, List list) {
        super(inputStream);
        this.zza = list;
    }

    @Nullable
    public static zzqj zza(List list, Uri uri, InputStream inputStream) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzrq zzrqVarZza = ((zzrs) it.next()).zza();
            if (zzrqVarZza != null) {
                arrayList.add(zzrqVarZza);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzqj(inputStream, arrayList);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            try {
                ((zzrq) it.next()).close();
            } catch (Throwable unused) {
            }
        }
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i = this.in.read();
        if (i != -1) {
            Iterator it = this.zza.iterator();
            while (it.hasNext()) {
                ((zzrq) it.next()).zza();
            }
        }
        return i;
    }

    @Override // com.google.android.gms.internal.nearby.zzrh, java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        int i = this.in.read(bArr);
        if (i != -1) {
            Iterator it = this.zza.iterator();
            while (it.hasNext()) {
                ((zzrq) it.next()).zza();
            }
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.in.read(bArr, i, i2);
        if (i3 != -1) {
            Iterator it = this.zza.iterator();
            while (it.hasNext()) {
                ((zzrq) it.next()).zza();
            }
        }
        return i3;
    }
}
