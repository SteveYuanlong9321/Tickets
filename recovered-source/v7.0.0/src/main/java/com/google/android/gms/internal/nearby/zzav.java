package com.google.android.gms.internal.nearby;

import android.util.Log;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzav {
    private final zzi zza;
    private final Level zzb;
    private final String zzc;

    private zzav(zzi zziVar, String str, Level level) {
        this.zza = zziVar;
        this.zzc = "Nearby";
        this.zzb = level;
    }

    public zzav(String str) {
        zzi zziVarZza = zzaw.zza("Nearby");
        Level level = Level.OFF;
        this.zza = zziVarZza;
        this.zzc = "Nearby";
        this.zzb = level;
    }

    private final void zzd(String str, Object... objArr) {
        String str2 = String.format(str, objArr);
        Level level = this.zzb;
        if (level.equals(Level.FINE)) {
            String str3 = this.zzc;
            if (Log.isLoggable(str3, 3)) {
                Log.d(str3, str2);
                return;
            }
            return;
        }
        if (level.equals(Level.INFO)) {
            String str4 = this.zzc;
            if (Log.isLoggable(str4, 4)) {
                Log.i(str4, str2);
                return;
            }
            return;
        }
        if (level.equals(Level.WARNING)) {
            String str5 = this.zzc;
            if (Log.isLoggable(str5, 5)) {
                Log.w(str5, str2);
                return;
            }
            return;
        }
        boolean zEquals = level.equals(Level.SEVERE);
        String str6 = this.zzc;
        if (zEquals) {
            if (Log.isLoggable(str6, 6)) {
                Log.e(str6, str2);
            }
        } else if (Log.isLoggable(str6, 2)) {
            Log.v(str6, str2);
        }
    }

    public final zzav zza() {
        return new zzav(this.zza, this.zzc, Level.INFO);
    }

    public final void zzb(String str, Object obj) {
        zzd(str, "[NC_WifiAwareConnInfo]");
    }

    public final void zzc(String str, Object obj, Object obj2) {
        if (obj2 == null) {
            obj2 = "null";
        }
        zzd("%s %s", "[NC_WifiAwareConnInfo]", obj2);
    }
}
