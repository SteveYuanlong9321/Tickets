package com.google.android.gms.nearby.internal.connection;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzhj> CREATOR = new zzhk();
    private zzen zza;
    private zzdp zzb;
    private String zzc;
    private String zzd;
    private long zze;
    private zze zzf;
    private zzdv zzg;
    private byte[] zzh;
    private String zzi;

    private zzhj() {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzhj) {
            zzhj zzhjVar = (zzhj) obj;
            if (Objects.equal(this.zza, zzhjVar.zza) && Objects.equal(this.zzb, zzhjVar.zzb) && Objects.equal(this.zzc, zzhjVar.zzc) && Objects.equal(this.zzd, zzhjVar.zzd) && Objects.equal(Long.valueOf(this.zze), Long.valueOf(zzhjVar.zze)) && Objects.equal(this.zzf, zzhjVar.zzf) && Objects.equal(this.zzg, zzhjVar.zzg) && Arrays.equals(this.zzh, zzhjVar.zzh) && Objects.equal(this.zzi, zzhjVar.zzi)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, Long.valueOf(this.zze), this.zzf, this.zzg, Integer.valueOf(Arrays.hashCode(this.zzh)), this.zzi);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzen zzenVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzenVar == null ? null : zzenVar.asBinder(), false);
        zzdp zzdpVar = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 2, zzdpVar == null ? null : zzdpVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        zzdv zzdvVar = this.zzg;
        SafeParcelWriter.writeIBinder(parcel, 7, zzdvVar != null ? zzdvVar.asBinder() : null, false);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzh, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ void zza(zzen zzenVar) {
        this.zza = zzenVar;
    }

    final /* synthetic */ void zzb(zzdp zzdpVar) {
        this.zzb = zzdpVar;
    }

    final /* synthetic */ void zzc(String str) {
        this.zzc = str;
    }

    final /* synthetic */ void zzd(String str) {
        this.zzd = str;
    }

    final /* synthetic */ void zze(long j) {
        this.zze = j;
    }

    final /* synthetic */ void zzf(zze zzeVar) {
        this.zzf = zzeVar;
    }

    final /* synthetic */ void zzg(zzdv zzdvVar) {
        this.zzg = zzdvVar;
    }

    final /* synthetic */ void zzh(byte[] bArr) {
        this.zzh = bArr;
    }

    zzhj(IBinder iBinder, IBinder iBinder2, String str, String str2, long j, zze zzeVar, IBinder iBinder3, byte[] bArr, String str3) {
        zzen zzelVar;
        zzdp zzdnVar;
        zzdv zzdtVar = null;
        if (iBinder == null) {
            zzelVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
            zzelVar = iInterfaceQueryLocalInterface instanceof zzen ? (zzen) iInterfaceQueryLocalInterface : new zzel(iBinder);
        }
        if (iBinder2 == null) {
            zzdnVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
            zzdnVar = iInterfaceQueryLocalInterface2 instanceof zzdp ? (zzdp) iInterfaceQueryLocalInterface2 : new zzdn(iBinder2);
        }
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
            zzdtVar = iInterfaceQueryLocalInterface3 instanceof zzdv ? (zzdv) iInterfaceQueryLocalInterface3 : new zzdt(iBinder3);
        }
        this.zza = zzelVar;
        this.zzb = zzdnVar;
        this.zzc = str;
        this.zzd = str2;
        this.zze = j;
        this.zzf = zzeVar;
        this.zzg = zzdtVar;
        this.zzh = bArr;
        this.zzi = str3;
    }

    /* synthetic */ zzhj(byte[] bArr) {
    }
}
