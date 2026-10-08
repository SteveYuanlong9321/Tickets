package com.google.android.gms.internal.nearby;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalr extends zzals {
    zzalr(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.nearby.zzals
    public final boolean zza(Object obj, long j) {
        return zzalt.zza ? zzalt.zzp(obj, j) : zzalt.zzq(obj, j);
    }

    @Override // com.google.android.gms.internal.nearby.zzals
    public final void zzb(Object obj, long j, boolean z) {
        if (zzalt.zza) {
            zzalt.zzr(obj, j, z);
        } else {
            zzalt.zzs(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzals
    public final float zzc(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.nearby.zzals
    public final void zzd(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.nearby.zzals
    public final double zze(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.nearby.zzals
    public final void zzf(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }
}
