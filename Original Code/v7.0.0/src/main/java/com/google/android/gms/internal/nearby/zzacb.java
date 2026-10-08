package com.google.android.gms.internal.nearby;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzacb implements Iterator {
    final /* synthetic */ zzacc zza;
    private int zzb;

    zzacb(zzacc zzaccVar) {
        Objects.requireNonNull(zzaccVar);
        this.zza = zzaccVar;
        this.zzb = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zza.zza.zzg();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i = this.zzb;
        this.zzb = i + 1;
        zzace zzaceVar = this.zza.zza;
        return zzaceVar.zzd(zzaceVar.zzf()[i] & 31);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
