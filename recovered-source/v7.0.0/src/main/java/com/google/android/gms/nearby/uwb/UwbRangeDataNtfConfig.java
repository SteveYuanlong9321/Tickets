package com.google.android.gms.nearby.uwb;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.internal.nearby.zzxd;
import com.google.android.gms.internal.nearby.zzyg;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class UwbRangeDataNtfConfig {
    public static final zzyg zza = zzyg.zzn(0, 1, 2, 3);
    private final int zzb;
    private final int zzc;
    private final int zzd;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public static class Builder {
        private int zza = 1;
        private int zzb = 0;
        private int zzc = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;

        public UwbRangeDataNtfConfig build() {
            return new UwbRangeDataNtfConfig(this.zza, this.zzb, this.zzc, null);
        }

        public Builder setNtfProximityFar(int i) {
            this.zzc = i;
            return this;
        }

        public Builder setNtfProximityNear(int i) {
            this.zzb = i;
            return this;
        }

        public Builder setRangeDataConfigType(int i) {
            this.zza = i;
            return this;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public @interface RangeDataNtfConfig {
        public static final int RANGE_DATA_NTF_DISABLE = 0;
        public static final int RANGE_DATA_NTF_ENABLE = 1;
        public static final int RANGE_DATA_NTF_ENABLE_PROXIMITY_EDGE_TRIG = 3;
        public static final int RANGE_DATA_NTF_ENABLE_PROXIMITY_LEVEL_TRIG = 2;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0025  */
    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    /* JADX WARN: Code duplicated, block: B:14:0x002c  */
    /* JADX WARN: Code duplicated, block: B:15:0x002f  */
    /* synthetic */ UwbRangeDataNtfConfig(int i, int i2, int i3, byte[] bArr) {
        zzxd.zzb(zza.contains(Integer.valueOf(i)), "Invalid/unsupported range data notification config");
        boolean z = true;
        zzxd.zzb(i2 <= i3, "Proximity near cannot be greater than proximity far");
        if (i == 1) {
            if (i2 == 0) {
                z = false;
            } else if (i3 == 20000) {
                i3 = 20000;
                i2 = 0;
            } else {
                i2 = 0;
                z = false;
            }
            zzxd.zzb(z, "Proximity near and far distances are not set to default");
        } else if (i == 0) {
            i = 0;
            if (i2 == 0) {
                z = false;
            } else if (i3 == 20000) {
                i3 = 20000;
                i2 = 0;
            } else {
                i2 = 0;
                z = false;
            }
            zzxd.zzb(z, "Proximity near and far distances are not set to default");
        }
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UwbRangeDataNtfConfig)) {
            return false;
        }
        UwbRangeDataNtfConfig uwbRangeDataNtfConfig = (UwbRangeDataNtfConfig) obj;
        return this.zzb == uwbRangeDataNtfConfig.zzb && this.zzc == uwbRangeDataNtfConfig.zzc && this.zzd == uwbRangeDataNtfConfig.zzd;
    }

    public int getNtfProximityFar() {
        return this.zzd;
    }

    public int getNtfProximityNear() {
        return this.zzc;
    }

    public int getRangeDataNtfConfigType() {
        return this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd));
    }

    public final String toString() {
        int i = this.zzb;
        int length = String.valueOf(i).length();
        int i2 = this.zzc;
        int length2 = String.valueOf(i2).length();
        int i3 = this.zzd;
        StringBuilder sb = new StringBuilder(length + 66 + length2 + 19 + String.valueOf(i3).length() + 1);
        sb.append("UwbRangeDataNtfConfig{mRangeDataNtfConfigType=");
        sb.append(i);
        sb.append(", mNtfProximityNear=");
        sb.append(i2);
        sb.append(", mNtfProximityFar=");
        sb.append(i3);
        sb.append("}");
        return sb.toString();
    }
}
