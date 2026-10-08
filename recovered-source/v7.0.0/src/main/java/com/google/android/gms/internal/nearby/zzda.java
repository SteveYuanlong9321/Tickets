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
public final class zzda extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzda> CREATOR = new zzdb();
    private zzdv zza;

    private zzda() {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzda) {
            return Objects.equal(this.zza, ((zzda) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, this.zza.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ void zza(zzdv zzdvVar) {
        this.zza = zzdvVar;
    }

    zzda(IBinder iBinder) {
        zzdv zzdtVar;
        if (iBinder == null) {
            zzdtVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.uwb.internal.IUwbAddressResultListener");
            zzdtVar = iInterfaceQueryLocalInterface instanceof zzdv ? (zzdv) iInterfaceQueryLocalInterface : new zzdt(iBinder);
        }
        this.zza = zzdtVar;
    }

    /* synthetic */ zzda(byte[] bArr) {
    }
}
