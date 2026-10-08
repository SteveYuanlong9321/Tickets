package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbajb extends zbuf implements zbvn {
    private static final zbajb zbb;
    private String zbd = "";
    private zbun zbe = zby();

    static {
        zbajb zbajbVar = new zbajb();
        zbb = zbajbVar;
        zbuf.zbD(zbajb.class, zbajbVar);
    }

    private zbajb() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zbd", "zbe", zbajh.class});
        }
        if (i2 == 3) {
            return new zbajb();
        }
        zbaiz zbaizVar = null;
        if (i2 == 4) {
            return new zbaja(zbaizVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
