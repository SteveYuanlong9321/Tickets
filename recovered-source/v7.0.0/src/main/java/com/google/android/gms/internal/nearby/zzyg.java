package com.google.android.gms.internal.nearby;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzyg extends zzyb implements List, RandomAccess {
    private static final zzzm zza = new zzyd(zzyz.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    zzyg() {
    }

    public static zzyg zzj() {
        return zzyz.zza;
    }

    public static zzyg zzk(Object obj) {
        Object[] objArr = {obj};
        zzyx.zza(objArr, 1);
        return zzt(objArr, 1);
    }

    public static zzyg zzl(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        zzyx.zza(objArr, 2);
        return zzt(objArr, 2);
    }

    public static zzyg zzm(Object obj, Object obj2, Object obj3) {
        Object[] objArr = {"/", "\\", "../"};
        zzyx.zza(objArr, 3);
        return zzt(objArr, 3);
    }

    public static zzyg zzn(Object obj, Object obj2, Object obj3, Object obj4) {
        Object[] objArr = {obj, obj2, obj3, obj4};
        zzyx.zza(objArr, 4);
        return zzt(objArr, 4);
    }

    public static zzyg zzo(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object[] objArr = {obj, obj2, obj3, obj4, obj5};
        zzyx.zza(objArr, 5);
        return zzt(objArr, 5);
    }

    public static zzyg zzp(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Object[] objArr = {obj, obj2, obj3, obj4, obj5, obj6};
        zzyx.zza(objArr, 6);
        return zzt(objArr, 6);
    }

    @SafeVarargs
    public static zzyg zzq(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        int length = objArr.length;
        int i = length + 12;
        Object[] objArr2 = new Object[i];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        objArr2[6] = obj7;
        objArr2[7] = obj8;
        objArr2[8] = obj9;
        objArr2[9] = obj10;
        objArr2[10] = obj11;
        objArr2[11] = obj12;
        System.arraycopy(objArr, 0, objArr2, 12, length);
        zzyx.zza(objArr2, i);
        return zzt(objArr2, i);
    }

    public static zzyg zzr(Iterable iterable) {
        if (iterable instanceof Collection) {
            return zzs((Collection) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return zzyz.zza;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return zzk(next);
        }
        zzyc zzycVar = new zzyc(4);
        zzycVar.zzc(next);
        zzycVar.zzd(it);
        return zzycVar.zze();
    }

    public static zzyg zzs(Collection collection) {
        if (!(collection instanceof zzyb)) {
            Object[] array = collection.toArray();
            int length = array.length;
            zzyx.zza(array, length);
            return zzt(array, length);
        }
        zzyg zzygVarZze = ((zzyb) collection).zze();
        if (!zzygVarZze.zzf()) {
            return zzygVarZze;
        }
        Object[] array2 = zzygVarZze.toArray();
        return zzt(array2, array2.length);
    }

    static zzyg zzt(Object[] objArr, int i) {
        return i == 0 ? zzyz.zza : new zzyz(objArr, i);
    }

    public static zzyc zzv(int i) {
        zzxw.zzb(i, "expectedSize");
        return new zzyc(i);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.nearby.zzyb, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        if (list instanceof RandomAccess) {
            for (int i = 0; i < size; i++) {
                if (!Objects.equals(get(i), list.get(i))) {
                    return false;
                }
            }
            return true;
        }
        Iterator it = iterator();
        Iterator it2 = list.iterator();
        while (it.hasNext()) {
            if (!it2.hasNext() || !Objects.equals(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + get(i).hashCode();
        }
        return iHashCode;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    /* JADX INFO: renamed from: zza */
    public final zzzl iterator() {
        return listIterator(0);
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    @Deprecated
    public final zzyg zze() {
        return this;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    int zzg(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    public zzyg zzh() {
        return size() <= 1 ? this : new zzye(this);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public zzyg subList(int i, int i2) {
        zzxd.zzk(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        return i3 == 0 ? zzyz.zza : new zzyf(this, i, i3);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzu, reason: merged with bridge method [inline-methods] */
    public final zzzm listIterator(int i) {
        zzxd.zzj(i, size(), "index");
        return isEmpty() ? zza : new zzyd(this, i);
    }
}
