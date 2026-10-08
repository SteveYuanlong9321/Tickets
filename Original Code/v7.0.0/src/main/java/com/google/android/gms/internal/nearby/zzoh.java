package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzoh {
    private static final Object zza = new Object();
    private static volatile Map zzb;
    private final String zzc;

    zzoh(Context context, zzoj zzojVar) {
        String strZza;
        if (zzojVar.zzb()) {
            String strZza2 = zzojVar.zza();
            int i = zzkl.zza;
            if (strZza2.contains("#")) {
                String.valueOf(strZza2);
                throw new IllegalArgumentException("The passed in package cannot already have a subpackage: ".concat(String.valueOf(strZza2)));
            }
            String packageName = context.getPackageName();
            StringBuilder sb = new StringBuilder(String.valueOf(strZza2).length() + 1 + String.valueOf(packageName).length());
            sb.append(strZza2);
            sb.append("#");
            sb.append(packageName);
            strZza = sb.toString();
        } else {
            strZza = zzojVar.zza();
        }
        this.zzc = strZza;
        zzojVar.zzd();
        zzojVar.zzg();
        zzojVar.zze();
        zzojVar.zzf();
    }

    static Map zza(Context context) {
        Map mapZzb;
        Map map = zzb;
        if (map != null) {
            return map;
        }
        synchronized (zza) {
            mapZzb = zzb;
            if (mapZzb == null) {
                zzyi zzyiVar = new zzyi();
                try {
                    String[] list = context.getAssets().list("phenotype");
                    if (list != null) {
                        for (String str : list) {
                            if (str.endsWith("_package_metadata.binarypb")) {
                                try {
                                    AssetManager assets = context.getAssets();
                                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 10);
                                    sb.append("phenotype/");
                                    sb.append(str);
                                    InputStream inputStreamOpen = assets.open(sb.toString());
                                    try {
                                        zzoh zzohVar = new zzoh(context, zzoj.zzh(inputStreamOpen, zzaiz.zzb()));
                                        zzyiVar.zza(zzohVar.zzc, zzohVar);
                                        if (inputStreamOpen != null) {
                                            inputStreamOpen.close();
                                        }
                                    } catch (Throwable th) {
                                        if (inputStreamOpen != null) {
                                            try {
                                                inputStreamOpen.close();
                                            } catch (Throwable th2) {
                                                th.addSuppressed(th2);
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (zzakf e) {
                                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 45);
                                    sb2.append("Unable to read Phenotype PackageMetadata for ");
                                    sb2.append(str);
                                    Log.e("PackageInfo", sb2.toString(), e);
                                }
                            }
                        }
                    }
                } catch (IOException e2) {
                    Log.e("PackageInfo", "Unable to read Phenotype PackageMetadata from assets.", e2);
                }
                mapZzb = zzyiVar.zzb();
                zzb = mapZzb;
            }
        }
        return mapZzb;
    }
}
