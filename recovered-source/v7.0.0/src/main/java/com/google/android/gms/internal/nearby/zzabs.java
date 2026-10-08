package com.google.android.gms.internal.nearby;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzabs {
    private static final zzabv zza = new zzabq();
    private static final zzabu zzb = new zzabr();
    private final zzabv zze;
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private zzabu zzf = null;

    public final zzabs zza(zzabu zzabuVar) {
        this.zzf = zzabuVar;
        return this;
    }

    final void zzb(zzaaq zzaaqVar) {
        zzadx.zza(zzaaqVar, "key");
        if (!zzaaqVar.zzf()) {
            zzabv zzabvVar = zza;
            zzadx.zza(zzaaqVar, "key");
            this.zzd.remove(zzaaqVar);
            this.zzc.put(zzaaqVar, zzabvVar);
            return;
        }
        zzabu zzabuVar = zzb;
        zzadx.zza(zzaaqVar, "key");
        zzadx.zzb(zzaaqVar.zzf(), "key must be repeating");
        this.zzc.remove(zzaaqVar);
        this.zzd.put(zzaaqVar, zzabuVar);
    }

    public final zzabw zzc() {
        return new zzabt(this, null);
    }

    final /* synthetic */ Map zzd() {
        return this.zzc;
    }

    final /* synthetic */ Map zze() {
        return this.zzd;
    }

    final /* synthetic */ zzabv zzf() {
        return this.zze;
    }

    final /* synthetic */ zzabu zzg() {
        return this.zzf;
    }
}
