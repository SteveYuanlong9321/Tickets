package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdg implements Connections {
    public static final Api.ClientKey zza = new Api.ClientKey();
    public static final Api.AbstractClientBuilder zzb = new zzcs();

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult<Status> acceptConnection(GoogleApiClient googleApiClient, String str, PayloadCallback payloadCallback) {
        return googleApiClient.execute(new zzci(this, googleApiClient, str, googleApiClient.registerListener(payloadCallback)));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final PendingResult<Status> acceptConnectionRequest(GoogleApiClient googleApiClient, String str, byte[] bArr, Connections.MessageListener messageListener) {
        return googleApiClient.execute(new zzcq(this, googleApiClient, str, bArr, googleApiClient.registerListener(messageListener)));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult<Status> cancelPayload(GoogleApiClient googleApiClient, long j) {
        return googleApiClient.execute(new zzcm(this, googleApiClient, j));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void disconnectFromEndpoint(GoogleApiClient googleApiClient, String str) {
        googleApiClient.execute(new zzcn(this, googleApiClient, str));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult<Status> rejectConnection(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzcj(this, googleApiClient, str));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final PendingResult<Status> rejectConnectionRequest(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzcr(this, googleApiClient, str));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult<Status> requestConnection(GoogleApiClient googleApiClient, String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback) {
        return googleApiClient.execute(new zzdb(this, googleApiClient, str, str2, googleApiClient.registerListener(connectionLifecycleCallback)));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final PendingResult<Status> sendConnectionRequest(GoogleApiClient googleApiClient, String str, String str2, byte[] bArr, Connections.ConnectionResponseCallback connectionResponseCallback, Connections.MessageListener messageListener) {
        return googleApiClient.execute(new zzcp(this, googleApiClient, str, str2, bArr, googleApiClient.registerListener(connectionResponseCallback), googleApiClient.registerListener(messageListener)));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult<Status> sendPayload(GoogleApiClient googleApiClient, String str, Payload payload) {
        return googleApiClient.execute(new zzck(this, googleApiClient, str, payload));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void sendReliableMessage(GoogleApiClient googleApiClient, String str, byte[] bArr) {
        googleApiClient.execute(new zzct(this, googleApiClient, str, bArr));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void sendUnreliableMessage(GoogleApiClient googleApiClient, String str, byte[] bArr) {
        googleApiClient.execute(new zzck(this, googleApiClient, str, Payload.fromBytes(bArr)));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final PendingResult<Connections.StartAdvertisingResult> startAdvertising(GoogleApiClient googleApiClient, String str, AppMetadata appMetadata, long j, Connections.ConnectionRequestListener connectionRequestListener) {
        return googleApiClient.execute(new zzcw(this, googleApiClient, str, j, googleApiClient.registerListener(connectionRequestListener)));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final PendingResult<Status> startDiscovery(GoogleApiClient googleApiClient, String str, long j, Connections.EndpointDiscoveryListener endpointDiscoveryListener) {
        return googleApiClient.execute(new zzcz(this, googleApiClient, str, j, googleApiClient.registerListener(endpointDiscoveryListener)));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void stopAdvertising(GoogleApiClient googleApiClient) {
        googleApiClient.execute(new zzcx(this, googleApiClient));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void stopAllEndpoints(GoogleApiClient googleApiClient) {
        googleApiClient.execute(new zzco(this, googleApiClient));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void stopDiscovery(GoogleApiClient googleApiClient) {
        googleApiClient.execute(new zzda(this, googleApiClient));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult<Status> sendPayload(GoogleApiClient googleApiClient, List<String> list, Payload payload) {
        return googleApiClient.execute(new zzcl(this, googleApiClient, list, payload));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void sendReliableMessage(GoogleApiClient googleApiClient, List<String> list, byte[] bArr) {
        googleApiClient.execute(new zzcu(this, googleApiClient, list, bArr));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void stopDiscovery(GoogleApiClient googleApiClient, String str) {
        googleApiClient.execute(new zzda(this, googleApiClient));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void sendUnreliableMessage(GoogleApiClient googleApiClient, List<String> list, byte[] bArr) {
        googleApiClient.execute(new zzcl(this, googleApiClient, list, Payload.fromBytes(bArr)));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult<Connections.StartAdvertisingResult> startAdvertising(GoogleApiClient googleApiClient, String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions) {
        return googleApiClient.execute(new zzcv(this, googleApiClient, str, str2, googleApiClient.registerListener(connectionLifecycleCallback), advertisingOptions));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult<Status> startDiscovery(GoogleApiClient googleApiClient, String str, EndpointDiscoveryCallback endpointDiscoveryCallback, DiscoveryOptions discoveryOptions) {
        return googleApiClient.execute(new zzcy(this, googleApiClient, str, googleApiClient.registerListener(endpointDiscoveryCallback), discoveryOptions));
    }
}
