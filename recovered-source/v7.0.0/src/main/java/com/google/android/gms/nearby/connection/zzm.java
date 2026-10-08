package com.google.android.gms.nearby.connection;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzm {
    private String zza;
    private String zzb;
    private byte[] zzc;
    private boolean zzd;
    private boolean zze;
    private byte[] zzf;
    private int zzg = 0;

    public final zzm zza(String str) {
        this.zza = str;
        return this;
    }

    @Deprecated
    public final zzm zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzm zzc(byte[] bArr) {
        this.zzc = bArr;
        return this;
    }

    public final zzm zzd(boolean z) {
        this.zzd = z;
        return this;
    }

    public final zzm zze(byte[] bArr) {
        this.zzf = bArr;
        return this;
    }

    @Deprecated
    public final zzm zzf(boolean z) {
        this.zze = z;
        return this;
    }

    public final zzm zzg(int i) {
        this.zzg = i;
        return this;
    }

    public final ConnectionInfo zzh() {
        return new ConnectionInfo(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, null);
    }
}
