package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzdo extends zzb implements zzdp {
    public zzdo() {
        super("com.google.android.gms.nearby.uwb.internal.IRangingSessionCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzej zzejVar = (zzej) zzc.zzb(parcel, zzej.CREATOR);
            zzc.zzd(parcel);
            zzd(zzejVar);
            return true;
        }
        if (i == 3) {
            zzel zzelVar = (zzel) zzc.zzb(parcel, zzel.CREATOR);
            zzc.zzd(parcel);
            zze(zzelVar);
            return true;
        }
        if (i == 4) {
            zzen zzenVar = (zzen) zzc.zzb(parcel, zzen.CREATOR);
            zzc.zzd(parcel);
            zzf(zzenVar);
            return true;
        }
        if (i == 5) {
            zzef zzefVar = (zzef) zzc.zzb(parcel, zzef.CREATOR);
            zzc.zzd(parcel);
            zzg(zzefVar);
            return true;
        }
        if (i != 6) {
            return false;
        }
        zzeh zzehVar = (zzeh) zzc.zzb(parcel, zzeh.CREATOR);
        zzc.zzd(parcel);
        zzh(zzehVar);
        return true;
    }
}
