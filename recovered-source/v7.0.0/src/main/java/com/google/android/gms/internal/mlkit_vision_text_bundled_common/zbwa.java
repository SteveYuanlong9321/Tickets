package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbwa extends zbwh {
    zbwa() {
        super(null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwh
    public final void zba() {
        if (!zbj()) {
            for (int i = 0; i < zbc(); i++) {
                ((zbtt) ((zbwb) zbg(i)).zba()).zbg();
            }
            Iterator it = zbd().iterator();
            while (it.hasNext()) {
                ((zbtt) ((Map.Entry) it.next()).getKey()).zbg();
            }
        }
        super.zba();
    }
}
