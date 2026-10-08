package com.google.android.gms.internal.nearby;

import android.net.Uri;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzrp implements zzro {
    protected abstract zzro zzb();

    protected Uri zzf(Uri uri) throws IOException {
        throw null;
    }

    @Override // com.google.android.gms.internal.nearby.zzro
    public final OutputStream zzj(Uri uri) throws IOException {
        return zzb().zzj(zzf(uri));
    }

    @Override // com.google.android.gms.internal.nearby.zzro
    public final void zzk(Uri uri) throws IOException {
        zzb().zzk(zzf(uri));
    }

    @Override // com.google.android.gms.internal.nearby.zzro
    public final void zzl(Uri uri, Uri uri2) throws IOException {
        zzb().zzl(zzf(uri), zzf(uri2));
    }
}
