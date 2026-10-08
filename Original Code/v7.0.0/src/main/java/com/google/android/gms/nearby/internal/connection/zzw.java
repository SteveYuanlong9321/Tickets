package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.Connections;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzw extends zzan {
    final /* synthetic */ zzev zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzw(zzx zzxVar, zzev zzevVar) {
        super(null);
        this.zza = zzevVar;
        Objects.requireNonNull(zzxVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        zzev zzevVar = this.zza;
        ((Connections.ConnectionRequestListener) obj).onConnectionRequest(zzevVar.zza(), zzevVar.zzb(), (byte[]) Preconditions.checkNotNull(zzevVar.zzc()));
    }
}
