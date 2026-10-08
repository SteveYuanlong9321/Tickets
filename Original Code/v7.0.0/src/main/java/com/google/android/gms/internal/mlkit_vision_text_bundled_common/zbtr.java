package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbtr extends zbtq {
    zbtr() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtq
    final void zba(Object obj) {
        ((zbub) obj).zbb.zbh();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtq
    final void zbb(zbwy zbwyVar, Map.Entry entry) throws IOException {
        zbww zbwwVar = zbww.DOUBLE;
        switch (r3.zbb) {
            case DOUBLE:
                zbwyVar.zbf(32149011, ((Double) entry.getValue()).doubleValue());
                break;
            case FLOAT:
                zbwyVar.zbo(32149011, ((Float) entry.getValue()).floatValue());
                break;
            case INT64:
                zbwyVar.zbt(32149011, ((Long) entry.getValue()).longValue());
                break;
            case UINT64:
                zbwyVar.zbL(32149011, ((Long) entry.getValue()).longValue());
                break;
            case INT32:
                zbwyVar.zbr(32149011, ((Integer) entry.getValue()).intValue());
                break;
            case FIXED64:
                zbwyVar.zbm(32149011, ((Long) entry.getValue()).longValue());
                break;
            case FIXED32:
                zbwyVar.zbk(32149011, ((Integer) entry.getValue()).intValue());
                break;
            case BOOL:
                zbwyVar.zbb(32149011, ((Boolean) entry.getValue()).booleanValue());
                break;
            case STRING:
                zbwyVar.zbH(32149011, (String) entry.getValue());
                break;
            case GROUP:
                zbwyVar.zbq(32149011, entry.getValue(), zbvu.zba().zbb(entry.getValue().getClass()));
                break;
            case MESSAGE:
                zbwyVar.zbw(32149011, entry.getValue(), zbvu.zba().zbb(entry.getValue().getClass()));
                break;
            case BYTES:
                zbwyVar.zbd(32149011, (zbtc) entry.getValue());
                break;
            case UINT32:
                zbwyVar.zbJ(32149011, ((Integer) entry.getValue()).intValue());
                break;
            case ENUM:
                zbwyVar.zbr(32149011, ((Integer) entry.getValue()).intValue());
                break;
            case SFIXED32:
                zbwyVar.zby(32149011, ((Integer) entry.getValue()).intValue());
                break;
            case SFIXED64:
                zbwyVar.zbA(32149011, ((Long) entry.getValue()).longValue());
                break;
            case SINT32:
                zbwyVar.zbC(32149011, ((Integer) entry.getValue()).intValue());
                break;
            case SINT64:
                zbwyVar.zbE(32149011, ((Long) entry.getValue()).longValue());
                break;
        }
    }
}
