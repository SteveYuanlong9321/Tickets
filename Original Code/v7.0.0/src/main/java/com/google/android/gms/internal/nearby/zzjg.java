package com.google.android.gms.internal.nearby;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public interface zzjg extends IInterface {
    void zzb(Status status) throws RemoteException;

    void zzc(Status status) throws RemoteException;

    void zzd(Status status) throws RemoteException;

    void zze(Status status) throws RemoteException;

    void zzf(Status status, @Nullable zzhw zzhwVar) throws RemoteException;

    void zzg(Status status) throws RemoteException;

    void zzh(Status status, @Nullable zzia zziaVar) throws RemoteException;

    void zzi(Status status, @Nullable zzhy zzhyVar) throws RemoteException;

    void zzj(Status status) throws RemoteException;

    void zzk(Status status, @Nullable zzid zzidVar) throws RemoteException;

    void zzl(Status status, @Nullable zzhw zzhwVar) throws RemoteException;

    void zzm(Status status, long j) throws RemoteException;

    void zzn(Status status) throws RemoteException;

    void zzo(Status status, @Nullable zzih zzihVar) throws RemoteException;

    void zzp(Status status) throws RemoteException;

    void zzq(Status status, long j) throws RemoteException;
}
