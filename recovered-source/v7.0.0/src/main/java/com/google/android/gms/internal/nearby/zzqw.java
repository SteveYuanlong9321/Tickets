package com.google.android.gms.internal.nearby;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzqw {
    public static final File zza(Uri uri) throws zzrc {
        if (!uri.getScheme().equals("file")) {
            throw new zzrc("Scheme must be 'file'");
        }
        if (!TextUtils.isEmpty(uri.getQuery())) {
            throw new zzrc("Did not expect uri to have query");
        }
        if (TextUtils.isEmpty(uri.getAuthority())) {
            return new File(uri.getPath());
        }
        throw new zzrc("Did not expect uri to have authority");
    }
}
