package com.google.android.gms.internal.nearby;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzacv extends zzacz {
    private static final zzacv zza = new zzacv(zzacz.zze());
    private final AtomicReference zzb;

    zzacv(zzacz zzaczVar) {
        this.zzb = new AtomicReference(zzaczVar);
    }

    public static final zzacv zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzacz
    public final boolean zzb(String str, Level level, boolean z) {
        ((zzacz) this.zzb.get()).zzb(str, level, z);
        return false;
    }

    @Override // com.google.android.gms.internal.nearby.zzacz
    public final zzadk zzc() {
        return ((zzacz) this.zzb.get()).zzc();
    }

    @Override // com.google.android.gms.internal.nearby.zzacz
    public final zzabp zzd() {
        return ((zzacz) this.zzb.get()).zzd();
    }
}
