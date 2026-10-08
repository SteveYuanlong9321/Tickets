package com.google.android.gms.nearby.internal.connection;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionOptions;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.ConnectionsOptions;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzch extends GoogleApi implements ConnectionsClient {
    public static final /* synthetic */ int zza = 0;
    private static final Api.ClientKey zzb;
    private static final Api.AbstractClientBuilder zzc;
    private static final Api zzd;
    private com.google.android.gms.internal.nearby.zzat zze;
    private final zzeq zzf;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zzb = clientKey;
        zzax zzaxVar = new zzax();
        zzc = zzaxVar;
        zzd = new Api("Nearby.CONNECTIONS_API", zzaxVar, clientKey);
    }

    private zzch(Activity activity, ConnectionsOptions connectionsOptions) {
        super(activity, (Api<Api.ApiOptions>) zzd, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zzf = zzeq.zza(activity);
    }

    public static zzch zza(Context context, ConnectionsOptions connectionsOptions) {
        zzch zzchVar = new zzch(context, (ConnectionsOptions) null);
        zzchVar.zze = com.google.android.gms.internal.nearby.zzat.zza(zzchVar, null);
        return zzchVar;
    }

    public static zzch zzb(Activity activity, ConnectionsOptions connectionsOptions) {
        zzch zzchVar = new zzch(activity, (ConnectionsOptions) null);
        zzchVar.zze = com.google.android.gms.internal.nearby.zzat.zza(zzchVar, null);
        return zzchVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final void zzf(String str) {
        this.zze.zze(this, RegistrationMethods.builder().withHolder(this.zze.zzc(this, str, "connection")).register(zzbs.zza).unregister(zzbt.zza).setMethodKey(1268).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final void zzg(String str) {
        com.google.android.gms.internal.nearby.zzat zzatVar = this.zze;
        zzatVar.zzf(this, zzatVar.zzd(str, "connection"));
    }

    private final Task zzj(final zzbc zzbcVar, int i) {
        return doWrite(TaskApiCall.builder().setMethodKey(i).run(new RemoteCall() { // from class: com.google.android.gms.nearby.internal.connection.zzbu
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                zzcf zzcfVar = new zzcf(this.zza, (TaskCompletionSource) obj2);
                zzbcVar.zza((zzaw) obj, zzcfVar);
            }
        }).build());
    }

    private final Task zzk(final zzcg zzcgVar, int i) {
        return doWrite(TaskApiCall.builder().setMethodKey(i).run(new RemoteCall() { // from class: com.google.android.gms.nearby.internal.connection.zzbv
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                int i2 = zzch.zza;
                zzcgVar.zza((zzaw) obj);
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> acceptConnection(final String str, PayloadCallback payloadCallback) {
        final ListenerHolder listenerHolderRegisterListener = registerListener(payloadCallback, PayloadCallback.class.getName());
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.nearby.internal.connection.zzbj
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                ((zzaw) obj).zzz(new zzcf(this.zza, (TaskCompletionSource) obj2), str, listenerHolderRegisterListener);
            }
        }).setMethodKey(1227).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> cancelPayload(final long j) {
        return zzj(new zzbc() { // from class: com.google.android.gms.nearby.internal.connection.zzbn
            @Override // com.google.android.gms.nearby.internal.connection.zzbc
            public final /* synthetic */ void zza(zzaw zzawVar, BaseImplementation.ResultHolder resultHolder) throws RemoteException {
                int i = zzch.zza;
                zzawVar.zzF(resultHolder, j);
            }
        }, 1424);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void disconnectFromEndpoint(final String str) {
        zzk(new zzcg() { // from class: com.google.android.gms.nearby.internal.connection.zzbo
            @Override // com.google.android.gms.nearby.internal.connection.zzcg
            public final /* synthetic */ void zza(zzaw zzawVar) throws RemoteException {
                int i = zzch.zza;
                zzawVar.zzG(str);
            }
        }, 1425);
        zzg(str);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> rejectConnection(final String str) {
        return zzj(new zzbc() { // from class: com.google.android.gms.nearby.internal.connection.zzbk
            @Override // com.google.android.gms.nearby.internal.connection.zzbc
            public final /* synthetic */ void zza(zzaw zzawVar, BaseImplementation.ResultHolder resultHolder) throws RemoteException {
                int i = zzch.zza;
                zzawVar.zzA(resultHolder, str);
            }
        }, 1422);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> requestConnection(final String str, final String str2, ConnectionLifecycleCallback connectionLifecycleCallback) {
        final ListenerHolder listenerHolderRegisterListener = registerListener(new zzbd(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        zzf(str2);
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.nearby.internal.connection.zzbw
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                ((zzaw) obj).zzy(new zzcf(this.zza, (TaskCompletionSource) obj2), str, str2, listenerHolderRegisterListener);
            }
        }).setMethodKey(1226).build()).addOnFailureListener(new zzbb(this, str2));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> sendPayload(final String str, final Payload payload) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.nearby.internal.connection.zzbl
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws Throwable {
                ((zzaw) obj).zzB(new zzcf(this.zza, (TaskCompletionSource) obj2), new String[]{str}, payload, false);
            }
        }).setMethodKey(1228).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> startAdvertising(final String str, final String str2, ConnectionLifecycleCallback connectionLifecycleCallback, final AdvertisingOptions advertisingOptions) {
        final ListenerHolder listenerHolderRegisterListener = registerListener(new zzbd(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        return this.zze.zze(this, RegistrationMethods.builder().withHolder(this.zze.zzb(this, new Object(), "advertising")).register(new RemoteCall() { // from class: com.google.android.gms.nearby.internal.connection.zzbz
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                ((zzaw) obj).zzD(new zzcf(this.zza, (TaskCompletionSource) obj2), str, str2, listenerHolderRegisterListener, zze.zza(advertisingOptions));
            }
        }).unregister(zzca.zza).setMethodKey(1266).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> startDiscovery(final String str, EndpointDiscoveryCallback endpointDiscoveryCallback, final DiscoveryOptions discoveryOptions) {
        final ListenerHolder listenerHolderZzb = this.zze.zzb(this, endpointDiscoveryCallback, "discovery");
        return this.zze.zze(this, RegistrationMethods.builder().withHolder(listenerHolderZzb).register(new RemoteCall() { // from class: com.google.android.gms.nearby.internal.connection.zzcc
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                ((zzaw) obj).zzE(new zzcf(this.zza, (TaskCompletionSource) obj2), str, listenerHolderZzb, zzdl.zza(discoveryOptions));
            }
        }).unregister(zzcd.zza).setMethodKey(1267).build()).addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.gms.nearby.internal.connection.zzbf
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final /* synthetic */ void onSuccess(Object obj) {
                this.zza.zzc(discoveryOptions, (Void) obj);
            }
        }).addOnFailureListener(zzbg.zza);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopAdvertising() {
        this.zze.zzg(this, "advertising");
        doWrite(TaskApiCall.builder().setMethodKey(1416).run(new zzcb(this)).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopAllEndpoints() {
        this.zze.zzg(this, "advertising");
        doWrite(TaskApiCall.builder().setMethodKey(1416).run(new zzcb(this)).build());
        this.zze.zzg(this, "discovery");
        doWrite(TaskApiCall.builder().setMethodKey(1420).run(new zzbh(this)).build()).addOnSuccessListener(new zzbi(this));
        zzk(zzbq.zza, 1426).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.nearby.internal.connection.zzbr
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task) {
                this.zza.zze(task);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopDiscovery() {
        this.zze.zzg(this, "discovery");
        doWrite(TaskApiCall.builder().setMethodKey(1420).run(new zzbh(this)).build()).addOnSuccessListener(new zzbi(this));
    }

    final /* synthetic */ void zzc(DiscoveryOptions discoveryOptions, Void r2) {
        if (discoveryOptions.zzf()) {
            zzeq zzeqVar = this.zzf;
            if (zzeqVar == null) {
                Log.d("NearbyConnections", "Discovery started with NFC requested, but there is no NfcDispatcher available. Discovery will continue over other mediums instead. To use NFC discovery, pass in an Activity when calling Nearby.getConnectionsClient().");
            } else {
                zzeqVar.zzb();
            }
        }
    }

    final /* synthetic */ void zzd(Void r1) {
        zzeq zzeqVar = this.zzf;
        if (zzeqVar != null) {
            zzeqVar.zzc();
        }
    }

    final /* synthetic */ void zze(Task task) {
        this.zze.zzg(this, "connection");
        disconnectService();
    }

    private zzch(Context context, ConnectionsOptions connectionsOptions) {
        super(context, (Api<Api.ApiOptions>) zzd, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zzf = null;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> sendPayload(final List<String> list, final Payload payload) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.nearby.internal.connection.zzbm
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws Throwable {
                ((zzaw) obj).zzB(new zzcf(this.zza, (TaskCompletionSource) obj2), (String[]) list.toArray(new String[0]), payload, false);
            }
        }).setMethodKey(1228).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> requestConnection(final String str, final String str2, ConnectionLifecycleCallback connectionLifecycleCallback, final ConnectionOptions connectionOptions) {
        final ListenerHolder listenerHolderRegisterListener = registerListener(new zzbd(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        zzf(str2);
        return doWrite(TaskApiCall.builder().setFeatures(com.google.android.gms.nearby.zza.zza).run(new RemoteCall() { // from class: com.google.android.gms.nearby.internal.connection.zzce
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                ((zzaw) obj).zzv(new zzcf(this.zza, (TaskCompletionSource) obj2), str, str2, listenerHolderRegisterListener, zzm.zza(connectionOptions));
            }
        }).setMethodKey(1226).build()).addOnFailureListener(new zzay(this, str2));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> startAdvertising(final byte[] bArr, final String str, ConnectionLifecycleCallback connectionLifecycleCallback, final AdvertisingOptions advertisingOptions) {
        final ListenerHolder listenerHolderRegisterListener = registerListener(new zzbd(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        return this.zze.zze(this, RegistrationMethods.builder().withHolder(this.zze.zzb(this, new Object(), "advertising")).setFeatures(com.google.android.gms.nearby.zza.zza).register(new RemoteCall() { // from class: com.google.android.gms.nearby.internal.connection.zzbx
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                ((zzaw) obj).zzC(new zzcf(this.zza, (TaskCompletionSource) obj2), bArr, str, listenerHolderRegisterListener, zze.zza(advertisingOptions));
            }
        }).unregister(zzby.zza).setMethodKey(1266).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> requestConnection(final byte[] bArr, final String str, ConnectionLifecycleCallback connectionLifecycleCallback) {
        final ListenerHolder listenerHolderRegisterListener = registerListener(new zzbd(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        zzf(str);
        return doWrite(TaskApiCall.builder().setFeatures(com.google.android.gms.nearby.zza.zza).run(new RemoteCall() { // from class: com.google.android.gms.nearby.internal.connection.zzbp
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                ((zzaw) obj).zzx(new zzcf(this.zza, (TaskCompletionSource) obj2), bArr, str, listenerHolderRegisterListener);
            }
        }).setMethodKey(1226).build()).addOnFailureListener(new zzba(this, str));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> requestConnection(final byte[] bArr, final String str, ConnectionLifecycleCallback connectionLifecycleCallback, final ConnectionOptions connectionOptions) {
        final ListenerHolder listenerHolderRegisterListener = registerListener(new zzbd(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        zzf(str);
        return doWrite(TaskApiCall.builder().setFeatures(com.google.android.gms.nearby.zza.zza).run(new RemoteCall() { // from class: com.google.android.gms.nearby.internal.connection.zzbe
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                ((zzaw) obj).zzw(new zzcf(this.zza, (TaskCompletionSource) obj2), bArr, str, listenerHolderRegisterListener, zzm.zza(connectionOptions));
            }
        }).setMethodKey(1226).build()).addOnFailureListener(new zzaz(this, str));
    }
}
