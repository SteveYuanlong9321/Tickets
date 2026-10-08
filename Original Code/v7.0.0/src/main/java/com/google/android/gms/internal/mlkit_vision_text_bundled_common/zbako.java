package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbako extends zbuf implements zbvn {
    private static final zbako zbb;
    private int zbd;
    private zbaku zbe;
    private zbalj zbf;
    private zbakl zbg;
    private zbajq zbh;
    private zbaje zbi;
    private zbald zbj;
    private zbajw zbk;

    static {
        zbako zbakoVar = new zbako();
        zbb = zbakoVar;
        zbuf.zbD(zbako.class, zbakoVar);
    }

    private zbako() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk"});
        }
        if (i2 == 3) {
            return new zbako();
        }
        zbakm zbakmVar = null;
        if (i2 == 4) {
            return new zbakn(zbakmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
