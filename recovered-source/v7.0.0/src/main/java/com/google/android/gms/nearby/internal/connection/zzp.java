package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzp extends zzan {
    final /* synthetic */ zzez zza;
    final /* synthetic */ Status zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzp(zzv zzvVar, zzez zzezVar, Status status) {
        super(null);
        this.zza = zzezVar;
        this.zzb = status;
        Objects.requireNonNull(zzvVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((ConnectionLifecycleCallback) obj).onConnectionResult(this.zza.zza(), new ConnectionResolution(this.zzb));
    }
}
