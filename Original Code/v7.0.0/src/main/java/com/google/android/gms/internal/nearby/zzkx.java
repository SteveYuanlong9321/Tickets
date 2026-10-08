package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzkx {
    private static final Object zza = new Object();
    private static volatile boolean zzb = false;
    private static volatile zzkw zzc = null;
    private static volatile boolean zzd = false;
    private static volatile zzkw zze;

    static void zza() {
        zzd = true;
    }

    static boolean zzb() {
        synchronized (zza) {
        }
        return false;
    }

    static void zzc() {
        if (zze == null) {
            zze = new zzkw(null);
        }
    }

    static void zzd() {
        if (zzc == null) {
            zzc = new zzkw(null);
        }
    }
}
