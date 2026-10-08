package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.nearby.connection.Connections;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzy extends zzan {
    final /* synthetic */ zzex zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzy(zzz zzzVar, zzex zzexVar) {
        super(null);
        this.zza = zzexVar;
        Objects.requireNonNull(zzzVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        zzex zzexVar = this.zza;
        Connections.ConnectionResponseCallback connectionResponseCallback = (Connections.ConnectionResponseCallback) obj;
        byte[] bArrZzc = zzexVar.zzc();
        if (bArrZzc != null) {
            connectionResponseCallback.onConnectionResponse(zzexVar.zza(), zzaw.zzK(zzexVar.zzb()), bArrZzc);
        }
    }
}
