package com.google.android.gms.internal.nearby;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzabt extends zzabw {
    private final Map zza;
    private final Map zzb;
    private final zzabv zzc;
    private final zzabu zzd;

    /* synthetic */ zzabt(zzabs zzabsVar, byte[] bArr) {
        HashMap map = new HashMap();
        this.zza = map;
        HashMap map2 = new HashMap();
        this.zzb = map2;
        map.putAll(zzabsVar.zzd());
        map2.putAll(zzabsVar.zze());
        this.zzc = zzabsVar.zzf();
        this.zzd = zzabsVar.zzg();
    }

    @Override // com.google.android.gms.internal.nearby.zzabw
    protected final void zza(zzaaq zzaaqVar, Object obj, Object obj2) {
        zzabv zzabvVar = (zzabv) this.zza.get(zzaaqVar);
        if (zzabvVar != null) {
            zzabvVar.zza(zzaaqVar, obj, obj2);
        } else {
            this.zzc.zza(zzaaqVar, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzabw
    protected final void zzb(zzaaq zzaaqVar, Iterator it, Object obj) {
        zzabu zzabuVar = (zzabu) this.zzb.get(zzaaqVar);
        if (zzabuVar != null) {
            zzabuVar.zza(zzaaqVar, it, obj);
            return;
        }
        zzabu zzabuVar2 = this.zzd;
        if (zzabuVar2 != null && !this.zza.containsKey(zzaaqVar)) {
            zzabuVar2.zza(zzaaqVar, it, obj);
        } else {
            while (it.hasNext()) {
                zza(zzaaqVar, it.next(), obj);
            }
        }
    }
}
