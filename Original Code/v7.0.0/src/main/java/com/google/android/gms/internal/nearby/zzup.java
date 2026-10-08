package com.google.android.gms.internal.nearby;

import android.os.Build;
import android.os.Trace;
import java.util.ArrayDeque;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzup {
    public static final /* synthetic */ int zzb = 0;
    private static final zzyl zzc = zzyl.zzk("androidx.fragment.app.FragmentViewLifecycleOwner.handleLifecycleEvent", "com.google.android.libraries.logging.logger.transmitters.clearcut", "com.google.android.libraries.performance.primes.transmitter.clearcut", "com.google.android.libraries.performance.primes.metrics.crash.CrashMetricServiceImpl", "com.google.android.libraries.performance.primes.metrics.crash.applicationexit.ApplicationExitMetricServiceImpl", "com.google.apps.tiktok.tracing.contrib.mdd.MddTraceFlush", new String[0]);
    private static final AtomicReference zzd = new AtomicReference(zzyl.zzh());
    static final zzqa zza = new zzqa("tiktok_systrace");
    private static final WeakHashMap zze = new WeakHashMap();
    private static final zzuo zzf = new zzuo();

    static {
        new ArrayDeque();
        new ArrayDeque();
    }

    static zzyl zza() {
        return (zzyl) zzd.get();
    }

    static zzvj zzb(boolean z) {
        zzvh zzvhVarZzd = zzd();
        zzvj zzvjVar = zzvhVarZzd.zzb;
        return (zzvjVar == null || zzvjVar == zzux.zza) ? zzuu.zzi(zzvhVarZzd) : zzvjVar;
    }

    public static zzvj zzc(zzvh zzvhVar, zzvj zzvjVar) {
        zzug zzugVar = zzvhVar.zzc;
        zzvj zzvjVar2 = zzvhVar.zzb;
        if (zzvjVar2 != zzvjVar) {
            if (zzvjVar2 == null) {
                zzvhVar.zza = Build.VERSION.SDK_INT >= 29 ? Trace.isEnabled() : zzqe.zza(zza);
            }
            if (zzvhVar.zza) {
                zzvi.zza(zzvjVar2, zzvjVar);
            }
            if (zzvjVar2 != zzvjVar) {
                zzvhVar.zzb = zzvjVar;
                return zzvjVar2;
            }
        }
        return zzvjVar;
    }

    public static zzvh zzd() {
        return (zzvh) zzf.get();
    }
}
