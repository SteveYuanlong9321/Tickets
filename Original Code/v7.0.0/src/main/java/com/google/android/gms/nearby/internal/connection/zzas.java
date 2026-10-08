package com.google.android.gms.nearby.internal.connection;

import android.content.Context;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzas extends zzeg implements zzaj {
    private final Context zza;
    private final ListenerHolder zzb;
    private final Map zzc = new ArrayMap();
    private final zzgc zzd;

    zzas(Context context, ListenerHolder listenerHolder, zzgc zzgcVar) {
        this.zza = (Context) Preconditions.checkNotNull(context);
        this.zzb = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        this.zzd = zzgcVar;
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzeh
    public final synchronized void zzb(zzfr zzfrVar) {
        Payload payloadZza = zzgy.zza(this.zza, zzfrVar.zzb());
        if (payloadZza == null) {
            Log.w("NearbyConnectionsClient", String.format("Failed to convert incoming ParcelablePayload %d to Payload.", Long.valueOf(zzfrVar.zzb().zza())));
            return;
        }
        Map map = this.zzc;
        zzar zzarVar = new zzar(zzfrVar.zza(), zzfrVar.zzb().zza());
        PayloadTransferUpdate.Builder builder = new PayloadTransferUpdate.Builder();
        builder.setPayloadId(zzfrVar.zzb().zza());
        map.put(zzarVar, builder.build());
        this.zzb.notifyListener(new zzao(this, zzfrVar, payloadZza));
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzeh
    public final synchronized void zzc(zzft zzftVar) {
        int status = zzftVar.zzb().getStatus();
        Map map = this.zzc;
        if (status == 3) {
            map.put(new zzar(zzftVar.zza(), zzftVar.zzb().getPayloadId()), zzftVar.zzb());
        } else {
            map.remove(new zzar(zzftVar.zza(), zzftVar.zzb().getPayloadId()));
            zzgc zzgcVar = this.zzd;
            if (zzgcVar != null) {
                zzgcVar.zzb(zzftVar.zzb().getPayloadId());
            }
        }
        this.zzb.notifyListener(new zzap(this, zzftVar));
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzaj
    public final synchronized void zzg() {
        Map map = this.zzc;
        for (Map.Entry entry : map.entrySet()) {
            this.zzb.notifyListener(new zzaq(this, ((zzar) entry.getKey()).zza(), (PayloadTransferUpdate) entry.getValue()));
        }
        map.clear();
    }
}
