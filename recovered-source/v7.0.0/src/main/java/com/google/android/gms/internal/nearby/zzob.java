package com.google.android.gms.internal.nearby;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzob {
    private final zzwx zza;
    private zzyl zzb = zzyl.zzh();
    private boolean zzc = false;

    public zzob(zzwx zzwxVar) {
        this.zza = zzwxVar;
    }

    public final zzob zza(Set set) {
        this.zzb = zzyl.zzm(set);
        return this;
    }

    public final zzob zzb() {
        this.zzc = true;
        return this;
    }

    public final zznz zzc() {
        return new zzoa(new zznf(this.zza, false, false, this.zzc, false, this.zzb), null);
    }
}
