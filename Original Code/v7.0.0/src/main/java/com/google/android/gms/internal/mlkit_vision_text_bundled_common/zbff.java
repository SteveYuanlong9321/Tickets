package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbff extends zbuf implements zbvn {
    private static final zbff zbb;
    private int zbd;
    private float zbe;

    static {
        zbff zbffVar = new zbff();
        zbb = zbffVar;
        zbuf.zbD(zbff.class, zbffVar);
    }

    private zbff() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ခ\u0000", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new zbff();
        }
        zbfd zbfdVar = null;
        if (i2 == 4) {
            return new zbfe(zbfdVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
