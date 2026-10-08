package com.google.android.gms.nearby.uwb;

import androidx.compose.animation.core.AnimationKt;
import com.google.android.gms.internal.nearby.zzcu;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class RangingPosition {
    public static final int RSSI_MAX = -1;
    public static final int RSSI_MIN = -127;
    public static final int RSSI_UNKNOWN = -128;
    private final RangingMeasurement zza;
    private final RangingMeasurement zzb;
    private final RangingMeasurement zzc;
    private final long zzd;
    private final int zze;
    private final PreciseEstimateInfo zzf;

    public RangingPosition(RangingMeasurement rangingMeasurement, RangingMeasurement rangingMeasurement2, RangingMeasurement rangingMeasurement3, long j, int i, zzcu zzcuVar, PreciseEstimateInfo preciseEstimateInfo) {
        this.zza = rangingMeasurement;
        this.zzb = rangingMeasurement2;
        this.zzc = rangingMeasurement3;
        this.zzd = j;
        this.zze = i;
        this.zzf = preciseEstimateInfo;
    }

    public RangingMeasurement getAzimuth() {
        return this.zzb;
    }

    public RangingMeasurement getDistance() {
        return this.zza;
    }

    public long getElapsedRealtimeNanos() {
        return this.zzd;
    }

    public RangingMeasurement getElevation() {
        return this.zzc;
    }

    public PreciseEstimateInfo getPreciseEstimateInfo() {
        return this.zzf;
    }

    public int getRssiDbm() {
        return this.zze;
    }

    public String toString() {
        String strConcat = String.format(Locale.US, "elapsedRealtime (ms) %d | distance (m) %f", Long.valueOf(this.zzd / AnimationKt.MillisToNanos), Float.valueOf(this.zza.getValue()));
        RangingMeasurement rangingMeasurement = this.zzb;
        if (rangingMeasurement != null) {
            String str = String.format(Locale.US, " | azimuth: %f", Float.valueOf(rangingMeasurement.getValue()));
            String.valueOf(strConcat);
            String.valueOf(str);
            strConcat = String.valueOf(strConcat).concat(String.valueOf(str));
        }
        RangingMeasurement rangingMeasurement2 = this.zzc;
        if (rangingMeasurement2 != null) {
            String str2 = String.format(Locale.US, " | elevation: %f", Float.valueOf(rangingMeasurement2.getValue()));
            String.valueOf(strConcat);
            String.valueOf(str2);
            strConcat = String.valueOf(strConcat).concat(String.valueOf(str2));
        }
        String str3 = String.format(Locale.US, " | rssi: %d", Integer.valueOf(this.zze));
        String.valueOf(strConcat);
        String.valueOf(str3);
        String strValueOf = String.valueOf(str3);
        PreciseEstimateInfo preciseEstimateInfo = this.zzf;
        String strConcat2 = String.valueOf(strConcat).concat(strValueOf);
        if (preciseEstimateInfo == null) {
            return strConcat2;
        }
        String str4 = String.format(Locale.US, " | preciseEstimateInfo: %s", preciseEstimateInfo);
        String.valueOf(str4);
        return strConcat2.concat(String.valueOf(str4));
    }
}
