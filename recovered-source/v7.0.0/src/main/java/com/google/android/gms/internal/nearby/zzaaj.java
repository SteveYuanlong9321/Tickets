package com.google.android.gms.internal.nearby;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaaj implements Runnable {
    final /* synthetic */ zzaai zza;
    final /* synthetic */ zzaak zzb;

    zzaaj(zzaak zzaakVar, zzaai zzaaiVar) {
        this.zza = zzaaiVar;
        Objects.requireNonNull(zzaakVar);
        this.zzb = zzaakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc().remove(this.zza);
    }
}
