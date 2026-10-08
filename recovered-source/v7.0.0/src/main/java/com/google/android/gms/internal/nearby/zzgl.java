package com.google.android.gms.internal.nearby;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgl extends zzdg {
    final /* synthetic */ TaskCompletionSource zza;

    zzgl(zzhq zzhqVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
        Objects.requireNonNull(zzhqVar);
    }

    @Override // com.google.android.gms.internal.nearby.zzdh
    public final void zzd(boolean z) {
        this.zza.setResult(Boolean.valueOf(z));
    }
}
