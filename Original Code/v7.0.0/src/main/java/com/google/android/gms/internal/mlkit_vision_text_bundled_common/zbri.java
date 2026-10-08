package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbri extends zbuf implements zbvn {
    private static final zbri zbb;
    private byte zbe = 2;
    private zbun zbd = zby();

    static {
        zbri zbriVar = new zbri();
        zbb = zbriVar;
        zbuf.zbD(zbri.class, zbriVar);
    }

    private zbri() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbe);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zbd", zbrg.class});
        }
        if (i2 == 3) {
            return new zbri();
        }
        zbpu zbpuVar = null;
        if (i2 == 4) {
            return new zbrh(zbpuVar);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbe = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
