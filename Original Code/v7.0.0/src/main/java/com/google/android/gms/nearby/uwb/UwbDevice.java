package com.google.android.gms.nearby.uwb;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class UwbDevice {
    private final UwbAddress zza;

    private UwbDevice(UwbAddress uwbAddress) {
        this.zza = uwbAddress;
    }

    public static UwbDevice createForAddress(String str) {
        return new UwbDevice(new UwbAddress(str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UwbDevice) {
            return Objects.equals(this.zza, ((UwbDevice) obj).zza);
        }
        return false;
    }

    public UwbAddress getAddress() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza);
    }

    public String toString() {
        return String.format("UwbDevice {%s}", this.zza);
    }

    public static UwbDevice createForAddress(byte[] bArr) {
        return new UwbDevice(new UwbAddress(bArr));
    }
}
