package com.google.android.gms.internal.nearby;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrl implements zzqn {
    private boolean zza = false;

    static {
        new AtomicInteger();
    }

    private zzrl() {
    }

    public static zzrl zzb() {
        return new zzrl();
    }

    @Override // com.google.android.gms.internal.nearby.zzqn
    public final /* bridge */ /* synthetic */ Object zza(zzqm zzqmVar) throws IOException {
        if (this.zza) {
            if (zzqmVar.zze()) {
                throw new zzre("Short circuit would skip transforms.");
            }
            return zzqmVar.zza().zzg(zzqmVar.zzb());
        }
        zzrd zzrdVarZza = zzrd.zza(zzrm.zzc(zzqmVar));
        try {
            if (!(zzrdVarZza.zzb() instanceof zzqz)) {
                throw new IOException("Not convertible and fallback to pipe is disabled.");
            }
            File fileZza = ((zzqz) zzrdVarZza.zzb()).zza();
            zzrdVarZza.close();
            return fileZza;
        } catch (Throwable th) {
            try {
                zzrdVarZza.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final zzrl zzc() {
        this.zza = true;
        return this;
    }
}
