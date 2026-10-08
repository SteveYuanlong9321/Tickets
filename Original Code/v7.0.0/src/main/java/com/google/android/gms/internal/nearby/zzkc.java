package com.google.android.gms.internal.nearby;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzkc extends BroadcastReceiver {
    final /* synthetic */ AtomicBoolean zza;
    final /* synthetic */ Context zzb;
    final /* synthetic */ zzahl zzc;
    final /* synthetic */ zzafp zzd;
    final /* synthetic */ Executor zze;

    zzkc(AtomicBoolean atomicBoolean, Context context, zzahl zzahlVar, zzafp zzafpVar, Executor executor) {
        this.zza = atomicBoolean;
        this.zzb = context;
        this.zzc = zzahlVar;
        this.zzd = zzafpVar;
        this.zze = executor;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.zza.compareAndSet(false, true)) {
            zzkf.zzg(this.zzb, this);
            this.zzc.zze(zzagn.zzf(this.zzd, this.zze));
        }
    }
}
