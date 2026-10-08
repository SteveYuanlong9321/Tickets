package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrn implements zzqn {
    private zzqi[] zza;

    private zzrn() {
    }

    public static zzrn zzb() {
        return new zzrn();
    }

    @Override // com.google.android.gms.internal.nearby.zzqn
    public final /* bridge */ /* synthetic */ Object zza(zzqm zzqmVar) throws IOException {
        List listZzd = zzqmVar.zzd(zzqmVar.zza().zzj(zzqmVar.zzb()));
        zzqi[] zzqiVarArr = this.zza;
        if (zzqiVarArr != null) {
            zzqiVarArr[0].zza(listZzd);
        }
        return (OutputStream) listZzd.get(0);
    }

    public final zzrn zzc(zzqi... zzqiVarArr) {
        this.zza = zzqiVarArr;
        return this;
    }
}
