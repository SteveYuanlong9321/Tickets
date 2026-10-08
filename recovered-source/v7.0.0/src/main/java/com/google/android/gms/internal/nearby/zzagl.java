package com.google.android.gms.internal.nearby;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzagl {
    private final boolean zza;
    private final zzyg zzb;

    /* synthetic */ zzagl(boolean z, zzyg zzygVar, byte[] bArr) {
        this.zza = z;
        this.zzb = zzygVar;
    }

    public final zzagx zza(zzafp zzafpVar, Executor executor) {
        return new zzafw(this.zzb, this.zza, executor, zzafpVar);
    }

    public final zzagx zzb(Callable callable, Executor executor) {
        return new zzafw(this.zzb, this.zza, executor, callable);
    }
}
