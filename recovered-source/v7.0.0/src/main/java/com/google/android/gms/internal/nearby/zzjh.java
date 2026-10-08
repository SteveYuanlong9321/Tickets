package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzjh extends zza implements IInterface {
    zzjh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.phenotype.internal.IPhenotypeService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzd(zzjg zzjgVar, String str, String str2, String str3) throws RemoteException {
        Parcel parcelZza = zza();
        int i = zzc.zza;
        parcelZza.writeStrongBinder(zzjgVar);
        parcelZza.writeString(str);
        parcelZza.writeString("");
        parcelZza.writeString(null);
        zzt(11, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zze(zzjg zzjgVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        int i = zzc.zza;
        parcelZza.writeStrongBinder(zzjgVar);
        parcelZza.writeString(str);
        zzt(5, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzf(zzjg zzjgVar, byte[] bArr) throws RemoteException {
        Parcel parcelZza = zza();
        int i = zzc.zza;
        parcelZza.writeStrongBinder(zzjgVar);
        parcelZza.writeByteArray(bArr);
        zzt(31, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzg(zzje zzjeVar) throws RemoteException {
        Parcel parcelZza = zza();
        int i = zzc.zza;
        parcelZza.writeStrongBinder(zzjeVar);
        zzt(27, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzh(String str, zzjc zzjcVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        int i = zzc.zza;
        parcelZza.writeStrongBinder(zzjcVar);
        zzt(28, parcelZza);
    }
}
