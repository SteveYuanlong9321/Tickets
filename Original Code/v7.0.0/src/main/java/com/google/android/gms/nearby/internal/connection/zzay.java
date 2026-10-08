package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzay implements OnFailureListener {
    final /* synthetic */ String zza;
    final /* synthetic */ zzch zzb;

    zzay(zzch zzchVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzchVar);
        this.zzb = zzchVar;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        if ((exc instanceof ApiException) && ((ApiException) exc).getStatusCode() == 8003) {
            return;
        }
        this.zzb.zzg(this.zza);
    }
}
