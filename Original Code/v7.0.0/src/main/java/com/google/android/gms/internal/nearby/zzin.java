package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzin extends zzjd {
    final /* synthetic */ TaskCompletionSource zza;

    zzin(zziy zziyVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
        Objects.requireNonNull(zziyVar);
    }

    @Override // com.google.android.gms.internal.nearby.zzje
    public final void zzb(Status status, byte[] bArr) {
        if (!status.isSuccess()) {
            TaskUtil.setResultOrApiException(status, (Object) null, (TaskCompletionSource<Object>) this.zza);
            return;
        }
        try {
            TaskUtil.setResultOrApiException(status, zzmn.zzd(bArr, zzaiz.zzb()), (TaskCompletionSource<zzmn>) this.zza);
        } catch (zzakf e) {
            this.zza.setException(e);
        }
    }
}
