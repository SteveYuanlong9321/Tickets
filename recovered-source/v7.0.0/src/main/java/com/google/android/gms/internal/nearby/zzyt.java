package com.google.android.gms.internal.nearby;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
class zzyt extends AbstractList {
    private final List zza;

    zzyt(List list) {
        list.getClass();
        this.zza = list;
    }

    private final int zzb(int i) {
        int size = size();
        zzxd.zzi(i, size, "index");
        return (size - 1) - i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int size = size();
        zzxd.zzj(i, size, "index");
        this.zza.add(size - i, obj);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.zza.get(zzb(i));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        int size = size();
        zzxd.zzj(i, size, "index");
        return new zzys(this, this.zza.listIterator(size - i));
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        return this.zza.remove(zzb(i));
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        subList(i, i2).clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        return this.zza.set(zzb(i), obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        zzxd.zzk(i, i2, size());
        int size = size();
        zzxd.zzj(i2, size, "index");
        int i3 = size - i2;
        int size2 = size();
        zzxd.zzj(i, size2, "index");
        return zzyu.zza(this.zza.subList(i3, size2 - i));
    }

    final List zza() {
        return this.zza;
    }
}
