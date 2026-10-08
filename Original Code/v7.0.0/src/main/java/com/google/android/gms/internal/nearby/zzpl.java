package com.google.android.gms.internal.nearby;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzpl {
    private final boolean zza = true;
    private final String zzb;
    private final zzaik zzc;
    private final zzyj zzd;
    private final zzpk zze;

    private zzpl(zzmc zzmcVar, zzpk zzpkVar) {
        zzmcVar.zzi();
        this.zzb = zzmcVar.zzd();
        this.zzc = zzmcVar.zzg();
        zzmcVar.zze();
        zzmcVar.zzf();
        Map mapZzh = zzmcVar.zzh();
        if (mapZzh != null) {
            zzyl.zzm(mapZzh.keySet());
        } else {
            zzyl.zzh();
        }
        zzlw zzlwVarZzc = zzmcVar.zzc();
        zzyi zzyiVarZzb = zzyj.zzb(zzlwVarZzc.zzf() + 3);
        zzlwVarZzc.zzc(zzyiVarZzb);
        zzyiVarZzb.zza("__phenotype_server_token", zzmcVar.zze());
        zzyiVarZzb.zza("__phenotype_snapshot_token", zzmcVar.zzd());
        zzyiVarZzb.zza("__phenotype_configuration_version", Long.valueOf(zzmcVar.zzf()));
        this.zzd = zzyiVarZzb.zzc();
        this.zze = zzpkVar;
    }

    static zzpl zza(zzpo zzpoVar, zzpk zzpkVar) {
        return new zzpl(zzpoVar, zzpkVar);
    }

    static zzpl zzb(zzpo zzpoVar, zzpl zzplVar) {
        return new zzpl(zzpoVar, zzplVar.zze);
    }

    static zzpl zzc(zzmc zzmcVar, zzpk zzpkVar) {
        return new zzpl(zzmcVar, zzpkVar);
    }

    final String zzd() {
        return this.zzb;
    }

    final zzaik zze() {
        return this.zzc;
    }

    final zzyj zzf() {
        return this.zzd;
    }

    public final boolean zzg() {
        return this.zze.zzd() == 3;
    }

    public final boolean zzh() {
        return this.zza;
    }

    final zzld zzi() {
        return this.zze.zzb();
    }

    public final boolean zzj() {
        return this.zze.zzc() == 17;
    }

    public final boolean zzk() {
        int iZzc = this.zze.zzc() - 2;
        return iZzc == 15 || iZzc == 16;
    }

    public final boolean zzl() {
        return this.zze.zza();
    }

    private zzpl(zzpo zzpoVar, zzpk zzpkVar) {
        zzpo.zzj().equals(zzpoVar);
        this.zzb = zzpoVar.zza();
        this.zzc = zzpoVar.zzb();
        zzpoVar.zzd();
        zzpoVar.zze();
        zzyl.zzh();
        zzyi zzyiVarZzb = zzyj.zzb(zzpoVar.zzg() + 3);
        for (zzpq zzpqVar : zzpoVar.zzf()) {
            int iZzp = zzpqVar.zzp();
            int i = iZzp - 1;
            if (iZzp == 0) {
                throw null;
            }
            if (i == 0) {
                zzyiVarZzb.zza(zzpqVar.zza(), Long.valueOf(zzpqVar.zzb()));
            } else if (i == 1) {
                zzyiVarZzb.zza(zzpqVar.zza(), Boolean.valueOf(zzpqVar.zzd()));
            } else if (i == 2) {
                zzyiVarZzb.zza(zzpqVar.zza(), Double.valueOf(zzpqVar.zze()));
            } else if (i == 3) {
                zzyiVarZzb.zza(zzpqVar.zza(), zzpqVar.zzf());
            } else if (i == 4) {
                zzyiVarZzb.zza(zzpqVar.zza(), zzpqVar.zzg().zzm());
            }
        }
        zzyiVarZzb.zza("__phenotype_server_token", zzpoVar.zzd());
        zzyiVarZzb.zza("__phenotype_snapshot_token", zzpoVar.zza());
        zzyiVarZzb.zza("__phenotype_configuration_version", Long.valueOf(zzpoVar.zze()));
        this.zzd = zzyiVarZzb.zzc();
        this.zze = zzpkVar;
    }
}
