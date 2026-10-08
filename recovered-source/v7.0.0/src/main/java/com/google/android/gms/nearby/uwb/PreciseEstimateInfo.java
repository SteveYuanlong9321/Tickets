package com.google.android.gms.nearby.uwb;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class PreciseEstimateInfo {
    private final int zza;
    private final int zzb;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    @Target({ElementType.TYPE_USE})
    public @interface EstimateFailureReason {
        public static final int BAD_STATE = 8;
        public static final int CAMERA_NOT_AVAILABLE = 5;
        public static final int EXCESSIVE_MOTION = 3;
        public static final int INCONCLUSIVE_RESULT = 7;
        public static final int INSUFFICIENT_FEATURES = 4;
        public static final int INSUFFICIENT_LIGHT = 2;
        public static final int MISSING_GL_CONTEXT = 9;
        public static final int NONE = 0;
        public static final int NOT_AVAILABLE = 1;
        public static final int PEER_MOVING = 6;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    @Target({ElementType.TYPE_USE})
    public @interface EstimateKind {
        public static final int DRIFTING = 2;
        public static final int IMPRECISE = 1;
        public static final int PRECISE = 0;
    }

    public PreciseEstimateInfo(int i, int i2) {
        Preconditions.checkArgument((i == 1) == (i2 != 0), "Estimate failure reason should be NONE if and only if the estimate kind is PRECISE or DRIFTING");
        this.zza = i;
        this.zzb = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PreciseEstimateInfo) {
            PreciseEstimateInfo preciseEstimateInfo = (PreciseEstimateInfo) obj;
            if (this.zza == preciseEstimateInfo.zza && this.zzb == preciseEstimateInfo.zzb) {
                return true;
            }
        }
        return false;
    }

    public int getEstimateFailureReason() {
        return this.zzb;
    }

    public int getEstimateKind() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.zza), Integer.valueOf(this.zzb));
    }

    public String toString() {
        return String.format(Locale.US, "estimateKind: %d, estimateFailureReason: %d", Integer.valueOf(this.zza), Integer.valueOf(this.zzb));
    }
}
