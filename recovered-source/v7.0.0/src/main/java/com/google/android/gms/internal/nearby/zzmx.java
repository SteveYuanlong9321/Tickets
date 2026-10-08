package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzmx extends zzmo implements zzmu {
    private volatile int zza;
    private zzok zzb;

    zzmx(String str, String str2, zznz zznzVar) {
        super("com.google.android.gms.nearby", "connections_enable_wifi_lan_connectivity_info_v2", zznzVar);
        this.zza = -1;
    }

    @Override // com.google.android.gms.internal.nearby.zzmo
    protected final Object zzc(zzkp zzkpVar) {
        return zzbi(this, zzkpVar, "");
    }

    @Override // com.google.android.gms.internal.nearby.zzmu
    public final int zzf() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzmu
    public final zzok zzg() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzmu
    public final void zzi(int i) {
        this.zza = i;
    }

    @Override // com.google.android.gms.internal.nearby.zzmu
    public final void zzj(zzok zzokVar) {
        this.zzb = zzokVar;
    }
}
