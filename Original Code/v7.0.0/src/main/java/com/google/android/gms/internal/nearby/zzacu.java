package com.google.android.gms.internal.nearby;

import android.os.Build;
import android.util.Log;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzacu extends zzacm {
    static final boolean zza;
    static final boolean zzb;
    static final boolean zzc;
    private static final AtomicReference zzd;
    private static final AtomicLong zzf;
    private static final ConcurrentLinkedQueue zzg;
    private volatile zzabl zze;

    static {
        zza = Build.FINGERPRINT == null || "robolectric".equals(Build.FINGERPRINT);
        zzb = "goldfish".equals(Build.HARDWARE) || "ranchu".equals(Build.HARDWARE);
        zzc = "eng".equals(Build.TYPE) || "userdebug".equals(Build.TYPE);
        zzd = new AtomicReference();
        zzf = new AtomicLong();
        zzg = new ConcurrentLinkedQueue();
    }

    private zzacu(String str) {
        super(str);
        if (zza || zzb) {
            this.zze = new zzacn().zza(zza());
        } else if (zzc) {
            this.zze = zzacy.zze().zzb(false).zza(zza());
        } else {
            this.zze = null;
        }
    }

    public static zzabl zze(String str) {
        char cCharAt;
        AtomicReference atomicReference = zzd;
        if (atomicReference.get() != null) {
            return ((zzaco) atomicReference.get()).zza(str);
        }
        int length = str.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
            cCharAt = str.charAt(length);
            if (cCharAt == '$') {
                str = str.replace(Typography.dollar, '.');
                break;
            }
        } while (cCharAt != '.');
        zzacu zzacuVar = new zzacu(str);
        ConcurrentLinkedQueue concurrentLinkedQueue = zzacs.zza;
        concurrentLinkedQueue.offer(zzacuVar);
        if (atomicReference.get() != null) {
            while (true) {
                zzacu zzacuVar2 = (zzacu) concurrentLinkedQueue.poll();
                if (zzacuVar2 == null) {
                    break;
                }
                zzacuVar2.zze = ((zzaco) atomicReference.get()).zza(zzacuVar2.zza());
            }
            zzf();
        }
        return zzacuVar;
    }

    private static void zzf() {
        while (true) {
            zzact zzactVar = (zzact) zzg.poll();
            if (zzactVar == null) {
                return;
            }
            zzf.getAndDecrement();
            zzabl zzablVarZza = zzactVar.zza();
            zzabj zzabjVarZzb = zzactVar.zzb();
            if (zzabjVarZzb.zzk() || zzablVarZza.zzb(zzabjVarZzb.zze())) {
                zzablVarZza.zzc(zzabjVarZzb);
            }
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzabl
    public final boolean zzb(Level level) {
        return this.zze == null || this.zze.zzb(level);
    }

    @Override // com.google.android.gms.internal.nearby.zzabl
    public final void zzc(zzabj zzabjVar) {
        if (this.zze != null) {
            this.zze.zzc(zzabjVar);
            return;
        }
        if (zzf.incrementAndGet() > 20) {
            zzg.poll();
            Log.w("ProxyAndroidLoggerBackend", "Too many Flogger logs received before configuration. Dropping old logs.");
        }
        zzg.offer(new zzact(this, zzabjVar));
        if (this.zze != null) {
            zzf();
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzacm, com.google.android.gms.internal.nearby.zzabl
    public final void zzd(RuntimeException runtimeException, zzabj zzabjVar) {
        if (this.zze != null) {
            this.zze.zzd(runtimeException, zzabjVar);
        } else {
            Log.e("ProxyAndroidLoggerBackend", "Internal logging error before configuration", runtimeException);
        }
    }
}
