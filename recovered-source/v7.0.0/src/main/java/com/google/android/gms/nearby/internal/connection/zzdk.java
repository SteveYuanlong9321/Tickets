package com.google.android.gms.nearby.internal.connection;

import android.os.ParcelUuid;
import android.util.Log;
import com.google.android.gms.nearby.connection.Strategy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdk {
    private final zzdl zza = new zzdl(null);

    public final zzdk zza(Strategy strategy) {
        this.zza.zzb(strategy);
        return this;
    }

    public final zzdk zzb(boolean z) {
        this.zza.zzc(z);
        return this;
    }

    @Deprecated
    public final zzdk zzc(boolean z) {
        this.zza.zzd(z);
        return this;
    }

    @Deprecated
    public final zzdk zzd(boolean z) {
        this.zza.zze(z);
        return this;
    }

    public final zzdk zze(boolean z) {
        this.zza.zzg(z);
        return this;
    }

    public final zzdk zzf(ParcelUuid parcelUuid) {
        this.zza.zzh(parcelUuid);
        return this;
    }

    @Deprecated
    public final zzdk zzg(boolean z) {
        this.zza.zzi(z);
        return this;
    }

    @Deprecated
    public final zzdk zzh(boolean z) {
        this.zza.zzj(z);
        return this;
    }

    @Deprecated
    public final zzdk zzi(boolean z) {
        this.zza.zzk(z);
        return this;
    }

    public final zzdk zzj(boolean z) {
        this.zza.zzl(z);
        return this;
    }

    public final zzdk zzk(int i) {
        this.zza.zzm(i);
        return this;
    }

    public final zzdk zzl(int i) {
        this.zza.zzn(i);
        return this;
    }

    public final zzdk zzm(byte[] bArr) {
        this.zza.zzo(bArr);
        return this;
    }

    public final zzdk zzn(long j) {
        this.zza.zzp(j);
        return this;
    }

    public final zzdk zzo(int... iArr) {
        this.zza.zzr(iArr);
        return this;
    }

    public final zzdk zzp(boolean z) {
        this.zza.zzs(z);
        return this;
    }

    @Deprecated
    public final zzdk zzq(boolean z) {
        this.zza.zzt(z);
        return this;
    }

    public final zzdk zzr(boolean z) {
        this.zza.zzu(z);
        return this;
    }

    public final zzdk zzs(boolean z) {
        this.zza.zzv(z);
        return this;
    }

    public final zzdk zzt(int i) {
        this.zza.zzx(i);
        return this;
    }

    public final zzdk zzu(boolean z) {
        this.zza.zzy(z);
        return this;
    }

    public final zzdl zzv() {
        zzdl zzdlVar = this.zza;
        int[] iArrZzq = zzdlVar.zzq();
        if (iArrZzq != null && iArrZzq.length > 0) {
            zzdlVar.zze(false);
            zzdlVar.zzd(false);
            zzdlVar.zzj(false);
            zzdlVar.zzk(false);
            zzdlVar.zzi(false);
            for (int i : iArrZzq) {
                if (i == 2) {
                    zzdlVar.zzd(true);
                } else if (i != 11) {
                    if (i == 4) {
                        zzdlVar.zze(true);
                    } else if (i == 5) {
                        zzdlVar.zzi(true);
                    } else if (i == 6) {
                        zzdlVar.zzk(true);
                    } else if (i != 7) {
                        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 25);
                        sb.append("Illegal discovery medium ");
                        sb.append(i);
                        Log.d("NearbyConnections", sb.toString());
                    } else {
                        zzdlVar.zzj(true);
                    }
                }
            }
        }
        if (zzdlVar.zzw() == 0) {
            zzdlVar.zzx(true != zzdlVar.zzf() ? 3 : 1);
            return zzdlVar;
        }
        zzdlVar.zzg(zzdlVar.zzw() != 3);
        return zzdlVar;
    }
}
