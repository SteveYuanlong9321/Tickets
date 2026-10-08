package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzdl extends zzb implements zzdm {
    public zzdl() {
        super("com.google.android.gms.nearby.uwb.internal.IRangingCapabilitiesResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzex zzexVar = (zzex) zzc.zzb(parcel, zzex.CREATOR);
        zzc.zzd(parcel);
        zzd(zzexVar);
        return true;
    }
}
