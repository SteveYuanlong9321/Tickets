package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzpk {
    private final boolean zza;
    private final int zzb;
    private final int zzc;

    zzpk(int i, int i2, boolean z) {
        this.zzb = i;
        this.zzc = i2;
        this.zza = z;
    }

    zzpk(int i, boolean z) {
        this.zzb = 2;
        this.zzc = i;
        this.zza = z;
    }

    final boolean zza() {
        return this.zza;
    }

    final zzld zzb() {
        zzlc zzlcVarZza = zzld.zza();
        zzlcVarZza.zza(this.zzb);
        zzlcVarZza.zzb(this.zzc);
        return (zzld) zzlcVarZza.zzn();
    }

    final int zzc() {
        return this.zzc;
    }

    final /* synthetic */ int zzd() {
        return this.zzb;
    }
}
