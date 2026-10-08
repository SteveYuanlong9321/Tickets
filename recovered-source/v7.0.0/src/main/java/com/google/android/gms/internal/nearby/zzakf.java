package com.google.android.gms.internal.nearby;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class zzakf extends IOException {
    private boolean zza;

    public zzakf(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    final void zza() {
        this.zza = true;
    }

    final boolean zzb() {
        return this.zza;
    }

    public zzakf(String str) {
        super(str);
    }

    public zzakf(String str, IOException iOException) {
        super("Unable to parse map entry.", iOException);
    }
}
