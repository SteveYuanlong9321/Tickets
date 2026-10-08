package com.google.android.gms.internal.nearby;

import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzux extends zzuk {
    public static final zzux zza = new zzux(UUID.randomUUID());

    private zzux(UUID uuid) {
        super("<skip trace>", uuid, zzud.zzbj(uuid), zzvb.zza, zzup.zzd());
    }

    @Override // com.google.android.gms.internal.nearby.zzvj
    public final zzvj zzj(String str, String str2, String str3, int i, zzvc zzvcVar, zzvh zzvhVar) {
        throw new IllegalStateException("Can't create child trace for no trace!");
    }

    @Override // com.google.android.gms.internal.nearby.zzvj
    public final long zzk() {
        return -1L;
    }

    @Override // com.google.android.gms.internal.nearby.zzvj
    public final zzvc zzl() {
        return zzvb.zza;
    }
}
