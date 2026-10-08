package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzej extends com.google.android.gms.internal.nearby.zzb implements zzek {
    public zzej() {
        super("com.google.android.gms.nearby.internal.connection.IResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        int i3 = parcel.readInt();
        com.google.android.gms.internal.nearby.zzc.zzd(parcel);
        zzb(i3);
        return true;
    }
}
