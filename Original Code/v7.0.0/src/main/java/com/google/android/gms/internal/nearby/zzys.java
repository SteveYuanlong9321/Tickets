package com.google.android.gms.internal.nearby;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzys implements ListIterator {
    boolean zza;
    final /* synthetic */ ListIterator zzb;
    final /* synthetic */ zzyt zzc;

    zzys(zzyt zzytVar, ListIterator listIterator) {
        this.zzb = listIterator;
        Objects.requireNonNull(zzytVar);
        this.zzc = zzytVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        ListIterator listIterator = this.zzb;
        listIterator.add(obj);
        listIterator.previous();
        this.zza = false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.zzb.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzb.hasNext();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.zza = true;
        return this.zzb.previous();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        int iNextIndex = this.zzb.nextIndex();
        int size = this.zzc.size();
        zzxd.zzj(iNextIndex, size, "index");
        return size - iNextIndex;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        this.zza = true;
        return this.zzb.next();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return nextIndex() - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        zzxd.zzf(this.zza, "no calls to next() since the last call to remove()");
        this.zzb.remove();
        this.zza = false;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        zzxd.zze(this.zza);
        this.zzb.set(obj);
    }
}
