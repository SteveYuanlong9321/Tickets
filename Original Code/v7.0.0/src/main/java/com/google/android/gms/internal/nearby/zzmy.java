package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmy {
    private final String zza = "com.google.android.gms.nearby";
    private final zznz zzb;

    public zzmy(String str, zznz zznzVar) {
        this.zzb = zznzVar;
    }

    public final zzne zza(String str, boolean z) {
        return new zzmv(this.zza, "connections_enable_wifi_lan_connectivity_info_v2", this.zzb, false);
    }
}
