package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbku extends zbkr {
    public zbku() {
        super(4);
    }

    public final zbku zba(Object obj) {
        int i = this.zbb;
        int i2 = i + 1;
        Object[] objArr = this.zba;
        int length = objArr.length;
        if (length < i2) {
            int i3 = length + (length >> 1) + 1;
            if (i3 < i2) {
                int iHighestOneBit = Integer.highestOneBit(i);
                i3 = iHighestOneBit + iHighestOneBit;
            }
            if (i3 < 0) {
                i3 = Integer.MAX_VALUE;
            }
            this.zba = Arrays.copyOf(objArr, i3);
            this.zbc = false;
        } else if (this.zbc) {
            this.zba = (Object[]) objArr.clone();
            this.zbc = false;
        }
        Object[] objArr2 = this.zba;
        int i4 = this.zbb;
        this.zbb = i4 + 1;
        objArr2[i4] = obj;
        return this;
    }

    public final zbkx zbb() {
        this.zbc = true;
        return zbkx.zbg(this.zba, this.zbb);
    }
}
