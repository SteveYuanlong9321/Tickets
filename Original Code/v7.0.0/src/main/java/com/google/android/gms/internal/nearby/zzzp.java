package com.google.android.gms.internal.nearby;

import androidx.collection.SieveCacheKt;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzzp extends zzaav {
    private static final zzaak zza = new zzzo();
    private final AtomicLong zzb = new AtomicLong(SieveCacheKt.NodeLinkMask);

    zzzp() {
    }

    static zzaav zza(zzabp zzabpVar, zzaai zzaaiVar) {
        Integer num = (Integer) zzabpVar.zzd(zzaac.zzb);
        if (num == null) {
            return null;
        }
        zzzp zzzpVar = (zzzp) zza.zzb(zzaaiVar, zzabpVar);
        return zzzpVar.zzb.incrementAndGet() >= ((long) num.intValue()) ? zzzpVar : zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zzaav
    public final void zzb() {
        this.zzb.set(0L);
    }
}
