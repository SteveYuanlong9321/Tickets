package com.google.android.gms.internal.nearby;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzok {
    private final AtomicInteger zza = new AtomicInteger();

    public final int zza() {
        return this.zza.get();
    }

    public final void zzb() {
        this.zza.incrementAndGet();
    }
}
