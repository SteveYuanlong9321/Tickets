package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrm implements zzqn {
    private zzrm() {
    }

    public static zzrm zzb() {
        return new zzrm();
    }

    public static final InputStream zzc(zzqm zzqmVar) throws IOException {
        return (InputStream) zzqmVar.zzc(zzqmVar.zza().zzd(zzqmVar.zzb())).get(0);
    }

    @Override // com.google.android.gms.internal.nearby.zzqn
    public final /* bridge */ /* synthetic */ Object zza(zzqm zzqmVar) throws IOException {
        return zzc(zzqmVar);
    }
}
