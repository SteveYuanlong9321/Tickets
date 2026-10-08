package com.google.firebase.concurrent;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticBackport0;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public interface PausableExecutorService extends ExecutorService, PausableExecutor, AutoCloseable {
    @Override // java.lang.AutoCloseable
    /* synthetic */ default void close() {
        ImageAnalysis$$ExternalSyntheticBackport0.m((ExecutorService) this);
    }
}
