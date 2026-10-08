package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbaw extends zbuf implements zbvn {
    private static final zbaw zbb;
    private int zbd;
    private float zbe = 50.0f;
    private int zbf = 1;

    static {
        zbaw zbawVar = new zbaw();
        zbb = zbawVar;
        zbuf.zbD(zbaw.class, zbawVar);
    }

    private zbaw() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ခ\u0000\u0002င\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbaw();
        }
        zbau zbauVar = null;
        if (i2 == 4) {
            return new zbav(zbauVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
