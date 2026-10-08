package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.nearby.connection.BandwidthInfo;
import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbd extends ConnectionLifecycleCallback {
    final /* synthetic */ zzch zza;
    private final ConnectionLifecycleCallback zzb;

    zzbd(zzch zzchVar, ConnectionLifecycleCallback connectionLifecycleCallback) {
        Objects.requireNonNull(zzchVar);
        this.zza = zzchVar;
        this.zzb = connectionLifecycleCallback;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback, com.google.android.gms.nearby.connection.zza
    public final void onBandwidthChanged(String str, BandwidthInfo bandwidthInfo) {
        this.zzb.onBandwidthChanged(str, bandwidthInfo);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback, com.google.android.gms.nearby.connection.zza
    public final void onConnectionInitiated(String str, ConnectionInfo connectionInfo) {
        if (connectionInfo.isIncomingConnection()) {
            this.zza.zzf(str);
        }
        this.zzb.onConnectionInitiated(str, connectionInfo);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback, com.google.android.gms.nearby.connection.zza
    public final void onConnectionResult(String str, ConnectionResolution connectionResolution) {
        if (!connectionResolution.getStatus().isSuccess()) {
            this.zza.zzg(str);
        }
        this.zzb.onConnectionResult(str, connectionResolution);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback, com.google.android.gms.nearby.connection.zza
    public final void onDisconnected(String str) {
        this.zza.zzg(str);
        this.zzb.onDisconnected(str);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void zza(List list) {
        this.zzb.zza(list);
    }
}
