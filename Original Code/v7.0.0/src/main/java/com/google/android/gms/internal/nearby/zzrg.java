package com.google.android.gms.internal.nearby;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrg extends zzri implements zzqz {
    private final FileOutputStream zza;
    private final File zzb;

    public zzrg(FileOutputStream fileOutputStream, File file) {
        super(fileOutputStream);
        this.zza = fileOutputStream;
        this.zzb = file;
    }

    @Override // com.google.android.gms.internal.nearby.zzqz
    public final File zza() {
        return this.zzb;
    }

    public final void zzb() throws IOException {
        this.zza.getFD().sync();
    }
}
