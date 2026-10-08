package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbss extends zbsl implements RandomAccess, zbun {
    private boolean[] zba;
    private int zbb;

    static {
        new zbss(new boolean[0], 0, false);
    }

    zbss() {
        this(new boolean[10], 0, true);
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
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zba();
        if (i < 0 || i > (i2 = this.zbb)) {
            throw new IndexOutOfBoundsException(zbg(i));
        }
        int i3 = i + 1;
        boolean[] zArr = this.zba;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i3, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zba, i, zArr2, i3, this.zbb - i);
            this.zba = zArr2;
        }
        this.zba[i] = zBooleanValue;
        this.zbb++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zba();
        byte[] bArr = zbuo.zbb;
        collection.getClass();
        if (!(collection instanceof zbss)) {
            return super.addAll(collection);
        }
        zbss zbssVar = (zbss) collection;
        int i = zbssVar.zbb;
        if (i == 0) {
            return false;
        }
        int i2 = this.zbb;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        boolean[] zArrCopyOf = this.zba;
        if (i3 > zArrCopyOf.length) {
            zArrCopyOf = Arrays.copyOf(zArrCopyOf, i3);
            this.zba = zArrCopyOf;
        }
        System.arraycopy(zbssVar.zba, 0, zArrCopyOf, this.zbb, zbssVar.zbb);
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
        if (!(obj instanceof zbss)) {
            return super.equals(obj);
        }
        zbss zbssVar = (zbss) obj;
        if (this.zbb != zbssVar.zbb) {
            return false;
        }
        boolean[] zArr = zbssVar.zba;
        for (int i = 0; i < this.zbb; i++) {
            if (this.zba[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zbh(i);
        return Boolean.valueOf(this.zba[i]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZba = 1;
        for (int i = 0; i < this.zbb; i++) {
            iZba = (iZba * 31) + zbuo.zba(this.zba[i]);
        }
        return iZba;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i = this.zbb;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zba[i2] == zBooleanValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zba();
        zbh(i);
        boolean[] zArr = this.zba;
        boolean z = zArr[i];
        int i2 = this.zbb;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.zbb--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zba();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.zba;
        System.arraycopy(zArr, i2, zArr, i, this.zbb - i2);
        this.zbb -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zba();
        zbh(i);
        boolean[] zArr = this.zba;
        boolean z = zArr[i];
        zArr[i] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zbb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun
    public final /* bridge */ /* synthetic */ zbun zbd(int i) {
        if (i >= this.zbb) {
            return new zbss(Arrays.copyOf(this.zba, i), this.zbb, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zbe(boolean z) {
        zba();
        int i = this.zbb;
        boolean[] zArr = this.zba;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[((i * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.zba = zArr2;
            zArr = zArr2;
        }
        int i2 = this.zbb;
        this.zbb = i2 + 1;
        zArr[i2] = z;
    }

    public final boolean zbf(int i) {
        zbh(i);
        return this.zba[i];
    }

    private zbss(boolean[] zArr, int i, boolean z) {
        super(z);
        this.zba = zArr;
        this.zbb = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zbe(((Boolean) obj).booleanValue());
        return true;
    }
}
