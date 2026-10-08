package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzl extends zzq {
    private String zza;
    private byte zzb;
    private int zzc;
    private int zzd;

    zzl() {
    }

    public final zzq zza(String str) {
        this.zza = "";
        return this;
    }

    @Override // com.google.android.gms.internal.nearby.zzq
    public final zzq zzb(boolean z) {
        this.zzb = (byte) 1;
        return this;
    }

    @Override // com.google.android.gms.internal.nearby.zzq
    final zzq zzd(int i) {
        this.zzc = i;
        return this;
    }

    @Override // com.google.android.gms.internal.nearby.zzq
    public final zzq zze(int i) {
        this.zzd = 1;
        return this;
    }

    @Override // com.google.android.gms.internal.nearby.zzq
    public final zzr zzc() {
        if (this.zzb == 1 && this.zza != null && this.zzc != 0 && this.zzd != 0) {
            return new zzm(this.zza, false, this.zzc, null, this.zzd, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" fileOwner");
        }
        if (this.zzb == 0) {
            sb.append(" hasDifferentDmaOwner");
        }
        if (this.zzc == 0) {
            sb.append(" fileChecks");
        }
        if (this.zzd == 0) {
            sb.append(" filePurpose");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
