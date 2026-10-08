package com.google.android.gms.nearby.internal.connection;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.Strategy;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcw extends zzde {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ ListenerHolder zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcw(zzdg zzdgVar, GoogleApiClient googleApiClient, String str, long j, ListenerHolder listenerHolder) {
        super(googleApiClient, null);
        this.zza = str;
        this.zzb = j;
        this.zzc = listenerHolder;
        Objects.requireNonNull(zzdgVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzd zzdVar = new zzd();
        zzdVar.zza(Strategy.P2P_CLUSTER);
        zze zzeVarZzL = zzdVar.zzL();
        zzee zzeeVar = (zzee) ((zzaw) anyClient).getService();
        zzhi zzhiVar = new zzhi();
        zzhiVar.zza(new zzav(this));
        zzhiVar.zzc(this.zza);
        zzhiVar.zzd("__LEGACY_SERVICE_ID__");
        zzhiVar.zze(this.zzb);
        zzhiVar.zzb(new zzx(this.zzc));
        zzhiVar.zzf(zzeVarZzL);
        zzeeVar.zzd(zzhiVar.zzi());
    }
}
