package com.google.android.gms.internal.nearby;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzacf extends zzacg {
    private final Map zza;

    /* synthetic */ zzacf(zzabp zzabpVar, zzabp zzabpVar2, byte[] bArr) {
        super(null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        zzd(linkedHashMap, zzabpVar);
        zzd(linkedHashMap, zzabpVar2);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((zzaaq) entry.getKey()).zzf()) {
                entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
            }
        }
        this.zza = Collections.unmodifiableMap(linkedHashMap);
    }

    private static void zzd(Map map, zzabp zzabpVar) {
        for (int i = 0; i < zzabpVar.zza(); i++) {
            zzaaq zzaaqVarZzb = zzabpVar.zzb(i);
            Object obj = map.get(zzaaqVarZzb);
            if (zzaaqVarZzb.zzf()) {
                List arrayList = (List) obj;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(zzaaqVarZzb, arrayList);
                }
                arrayList.add(zzaaqVarZzb.zze(zzabpVar.zzc(i)));
            } else {
                map.put(zzaaqVarZzb, zzaaqVarZzb.zze(zzabpVar.zzc(i)));
            }
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzacg
    public final void zza(zzabw zzabwVar, Object obj) {
        for (Map.Entry entry : this.zza.entrySet()) {
            zzaaq zzaaqVar = (zzaaq) entry.getKey();
            Object value = entry.getValue();
            if (zzaaqVar.zzf()) {
                zzabwVar.zzb(zzaaqVar, ((List) value).iterator(), obj);
            } else {
                zzabwVar.zza(zzaaqVar, value, obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzacg
    public final int zzb() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.nearby.zzacg
    public final Set zzc() {
        return this.zza.keySet();
    }
}
