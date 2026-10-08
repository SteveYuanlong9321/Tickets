package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaas extends zzaav {
    final /* synthetic */ zzaav zza;
    final /* synthetic */ zzaav zzb;

    zzaas(zzaav zzaavVar, zzaav zzaavVar2) {
        this.zza = zzaavVar;
        this.zzb = zzaavVar2;
    }

    @Override // com.google.android.gms.internal.nearby.zzaav
    public final void zzb() {
        try {
            this.zza.zzb();
        } finally {
            this.zzb.zzb();
        }
    }
}
