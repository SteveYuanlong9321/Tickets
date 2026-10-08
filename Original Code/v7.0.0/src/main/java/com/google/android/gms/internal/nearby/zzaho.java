package com.google.android.gms.internal.nearby;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaho extends zzage implements RunnableFuture {
    private volatile zzagv zza;

    zzaho(zzafp zzafpVar) {
        this.zza = new zzahm(this, zzafpVar);
    }

    static zzaho zzf(Runnable runnable, Object obj) {
        return new zzaho(Executors.callable(runnable, obj));
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzagv zzagvVar = this.zza;
        if (zzagvVar != null) {
            zzagvVar.run();
        }
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.nearby.zzafb
    protected final void zzc() {
        zzagv zzagvVar;
        if (zzk() && (zzagvVar = this.zza) != null) {
            zzagvVar.zzh();
        }
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.nearby.zzafb
    protected final String zzd() {
        zzagv zzagvVar = this.zza;
        if (zzagvVar == null) {
            return super.zzd();
        }
        String string = zzagvVar.toString();
        StringBuilder sb = new StringBuilder(string.length() + 7);
        sb.append("task=[");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }

    zzaho(Callable callable) {
        this.zza = new zzahn(this, callable);
    }
}
