package com.google.android.gms.internal.nearby;

import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzagk implements Runnable {
    zzagx zza;
    Future zzb;

    zzagk(zzagx zzagxVar, Future future) {
        this.zza = zzagxVar;
        this.zzb = future;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzagn.zzq(this.zza, this.zzb);
        this.zza = null;
        this.zzb = null;
    }
}
