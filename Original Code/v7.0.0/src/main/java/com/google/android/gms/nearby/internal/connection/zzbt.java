package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzbt implements RemoteCall {
    static final /* synthetic */ zzbt zza = new zzbt();

    private /* synthetic */ zzbt() {
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) {
        int i = zzch.zza;
        ((TaskCompletionSource) obj2).setResult(true);
    }
}
