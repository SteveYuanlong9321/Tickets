package com.google.android.gms.internal.nearby;

import java.util.concurrent.Executors;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzku implements zzxn {
    static final /* synthetic */ zzku zza = new zzku();

    private /* synthetic */ zzku() {
    }

    @Override // com.google.android.gms.internal.nearby.zzxn
    public final /* synthetic */ Object zzbh() {
        int i = zzkp.zza;
        return zzahg.zzc(Executors.newSingleThreadScheduledExecutor(zzkt.zza));
    }
}
