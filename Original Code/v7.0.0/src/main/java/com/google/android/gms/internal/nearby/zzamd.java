package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzamd {
    public static final /* synthetic */ int zza = 0;
    private static final zznz zzb;
    private static final zzmy zzc;

    static {
        zzob zzobVar = new zzob(zzamc.zza);
        zzobVar.zza(zzyl.zzj("COPRESENCE", "COPRESENCE_NO_IDS", "NEARBY", "NEARBY_EXPOSURE_NOTIFICATION", "FAST_PAIR"));
        zzobVar.zzb();
        zznz zznzVarZzc = zzobVar.zzc();
        zzb = zznzVarZzc;
        zzc = new zzmy("com.google.android.gms.nearby", zznzVarZzc);
    }

    public static zzmy zza() {
        return zzc;
    }
}
