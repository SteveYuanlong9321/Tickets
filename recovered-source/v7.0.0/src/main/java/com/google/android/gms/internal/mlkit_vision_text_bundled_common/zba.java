package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public class zba implements IInterface {
    private final IBinder zba;

    protected zba(IBinder iBinder, String str) {
        this.zba = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zba;
    }
}
