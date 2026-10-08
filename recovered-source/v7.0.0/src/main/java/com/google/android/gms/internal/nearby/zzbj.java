package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.messages.StatusCallback;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbj extends zzbi {
    final /* synthetic */ boolean zza;

    zzbj(zzbk zzbkVar, boolean z) {
        this.zza = z;
        Objects.requireNonNull(zzbkVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((StatusCallback) obj).onPermissionChanged(this.zza);
    }
}
