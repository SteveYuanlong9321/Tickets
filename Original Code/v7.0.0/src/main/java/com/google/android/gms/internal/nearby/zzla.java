package com.google.android.gms.internal.nearby;

import java.util.concurrent.Executor;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzla {
    public static final void zza(Level level, Executor executor, String str, Object... objArr) {
        zzc(level, executor, null, str, objArr);
    }

    public static final void zzb(Level level, Executor executor, Throwable th, String str, Object... objArr) {
        zzc(level, executor, th, str, objArr);
    }

    private static final void zzc(final Level level, Executor executor, final Throwable th, final String str, final Object... objArr) {
        executor.execute(zzvr.zza(new Runnable() { // from class: com.google.android.gms.internal.nearby.zzkz
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                ((zzzu) ((zzzu) zzky.zza.zze(level).zzo(th)).zzn("com/google/android/libraries/phenotype/client/Phlogger", "logInternal", 44, "Phlogger.java")).zzp(str, objArr);
            }
        }));
    }
}
