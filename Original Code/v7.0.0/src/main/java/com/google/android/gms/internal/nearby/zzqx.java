package com.google.android.gms.internal.nearby;

import android.net.Uri;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzqx implements zzro {
    public zzqx() {
        new zzrb();
    }

    public zzqx(zzrb zzrbVar) {
    }

    @Override // com.google.android.gms.internal.nearby.zzro
    public final String zzc() {
        return "file";
    }

    @Override // com.google.android.gms.internal.nearby.zzro
    public final InputStream zzd(Uri uri) throws IOException {
        return zzrf.zzb(zzqw.zza(uri));
    }

    @Override // com.google.android.gms.internal.nearby.zzro
    public final boolean zze(Uri uri) throws IOException {
        return zzqw.zza(uri).exists();
    }

    @Override // com.google.android.gms.internal.nearby.zzro
    public final File zzg(Uri uri) throws IOException {
        return zzqw.zza(uri);
    }

    @Override // com.google.android.gms.internal.nearby.zzro
    public final OutputStream zzj(Uri uri) throws IOException {
        File fileZza = zzqw.zza(uri);
        zzaeu.zza(fileZza);
        return new zzrg(new FileOutputStream(fileZza), fileZza);
    }

    @Override // com.google.android.gms.internal.nearby.zzro
    public final void zzk(Uri uri) throws IOException {
        File fileZza = zzqw.zza(uri);
        if (fileZza.isDirectory()) {
            throw new FileNotFoundException(String.format("%s is a directory", uri));
        }
        if (fileZza.delete()) {
            return;
        }
        if (!fileZza.exists()) {
            throw new FileNotFoundException(String.format("%s does not exist", uri));
        }
        throw new IOException(String.format("%s could not be deleted", uri));
    }

    @Override // com.google.android.gms.internal.nearby.zzro
    public final void zzl(Uri uri, Uri uri2) throws IOException {
        File fileZza = zzqw.zza(uri);
        File fileZza2 = zzqw.zza(uri2);
        zzaeu.zza(fileZza2);
        if (!fileZza.renameTo(fileZza2)) {
            throw new IOException(String.format("%s could not be renamed to %s", uri, uri2));
        }
    }
}
