package com.google.android.gms.internal.nearby;

import androidx.compose.animation.core.AnimationKt;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzxl {
    private final zzxt zza;
    private boolean zzb;
    private long zzc;

    zzxl() {
        this.zza = zzxt.zzb();
    }

    public static zzxl zza(zzxt zzxtVar) {
        zzxl zzxlVar = new zzxl(zzxtVar);
        zzxd.zzf(!zzxlVar.zzb, "This stopwatch is already running.");
        zzxlVar.zzb = true;
        zzxlVar.zzc = zzxlVar.zza.zza();
        return zzxlVar;
    }

    public final String toString() {
        TimeUnit timeUnit;
        String str;
        long jZza = this.zzb ? this.zza.zza() - this.zzc : 0L;
        TimeUnit timeUnit2 = TimeUnit.DAYS;
        TimeUnit timeUnit3 = TimeUnit.NANOSECONDS;
        if (jZza / 86400000000000L > 0) {
            timeUnit = TimeUnit.DAYS;
        } else {
            TimeUnit timeUnit4 = TimeUnit.HOURS;
            TimeUnit timeUnit5 = TimeUnit.NANOSECONDS;
            if (jZza / 3600000000000L > 0) {
                timeUnit = TimeUnit.HOURS;
            } else {
                TimeUnit timeUnit6 = TimeUnit.MINUTES;
                TimeUnit timeUnit7 = TimeUnit.NANOSECONDS;
                if (jZza / 60000000000L > 0) {
                    timeUnit = TimeUnit.MINUTES;
                } else {
                    TimeUnit timeUnit8 = TimeUnit.SECONDS;
                    TimeUnit timeUnit9 = TimeUnit.NANOSECONDS;
                    if (jZza / 1000000000 > 0) {
                        timeUnit = TimeUnit.SECONDS;
                    } else {
                        TimeUnit timeUnit10 = TimeUnit.MILLISECONDS;
                        TimeUnit timeUnit11 = TimeUnit.NANOSECONDS;
                        if (jZza / AnimationKt.MillisToNanos > 0) {
                            timeUnit = TimeUnit.MILLISECONDS;
                        } else {
                            TimeUnit timeUnit12 = TimeUnit.MICROSECONDS;
                            TimeUnit timeUnit13 = TimeUnit.NANOSECONDS;
                            timeUnit = jZza / 1000 > 0 ? TimeUnit.MICROSECONDS : TimeUnit.NANOSECONDS;
                        }
                    }
                }
            }
        }
        String str2 = String.format(Locale.ROOT, "%.4g", Double.valueOf(jZza / TimeUnit.NANOSECONDS.convert(1L, timeUnit)));
        switch (zzxk.zza[timeUnit.ordinal()]) {
            case 1:
                str = "ns";
                break;
            case 2:
                str = "μs";
                break;
            case 3:
                str = AccessibilityNodeInfoCompat.MathInfoCompat.MATH_TAG_STRING_LITERAL;
                break;
            case 4:
                str = "s";
                break;
            case 5:
                str = "min";
                break;
            case 6:
                str = "h";
                break;
            case 7:
                str = "d";
                break;
            default:
                throw new AssertionError();
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + str.length());
        sb.append(str2);
        sb.append(" ");
        sb.append(str);
        return sb.toString();
    }

    zzxl(zzxt zzxtVar) {
        zzxd.zzg(zzxtVar, "ticker");
        this.zza = zzxtVar;
    }
}
