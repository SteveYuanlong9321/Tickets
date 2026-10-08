package com.google.android.gms.internal.nearby;

import android.net.Uri;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzru extends zzsg {
    private Uri zza;
    private zzaks zzb;
    private zzxb zzc = zzxb.zze();
    private zzyg zzd;
    private zzsz zze;
    private boolean zzf;
    private byte zzg;

    zzru() {
    }

    @Override // com.google.android.gms.internal.nearby.zzsg
    public final zzsg zza(Uri uri) {
        if (uri == null) {
            throw new NullPointerException("Null uri");
        }
        this.zza = uri;
        return this;
    }

    @Override // com.google.android.gms.internal.nearby.zzsg
    public final zzsg zzb(zzaks zzaksVar) {
        if (zzaksVar == null) {
            throw new NullPointerException("Null schema");
        }
        this.zzb = zzaksVar;
        return this;
    }

    @Override // com.google.android.gms.internal.nearby.zzsg
    public final zzsg zzc(zzrw zzrwVar) {
        this.zzc = zzxb.zzf(zzrwVar);
        return this;
    }

    public final zzsg zzd(zzsz zzszVar) {
        this.zze = zzszVar;
        return this;
    }

    @Override // com.google.android.gms.internal.nearby.zzsg
    public final zzsg zze(boolean z) {
        this.zzf = true;
        this.zzg = (byte) (1 | this.zzg);
        return this;
    }

    @Override // com.google.android.gms.internal.nearby.zzsg
    public final zzsg zzf(boolean z) {
        this.zzg = (byte) (this.zzg | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.nearby.zzsg
    public final zzsh zzg() {
        Uri uri;
        zzaks zzaksVar;
        zzsz zzszVar;
        if (this.zzd == null) {
            this.zzd = zzyg.zzj();
        }
        if (this.zzg == 3 && (uri = this.zza) != null && (zzaksVar = this.zzb) != null && (zzszVar = this.zze) != null) {
            return new zzrv(uri, zzaksVar, this.zzc, this.zzd, zzszVar, this.zzf, false, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" uri");
        }
        if (this.zzb == null) {
            sb.append(" schema");
        }
        if (this.zze == null) {
            sb.append(" variantConfig");
        }
        if ((this.zzg & 1) == 0) {
            sb.append(" useGeneratedExtensionRegistry");
        }
        if ((this.zzg & 2) == 0) {
            sb.append(" enableTracing");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
