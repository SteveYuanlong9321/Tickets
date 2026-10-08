package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzdu extends zzb implements zzdv {
    public zzdu() {
        super("com.google.android.gms.nearby.uwb.internal.IUwbAddressResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        zzgb zzgbVar = (zzgb) zzc.zzb(parcel, zzgb.CREATOR);
        zzc.zzd(parcel);
        zzd(zzgbVar);
        return true;
    }
}
