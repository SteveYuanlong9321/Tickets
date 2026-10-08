package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzbs implements RemoteCall {
    static final /* synthetic */ zzbs zza = new zzbs();

    private /* synthetic */ zzbs() {
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) {
        int i = zzch.zza;
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
