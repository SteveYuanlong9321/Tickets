package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzat extends zzej {
    private final BaseImplementation.ResultHolder zza;

    zzat(BaseImplementation.ResultHolder resultHolder) {
        this.zza = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder);
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzek
    public final void zzb(int i) {
        Status statusZzK = zzaw.zzK(i);
        boolean zIsSuccess = statusZzK.isSuccess();
        BaseImplementation.ResultHolder resultHolder = this.zza;
        if (zIsSuccess) {
            resultHolder.setResult(statusZzK);
        } else {
            resultHolder.setFailedResult(statusZzK);
        }
    }
}
