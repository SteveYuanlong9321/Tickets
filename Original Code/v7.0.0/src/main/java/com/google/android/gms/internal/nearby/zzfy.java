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
public final class zzfy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfy> CREATOR = new zzfz();
    private zzds zza;

    private zzfy() {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfy) {
            return Objects.equal(this.zza, ((zzfy) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzds zzdsVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzdsVar == null ? null : zzdsVar.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ void zza(zzds zzdsVar) {
        this.zza = zzdsVar;
    }

    zzfy(IBinder iBinder) {
        zzds zzdqVar;
        if (iBinder == null) {
            zzdqVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.uwb.internal.IResultListener");
            zzdqVar = iInterfaceQueryLocalInterface instanceof zzds ? (zzds) iInterfaceQueryLocalInterface : new zzdq(iBinder);
        }
        this.zza = zzdqVar;
    }

    /* synthetic */ zzfy(byte[] bArr) {
    }
}
