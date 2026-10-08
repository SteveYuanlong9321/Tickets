package com.google.android.gms.nearby.internal.connection;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.v3.dct.DctDevice;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzhg> CREATOR = new zzhh();
    private zzek zza;
    private String[] zzb;
    private zzgq zzc;
    private boolean zzd;
    private final int zze;
    private com.google.android.gms.internal.nearby.zzbz zzf;
    private com.google.android.gms.nearby.connection.zzo zzg;
    private DctDevice zzh;

    private zzhg() {
        this.zze = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzhg) {
            zzhg zzhgVar = (zzhg) obj;
            if (Objects.equal(this.zza, zzhgVar.zza) && Arrays.equals(this.zzb, zzhgVar.zzb) && Objects.equal(this.zzc, zzhgVar.zzc) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(zzhgVar.zzd)) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(zzhgVar.zze)) && Objects.equal(this.zzf, zzhgVar.zzf) && Objects.equal(this.zzg, zzhgVar.zzg) && Objects.equal(this.zzh, zzhgVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(Arrays.hashCode(this.zzb)), this.zzc, Boolean.valueOf(this.zzd), Integer.valueOf(this.zze), this.zzf, this.zzg, this.zzh);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzek zzekVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzekVar == null ? null : zzekVar.asBinder(), false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ void zza(zzek zzekVar) {
        this.zza = zzekVar;
    }

    final /* synthetic */ void zzb(String[] strArr) {
        this.zzb = strArr;
    }

    final /* synthetic */ void zzc(zzgq zzgqVar) {
        this.zzc = zzgqVar;
    }

    zzhg(IBinder iBinder, String[] strArr, zzgq zzgqVar, boolean z, int i, com.google.android.gms.internal.nearby.zzbz zzbzVar, com.google.android.gms.nearby.connection.zzo zzoVar, DctDevice dctDevice) {
        zzek zzeiVar;
        if (iBinder == null) {
            zzeiVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzeiVar = iInterfaceQueryLocalInterface instanceof zzek ? (zzek) iInterfaceQueryLocalInterface : new zzei(iBinder);
        }
        this.zza = zzeiVar;
        this.zzb = strArr;
        this.zzc = zzgqVar;
        this.zzd = z;
        this.zze = i;
        this.zzf = zzbzVar;
        this.zzg = zzoVar;
        this.zzh = dctDevice;
    }
}
