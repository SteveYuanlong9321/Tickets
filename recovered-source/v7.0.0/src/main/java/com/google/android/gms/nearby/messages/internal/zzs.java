package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzs extends com.google.android.gms.internal.nearby.zza implements IInterface {
    zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
    }

    public final void zzd(zzbx zzbxVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.nearby.zzc.zzc(parcelZza, zzbxVar);
        zzu(1, parcelZza);
    }

    public final void zze(zzcc zzccVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.nearby.zzc.zzc(parcelZza, zzccVar);
        zzu(2, parcelZza);
    }

    public final void zzf(SubscribeRequest subscribeRequest) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.nearby.zzc.zzc(parcelZza, subscribeRequest);
        zzu(3, parcelZza);
    }

    public final void zzg(zzce zzceVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.nearby.zzc.zzc(parcelZza, zzceVar);
        zzu(4, parcelZza);
    }

    public final void zzh(zzh zzhVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.nearby.zzc.zzc(parcelZza, zzhVar);
        zzu(7, parcelZza);
    }

    public final void zzi(zzbz zzbzVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.nearby.zzc.zzc(parcelZza, zzbzVar);
        zzu(8, parcelZza);
    }

    public final void zzj(zzj zzjVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.nearby.zzc.zzc(parcelZza, zzjVar);
        zzu(9, parcelZza);
    }
}
