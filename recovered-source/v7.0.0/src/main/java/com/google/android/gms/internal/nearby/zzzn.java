package com.google.android.gms.internal.nearby;

import androidx.compose.animation.core.AnimationKt;
import com.google.android.gms.internal.nearby.zzaan;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class zzzn<API extends zzaan<API>> {
    private final zzabl zza;

    protected zzzn(zzabl zzablVar) {
        this.zza = zzablVar;
    }

    private static void zzd(String str, zzabj zzabjVar) {
        StringBuilder sb = new StringBuilder();
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        sb.append(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(new Date(zzabjVar.zzf() / AnimationKt.MillisToNanos)));
        sb.append(": logging error [");
        zzabk.zza(1, zzabjVar.zzg(), sb);
        sb.append("]: ");
        sb.append(str);
        System.err.println(sb);
        System.err.flush();
    }

    protected final String zza() {
        return this.zza.zza();
    }

    protected final boolean zzb(Level level) {
        return this.zza.zzb(level);
    }

    final void zzc(zzabj zzabjVar) {
        try {
            zzadz zzadzVarZzc = zzadz.zzc();
            try {
                if (zzadzVarZzc.zzb() <= 100) {
                    this.zza.zzc(zzabjVar);
                } else {
                    zzd("unbounded recursion in log statement", zzabjVar);
                }
                if (zzadzVarZzc != null) {
                    zzadzVarZzc.close();
                }
            } catch (Throwable th) {
                if (zzadzVarZzc != null) {
                    try {
                        zzadzVarZzc.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (RuntimeException e) {
            try {
                this.zza.zzd(e, zzabjVar);
            } catch (zzabm e2) {
                throw e2;
            } catch (RuntimeException e3) {
                String name = e3.getClass().getName();
                String message = e3.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 2 + String.valueOf(message).length());
                sb.append(name);
                sb.append(": ");
                sb.append(message);
                zzd(sb.toString(), zzabjVar);
                try {
                    e3.printStackTrace(System.err);
                } catch (RuntimeException unused) {
                }
            }
        }
    }
}
