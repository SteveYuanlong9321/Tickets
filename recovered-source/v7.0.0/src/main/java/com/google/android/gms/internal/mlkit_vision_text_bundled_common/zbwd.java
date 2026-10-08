package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbwd implements Iterator {
    final /* synthetic */ zbwh zba;
    private int zbb = -1;
    private boolean zbc;
    private Iterator zbd;

    /* synthetic */ zbwd(zbwh zbwhVar, zbwc zbwcVar) {
        this.zba = zbwhVar;
    }

    private final Iterator zba() {
        Iterator it = this.zbd;
        if (it != null) {
            return it;
        }
        Iterator it2 = this.zba.zbc.entrySet().iterator();
        this.zbd = it2;
        return it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zbb + 1;
        zbwh zbwhVar = this.zba;
        if (i >= zbwhVar.zbb) {
            return !zbwhVar.zbc.isEmpty() && zba().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zbc = true;
        int i = this.zbb + 1;
        this.zbb = i;
        zbwh zbwhVar = this.zba;
        return i < zbwhVar.zbb ? (zbwb) zbwhVar.zba[i] : (Map.Entry) zba().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zbc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zbc = false;
        this.zba.zbo();
        int i = this.zbb;
        zbwh zbwhVar = this.zba;
        if (i >= zbwhVar.zbb) {
            zba().remove();
        } else {
            this.zbb = i - 1;
            zbwhVar.zbm(i);
        }
    }
}
