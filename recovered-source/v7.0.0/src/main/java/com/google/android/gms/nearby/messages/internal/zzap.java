package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.Message;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzap implements zzao {
    private final /* synthetic */ Message zza;

    @Override // com.google.android.gms.nearby.messages.internal.zzao
    public final /* synthetic */ void zza(zzah zzahVar, ListenerHolder listenerHolder) throws RemoteException {
        int i = zzbf.zza;
        zzahVar.zzy(listenerHolder, new zzae(1, this.zza));
    }
}
