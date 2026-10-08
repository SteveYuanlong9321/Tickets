package com.google.android.gms.internal.nearby;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzagb extends AtomicReference implements Executor, Runnable {
    zzagd zza;
    Executor zzb;
    Runnable zzc;
    Thread zzd;

    /* synthetic */ zzagb(Executor executor, zzagd zzagdVar, byte[] bArr) {
        super(zzaga.NOT_RUN);
        this.zzb = executor;
        this.zza = zzagdVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (get() == zzaga.CANCELLED) {
            this.zzb = null;
            this.zza = null;
            return;
        }
        this.zzd = Thread.currentThread();
        try {
            zzagc zzagcVarZzc = ((zzagd) Objects.requireNonNull(this.zza)).zzc();
            if (zzagcVarZzc.zza == this.zzd) {
                this.zza = null;
                zzxd.zze(zzagcVarZzc.zzb == null);
                zzagcVarZzc.zzb = runnable;
                zzagcVarZzc.zzc = (Executor) Objects.requireNonNull(this.zzb);
                this.zzb = null;
            } else {
                Executor executor = (Executor) Objects.requireNonNull(this.zzb);
                this.zzb = null;
                this.zzc = runnable;
                executor.execute(this);
            }
        } finally {
            this.zzd = null;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Executor executor;
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread != this.zzd) {
            Runnable runnable = (Runnable) Objects.requireNonNull(this.zzc);
            this.zzc = null;
            runnable.run();
            return;
        }
        zzagc zzagcVar = new zzagc(null);
        zzagcVar.zza = threadCurrentThread;
        ((zzagd) Objects.requireNonNull(this.zza)).zzd(zzagcVar);
        this.zza = null;
        try {
            Runnable runnable2 = (Runnable) Objects.requireNonNull(this.zzc);
            this.zzc = null;
            runnable2.run();
            while (true) {
                Runnable runnable3 = zzagcVar.zzb;
                if (runnable3 == null || (executor = zzagcVar.zzc) == null) {
                    break;
                }
                zzagcVar.zzb = null;
                zzagcVar.zzc = null;
                executor.execute(runnable3);
            }
            zzagcVar.zza = null;
        } catch (Throwable th) {
            zzagcVar.zza = null;
            throw th;
        }
    }
}
