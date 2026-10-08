package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbvv extends zbsl implements RandomAccess {
    private static final zbvv zba = new zbvv(new Object[0], 0, false);
    private Object[] zbb;
    private int zbc;

    zbvv() {
        this(new Object[10], 0, true);
    }

    public static zbvv zbe() {
        return zba;
    }

    private final String zbf(int i) {
        return "Index:" + i + ", Size:" + this.zbc;
    }

    private final void zbg(int i) {
        if (i < 0 || i >= this.zbc) {
            throw new IndexOutOfBoundsException(zbf(i));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        zba();
        if (i < 0 || i > (i2 = this.zbc)) {
            throw new IndexOutOfBoundsException(zbf(i));
        }
        int i3 = i + 1;
        Object[] objArr = this.zbb;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i3, i2 - i);
        } else {
            Object[] objArr2 = new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.zbb, i, objArr2, i3, this.zbc - i);
            this.zbb = objArr2;
        }
        this.zbb[i] = obj;
        this.zbc++;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        zbg(i);
        return this.zbb[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        zba();
        zbg(i);
        Object[] objArr = this.zbb;
        Object obj = objArr[i];
        int i2 = this.zbc;
        if (i < i2 - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (i2 - i) - 1);
        }
        this.zbc--;
        this.modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        zba();
        zbg(i);
        Object[] objArr = this.zbb;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        this.modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zbc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun
    public final /* bridge */ /* synthetic */ zbun zbd(int i) {
        if (i >= this.zbc) {
            return new zbvv(Arrays.copyOf(this.zbb, i), this.zbc, true);
        }
        throw new IllegalArgumentException();
    }

    private zbvv(Object[] objArr, int i, boolean z) {
        super(z);
        this.zbb = objArr;
        this.zbc = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zba();
        int i = this.zbc;
        Object[] objArrCopyOf = this.zbb;
        if (i == objArrCopyOf.length) {
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, ((i * 3) / 2) + 1);
            this.zbb = objArrCopyOf;
        }
        int i2 = this.zbc;
        this.zbc = i2 + 1;
        objArrCopyOf[i2] = obj;
        this.modCount++;
        return true;
    }
}
