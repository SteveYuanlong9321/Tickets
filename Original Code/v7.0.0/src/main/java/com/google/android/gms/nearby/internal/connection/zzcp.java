package com.google.android.gms.nearby.internal.connection;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcp extends zzdf {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ byte[] zzc;
    final /* synthetic */ ListenerHolder zzd;
    final /* synthetic */ ListenerHolder zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcp(zzdg zzdgVar, GoogleApiClient googleApiClient, String str, String str2, byte[] bArr, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        super(googleApiClient, null);
        this.zza = str;
        this.zzb = str2;
        this.zzc = bArr;
        this.zzd = listenerHolder;
        this.zze = listenerHolder2;
        Objects.requireNonNull(zzdgVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzaw zzawVar = (zzaw) anyClient;
        zzee zzeeVar = (zzee) zzawVar.getService();
        zzhc zzhcVar = new zzhc();
        zzhcVar.zza(new zzat(this));
        zzhcVar.zzd(this.zza);
        zzhcVar.zze(this.zzb);
        zzhcVar.zzf(this.zzc);
        zzhcVar.zzb(new zzam(zzawVar.getContext(), this.zze));
        zzhcVar.zzc(new zzz(this.zzd));
        zzeeVar.zzh(zzhcVar.zzj());
    }
}
