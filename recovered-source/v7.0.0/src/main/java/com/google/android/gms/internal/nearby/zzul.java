package com.google.android.gms.internal.nearby;

import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzul {
    private static final WeakHashMap zza = new WeakHashMap();
    private static final WeakHashMap zzb = new WeakHashMap();

    public static void zza(Throwable th) {
        Throwable cause;
        zzvs zzvsVar;
        zzvj zzvjVarZzb;
        WeakHashMap weakHashMap = zzb;
        synchronized (weakHashMap) {
            cause = th;
            while (cause != null) {
                try {
                    if (weakHashMap.containsKey(cause)) {
                        break;
                    } else {
                        cause = cause.getCause();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            weakHashMap.put(th, Boolean.valueOf(cause != null));
        }
        if (cause != null) {
            return;
        }
        WeakHashMap weakHashMap2 = zza;
        synchronized (weakHashMap2) {
            Throwable cause2 = th;
            while (cause2 != null) {
                try {
                    if (weakHashMap2.containsKey(cause2)) {
                        break;
                    } else {
                        cause2 = cause2.getCause();
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            if (cause2 == null) {
                zzvsVar = null;
            } else {
                zzvn zzvnVar = (zzvn) weakHashMap2.get(cause2);
                weakHashMap2.put(th, zzvnVar);
                zzvsVar = new zzvs(cause2, zzvnVar);
            }
        }
        if (zzvsVar != null || (zzvjVarZzb = zzup.zzd().zzb) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (zzvjVarZzb = zzup.zzd().zzb; zzvjVarZzb != null; zzvjVarZzb = zzvjVarZzb.zzb()) {
            arrayList.add(zzvjVarZzb);
        }
        zzue zzueVar = new zzue();
        zzueVar.zzc(((zzvj) arrayList.get(0)).zzc());
        ((zzvj) arrayList.get(0)).zzk();
        zzueVar.zzd(-1L);
        zzyc zzycVarZzv = zzyg.zzv(arrayList.size());
        zzyc zzycVarZzv2 = zzyg.zzv(arrayList.size());
        for (zzvj zzvjVar : zzyu.zza(arrayList)) {
            zzycVarZzv2.zzc(zzvjVar.zze());
            zzycVarZzv.zzc(zzvjVar.zzh());
        }
        WeakHashMap weakHashMap3 = zza;
        synchronized (weakHashMap3) {
            zzueVar.zza(zzycVarZzv2.zze());
            zzueVar.zzb(zzycVarZzv.zze());
            weakHashMap3.put(th, zzueVar.zze());
        }
    }
}
