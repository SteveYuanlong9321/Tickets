package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.uwb.RangingPosition;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfh> CREATOR = new zzfi();
    private zzfc zza;
    private zzfc zzb;
    private zzfc zzc;
    private long zzd;
    private final int zze;
    private zzcu zzf;
    private final zzep zzg;

    private zzfh() {
        this.zze = RangingPosition.RSSI_UNKNOWN;
        this.zzg = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfh) {
            zzfh zzfhVar = (zzfh) obj;
            if (Objects.equal(this.zza, zzfhVar.zza) && Objects.equal(this.zzb, zzfhVar.zzb) && Objects.equal(this.zzc, zzfhVar.zzc) && Objects.equal(Long.valueOf(this.zzd), Long.valueOf(zzfhVar.zzd)) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(zzfhVar.zze)) && Objects.equal(this.zzf, zzfhVar.zzf) && Objects.equal(this.zzg, zzfhVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Long.valueOf(this.zzd), Integer.valueOf(this.zze), this.zzf, this.zzg);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final zzfc zza() {
        return this.zza;
    }

    public final zzfc zzb() {
        return this.zzb;
    }

    public final zzfc zzc() {
        return this.zzc;
    }

    public final long zzd() {
        return this.zzd;
    }

    public final int zze() {
        return this.zze;
    }

    public final zzcu zzf() {
        return this.zzf;
    }

    public final zzep zzg() {
        return this.zzg;
    }

    zzfh(zzfc zzfcVar, zzfc zzfcVar2, zzfc zzfcVar3, long j, int i, zzcu zzcuVar, zzep zzepVar) {
        this.zza = zzfcVar;
        this.zzb = zzfcVar2;
        this.zzc = zzfcVar3;
        this.zzd = j;
        this.zze = i;
        this.zzf = zzcuVar;
        this.zzg = zzepVar;
    }
}
