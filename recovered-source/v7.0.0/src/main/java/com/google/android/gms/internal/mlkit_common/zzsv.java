package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.11.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzsv {
    private static zzsv zza;

    private zzsv() {
    }

    public static synchronized zzsv zza() {
        zzsv zzsvVar;
        zzsvVar = zza;
        if (zzsvVar == null) {
            zzsvVar = new zzsv();
            zza = zzsvVar;
        }
        return zzsvVar;
    }

    public static void zzb() {
        zzsu.zza();
    }
}
