package com.google.android.gms.internal.nearby;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzzg extends zzyn {
    static final zzzg zzc;
    final transient zzyg zzd;

    static {
        int i = zzyg.zzd;
        zzc = new zzzg(zzyz.zza, zzyw.zza);
    }

    zzzg(zzyg zzygVar, Comparator comparator) {
        super(comparator);
        this.zzd = zzygVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzyn, java.util.NavigableSet
    public final Object ceiling(Object obj) {
        zzyg zzygVar = this.zzd;
        int iZzz = zzz(obj, true);
        if (iZzz == zzygVar.size()) {
            return null;
        }
        return zzygVar.get(iZzz);
    }

    @Override // com.google.android.gms.internal.nearby.zzyb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (Collections.binarySearch(this.zzd, obj, this.zza) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        if (collection instanceof zzyv) {
            collection = ((zzyv) collection).zza();
        }
        Comparator comparator = ((zzyn) this).zza;
        if (!zzzk.zza(comparator, collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        zzzm zzzmVarListIterator = this.zzd.listIterator(0);
        Iterator it = collection.iterator();
        if (!zzzmVarListIterator.hasNext()) {
            return false;
        }
        Object next = it.next();
        E next2 = zzzmVarListIterator.next();
        while (true) {
            try {
                int iCompare = comparator.compare(next2, next);
                if (iCompare < 0) {
                    if (!zzzmVarListIterator.hasNext()) {
                        return false;
                    }
                    next2 = zzzmVarListIterator.next();
                } else {
                    if (iCompare != 0) {
                        return false;
                    }
                    if (!it.hasNext()) {
                        return true;
                    }
                    next = it.next();
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzyl, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        zzyg zzygVar = this.zzd;
        if (zzygVar.size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!zzzk.zza(this.zza, set)) {
            return containsAll(set);
        }
        Iterator it = set.iterator();
        try {
            zzzm zzzmVarListIterator = zzygVar.listIterator(0);
            while (zzzmVarListIterator.hasNext()) {
                E next = zzzmVarListIterator.next();
                Object next2 = it.next();
                if (next2 == null || ((zzyn) this).zza.compare(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzyn, java.util.SortedSet
    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.zzd.get(0);
    }

    @Override // com.google.android.gms.internal.nearby.zzyn, java.util.NavigableSet
    public final Object floor(Object obj) {
        int iZzy = zzy(obj, true) - 1;
        if (iZzy == -1) {
            return null;
        }
        return this.zzd.get(iZzy);
    }

    @Override // com.google.android.gms.internal.nearby.zzyn, java.util.NavigableSet
    public final Object higher(Object obj) {
        zzyg zzygVar = this.zzd;
        int iZzz = zzz(obj, false);
        if (iZzz == zzygVar.size()) {
            return null;
        }
        return zzygVar.get(iZzz);
    }

    @Override // com.google.android.gms.internal.nearby.zzyn, com.google.android.gms.internal.nearby.zzyl, com.google.android.gms.internal.nearby.zzyb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzd.listIterator(0);
    }

    @Override // com.google.android.gms.internal.nearby.zzyn, java.util.SortedSet
    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        zzyg zzygVar = this.zzd;
        return zzygVar.get(zzygVar.size() - 1);
    }

    @Override // com.google.android.gms.internal.nearby.zzyn, java.util.NavigableSet
    public final Object lower(Object obj) {
        int iZzy = zzy(obj, false) - 1;
        if (iZzy == -1) {
            return null;
        }
        return this.zzd.get(iZzy);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzd.size();
    }

    final zzzg zzA(int i, int i2) {
        if (i == 0) {
            if (i2 == this.zzd.size()) {
                return this;
            }
            i = 0;
        }
        if (i >= i2) {
            return zzq(this.zza);
        }
        zzyg zzygVar = this.zzd;
        return new zzzg(zzygVar.subList(i, i2), this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzyn, com.google.android.gms.internal.nearby.zzyl, com.google.android.gms.internal.nearby.zzyb
    /* JADX INFO: renamed from: zza */
    public final zzzl iterator() {
        return this.zzd.listIterator(0);
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final Object[] zzb() {
        return this.zzd.zzb();
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final int zzc() {
        return this.zzd.zzc();
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final int zzd() {
        return this.zzd.zzd();
    }

    @Override // com.google.android.gms.internal.nearby.zzyl, com.google.android.gms.internal.nearby.zzyb
    public final zzyg zze() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final boolean zzf() {
        return this.zzd.zzf();
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final int zzg(Object[] objArr, int i) {
        return this.zzd.zzg(objArr, 0);
    }

    @Override // com.google.android.gms.internal.nearby.zzyn
    final zzyn zzt(Object obj, boolean z) {
        return zzA(0, zzy(obj, z));
    }

    @Override // com.google.android.gms.internal.nearby.zzyn
    final zzyn zzu(Object obj, boolean z, Object obj2, boolean z2) {
        return zzv(obj, z).zzt(obj2, z2);
    }

    @Override // com.google.android.gms.internal.nearby.zzyn
    final zzyn zzv(Object obj, boolean z) {
        return zzA(zzz(obj, z), this.zzd.size());
    }

    @Override // com.google.android.gms.internal.nearby.zzyn
    final zzyn zzw() {
        Comparator comparatorReverseOrder = Collections.reverseOrder(this.zza);
        return isEmpty() ? zzq(comparatorReverseOrder) : new zzzg(this.zzd.zzh(), comparatorReverseOrder);
    }

    @Override // com.google.android.gms.internal.nearby.zzyn, java.util.NavigableSet
    /* JADX INFO: renamed from: zzx, reason: merged with bridge method [inline-methods] */
    public final zzzl descendingIterator() {
        return this.zzd.zzh().listIterator(0);
    }

    final int zzy(Object obj, boolean z) {
        obj.getClass();
        int iBinarySearch = Collections.binarySearch(this.zzd, obj, ((zzyn) this).zza);
        if (iBinarySearch >= 0) {
            return z ? iBinarySearch + 1 : iBinarySearch;
        }
        return ~iBinarySearch;
    }

    final int zzz(Object obj, boolean z) {
        obj.getClass();
        int iBinarySearch = Collections.binarySearch(this.zzd, obj, ((zzyn) this).zza);
        if (iBinarySearch >= 0) {
            return z ? iBinarySearch : iBinarySearch + 1;
        }
        return ~iBinarySearch;
    }
}
