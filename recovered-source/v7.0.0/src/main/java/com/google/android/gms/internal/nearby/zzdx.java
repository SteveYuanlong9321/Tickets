package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzdx extends zzb implements zzdy {
    public zzdx() {
        super("com.google.android.gms.nearby.uwb.internal.IUwbAvailabilityObserver");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        boolean zZza = zzc.zza(parcel);
        int i3 = parcel.readInt();
        zzc.zzd(parcel);
        zzd(zZza, i3);
        return true;
    }
}
