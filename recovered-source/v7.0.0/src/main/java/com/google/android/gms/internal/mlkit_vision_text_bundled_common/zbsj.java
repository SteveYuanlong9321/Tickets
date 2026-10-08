package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsi;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsj;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zbsj<MessageType extends zbsj<MessageType, BuilderType>, BuilderType extends zbsi<MessageType, BuilderType>> implements zbvm {
    protected int zba = 0;

    int zbj(zbvx zbvxVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvm
    public final zbtc zbk() {
        try {
            int iZbo = zbo();
            zbtc zbtcVar = zbtc.zbb;
            byte[] bArr = new byte[iZbo];
            zbth zbthVar = new zbth(bArr, 0, iZbo);
            zbL(zbthVar);
            return zbsy.zba(zbthVar, bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final byte[] zbl() {
        try {
            int iZbo = zbo();
            byte[] bArr = new byte[iZbo];
            zbth zbthVar = new zbth(bArr, 0, iZbo);
            zbL(zbthVar);
            zbthVar.zbF();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
