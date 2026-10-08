package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbaje extends zbuf implements zbvn {
    private static final zbaje zbb;
    private zbun zbd = zby();

    static {
        zbaje zbajeVar = new zbaje();
        zbb = zbajeVar;
        zbuf.zbD(zbaje.class, zbajeVar);
    }

    private zbaje() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zbd", zbajb.class});
        }
        if (i2 == 3) {
            return new zbaje();
        }
        zbajc zbajcVar = null;
        if (i2 == 4) {
            return new zbajd(zbajcVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
