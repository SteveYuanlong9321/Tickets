package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjt {
    public static final zzvz zza(Context context) throws zzwe, zzwf, zzwg, zzwi {
        System.loadLibrary("arcore_sdk_jni");
        try {
            Object objZza = zzx.zza(zzvz.class, "nativeCreateSessionAndWrapperWithFeatures", zzw.zza(Context.class, context), zzw.zza(int[].class, new int[]{6, 0}));
            if (objZza == null) {
                throw new AssertionError("Failed to create ArCore session: nativeCreateSessionAndWrapperWithFeatures returned null");
            }
            Long l = (Long) objZza;
            l.longValue();
            Constructor declaredConstructor = zzvz.class.getDeclaredConstructor(Long.TYPE);
            declaredConstructor.setAccessible(true);
            zzvz zzvzVar = (zzvz) declaredConstructor.newInstance(l);
            zzx.zza(zzvz.class, "loadDynamicSymbolsAfterSessionCreate", new zzw[0]);
            return zzvzVar;
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause instanceof zzwf) {
                throw ((zzwf) cause);
            }
            if (cause instanceof zzwe) {
                throw ((zzwe) cause);
            }
            if (cause instanceof zzwi) {
                throw ((zzwi) cause);
            }
            if (cause instanceof zzwg) {
                throw ((zzwg) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new AssertionError("Failed to create ArCore session: ", e);
        } catch (ReflectiveOperationException e2) {
            throw new LinkageError("Failed to create ArCore session: ", e2);
        }
    }

    static void zzb() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        if (eGLDisplayEglGetDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
            throw new zzjq("Unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            throw new zzjq("Unable to initialize EGL14");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(eGLDisplayEglGetDisplay, new int[]{12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            throw new zzjq("Unable to find EGL config");
        }
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplayEglGetDisplay, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        zzc("eglCreateContext");
        if (eGLContextEglCreateContext == null) {
            throw new zzjq("Null EGL context");
        }
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplayEglGetDisplay, eGLConfigArr[0], new int[]{12344}, 0);
        zzc("eglCreatePbufferSurface");
        if (eGLSurfaceEglCreatePbufferSurface == null) {
            throw new zzjq("Pbuffer surface was null");
        }
        if (!EGL14.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglCreateContext)) {
            throw new zzjq("eglMakeCurrent failed");
        }
    }

    private static void zzc(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        int length = str.length();
        String hexString = Integer.toHexString(iEglGetError);
        StringBuilder sb = new StringBuilder(length + 15 + String.valueOf(hexString).length());
        sb.append(str);
        sb.append(": EGL error: 0x");
        sb.append(hexString);
        throw new zzjq(sb.toString());
    }
}
