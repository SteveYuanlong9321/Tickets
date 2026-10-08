package com.google.android.gms.internal.nearby;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticBackport0;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzjs extends AbstractExecutorService implements ScheduledExecutorService, AutoCloseable {
    private final Executor zza;
    private final ScheduledExecutorService zzb = Executors.newSingleThreadScheduledExecutor();

    zzjs(Executor executor) {
        this.zza = executor;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.zzb.awaitTermination(j, timeUnit);
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        ImageAnalysis$$ExternalSyntheticBackport0.m((ExecutorService) this);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zza.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.zzb.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.zzb.isTerminated();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(final Runnable runnable, long j, TimeUnit timeUnit) {
        return this.zzb.schedule(new Runnable() { // from class: com.google.android.gms.internal.nearby.zzjr
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zza(runnable);
            }
        }, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.zzb.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        return this.zzb.shutdownNow();
    }

    final /* synthetic */ void zza(Runnable runnable) {
        this.zza.execute(runnable);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
