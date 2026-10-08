package com.google.android.gms.internal.nearby;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzu implements ThreadFactory {
    private final ThreadFactory zza = Executors.defaultThreadFactory();

    private zzu() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.zza.newThread(runnable);
        if (threadNewThread == null) {
            throw new NullPointerException("Default ThreadFactory returned null thread");
        }
        String name = threadNewThread.getName();
        String.valueOf(name);
        threadNewThread.setName("punch".concat(String.valueOf(name)));
        return threadNewThread;
    }

    /* synthetic */ zzu(byte[] bArr) {
    }
}
