package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzad extends zzai {
    final /* synthetic */ TaskCompletionSource zza;

    zzad(zzag zzagVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
        Objects.requireNonNull(zzagVar);
    }

    @Override // com.google.android.gms.internal.nearby.zzaj
    public final void zzb(Status status, boolean z) {
        TaskUtil.trySetResultOrApiException(status, Boolean.valueOf(z), this.zza);
    }
}
