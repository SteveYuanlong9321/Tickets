package com.google.android.gms.internal.nearby;

import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzvx {
    final zzvz zza;
    long zzb;

    static {
        new ArrayList();
        new ArrayList();
    }

    protected zzvx() {
        this.zzb = 0L;
        this.zza = null;
    }

    zzvx(zzvz zzvzVar) {
        long jZzc = zzc(0L);
        this.zza = zzvzVar;
        this.zzb = jZzc;
    }

    private static native long zzc(long j);

    private static native void zzd(long j, long j2);

    private final native zzvy zze(long j, long j2);

    protected final void finalize() throws Throwable {
        long j = this.zzb;
        if (j != 0) {
            zzd(0L, j);
            this.zzb = 0L;
        }
        super.finalize();
    }

    public final zzvu zza() {
        return new zzvu(this.zza, this);
    }

    public final zzvy zzb() {
        long j = this.zza.zza;
        return zze(0L, this.zzb);
    }
}
