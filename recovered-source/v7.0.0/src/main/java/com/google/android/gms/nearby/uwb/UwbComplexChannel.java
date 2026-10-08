package com.google.android.gms.nearby.uwb;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class UwbComplexChannel {
    private final int zza;
    private final int zzb;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public static class Builder {
        private int zza;
        private int zzb;

        public UwbComplexChannel build() {
            return new UwbComplexChannel(this.zza, this.zzb, null);
        }

        public Builder setChannel(int i) {
            this.zza = i;
            return this;
        }

        public Builder setPreambleIndex(int i) {
            this.zzb = i;
            return this;
        }
    }

    /* synthetic */ UwbComplexChannel(int i, int i2, byte[] bArr) {
        this.zza = i;
        this.zzb = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UwbComplexChannel)) {
            return false;
        }
        UwbComplexChannel uwbComplexChannel = (UwbComplexChannel) obj;
        return this.zza == uwbComplexChannel.zza && this.zzb == uwbComplexChannel.zzb;
    }

    public int getChannel() {
        return this.zza;
    }

    public int getPreambleIndex() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.zza), Integer.valueOf(this.zzb));
    }

    public String toString() {
        int i = this.zza;
        int length = String.valueOf(i).length();
        int i2 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 42 + String.valueOf(i2).length() + 1);
        sb.append("UwbComplexChannel{channel=");
        sb.append(i);
        sb.append(", preambleIndex=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
