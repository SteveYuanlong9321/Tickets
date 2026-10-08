package com.google.android.gms.internal.nearby;

import java.util.Objects;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzahj implements Runnable {
    Runnable zza;
    final /* synthetic */ zzahk zzb;

    /* synthetic */ zzahj(zzahk zzahkVar, byte[] bArr) {
        Objects.requireNonNull(zzahkVar);
        this.zzb = zzahkVar;
    }

    public final String toString() {
        String str;
        Runnable runnable = this.zza;
        if (runnable != null) {
            String string = runnable.toString();
            StringBuilder sb = new StringBuilder(string.length() + 34);
            sb.append("SequentialExecutorWorker{running=");
            sb.append(string);
            sb.append("}");
            return sb.toString();
        }
        int iZze = this.zzb.zze();
        if (iZze == 1) {
            str = "IDLE";
        } else if (iZze == 2) {
            str = "QUEUING";
        } else if (iZze != 3) {
            str = iZze != 4 ? "null" : DebugCoroutineInfoImplKt.RUNNING;
        } else {
            str = "QUEUED";
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 32);
        sb2.append("SequentialExecutorWorker{state=");
        sb2.append(str);
        sb2.append("}");
        return sb2.toString();
    }

    /* JADX WARN: Code duplicated, block: B:61:0x003b A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        if (r3 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        r3 = r3 | java.lang.Thread.interrupted();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
    
        r12.zza.run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:
    
        r12.zza = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0059, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005b, code lost:
    
        r5 = com.google.android.gms.internal.nearby.zzahk.zza.zza();
        r6 = java.util.logging.Level.SEVERE;
        r0 = java.lang.String.valueOf(r12.zza);
        r11 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 35);
        r11.append("Exception while executing runnable ");
        r11.append(r0);
        r5.logp(r6, "com.google.common.util.concurrent.SequentialExecutor$QueueWorker", "workOnQueue", r11.toString(), (java.lang.Throwable) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008b, code lost:
    
        r12.zza = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008e, code lost:
    
        r12.zza = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0090, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Runnable runnable;
        boolean z = false;
        boolean zInterrupted = false;
        while (true) {
            try {
                try {
                    zzahk zzahkVar = this.zzb;
                    synchronized (zzahkVar.zzb()) {
                        if (z) {
                            runnable = (Runnable) zzahkVar.zzb().poll();
                            this.zza = runnable;
                            if (runnable == null) {
                                this.zzb.zzf(1);
                            }
                        } else if (zzahkVar.zze() != 4) {
                            zzahkVar.zzd(zzahkVar.zzc() + 1);
                            zzahkVar.zzf(4);
                            runnable = (Runnable) zzahkVar.zzb().poll();
                            this.zza = runnable;
                            if (runnable == null) {
                                this.zzb.zzf(1);
                            }
                        }
                    }
                    if (zInterrupted) {
                        break;
                    } else {
                        return;
                    }
                    z = true;
                } catch (Throwable th) {
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (Error e) {
                zzahk zzahkVar2 = this.zzb;
                synchronized (zzahkVar2.zzb()) {
                    zzahkVar2.zzf(1);
                    throw e;
                }
            }
        }
        Thread.currentThread().interrupt();
    }
}
