package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbrg extends zbuf implements zbvn {
    private static final zbrg zbb;
    private int zbd;
    private int zbe;
    private float zbg;
    private byte zbh = 2;
    private zbul zbf = zbw();

    static {
        zbrg zbrgVar = new zbrg();
        zbb = zbrgVar;
        zbuf.zbD(zbrg.class, zbrgVar);
    }

    private zbrg() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbh);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001ᔄ\u0000\u0002ᔁ\u0001\u0003\u0016", new Object[]{"zbd", "zbe", "zbg", "zbf"});
        }
        if (i2 == 3) {
            return new zbrg();
        }
        zbpu zbpuVar = null;
        if (i2 == 4) {
            return new zbrf(zbpuVar);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
