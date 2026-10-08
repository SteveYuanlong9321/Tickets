package com.google.android.gms.nearby.uwb;

import com.google.android.gms.internal.nearby.zzxm;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class UwbRangeLimitsConfig {
    private final int zza;
    private final int zzb;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public static class Builder {
        private int zza = 0;
        private int zzb = 0;

        public UwbRangeLimitsConfig build() {
            return new UwbRangeLimitsConfig(this.zza, this.zzb, null);
        }

        public Builder setRangeMaxNumberOfMeasurements(int i) {
            this.zza = i;
            return this;
        }

        public Builder setRangeMaxRangingRoundRetries(int i) {
            this.zzb = i;
            return this;
        }
    }

    /* synthetic */ UwbRangeLimitsConfig(int i, int i2, byte[] bArr) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException(zzxm.zzd("Uwb Range Max Number of Measurements %s should be less than %s", Integer.valueOf(i), 65535));
        }
        if (i2 < 0 || i2 > 65535) {
            throw new IllegalArgumentException(zzxm.zzd("UWB Range Max Ranging Round Retries should be less than and %s", 65535));
        }
        this.zza = i;
        this.zzb = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UwbRangeLimitsConfig)) {
            return false;
        }
        UwbRangeLimitsConfig uwbRangeLimitsConfig = (UwbRangeLimitsConfig) obj;
        return this.zza == uwbRangeLimitsConfig.zza && this.zzb == uwbRangeLimitsConfig.zzb;
    }

    public int getRangeMaxNumberOfMeasurements() {
        return this.zza;
    }

    public int getRangeMaxRangingRoundRetries() {
        return this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.zza), Integer.valueOf(this.zzb));
    }

    public final String toString() {
        int i = this.zza;
        int length = String.valueOf(i).length();
        int i2 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 80 + String.valueOf(i2).length() + 1);
        sb.append("UwbRangeLimitsConfig{rangeMaxNumberOfMeasurements=");
        sb.append(i);
        sb.append(", rangeMaxRangingRoundRetries=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
