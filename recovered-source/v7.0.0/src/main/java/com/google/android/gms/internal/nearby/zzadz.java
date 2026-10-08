package com.google.android.gms.internal.nearby;

import java.io.Closeable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzadz implements Closeable {
    private static final ThreadLocal zza = new zzady();
    private int zzb = 0;

    public static int zza() {
        return zzd().zzb;
    }

    public static zzadz zzc() {
        zzadz zzadzVarZzd = zzd();
        int i = zzadzVarZzd.zzb + 1;
        zzadzVarZzd.zzb = i;
        if (i != 0) {
            return zzadzVarZzd;
        }
        throw new AssertionError("Overflow of RecursionDepth (possible error in core library)");
    }

    private static zzadz zzd() {
        return (zzadz) zza.get();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i = this.zzb;
        if (i <= 0) {
            throw new AssertionError("Mismatched calls to RecursionDepth (possible error in core library)");
        }
        this.zzb = i - 1;
    }

    public final int zzb() {
        return this.zzb;
    }
}
