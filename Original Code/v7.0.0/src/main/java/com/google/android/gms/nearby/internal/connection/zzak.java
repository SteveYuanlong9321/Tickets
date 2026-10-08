package com.google.android.gms.nearby.internal.connection;

import android.util.Log;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.Payload;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzak extends zzan {
    final /* synthetic */ zzfr zza;
    final /* synthetic */ zzam zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzak(zzam zzamVar, zzfr zzfrVar) {
        super(null);
        this.zza = zzfrVar;
        Objects.requireNonNull(zzamVar);
        this.zzb = zzamVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        byte[] bArrAsBytes;
        zzfr zzfrVar = this.zza;
        Connections.MessageListener messageListener = (Connections.MessageListener) obj;
        Payload payloadZza = zzgy.zza(this.zzb.zzd(), zzfrVar.zzb());
        if (payloadZza == null) {
            Log.w("NearbyConnectionsClient", String.format("Failed to convert incoming ParcelablePayload %d to Payload.", Long.valueOf(zzfrVar.zzb().zza())));
        } else if (payloadZza.getType() == 1 && (bArrAsBytes = payloadZza.asBytes()) != null) {
            messageListener.onMessageReceived(zzfrVar.zza(), bArrAsBytes, zzfrVar.zzc());
        }
    }
}
