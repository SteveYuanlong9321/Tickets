package com.google.android.gms.nearby.internal.connection;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzeo implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzeq zza;
    private final WeakReference zzb;

    zzeo(zzeq zzeqVar, WeakReference weakReference) {
        Objects.requireNonNull(zzeqVar);
        this.zza = zzeqVar;
        this.zzb = weakReference;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (activity == this.zzb.get()) {
            zzeq zzeqVar = this.zza;
            zzeqVar.zzf(true);
            Log.d("NearbyConnections", "Activity is visible.");
            zzeqVar.zze();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (activity == this.zzb.get()) {
            zzeq zzeqVar = this.zza;
            zzeqVar.zzf(false);
            Log.d("NearbyConnections", "Activity is hidden.");
            zzeqVar.zze();
        }
    }
}
