package com.google.android.gms.internal.nearby;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzacc extends AbstractSet {
    final /* synthetic */ zzace zza;

    zzacc(zzace zzaceVar) {
        Objects.requireNonNull(zzaceVar);
        this.zza = zzaceVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzacb(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.zzg();
    }
}
