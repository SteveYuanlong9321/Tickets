package com.google.android.gms.internal.nearby;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzacg {
    private static final zzacg zza = new zzaca();

    /* synthetic */ zzacg(byte[] bArr) {
    }

    public abstract void zza(zzabw zzabwVar, Object obj);

    public abstract int zzb();

    public abstract Set zzc();

    public static zzacg zzh(zzabp zzabpVar, zzabp zzabpVar2) {
        int iZza = zzabpVar2.zza();
        if (iZza == 0) {
            return zza;
        }
        byte[] bArr = null;
        return iZza <= 28 ? new zzace(zzabpVar, zzabpVar2, bArr) : new zzacf(zzabpVar, zzabpVar2, bArr);
    }
}
