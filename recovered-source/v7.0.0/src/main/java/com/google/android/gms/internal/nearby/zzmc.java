package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmc {
    private static final zzmc zza = new zzmc(zzlw.zzb(), zzlp.zzi());
    private final zzlw zzb;
    private final zzlp zzc;

    public static zzmc zza() {
        return zza;
    }

    public static zzmc zzb(zzaio zzaioVar, boolean z) throws IOException {
        zzlw zzlwVar;
        int iZzr = zzaioVar.zzr();
        if (iZzr > 1) {
            StringBuilder sb = new StringBuilder(String.valueOf(iZzr).length() + 44);
            sb.append("Unsupported version: ");
            sb.append(iZzr);
            sb.append(". Current version is: 1");
            throw new zzakf(sb.toString());
        }
        zzaioVar.zzr();
        int iZzC = zzaioVar.zzC(zzaioVar.zzp());
        zzlp zzlpVarZzh = zzlp.zzh(zzaioVar, zzaiz.zzb());
        zzaioVar.zzD(iZzC);
        zzlt zzltVarZza = zzlt.zza();
        try {
            if (z) {
                int iZzC2 = zzaioVar.zzC(zzaioVar.zzp());
                zzlwVar = (zzlw) zzltVarZza.zzc(zzaioVar, zzma.zza);
                int iZzE = zzaioVar.zzE();
                if (iZzE > 0) {
                    zzaioVar.zzK(iZzE);
                }
                zzaioVar.zzD(iZzC2);
            } else {
                zzlwVar = (zzlw) zzltVarZza.zzb(zzaioVar.zzo(), zzmb.zza);
            }
            zzltVarZza.close();
            return new zzmc(zzlwVar, zzlpVarZzh);
        } catch (Throwable th) {
            try {
                zzltVarZza.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final zzlw zzc() {
        zzyj zzyjVarZzc;
        zzlw zzlwVar = this.zzb;
        zzlp zzlpVar = this.zzc;
        if (zzlpVar.zzf() <= 0) {
            return zzlwVar;
        }
        Collection<zzli> collectionValues = zzlpVar.zzg().values();
        if (collectionValues == null) {
            zzyjVarZzc = zzyj.zza();
        } else {
            zzyi zzyiVar = new zzyi();
            for (zzli zzliVar : collectionValues) {
                int iZzq = zzliVar.zzq();
                int i = iZzq - 1;
                if (iZzq == 0) {
                    throw null;
                }
                if (i == 0) {
                    zzyiVar.zza(zzliVar.zza(), Long.valueOf(zzliVar.zzb()));
                } else if (i == 1) {
                    zzyiVar.zza(zzliVar.zza(), Boolean.valueOf(zzliVar.zzd()));
                } else if (i == 2) {
                    zzyiVar.zza(zzliVar.zza(), Double.valueOf(zzliVar.zze()));
                } else if (i == 3) {
                    zzyiVar.zza(zzliVar.zza(), zzliVar.zzf());
                } else {
                    if (i != 4) {
                        String strZza = zzliVar.zza();
                        String.valueOf(strZza);
                        throw new IllegalStateException("Could not serialize Flag for override: ".concat(String.valueOf(strZza)));
                    }
                    zzyiVar.zza(zzliVar.zza(), zzliVar.zzg().zzm());
                }
            }
            zzyjVarZzc = zzyiVar.zzc();
        }
        return zzlw.zza(zzlwVar, zzyjVarZzc);
    }

    public final String zzd() {
        return this.zzc.zza();
    }

    public final String zze() {
        return this.zzc.zzd();
    }

    public final long zzf() {
        return this.zzc.zze();
    }

    public final zzaik zzg() {
        return this.zzc.zzb();
    }

    public final Map zzh() {
        zzlp zzlpVar = this.zzc;
        if (zzlpVar.zzf() == 0) {
            return null;
        }
        return zzlpVar.zzg();
    }

    public final boolean zzi() {
        if (this.zzb.zze().isEmpty()) {
            return zzlp.zzi().equals(this.zzc);
        }
        return false;
    }

    private zzmc(zzlw zzlwVar, zzlp zzlpVar) {
        zzlwVar.getClass();
        this.zzb = zzlwVar;
        this.zzc = zzlpVar;
    }
}
