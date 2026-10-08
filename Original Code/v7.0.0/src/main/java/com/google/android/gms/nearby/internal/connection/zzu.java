package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzu extends zzan {
    final /* synthetic */ String zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzu(zzv zzvVar, String str) {
        super(null);
        this.zza = str;
        Objects.requireNonNull(zzvVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((ConnectionLifecycleCallback) obj).onDisconnected(this.zza);
    }
}
