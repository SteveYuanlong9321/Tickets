package com.google.android.gms.internal.nearby;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zztr extends zzrw {
    private final zzaks zza;

    public zztr(zzaks zzaksVar) {
        this.zza = zzaksVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzrw
    public final zzagx zza(final IOException iOException, zzrx zzrxVar) {
        return !(iOException.getCause() instanceof zzakf) ? zzagn.zzc(iOException) : zzagn.zzh(zzrxVar.zza(zzagn.zza(this.zza)), IOException.class, new zzafq() { // from class: com.google.android.gms.internal.nearby.zztq
            @Override // com.google.android.gms.internal.nearby.zzafq
            public final /* synthetic */ zzagx zza(Object obj) throws IOException {
                IOException iOException2 = iOException;
                iOException2.addSuppressed((IOException) obj);
                throw iOException2;
            }
        }, zzahg.zza());
    }
}
