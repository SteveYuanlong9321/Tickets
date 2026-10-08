package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzoa implements zznz {
    private volatile zznf zza;
    private zzny zzb;

    /* synthetic */ zzoa(zznf zznfVar, byte[] bArr) {
        this.zza = zznfVar;
    }

    @Override // com.google.android.gms.internal.nearby.zznz
    public final zzny zza(zzkp zzkpVar, String str) {
        zznf zznfVar = this.zza;
        zznf zznfVar2 = zzny.zza;
        if (zznfVar != zznfVar2) {
            this.zzb = zzny.zzd().zzc(zzkpVar, zznfVar, "").zza(zzkpVar, "");
            this.zza = zznfVar2;
        }
        return this.zzb;
    }
}
