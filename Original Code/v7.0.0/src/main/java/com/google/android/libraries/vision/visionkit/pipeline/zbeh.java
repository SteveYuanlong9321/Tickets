package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbeh extends zbuf implements zbvn {
    private static final zbeh zbb;
    private int zbd;
    private zbeg zbe;

    static {
        zbeh zbehVar = new zbeh();
        zbb = zbehVar;
        zbuf.zbD(zbeh.class, zbehVar);
    }

    private zbeh() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new zbeh();
        }
        zbed zbedVar = null;
        if (i2 == 4) {
            return new zbee(zbedVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
