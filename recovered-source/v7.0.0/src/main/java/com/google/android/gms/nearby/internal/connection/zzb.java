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
public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new zzc();
    private zzek zza;
    private zzds zzb;
    private String zzc;
    private byte[] zzd;
    private zzeh zze;
    private final int zzf;
    private com.google.android.gms.internal.nearby.zzbz zzg;
    private com.google.android.gms.nearby.connection.zzo zzh;
    private DctDevice zzi;

    private zzb() {
        this.zzf = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzb) {
            zzb zzbVar = (zzb) obj;
            if (Objects.equal(this.zza, zzbVar.zza) && Objects.equal(this.zzb, zzbVar.zzb) && Objects.equal(this.zzc, zzbVar.zzc) && Arrays.equals(this.zzd, zzbVar.zzd) && Objects.equal(this.zze, zzbVar.zze) && Objects.equal(Integer.valueOf(this.zzf), Integer.valueOf(zzbVar.zzf)) && Objects.equal(this.zzg, zzbVar.zzg) && Objects.equal(this.zzh, zzbVar.zzh) && Objects.equal(this.zzi, zzbVar.zzi)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Integer.valueOf(Arrays.hashCode(this.zzd)), this.zze, Integer.valueOf(this.zzf), this.zzg, this.zzh, this.zzi);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzek zzekVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzekVar == null ? null : zzekVar.asBinder(), false);
        zzds zzdsVar = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 2, zzdsVar == null ? null : zzdsVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzd, false);
        zzeh zzehVar = this.zze;
        SafeParcelWriter.writeIBinder(parcel, 5, zzehVar != null ? zzehVar.asBinder() : null, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ void zza(zzek zzekVar) {
        this.zza = zzekVar;
    }

    final /* synthetic */ void zzb(zzds zzdsVar) {
        this.zzb = zzdsVar;
    }

    final /* synthetic */ void zzc(String str) {
        this.zzc = str;
    }

    final /* synthetic */ void zzd(byte[] bArr) {
        this.zzd = bArr;
    }

    final /* synthetic */ void zze(zzeh zzehVar) {
        this.zze = zzehVar;
    }

    zzb(IBinder iBinder, IBinder iBinder2, String str, byte[] bArr, IBinder iBinder3, int i, com.google.android.gms.internal.nearby.zzbz zzbzVar, com.google.android.gms.nearby.connection.zzo zzoVar, DctDevice dctDevice) {
        zzek zzeiVar;
        zzds zzdqVar;
        zzeh zzefVar = null;
        if (iBinder == null) {
            zzeiVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzeiVar = iInterfaceQueryLocalInterface instanceof zzek ? (zzek) iInterfaceQueryLocalInterface : new zzei(iBinder);
        }
        if (iBinder2 == null) {
            zzdqVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
            zzdqVar = iInterfaceQueryLocalInterface2 instanceof zzds ? (zzds) iInterfaceQueryLocalInterface2 : new zzdq(iBinder2);
        }
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IPayloadListener");
            zzefVar = iInterfaceQueryLocalInterface3 instanceof zzeh ? (zzeh) iInterfaceQueryLocalInterface3 : new zzef(iBinder3);
        }
        this.zza = zzeiVar;
        this.zzb = zzdqVar;
        this.zzc = str;
        this.zzd = bArr;
        this.zze = zzefVar;
        this.zzf = i;
        this.zzg = zzbzVar;
        this.zzh = zzoVar;
        this.zzi = dctDevice;
    }
}
