package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzak extends zza implements IInterface {
    zzak(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.fastpair.internal.INearbyFastPairService");
    }

    public final void zzd(zzam zzamVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzamVar);
        zzu(15, parcelZza);
    }

    public final void zze(zzap zzapVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzapVar);
        zzu(16, parcelZza);
    }
}
