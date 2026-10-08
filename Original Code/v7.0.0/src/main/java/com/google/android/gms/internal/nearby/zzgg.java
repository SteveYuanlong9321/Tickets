package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgg extends GmsClient {
    private final com.google.android.gms.nearby.uwb.zzc zze;

    public zzgg(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings, com.google.android.gms.nearby.uwb.zzc zzcVar) {
        super(context, looper, 298, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zze = zzcVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.uwb.internal.INearbyUwbService");
        return iInterfaceQueryLocalInterface instanceof zzdj ? (zzdj) iInterfaceQueryLocalInterface : new zzdi(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        if (isConnected()) {
            try {
                ((zzdj) getService()).zzj(new zzcs());
            } catch (RemoteException e) {
                Log.w("NearbyUwbClient", "Failed to notify client disconnect.", e);
            }
        }
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return new Feature[]{com.google.android.gms.nearby.zza.zzA, com.google.android.gms.nearby.zza.zzB, com.google.android.gms.nearby.zza.zzC, com.google.android.gms.nearby.zza.zzD, com.google.android.gms.nearby.zza.zzE, com.google.android.gms.nearby.zza.zzG, com.google.android.gms.nearby.zza.zzF, com.google.android.gms.nearby.zza.zzH};
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        com.google.android.gms.nearby.uwb.zzc zzcVar = this.zze;
        if (zzcVar != null) {
            bundle.putLong("clientId", zzcVar.hashCode());
            bundle.putInt("deviceType", zzcVar.zza());
            bundle.putBoolean("isTestOnly", false);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 211600000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.uwb.internal.INearbyUwbService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.nearby.uwb.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final boolean getUseDynamicLookup() {
        return true;
    }
}
