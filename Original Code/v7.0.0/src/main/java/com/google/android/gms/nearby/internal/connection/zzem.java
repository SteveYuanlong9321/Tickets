package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzem extends com.google.android.gms.internal.nearby.zzb implements zzen {
    public zzem() {
        super("com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        zzfv zzfvVar = (zzfv) com.google.android.gms.internal.nearby.zzc.zzb(parcel, zzfv.CREATOR);
        com.google.android.gms.internal.nearby.zzc.zzd(parcel);
        zzb(zzfvVar);
        return true;
    }
}
