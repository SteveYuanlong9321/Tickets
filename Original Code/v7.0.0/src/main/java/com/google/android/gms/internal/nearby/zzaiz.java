package com.google.android.gms.internal.nearby;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaiz {
    static final zzaiz zza = new zzaiz(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzaiz zzd = null;
    private static volatile int zzf = 1;
    private final Map zze;

    zzaiz() {
        this.zze = new HashMap();
    }

    static boolean zza() {
        return false;
    }

    public static zzaiz zzb() {
        int i = zzahy.zza;
        return zza;
    }

    public static zzaiz zzc() {
        zzaiz zzaizVar = zzd;
        if (zzaizVar != null) {
            return zzaizVar;
        }
        synchronized (zzaiz.class) {
            zzaiz zzaizVar2 = zzd;
            if (zzaizVar2 != null) {
                return zzaizVar2;
            }
            int i = zzahy.zza;
            zzaiz zzaizVarZzb = zzajh.zzb(zzaiz.class);
            zzd = zzaizVarZzb;
            return zzaizVarZzb;
        }
    }

    public final zzajn zzd(zzaks zzaksVar, int i) {
        return (zzajn) this.zze.get(new zzaiy(zzaksVar, i));
    }

    zzaiz(boolean z) {
        this.zze = Collections.EMPTY_MAP;
    }
}
