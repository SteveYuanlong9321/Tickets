package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalo extends zzalm {
    zzalo() {
    }

    static final void zzi(zzaln zzalnVar, int i, long j) {
        zzalnVar.zzk(i << 3, Long.valueOf(j));
    }

    static final zzaln zzj(Object obj) {
        zzajo zzajoVar = (zzajo) obj;
        zzaln zzalnVar = zzajoVar.zzc;
        if (zzalnVar != zzaln.zza()) {
            return zzalnVar;
        }
        zzaln zzalnVarZzb = zzaln.zzb();
        zzajoVar.zzc = zzalnVarZzb;
        return zzalnVarZzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzalm
    final /* bridge */ /* synthetic */ void zza(Object obj, int i, long j) {
        zzi((zzaln) obj, i, j);
    }

    @Override // com.google.android.gms.internal.nearby.zzalm
    final /* bridge */ /* synthetic */ void zzb(Object obj, int i, int i2) {
        ((zzaln) obj).zzk((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.nearby.zzalm
    final /* bridge */ /* synthetic */ void zzc(Object obj, int i, long j) {
        ((zzaln) obj).zzk((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.nearby.zzalm
    final /* synthetic */ void zzd(Object obj, int i, zzaik zzaikVar) {
        ((zzaln) obj).zzk((i << 3) | 2, zzaikVar);
    }

    @Override // com.google.android.gms.internal.nearby.zzalm
    final /* bridge */ /* synthetic */ void zze(Object obj, int i, Object obj2) {
        ((zzaln) obj).zzk((i << 3) | 3, (zzaln) obj2);
    }

    @Override // com.google.android.gms.internal.nearby.zzalm
    final /* synthetic */ Object zzf() {
        return zzaln.zzb();
    }

    @Override // com.google.android.gms.internal.nearby.zzalm
    final /* synthetic */ Object zzg(Object obj) {
        zzaln zzalnVar = (zzaln) obj;
        zzalnVar.zzd();
        return zzalnVar;
    }
}
