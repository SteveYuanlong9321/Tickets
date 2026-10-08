package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzaav {
    public static final zzaav zzc = new zzaar();
    public static final zzaav zzd = new zzaar();

    protected zzaav() {
    }

    static zzaav zzc(zzaav zzaavVar, zzaav zzaavVar2) {
        zzaav zzaavVar3;
        zzaav zzaavVar4;
        if (zzaavVar != null) {
            if (zzaavVar2 == null || zzaavVar == (zzaavVar3 = zzc) || zzaavVar2 == (zzaavVar4 = zzd)) {
                return zzaavVar;
            }
            if (zzaavVar2 != zzaavVar3 && zzaavVar != zzaavVar4) {
                return new zzaas(zzaavVar, zzaavVar2);
            }
        }
        return zzaavVar2;
    }

    protected abstract void zzb();
}
