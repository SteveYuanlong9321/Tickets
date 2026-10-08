package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbaac extends zbub implements zbvn {
    private static final zbaac zbd;
    private int zbe;
    private int zbf;
    private byte zbg = 2;

    static {
        zbaac zbaacVar = new zbaac();
        zbd = zbaacVar;
        zbuf.zbD(zbaac.class, zbaacVar);
    }

    private zbaac() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbg);
        }
        if (i2 == 2) {
            return zbA(zbd, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zbe", "zbf", zbaab.zba});
        }
        if (i2 == 3) {
            return new zbaac();
        }
        zbzz zbzzVar = null;
        if (i2 == 4) {
            return new zbaaa(zbzzVar);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
