package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzw {
    private final Class zza;
    private final Object zzb;

    private zzw(Class cls, Object obj) {
        this.zza = cls;
        this.zzb = obj;
    }

    public static zzw zza(Class cls, Object obj) {
        return new zzw(cls, obj);
    }

    public final Class zzb() {
        return this.zza;
    }

    public final Object zzc() {
        return this.zzb;
    }
}
