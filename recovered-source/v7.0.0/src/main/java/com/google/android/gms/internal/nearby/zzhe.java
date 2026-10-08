package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzhe implements RemoteCall {
    private final /* synthetic */ zzgq zza;

    /* synthetic */ zzhe(zzgq zzgqVar) {
        this.zza = zzgqVar;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
        int i = zzhq.zza;
        zzdj zzdjVar = (zzdj) ((zzgg) obj).getService();
        zzgd zzgdVar = new zzgd();
        zzgdVar.zza(this.zza);
        zzdjVar.zzq(zzgdVar.zzb());
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
