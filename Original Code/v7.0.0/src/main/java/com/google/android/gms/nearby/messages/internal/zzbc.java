package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
class zzbc extends zzu {
    private static final com.google.android.gms.internal.nearby.zzbi zza = new zzbb();
    private final ListenerHolder zzb;

    public zzbc(ListenerHolder listenerHolder) {
        this.zzb = listenerHolder;
    }

    public void zzd() {
        ListenerHolder listenerHolder = this.zzb;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(zza);
        }
    }
}
