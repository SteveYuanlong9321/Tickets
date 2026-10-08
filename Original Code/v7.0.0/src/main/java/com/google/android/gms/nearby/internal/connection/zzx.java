package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
final class zzx extends zzdo {
    private final ListenerHolder zza;

    zzx(ListenerHolder listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzdp
    public final void zzb(zzev zzevVar) {
        this.zza.notifyListener(new zzw(this, zzevVar));
    }
}
