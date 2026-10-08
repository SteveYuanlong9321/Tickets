package com.google.android.gms.internal.nearby;

import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzuw extends zzuk implements zzuj {
    private final Exception zza;
    private final boolean zzb;

    zzuw(String str, zzuj zzujVar, zzvc zzvcVar, boolean z, zzvh zzvhVar) {
        super("<missing root>:".concat(str), zzujVar, zzvc.zza(zzvcVar, zzvb.zzb), zzvhVar);
        this.zza = zzujVar.zzf();
        this.zzb = z;
    }

    @Override // com.google.android.gms.internal.nearby.zzuj
    public final Exception zzf() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzuj
    public final zzvj zzg(String str, zzvc zzvcVar, boolean z, zzvh zzvhVar) {
        if (z && !this.zzb) {
            int i = zzup.zzb;
        }
        boolean z2 = true;
        if ((!z || this.zzb) && !this.zzb) {
            z2 = false;
        }
        return new zzuw(str, this, zzvcVar, z2, zzvhVar);
    }

    @Override // com.google.android.gms.internal.nearby.zzvj
    public final zzvj zzj(String str, String str2, String str3, int i, zzvc zzvcVar, zzvh zzvhVar) {
        int i2 = zzup.zzb;
        return zzg(str, zzvcVar, true, zzvhVar);
    }

    @Override // com.google.android.gms.internal.nearby.zzvj
    public final long zzk() {
        return -1L;
    }

    @Override // com.google.android.gms.internal.nearby.zzvj
    public final zzvc zzl() {
        return zzvb.zza;
    }

    zzuw(UUID uuid, String str, String str2, zzvc zzvcVar, Exception exc, boolean z, boolean z2, zzvh zzvhVar) {
        super("<missing root>:".concat(str2), uuid, str, zzvc.zza(zzvcVar, zzvb.zzb), zzvhVar);
        this.zza = exc;
        this.zzb = false;
    }
}
