package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.os.Parcelable;
import com.google.android.gms.common.logging.Logger;
import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzjz {
    public static final /* synthetic */ int zza = 0;
    private final boolean zzc;
    private final zzvz zzd;
    private final zzaha zze;
    private zzagx zzf;
    private Consumer zzg;
    private volatile boolean zzh;
    private volatile Integer zzi;
    private static final zzkb zzj = new zzkb();
    private static final Logger zzb = new Logger("zzjz", new String[0]);

    public zzjz(Context context) throws zzwe, zzwf, zzwg, zzwi {
        this.zzh = true;
        this.zzi = null;
        this.zzc = true;
        this.zzd = zzjt.zza(context);
        this.zze = zzahg.zzc(Executors.newSingleThreadScheduledExecutor(new zzjy(this)));
    }

    private final boolean zzh() {
        FutureTask futureTask = new FutureTask(zzjv.zza);
        this.zze.execute(futureTask);
        try {
            return ((Boolean) futureTask.get(100L, TimeUnit.MILLISECONDS)).booleanValue();
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzb.e("GL context check failed", e, new Object[0]);
            return false;
        }
    }

    private final void zzi() {
        Consumer consumer = this.zzg;
        zzjj zzjjVar = new zzjj();
        zzjjVar.zzc(true != this.zzh ? 2 : 1);
        zzjjVar.zzb(zzkb.zza());
        consumer.accept(zzjjVar.zza());
    }

    public final synchronized void zza(Consumer consumer, zzjl zzjlVar) throws zzwa, zzwc {
        if (this.zzf != null) {
            zzb.e("Attempt to start while already running", new Object[0]);
            return;
        }
        if (!zzh()) {
            throw new zzwc();
        }
        this.zzd.zzb();
        this.zzg = consumer;
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.nearby.zzjw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzd();
            }
        };
        long millis = Duration.ofSeconds(1L).dividedBy(zzjlVar.zza()).toMillis();
        zzaha zzahaVar = this.zze;
        zzagx zzagxVarZza = zzwo.zza(runnable, 0L, millis, TimeUnit.MILLISECONDS, zzj, zzahaVar);
        this.zzf = zzagxVarZza;
        zzagxVarZza.zzl(new Runnable() { // from class: com.google.android.gms.internal.nearby.zzju
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zze();
            }
        }, zzahaVar);
    }

    public final Integer zzb() {
        return this.zzi;
    }

    public final synchronized void zzc() {
        zzagx zzagxVar = this.zzf;
        if (zzagxVar != null) {
            zzagxVar.cancel(false);
        } else {
            zzb.w("Attempt to stop while not running", new Object[0]);
            this.zze.shutdown();
        }
    }

    final /* synthetic */ void zzd() {
        Integer num;
        try {
            zzvx zzvxVarZzc = this.zzd.zzc();
            int iZzb = zzvxVarZzc.zza().zzb() - 1;
            int i = 2;
            if (iZzb != 0) {
                if (iZzb == 1) {
                    num = 0;
                } else if (iZzb == 2) {
                    num = 1;
                } else if (iZzb != 3) {
                    num = iZzb != 4 ? null : 3;
                } else {
                    num = 2;
                }
            }
            this.zzi = num;
            int iZza = zzvxVarZzc.zza().zza();
            zzvxVarZzc.zzb();
            if (iZza == 1) {
                this.zzh = false;
                i = 0;
            } else if (this.zzh) {
                i = 1;
            }
            Consumer consumer = this.zzg;
            if (i != 0) {
                consumer.accept(new zzjk(null, zzkb.zza(), i));
            } else {
                Parcelable.Creator<zzjo> creator = zzjo.CREATOR;
                throw null;
            }
        } catch (zzwa unused) {
            zzb.v("Camera not available", new Object[0]);
            this.zzi = 4;
            zzi();
        } catch (zzwc unused2) {
            zzb.v("Missing GL context", new Object[0]);
            this.zzi = 5;
            zzi();
        } catch (zzwd unused3) {
            zzb.v("Session paused", new Object[0]);
            this.zzi = 6;
            zzi();
        }
    }

    final /* synthetic */ void zze() {
        if (this.zzc) {
            this.zzd.zza();
        }
        this.zze.shutdown();
    }

    final /* synthetic */ zzvz zzg() {
        return this.zzd;
    }

    public zzjz(zzvz zzvzVar, Executor executor) {
        this.zzh = true;
        this.zzi = null;
        this.zzc = false;
        this.zzd = zzvzVar;
        this.zze = zzahg.zzc(new zzjs(executor));
    }
}
