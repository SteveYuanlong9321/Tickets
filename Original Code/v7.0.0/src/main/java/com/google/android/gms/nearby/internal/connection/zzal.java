package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.nearby.connection.Connections;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzal extends zzan {
    final /* synthetic */ zzfd zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzal(zzam zzamVar, zzfd zzfdVar) {
        super(null);
        this.zza = zzfdVar;
        Objects.requireNonNull(zzamVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((Connections.MessageListener) obj).onDisconnected(this.zza.zza());
    }
}
