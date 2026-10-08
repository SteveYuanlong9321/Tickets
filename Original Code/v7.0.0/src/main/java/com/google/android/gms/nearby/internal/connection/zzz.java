package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
final class zzz extends zzdx {
    private final ListenerHolder zza;

    public zzz(ListenerHolder listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzdy
    public final void zzb(zzex zzexVar) {
        this.zza.notifyListener(new zzy(this, zzexVar));
    }
}
