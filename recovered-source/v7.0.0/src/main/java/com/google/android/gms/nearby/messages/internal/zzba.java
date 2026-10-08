package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.PublishOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzba implements zzao {
    private final /* synthetic */ zzbf zza;
    private final /* synthetic */ Message zzb;
    private final /* synthetic */ zzbc zzc;
    private final /* synthetic */ PublishOptions zzd;

    /* synthetic */ zzba(zzbf zzbfVar, Message message, zzbc zzbcVar, PublishOptions publishOptions) {
        this.zza = zzbfVar;
        this.zzb = message;
        this.zzc = zzbcVar;
        this.zzd = publishOptions;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzao
    public final /* synthetic */ void zza(zzah zzahVar, ListenerHolder listenerHolder) {
        this.zza.zza(this.zzb, this.zzc, this.zzd, zzahVar, listenerHolder);
    }
}
