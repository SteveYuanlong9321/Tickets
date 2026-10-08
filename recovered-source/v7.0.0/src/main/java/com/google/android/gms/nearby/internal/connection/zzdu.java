package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzdu extends com.google.android.gms.internal.nearby.zzb implements zzdv {
    public zzdu() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                zzet zzetVar = (zzet) com.google.android.gms.internal.nearby.zzc.zzb(parcel, zzet.CREATOR);
                com.google.android.gms.internal.nearby.zzc.zzd(parcel);
                zzb(zzetVar);
                return true;
            case 3:
                zzez zzezVar = (zzez) com.google.android.gms.internal.nearby.zzc.zzb(parcel, zzez.CREATOR);
                com.google.android.gms.internal.nearby.zzc.zzd(parcel);
                zzc(zzezVar);
                return true;
            case 4:
                zzfd zzfdVar = (zzfd) com.google.android.gms.internal.nearby.zzc.zzb(parcel, zzfd.CREATOR);
                com.google.android.gms.internal.nearby.zzc.zzd(parcel);
                zzd(zzfdVar);
                return true;
            case 5:
                zzer zzerVar = (zzer) com.google.android.gms.internal.nearby.zzc.zzb(parcel, zzer.CREATOR);
                com.google.android.gms.internal.nearby.zzc.zzd(parcel);
                zze(zzerVar);
                return true;
            case 6:
                com.google.android.gms.internal.nearby.zzc.zzd(parcel);
                return true;
            case 7:
                com.google.android.gms.internal.nearby.zzc.zzd(parcel);
                return true;
            case 8:
                com.google.android.gms.internal.nearby.zzc.zzd(parcel);
                return true;
            case 9:
                zzfb zzfbVar = (zzfb) com.google.android.gms.internal.nearby.zzc.zzb(parcel, zzfb.CREATOR);
                com.google.android.gms.internal.nearby.zzc.zzd(parcel);
                zzf(zzfbVar);
                return true;
            default:
                return false;
        }
    }
}
