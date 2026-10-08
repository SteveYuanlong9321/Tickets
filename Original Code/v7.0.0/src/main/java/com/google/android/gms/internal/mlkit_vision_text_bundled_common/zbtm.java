package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbtm extends zbsl implements RandomAccess, zbun {
    private double[] zba;
    private int zbb;

    static {
        new zbtm(new double[0], 0, false);
    }

    zbtm() {
        this(new double[10], 0, true);
    }

    private final String zbg(int i) {
        return "Index:" + i + ", Size:" + this.zbb;
    }

    private final void zbh(int i) {
        if (i < 0 || i >= this.zbb) {
            throw new IndexOutOfBoundsException(zbg(i));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double dDoubleValue = ((Double) obj).doubleValue();
        zba();
        if (i < 0 || i > (i2 = this.zbb)) {
            throw new IndexOutOfBoundsException(zbg(i));
        }
        int i3 = i + 1;
        double[] dArr = this.zba;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i3, i2 - i);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.zba, i, dArr2, i3, this.zbb - i);
            this.zba = dArr2;
        }
        this.zba[i] = dDoubleValue;
        this.zbb++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zba();
        byte[] bArr = zbuo.zbb;
        collection.getClass();
        if (!(collection instanceof zbtm)) {
            return super.addAll(collection);
        }
        zbtm zbtmVar = (zbtm) collection;
        int i = zbtmVar.zbb;
        if (i == 0) {
            return false;
        }
        int i2 = this.zbb;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        double[] dArrCopyOf = this.zba;
        if (i3 > dArrCopyOf.length) {
            dArrCopyOf = Arrays.copyOf(dArrCopyOf, i3);
            this.zba = dArrCopyOf;
        }
        System.arraycopy(zbtmVar.zba, 0, dArrCopyOf, this.zbb, zbtmVar.zbb);
        this.zbb = i3;
        this.modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zbtm)) {
            return super.equals(obj);
        }
        zbtm zbtmVar = (zbtm) obj;
        if (this.zbb != zbtmVar.zbb) {
            return false;
        }
        double[] dArr = zbtmVar.zba;
        for (int i = 0; i < this.zbb; i++) {
            if (Double.doubleToLongBits(this.zba[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zbh(i);
        return Double.valueOf(this.zba[i]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.zbb; i2++) {
            long jDoubleToLongBits = Double.doubleToLongBits(this.zba[i2]);
            byte[] bArr = zbuo.zbb;
            i = (i * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i = this.zbb;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zba[i2] == dDoubleValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zba();
        zbh(i);
        double[] dArr = this.zba;
        double d = dArr[i];
        int i2 = this.zbb;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.zbb--;
        this.modCount++;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zba();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.zba;
        System.arraycopy(dArr, i2, dArr, i, this.zbb - i2);
        this.zbb -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        zba();
        zbh(i);
        double[] dArr = this.zba;
        double d = dArr[i];
        dArr[i] = dDoubleValue;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zbb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun
    public final /* bridge */ /* synthetic */ zbun zbd(int i) {
        if (i >= this.zbb) {
            return new zbtm(Arrays.copyOf(this.zba, i), this.zbb, true);
        }
        throw new IllegalArgumentException();
    }

    public final double zbe(int i) {
        zbh(i);
        return this.zba[i];
    }

    public final void zbf(double d) {
        zba();
        int i = this.zbb;
        double[] dArr = this.zba;
        if (i == dArr.length) {
            double[] dArr2 = new double[((i * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.zba = dArr2;
            dArr = dArr2;
        }
        int i2 = this.zbb;
        this.zbb = i2 + 1;
        dArr[i2] = d;
    }

    private zbtm(double[] dArr, int i, boolean z) {
        super(z);
        this.zba = dArr;
        this.zbb = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zbf(((Double) obj).doubleValue());
        return true;
    }
}
