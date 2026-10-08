package com.google.android.gms.internal.nearby;

import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzuk extends zzud {
    private final zzvc zza;

    zzuk(String str, zzvj zzvjVar, zzvc zzvcVar, zzvh zzvhVar) {
        super(str, zzvjVar, zzvhVar);
        zzxd.zza(zzvcVar.zze());
        this.zza = zzvcVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzvj
    public final zzvc zzh() {
        return zzvc.zza(this.zza, zzl());
    }

    zzuk(String str, UUID uuid, String str2, zzvc zzvcVar, zzvh zzvhVar) {
        super(str, uuid, str2, zzvhVar);
        zzxd.zza(zzvcVar.zze());
        this.zza = zzvcVar;
    }
}
