package com.google.android.gms.internal.nearby;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzagj extends zzagh implements zzagx {
    protected zzagj() {
    }

    @Override // com.google.android.gms.internal.nearby.zzagh
    protected /* bridge */ /* synthetic */ Future zzb() {
        throw null;
    }

    protected abstract zzagx zzc();

    @Override // com.google.android.gms.internal.nearby.zzagx
    public final void zzl(Runnable runnable, Executor executor) {
        zzc().zzl(runnable, executor);
    }
}
