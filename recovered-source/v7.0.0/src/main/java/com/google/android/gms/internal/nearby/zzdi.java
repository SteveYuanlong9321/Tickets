package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.core.view.PointerIconCompat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdi extends zza implements zzdj {
    zzdi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.uwb.internal.INearbyUwbService");
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zzd(zzed zzedVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzedVar);
        zzu(1001, parcelZza);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zze(zzdd zzddVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzddVar);
        zzu(PointerIconCompat.TYPE_HAND, parcelZza);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zzf(zzda zzdaVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzdaVar);
        zzu(PointerIconCompat.TYPE_HELP, parcelZza);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zzg(zzcx zzcxVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzcxVar);
        zzu(PointerIconCompat.TYPE_WAIT, parcelZza);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zzh(zzft zzftVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzftVar);
        zzu(1005, parcelZza);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zzi(zzfy zzfyVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzfyVar);
        zzu(PointerIconCompat.TYPE_CELL, parcelZza);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zzj(zzcs zzcsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzcsVar);
        zzu(PointerIconCompat.TYPE_CROSSHAIR, parcelZza);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zzk(zzci zzciVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzciVar);
        zzu(PointerIconCompat.TYPE_TEXT, parcelZza);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zzl(zzfq zzfqVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzfqVar);
        zzu(PointerIconCompat.TYPE_VERTICAL_TEXT, parcelZza);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zzm(zzcl zzclVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzclVar);
        zzu(PointerIconCompat.TYPE_NO_DROP, parcelZza);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zzn(zzfn zzfnVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzfnVar);
        zzu(PointerIconCompat.TYPE_ALL_SCROLL, parcelZza);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zzo(zzfk zzfkVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzfkVar);
        zzu(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, parcelZza);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zzp(zzge zzgeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzgeVar);
        zzu(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, parcelZza);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zzq(zzge zzgeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzgeVar);
        zzu(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, parcelZza);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zzr(zzco zzcoVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzcoVar);
        zzu(PointerIconCompat.TYPE_ZOOM_IN, parcelZza);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zzs(zzfv zzfvVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzfvVar);
        zzu(PointerIconCompat.TYPE_ZOOM_OUT, parcelZza);
    }
}
