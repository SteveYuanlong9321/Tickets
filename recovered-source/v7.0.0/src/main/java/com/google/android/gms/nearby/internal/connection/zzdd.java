package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.Connections;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdd implements Connections.StartAdvertisingResult {
    final /* synthetic */ Status zza;

    zzdd(zzde zzdeVar, Status status) {
        this.zza = status;
        Objects.requireNonNull(zzdeVar);
    }

    @Override // com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult
    public final String getLocalEndpointName() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}
