package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
class zbwh extends AbstractMap {
    private Object[] zba;
    private int zbb;
    private boolean zbd;
    private volatile zbwf zbe;
    private Map zbc = Collections.EMPTY_MAP;
    private Map zbf = Collections.EMPTY_MAP;

    private zbwh() {
    }

    private final int zbl(Comparable comparable) {
        int i = this.zbb;
        int i2 = i - 1;
        int i3 = 0;
        if (i2 >= 0) {
            int iCompareTo = comparable.compareTo(((zbwb) this.zba[i2]).zba());
            if (iCompareTo > 0) {
                return -(i + 1);
            }
            if (iCompareTo == 0) {
                return i2;
            }
        }
        while (i3 <= i2) {
            int i4 = (i3 + i2) / 2;
            int iCompareTo2 = comparable.compareTo(((zbwb) this.zba[i4]).zba());
            if (iCompareTo2 < 0) {
                i2 = i4 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i4;
                }
                i3 = i4 + 1;
            }
        }
        return -(i3 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zbm(int i) {
        zbo();
        Object value = ((zbwb) this.zba[i]).getValue();
        Object[] objArr = this.zba;
        System.arraycopy(objArr, i + 1, objArr, i, (this.zbb - i) - 1);
        this.zbb--;
        if (!this.zbc.isEmpty()) {
            Iterator it = zbn().entrySet().iterator();
            Object[] objArr2 = this.zba;
            int i2 = this.zbb;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i2] = new zbwb(this, (Comparable) entry.getKey(), entry.getValue());
            this.zbb++;
            it.remove();
        }
        return value;
    }

    private final SortedMap zbn() {
        zbo();
        if (this.zbc.isEmpty() && !(this.zbc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zbc = treeMap;
            this.zbf = treeMap.descendingMap();
        }
        return (SortedMap) this.zbc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zbo() {
        if (this.zbd) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zbo();
        if (this.zbb != 0) {
            this.zba = null;
            this.zbb = 0;
        }
        if (this.zbc.isEmpty()) {
            return;
        }
        this.zbc.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zbl(comparable) >= 0 || this.zbc.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.zbe == null) {
            this.zbe = new zbwf(this, null);
        }
        return this.zbe;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zbwh)) {
            return super.equals(obj);
        }
        zbwh zbwhVar = (zbwh) obj;
        int size = size();
        if (size != zbwhVar.size()) {
            return false;
        }
        int i = this.zbb;
        if (i != zbwhVar.zbb) {
            return entrySet().equals(zbwhVar.entrySet());
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (!zbg(i2).equals(zbwhVar.zbg(i2))) {
                return false;
            }
        }
        if (i != size) {
            return this.zbc.equals(zbwhVar.zbc);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZbl = zbl(comparable);
        return iZbl >= 0 ? ((zbwb) this.zba[iZbl]).getValue() : this.zbc.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i = this.zbb;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode += this.zba[i2].hashCode();
        }
        return this.zbc.size() > 0 ? iHashCode + this.zbc.hashCode() : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zbo();
        Comparable comparable = (Comparable) obj;
        int iZbl = zbl(comparable);
        if (iZbl >= 0) {
            return zbm(iZbl);
        }
        if (this.zbc.isEmpty()) {
            return null;
        }
        return this.zbc.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zbb + this.zbc.size();
    }

    public void zba() {
        if (this.zbd) {
            return;
        }
        this.zbc = this.zbc.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.zbc);
        this.zbf = this.zbf.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.zbf);
        this.zbd = true;
    }

    public final int zbc() {
        return this.zbb;
    }

    public final Iterable zbd() {
        return this.zbc.isEmpty() ? Collections.EMPTY_SET : this.zbc.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zbf, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        zbo();
        int iZbl = zbl(comparable);
        if (iZbl >= 0) {
            return ((zbwb) this.zba[iZbl]).setValue(obj);
        }
        zbo();
        Object[] objArr = this.zba;
        if (objArr == null) {
            objArr = new Object[16];
            this.zba = objArr;
        }
        int i = -(iZbl + 1);
        if (i >= 16) {
            return zbn().put(comparable, obj);
        }
        if (this.zbb == 16) {
            zbwb zbwbVar = (zbwb) objArr[15];
            this.zbb = 15;
            zbn().put(zbwbVar.zba(), zbwbVar.getValue());
        }
        Object[] objArr2 = this.zba;
        int length = objArr2.length;
        System.arraycopy(objArr2, i, objArr2, i + 1, 15 - i);
        this.zba[i] = new zbwb(this, comparable, obj);
        this.zbb++;
        return null;
    }

    public final Map.Entry zbg(int i) {
        if (i < this.zbb) {
            return (zbwb) this.zba[i];
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public final boolean zbj() {
        return this.zbd;
    }

    /* synthetic */ zbwh(zbwg zbwgVar) {
    }
}
