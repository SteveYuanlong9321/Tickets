package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzdr extends com.google.android.gms.internal.nearby.zzb implements zzds {
    public zzdr() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzfr zzfrVar = (zzfr) com.google.android.gms.internal.nearby.zzc.zzb(parcel, zzfr.CREATOR);
            com.google.android.gms.internal.nearby.zzc.zzd(parcel);
            zzb(zzfrVar);
            return true;
        }
        if (i == 3) {
            zzfd zzfdVar = (zzfd) com.google.android.gms.internal.nearby.zzc.zzb(parcel, zzfd.CREATOR);
            com.google.android.gms.internal.nearby.zzc.zzd(parcel);
            zzc(zzfdVar);
            return true;
        }
        if (i != 4) {
            return false;
        }
        com.google.android.gms.internal.nearby.zzc.zzd(parcel);
        return true;
    }
}
