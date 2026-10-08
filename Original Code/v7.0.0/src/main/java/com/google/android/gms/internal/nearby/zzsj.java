package com.google.android.gms.internal.nearby;

import android.net.Uri;
import android.util.Pair;
import androidx.core.os.EnvironmentCompat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzsj {
    private final ConcurrentMap zza = new ConcurrentHashMap();
    private final Executor zzb;
    private final zzqo zzc;
    private final zzafq zzd;
    private final Map zze;
    private final zzts zzf;

    zzsj(Executor executor, zzqo zzqoVar, zzts zztsVar, Map map, @Nullable zztv zztvVar) {
        executor.getClass();
        this.zzb = executor;
        zzqoVar.getClass();
        this.zzc = zzqoVar;
        this.zzf = zztsVar;
        this.zze = map;
        zzxd.zza(!map.isEmpty());
        this.zzd = zzsi.zza;
    }

    public final zzsf zza(zzsh zzshVar) {
        zzsh zzshVar2;
        ConcurrentMap concurrentMap = this.zza;
        Uri uriZza = zzshVar.zza();
        Pair pairCreate = (Pair) concurrentMap.get(uriZza);
        if (pairCreate == null) {
            Uri uriZza2 = zzshVar.zza();
            zzxd.zzd(uriZza2.isHierarchical(), "Uri must be hierarchical: %s", uriZza2);
            String strZza = zzxm.zza(uriZza2.getLastPathSegment());
            int iLastIndexOf = strZza.lastIndexOf(46);
            zzxd.zzd((iLastIndexOf == -1 ? "" : strZza.substring(iLastIndexOf + 1)).equals("pb"), "Uri extension must be .pb: %s", uriZza2);
            zzxd.zzb(zzshVar.zzc() != null, "Handler cannot be null");
            zztm zztmVar = (zztm) this.zze.get("singleproc");
            zzxd.zzd(zztmVar != null, "No XDataStoreVariantFactory registered for ID %s", "singleproc");
            String strZza2 = zzxm.zza(zzshVar.zza().getLastPathSegment());
            int iLastIndexOf2 = strZza2.lastIndexOf(46);
            if (iLastIndexOf2 != -1) {
                strZza2 = strZza2.substring(0, iLastIndexOf2);
            }
            String str = strZza2;
            zzagx zzagxVarZzi = zzagn.zzi(zzagn.zza(zzshVar.zza()), this.zzd, zzahg.zza());
            Executor executor = this.zzb;
            zzshVar2 = zzshVar;
            zzsf zzsfVar = new zzsf(zztmVar.zzc(zzshVar2, str, executor, this.zzc, 1), this.zzf, zzagxVarZzi, false, zztmVar.zzb(1));
            zzyg zzygVarZzd = zzshVar2.zzd();
            if (!zzygVarZzd.isEmpty()) {
                zzsfVar.zza(zzse.zzb(zzygVarZzd, executor));
            }
            pairCreate = Pair.create(zzsfVar, zzshVar2);
            Pair pair = (Pair) concurrentMap.putIfAbsent(uriZza, pairCreate);
            if (pair != null) {
                pairCreate = pair;
            }
        } else {
            zzshVar2 = zzshVar;
        }
        zzsf zzsfVar2 = (zzsf) pairCreate.first;
        zzsh zzshVar3 = (zzsh) pairCreate.second;
        if (zzshVar2.equals(zzshVar3)) {
            return zzsfVar2;
        }
        String strZzd = zzxm.zzd("ProtoDataStoreConfig<%s> doesn't match previous call [uri=%s] [%s]", zzshVar2.zzb().getClass().getSimpleName(), zzshVar2.zza());
        zzxd.zzd(zzshVar2.zza().equals(zzshVar3.zza()), strZzd, "uri");
        zzxd.zzd(zzshVar2.zzb().equals(zzshVar3.zzb()), strZzd, "schema");
        zzxd.zzd(zzshVar2.zzc().equals(zzshVar3.zzc()), strZzd, "handler");
        zzxd.zzd(zzshVar2.zzd().equals(zzshVar3.zzd()), strZzd, "migrations");
        zzxd.zzd(zzshVar2.zze().equals(zzshVar3.zze()), strZzd, "variantConfig");
        zzxd.zzd(zzshVar2.zzf() == zzshVar3.zzf(), strZzd, "useGeneratedExtensionRegistry");
        zzshVar3.zzg();
        throw new IllegalArgumentException(zzxm.zzd(strZzd, EnvironmentCompat.MEDIA_UNKNOWN));
    }
}
