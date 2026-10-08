package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzhc implements RemoteCall {
    static final /* synthetic */ zzhc zza = new zzhc();

    private /* synthetic */ zzhc() {
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
        int i = zzhq.zza;
        ((zzdj) ((zzgg) obj).getService()).zzs(new zzfv());
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
