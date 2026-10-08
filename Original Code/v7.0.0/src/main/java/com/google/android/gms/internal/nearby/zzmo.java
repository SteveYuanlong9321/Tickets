package com.google.android.gms.internal.nearby;

import android.util.Log;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzmo implements zzne {
    private final String zza = "connections_enable_wifi_lan_connectivity_info_v2";
    private final zznz zzb;

    zzmo(String str, String str2, zznz zznzVar) {
        this.zzb = zznzVar;
    }

    protected Object zzb() {
        return null;
    }

    @Override // com.google.android.gms.internal.nearby.zzne, com.google.android.gms.internal.nearby.zzxn
    public final Object zzbh() {
        Object objZzc = zzc(zzkp.zza());
        objZzc.getClass();
        return objZzc;
    }

    protected final Object zzbi(zzmu zzmuVar, final zzkp zzkpVar, String str) {
        zzny zznyVarZza;
        Object objZzb;
        String strZza;
        int iZzf = zzmuVar.zzf();
        if (iZzf == -1 || iZzf < zzmuVar.zzg().zza()) {
            synchronized (zzmuVar) {
                int iZzf2 = zzmuVar.zzf();
                Object objZze = null;
                if (iZzf2 == -1) {
                    zzkp.zzk();
                    if (zzkpVar == null) {
                        throw null;
                    }
                    zznyVarZza = this.zzb.zza(zzkpVar, "");
                    zzmuVar.zzj(zznyVarZza.zzc());
                } else {
                    zznyVarZza = null;
                }
                int iZza = zzmuVar.zzg().zza();
                if (iZzf2 < iZza) {
                    zzkp.zzk();
                    if (zzkpVar == null) {
                        zzkpVar = null;
                    }
                    if (zzkpVar == null) {
                        throw null;
                    }
                    zzxb zzxbVarZza = zzkk.zza(zzkpVar.zzb());
                    if (!zzxbVarZza.zza() || (strZza = ((zzkj) zzxbVarZza.zzb()).zza(zzkl.zzc("com.google.android.gms.nearby"), null, null, this.zza)) == null) {
                        objZzb = null;
                    } else {
                        try {
                            objZzb = zzd(strZza);
                        } catch (IOException | IllegalArgumentException e) {
                            Log.e("FilePhenotypeFlags", "Invalid Phenotype flag value for flag ".concat(this.zza), e);
                            objZzb = null;
                        }
                    }
                    if (zznyVarZza == null) {
                        zznyVarZza = this.zzb.zza(zzkpVar, "");
                    }
                    final String strZzb = zznyVarZza.zzb();
                    if (!zzkpVar.zzb().getPackageName().equals("com.android.vending") && !zzkpVar.zzb().getPackageName().equals("com.google.android.wearable.app.cn") && !strZzb.startsWith("com.google.android.gms.measurement#")) {
                        zzop.zza(zzkpVar.zzf().submit(new Runnable() { // from class: com.google.android.gms.internal.nearby.zzof
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                Map mapZza = zzoh.zza(zzkpVar.zzb());
                                String str2 = strZzb;
                                if (mapZza.containsKey(str2)) {
                                    return;
                                }
                                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 173);
                                sb.append("Config package ");
                                sb.append(str2);
                                sb.append(" cannot use FILE backing without declarative registration. See go/phenotype-android-integration#phenotype for more information. This will lead to stale flags.");
                                Log.e("FilePhenotypeFlags", sb.toString());
                            }
                        }));
                    }
                    Object objZza = zznyVarZza.zza(this.zza, false);
                    if (objZza != null) {
                        try {
                            objZze = zze(objZza);
                        } catch (IOException | ClassCastException e2) {
                            Log.e("FilePhenotypeFlags", "Invalid Phenotype flag value for flag ".concat(this.zza), e2);
                        }
                    }
                    if (true != zzxbVarZza.zza()) {
                        objZzb = objZze;
                    }
                    if (objZzb == null) {
                        objZzb = zzb();
                    }
                    if (objZzb != null) {
                        zzmuVar.zzh(objZzb);
                        zzmuVar.zzi(iZza);
                    }
                    return objZzb;
                }
            }
        }
        return zzmuVar.zza();
    }

    protected abstract Object zzc(zzkp zzkpVar);

    protected abstract Object zzd(String str) throws IOException;

    protected abstract Object zze(Object obj) throws IOException;
}
