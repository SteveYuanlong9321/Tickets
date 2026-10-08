package com.google.android.gms.internal.nearby;

import android.os.SystemClock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzwl {
    private static final zzxt zza;

    static {
        zzxt zzwkVar;
        try {
            SystemClock.elapsedRealtimeNanos();
            zzwkVar = new zzwj();
        } catch (Throwable unused) {
            SystemClock.elapsedRealtime();
            zzwkVar = new zzwk();
        }
        zza = zzwkVar;
    }

    public static zzxt zza() {
        return zza;
    }
}
