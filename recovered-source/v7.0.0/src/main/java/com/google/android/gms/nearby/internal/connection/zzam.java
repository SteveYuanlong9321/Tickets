package com.google.android.gms.nearby.internal.connection;

import android.content.Context;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
final class zzam extends zzdr {
    private final Context zza;
    private final ListenerHolder zzb;

    zzam(Context context, ListenerHolder listenerHolder) {
        this.zza = (Context) Preconditions.checkNotNull(context);
        this.zzb = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzds
    public final void zzb(zzfr zzfrVar) {
        this.zzb.notifyListener(new zzak(this, zzfrVar));
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzds
    public final void zzc(zzfd zzfdVar) {
        this.zzb.notifyListener(new zzal(this, zzfdVar));
    }

    final /* synthetic */ Context zzd() {
        return this.zza;
    }
}
