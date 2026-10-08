package com.google.mlkit.vision.text.pipeline;

import android.os.RemoteException;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zbo {
    static zbo zbc(int i, RemoteException remoteException) {
        return new zbb(i, zbki.zbe(remoteException));
    }

    public abstract int zba();

    public abstract zbki zbb();

    public final boolean zbd() {
        return !zbb().zbc();
    }
}
