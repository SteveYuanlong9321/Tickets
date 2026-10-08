package com.google.android.gms.nearby.fastpair;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public interface FastPairClient extends HasApiKey<Api.ApiOptions.NoOptions> {
    Task<Boolean> isSassDeviceAvailable(int i);

    Task<Boolean> triggerSassForUsage(int i);
}
