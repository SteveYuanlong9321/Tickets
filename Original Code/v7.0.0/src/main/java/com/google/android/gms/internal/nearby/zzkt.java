package com.google.android.gms.internal.nearby;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzkt implements ThreadFactory {
    static final /* synthetic */ zzkt zza = new zzkt();

    private /* synthetic */ zzkt() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final /* synthetic */ Thread newThread(Runnable runnable) {
        int i = zzkp.zza;
        return new Thread(runnable, "ProcessStablePhenotypeFlag");
    }
}
