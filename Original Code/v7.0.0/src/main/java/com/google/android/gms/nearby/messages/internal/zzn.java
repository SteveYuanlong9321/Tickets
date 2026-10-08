package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzn extends com.google.android.gms.internal.nearby.zzb implements zzo {
    public zzn() {
        super("com.google.android.gms.nearby.messages.internal.IMessageListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1 || i == 2) {
            com.google.android.gms.internal.nearby.zzc.zzd(parcel);
        } else {
            if (i != 4) {
                return false;
            }
            ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(Update.CREATOR);
            com.google.android.gms.internal.nearby.zzc.zzd(parcel);
            zzd(arrayListCreateTypedArrayList);
        }
        return true;
    }
}
