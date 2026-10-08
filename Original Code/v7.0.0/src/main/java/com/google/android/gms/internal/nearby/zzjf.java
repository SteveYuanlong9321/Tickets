package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzjf extends zzb implements zzjg {
    public zzjf() {
        super("com.google.android.gms.phenotype.internal.IPhenotypeCallbacks");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                Status status = (Status) zzc.zzb(parcel, Status.CREATOR);
                zzc.zzd(parcel);
                zzb(status);
                return true;
            case 2:
                Status status2 = (Status) zzc.zzb(parcel, Status.CREATOR);
                zzc.zzd(parcel);
                zzc(status2);
                return true;
            case 3:
                Status status3 = (Status) zzc.zzb(parcel, Status.CREATOR);
                zzc.zzd(parcel);
                zze(status3);
                return true;
            case 4:
                Status status4 = (Status) zzc.zzb(parcel, Status.CREATOR);
                zzhw zzhwVar = (zzhw) zzc.zzb(parcel, zzhw.CREATOR);
                zzc.zzd(parcel);
                zzf(status4, zzhwVar);
                return true;
            case 5:
                Status status5 = (Status) zzc.zzb(parcel, Status.CREATOR);
                zzc.zzd(parcel);
                zzg(status5);
                return true;
            case 6:
                Status status6 = (Status) zzc.zzb(parcel, Status.CREATOR);
                zzia zziaVar = (zzia) zzc.zzb(parcel, zzia.CREATOR);
                zzc.zzd(parcel);
                zzh(status6, zziaVar);
                return true;
            case 7:
                Status status7 = (Status) zzc.zzb(parcel, Status.CREATOR);
                zzhy zzhyVar = (zzhy) zzc.zzb(parcel, zzhy.CREATOR);
                zzc.zzd(parcel);
                zzi(status7, zzhyVar);
                return true;
            case 8:
                Status status8 = (Status) zzc.zzb(parcel, Status.CREATOR);
                zzc.zzd(parcel);
                zzj(status8);
                return true;
            case 9:
                Status status9 = (Status) zzc.zzb(parcel, Status.CREATOR);
                zzid zzidVar = (zzid) zzc.zzb(parcel, zzid.CREATOR);
                zzc.zzd(parcel);
                zzk(status9, zzidVar);
                return true;
            case 10:
                Status status10 = (Status) zzc.zzb(parcel, Status.CREATOR);
                zzhw zzhwVar2 = (zzhw) zzc.zzb(parcel, zzhw.CREATOR);
                zzc.zzd(parcel);
                zzl(status10, zzhwVar2);
                return true;
            case 11:
                Status status11 = (Status) zzc.zzb(parcel, Status.CREATOR);
                long j = parcel.readLong();
                zzc.zzd(parcel);
                zzm(status11, j);
                return true;
            case 12:
                Status status12 = (Status) zzc.zzb(parcel, Status.CREATOR);
                zzc.zzd(parcel);
                zzn(status12);
                return true;
            case 13:
                Status status13 = (Status) zzc.zzb(parcel, Status.CREATOR);
                zzih zzihVar = (zzih) zzc.zzb(parcel, zzih.CREATOR);
                zzc.zzd(parcel);
                zzo(status13, zzihVar);
                return true;
            case 14:
                Status status14 = (Status) zzc.zzb(parcel, Status.CREATOR);
                zzc.zzd(parcel);
                zzd(status14);
                return true;
            case 15:
                Status status15 = (Status) zzc.zzb(parcel, Status.CREATOR);
                zzc.zzd(parcel);
                zzp(status15);
                return true;
            case 16:
                Status status16 = (Status) zzc.zzb(parcel, Status.CREATOR);
                long j2 = parcel.readLong();
                zzc.zzd(parcel);
                zzq(status16, j2);
                return true;
            default:
                return false;
        }
    }
}
