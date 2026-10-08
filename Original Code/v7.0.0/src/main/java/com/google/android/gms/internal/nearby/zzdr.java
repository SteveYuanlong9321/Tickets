package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzdr extends zzb implements zzds {
    public zzdr() {
        super("com.google.android.gms.nearby.uwb.internal.IResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        int i3 = parcel.readInt();
        zzc.zzd(parcel);
        zzd(i3);
        return true;
    }
}
