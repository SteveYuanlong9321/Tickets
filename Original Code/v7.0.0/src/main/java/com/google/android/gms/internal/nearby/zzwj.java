package com.google.android.gms.internal.nearby;

import android.os.SystemClock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzwj extends zzxt {
    zzwj() {
    }

    @Override // com.google.android.gms.internal.nearby.zzxt
    public final long zza() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
