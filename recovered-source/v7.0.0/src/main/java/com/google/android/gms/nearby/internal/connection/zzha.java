package com.google.android.gms.nearby.internal.connection;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.v3.dct.DctDevice;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzha extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzha> CREATOR = new zzhb();
    private zzek zza;
    private String zzb;
    private final int zzc;
    private com.google.android.gms.internal.nearby.zzbz zzd;
    private com.google.android.gms.nearby.connection.zzo zze;
    private DctDevice zzf;

    private zzha() {
        this.zzc = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzha) {
            zzha zzhaVar = (zzha) obj;
            if (Objects.equal(this.zza, zzhaVar.zza) && Objects.equal(this.zzb, zzhaVar.zzb) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzhaVar.zzc)) && Objects.equal(this.zzd, zzhaVar.zzd) && Objects.equal(this.zze, zzhaVar.zze) && Objects.equal(this.zzf, zzhaVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(this.zzc), this.zzd, this.zze, this.zzf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzek zzekVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzekVar == null ? null : zzekVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ void zza(zzek zzekVar) {
        this.zza = zzekVar;
    }

    final /* synthetic */ void zzb(String str) {
        this.zzb = str;
    }

    zzha(IBinder iBinder, String str, int i, com.google.android.gms.internal.nearby.zzbz zzbzVar, com.google.android.gms.nearby.connection.zzo zzoVar, DctDevice dctDevice) {
        zzek zzeiVar;
        if (iBinder == null) {
            zzeiVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzeiVar = iInterfaceQueryLocalInterface instanceof zzek ? (zzek) iInterfaceQueryLocalInterface : new zzei(iBinder);
        }
        this.zza = zzeiVar;
        this.zzb = str;
        this.zzc = i;
        this.zzd = zzbzVar;
        this.zze = zzoVar;
        this.zzf = dctDevice;
    }
}
