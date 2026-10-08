package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzac extends zzan {
    final /* synthetic */ zzfh zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzac(zzaf zzafVar, zzfh zzfhVar) {
        super(null);
        this.zza = zzfhVar;
        Objects.requireNonNull(zzafVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        zzfh zzfhVar = this.zza;
        EndpointDiscoveryCallback endpointDiscoveryCallback = (EndpointDiscoveryCallback) obj;
        if (zzaf.zzg(zzfhVar)) {
            com.google.android.gms.nearby.connection.zzt zztVar = new com.google.android.gms.nearby.connection.zzt();
            zztVar.zza(zzfhVar.zzb());
            zztVar.zzc(zzfhVar.zzd());
            endpointDiscoveryCallback.onEndpointFound("__UNRECOGNIZED_BLUETOOTH_DEVICE__", zztVar.zze());
            return;
        }
        String strZza = zzfhVar.zza();
        com.google.android.gms.nearby.connection.zzt zztVar2 = new com.google.android.gms.nearby.connection.zzt();
        zztVar2.zza(zzfhVar.zzb());
        zztVar2.zzb(zzfhVar.zzc());
        zztVar2.zzd(zzfhVar.zze());
        endpointDiscoveryCallback.onEndpointFound(strZza, zztVar2.zze());
    }
}
