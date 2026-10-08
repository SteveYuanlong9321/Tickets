package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzeb extends com.google.android.gms.internal.nearby.zzb implements zzec {
    public zzeb() {
        super("com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzfh zzfhVar = (zzfh) com.google.android.gms.internal.nearby.zzc.zzb(parcel, zzfh.CREATOR);
            com.google.android.gms.internal.nearby.zzc.zzd(parcel);
            zzc(zzfhVar);
            return true;
        }
        if (i == 3) {
            zzfn zzfnVar = (zzfn) com.google.android.gms.internal.nearby.zzc.zzb(parcel, zzfn.CREATOR);
            com.google.android.gms.internal.nearby.zzc.zzd(parcel);
            zzd(zzfnVar);
            return true;
        }
        if (i == 4) {
            com.google.android.gms.internal.nearby.zzc.zzd(parcel);
            return true;
        }
        if (i != 5) {
            return false;
        }
        zzff zzffVar = (zzff) com.google.android.gms.internal.nearby.zzc.zzb(parcel, zzff.CREATOR);
        com.google.android.gms.internal.nearby.zzc.zzd(parcel);
        zzb(zzffVar);
        return true;
    }
}
