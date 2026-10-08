package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbg extends zzbi {
    final /* synthetic */ Status zza;

    zzbg(zzbh zzbhVar, Status status) {
        this.zza = status;
        Objects.requireNonNull(zzbhVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        BaseImplementation.ResultHolder resultHolder = (BaseImplementation.ResultHolder) obj;
        Status status = this.zza;
        if (status.isSuccess()) {
            resultHolder.setResult(status);
        } else {
            resultHolder.setFailedResult(status);
        }
    }
}
