package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzln implements zzlj {
    private final zziy zza;

    public zzln(zziy zziyVar) {
        this.zza = zziyVar;
    }

    private static zzagx zzf(Task task) {
        return zzagn.zzh(zzki.zza(task, null), ApiException.class, zzll.zza, zzahg.zza());
    }

    @Override // com.google.android.gms.internal.nearby.zzlj
    public final zzagx zzc(zzle zzleVar) {
        return zzf(this.zza.zzc(zzleVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzlj
    public final zzagx zzd() {
        return zzf(this.zza.zzd());
    }

    @Override // com.google.android.gms.internal.nearby.zzlj
    public final zzagx zze(zzoe zzoeVar) {
        return zzf(this.zza.zze(zzoeVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzlj
    public final zzagx zzb(String str) {
        str.getClass();
        return zzf(this.zza.zzb(str));
    }

    @Override // com.google.android.gms.internal.nearby.zzlj
    public final zzagx zza(String str, String str2) {
        str.getClass();
        return zzf(this.zza.zza(str, "", null).continueWith(zzahg.zza(), new Continuation(this) { // from class: com.google.android.gms.internal.nearby.zzlm
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                zzajo zzajoVarZzn;
                zzhw zzhwVar = (zzhw) task.getResult();
                zzlf zzlfVarZzh = zzlg.zzh();
                zzlfVarZzh.zza(zzhwVar.zza);
                zzlfVarZzh.zzc(zzhwVar.zzc);
                zzlfVarZzh.zzf(zzhwVar.zzf);
                zzlfVarZzh.zzg(zzhwVar.zzg);
                byte[] bArr = zzhwVar.zzb;
                if (bArr != null) {
                    zzlfVarZzh.zzb(zzaik.zzj(bArr, 0, bArr.length));
                }
                for (zzhu zzhuVar : zzhwVar.zzd) {
                    for (zzid zzidVar : zzhuVar.zzb) {
                        int i = zzidVar.zzg;
                        if (i == 1) {
                            zzlh zzlhVarZzh = zzli.zzh();
                            zzlhVarZzh.zza(zzidVar.zza);
                            zzlhVarZzh.zzb(zzidVar.zza());
                            zzajoVarZzn = zzlhVarZzh.zzn();
                        } else if (i == 2) {
                            zzlh zzlhVarZzh2 = zzli.zzh();
                            zzlhVarZzh2.zza(zzidVar.zza);
                            zzlhVarZzh2.zzc(zzidVar.zzb());
                            zzajoVarZzn = zzlhVarZzh2.zzn();
                        } else if (i == 3) {
                            zzlh zzlhVarZzh3 = zzli.zzh();
                            zzlhVarZzh3.zza(zzidVar.zza);
                            zzlhVarZzh3.zzd(zzidVar.zzc());
                            zzajoVarZzn = zzlhVarZzh3.zzn();
                        } else if (i == 4) {
                            zzlh zzlhVarZzh4 = zzli.zzh();
                            zzlhVarZzh4.zza(zzidVar.zza);
                            zzlhVarZzh4.zze(zzidVar.zzd());
                            zzajoVarZzn = zzlhVarZzh4.zzn();
                        } else {
                            if (i != 5) {
                                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 24);
                                sb.append("Unrecognized flag type: ");
                                sb.append(i);
                                throw new IllegalArgumentException(sb.toString());
                            }
                            zzlh zzlhVarZzh5 = zzli.zzh();
                            zzlhVarZzh5.zza(zzidVar.zza);
                            byte[] bArrZze = zzidVar.zze();
                            zzaik zzaikVar = zzaik.zza;
                            zzlhVarZzh5.zzf(zzaik.zzj(bArrZze, 0, bArrZze.length));
                            zzajoVarZzn = zzlhVarZzh5.zzn();
                        }
                        zzlfVarZzh.zzd((zzli) zzajoVarZzn);
                    }
                    String[] strArr = zzhuVar.zzc;
                    if (strArr != null) {
                        for (String str3 : strArr) {
                            zzlfVarZzh.zze(str3);
                        }
                    }
                }
                return (zzlg) zzlfVarZzh.zzn();
            }
        }));
    }
}
