package com.google.android.gms.internal.nearby;

import java.io.Closeable;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrd implements Closeable {

    @Nullable
    private final Closeable zza;

    private zzrd(Closeable closeable) {
        this.zza = closeable;
    }

    public static zzrd zza(Closeable closeable) {
        return new zzrd(closeable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Closeable closeable = this.zza;
        if (closeable != null) {
            closeable.close();
        }
    }

    @Nullable
    public final Closeable zzb() {
        return this.zza;
    }
}
