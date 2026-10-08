package com.google.android.gms.nearby.connection.v3.dct;

import android.net.Uri;
import com.google.android.gms.nearby.connection.Payload;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzj extends Payload {
    private final int zzc;
    private final zzh zzd;
    private final zzi zze;
    private final zzg zzf;

    private zzj(int i, long j, zzh zzhVar, zzi zziVar, zzg zzgVar) {
        super(j, 0, null, null, null);
        this.zzc = i;
        this.zzd = zzhVar;
        this.zze = zziVar;
        this.zzf = zzgVar;
    }

    public static zzj zzi(long j, String str, byte[] bArr) {
        return new zzj(4, j, null, null, new zzg(str, bArr, null));
    }

    public static zzj zzj(Uri uri, long j, long j2, String str, byte[] bArr, Map map) {
        if (bArr == null) {
            return new zzj(1, j, new zzh(uri, j2, map, null), null, null);
        }
        if (str != null) {
            return new zzj(1, j, new zzh(uri, str, bArr, j2, null), null, null);
        }
        throw new NullPointerException("Cannot create a DctPayload request from null contentType.");
    }

    public static zzj zzk(long j, long j2, List list, String str, boolean z, boolean z2) {
        return new zzj(2, j, null, new zzd(j2, list, str, z, z2, null), null);
    }

    public static zzj zzl(long j, long j2, List list, String str, boolean z, boolean z2) {
        return new zzj(3, j, null, new zzf(j2, list, str, z, z2, null), null);
    }

    public final zzg zzm() {
        return this.zzf;
    }

    public final zzh zzn() {
        return this.zzd;
    }

    public final zzi zzo() {
        return this.zze;
    }

    public final int zzp() {
        return this.zzc;
    }
}
