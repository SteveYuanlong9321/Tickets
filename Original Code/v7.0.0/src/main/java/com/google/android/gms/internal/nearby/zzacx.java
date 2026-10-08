package com.google.android.gms.internal.nearby;

import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzacx extends zzacm {
    private final String zza;
    private final Level zzb;
    private final Set zzc;
    private final zzabw zzd;
    private final int zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzacx(String str, String str2, boolean z, int i, boolean z2, boolean z3) {
        super(str2);
        Level level = Level.ALL;
        int i2 = zzacy.zza;
        this.zza = "";
        this.zze = 2;
        this.zzb = level;
        this.zzc = zzacy.zzb;
        this.zzd = zzacy.zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zzabl
    public final boolean zzb(Level level) {
        return true;
    }

    @Override // com.google.android.gms.internal.nearby.zzabl
    public final void zzc(zzabj zzabjVar) {
        String strZza = (String) zzabjVar.zzl().zzd(zzabc.zza);
        if (strZza == null) {
            strZza = zza();
        }
        if (strZza == null) {
            strZza = zzabjVar.zzg().zza();
            int iIndexOf = strZza.indexOf(36, strZza.lastIndexOf(46));
            if (iIndexOf >= 0) {
                strZza = strZza.substring(0, iIndexOf);
            }
        }
        String str = this.zza;
        zzacy.zzi(zzabjVar, zzacr.zza(str, strZza, true), 2, this.zzb, this.zzc, this.zzd);
    }
}
