package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbqk extends zbuf implements zbvn {
    private static final zbqk zbb;
    private int zbd;
    private zbqm zbe;
    private float zbf;
    private byte zbh = 2;
    private zbuk zbg = zbv();

    static {
        zbqk zbqkVar = new zbqk();
        zbb = zbqkVar;
        zbuf.zbD(zbqk.class, zbqkVar);
    }

    private zbqk() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbh);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001ᐉ\u0000\u0002ခ\u0001\u0003\u0013", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbqk();
        }
        zbpu zbpuVar = null;
        if (i2 == 4) {
            return new zbqj(zbpuVar);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
