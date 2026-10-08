package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzai extends zzeb {
    private final ListenerHolder zza;

    zzai(ListenerHolder listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzec
    public final synchronized void zzb(zzff zzffVar) {
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzec
    public final void zzc(zzfh zzfhVar) {
        this.zza.notifyListener(new zzag(this, zzfhVar));
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzec
    public final void zzd(zzfn zzfnVar) {
        this.zza.notifyListener(new zzah(this, zzfnVar));
    }
}
