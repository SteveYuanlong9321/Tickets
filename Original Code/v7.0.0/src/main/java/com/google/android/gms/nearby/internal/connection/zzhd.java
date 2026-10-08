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
public final class zzhd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzhd> CREATOR = new zzhe();
    private zzek zza;
    private zzds zzb;
    private zzdy zzc;
    private String zzd;
    private String zze;
    private byte[] zzf;
    private zzdv zzg;
    private byte[] zzh;
    private zzm zzi;
    private final int zzj;
    private com.google.android.gms.internal.nearby.zzbz zzk;
    private com.google.android.gms.nearby.connection.zzo zzl;
    private DctDevice zzm;
    private byte[] zzn;
    private String zzo;

    private zzhd() {
        this.zzj = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzhd) {
            zzhd zzhdVar = (zzhd) obj;
            if (Objects.equal(this.zza, zzhdVar.zza) && Objects.equal(this.zzb, zzhdVar.zzb) && Objects.equal(this.zzc, zzhdVar.zzc) && Objects.equal(this.zzd, zzhdVar.zzd) && Objects.equal(this.zze, zzhdVar.zze) && Arrays.equals(this.zzf, zzhdVar.zzf) && Objects.equal(this.zzg, zzhdVar.zzg) && Arrays.equals(this.zzh, zzhdVar.zzh) && Objects.equal(this.zzi, zzhdVar.zzi) && Objects.equal(Integer.valueOf(this.zzj), Integer.valueOf(zzhdVar.zzj)) && Objects.equal(this.zzk, zzhdVar.zzk) && Objects.equal(this.zzl, zzhdVar.zzl) && Objects.equal(this.zzm, zzhdVar.zzm) && Arrays.equals(this.zzn, zzhdVar.zzn) && Objects.equal(this.zzo, zzhdVar.zzo)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze, Integer.valueOf(Arrays.hashCode(this.zzf)), this.zzg, Integer.valueOf(Arrays.hashCode(this.zzh)), this.zzi, Integer.valueOf(this.zzj), this.zzk, this.zzl, this.zzm, Integer.valueOf(Arrays.hashCode(this.zzn)), this.zzo);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzek zzekVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzekVar == null ? null : zzekVar.asBinder(), false);
        zzds zzdsVar = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 2, zzdsVar == null ? null : zzdsVar.asBinder(), false);
        zzdy zzdyVar = this.zzc;
        SafeParcelWriter.writeIBinder(parcel, 3, zzdyVar == null ? null : zzdyVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeByteArray(parcel, 6, this.zzf, false);
        zzdv zzdvVar = this.zzg;
        SafeParcelWriter.writeIBinder(parcel, 7, zzdvVar != null ? zzdvVar.asBinder() : null, false);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzh, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.writeInt(parcel, 10, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeByteArray(parcel, 12, this.zzn, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzo, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzl, i, false);
        SafeParcelWriter.writeParcelable(parcel, 15, this.zzm, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ void zza(zzek zzekVar) {
        this.zza = zzekVar;
    }

    final /* synthetic */ void zzb(zzds zzdsVar) {
        this.zzb = zzdsVar;
    }

    final /* synthetic */ void zzc(zzdy zzdyVar) {
        this.zzc = zzdyVar;
    }

    final /* synthetic */ void zzd(String str) {
        this.zzd = str;
    }

    final /* synthetic */ void zze(String str) {
        this.zze = str;
    }

    final /* synthetic */ void zzf(byte[] bArr) {
        this.zzf = bArr;
    }

    final /* synthetic */ void zzg(zzdv zzdvVar) {
        this.zzg = zzdvVar;
    }

    final /* synthetic */ void zzh(byte[] bArr) {
        this.zzh = bArr;
    }

    final /* synthetic */ void zzi(zzm zzmVar) {
        this.zzi = zzmVar;
    }

    zzhd(IBinder iBinder, IBinder iBinder2, IBinder iBinder3, String str, String str2, byte[] bArr, IBinder iBinder4, byte[] bArr2, zzm zzmVar, int i, com.google.android.gms.internal.nearby.zzbz zzbzVar, com.google.android.gms.nearby.connection.zzo zzoVar, DctDevice dctDevice, byte[] bArr3, String str3) {
        zzek zzeiVar;
        zzds zzdqVar;
        zzdy zzdwVar;
        zzdv zzdtVar = null;
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
        if (iBinder3 == null) {
            zzdwVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionResponseListener");
            zzdwVar = iInterfaceQueryLocalInterface3 instanceof zzdy ? (zzdy) iInterfaceQueryLocalInterface3 : new zzdw(iBinder3);
        }
        if (iBinder4 != null) {
            IInterface iInterfaceQueryLocalInterface4 = iBinder4.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
            zzdtVar = iInterfaceQueryLocalInterface4 instanceof zzdv ? (zzdv) iInterfaceQueryLocalInterface4 : new zzdt(iBinder4);
        }
        this.zza = zzeiVar;
        this.zzb = zzdqVar;
        this.zzc = zzdwVar;
        this.zzd = str;
        this.zze = str2;
        this.zzf = bArr;
        this.zzg = zzdtVar;
        this.zzh = bArr2;
        this.zzi = zzmVar;
        this.zzj = i;
        this.zzk = zzbzVar;
        this.zzl = zzoVar;
        this.zzm = dctDevice;
        this.zzn = bArr3;
        this.zzo = str3;
    }
}
