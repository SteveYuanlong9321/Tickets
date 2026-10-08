package com.google.android.gms.internal.nearby;

import android.os.SystemClock;
import androidx.compose.animation.core.AnimationKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzka {
    private static final boolean zza;

    static {
        boolean z;
        try {
            SystemClock.elapsedRealtimeNanos();
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        zza = z;
    }

    static long zza() {
        return zza ? SystemClock.elapsedRealtimeNanos() : SystemClock.elapsedRealtime() * AnimationKt.MillisToNanos;
    }
}
