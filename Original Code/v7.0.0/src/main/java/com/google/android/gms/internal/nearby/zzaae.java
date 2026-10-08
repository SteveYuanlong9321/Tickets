package com.google.android.gms.internal.nearby;

import java.util.Arrays;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzaae implements zzaan, zzabj {
    private static final String zza = new String();
    private final Level zzb;
    private final long zzc;
    private zzaad zzd = null;
    private zzaah zze = null;
    private zzaav zzf = null;
    private zzacl zzg = null;
    private Object[] zzh = null;

    protected zzaae(Level level, boolean z, long j) {
        zzadx.zza(level, "level");
        this.zzb = level;
        this.zzc = j;
    }

    protected abstract zzadt zza();

    protected boolean zzb(zzaai zzaaiVar) {
        zzaad zzaadVar = this.zzd;
        if (zzaadVar != null) {
            if (zzaaiVar != null) {
                zzaav zzaavVarZzc = zzaav.zzc(zzaav.zzc(zzzs.zza(zzaadVar, zzaaiVar, this.zzc), zzzp.zza(this.zzd, zzaaiVar)), zzaay.zza(this.zzd, zzaaiVar));
                this.zzf = zzaavVarZzc;
                if (zzaavVarZzc == zzaav.zzc) {
                    return false;
                }
            }
            zzaad zzaadVar2 = this.zzd;
            zzaaq zzaaqVar = zzaac.zzi;
            zzaba zzabaVar = (zzaba) zzaadVar2.zzd(zzaaqVar);
            if (zzabaVar != null) {
                zzaad zzaadVar3 = this.zzd;
                if (zzaadVar3 != null) {
                    zzaadVar3.zzf(zzaaqVar);
                }
                zzabp zzabpVarZzl = zzl();
                zzaaq zzaaqVar2 = zzaac.zza;
                zzm(zzaaqVar2, new zzaal((Throwable) zzabpVarZzl.zzd(zzaaqVar2), zzabaVar, zzadw.zzb(zzaae.class, zzabaVar.zza(), 1)));
            }
        }
        return true;
    }

    protected abstract zzzn zzc();

    protected abstract zzaan zzd();

    @Override // com.google.android.gms.internal.nearby.zzabj
    public final Level zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzabj
    public final long zzf() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zzabj
    public final zzaah zzg() {
        zzaah zzaahVar = this.zze;
        if (zzaahVar != null) {
            return zzaahVar;
        }
        throw new IllegalStateException("cannot request log site information prior to postProcess()");
    }

    @Override // com.google.android.gms.internal.nearby.zzabj
    public final zzacl zzh() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.nearby.zzabj
    public final Object[] zzi() {
        zzadx.zzc(this.zzg != null, "cannot get arguments unless a template context exists");
        Object[] objArr = this.zzh;
        if (objArr != null) {
            return objArr;
        }
        throw new IllegalStateException("cannot get arguments before calling log()");
    }

    @Override // com.google.android.gms.internal.nearby.zzabj
    public final Object zzj() {
        zzadx.zzc(this.zzg == null, "cannot get literal argument if a template context exists");
        Object[] objArr = this.zzh;
        if (objArr != null) {
            return objArr[0];
        }
        throw new IllegalStateException("cannot get literal argument before calling log()");
    }

    @Override // com.google.android.gms.internal.nearby.zzabj
    public final boolean zzk() {
        return this.zzd != null && Boolean.TRUE.equals(this.zzd.zzd(zzaac.zzg));
    }

    @Override // com.google.android.gms.internal.nearby.zzabj
    public final zzabp zzl() {
        zzaad zzaadVar = this.zzd;
        return zzaadVar != null ? zzaadVar : zzabp.zzg();
    }

    protected final void zzm(zzaaq zzaaqVar, Object obj) {
        zzaad zzaadVar = this.zzd;
        if (zzaadVar == null) {
            zzaadVar = new zzaad();
            this.zzd = zzaadVar;
        }
        zzaadVar.zze(zzaaqVar, obj);
    }

    @Override // com.google.android.gms.internal.nearby.zzaan
    public final zzaan zzn(String str, String str2, int i, String str3) {
        zzaah zzaahVar = zzaah.zza;
        zzaag zzaagVar = new zzaag("com/google/android/libraries/phenotype/client/Phlogger", "logInternal", 44, "Phlogger.java", null);
        if (this.zze == null) {
            this.zze = zzaagVar;
        }
        return zzd();
    }

    @Override // com.google.android.gms.internal.nearby.zzaan
    public final zzaan zzo(Throwable th) {
        zzaaq zzaaqVar = zzaac.zza;
        zzadx.zza(zzaaqVar, "metadata key");
        if (th != null) {
            zzm(zzaaqVar, th);
        }
        return zzd();
    }

    @Override // com.google.android.gms.internal.nearby.zzaan
    public final void zzp(String str, Object[] objArr) {
        zzaai zzaaiVarZzb;
        zzaad zzaadVar;
        zzaah zzaahVarZzb = this.zze;
        if (zzaahVarZzb == null) {
            zzaahVarZzb = zzacj.zzb().zzb(zzaae.class, 1);
            this.zze = zzaahVarZzb;
        }
        if (zzaahVarZzb != zzaah.zza) {
            zzaaiVarZzb = this.zze;
            zzaad zzaadVar2 = this.zzd;
            if (zzaadVar2 != null && zzaadVar2.zza() > 0) {
                zzadx.zza(zzaaiVarZzb, "logSiteKey");
                int iZza = zzaadVar2.zza();
                for (int i = 0; i < iZza; i++) {
                    if (zzaac.zzf.equals(zzaadVar2.zzb(i))) {
                        Object objZzc = zzaadVar2.zzc(i);
                        zzaaiVarZzb = objZzc instanceof zzaao ? ((zzaao) objZzc).zzb() : zzaaz.zza(zzaaiVarZzb, objZzc);
                    }
                }
            }
        } else {
            zzaaiVarZzb = null;
        }
        boolean zZzb = zzb(zzaaiVarZzb);
        zzaav zzaavVar = this.zzf;
        if (zzaavVar != null) {
            int iZza2 = zzaau.zza(zzaavVar, zzaaiVarZzb, this.zzd);
            if (zZzb && iZza2 > 0 && (zzaadVar = this.zzd) != null) {
                zzaadVar.zze(zzaac.zze, Integer.valueOf(iZza2));
            }
            zZzb &= iZza2 >= 0;
        }
        if (zZzb) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            this.zzh = objArrCopyOf;
            for (int i2 = 0; i2 < objArrCopyOf.length; i2++) {
                Object obj = objArrCopyOf[i2];
                if (obj instanceof zzzz) {
                    objArrCopyOf[i2] = ((zzzz) obj).zza();
                }
            }
            if (str != zza) {
                this.zzg = new zzacl(zza(), str);
            }
            zzadk zzadkVarZzi = zzacj.zzi();
            if (!zzadkVarZzi.zzc()) {
                zzabp zzabpVarZzl = zzl();
                zzaaq zzaaqVar = zzaac.zzh;
                zzadk zzadkVar = (zzadk) zzabpVarZzl.zzd(zzaaqVar);
                if (zzadkVar != null) {
                    zzadkVarZzi = zzadkVarZzi.zzd(zzadkVar);
                }
                zzm(zzaaqVar, zzadkVarZzi);
            }
            zzc().zzc(this);
        }
    }
}
