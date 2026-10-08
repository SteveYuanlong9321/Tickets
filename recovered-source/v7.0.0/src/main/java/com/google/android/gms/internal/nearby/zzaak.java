package com.google.android.gms.internal.nearby;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzaak {
    private final ConcurrentHashMap zza = new ConcurrentHashMap();

    protected zzaak() {
    }

    protected abstract Object zza();

    public final Object zzb(zzaai zzaaiVar, zzabp zzabpVar) {
        ConcurrentHashMap concurrentHashMap = this.zza;
        Object obj = concurrentHashMap.get(zzaaiVar);
        if (obj != null) {
            return obj;
        }
        Object objZza = zza();
        Object objPutIfAbsent = concurrentHashMap.putIfAbsent(zzaaiVar, objZza);
        if (objPutIfAbsent != null) {
            return objPutIfAbsent;
        }
        int iZza = zzabpVar.zza();
        zzaaj zzaajVar = null;
        for (int i = 0; i < iZza; i++) {
            if (zzaac.zzf.equals(zzabpVar.zzb(i))) {
                Object objZzc = zzabpVar.zzc(i);
                if (objZzc instanceof zzaao) {
                    if (zzaajVar == null) {
                        zzaajVar = new zzaaj(this, zzaaiVar);
                    }
                    ((zzaao) objZzc).zza();
                }
            }
        }
        return objZza;
    }

    final /* synthetic */ ConcurrentHashMap zzc() {
        return this.zza;
    }
}
