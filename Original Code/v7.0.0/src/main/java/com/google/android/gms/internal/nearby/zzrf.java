package com.google.android.gms.internal.nearby;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrf extends zzrh implements zzqz {
    private final FileInputStream zza;
    private final File zzb;

    private zzrf(FileInputStream fileInputStream, File file) {
        super(fileInputStream);
        this.zza = fileInputStream;
        this.zzb = file;
    }

    public static zzrf zzb(File file) throws FileNotFoundException {
        return new zzrf(new FileInputStream(file), file);
    }

    @Override // com.google.android.gms.internal.nearby.zzqz
    public final File zza() {
        return this.zzb;
    }
}
