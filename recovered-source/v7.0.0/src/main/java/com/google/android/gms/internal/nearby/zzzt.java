package com.google.android.gms.internal.nearby;

import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzzt extends zzaae implements zzaan {
    protected zzzt(Level level, boolean z) {
        super(level, false, zzacj.zzk());
    }

    @Override // com.google.android.gms.internal.nearby.zzaae
    protected final zzadt zza() {
        return zzadr.zza();
    }

    @Override // com.google.android.gms.internal.nearby.zzaae
    protected final boolean zzb(zzaai zzaaiVar) {
        zzabp zzabpVarZzl = zzl();
        int iZza = zzabpVarZzl.zza();
        for (int i = 0; i < iZza; i++) {
            if (zzabpVarZzl.zzb(i).zzd() == "eye3tag") {
                if (zzabpVarZzl.zzd(zzaac.zza) != null) {
                    break;
                }
                zzaaq zzaaqVar = zzaac.zzi;
                if (zzabpVarZzl.zzd(zzaaqVar) != null) {
                    break;
                }
                zzm(zzaaqVar, zzaba.SMALL);
                break;
            }
        }
        return super.zzb(zzaaiVar);
    }
}
