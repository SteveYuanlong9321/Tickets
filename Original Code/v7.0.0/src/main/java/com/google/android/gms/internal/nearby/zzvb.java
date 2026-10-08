package com.google.android.gms.internal.nearby;

import androidx.collection.SimpleArrayMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzvb extends zzvc {
    static final zzvc zza;
    static final zzvc zzb;

    static {
        zzvc zzvcVarZzb = new zzvb(null, new SimpleArrayMap(0)).zzb();
        zza = zzvcVarZzb;
        zzvb zzvbVar = new zzvb(zzvcVarZzb, new SimpleArrayMap(), null);
        zzxd.zzf(!zzvbVar.zzh(), "Can't mutate after handing to trace");
        zzva zzvaVar = zzvc.zza;
        zzxd.zzf(true ^ zzvbVar.zzd(zzvaVar), "Key already present");
        zzvbVar.zzg().put(zzvaVar, true);
        zzb = zzvbVar.zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private zzvb(zzvc zzvcVar, SimpleArrayMap simpleArrayMap) {
        super(null, simpleArrayMap, 0 == true ? 1 : 0);
    }

    /* synthetic */ zzvb(zzvc zzvcVar, SimpleArrayMap simpleArrayMap, byte[] bArr) {
        super(zzvcVar, simpleArrayMap, null);
    }
}
