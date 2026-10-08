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
public final class zzhm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzhm> CREATOR = new zzhn();
    private zzek zza;
    private String zzb;
    private long zzc;
    private zzdl zzd;
    private zzec zze;
    private String zzf;
    private zzdz zzg;

    private zzhm() {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzhm) {
            zzhm zzhmVar = (zzhm) obj;
            if (Objects.equal(this.zza, zzhmVar.zza) && Objects.equal(this.zzg, zzhmVar.zzg) && Objects.equal(this.zzb, zzhmVar.zzb) && Objects.equal(Long.valueOf(this.zzc), Long.valueOf(zzhmVar.zzc)) && Objects.equal(this.zzd, zzhmVar.zzd) && Objects.equal(this.zze, zzhmVar.zze) && Objects.equal(this.zzf, zzhmVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzg, this.zzb, Long.valueOf(this.zzc), this.zzd, this.zze, this.zzf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzek zzekVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzekVar == null ? null : zzekVar.asBinder(), false);
        zzdz zzdzVar = this.zzg;
        SafeParcelWriter.writeIBinder(parcel, 2, zzdzVar == null ? null : zzdzVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzd, i, false);
        zzec zzecVar = this.zze;
        SafeParcelWriter.writeIBinder(parcel, 6, zzecVar != null ? zzecVar.asBinder() : null, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ void zza(zzek zzekVar) {
        this.zza = zzekVar;
    }

    final /* synthetic */ void zzb(String str) {
        this.zzb = str;
    }

    final /* synthetic */ void zzc(long j) {
        this.zzc = j;
    }

    final /* synthetic */ void zzd(zzdl zzdlVar) {
        this.zzd = zzdlVar;
    }

    final /* synthetic */ void zze(zzec zzecVar) {
        this.zze = zzecVar;
    }

    zzhm(IBinder iBinder, IBinder iBinder2, String str, long j, zzdl zzdlVar, IBinder iBinder3, String str2) {
        zzek zzeiVar;
        zzdz zzdzVar;
        zzec zzeaVar = null;
        if (iBinder == null) {
            zzeiVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzeiVar = iInterfaceQueryLocalInterface instanceof zzek ? (zzek) iInterfaceQueryLocalInterface : new zzei(iBinder);
        }
        if (iBinder2 == null) {
            zzdzVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IDiscoveryCallback");
            zzdzVar = iInterfaceQueryLocalInterface2 instanceof zzdz ? (zzdz) iInterfaceQueryLocalInterface2 : new zzdz(iBinder2);
        }
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
            zzeaVar = iInterfaceQueryLocalInterface3 instanceof zzec ? (zzec) iInterfaceQueryLocalInterface3 : new zzea(iBinder3);
        }
        this.zza = zzeiVar;
        this.zzg = zzdzVar;
        this.zzb = str;
        this.zzc = j;
        this.zzd = zzdlVar;
        this.zze = zzeaVar;
        this.zzf = str2;
    }

    /* synthetic */ zzhm(byte[] bArr) {
    }
}
