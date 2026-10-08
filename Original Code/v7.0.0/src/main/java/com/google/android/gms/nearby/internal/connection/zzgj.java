package com.google.android.gms.nearby.internal.connection;

import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgj {
    private final zzgk zza = new zzgk(null);

    public final zzgj zza(byte[] bArr) {
        this.zza.zze(bArr);
        return this;
    }

    public final zzgj zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zzf(parcelFileDescriptor);
        return this;
    }

    public final zzgj zzc(long j) {
        this.zza.zzg(j);
        return this;
    }

    public final zzgj zzd(Uri uri) {
        this.zza.zzh(uri);
        return this;
    }

    public final zzgk zze() {
        return this.zza;
    }
}
