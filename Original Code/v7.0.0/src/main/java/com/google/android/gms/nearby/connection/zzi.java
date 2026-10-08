package com.google.android.gms.nearby.connection;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzi {
    private byte[] zza;
    private byte[] zzb;
    private byte[] zzc;

    public final zzi zza(byte[] bArr) {
        this.zza = bArr;
        return this;
    }

    public final zzi zzb(byte[] bArr) {
        this.zzb = bArr;
        return this;
    }

    public final zzi zzc(byte[] bArr) {
        if (bArr.length == 0) {
            throw new IllegalArgumentException("Actions length is 0.");
        }
        this.zzc = bArr;
        return this;
    }

    public final zzj zzd() {
        return new zzj(this.zza, this.zzb, this.zzc);
    }
}
