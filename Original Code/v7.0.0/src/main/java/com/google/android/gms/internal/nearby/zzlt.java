package com.google.android.gms.internal.nearby;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzlt implements Closeable {
    private final Inflater zza = new Inflater(true);

    private zzlt() {
    }

    public static zzlt zza() {
        return new zzlt();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.zza.end();
    }

    public final Object zzb(byte[] bArr, zzls zzlsVar) throws IOException {
        this.zza.setInput(bArr);
        try {
            return zzlw.zzd(zzaio.zzL(new zzlq(this), 4096), null, null);
        } finally {
            this.zza.reset();
        }
    }

    public final Object zzc(zzaio zzaioVar, zzls zzlsVar) throws IOException {
        try {
            return zzlw.zzd(zzaio.zzL(new InflaterInputStream(new zzlr(this, zzaioVar), this.zza, 4096), 4096), null, null);
        } finally {
            this.zza.reset();
        }
    }

    final /* synthetic */ Inflater zzd() {
        return this.zza;
    }
}
