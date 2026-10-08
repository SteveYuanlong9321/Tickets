package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.UwbAvailabilityObserver;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgq extends zzdx {
    private final UwbAvailabilityObserver zza;

    zzgq(zzhq zzhqVar, UwbAvailabilityObserver uwbAvailabilityObserver) {
        Objects.requireNonNull(zzhqVar);
        zzhqVar.registerListener(uwbAvailabilityObserver, UwbAvailabilityObserver.class.getName());
        this.zza = uwbAvailabilityObserver;
    }

    final /* synthetic */ UwbAvailabilityObserver zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzdy
    public final void zzd(boolean z, int i) {
        this.zza.onUwbStateChanged(z, i);
    }
}
