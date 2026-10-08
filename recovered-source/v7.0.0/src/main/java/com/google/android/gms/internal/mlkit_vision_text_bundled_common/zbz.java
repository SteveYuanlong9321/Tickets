package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbz extends zbuf implements zbvn {
    private static final zbz zbb;
    private zbun zbd = zby();

    static {
        zbz zbzVar = new zbz();
        zbb = zbzVar;
        zbuf.zbD(zbz.class, zbzVar);
    }

    private zbz() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zbd", zbac.class});
        }
        if (i2 == 3) {
            return new zbz();
        }
        zbx zbxVar = null;
        if (i2 == 4) {
            return new zby(zbxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
