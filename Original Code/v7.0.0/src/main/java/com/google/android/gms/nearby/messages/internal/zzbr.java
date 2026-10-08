package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbr extends zzu {
    private static final com.google.android.gms.internal.nearby.zzbi zza = new zzbq();
    private final ListenerHolder zzb;

    public zzbr(ListenerHolder listenerHolder) {
        this.zzb = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzv
    public final void zzd() {
        this.zzb.notifyListener(zza);
    }
}
