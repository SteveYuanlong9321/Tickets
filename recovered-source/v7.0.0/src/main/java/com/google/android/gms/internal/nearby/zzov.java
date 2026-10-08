package com.google.android.gms.internal.nearby;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzov implements zzoe {
    final /* synthetic */ zzow zza;
    private final zzpe zzb;

    zzov(zzow zzowVar, zzpe zzpeVar) {
        Objects.requireNonNull(zzowVar);
        this.zza = zzowVar;
        this.zzb = zzpeVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzoe
    public final void zza(zzod zzodVar) {
        Iterator it = this.zza.zzc().iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (((zzou) it.next()).zza(zzodVar.zza()) && !z) {
                this.zzb.zza();
                z = true;
            }
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzoe
    public final void zzb(Throwable th) {
    }
}
