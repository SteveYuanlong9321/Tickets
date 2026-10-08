package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.nearby.fastpair.FastPairClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzag extends GoogleApi implements FastPairClient {
    private static final Api zza = new Api("Nearby.FAST_PAIR", new zzab(), new Api.ClientKey());

    public zzag(Context context) {
        super(context, (Api<Api.ApiOptions>) zza, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Override // com.google.android.gms.nearby.fastpair.FastPairClient
    public final Task<Boolean> isSassDeviceAvailable(final int i) {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzaf
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                zzac zzacVar = new zzac(this.zza, (TaskCompletionSource) obj2);
                zzak zzakVar = (zzak) ((zzaa) obj).getService();
                zzal zzalVar = new zzal();
                zzalVar.zza(i);
                zzalVar.zzb(zzacVar);
                zzakVar.zzd(zzalVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zze).setMethodKey(1340).build());
    }

    @Override // com.google.android.gms.nearby.fastpair.FastPairClient
    public final Task<Boolean> triggerSassForUsage(final int i) {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzae
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                zzad zzadVar = new zzad(this.zza, (TaskCompletionSource) obj2);
                zzak zzakVar = (zzak) ((zzaa) obj).getService();
                zzao zzaoVar = new zzao();
                zzaoVar.zza(i);
                zzaoVar.zzb(zzadVar);
                zzakVar.zze(zzaoVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zze).setMethodKey(1341).build());
    }
}
