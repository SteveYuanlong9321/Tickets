package com.google.android.gms.nearby.connection.v3.dct;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzh {
    private final Uri zza;
    private final long zzb;
    private final String zzc;
    private final byte[] zzd;
    private final Map zze;

    /* synthetic */ zzh(Uri uri, long j, Map map, byte[] bArr) {
        this.zza = uri;
        this.zzb = j;
        this.zzc = null;
        this.zzd = null;
        this.zze = map;
    }

    /* synthetic */ zzh(Uri uri, String str, byte[] bArr, long j, byte[] bArr2) {
        this.zza = uri;
        this.zzb = j;
        this.zzc = str;
        this.zzd = bArr;
        this.zze = null;
    }

    public final Uri zza() {
        return this.zza;
    }

    public final long zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final byte[] zzd() {
        return this.zzd;
    }

    public final Map zze() {
        return this.zze;
    }
}
