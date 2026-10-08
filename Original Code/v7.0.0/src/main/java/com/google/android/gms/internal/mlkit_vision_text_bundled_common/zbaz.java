package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbaz extends zbub implements zbvn {
    private static final zbaz zbd;
    private byte zbe = 2;

    static {
        zbaz zbazVar = new zbaz();
        zbd = zbazVar;
        zbuf.zbD(zbaz.class, zbazVar);
    }

    private zbaz() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbe);
        }
        zbax zbaxVar = null;
        if (i2 == 2) {
            return zbA(zbd, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new zbaz();
        }
        if (i2 == 4) {
            return new zbay(zbaxVar);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbe = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
