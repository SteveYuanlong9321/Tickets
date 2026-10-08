package com.google.android.gms.internal.nearby;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzjv implements Callable {
    static final /* synthetic */ zzjv zza = new zzjv();

    private /* synthetic */ zzjv() {
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        int i = zzjz.zza;
        EGLContext eGLContextEglGetCurrentContext = EGL14.eglGetCurrentContext();
        boolean z = false;
        if (eGLContextEglGetCurrentContext != null && !eGLContextEglGetCurrentContext.equals(EGL14.EGL_NO_CONTEXT)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
