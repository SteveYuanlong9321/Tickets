package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbaht extends zbuf implements zbvn {
    private static final zbaht zbb;
    private int zbd = 0;
    private Object zbe;
    private int zbf;
    private float zbg;

    static {
        zbaht zbahtVar = new zbaht();
        zbb = zbahtVar;
        zbuf.zbD(zbaht.class, zbahtVar);
    }

    private zbaht() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0002\u0001\u0003?\u0000\u0004Ȼ\u0000", new Object[]{"zbe", "zbd", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbaht();
        }
        zbagx zbagxVar = null;
        if (i2 == 4) {
            return new zbahs(zbagxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
