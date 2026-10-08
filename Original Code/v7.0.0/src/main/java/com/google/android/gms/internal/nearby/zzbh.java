package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbh extends com.google.android.gms.nearby.messages.internal.zzq {
    private final ListenerHolder zza;
    private boolean zzb = false;

    public zzbh(ListenerHolder listenerHolder) {
        this.zza = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzr
    public final synchronized void zzd(Status status) throws RemoteException {
        if (!this.zzb) {
            this.zza.notifyListener(new zzbg(this, status));
            this.zzb = true;
            return;
        }
        String strValueOf = String.valueOf(status);
        String.valueOf(strValueOf);
        String strValueOf2 = String.valueOf(strValueOf);
        Log.wtf("NearbyMessagesCallbackWrapper", "Received multiple statuses: ".concat(strValueOf2), new Exception());
    }
}
