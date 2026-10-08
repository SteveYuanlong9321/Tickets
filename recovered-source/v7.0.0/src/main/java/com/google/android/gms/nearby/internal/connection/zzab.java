package com.google.android.gms.nearby.internal.connection;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzab extends zzan {
    final /* synthetic */ zzff zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzab(zzaf zzafVar, zzff zzffVar) {
        super(null);
        this.zza = zzffVar;
        Objects.requireNonNull(zzafVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        zzff zzffVar = this.zza;
        zzffVar.zza();
        zzffVar.zzb();
        zzffVar.zzc();
    }
}
