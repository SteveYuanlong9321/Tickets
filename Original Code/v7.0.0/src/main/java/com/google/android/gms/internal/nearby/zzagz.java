package com.google.android.gms.internal.nearby;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticBackport0;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public interface zzagz extends ExecutorService, AutoCloseable {
    @Override // java.lang.AutoCloseable
    /* synthetic */ default void close() {
        ImageAnalysis$$ExternalSyntheticBackport0.m((ExecutorService) this);
    }

    @Override // java.util.concurrent.ExecutorService, com.google.android.gms.internal.nearby.zzagz
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    zzagx submit(Runnable runnable);

    @Override // java.util.concurrent.ExecutorService, com.google.android.gms.internal.nearby.zzagz
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    zzagx submit(Runnable runnable, Object obj);

    @Override // java.util.concurrent.ExecutorService, com.google.android.gms.internal.nearby.zzagz
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    zzagx submit(Callable callable);
}
