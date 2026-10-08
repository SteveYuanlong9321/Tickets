package com.google.android.gms.nearby.uwb;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzb {
    private int zza = 0;

    public final zzb zza(int i) {
        this.zza = i;
        return this;
    }

    public final zzc zzb() {
        Preconditions.checkArgument(this.zza != 0, "deviceType must be set.");
        return new zzc(this.zza, false, null, hashCode(), null);
    }
}
