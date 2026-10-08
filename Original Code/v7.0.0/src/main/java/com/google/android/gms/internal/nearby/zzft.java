package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzft extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzft> CREATOR = new zzfu();
    private zzds zza;
    private zzff zzb;
    private zzdp zzc;

    private zzft() {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzft) {
            zzft zzftVar = (zzft) obj;
            if (Objects.equal(this.zza, zzftVar.zza) && Objects.equal(this.zzb, zzftVar.zzb) && Objects.equal(this.zzc, zzftVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzds zzdsVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzdsVar == null ? null : zzdsVar.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzc.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ void zza(zzds zzdsVar) {
        this.zza = zzdsVar;
    }

    final /* synthetic */ void zzb(zzff zzffVar) {
        this.zzb = zzffVar;
    }

    final /* synthetic */ void zzc(zzdp zzdpVar) {
        this.zzc = zzdpVar;
    }

    zzft(IBinder iBinder, zzff zzffVar, IBinder iBinder2) {
        zzds zzdqVar;
        zzdp zzdnVar = null;
        if (iBinder == null) {
            zzdqVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.uwb.internal.IResultListener");
            zzdqVar = iInterfaceQueryLocalInterface instanceof zzds ? (zzds) iInterfaceQueryLocalInterface : new zzdq(iBinder);
        }
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.uwb.internal.IRangingSessionCallback");
            zzdnVar = iInterfaceQueryLocalInterface2 instanceof zzdp ? (zzdp) iInterfaceQueryLocalInterface2 : new zzdn(iBinder2);
        }
        this.zza = zzdqVar;
        this.zzb = zzffVar;
        this.zzc = zzdnVar;
    }

    /* synthetic */ zzft(byte[] bArr) {
    }
}
