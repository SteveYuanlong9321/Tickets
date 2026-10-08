package com.google.android.gms.nearby.connection;

import android.bluetooth.BluetoothDevice;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class DiscoveredEndpointInfo {
    private final String zza;
    private final String zzb;
    private final byte[] zzc;

    @Deprecated
    public DiscoveredEndpointInfo(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str2.getBytes();
    }

    /* synthetic */ DiscoveredEndpointInfo(String str, String str2, BluetoothDevice bluetoothDevice, byte[] bArr, byte[] bArr2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bArr;
    }

    public byte[] getEndpointInfo() {
        return this.zzc;
    }

    public String getEndpointName() {
        return this.zzb;
    }

    public String getServiceId() {
        return this.zza;
    }
}
