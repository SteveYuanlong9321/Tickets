package com.google.android.gms.nearby.connection.v3.dct;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class zzi {
    private final boolean zza;
    private final long zzb;
    private final String zzc;
    private final boolean zzd;

    /* synthetic */ zzi(long j, String str, boolean z, boolean z2, byte[] bArr) {
        if (j == 0) {
            throw new NullPointerException("Cannot create a DctPayload BytesResponse from invalid requestId.");
        }
        this.zzb = j;
        this.zzc = str;
        this.zza = z;
        this.zzd = z2;
        Log.i("NC_DctPayload", String.format("created response with requestId: %d, contentType: %s, isLast: %b, isMultiPart: %b", Long.valueOf(j), str, Boolean.valueOf(z), Boolean.valueOf(z2)));
    }

    public final boolean zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final long zzd() {
        return this.zzb;
    }

    public final boolean zze() {
        return this.zzd;
    }
}
