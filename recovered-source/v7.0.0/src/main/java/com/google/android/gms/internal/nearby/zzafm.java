package com.google.android.gms.internal.nearby;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzafm extends zzafl {
    private static final AtomicReferenceFieldUpdater zza = AtomicReferenceFieldUpdater.newUpdater(zzafo.class, Set.class, "seenExceptionsField");
    private static final AtomicIntegerFieldUpdater zzb = AtomicIntegerFieldUpdater.newUpdater(zzafo.class, "remainingField");

    private zzafm() {
        throw null;
    }

    /* synthetic */ zzafm(byte[] bArr) {
        super(null);
    }

    @Override // com.google.android.gms.internal.nearby.zzafl
    final void zza(zzafo zzafoVar, Set set, Set set2) {
        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(zza, zzafoVar, null, set2);
    }

    @Override // com.google.android.gms.internal.nearby.zzafl
    final int zzb(zzafo zzafoVar) {
        return zzb.decrementAndGet(zzafoVar);
    }
}
