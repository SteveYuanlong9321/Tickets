package com.google.android.gms.nearby.connection;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ConnectionLifecycleCallback extends zza {
    @Override // com.google.android.gms.nearby.connection.zza
    public void onBandwidthChanged(String str, BandwidthInfo bandwidthInfo) {
    }

    @Override // com.google.android.gms.nearby.connection.zza
    public abstract void onConnectionInitiated(String str, ConnectionInfo connectionInfo);

    @Override // com.google.android.gms.nearby.connection.zza
    public abstract void onConnectionResult(String str, ConnectionResolution connectionResolution);

    @Override // com.google.android.gms.nearby.connection.zza
    public abstract void onDisconnected(String str);

    public void zza(List list) {
    }
}
