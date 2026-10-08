package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.messages.MessageListener;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbe extends zzbi {
    final /* synthetic */ List zza;

    zzbe(zzbf zzbfVar, List list) {
        this.zza = list;
        Objects.requireNonNull(zzbfVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        zzbf.zzb(this.zza, (MessageListener) obj);
    }
}
