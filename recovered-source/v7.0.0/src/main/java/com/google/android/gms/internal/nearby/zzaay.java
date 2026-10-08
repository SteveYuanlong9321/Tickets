package com.google.android.gms.internal.nearby;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaay extends zzaav {
    private static final zzaak zzb = new zzaaw();
    private static final ThreadLocal zze = new zzaax();
    final AtomicInteger zza = new AtomicInteger();

    zzaay() {
    }

    static zzaav zza(zzabp zzabpVar, zzaai zzaaiVar) {
        Integer num = (Integer) zzabpVar.zzd(zzaac.zzc);
        if (num == null || num.intValue() <= 0) {
            return null;
        }
        zzaay zzaayVar = (zzaay) zzb.zzb(zzaaiVar, zzabpVar);
        return (((Random) zze.get()).nextInt(num.intValue()) == 0 ? zzaayVar.zza.incrementAndGet() : zzaayVar.zza.get()) > 0 ? zzaayVar : zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zzaav
    public final void zzb() {
        this.zza.decrementAndGet();
    }
}
