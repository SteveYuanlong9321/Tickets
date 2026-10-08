package com.google.android.gms.internal.nearby;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzacm extends zzabl {
    private final String zza;

    protected zzacm(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.nearby.zzabl
    public String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzabl
    public void zzd(RuntimeException runtimeException, zzabj zzabjVar) {
        Log.e("AbstractAndroidBackend", "Internal logging error", runtimeException);
    }
}
