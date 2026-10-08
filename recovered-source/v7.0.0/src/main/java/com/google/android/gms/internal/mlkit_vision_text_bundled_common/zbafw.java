package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbafw extends zbuf implements zbvn {
    private static final zbafw zbb;
    private int zbd = 0;
    private Object zbe;

    static {
        zbafw zbafwVar = new zbafw();
        zbb = zbafwVar;
        zbuf.zbD(zbafw.class, zbafwVar);
    }

    private zbafw() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001;\u0000\u0002=\u0000", new Object[]{"zbe", "zbd"});
        }
        if (i2 == 3) {
            return new zbafw();
        }
        zbafu zbafuVar = null;
        if (i2 == 4) {
            return new zbafv(zbafuVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
