package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbcn extends zbuf implements zbvn {
    private static final zbcn zbb;
    private int zbd;
    private Object zbf;
    private int zbe = 0;
    private String zbg = "";

    static {
        zbcn zbcnVar = new zbcn();
        zbb = zbcnVar;
        zbuf.zbD(zbcn.class, zbcnVar);
    }

    private zbcn() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    protected final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u00025\u0000\u0003<\u0000", new Object[]{"zbf", "zbe", "zbd", "zbg", zbcm.class});
        }
        if (i2 == 3) {
            return new zbcn();
        }
        zbcg zbcgVar = null;
        if (i2 == 4) {
            return new zbci(zbcgVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
