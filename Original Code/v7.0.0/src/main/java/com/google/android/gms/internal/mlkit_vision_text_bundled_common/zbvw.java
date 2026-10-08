package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbvw implements zbvj {
    private final zbvm zba;
    private final String zbb;
    private final Object[] zbc;
    private final int zbd;

    zbvw(zbvm zbvmVar, String str, Object[] objArr) {
        this.zba = zbvmVar;
        this.zbb = str;
        this.zbc = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.zbd = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 1;
        int i3 = 13;
        while (true) {
            int i4 = i2 + 1;
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 < 55296) {
                this.zbd = i | (cCharAt2 << i3);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i2 = i4;
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvj
    public final zbvm zba() {
        return this.zba;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvj
    public final boolean zbb() {
        return (this.zbd & 2) == 2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvj
    public final int zbc() {
        int i = this.zbd;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }

    final String zbd() {
        return this.zbb;
    }

    final Object[] zbe() {
        return this.zbc;
    }
}
