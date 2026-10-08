package com.google.android.gms.internal.nearby;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzsn extends zztm {
    private static final zztm zza = new zzsn();

    private zzsn() {
    }

    @Override // com.google.android.gms.internal.nearby.zztm
    public final String zzb(int i) {
        return "singleproc";
    }

    @Override // com.google.android.gms.internal.nearby.zztm
    public final /* bridge */ /* synthetic */ zztl zzc(zzsh zzshVar, String str, Executor executor, zzqo zzqoVar, int i) {
        return new zzsy(str, zzagn.zza(zzshVar.zza()), zztu.zzd(zzshVar.zzb(), zzshVar.zzf() ? zzaiz.zzc() : zzaiz.zzb()), executor, zzqoVar, zzshVar.zzc(), zzus.zzb());
    }
}
