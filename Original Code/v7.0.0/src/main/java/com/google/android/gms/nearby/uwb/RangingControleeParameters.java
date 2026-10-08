package com.google.android.gms.nearby.uwb;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class RangingControleeParameters {
    private final UwbAddress zza;
    private final int zzb;
    private final byte[] zzc;

    public RangingControleeParameters(UwbAddress uwbAddress) {
        this.zza = uwbAddress;
        this.zzb = 0;
        this.zzc = null;
    }

    public RangingControleeParameters(UwbAddress uwbAddress, int i, byte[] bArr) {
        this.zza = uwbAddress;
        this.zzb = i;
        this.zzc = bArr;
    }

    public UwbAddress getAddress() {
        return this.zza;
    }

    public int getSubSessionId() {
        return this.zzb;
    }

    public byte[] getSubSessionKey() {
        return this.zzc;
    }
}
