package com.google.android.gms.internal.nearby;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzafb<V> extends zzafc<V> {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    final class zza {
        static final zza zza;
        static final zza zzb;
        final boolean zzc;
        final Throwable zzd;

        static {
            if (zzafc.zzg) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zza(false, null);
                zza = new zza(true, null);
            }
        }

        zza(boolean z, Throwable th) {
            this.zzc = z;
            this.zzd = th;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    final class zzb<V> implements Runnable {
        final zzafb<V> zza;
        final zzagx<? extends V> zzb;

        zzb(zzafb zzafbVar, zzagx zzagxVar) {
            this.zza = zzafbVar;
            this.zzb = zzagxVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.zza.valueField != this) {
                return;
            }
            if (zzafc.zzs(this.zza, this, zzafb.zzf(this.zzb))) {
                zzafb.zzx(this.zza, false);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.nearby.zzafb.zzc.1
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        zzc(Throwable th) {
            th.getClass();
            this.zzb = th;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    final class zzd {
        static final zzd zza = new zzd();
        zzd next;
        final Runnable zzb;
        final Executor zzc;

        zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    interface zze<V> extends zzagx<V> {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    abstract class zzf<V> extends zzafb<V> implements zze<V> {
        zzf() {
        }
    }

    protected zzafb() {
    }

    private static Object zzA(Object obj) {
        return obj == null ? zze : obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object zzf(zzagx zzagxVar) {
        Throwable thZzm;
        if (zzagxVar instanceof zze) {
            Object zzaVar = ((zzafb) zzagxVar).valueField;
            if (zzaVar instanceof zza) {
                zza zzaVar2 = (zza) zzaVar;
                if (zzaVar2.zzc) {
                    Throwable th = zzaVar2.zzd;
                    zzaVar = th != null ? new zza(false, th) : zza.zzb;
                }
            }
            return Objects.requireNonNull(zzaVar);
        }
        if ((zzagxVar instanceof zzahq) && (thZzm = ((zzahq) zzagxVar).zzm()) != null) {
            return new zzc(thZzm);
        }
        boolean zIsCancelled = zzagxVar.isCancelled();
        if ((!zzg) && zIsCancelled) {
            return Objects.requireNonNull(zza.zzb);
        }
        try {
            Object objZzg = zzg(zzagxVar);
            if (!zIsCancelled) {
                return zzA(objZzg);
            }
            String strValueOf = String.valueOf(zzagxVar);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 84);
            sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
            sb.append(strValueOf);
            return new zza(false, new IllegalArgumentException(sb.toString()));
        } catch (Error | Exception e) {
            return new zzc(e);
        } catch (CancellationException e2) {
            if (zIsCancelled) {
                return new zza(false, e2);
            }
            String strValueOf2 = String.valueOf(zzagxVar);
            String.valueOf(strValueOf2);
            return new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(strValueOf2)), e2));
        } catch (ExecutionException e3) {
            if (!zIsCancelled) {
                return new zzc(e3.getCause());
            }
            String strValueOf3 = String.valueOf(zzagxVar);
            String.valueOf(strValueOf3);
            return new zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(strValueOf3)), e3));
        }
    }

    private static Object zzg(Future future) throws ExecutionException {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    static Object zzh(Object obj) throws ExecutionException {
        if (obj instanceof zza) {
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(((zza) obj).zzd);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        }
        if (obj == zze) {
            return null;
        }
        return obj;
    }

    static boolean zzi(Object obj) {
        return !(obj instanceof zzb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzx(zzafb zzafbVar, boolean z) {
        zzd zzdVar = null;
        while (true) {
            zzafbVar.zzt();
            if (z) {
                zzafbVar.zzj();
            }
            zzafbVar.zzc();
            zzd zzdVar2 = zzdVar;
            zzd zzdVarZzr = zzafbVar.zzr(zzd.zza);
            zzd zzdVar3 = zzdVar2;
            while (zzdVarZzr != null) {
                zzd zzdVar4 = zzdVarZzr.next;
                zzdVarZzr.next = zzdVar3;
                zzdVar3 = zzdVarZzr;
                zzdVarZzr = zzdVar4;
            }
            while (zzdVar3 != null) {
                Runnable runnable = zzdVar3.zzb;
                zzdVar = zzdVar3.next;
                Runnable runnable2 = (Runnable) Objects.requireNonNull(runnable);
                if (runnable2 instanceof zzb) {
                    zzb zzbVar = (zzb) runnable2;
                    zzafbVar = zzbVar.zza;
                    if (zzafbVar.valueField == zzbVar && zzs(zzafbVar, zzbVar, zzf(zzbVar.zzb))) {
                        z = false;
                    }
                } else {
                    zzz(runnable2, (Executor) Objects.requireNonNull(zzdVar3.zzc));
                }
                zzdVar3 = zzdVar;
            }
            return;
        }
    }

    private final void zzy(StringBuilder sb) {
        try {
            Object objZzg = zzg(this);
            sb.append("SUCCESS, result=[");
            if (objZzg == null) {
                sb.append("null");
            } else if (objZzg == this) {
                sb.append("this future");
            } else {
                sb.append(objZzg.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(objZzg)));
            }
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append("]");
        } catch (Exception e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private static void zzz(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            Logger loggerZza = zzf.zza();
            Level level = Level.SEVERE;
            String strValueOf = String.valueOf(runnable);
            String strValueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 57 + String.valueOf(strValueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(strValueOf);
            sb.append(" with executor ");
            sb.append(strValueOf2);
            loggerZza.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", sb.toString(), (Throwable) e);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Object objRequireNonNull;
        Object obj = this.valueField;
        if (!(obj instanceof zzb) && !(obj == null)) {
            return false;
        }
        if (zzg) {
            objRequireNonNull = new zza(z, new CancellationException("Future.cancel() was called."));
        } else {
            objRequireNonNull = Objects.requireNonNull(z ? zza.zza : zza.zzb);
        }
        boolean z2 = false;
        while (true) {
            if (zzs(this, obj, objRequireNonNull)) {
                zzx(this, z);
                if (obj instanceof zzb) {
                    zzagx<? extends V> zzagxVar = ((zzb) obj).zzb;
                    if (zzagxVar instanceof zze) {
                        this = (zzafb) zzagxVar;
                        obj = this.valueField;
                        if (!(obj == null) && !(obj instanceof zzb)) {
                            return true;
                        }
                        z2 = true;
                    } else {
                        zzagxVar.cancel(z);
                    }
                }
                return true;
            }
            obj = this.valueField;
            if (zzi(obj)) {
                return z2;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public Object get() throws ExecutionException, InterruptedException {
        return zzv();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.valueField instanceof zza;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.valueField;
        return (obj != null) & zzi(obj);
    }

    public String toString() {
        String strConcat;
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzy(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.valueField;
            if (obj instanceof zzb) {
                sb.append(", setFuture=[");
                zzagx<? extends V> zzagxVar = ((zzb) obj).zzb;
                try {
                    if (zzagxVar == this) {
                        sb.append("this future");
                    } else {
                        sb.append(zzagxVar);
                    }
                } catch (Throwable th) {
                    zzahh.zzb(th);
                    sb.append("Exception thrown from implementation: ");
                    sb.append(th.getClass());
                }
                sb.append("]");
            } else {
                try {
                    strConcat = zzxm.zzb(zzd());
                } catch (Throwable th2) {
                    zzahh.zzb(th2);
                    String strValueOf = String.valueOf(th2.getClass());
                    String.valueOf(strValueOf);
                    strConcat = "Exception thrown from implementation: ".concat(String.valueOf(strValueOf));
                }
                if (strConcat != null) {
                    sb.append(", info=[");
                    sb.append(strConcat);
                    sb.append("]");
                }
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                zzy(sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    protected boolean zza(Object obj) {
        if (!zzs(this, null, zzA(obj))) {
            return false;
        }
        zzx(this, false);
        return true;
    }

    protected boolean zzb(Throwable th) {
        if (!zzs(this, null, new zzc(th))) {
            return false;
        }
        zzx(this, false);
        return true;
    }

    protected void zzc() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String zzd() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb = new StringBuilder(String.valueOf(delay).length() + 21);
        sb.append("remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }

    protected void zzj() {
    }

    protected final boolean zzk() {
        Object obj = this.valueField;
        return (obj instanceof zza) && ((zza) obj).zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zzagx
    public void zzl(Runnable runnable, Executor executor) {
        zzd zzdVar;
        zzxd.zzg(executor, "Executor was null.");
        if (!isDone() && (zzdVar = this.listenersField) != zzd.zza) {
            zzd zzdVar2 = new zzd(runnable, executor);
            do {
                zzdVar2.next = zzdVar;
                if (zzq(zzdVar, zzdVar2)) {
                    return;
                } else {
                    zzdVar = this.listenersField;
                }
            } while (zzdVar != zzd.zza);
        }
        zzz(runnable, executor);
    }

    @Override // com.google.android.gms.internal.nearby.zzahq
    protected final Throwable zzm() {
        if (!(this instanceof zze)) {
            return null;
        }
        Object obj = this.valueField;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    final void zzn(Future future) {
        if ((future != null) && isCancelled()) {
            future.cancel(zzk());
        }
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return zzu(j, timeUnit);
    }

    protected boolean zze(zzagx zzagxVar) {
        zzc zzcVar;
        zzagxVar.getClass();
        Object obj = this.valueField;
        if (obj == null) {
            if (zzagxVar.isDone()) {
                if (!zzs(this, null, zzf(zzagxVar))) {
                    return false;
                }
                zzx(this, false);
                return true;
            }
            zzb zzbVar = new zzb(this, zzagxVar);
            if (zzs(this, null, zzbVar)) {
                try {
                    zzagxVar.zzl(zzbVar, zzafx.INSTANCE);
                } catch (Throwable th) {
                    try {
                        zzcVar = new zzc(th);
                    } catch (Error | Exception unused) {
                        zzcVar = zzc.zza;
                    }
                    zzs(this, zzbVar, zzcVar);
                }
                return true;
            }
            obj = this.valueField;
        }
        if (obj instanceof zza) {
            zzagxVar.cancel(((zza) obj).zzc);
        }
        return false;
    }
}
