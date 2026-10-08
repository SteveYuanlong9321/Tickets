package com.google.android.gms.internal.nearby;

import android.opengl.GLES20;
import java.util.Objects;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzjy implements ThreadFactory {
    final /* synthetic */ zzjz zza;

    zzjy(zzjz zzjzVar) {
        Objects.requireNonNull(zzjzVar);
        this.zza = zzjzVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(final Runnable runnable) {
        return new Thread(new Runnable() { // from class: com.google.android.gms.internal.nearby.zzjx
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzjy zzjyVar = this.zza;
                try {
                    zzjt.zzb();
                    zzvz zzvzVarZzg = zzjyVar.zza.zzg();
                    int[] iArr = new int[1];
                    GLES20.glGenTextures(1, iArr, 0);
                    GLES20.glBindTexture(36197, iArr[0]);
                    zzvzVarZzg.zzd(iArr[0]);
                } catch (zzjq e) {
                    int i = zzjz.zza;
                    zzjz.zzb.e("Failed to attach OpenGL context", e, new Object[0]);
                }
                runnable.run();
            }
        });
    }
}
