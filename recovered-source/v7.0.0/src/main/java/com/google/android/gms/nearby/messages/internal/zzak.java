package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzak extends zzbe {
    final /* synthetic */ ListenerHolder zza;
    final /* synthetic */ zzbf zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzak(zzbf zzbfVar, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        super(listenerHolder);
        this.zza = listenerHolder2;
        Objects.requireNonNull(zzbfVar);
        this.zzb = zzbfVar;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbe, com.google.android.gms.nearby.messages.internal.zzab
    public final void zzd() {
        ListenerHolder.ListenerKey<?> listenerKey = this.zza.getListenerKey();
        if (listenerKey != null) {
            this.zzb.doUnregisterEventListener(listenerKey);
        }
        super.zzd();
    }
}
