package com.google.android.gms.internal.nearby;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
class zzmw extends zzmx {
    private volatile boolean zza;

    zzmw(String str, String str2, zznz zznzVar) {
        super("com.google.android.gms.nearby", "connections_enable_wifi_lan_connectivity_info_v2", zznzVar);
    }

    @Override // com.google.android.gms.internal.nearby.zzmu
    public final /* synthetic */ Object zza() {
        return Boolean.valueOf(this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzmo
    protected final /* synthetic */ Object zzd(String str) throws IOException {
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }

    @Override // com.google.android.gms.internal.nearby.zzmo
    protected final /* synthetic */ Object zze(Object obj) throws IOException {
        return (Boolean) obj;
    }

    @Override // com.google.android.gms.internal.nearby.zzmu
    public final /* synthetic */ void zzh(Object obj) {
        this.zza = ((Boolean) obj).booleanValue();
    }
}
