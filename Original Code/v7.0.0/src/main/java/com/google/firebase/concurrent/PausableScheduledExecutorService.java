package com.google.firebase.concurrent;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticBackport0;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public interface PausableScheduledExecutorService extends ScheduledExecutorService, PausableExecutorService, AutoCloseable {
    @Override // com.google.firebase.concurrent.PausableExecutorService, java.lang.AutoCloseable
    /* synthetic */ default void close() {
        ImageAnalysis$$ExternalSyntheticBackport0.m((ExecutorService) this);
    }
}
