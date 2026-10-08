package com.google.android.gms.internal.nearby;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzacj {
    private static String zza = "com.google.android.gms.internal.nearby.zzacp";
    private static String zzb = "com.google.common.flogger.backend.google.GooglePlatform";
    private static String zzc = "com.google.common.flogger.backend.system.DefaultPlatform";
    private static final String[] zzd = {"com.google.android.gms.internal.nearby.zzacp", "com.google.common.flogger.backend.google.GooglePlatform", "com.google.common.flogger.backend.system.DefaultPlatform"};

    public static int zza() {
        return zzadz.zza();
    }

    public static zzaci zzb() {
        return zzach.zza.zzc();
    }

    public static zzabl zzd(String str) {
        return zzach.zza.zze(str);
    }

    public static zzacz zzf() {
        return zzach.zza.zzg();
    }

    public static boolean zzh(String str, Level level, boolean z) {
        zzf().zzb(str, level, z);
        return false;
    }

    public static zzadk zzi() {
        return zzf().zzc();
    }

    public static zzabp zzj() {
        return zzf().zzd();
    }

    public static long zzk() {
        return zzach.zza.zzl();
    }

    public static String zzm() {
        return zzach.zza.zzn();
    }

    protected abstract zzaci zzc();

    protected abstract zzabl zze(String str);

    protected zzacz zzg() {
        return zzacz.zze();
    }

    protected long zzl() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    protected abstract String zzn();
}
