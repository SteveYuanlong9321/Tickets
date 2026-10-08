package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzdx extends com.google.android.gms.internal.nearby.zzb implements zzdy {
    public zzdx() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionResponseListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        zzex zzexVar = (zzex) com.google.android.gms.internal.nearby.zzc.zzb(parcel, zzex.CREATOR);
        com.google.android.gms.internal.nearby.zzc.zzd(parcel);
        zzb(zzexVar);
        return true;
    }
}
