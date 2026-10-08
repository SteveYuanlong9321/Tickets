package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzvz {
    final long zza;
    final long zzb;

    protected zzvz() {
        new zzvw();
        this.zza = 0L;
        this.zzb = 0L;
    }

    private final native void zze(long j);

    private final native void zzf(long j);

    private final native void zzg(long j, int i);

    private final native void zzh(long j, long j2);

    public final void zza() {
        zze(0L);
    }

    public final void zzb() throws zzwa {
        zzf(0L);
    }

    public final zzvx zzc() throws zzwa {
        zzvx zzvxVar = new zzvx(this);
        zzh(0L, zzvxVar.zzb);
        return zzvxVar;
    }

    public final void zzd(int i) {
        zzg(0L, i);
    }
}
