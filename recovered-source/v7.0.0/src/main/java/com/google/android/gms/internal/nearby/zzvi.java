package com.google.android.gms.internal.nearby;

import android.os.Trace;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzvi {
    static void zza(zzvj zzvjVar, zzvj zzvjVar2) {
        if (zzvjVar != null) {
            if (zzvjVar2 != null) {
                if (zzvjVar.zzb() == zzvjVar2 && !zzd(zzvjVar)) {
                    Trace.endSection();
                    return;
                } else if (zzvjVar == zzvjVar2.zzb() && !zzd(zzvjVar2)) {
                    zze(zzvjVar2);
                    return;
                }
            }
            zzc(zzvjVar);
        }
        if (zzvjVar2 != null) {
            zzb(zzvjVar2);
        }
    }

    static void zzb(zzvj zzvjVar) {
        if (zzd(zzvjVar) || zzvjVar.zzb() == null) {
            Trace.beginSection(zzvjVar.zzd());
            zze(zzvjVar);
        } else {
            zzb(zzvjVar.zzb());
            zze(zzvjVar);
        }
    }

    static void zzc(zzvj zzvjVar) {
        if (zzd(zzvjVar) || zzvjVar.zzb() == null) {
            Trace.endSection();
            Trace.endSection();
        } else {
            Trace.endSection();
            zzc(zzvjVar.zzb());
        }
    }

    private static boolean zzd(zzvj zzvjVar) {
        return zzvjVar.zza() != Thread.currentThread();
    }

    private static void zze(zzvj zzvjVar) {
        String strZze = zzvjVar.zze();
        int i = zzup.zzb;
        if (strZze.length() > 127) {
            strZze = strZze.substring(0, 127);
        }
        Trace.beginSection(strZze);
    }
}
