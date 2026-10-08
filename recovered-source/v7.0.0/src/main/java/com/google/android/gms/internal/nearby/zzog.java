package com.google.android.gms.internal.nearby;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzog {
    private final AtomicReferenceArray zza = new AtomicReferenceArray(284);
    private final zzmy zzb;

    public zzog(zzmy zzmyVar, int i) {
        this.zzb = zzmyVar;
    }

    public final zzne zza(int i, String str, boolean z) {
        AtomicReferenceArray atomicReferenceArray = this.zza;
        zzne zzneVar = (zzne) atomicReferenceArray.get(128);
        if (zzneVar != null) {
            return zzneVar;
        }
        zzne zzneVarZza = this.zzb.zza("connections_enable_wifi_lan_connectivity_info_v2", false);
        if (zzog$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceArray, 128, null, zzneVarZza)) {
            return zzneVarZza;
        }
        zzne zzneVar2 = (zzne) atomicReferenceArray.get(128);
        zzneVar2.getClass();
        return zzneVar2;
    }
}
