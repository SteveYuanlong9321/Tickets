package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzadw {
    private static final String[] zza = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};
    private static final zzaea zzb;

    static {
        zzaea zzaebVar;
        for (int i = 0; i < 2; i++) {
            zzaebVar = null;
            try {
                zzaebVar = (zzaea) Class.forName(zza[i]).asSubclass(zzaea.class).getDeclaredConstructor(null).newInstance(null);
            } catch (Throwable unused) {
            }
            if (zzaebVar != null) {
                zzb = zzaebVar;
            }
        }
        zzaebVar = new zzaeb();
        zzb = zzaebVar;
    }

    public static StackTraceElement zza(Class cls, int i) {
        zzadx.zza(cls, "target");
        return zzb.zza(cls, 2);
    }

    public static StackTraceElement[] zzb(Class cls, int i, int i2) {
        if (i > 0 || i == -1) {
            return zzb.zzb(cls, i, 2);
        }
        throw new IllegalArgumentException("invalid maximum depth: 0");
    }
}
