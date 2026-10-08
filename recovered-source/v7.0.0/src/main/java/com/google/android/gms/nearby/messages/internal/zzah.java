package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzah extends GmsClient {
    private final com.google.android.gms.internal.nearby.zzbl zze;
    private final ClientAppContext zzf;
    private final int zzg;

    private zzah(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings, MessagesOptions messagesOptions) {
        super(context, looper, 62, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zze = new com.google.android.gms.internal.nearby.zzbl();
        String realClientPackageName = clientSettings.getRealClientPackageName();
        int iZzu = zzu(context);
        if (messagesOptions != null) {
            this.zzf = new ClientAppContext(1, realClientPackageName, null, false, iZzu, null);
            this.zzg = messagesOptions.zzc;
        } else {
            this.zzf = new ClientAppContext(1, realClientPackageName, null, false, iZzu, null);
            this.zzg = -1;
        }
    }

    static int zzu(Context context) {
        if (context instanceof Activity) {
            return 1;
        }
        if (context instanceof Application) {
            return 2;
        }
        return context instanceof Service ? 3 : 0;
    }

    public static zzah zzv(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings, MessagesOptions messagesOptions) {
        zzah zzahVar = new zzah(context, looper, connectionCallbacks, onConnectionFailedListener, clientSettings, messagesOptions);
        if (zzu(context) == 1) {
            Activity activity = (Activity) context;
            if (Log.isLoggable("NearbyMessagesClient", 2)) {
                Log.v("NearbyMessagesClient", String.format("Registering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", activity.getPackageName()));
            }
            activity.getApplication().registerActivityLifecycleCallbacks(new zzag(activity, zzahVar, null));
        }
        return zzahVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        return iInterfaceQueryLocalInterface instanceof zzs ? (zzs) iInterfaceQueryLocalInterface : new zzs(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        try {
            zzH(2);
        } catch (RemoteException e) {
            if (Log.isLoggable("NearbyMessagesClient", 2)) {
                Log.v("NearbyMessagesClient", String.format("Failed to emit CLIENT_DISCONNECTED from override of GmsClient#disconnect(): %s", e));
            }
        }
        this.zze.zze();
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle getGetServiceRequestExtraArgs() {
        Bundle getServiceRequestExtraArgs = super.getGetServiceRequestExtraArgs();
        getServiceRequestExtraArgs.putInt("NearbyPermissions", this.zzg);
        getServiceRequestExtraArgs.putParcelable("ClientAppContext", this.zzf);
        return getServiceRequestExtraArgs;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    @Deprecated
    final void zzA(ListenerHolder listenerHolder, ListenerHolder listenerHolder2, zzaa zzaaVar, SubscribeOptions subscribeOptions, byte[] bArr) throws RemoteException {
        zzz(listenerHolder, listenerHolder2, zzaaVar, subscribeOptions, null, this.zzf.zze);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzB(ListenerHolder listenerHolder, PendingIntent pendingIntent, zzaa zzaaVar, SubscribeOptions subscribeOptions, int i) throws RemoteException {
        Strategy strategy = subscribeOptions.getStrategy();
        com.google.android.gms.internal.nearby.zzbh zzbhVar = new com.google.android.gms.internal.nearby.zzbh(listenerHolder);
        MessageFilter filter = subscribeOptions.getFilter();
        boolean z = subscribeOptions.zza;
        int i2 = subscribeOptions.zzb;
        ((zzs) getService()).zzf(new SubscribeRequest(3, null, strategy, zzbhVar, filter, pendingIntent, 0, null, null, null, false, zzaaVar, false, null, false, 0, this.zzf.zze));
    }

    @Deprecated
    final void zzC(ListenerHolder listenerHolder, PendingIntent pendingIntent, zzaa zzaaVar, SubscribeOptions subscribeOptions) throws RemoteException {
        zzB(listenerHolder, pendingIntent, zzaaVar, subscribeOptions, this.zzf.zze);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzD(ListenerHolder listenerHolder, ListenerHolder listenerHolder2) throws RemoteException {
        ListenerHolder.ListenerKey listenerKey = listenerHolder2.getListenerKey();
        if (listenerKey == null) {
            return;
        }
        com.google.android.gms.internal.nearby.zzbh zzbhVar = new com.google.android.gms.internal.nearby.zzbh(listenerHolder);
        com.google.android.gms.internal.nearby.zzbl zzblVar = this.zze;
        if (!zzblVar.zza(listenerKey)) {
            zzbhVar.zzd(new Status(0));
            return;
        }
        ((zzs) getService()).zzg(new zzce(1, (IBinder) zzblVar.zzc(listenerKey), zzbhVar, null, 0, null, null, false, null));
        zzblVar.zzd(listenerKey);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzE(ListenerHolder listenerHolder, PendingIntent pendingIntent) throws RemoteException {
        ((zzs) getService()).zzg(new zzce(1, null, new com.google.android.gms.internal.nearby.zzbh(listenerHolder), pendingIntent, 0, null, null, false, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzF(ListenerHolder listenerHolder, ListenerHolder listenerHolder2) throws RemoteException {
        ListenerHolder.ListenerKey listenerKey = listenerHolder2.getListenerKey();
        if (listenerKey == null) {
            return;
        }
        com.google.android.gms.internal.nearby.zzbl zzblVar = this.zze;
        if (!zzblVar.zza(listenerKey)) {
            zzblVar.zzb(listenerKey, new com.google.android.gms.internal.nearby.zzbk(listenerHolder2));
        }
        zzbz zzbzVar = new zzbz(1, new com.google.android.gms.internal.nearby.zzbh(listenerHolder), (IBinder) zzblVar.zzc(listenerKey), false, null, null);
        zzbzVar.zzd = true;
        ((zzs) getService()).zzi(zzbzVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzG(ListenerHolder listenerHolder, ListenerHolder listenerHolder2) throws RemoteException {
        ListenerHolder.ListenerKey listenerKey = listenerHolder2.getListenerKey();
        if (listenerKey == null) {
            return;
        }
        com.google.android.gms.internal.nearby.zzbh zzbhVar = new com.google.android.gms.internal.nearby.zzbh(listenerHolder);
        com.google.android.gms.internal.nearby.zzbl zzblVar = this.zze;
        if (!zzblVar.zza(listenerKey)) {
            zzbhVar.zzd(new Status(0));
            return;
        }
        zzbz zzbzVar = new zzbz(1, zzbhVar, (IBinder) zzblVar.zzc(listenerKey), false, null, null);
        zzbzVar.zzd = false;
        ((zzs) getService()).zzi(zzbzVar);
        zzblVar.zzd(listenerKey);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzH(int i) throws RemoteException {
        String str = i != 1 ? "CLIENT_DISCONNECTED" : "ACTIVITY_STOPPED";
        if (!isConnected()) {
            if (Log.isLoggable("NearbyMessagesClient", 3)) {
                Log.d("NearbyMessagesClient", String.format("Failed to emit client lifecycle event %s due to GmsClient being disconnected", str));
            }
        } else {
            zzj zzjVar = new zzj(1, null, i);
            if (Log.isLoggable("NearbyMessagesClient", 3)) {
                Log.d("NearbyMessagesClient", String.format("Emitting client lifecycle event %s", str));
            }
            ((zzs) getService()).zzj(zzjVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzw(ListenerHolder listenerHolder, zzae zzaeVar, zzu zzuVar, PublishOptions publishOptions, int i) throws RemoteException {
        ((zzs) getService()).zzd(new zzbx(2, zzaeVar, publishOptions.getStrategy(), new com.google.android.gms.internal.nearby.zzbh(listenerHolder), null, null, false, zzuVar, false, null, i));
    }

    @Deprecated
    final void zzx(ListenerHolder listenerHolder, zzae zzaeVar, zzu zzuVar, PublishOptions publishOptions) throws RemoteException {
        zzw(listenerHolder, zzaeVar, zzuVar, publishOptions, this.zzf.zze);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzy(ListenerHolder listenerHolder, zzae zzaeVar) throws RemoteException {
        ((zzs) getService()).zze(new zzcc(1, zzaeVar, new com.google.android.gms.internal.nearby.zzbh(listenerHolder), null, null, false, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzz(ListenerHolder listenerHolder, ListenerHolder listenerHolder2, zzaa zzaaVar, SubscribeOptions subscribeOptions, byte[] bArr, int i) throws RemoteException {
        ListenerHolder.ListenerKey listenerKey = listenerHolder2.getListenerKey();
        if (listenerKey == null) {
            return;
        }
        com.google.android.gms.internal.nearby.zzbl zzblVar = this.zze;
        if (!zzblVar.zza(listenerKey)) {
            zzblVar.zzb(listenerKey, new com.google.android.gms.internal.nearby.zzbf(listenerHolder2));
        }
        IBinder iBinder = (IBinder) zzblVar.zzc(listenerKey);
        Strategy strategy = subscribeOptions.getStrategy();
        com.google.android.gms.internal.nearby.zzbh zzbhVar = new com.google.android.gms.internal.nearby.zzbh(listenerHolder);
        MessageFilter filter = subscribeOptions.getFilter();
        boolean z = subscribeOptions.zza;
        ((zzs) getService()).zzf(new SubscribeRequest(3, iBinder, strategy, zzbhVar, filter, null, 0, null, null, null, false, zzaaVar, false, null, false, 0, i));
    }
}
