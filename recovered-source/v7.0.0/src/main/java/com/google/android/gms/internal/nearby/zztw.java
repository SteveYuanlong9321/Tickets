package com.google.android.gms.internal.nearby;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zztw implements Runnable {
    private zzafp zza;
    private Executor zzb;

    zztw(zzafp zzafpVar, Executor executor) {
        this.zza = zzafpVar;
        this.zzb = executor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza = null;
        this.zzb = null;
    }

    final /* synthetic */ zzafp zza() {
        return this.zza;
    }

    final /* synthetic */ Executor zzb() {
        return this.zzb;
    }
}
