package com.google.android.libraries.vision.visionkit.pipeline;

import android.content.Context;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidAssetUtil {
    private static native boolean nativeInitializeAssetManager(Context context, String str);

    public static synchronized boolean zba(Context context) {
        return nativeInitializeAssetManager(context, context.getCacheDir().getAbsolutePath());
    }
}
