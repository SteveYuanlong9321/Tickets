package com.google.android.gms.internal.nearby;

import java.util.UUID;
import java.util.function.Consumer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzuu extends zzud implements zzuj {
    static final zzuh zza = new zzui();
    public static final /* synthetic */ int zzb = 0;
    private final Exception zzc;

    private zzuu(UUID uuid, String str, Exception exc, boolean z, zzvh zzvhVar) {
        super("<missing root>", uuid, str, zzvhVar);
        this.zzc = exc;
    }

    public static zzuu zzi(zzvh zzvhVar) {
        final UUID uuidZzc = zzuq.zza().zzc();
        String strZzbj = zzud.zzbj(uuidZzc);
        zzyl zzylVarZza = zzup.zza();
        if (!zzylVarZza.isEmpty()) {
            final Exception exc = null;
            zzylVarZza.forEach(new Consumer(uuidZzc, exc) { // from class: com.google.android.gms.internal.nearby.zzut
                @Override // java.util.function.Consumer
                public final /* synthetic */ void accept(Object obj) {
                    int i = zzuu.zzb;
                    ((zzvl) obj).zza();
                }
            });
        }
        return new zzuu(uuidZzc, strZzbj, zza, false, zzvhVar);
    }

    @Override // com.google.android.gms.internal.nearby.zzuj
    public final Exception zzf() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zzuj
    public final zzvj zzg(String str, zzvc zzvcVar, boolean z, zzvh zzvhVar) {
        if (z) {
            int i = zzup.zzb;
        }
        return new zzuw(str, this, zzvcVar, z, zzvhVar);
    }

    @Override // com.google.android.gms.internal.nearby.zzvj
    public final zzvc zzh() {
        return zzvb.zza;
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
        throw null;
    }
}
