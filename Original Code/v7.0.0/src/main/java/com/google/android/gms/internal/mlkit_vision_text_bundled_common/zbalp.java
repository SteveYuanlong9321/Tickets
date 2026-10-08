package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbalp extends zbuf implements zbvn {
    private static final zbalp zbb;
    private int zbd;
    private zbhl zbe;
    private zbxb zbf;

    static {
        zbalp zbalpVar = new zbalp();
        zbb = zbalpVar;
        zbuf.zbD(zbalp.class, zbalpVar);
    }

    private zbalp() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbalp();
        }
        zbaln zbalnVar = null;
        if (i2 == 4) {
            return new zbalo(zbalnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
