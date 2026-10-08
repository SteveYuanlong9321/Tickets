package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzdo extends com.google.android.gms.internal.nearby.zzb implements zzdp {
    public zzdo() {
        super("com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzev zzevVar = (zzev) com.google.android.gms.internal.nearby.zzc.zzb(parcel, zzev.CREATOR);
            com.google.android.gms.internal.nearby.zzc.zzd(parcel);
            zzb(zzevVar);
            return true;
        }
        if (i != 3) {
            return false;
        }
        com.google.android.gms.internal.nearby.zzc.zzd(parcel);
        return true;
    }
}
