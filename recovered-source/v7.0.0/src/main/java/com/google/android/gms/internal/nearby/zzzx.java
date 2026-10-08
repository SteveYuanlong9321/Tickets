package com.google.android.gms.internal.nearby;

import java.util.logging.Level;
import javax.annotation.Nonnull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzzx extends zzzn {
    private static final zzzw zza = new zzzw(null);

    zzzx(zzabl zzablVar) {
        super(zzablVar);
    }

    @Nonnull
    @Deprecated
    public static zzzx zzd(String str) {
        return new zzzx(zzacj.zzd("Phlogger"));
    }

    public final zzzu zze(Level level) {
        boolean zZzb = zzb(level);
        zzacj.zzh(zza(), level, zZzb);
        return !zZzb ? zza : new zzzv(this, level, false);
    }
}
