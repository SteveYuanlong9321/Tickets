package com.google.android.gms.nearby.connection;

import android.bluetooth.BluetoothDevice;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzt {
    private String zza;
    private String zzb;
    private BluetoothDevice zzc;
    private byte[] zzd;

    public final zzt zza(String str) {
        this.zza = str;
        return this;
    }

    public final zzt zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzt zzc(BluetoothDevice bluetoothDevice) {
        this.zzc = bluetoothDevice;
        this.zzb = "__UNRECOGNIZED_BLUETOOTH_DEVICE__";
        this.zzd = "__UNRECOGNIZED_BLUETOOTH_DEVICE__".getBytes();
        return this;
    }

    public final zzt zzd(byte[] bArr) {
        this.zzd = bArr;
        return this;
    }

    public final DiscoveredEndpointInfo zze() {
        return new DiscoveredEndpointInfo(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
