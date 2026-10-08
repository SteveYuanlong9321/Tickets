package com.google.android.gms.internal.nearby;

import android.os.Build;
import dalvik.system.VMStack;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzacp extends zzacj {
    private static final boolean zza = zza.zza();
    private static final boolean zzb;
    private static final zzaci zzc;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    final class zza {
        zza() {
        }

        static boolean zza() {
            return zzacp.zzp();
        }
    }

    static {
        boolean z = true;
        if (Build.FINGERPRINT != null && !"robolectric".equals(Build.FINGERPRINT)) {
            z = false;
        }
        zzb = z;
        zzc = new zzaci() { // from class: com.google.android.gms.internal.nearby.zzacp.1
            @Override // com.google.android.gms.internal.nearby.zzaci
            public String zza(Class<? extends zzzn<?>> cls) {
                StackTraceElement stackTraceElementZza;
                if (zzacp.zza) {
                    try {
                        if (cls.equals(zzacp.zzr())) {
                            return VMStack.getStackClass2().getName();
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (!zzacp.zzb || (stackTraceElementZza = zzadw.zza(cls, 1)) == null) {
                    return null;
                }
                return stackTraceElementZza.getClassName();
            }

            @Override // com.google.android.gms.internal.nearby.zzaci
            public zzaah zzb(Class<?> cls, int i) {
                return zzaah.zza;
            }
        };
    }

    static boolean zzp() {
        try {
            Class.forName("dalvik.system.VMStack").getMethod("getStackClass2", null);
            return zza.class.getName().equals(zzq());
        } catch (Throwable unused) {
            return false;
        }
    }

    static String zzq() {
        try {
            return VMStack.getStackClass2().getName();
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class<?> zzr() {
        return VMStack.getStackClass2();
    }

    @Override // com.google.android.gms.internal.nearby.zzacj
    protected zzaci zzc() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zzacj
    protected zzabl zze(String str) {
        return zzacu.zze(str);
    }

    @Override // com.google.android.gms.internal.nearby.zzacj
    protected zzacz zzg() {
        return zzacv.zza();
    }

    @Override // com.google.android.gms.internal.nearby.zzacj
    protected String zzn() {
        return "platform: Android";
    }
}
