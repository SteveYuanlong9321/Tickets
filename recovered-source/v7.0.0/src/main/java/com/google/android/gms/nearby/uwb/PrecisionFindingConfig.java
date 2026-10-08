package com.google.android.gms.nearby.uwb;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.PointerIconCompat;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.nearby.zzyl;
import java.time.Duration;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class PrecisionFindingConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PrecisionFindingConfig> CREATOR = new zza();
    public static final zzyl zza = zzyl.zzk(1, 3, 4, 6, Integer.valueOf(PointerIconCompat.TYPE_HAND), Integer.valueOf(PointerIconCompat.TYPE_HELP), Integer.valueOf(PointerIconCompat.TYPE_WAIT), 1005);
    private final long zzb;
    private final ArOdometryProvider zzc;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public static final class Builder {
        private long zza = 1000;
        private ArOdometryProvider zzb;

        public PrecisionFindingConfig build() {
            return new PrecisionFindingConfig(this, null);
        }

        public Builder setArOdometryProvider(ArOdometryProvider arOdometryProvider) {
            this.zzb = arOdometryProvider;
            return this;
        }

        public Builder setDataStalenessThreshold(Duration duration) {
            this.zza = duration.toMillis();
            return this;
        }

        final /* synthetic */ long zza() {
            return this.zza;
        }

        final /* synthetic */ ArOdometryProvider zzb() {
            return this.zzb;
        }
    }

    PrecisionFindingConfig(long j) {
        this.zzb = j;
        this.zzc = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PrecisionFindingConfig) {
            PrecisionFindingConfig precisionFindingConfig = (PrecisionFindingConfig) obj;
            if (this.zzb == precisionFindingConfig.zzb && Objects.equals(this.zzc, precisionFindingConfig.zzc)) {
                return true;
            }
        }
        return false;
    }

    public ArOdometryProvider getArOdometryProvider() {
        return this.zzc;
    }

    public long getDataStalenessThresholdMs() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.zzb), this.zzc);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getDataStalenessThresholdMs());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    /* synthetic */ PrecisionFindingConfig(Builder builder, byte[] bArr) {
        this.zzb = builder.zza();
        this.zzc = builder.zzb();
    }
}
