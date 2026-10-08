package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbhz extends zbuf implements zbvn {
    private static final zbhz zbb;
    private zbun zbd = zby();

    static {
        zbhz zbhzVar = new zbhz();
        zbb = zbhzVar;
        zbuf.zbD(zbhz.class, zbhzVar);
    }

    private zbhz() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zbd", zbhx.class});
        }
        if (i2 == 3) {
            return new zbhz();
        }
        zbhs zbhsVar = null;
        if (i2 == 4) {
            return new zbhy(zbhsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
