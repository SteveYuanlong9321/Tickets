package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaiy {
    private final Object zza;
    private final int zzb;

    zzaiy(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaiy)) {
            return false;
        }
        zzaiy zzaiyVar = (zzaiy) obj;
        return this.zza == zzaiyVar.zza && this.zzb == zzaiyVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
