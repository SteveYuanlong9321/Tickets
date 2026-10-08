package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbaff extends zbuf implements zbvn {
    private static final zbaff zbb;
    private zbun zbd = zby();

    static {
        zbaff zbaffVar = new zbaff();
        zbb = zbaffVar;
        zbuf.zbD(zbaff.class, zbaffVar);
    }

    private zbaff() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zbd", zbafd.class});
        }
        if (i2 == 3) {
            return new zbaff();
        }
        zbafb zbafbVar = null;
        if (i2 == 4) {
            return new zbafe(zbafbVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
