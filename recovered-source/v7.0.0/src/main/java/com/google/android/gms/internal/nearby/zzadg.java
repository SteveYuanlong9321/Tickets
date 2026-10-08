package com.google.android.gms.internal.nearby;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzadg implements Iterator {
    final /* synthetic */ zzadh zza;
    private int zzb;

    zzadg(zzadh zzadhVar) {
        Objects.requireNonNull(zzadhVar);
        this.zza = zzadhVar;
        this.zzb = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb;
        zzadh zzadhVar = this.zza;
        return i < zzadhVar.zzc() - zzadhVar.zzb();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.zzb;
        zzadh zzadhVar = this.zza;
        if (i >= zzadhVar.zzc() - zzadhVar.zzb()) {
            throw new NoSuchElementException();
        }
        zzadi zzadiVar = zzadhVar.zzb;
        Object obj = zzadiVar.zzb()[zzadhVar.zzb() + i];
        this.zzb = i + 1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
