package com.google.android.gms.internal.nearby;

import android.net.Uri;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzrv extends zzsh {
    private final Uri zza;
    private final zzaks zzb;
    private final zzxb zzc;
    private final zzyg zzd;
    private final zzsz zze;
    private final boolean zzf;

    /* synthetic */ zzrv(Uri uri, zzaks zzaksVar, zzxb zzxbVar, zzyg zzygVar, zzsz zzszVar, boolean z, boolean z2, byte[] bArr) {
        this.zza = uri;
        this.zzb = zzaksVar;
        this.zzc = zzxbVar;
        this.zzd = zzygVar;
        this.zze = zzszVar;
        this.zzf = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzsh) {
            zzsh zzshVar = (zzsh) obj;
            if (this.zza.equals(zzshVar.zza()) && this.zzb.equals(zzshVar.zzb()) && this.zzc.equals(zzshVar.zzc()) && this.zzd.equals(zzshVar.zzd()) && this.zze.equals(zzshVar.zze()) && this.zzf == zzshVar.zzf()) {
                zzshVar.zzg();
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((true != this.zzf ? 1237 : 1231) ^ ((((((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode()) * 1000003) ^ this.zzd.hashCode()) * 1000003) ^ this.zze.hashCode()) * 1000003)) * 1000003) ^ 1237;
    }

    public final String toString() {
        String string = this.zza.toString();
        int length = string.length();
        String string2 = this.zzb.toString();
        int length2 = string2.length();
        zzsz zzszVar = this.zze;
        zzyg zzygVar = this.zzd;
        String strValueOf = String.valueOf(this.zzc);
        String strValueOf2 = String.valueOf(zzygVar);
        String string3 = zzszVar.toString();
        int length3 = String.valueOf(strValueOf).length();
        int length4 = String.valueOf(strValueOf2).length();
        int length5 = string3.length();
        boolean z = this.zzf;
        StringBuilder sb = new StringBuilder(length + 34 + length2 + 10 + length3 + 13 + length4 + 16 + length5 + 32 + String.valueOf(z).length() + 22);
        sb.append("ProtoDataStoreConfig{uri=");
        sb.append(string);
        sb.append(", schema=");
        sb.append(string2);
        sb.append(", handler=");
        sb.append(strValueOf);
        sb.append(", migrations=");
        sb.append(strValueOf2);
        sb.append(", variantConfig=");
        sb.append(string3);
        sb.append(", useGeneratedExtensionRegistry=");
        sb.append(z);
        sb.append(", enableTracing=false}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzsh
    public final Uri zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzsh
    public final zzaks zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzsh
    public final zzxb zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zzsh
    public final zzyg zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.nearby.zzsh
    public final zzsz zze() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.nearby.zzsh
    public final boolean zzf() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.nearby.zzsh
    final boolean zzg() {
        return false;
    }
}
