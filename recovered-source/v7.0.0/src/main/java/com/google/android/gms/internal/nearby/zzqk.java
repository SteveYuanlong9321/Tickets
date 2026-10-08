package com.google.android.gms.internal.nearby;

import android.net.Uri;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzqk extends zzri {
    private final List zza;

    private zzqk(OutputStream outputStream, List list) {
        super(outputStream);
        this.zza = list;
    }

    @Nullable
    public static zzqk zza(List list, Uri uri, OutputStream outputStream) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzrr zzrrVarZzb = ((zzrs) it.next()).zzb();
            if (zzrrVarZzb != null) {
                arrayList.add(zzrrVarZzb);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzqk(outputStream, arrayList);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            try {
                ((zzrr) it.next()).close();
            } catch (Throwable unused) {
            }
        }
        super.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) throws IOException {
        this.out.write(i);
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzrr) it.next()).zza();
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzri, java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
        for (zzrr zzrrVar : this.zza) {
            int length = bArr.length;
            zzrrVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzri, java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzrr) it.next()).zza();
        }
    }
}
