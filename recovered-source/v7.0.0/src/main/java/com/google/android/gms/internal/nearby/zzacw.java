package com.google.android.gms.internal.nearby;

import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzacw implements zzaco {
    private final String zza;
    private final Level zzb;
    private final Set zzc;
    private final zzabw zzd;
    private final int zze;

    private zzacw() {
        this("", true, 2, Level.ALL, false, zzacy.zzb, zzacy.zzc);
    }

    private zzacw(String str, boolean z, int i, Level level, boolean z2, Set set, zzabw zzabwVar) {
        this.zza = "";
        this.zze = 2;
        this.zzb = level;
        this.zzc = set;
        this.zzd = zzabwVar;
    }

    /* synthetic */ zzacw(byte[] bArr) {
        this("", true, 2, Level.ALL, false, zzacy.zzb, zzacy.zzc);
    }

    @Override // com.google.android.gms.internal.nearby.zzaco
    public final zzabl zza(String str) {
        return new zzacy(this.zza, str, true, 2, this.zzb, this.zzc, this.zzd, null);
    }

    public final zzacw zzb(boolean z) {
        Set set = this.zzc;
        zzabw zzabwVar = this.zzd;
        return new zzacw(this.zza, true, 2, Level.OFF, false, set, zzabwVar);
    }
}
