package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzav extends zzem {
    private final BaseImplementation.ResultHolder zza;

    zzav(BaseImplementation.ResultHolder resultHolder) {
        this.zza = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder);
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzen
    public final void zzb(zzfv zzfvVar) {
        Status statusZzK = zzaw.zzK(zzfvVar.zza());
        boolean zIsSuccess = statusZzK.isSuccess();
        BaseImplementation.ResultHolder resultHolder = this.zza;
        if (zIsSuccess) {
            resultHolder.setResult(new zzau(statusZzK, zzfvVar.zzb()));
        } else {
            resultHolder.setFailedResult(statusZzK);
        }
    }
}
