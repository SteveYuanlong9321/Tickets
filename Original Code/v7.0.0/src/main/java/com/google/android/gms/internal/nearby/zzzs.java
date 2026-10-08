package com.google.android.gms.internal.nearby;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzzs extends zzaav {
    private static final zzaak zza = new zzzq();
    private final AtomicLong zzb = new AtomicLong(-1);

    zzzs() {
    }

    static zzaav zza(zzabp zzabpVar, zzaai zzaaiVar, long j) {
        if (((zzzr) zzabpVar.zzd(zzaac.zzd)) == null) {
            return null;
        }
        zzzs zzzsVar = (zzzs) zza.zzb(zzaaiVar, zzabpVar);
        zzadx.zzb(j >= 0, "timestamp cannot be negative");
        AtomicLong atomicLong = zzzsVar.zzb;
        long j2 = atomicLong.get();
        if (j2 >= 0) {
            throw null;
        }
        atomicLong.compareAndSet(j2, -j);
        return zzzsVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzaav
    public final void zzb() {
        AtomicLong atomicLong = this.zzb;
        atomicLong.set(Math.max(-atomicLong.get(), 0L));
    }
}
