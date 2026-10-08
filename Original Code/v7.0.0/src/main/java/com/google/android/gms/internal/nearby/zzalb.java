package com.google.android.gms.internal.nearby;

import androidx.compose.foundation.style.StylePropertiesKt;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalb extends zzahx implements RandomAccess {
    private static final Object[] zza;
    private static final zzalb zzb;
    private Object[] zzc;
    private int zzd;

    static {
        Object[] objArr = new Object[0];
        zza = objArr;
        zzb = new zzalb(objArr, 0, false);
    }

    zzalb() {
        this(zza, 0, true);
    }

    public static zzalb zzd() {
        return zzb;
    }

    private final void zze(int i) {
        if (i < 0 || i >= this.zzd) {
            throw new IndexOutOfBoundsException(zzf(i));
        }
    }

    private final String zzf(int i) {
        return zzahz.zza(this.zzd, i, StylePropertiesKt.LeftId, "Index:", ", Size:");
    }

    @Override // com.google.android.gms.internal.nearby.zzahx, java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        zzbk();
        if (i < 0 || i > (i2 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzf(i));
        }
        int i3 = i + 1;
        Object[] objArr = this.zzc;
        int length = objArr.length;
        if (i2 < length) {
            System.arraycopy(objArr, i, objArr, i3, i2 - i);
        } else {
            Object[] objArr2 = new Object[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.zzc, 0, objArr2, 0, i);
            System.arraycopy(this.zzc, i, objArr2, i3, this.zzd - i);
            this.zzc = objArr2;
        }
        this.zzc[i] = obj;
        this.zzd++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.nearby.zzahx, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzalb) {
            zzalb zzalbVar = (zzalb) obj;
            int i = this.zzd;
            if (i != zzalbVar.zzd) {
                return false;
            }
            for (int i2 = 0; i2 < i; i2++) {
                if (!this.zzc[i2].equals(zzalbVar.zzc[i2])) {
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int i3 = this.zzd;
        if (i3 != list.size()) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!this.zzc[i4].equals(list.get(i4))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        zze(i);
        return this.zzc[i];
    }

    @Override // com.google.android.gms.internal.nearby.zzahx, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = this.zzd;
        int iHashCode = 1;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode = (iHashCode * 31) + this.zzc[i2].hashCode();
        }
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.nearby.zzahx, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        zzbk();
        zze(i);
        Object[] objArr = this.zzc;
        Object obj = objArr[i];
        int i2 = this.zzd;
        if (i < i2 - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (i2 - i) - 1);
        }
        this.zzd--;
        this.modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.nearby.zzahx, java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        zzbk();
        zze(i);
        Object[] objArr = this.zzc;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        this.modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.nearby.zzajz, com.google.android.gms.internal.nearby.zzajq
    public final /* bridge */ /* synthetic */ zzajz zzg(int i) {
        if (i >= this.zzd) {
            return new zzalb(i == 0 ? zza : Arrays.copyOf(this.zzc, i), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    private zzalb(Object[] objArr, int i, boolean z) {
        super(z);
        this.zzc = objArr;
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.nearby.zzahx, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zzbk();
        int i = this.zzd;
        Object[] objArrCopyOf = this.zzc;
        int length = objArrCopyOf.length;
        if (i == length) {
            objArrCopyOf = Arrays.copyOf(this.zzc, Math.max(((length * 3) / 2) + 1, 10));
            this.zzc = objArrCopyOf;
        }
        int i2 = this.zzd;
        this.zzd = i2 + 1;
        objArrCopyOf[i2] = obj;
        this.modCount++;
        return true;
    }
}
