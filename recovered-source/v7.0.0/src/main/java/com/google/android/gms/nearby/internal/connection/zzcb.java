package com.google.android.gms.nearby.internal.connection;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzcb implements RemoteCall {
    private final /* synthetic */ zzch zza;

    /* synthetic */ zzcb(zzch zzchVar) {
        this.zza = zzchVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
        zzcf zzcfVar = new zzcf(this.zza, (TaskCompletionSource) obj2);
        zzee zzeeVar = (zzee) ((zzaw) obj).getService();
        zzho zzhoVar = new zzho();
        zzhoVar.zza(new zzat(zzcfVar));
        zzeeVar.zze(zzhoVar.zzb());
    }
}
