package com.google.android.gms.internal.nearby;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzvq implements Runnable {
    final /* synthetic */ Ref.ObjectRef zza;
    final /* synthetic */ zzvj zzb;
    final /* synthetic */ Runnable zzc;

    zzvq(Ref.ObjectRef objectRef, zzvj zzvjVar, Runnable runnable) {
        this.zza = objectRef;
        this.zzb = zzvjVar;
        this.zzc = runnable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        if (((zzvt) this.zza.element) != null) {
            throw null;
        }
        zzvj zzvjVar = this.zzb;
        Intrinsics.checkNotNull(zzvjVar, "null cannot be cast to non-null type com.google.apps.tiktok.tracing.Trace");
        Runnable runnable = this.zzc;
        zzvh zzvhVarZzd = zzup.zzd();
        zzvj zzvjVarZzc = zzup.zzc(zzvhVarZzd, zzvjVar);
        try {
            runnable.run();
            Unit unit = Unit.INSTANCE;
            zzup.zzc(zzvhVarZzd, zzvjVarZzc);
        } catch (Throwable th) {
            try {
                zzul.zza(th);
                throw th;
            } catch (Throwable th2) {
                zzup.zzc(zzvhVarZzd, zzvjVarZzc);
                throw th2;
            }
        }
    }

    public final String toString() {
        Runnable runnable = this.zzc;
        StringBuilder sb = new StringBuilder(runnable.toString().length() + 14);
        sb.append("propagating=[");
        sb.append(runnable);
        sb.append("]");
        return sb.toString();
    }
}
