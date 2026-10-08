package com.google.android.gms.internal.nearby;

import android.net.Uri;
import java.io.File;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzqv {
    private final Uri.Builder zza = new Uri.Builder().scheme("file").authority("").path("/");
    private final zzyc zzb;

    private zzqv() {
        int i = zzyg.zzd;
        this.zzb = new zzyc();
    }

    public final zzqv zza(File file) {
        this.zza.path(file.getAbsolutePath());
        return this;
    }

    public final Uri zzb() {
        return this.zza.encodedFragment(zzrj.zzb(this.zzb.zze())).build();
    }

    /* synthetic */ zzqv(byte[] bArr) {
        int i = zzyg.zzd;
        this.zzb = new zzyc();
    }
}
