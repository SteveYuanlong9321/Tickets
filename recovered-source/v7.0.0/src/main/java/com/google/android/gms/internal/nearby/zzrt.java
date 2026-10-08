package com.google.android.gms.internal.nearby;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public interface zzrt {
    String zza();

    default InputStream zzb(Uri uri, InputStream inputStream) throws IOException {
        if (inputStream != null) {
            inputStream.close();
        }
        String strZza = zza();
        String.valueOf(strZza);
        throw new zzre("wrapForRead not supported by ".concat(String.valueOf(strZza)));
    }

    default OutputStream zzc(Uri uri, OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            outputStream.close();
        }
        String strZza = zza();
        String.valueOf(strZza);
        throw new zzre("wrapForWrite not supported by ".concat(String.valueOf(strZza)));
    }
}
