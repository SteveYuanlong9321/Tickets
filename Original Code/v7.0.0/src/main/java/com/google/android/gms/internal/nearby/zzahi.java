package com.google.android.gms.internal.nearby;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzahi implements Runnable {
    final /* synthetic */ Runnable zza;

    zzahi(zzahk zzahkVar, Runnable runnable) {
        this.zza = runnable;
        Objects.requireNonNull(zzahkVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.run();
    }

    public final String toString() {
        return this.zza.toString();
    }
}
