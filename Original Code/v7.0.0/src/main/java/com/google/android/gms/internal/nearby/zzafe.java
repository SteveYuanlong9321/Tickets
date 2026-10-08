package com.google.android.gms.internal.nearby;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticBackport0;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzafe extends AbstractExecutorService implements zzagz, AutoCloseable {
    protected zzafe() {
    }

    @Override // com.google.android.gms.internal.nearby.zzagz, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        ImageAnalysis$$ExternalSyntheticBackport0.m((ExecutorService) this);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return zzaho.zzf(runnable, obj);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.google.android.gms.internal.nearby.zzagz
    public final /* synthetic */ Future submit(Runnable runnable) {
        return (zzagx) super.submit(runnable);
    }

    @Override // com.google.android.gms.internal.nearby.zzagz
    /* JADX INFO: renamed from: zza */
    public final zzagx submit(Runnable runnable) {
        return (zzagx) super.submit(runnable);
    }

    @Override // com.google.android.gms.internal.nearby.zzagz
    /* JADX INFO: renamed from: zzb */
    public final zzagx submit(Runnable runnable, Object obj) {
        return (zzagx) super.submit(runnable, obj);
    }

    @Override // com.google.android.gms.internal.nearby.zzagz
    /* JADX INFO: renamed from: zzc */
    public final zzagx submit(Callable callable) {
        return (zzagx) super.submit(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final RunnableFuture newTaskFor(Callable callable) {
        return new zzaho(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.google.android.gms.internal.nearby.zzagz
    public final /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return (zzagx) super.submit(runnable, obj);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.google.android.gms.internal.nearby.zzagz
    public final /* synthetic */ Future submit(Callable callable) {
        return (zzagx) super.submit(callable);
    }
}
