package com.google.android.gms.internal.nearby;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaau {
    private static final zzaak zza = new zzaat();
    private final AtomicBoolean zzb = new AtomicBoolean();
    private final AtomicInteger zzc = new AtomicInteger();

    private zzaau() {
    }

    static int zza(zzaav zzaavVar, zzaai zzaaiVar, zzabp zzabpVar) {
        zzaau zzaauVar = (zzaau) zza.zzb(zzaaiVar, zzabpVar);
        int iIncrementAndGet = zzaauVar.zzc.incrementAndGet();
        if (zzaavVar == zzaav.zzc || !zzaauVar.zzb.compareAndSet(false, true)) {
            return -1;
        }
        try {
            zzaavVar.zzb();
            zzaauVar.zzb.set(false);
            zzaauVar.zzc.addAndGet(-iIncrementAndGet);
            return iIncrementAndGet - 1;
        } catch (Throwable th) {
            zzaauVar.zzb.set(false);
            throw th;
        }
    }

    /* synthetic */ zzaau(byte[] bArr) {
    }
}
