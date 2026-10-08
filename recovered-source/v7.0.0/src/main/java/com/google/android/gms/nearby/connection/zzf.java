package com.google.android.gms.nearby.connection;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzf {
    private byte[] zza;
    private byte[] zzb;
    private byte[] zzc;
    private byte[] zzd;
    private byte[] zze;

    public final zzf zza(byte[] bArr) {
        this.zza = bArr;
        return this;
    }

    public final zzf zzb(byte[] bArr) {
        this.zzd = bArr;
        return this;
    }

    public final zzf zzc(byte[] bArr) {
        this.zze = bArr;
        return this;
    }

    public final zzf zzd(byte[] bArr) {
        if (bArr.length == 0) {
            throw new IllegalArgumentException("BLE GATT Characteristic should not be empty.");
        }
        this.zzb = bArr;
        return this;
    }

    public final zzf zze(byte[] bArr) {
        if (bArr.length == 0) {
            throw new IllegalArgumentException("Actions length is 0.");
        }
        this.zzc = bArr;
        return this;
    }

    public final zzg zzf() {
        return new zzg(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }
}
