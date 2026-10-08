package com.google.android.gms.nearby.uwb;

import com.google.android.gms.internal.nearby.zzyg;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class RangingCapabilities {
    public static final boolean DEFAULT_SUPPORTS_RANGING_INTERVAL_RECONFIGURE = false;
    public static final float FIRA_DEFAULT_MIN_SLOT_DURATION_MS = 2.0f;
    public static final int FIRA_DEFAULT_RANGING_INTERVAL_MS = 200;
    public static final int FIRA_DEFAULT_SUPPORTED_CHANNEL = 9;
    public static final int RANGE_DATA_NTF_ENABLE = 1;
    private final boolean zza;
    private final boolean zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final int zze;
    private final zzyg zzf;
    private final zzyg zzg;
    private final zzyg zzh;
    private final zzyg zzi;
    private final zzyg zzj;
    private final boolean zzk;
    public static final List<Integer> FIRA_DEFAULT_SUPPORTED_CONFIG_IDS = zzyg.zzo(1, 2, 3, 1000, 1001);
    public static final List<Integer> DEFAULT_SUPPORTED_SLOT_DURATIONS = zzyg.zzk(2);
    public static final List<Integer> DEFAULT_SUPPORTED_RANGING_UPDATE_RATES = zzyg.zzl(1, 2);

    public RangingCapabilities(boolean z, boolean z2, boolean z3, boolean z4, int i, zzyg zzygVar, zzyg zzygVar2, zzyg zzygVar3, zzyg zzygVar4, zzyg zzygVar5, boolean z5) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = z4;
        this.zze = i;
        this.zzf = zzygVar;
        this.zzg = zzygVar2;
        this.zzh = zzygVar3;
        this.zzi = zzygVar4;
        this.zzj = zzygVar5;
        this.zzk = z5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RangingCapabilities)) {
            return false;
        }
        RangingCapabilities rangingCapabilities = (RangingCapabilities) obj;
        return this.zza == rangingCapabilities.zza && this.zzb == rangingCapabilities.zzb && this.zzc == rangingCapabilities.zzc && this.zzd == rangingCapabilities.zzd && getMinRangingInterval() == rangingCapabilities.getMinRangingInterval() && Objects.equals(getSupportedChannels(), rangingCapabilities.getSupportedChannels()) && Objects.equals(getSupportedNtfConfigs(), rangingCapabilities.getSupportedNtfConfigs()) && Objects.equals(getSupportedConfigIds(), rangingCapabilities.getSupportedConfigIds()) && Objects.equals(getSupportedSlotDurations(), rangingCapabilities.getSupportedSlotDurations()) && Objects.equals(getSupportedRangingUpdateRates(), rangingCapabilities.getSupportedRangingUpdateRates()) && this.zzk == rangingCapabilities.zzk;
    }

    public int getMinRangingInterval() {
        return this.zze;
    }

    public List<Integer> getSupportedChannels() {
        return this.zzf;
    }

    public List<Integer> getSupportedConfigIds() {
        return this.zzh;
    }

    public List<Integer> getSupportedNtfConfigs() {
        return this.zzg;
    }

    public List<Integer> getSupportedRangingUpdateRates() {
        return this.zzj;
    }

    public List<Integer> getSupportedSlotDurations() {
        return this.zzi;
    }

    public boolean hasBackgroundRangingSupport() {
        return this.zzk;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.zza), Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Integer.valueOf(getMinRangingInterval()), getSupportedChannels(), getSupportedNtfConfigs(), getSupportedConfigIds(), getSupportedSlotDurations(), getSupportedRangingUpdateRates(), Boolean.valueOf(this.zzk));
    }

    public boolean supportsAzimuthalAngle() {
        return this.zzb;
    }

    public boolean supportsDistance() {
        return this.zza;
    }

    public boolean supportsElevationAngle() {
        return this.zzc;
    }

    public boolean supportsRangingIntervalReconfigure() {
        return this.zzd;
    }

    public String toString() {
        zzyg zzygVar = this.zzj;
        zzyg zzygVar2 = this.zzi;
        zzyg zzygVar3 = this.zzh;
        zzyg zzygVar4 = this.zzg;
        String strValueOf = String.valueOf(this.zzf);
        String strValueOf2 = String.valueOf(zzygVar4);
        String strValueOf3 = String.valueOf(zzygVar3);
        String strValueOf4 = String.valueOf(zzygVar2);
        String strValueOf5 = String.valueOf(zzygVar);
        boolean z = this.zza;
        int length = String.valueOf(z).length();
        boolean z2 = this.zzb;
        int length2 = String.valueOf(z2).length();
        boolean z3 = this.zzc;
        int length3 = String.valueOf(z3).length();
        boolean z4 = this.zzd;
        int length4 = String.valueOf(z4).length();
        int i = this.zze;
        int length5 = String.valueOf(i).length();
        int length6 = String.valueOf(strValueOf).length();
        int length7 = String.valueOf(strValueOf2).length();
        int length8 = String.valueOf(strValueOf3).length();
        StringBuilder sb = new StringBuilder(length + 62 + length2 + 25 + length3 + 37 + length4 + 21 + length5 + 20 + length6 + 22 + length7 + 21 + length8 + 25 + String.valueOf(strValueOf4).length() + 30 + String.valueOf(strValueOf5).length() + 1);
        sb.append("RangingCapabilities{supportsDistance=");
        sb.append(z);
        sb.append(", supportsAzimuthalAngle=");
        sb.append(z2);
        sb.append(", supportsElevationAngle=");
        sb.append(z3);
        sb.append(", supportsRangingIntervalReconfigure=");
        sb.append(z4);
        sb.append(", minRangingInterval=");
        sb.append(i);
        sb.append(", supportedChannels=");
        sb.append(strValueOf);
        sb.append(", supportedNtfConfigs=");
        sb.append(strValueOf2);
        sb.append(", supportedConfigIds=");
        sb.append(strValueOf3);
        sb.append(", supportedSlotDurations=");
        sb.append(strValueOf4);
        sb.append(", supportedRangingUpdateRates=");
        sb.append(strValueOf5);
        sb.append("}");
        return sb.toString();
    }
}
