package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzakd {
    protected volatile zzaks zza;
    private final zzaks zzb;
    private final zzaiz zzc;
    private volatile zzaik zzd;
    private volatile boolean zze;

    zzakd(zzaks zzaksVar) {
        if (zzaksVar == null) {
            throw new IllegalArgumentException("message cannot be null");
        }
        this.zza = zzaksVar;
        this.zzb = zzaksVar.zzbg();
        int i = zzaiz.zzb;
        int i2 = zzahy.zza;
        this.zzc = zzaiz.zza;
        this.zzd = null;
        this.zze = false;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzakd)) {
            return zza().equals(obj);
        }
        zzakd zzakdVar = (zzakd) obj;
        if (this.zzd == null || zzakdVar.zzd == null || this.zzc != zzakdVar.zzc || !this.zzd.equals(zzakdVar.zzd)) {
            return zza().equals(zzakdVar.zza());
        }
        return true;
    }

    public final int hashCode() {
        return zza().hashCode();
    }

    public final String toString() {
        return zza().toString();
    }

    final zzaks zza() {
        try {
            return this.zza;
        } catch (zzakf unused) {
            zzaiz.zza();
            return this.zzb;
        }
    }

    final int zzb() {
        return this.zzd != null ? this.zzd.zzb() : this.zza.zzJ();
    }

    final zzaik zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            this.zzd = this.zza.zzu();
            return this.zzd;
        }
    }
}
