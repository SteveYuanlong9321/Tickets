package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbld extends zbkx {
    static final zbkx zba = new zbld(new Object[0], 0);
    final transient Object[] zbb;
    private final transient int zbc;

    zbld(Object[] objArr, int i) {
        this.zbb = objArr;
        this.zbc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zbkj.zba(i, this.zbc, "index");
        return Objects.requireNonNull(this.zbb[i]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zbc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkx, com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkt
    final int zba(Object[] objArr, int i) {
        System.arraycopy(this.zbb, 0, objArr, 0, this.zbc);
        return this.zbc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkt
    final int zbb() {
        return this.zbc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkt
    final int zbc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkt
    final Object[] zbe() {
        return this.zbb;
    }
}
