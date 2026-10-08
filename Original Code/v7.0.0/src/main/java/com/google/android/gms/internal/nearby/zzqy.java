package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzqy implements zzqi {
    private OutputStream zza;
    private zzrg zzb;

    @Override // com.google.android.gms.internal.nearby.zzqi
    public final void zza(List list) throws IOException {
        OutputStream outputStream = (OutputStream) zzyo.zzb(list);
        if (outputStream instanceof zzrg) {
            this.zzb = (zzrg) outputStream;
            this.zza = (OutputStream) list.get(0);
        }
    }

    public final void zzb() throws IOException {
        if (this.zzb == null) {
            throw new zzre("Cannot sync underlying stream");
        }
        this.zza.flush();
        this.zzb.zzb();
    }
}
