package com.google.android.gms.internal.nearby;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzafw extends zzafk {
    private zzafv zza;

    zzafw(zzyb zzybVar, boolean z, Executor executor, zzafp zzafpVar) {
        super(zzybVar, z, false);
        this.zza = new zzaft(this, zzafpVar, executor);
        zzf();
    }

    @Override // com.google.android.gms.internal.nearby.zzafk
    final void zzA(int i) {
        super.zzA(i);
        if (i == 1) {
            this.zza = null;
        }
    }

    final /* synthetic */ void zzD(zzafv zzafvVar) {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.nearby.zzafb
    protected final void zzj() {
        zzafv zzafvVar = this.zza;
        if (zzafvVar != null) {
            zzafvVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzafk
    final void zzx() {
        zzafv zzafvVar = this.zza;
        if (zzafvVar != null) {
            zzafvVar.zze();
        }
    }

    zzafw(zzyb zzybVar, boolean z, Executor executor, Callable callable) {
        super(zzybVar, z, false);
        this.zza = new zzafu(this, callable, executor);
        zzf();
    }
}
