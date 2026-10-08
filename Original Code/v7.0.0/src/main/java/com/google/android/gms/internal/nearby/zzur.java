package com.google.android.gms.internal.nearby;

import java.util.UUID;
import java.util.function.Consumer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzur extends zzus {
    zzur() {
        super(null);
    }

    @Override // com.google.android.gms.internal.nearby.zzus
    public final zzuz zza(String str, int i) {
        boolean z;
        zzvh zzvhVar;
        zzvj zzvjVarZzg;
        zzvc zzvcVar = zzvb.zza;
        zzvh zzvhVarZzd = zzup.zzd();
        zzvj zzvjVar = zzvhVarZzd.zzb;
        final Exception exc = null;
        if (zzvjVar == zzux.zza) {
            zzup.zzc(zzvhVarZzd, null);
            z = true;
            zzvjVar = null;
        } else {
            z = false;
        }
        if (zzvjVar == null) {
            final UUID uuidZzc = zzuq.zza().zzc();
            String strZzbj = zzud.zzbj(uuidZzc);
            zzuh zzuhVar = zzuu.zza;
            zzyl zzylVarZza = zzup.zza();
            if (!zzylVarZza.isEmpty()) {
                zzylVarZza.forEach(new Consumer(uuidZzc, exc) { // from class: com.google.android.gms.internal.nearby.zzuv
                    @Override // java.util.function.Consumer
                    public final /* synthetic */ void accept(Object obj) {
                        ((zzvl) obj).zza();
                    }
                });
            }
            zzvhVar = zzvhVarZzd;
            zzvjVarZzg = new zzuw(uuidZzc, strZzbj, str, zzvcVar, zzuhVar, false, false, zzvhVar);
        } else {
            zzvhVar = zzvhVarZzd;
            zzvjVarZzg = zzvjVar instanceof zzuj ? ((zzuj) zzvjVar).zzg(str, zzvcVar, false, zzvhVar) : zzvjVar.zzj(str, "B", "a", 1, zzvcVar, zzvhVar);
        }
        zzup.zzc(zzvhVar, zzvjVarZzg);
        return new zzuz(zzvjVarZzg, z);
    }
}
