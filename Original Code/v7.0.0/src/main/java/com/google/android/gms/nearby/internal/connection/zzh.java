package com.google.android.gms.nearby.internal.connection;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();
    private zzek zza;
    private long zzb;
    private final int zzc;

    private zzh() {
        this.zzc = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzh) {
            zzh zzhVar = (zzh) obj;
            if (Objects.equal(this.zza, zzhVar.zza) && Objects.equal(Long.valueOf(this.zzb), Long.valueOf(zzhVar.zzb)) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzhVar.zzc))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Long.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzek zzekVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzekVar == null ? null : zzekVar.asBinder(), false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ void zza(zzek zzekVar) {
        this.zza = zzekVar;
    }

    final /* synthetic */ void zzb(long j) {
        this.zzb = j;
    }

    zzh(IBinder iBinder, long j, int i) {
        zzek zzeiVar;
        if (iBinder == null) {
            zzeiVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzeiVar = iInterfaceQueryLocalInterface instanceof zzek ? (zzek) iInterfaceQueryLocalInterface : new zzei(iBinder);
        }
        this.zza = zzeiVar;
        this.zzb = j;
        this.zzc = i;
    }
}
