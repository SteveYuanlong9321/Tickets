package com.google.android.gms.internal.nearby;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzals {
    final Unsafe zza;

    zzals(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract boolean zza(Object obj, long j);

    public abstract void zzb(Object obj, long j, boolean z);

    public abstract float zzc(Object obj, long j);

    public abstract void zzd(Object obj, long j, float f);

    public abstract double zze(Object obj, long j);

    public abstract void zzf(Object obj, long j, double d);
}
