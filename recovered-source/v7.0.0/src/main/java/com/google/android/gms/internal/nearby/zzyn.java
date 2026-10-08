package com.google.android.gms.internal.nearby;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzyn extends zzyl implements NavigableSet, zzzj {
    final transient Comparator zza;
    transient zzyn zzb;

    zzyn(Comparator comparator) {
        this.zza = comparator;
    }

    static zzzg zzq(Comparator comparator) {
        if (zzyw.zza.equals(comparator)) {
            return zzzg.zzc;
        }
        int i = zzyg.zzd;
        return new zzzg(zzyz.zza, comparator);
    }

    public static zzyn zzr() {
        return zzzg.zzc;
    }

    @Deprecated
    public final void addFirst(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void addLast(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.SortedSet, com.google.android.gms.internal.nearby.zzzj
    public final Comparator comparator() {
        return this.zza;
    }

    @Override // java.util.NavigableSet
    public final /* bridge */ /* synthetic */ NavigableSet descendingSet() {
        zzyn zzynVar = this.zzb;
        if (zzynVar != null) {
            return zzynVar;
        }
        zzyn zzynVarZzw = zzw();
        this.zzb = zzynVarZzw;
        zzynVarZzw.zzb = this;
        return zzynVarZzw;
    }

    @Override // java.util.SortedSet
    public Object first() {
        return iterator().next();
    }

    public final Object getFirst() {
        return first();
    }

    public final Object getLast() {
        return last();
    }

    @Override // java.util.SortedSet
    public Object last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object removeFirst() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object removeLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // com.google.android.gms.internal.nearby.zzyl, com.google.android.gms.internal.nearby.zzyb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zza */
    public abstract zzzl iterator();

    abstract zzyn zzt(Object obj, boolean z);

    abstract zzyn zzu(Object obj, boolean z, Object obj2, boolean z2);

    abstract zzyn zzv(Object obj, boolean z);

    abstract zzyn zzw();

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: zzx */
    public abstract zzzl descendingIterator();

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* synthetic */ SortedSet headSet(Object obj) {
        obj.getClass();
        return zzt(obj, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* synthetic */ SortedSet tailSet(Object obj) {
        obj.getClass();
        return zzv(obj, true);
    }

    @Override // java.util.NavigableSet
    public Object ceiling(Object obj) {
        obj.getClass();
        return zzyo.zza(zzv(obj, true), null);
    }

    @Override // java.util.NavigableSet
    public Object floor(Object obj) {
        obj.getClass();
        return zzyq.zza(zzt(obj, true).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    public Object higher(Object obj) {
        obj.getClass();
        return zzyo.zza(zzv(obj, false), null);
    }

    @Override // java.util.NavigableSet
    public Object lower(Object obj) {
        obj.getClass();
        return zzyq.zza(zzt(obj, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    public final /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        obj.getClass();
        return zzt(obj, z);
    }

    @Override // java.util.NavigableSet
    public final /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        obj.getClass();
        return zzv(obj, z);
    }

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: zzs, reason: merged with bridge method [inline-methods] */
    public final zzyn subSet(Object obj, boolean z, Object obj2, boolean z2) {
        obj.getClass();
        obj2.getClass();
        zzxd.zza(this.zza.compare(obj, obj2) <= 0);
        return zzu(obj, z, obj2, z2);
    }
}
