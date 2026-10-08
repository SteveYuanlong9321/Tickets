package com.google.android.gms.internal.nearby;

import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzsk {
    private Executor zza;
    private zzqo zzb;
    private final zzts zzd = zzts.zza;
    private final HashMap zzc = new HashMap();

    public final zzsk zza(Executor executor) {
        this.zza = executor;
        return this;
    }

    public final zzsk zzb(zzqo zzqoVar) {
        this.zzb = zzqoVar;
        return this;
    }

    public final zzsk zzc(zztm zztmVar) {
        HashMap map = this.zzc;
        zzxd.zzd(!map.containsKey("singleproc"), "There is already a factory registered for the ID %s", "singleproc");
        map.put("singleproc", zztmVar);
        return this;
    }

    public final zzsj zzd() {
        return new zzsj(this.zza, this.zzb, this.zzd, this.zzc, null);
    }
}
