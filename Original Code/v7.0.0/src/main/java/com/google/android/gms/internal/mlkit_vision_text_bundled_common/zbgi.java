package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbgi extends zbuf implements zbvn {
    private static final zbgi zbb;
    private int zbd;
    private float zbf;
    private boolean zbg;
    private zbxb zbi;
    private boolean zbj;
    private boolean zbk;
    private zbul zbe = zbw();
    private int zbh = 1;

    static {
        zbgi zbgiVar = new zbgi();
        zbb = zbgiVar;
        zbuf.zbD(zbgi.class, zbgiVar);
    }

    private zbgi() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0007\u0000\u0001\u0001\b\u0007\u0000\u0001\u0000\u0001ࠞ\u0002ခ\u0000\u0003ဇ\u0001\u0004᠌\u0002\u0005ဉ\u0003\u0007ဇ\u0004\bဇ\u0005", new Object[]{"zbd", "zbe", zbge.zba, "zbf", "zbg", "zbh", zbgh.zba, "zbi", "zbj", "zbk"});
        }
        if (i2 == 3) {
            return new zbgi();
        }
        zbgf zbgfVar = null;
        if (i2 == 4) {
            return new zbgg(zbgfVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
