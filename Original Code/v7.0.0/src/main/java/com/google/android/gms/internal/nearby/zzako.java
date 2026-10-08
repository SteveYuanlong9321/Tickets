package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzako {
    zzako() {
    }

    public static final boolean zza(Object obj) {
        return !((zzakn) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzakn zzaknVarZzc = (zzakn) obj;
        zzakn zzaknVar = (zzakn) obj2;
        if (!zzaknVar.isEmpty()) {
            if (!zzaknVarZzc.zze()) {
                zzaknVarZzc = zzaknVarZzc.zzc();
            }
            zzaknVarZzc.zzb(zzaknVar);
        }
        return zzaknVarZzc;
    }
}
