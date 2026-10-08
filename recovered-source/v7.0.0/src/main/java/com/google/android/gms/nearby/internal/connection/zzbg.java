package com.google.android.gms.nearby.internal.connection;

import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzbg implements OnFailureListener {
    static final /* synthetic */ zzbg zza = new zzbg();

    private /* synthetic */ zzbg() {
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final /* synthetic */ void onFailure(Exception exc) {
        int i = zzch.zza;
        Log.w("NearbyConnections", "Failed to start discovery.", exc);
    }
}
