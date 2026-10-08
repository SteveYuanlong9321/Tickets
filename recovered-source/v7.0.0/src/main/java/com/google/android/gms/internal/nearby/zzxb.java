package com.google.android.gms.internal.nearby;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzxb implements Serializable {
    zzxb() {
    }

    public static zzxb zze() {
        return zzwp.zza;
    }

    public static zzxb zzf(Object obj) {
        obj.getClass();
        return new zzxe(obj);
    }

    public abstract boolean equals(Object obj);

    public abstract int hashCode();

    public abstract boolean zza();

    public abstract Object zzb();

    public abstract Object zzc(zzxn zzxnVar);

    public abstract Object zzd();
}
