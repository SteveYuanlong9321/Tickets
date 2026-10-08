package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbkl extends zbkn {
    final /* synthetic */ zbkm zba;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zbkl(zbkm zbkmVar, zbko zbkoVar, CharSequence charSequence) {
        super(zbkoVar, charSequence);
        this.zba = zbkmVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkn
    public final int zbc(int i) {
        return i + this.zba.zba.length();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkn
    public final int zbd(int i) {
        int length = this.zbb.length();
        int length2 = this.zba.zba.length();
        int i2 = length - length2;
        while (i <= i2) {
            for (int i3 = 0; i3 < length2; i3++) {
                if (this.zbb.charAt(i3 + i) != this.zba.zba.charAt(i3)) {
                    i++;
                }
            }
            return i;
        }
        return -1;
    }
}
