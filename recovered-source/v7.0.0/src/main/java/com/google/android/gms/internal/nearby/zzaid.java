package com.google.android.gms.internal.nearby;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaid extends zzaie {
    final /* synthetic */ zzaik zza;
    private int zzb;
    private final int zzc;

    zzaid(zzaik zzaikVar) {
        Objects.requireNonNull(zzaikVar);
        this.zza = zzaikVar;
        this.zzb = 0;
        this.zzc = zzaikVar.zzb();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zzaig
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zza(i);
    }
}
