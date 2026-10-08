package com.google.android.gms.internal.nearby;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzahk implements Executor {
    private static final zzagw zza = new zzagw(zzahk.class);
    private final Executor zzb;
    private final Deque zzc = new ArrayDeque();
    private int zzf = 1;
    private long zzd = 0;
    private final zzahj zze = new zzahj(this, null);

    zzahk(Executor executor) {
        this.zzb = executor;
    }

    public final String toString() {
        Executor executor = this.zzb;
        int iIdentityHashCode = System.identityHashCode(this);
        String strValueOf = String.valueOf(executor);
        StringBuilder sb = new StringBuilder(String.valueOf(iIdentityHashCode).length() + 20 + String.valueOf(strValueOf).length() + 1);
        sb.append("SequentialExecutor@");
        sb.append(iIdentityHashCode);
        sb.append("{");
        sb.append(strValueOf);
        sb.append("}");
        return sb.toString();
    }

    final /* synthetic */ Deque zzb() {
        return this.zzc;
    }

    final /* synthetic */ long zzc() {
        return this.zzd;
    }

    final /* synthetic */ void zzd(long j) {
        this.zzd = j;
    }

    final /* synthetic */ int zze() {
        return this.zzf;
    }

    final /* synthetic */ void zzf(int i) {
        this.zzf = i;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.getClass();
        Deque deque = this.zzc;
        synchronized (deque) {
            int i = this.zzf;
            if (i != 4 && i != 3) {
                long j = this.zzd;
                zzahi zzahiVar = new zzahi(this, runnable);
                deque.add(zzahiVar);
                this.zzf = 2;
                try {
                    this.zzb.execute(this.zze);
                    if (this.zzf != 2) {
                        return;
                    }
                    synchronized (this.zzc) {
                        if (this.zzd == j && this.zzf == 2) {
                            this.zzf = 3;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    Deque deque2 = this.zzc;
                    synchronized (deque2) {
                        int i2 = this.zzf;
                        boolean z = false;
                        if ((i2 == 1 || i2 == 2) && deque2.removeLastOccurrence(zzahiVar)) {
                            z = true;
                        }
                        if (!(th instanceof RejectedExecutionException) || z) {
                            throw th;
                        }
                        return;
                    }
                }
            }
            deque.add(runnable);
        }
    }
}
