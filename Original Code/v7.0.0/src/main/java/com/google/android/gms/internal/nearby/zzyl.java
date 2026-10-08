package com.google.android.gms.internal.nearby;

import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzyl extends zzyb implements Set {
    private transient zzyg zza;

    zzyl() {
    }

    public static zzyl zzh() {
        return zzzf.zza;
    }

    public static zzyl zzi(Object obj, Object obj2) {
        return zzq(2, obj, obj2);
    }

    public static zzyl zzj(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzq(5, "COPRESENCE", "COPRESENCE_NO_IDS", "NEARBY", "NEARBY_EXPOSURE_NOTIFICATION", "FAST_PAIR");
    }

    @SafeVarargs
    public static zzyl zzk(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        int length = objArr.length;
        int i = length + 6;
        Object[] objArr2 = new Object[i];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, length);
        return zzq(i, objArr2);
    }

    static int zzl(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            zzxd.zzb(iMax < 1073741824, "collection too large");
            return GroupFlagsKt.IsSubcompositionContextFlag;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzyl zzm(Collection collection) {
        if ((collection instanceof zzyl) && !(collection instanceof SortedSet)) {
            zzyl zzylVar = (zzyl) collection;
            if (!zzylVar.zzf()) {
                return zzylVar;
            }
        }
        Object[] array = collection.toArray();
        return zzq(array.length, array);
    }

    public static zzyl zzn(Object[] objArr) {
        return zzq(objArr.length, (Object[]) objArr.clone());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzyl) && zzo() && ((zzyl) obj).zzo() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                return size() == set.size() && containsAll(set);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzzh.zzb(this);
    }

    @Override // com.google.android.gms.internal.nearby.zzyb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public abstract zzzl iterator();

    @Override // com.google.android.gms.internal.nearby.zzyb
    public zzyg zze() {
        zzyg zzygVar = this.zza;
        if (zzygVar != null) {
            return zzygVar;
        }
        zzyg zzygVarZzp = zzp();
        this.zza = zzygVarZzp;
        return zzygVarZzp;
    }

    boolean zzo() {
        return false;
    }

    zzyg zzp() {
        Object[] array = toArray();
        int i = zzyg.zzd;
        return zzyg.zzt(array, array.length);
    }

    private static zzyl zzq(int i, Object... objArr) {
        if (i == 0) {
            return zzzf.zza;
        }
        if (i == 1) {
            return new zzzi(Objects.requireNonNull(objArr[0]));
        }
        int iZzl = zzl(i);
        Object[] objArr2 = new Object[iZzl];
        int i2 = iZzl - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[i5];
            zzyx.zzb(obj, i5);
            int iHashCode = obj.hashCode();
            int iZza = zzxy.zza(iHashCode);
            while (true) {
                int i6 = iZza & i2;
                Object obj2 = objArr2[i6];
                if (obj2 == null) {
                    objArr[i4] = obj;
                    objArr2[i6] = obj;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (obj2.equals(obj)) {
                    break;
                }
                iZza++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new zzzi(Objects.requireNonNull(objArr[0]));
        }
        if (zzl(i4) < iZzl / 2) {
            return zzq(i4, objArr);
        }
        int length = objArr.length;
        if (i4 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzzf(objArr, i3, objArr2, i2, i4);
    }
}
