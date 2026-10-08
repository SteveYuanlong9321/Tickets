package com.google.android.gms.internal.nearby;

import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzacy extends zzacm {
    public static final /* synthetic */ int zza = 0;
    private static final Set zzb;
    private static final zzabw zzc;
    private static final zzacw zzd;
    private final String zze;
    private final Level zzf;
    private final Set zzg;
    private final zzabw zzh;
    private final int zzi;

    static {
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(zzaac.zza, zzabc.zza, zzabd.zza)));
        zzb = setUnmodifiableSet;
        zzc = zzabz.zza(setUnmodifiableSet).zzc();
        zzd = new zzacw(null);
    }

    /* synthetic */ zzacy(String str, String str2, boolean z, int i, Level level, Set set, zzabw zzabwVar, byte[] bArr) {
        super(str2);
        this.zze = zzacr.zza("", str2, true);
        this.zzi = 2;
        this.zzf = level;
        this.zzg = set;
        this.zzh = zzabwVar;
    }

    public static zzacw zze() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x005b  */
    /* JADX WARN: Code duplicated, block: B:23:0x006a  */
    /* JADX WARN: Code duplicated, block: B:28:0x0088  */
    public static void zzi(zzabj zzabjVar, String str, int i, Level level, Set set, zzabw zzabwVar) {
        StringBuilder sb;
        String string;
        Boolean bool = (Boolean) zzabjVar.zzl().zzd(zzabd.zza);
        if (bool == null || !bool.booleanValue()) {
            zzacg zzacgVarZzh = zzacg.zzh(zzacj.zzj(), zzabjVar.zzl());
            boolean z = zzabjVar.zze().intValue() < level.intValue();
            if (z) {
                sb = new StringBuilder();
                if (zzabk.zza(2, zzabjVar.zzg(), sb)) {
                    sb.append(" ");
                }
                if (z) {
                    zzabe.zza(zzabjVar, sb);
                    int i2 = zzack.zza;
                    zzabi zzabiVar = new zzabi("[CONTEXT ", " ]", sb);
                    zzacgVarZzh.zza(zzabwVar, zzabiVar);
                    zzabiVar.zzb();
                } else {
                    zzabe.zza(zzabjVar, sb);
                    int i3 = zzack.zza;
                    zzabi zzabiVar2 = new zzabi("[CONTEXT ", " ]", sb);
                    zzacgVarZzh.zza(zzabwVar, zzabiVar2);
                    zzabiVar2.zzb();
                }
                string = sb.toString();
            } else {
                int i4 = zzack.zza;
                if (zzabjVar.zzh() == null && zzacgVarZzh.zzb() <= set.size() && set.containsAll(zzacgVarZzh.zzc())) {
                    string = zzabn.zza(zzabjVar.zzj());
                } else {
                    sb = new StringBuilder();
                    if (zzabk.zza(2, zzabjVar.zzg(), sb)) {
                        sb.append(" ");
                    }
                    if (z || zzabjVar.zzh() == null) {
                        zzabe.zza(zzabjVar, sb);
                        int i5 = zzack.zza;
                        zzabi zzabiVar3 = new zzabi("[CONTEXT ", " ]", sb);
                        zzacgVarZzh.zza(zzabwVar, zzabiVar3);
                        zzabiVar3.zzb();
                    } else {
                        sb.append("(REDACTED) ");
                        sb.append(zzabjVar.zzh().zzb());
                    }
                    string = sb.toString();
                }
            }
            Throwable th = (Throwable) zzabjVar.zzl().zzd(zzaac.zza);
            int iZzb = zzacr.zzb(zzabjVar.zze());
            if (iZzb == 2) {
                Log.v(str, string, th);
                return;
            }
            if (iZzb == 3) {
                Log.d(str, string, th);
                return;
            }
            if (iZzb == 4) {
                Log.i(str, string, th);
            } else if (iZzb != 5) {
                Log.e(str, string, th);
            } else {
                Log.w(str, string, th);
            }
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzabl
    public final boolean zzb(Level level) {
        String str = this.zze;
        int iZzb = zzacr.zzb(level);
        return Log.isLoggable(str, iZzb) || Log.isLoggable("all", iZzb);
    }

    @Override // com.google.android.gms.internal.nearby.zzabl
    public final void zzc(zzabj zzabjVar) {
        zzi(zzabjVar, this.zze, 2, this.zzf, this.zzg, this.zzh);
    }
}
