package com.google.android.gms.internal.nearby;

import android.os.SystemClock;
import androidx.compose.animation.core.AnimationKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzwk extends zzxt {
    zzwk() {
    }

    @Override // com.google.android.gms.internal.nearby.zzxt
    public final long zza() {
        return SystemClock.elapsedRealtime() * AnimationKt.MillisToNanos;
    }
}
