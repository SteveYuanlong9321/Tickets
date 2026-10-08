package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.nearby.connection.Strategy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzl {
    private final zzm zza = new zzm(null);

    public final zzl zza(boolean z) {
        this.zza.zzc(z);
        return this;
    }

    @Deprecated
    public final zzl zzb(boolean z) {
        this.zza.zzd(z);
        return this;
    }

    @Deprecated
    public final zzl zzc(boolean z) {
        this.zza.zze(z);
        return this;
    }

    @Deprecated
    public final zzl zzd(boolean z) {
        this.zza.zzf(z);
        return this;
    }

    @Deprecated
    public final zzl zze(boolean z) {
        this.zza.zzg(z);
        return this;
    }

    @Deprecated
    public final zzl zzf(boolean z) {
        this.zza.zzh(z);
        return this;
    }

    @Deprecated
    public final zzl zzg(boolean z) {
        this.zza.zzi(z);
        return this;
    }

    @Deprecated
    public final zzl zzh(boolean z) {
        this.zza.zzj(z);
        return this;
    }

    public final zzl zzi(byte[] bArr) {
        this.zza.zzk(bArr);
        return this;
    }

    @Deprecated
    public final zzl zzj(boolean z) {
        this.zza.zzl(z);
        return this;
    }

    public final zzl zzk(boolean z) {
        this.zza.zzm(z);
        return this;
    }

    @Deprecated
    public final zzl zzl(boolean z) {
        this.zza.zzo(z);
        return this;
    }

    public final zzl zzm(int i) {
        this.zza.zzp(i);
        return this;
    }

    public final zzl zzn(int i) {
        this.zza.zzq(i);
        return this;
    }

    public final zzl zzo(int... iArr) {
        this.zza.zzr(iArr);
        return this;
    }

    public final zzl zzp(int... iArr) {
        this.zza.zzs(iArr);
        return this;
    }

    public final zzl zzq(byte[] bArr) {
        this.zza.zzt(bArr);
        return this;
    }

    public final zzl zzr(int i) {
        this.zza.zzw(i);
        return this;
    }

    public final zzl zzs(Strategy strategy) {
        this.zza.zzu(strategy);
        return this;
    }

    public final zzl zzt(long j) {
        this.zza.zzx(j);
        return this;
    }

    @Deprecated
    public final zzl zzu(boolean z) {
        this.zza.zzy(z);
        return this;
    }

    public final zzl zzv(boolean z) {
        this.zza.zzz(z);
        return this;
    }

    public final zzl zzw(boolean z) {
        this.zza.zzA(z);
        return this;
    }

    public final zzl zzx(boolean z) {
        this.zza.zzC(z);
        return this;
    }

    public final zzl zzy(boolean z) {
        this.zza.zzB(z);
        return this;
    }

    public final zzm zzz() {
        zzm zzmVar = this.zza;
        zzm.zzb(zzmVar);
        if (zzmVar.zzv() != 0) {
            zzmVar.zzo(zzmVar.zzv() == 1);
            return zzmVar;
        }
        if (!zzmVar.zzn()) {
            zzmVar.zzw(2);
        }
        return zzmVar;
    }
}
