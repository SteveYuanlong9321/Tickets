package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzuz implements Runnable, zzvk {
    private zzvj zza;
    private final boolean zzb = zzqh.zza(Thread.currentThread());
    private boolean zzc;
    private boolean zzd;
    private boolean zze;

    zzuz(zzvj zzvjVar, boolean z) {
        this.zze = false;
        this.zza = zzvjVar;
        this.zze = z;
    }

    private final void zzb() {
        this.zzc = true;
        if (!this.zzb || this.zzd) {
            return;
        }
        zzqh.zza(Thread.currentThread());
    }

    public final zzagx zza(zzagx zzagxVar) {
        if (this.zzc) {
            throw new IllegalStateException("Span was already closed. Did you attach it to a future after calling Tracer.endSpan()?");
        }
        if (this.zzd) {
            throw new IllegalStateException("Signal is already attached to future");
        }
        this.zzd = true;
        zzagxVar.zzl(this, zzahg.zza());
        return zzagxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.zzc && this.zzd) {
            zzb();
        } else {
            zzqh.zzb().post(zzuy.zza);
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzvk, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        zzvj zzvjVar = this.zza;
        try {
            this.zza = null;
            if (!this.zzd) {
                if (this.zzc) {
                    throw new IllegalStateException("Span was already closed!");
                }
                zzb();
            }
            if (zzvjVar != null) {
                zzvjVar.close();
            }
            if (this.zze) {
                zzup.zzc(zzup.zzd(), zzux.zza);
            }
        } catch (Throwable th) {
            if (zzvjVar != null) {
                try {
                    zzvjVar.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
