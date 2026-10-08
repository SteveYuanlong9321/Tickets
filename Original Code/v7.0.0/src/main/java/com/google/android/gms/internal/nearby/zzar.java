package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzar implements OnFailureListener {
    final /* synthetic */ GoogleApi zza;
    final /* synthetic */ ListenerHolder.ListenerKey zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzat zzd;

    zzar(zzat zzatVar, GoogleApi googleApi, ListenerHolder.ListenerKey listenerKey, boolean z) {
        this.zza = googleApi;
        this.zzb = listenerKey;
        this.zzc = z;
        Objects.requireNonNull(zzatVar);
        this.zzd = zzatVar;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        int statusCode;
        zzat zzatVar = this.zzd;
        synchronized (zzatVar) {
            if (!(exc instanceof ApiException) || ((statusCode = ((ApiException) exc).getStatusCode()) != 8001 && statusCode != 8002)) {
                zzatVar.zzf(this.zza, this.zzb);
            } else if (this.zzc) {
                zzatVar.zzh().remove(this.zzb);
            }
        }
    }
}
