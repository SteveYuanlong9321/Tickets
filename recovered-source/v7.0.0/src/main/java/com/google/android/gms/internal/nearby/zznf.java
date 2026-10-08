package com.google.android.gms.internal.nearby;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zznf {
    private final zzwx zza;
    private final boolean zzb;
    private final zzyl zzc;
    private volatile String zzd = null;

    zznf(zzwx zzwxVar, boolean z, boolean z2, boolean z3, boolean z4, zzyl zzylVar) {
        this.zza = zzwxVar;
        this.zzb = z3;
        this.zzc = zzylVar;
    }

    final String zza(Context context) {
        String str = this.zzd;
        if (str != null) {
            return str;
        }
        String str2 = (String) this.zza.zza(context);
        this.zzd = str2;
        return str2;
    }

    final boolean zzb() {
        return this.zzb;
    }

    final zzyl zzc() {
        return this.zzc;
    }
}
