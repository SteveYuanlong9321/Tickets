package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbkv extends zbkq {
    private final zbkx zba;

    zbkv(zbkx zbkxVar, int i) {
        super(zbkxVar.size(), i);
        this.zba = zbkxVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkq
    protected final Object zba(int i) {
        return this.zba.get(i);
    }
}
