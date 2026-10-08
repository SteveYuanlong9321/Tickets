package com.google.android.gms.nearby.connection.v3.dct;

import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zze {
    final byte[] zza;
    final ParcelFileDescriptor zzb;
    final long zzc;
    final Uri zzd;

    public zze(Uri uri, ParcelFileDescriptor parcelFileDescriptor, byte[] bArr, long j) {
        this.zza = bArr;
        this.zzb = parcelFileDescriptor;
        this.zzc = j;
        this.zzd = uri;
    }
}
