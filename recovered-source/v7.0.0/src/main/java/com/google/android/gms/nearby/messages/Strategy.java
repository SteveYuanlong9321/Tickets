package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class Strategy extends AbstractSafeParcelable {

    @Deprecated
    public static final Strategy BLE_ONLY;
    public static final Parcelable.Creator<Strategy> CREATOR = new zzc();
    public static final Strategy DEFAULT = new Builder().build();
    public static final int DISCOVERY_MODE_BROADCAST = 1;
    public static final int DISCOVERY_MODE_DEFAULT = 3;
    public static final int DISCOVERY_MODE_SCAN = 2;
    public static final int DISTANCE_TYPE_DEFAULT = 0;
    public static final int DISTANCE_TYPE_EARSHOT = 1;
    public static final int TTL_SECONDS_DEFAULT = 300;
    public static final int TTL_SECONDS_INFINITE = Integer.MAX_VALUE;
    public static final int TTL_SECONDS_MAX = 86400;
    final int zza;

    @Deprecated
    final int zzb;
    final int zzc;
    final int zzd;

    @Deprecated
    final boolean zze;
    final int zzf;
    final int zzg;
    private final int zzh;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public static class Builder {
        private int zza = 3;
        private int zzb = 300;
        private int zzc = 0;
        private int zzd = -1;

        public Strategy build() {
            if (this.zzd == 2 && this.zzc == 1) {
                throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
            }
            return new Strategy(2, 0, this.zzb, this.zzc, false, this.zzd, this.zza, 0);
        }

        public Builder setDiscoveryMode(int i) {
            this.zza = i;
            return this;
        }

        public Builder setDistanceType(int i) {
            this.zzc = i;
            return this;
        }

        public Builder setTtlSeconds(int i) {
            boolean z = true;
            if (i != Integer.MAX_VALUE && (i <= 0 || i > 86400)) {
                z = false;
            }
            Preconditions.checkArgument(z, "mTtlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", Integer.valueOf(i), Integer.valueOf(Strategy.TTL_SECONDS_MAX));
            this.zzb = i;
            return this;
        }

        public final Builder zza(int i) {
            this.zzd = 2;
            return this;
        }
    }

    static {
        Builder builder = new Builder();
        builder.zza(2);
        builder.setTtlSeconds(Integer.MAX_VALUE);
        BLE_ONLY = builder.build();
    }

    /* JADX WARN: Code duplicated, block: B:4:0x000b A[PHI: r8
      0x000b: PHI (r8v2 int) = (r8v0 int), (r8v1 int) binds: [B:3:0x0009, B:7:0x0011] A[DONT_GENERATE, DONT_INLINE]] */
    Strategy(int i, int i2, int i3, int i4, boolean z, int i5, int i6, int i7) {
        this.zza = i;
        this.zzb = i2;
        if (i2 == 0) {
            this.zzg = i6;
        } else if (i2 != 2) {
            i6 = 3;
            if (i2 != 3) {
                this.zzg = i6;
            } else {
                this.zzg = 2;
            }
        } else {
            this.zzg = 1;
        }
        this.zzd = i4;
        this.zze = z;
        if (z) {
            this.zzf = 2;
            this.zzc = Integer.MAX_VALUE;
        } else {
            this.zzc = i3;
            this.zzf = (i5 == -1 || i5 == 0 || i5 == 1 || i5 == 6) ? -1 : i5;
        }
        this.zzh = i7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) obj;
        return this.zza == strategy.zza && this.zzg == strategy.zzg && this.zzc == strategy.zzc && this.zzd == strategy.zzd && this.zzf == strategy.zzf && this.zzh == strategy.zzh;
    }

    public int hashCode() {
        return (((((((((this.zza * 31) + this.zzg) * 31) + this.zzc) * 31) + this.zzd) * 31) + this.zzf) * 31) + this.zzh;
    }

    public String toString() {
        String string;
        String string2;
        String string3;
        int i = this.zzd;
        String string4 = "DEFAULT";
        if (i == 0) {
            string = "DEFAULT";
        } else if (i != 1) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 8);
            sb.append("UNKNOWN:");
            sb.append(i);
            string = sb.toString();
        } else {
            string = "EARSHOT";
        }
        int i2 = this.zzf;
        if (i2 == -1) {
            string2 = "DEFAULT";
        } else {
            ArrayList arrayList = new ArrayList();
            if ((i2 & 4) > 0) {
                arrayList.add("ULTRASOUND");
            }
            if ((i2 & 2) > 0) {
                arrayList.add("BLE");
            }
            if (arrayList.isEmpty()) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(i2).length() + 8);
                sb2.append("UNKNOWN:");
                sb2.append(i2);
                string2 = sb2.toString();
            } else {
                string2 = arrayList.toString();
            }
        }
        int i3 = this.zzg;
        if (i3 == 3) {
            string3 = "DEFAULT";
        } else {
            ArrayList arrayList2 = new ArrayList();
            if ((i3 & 1) > 0) {
                arrayList2.add("BROADCAST");
            }
            if ((i3 & 2) > 0) {
                arrayList2.add("SCAN");
            }
            if (arrayList2.isEmpty()) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(i3).length() + 8);
                sb3.append("UNKNOWN:");
                sb3.append(i3);
                string3 = sb3.toString();
            } else {
                string3 = arrayList2.toString();
            }
        }
        int i4 = this.zzh;
        if (i4 != 0) {
            if (i4 != 1) {
                StringBuilder sb4 = new StringBuilder(String.valueOf(i4).length() + 9);
                sb4.append("UNKNOWN: ");
                sb4.append(i4);
                string4 = sb4.toString();
            } else {
                string4 = "ALWAYS_ON";
            }
        }
        int i5 = this.zzc;
        StringBuilder sb5 = new StringBuilder(String.valueOf(i5).length() + 35 + string.length() + 18 + String.valueOf(string2).length() + 16 + String.valueOf(string3).length() + 21 + string4.length() + 1);
        sb5.append("Strategy{ttlSeconds=");
        sb5.append(i5);
        sb5.append(", distanceType=");
        sb5.append(string);
        sb5.append(", discoveryMedium=");
        sb5.append(string2);
        sb5.append(", discoveryMode=");
        sb5.append(string3);
        sb5.append(", backgroundScanMode=");
        sb5.append(string4);
        sb5.append("}");
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zzb;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zze);
        SafeParcelWriter.writeInt(parcel, 5, this.zzf);
        SafeParcelWriter.writeInt(parcel, 6, this.zzg);
        SafeParcelWriter.writeInt(parcel, 7, this.zzh);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zzh;
    }
}
