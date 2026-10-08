package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbgc extends zbuf implements zbvn {
    private static final zbgc zbb;
    private int zbd;
    private int zbe;
    private int zbf;

    static {
        zbgc zbgcVar = new zbgc();
        zbb = zbgcVar;
        zbuf.zbD(zbgc.class, zbgcVar);
    }

    private zbgc() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbgc();
        }
        zbfy zbfyVar = null;
        if (i2 == 4) {
            return new zbgb(zbfyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
