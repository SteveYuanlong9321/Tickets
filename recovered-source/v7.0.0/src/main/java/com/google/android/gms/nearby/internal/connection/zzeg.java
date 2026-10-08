package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzeg extends com.google.android.gms.internal.nearby.zzb implements zzeh {
    public zzeg() {
        super("com.google.android.gms.nearby.internal.connection.IPayloadListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzfr zzfrVar = (zzfr) com.google.android.gms.internal.nearby.zzc.zzb(parcel, zzfr.CREATOR);
            com.google.android.gms.internal.nearby.zzc.zzd(parcel);
            zzb(zzfrVar);
            return true;
        }
        if (i != 3) {
            return false;
        }
        zzft zzftVar = (zzft) com.google.android.gms.internal.nearby.zzc.zzb(parcel, zzft.CREATOR);
        com.google.android.gms.internal.nearby.zzc.zzd(parcel);
        zzc(zzftVar);
        return true;
    }
}
