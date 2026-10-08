package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.11.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzss {
    private static zzsr zza;

    public static synchronized zzsh zza(zzsb zzsbVar) {
        zzsr zzsrVar;
        zzsrVar = zza;
        if (zzsrVar == null) {
            zzsrVar = new zzsr(null);
            zza = zzsrVar;
        }
        return (zzsh) zzsrVar.get(zzsbVar);
    }

    public static synchronized zzsh zzb(String str) {
        return zza(zzsb.zzd("common").zzd());
    }
}
