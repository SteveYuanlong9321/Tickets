package com.google.android.gms.internal.nearby;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzagn extends zzagp {
    public static zzagx zza(Object obj) {
        return obj == null ? zzags.zza : new zzags(obj);
    }

    public static zzagx zzb() {
        return zzags.zza;
    }

    public static zzagx zzc(Throwable th) {
        return new zzagr(th);
    }

    public static zzagx zzd() {
        zzagq zzagqVar = zzagq.zza;
        return zzagqVar != null ? zzagqVar : new zzagq();
    }

    public static zzagx zze(Callable callable, Executor executor) {
        zzaho zzahoVar = new zzaho(callable);
        executor.execute(zzahoVar);
        return zzahoVar;
    }

    public static zzagx zzf(zzafp zzafpVar, Executor executor) {
        zzaho zzahoVar = new zzaho(zzafpVar);
        executor.execute(zzahoVar);
        return zzahoVar;
    }

    public static zzagx zzg(zzagx zzagxVar, Class cls, zzwx zzwxVar, Executor executor) {
        int i = zzafa.zzd;
        zzaez zzaezVar = new zzaez(zzagxVar, cls, zzwxVar);
        zzagxVar.zzl(zzaezVar, zzahg.zzd(executor, zzaezVar));
        return zzaezVar;
    }

    public static zzagx zzh(zzagx zzagxVar, Class cls, zzafq zzafqVar, Executor executor) {
        int i = zzafa.zzd;
        zzaey zzaeyVar = new zzaey(zzagxVar, cls, zzafqVar);
        zzagxVar.zzl(zzaeyVar, zzahg.zzd(executor, zzaeyVar));
        return zzaeyVar;
    }

    public static zzagx zzi(zzagx zzagxVar, zzafq zzafqVar, Executor executor) {
        int i = zzafh.zzc;
        zzaff zzaffVar = new zzaff(zzagxVar, zzafqVar);
        zzagxVar.zzl(zzaffVar, zzahg.zzd(executor, zzaffVar));
        return zzaffVar;
    }

    public static zzagx zzj(zzagx zzagxVar, zzwx zzwxVar, Executor executor) {
        int i = zzafh.zzc;
        zzafg zzafgVar = new zzafg(zzagxVar, zzwxVar);
        zzagxVar.zzl(zzafgVar, zzahg.zzd(executor, zzafgVar));
        return zzafgVar;
    }

    public static zzagl zzk(Iterable iterable) {
        return new zzagl(false, zzyg.zzr(iterable), null);
    }

    public static zzagl zzl(Iterable iterable) {
        return new zzagl(true, zzyg.zzr(iterable), null);
    }

    public static zzagx zzm(zzagx zzagxVar) {
        if (zzagxVar.isDone()) {
            return zzagxVar;
        }
        zzagm zzagmVar = new zzagm(zzagxVar);
        zzagxVar.zzl(zzagmVar, zzafx.INSTANCE);
        return zzagmVar;
    }

    public static Object zzn(Future future) throws ExecutionException {
        if (future.isDone()) {
            return zzahp.zza(future);
        }
        throw new IllegalStateException(zzxm.zzd("Future was expected to be done: %s", future));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzq(zzagx zzagxVar, Future future) {
        if (zzagxVar instanceof zzafb) {
            ((zzafb) zzagxVar).zzn(future);
        } else {
            if (zzagxVar == null || !zzagxVar.isCancelled() || future == null) {
                return;
            }
            future.cancel(false);
        }
    }

    public static void zzo(zzagx zzagxVar, Future future) {
        zzagxVar.getClass();
        if (future.isDone()) {
            return;
        }
        if (zzagxVar.isDone()) {
            zzq(zzagxVar, future);
            return;
        }
        zzagk zzagkVar = new zzagk(zzagxVar, future);
        zzafx zzafxVar = zzafx.INSTANCE;
        zzagxVar.zzl(zzagkVar, zzafxVar);
        ((zzagx) future).zzl(zzagkVar, zzafxVar);
    }
}
