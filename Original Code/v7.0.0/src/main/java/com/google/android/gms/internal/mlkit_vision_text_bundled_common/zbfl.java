package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbfl extends zbuf implements zbvn {
    private static final zbfl zbb;
    private int zbd;
    private float zbe;
    private boolean zbf;
    private zbtc zbg = zbtc.zbb;

    static {
        zbfl zbflVar = new zbfl();
        zbb = zbflVar;
        zbuf.zbD(zbfl.class, zbflVar);
    }

    private zbfl() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ခ\u0000\u0002ဇ\u0001\u0003ည\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbfl();
        }
        zbfj zbfjVar = null;
        if (i2 == 4) {
            return new zbfk(zbfjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
