package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzat implements zzao {
    private final /* synthetic */ zzbf zza;
    private final /* synthetic */ PendingIntent zzb;
    private final /* synthetic */ zzbe zzc;
    private final /* synthetic */ SubscribeOptions zzd;

    /* synthetic */ zzat(zzbf zzbfVar, PendingIntent pendingIntent, zzbe zzbeVar, SubscribeOptions subscribeOptions) {
        this.zza = zzbfVar;
        this.zzb = pendingIntent;
        this.zzc = zzbeVar;
        this.zzd = subscribeOptions;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzao
    public final /* synthetic */ void zza(zzah zzahVar, ListenerHolder listenerHolder) {
        this.zza.zzc(this.zzb, this.zzc, this.zzd, zzahVar, listenerHolder);
    }
}
