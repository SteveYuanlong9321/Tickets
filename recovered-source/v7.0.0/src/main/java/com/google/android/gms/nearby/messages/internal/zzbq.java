package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.nearby.messages.PublishCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbq extends com.google.android.gms.internal.nearby.zzbi {
    zzbq() {
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((PublishCallback) obj).onExpired();
    }
}
