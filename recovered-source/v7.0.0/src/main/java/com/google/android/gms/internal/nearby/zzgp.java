package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.uwb.UwbStatusCodes;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgp extends zzdr {
    final /* synthetic */ TaskCompletionSource zza;

    zzgp(zzhq zzhqVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
        Objects.requireNonNull(zzhqVar);
    }

    @Override // com.google.android.gms.internal.nearby.zzds
    public final void zzd(int i) {
        if (i == 42004) {
            this.zza.setException(new SecurityException("Missing UWB_RANGING permission"));
            return;
        }
        TaskCompletionSource taskCompletionSource = this.zza;
        if (i != 0) {
            taskCompletionSource.setException(new ApiException(new Status(i, UwbStatusCodes.zza(i))));
        } else {
            taskCompletionSource.setResult(null);
        }
    }
}
