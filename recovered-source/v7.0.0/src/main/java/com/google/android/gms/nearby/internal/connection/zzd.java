package com.google.android.gms.nearby.internal.connection;

import android.os.ParcelUuid;
import android.util.Log;
import com.google.android.gms.nearby.connection.Strategy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzd {
    private final zze zza = new zze(null);

    public final zzd zzA(int i) {
        this.zza.zzG(i);
        return this;
    }

    public final zzd zzB(byte[] bArr) {
        this.zza.zzH(bArr);
        return this;
    }

    public final zzd zzC(boolean z) {
        this.zza.zzI(z);
        return this;
    }

    public final zzd zzD(int i) {
        this.zza.zzK(i);
        return this;
    }

    @Deprecated
    public final zzd zzE(boolean z) {
        this.zza.zzL(z);
        return this;
    }

    public final zzd zzF(boolean z) {
        this.zza.zzM(z);
        return this;
    }

    public final zzd zzG(boolean z) {
        this.zza.zzN(z);
        return this;
    }

    public final zzd zzH(boolean z) {
        this.zza.zzO(z);
        return this;
    }

    public final zzd zzI(long j) {
        this.zza.zzP(j);
        return this;
    }

    public final zzd zzJ(boolean z) {
        this.zza.zzQ(z);
        return this;
    }

    public final zzd zzK(boolean z) {
        this.zza.zzR(z);
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0071  */
    public final zze zzL() {
        zze zzeVar = this.zza;
        int[] iArrZzA = zzeVar.zzA();
        if (iArrZzA != null && iArrZzA.length > 0) {
            zzeVar.zzf(false);
            zzeVar.zze(false);
            zzeVar.zzl(false);
            zzeVar.zzm(false);
            zzeVar.zzk(false);
            zzeVar.zzo(false);
            for (int i : iArrZzA) {
                if (i == 2) {
                    zzeVar.zze(true);
                } else if (i == 9) {
                    zzeVar.zzo(true);
                } else if (i == 4) {
                    zzeVar.zzf(true);
                } else if (i == 5) {
                    zzeVar.zzk(true);
                } else if (i == 6) {
                    zzeVar.zzm(true);
                } else if (i == 7) {
                    zzeVar.zzl(true);
                } else if (i != 11) {
                    if (i != 12) {
                        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 27);
                        sb.append("Illegal advertising medium ");
                        sb.append(i);
                        Log.d("NearbyConnections", sb.toString());
                    } else {
                        zzeVar.zzo(true);
                    }
                }
            }
        }
        if (zzeVar.zzC() != null && zzeVar.zzC().length > 0) {
            zzeVar.zzy(false);
            for (int i2 = 0; i2 < zzeVar.zzC().length; i2++) {
                if (zzeVar.zzC()[i2] == 9 || zzeVar.zzC()[i2] == 12) {
                    zzeVar.zzy(true);
                    break;
                }
            }
        }
        if (zzeVar.zzF() == 0) {
            zzeVar.zzG(true == zzeVar.zzh() ? 1 : 3);
        } else {
            zzeVar.zzi(zzeVar.zzF() != 3);
        }
        if (zzeVar.zzJ() != 0) {
            zzeVar.zzx(zzeVar.zzJ() == 1);
            return zzeVar;
        }
        if (!zzeVar.zzw()) {
            zzeVar.zzK(2);
        }
        return zzeVar;
    }

    public final zzd zza(Strategy strategy) {
        this.zza.zzb(strategy);
        return this;
    }

    public final zzd zzb(boolean z) {
        this.zza.zzc(z);
        return this;
    }

    public final zzd zzc(boolean z) {
        this.zza.zzd(z);
        return this;
    }

    @Deprecated
    public final zzd zzd(boolean z) {
        this.zza.zze(z);
        return this;
    }

    @Deprecated
    public final zzd zze(boolean z) {
        this.zza.zzf(z);
        return this;
    }

    @Deprecated
    public final zzd zzf(byte[] bArr) {
        this.zza.zzg(bArr);
        return this;
    }

    public final zzd zzg(boolean z) {
        this.zza.zzi(z);
        return this;
    }

    public final zzd zzh(ParcelUuid parcelUuid) {
        this.zza.zzj(parcelUuid);
        return this;
    }

    @Deprecated
    public final zzd zzi(boolean z) {
        this.zza.zzk(z);
        return this;
    }

    @Deprecated
    public final zzd zzj(boolean z) {
        this.zza.zzl(z);
        return this;
    }

    @Deprecated
    public final zzd zzk(boolean z) {
        this.zza.zzm(z);
        return this;
    }

    public final zzd zzl(boolean z) {
        this.zza.zzn(z);
        return this;
    }

    @Deprecated
    public final zzd zzm(boolean z) {
        this.zza.zzo(z);
        return this;
    }

    public final zzd zzn(boolean z) {
        this.zza.zzp(z);
        return this;
    }

    public final zzd zzo(int i) {
        this.zza.zzq(i);
        return this;
    }

    public final zzd zzp(int i) {
        this.zza.zzr(i);
        return this;
    }

    public final zzd zzq(byte[] bArr) {
        this.zza.zzs(bArr);
        return this;
    }

    public final zzd zzr(long j) {
        this.zza.zzt(j);
        return this;
    }

    public final zzd zzs(com.google.android.gms.nearby.connection.zzz[] zzzVarArr) {
        this.zza.zzu(zzzVarArr);
        return this;
    }

    public final zzd zzt(boolean z) {
        this.zza.zzv(z);
        return this;
    }

    @Deprecated
    public final zzd zzu(boolean z) {
        this.zza.zzx(z);
        return this;
    }

    @Deprecated
    public final zzd zzv(boolean z) {
        this.zza.zzy(z);
        return this;
    }

    public final zzd zzw(boolean z) {
        this.zza.zzz(z);
        return this;
    }

    public final zzd zzx(int... iArr) {
        this.zza.zzB(iArr);
        return this;
    }

    public final zzd zzy(int... iArr) {
        this.zza.zzD(iArr);
        return this;
    }

    public final zzd zzz(boolean z) {
        this.zza.zzE(z);
        return this;
    }
}
