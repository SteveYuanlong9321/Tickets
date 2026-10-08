package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzacl {
    private final zzadt zza;
    private final String zzb;

    public zzacl(zzadt zzadtVar, String str) {
        zzadx.zza(zzadtVar, "parser");
        this.zza = zzadtVar;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzacl) {
            zzacl zzaclVar = (zzacl) obj;
            if (this.zza.equals(zzaclVar.zza) && this.zzb.equals(zzaclVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() ^ this.zzb.hashCode();
    }

    public final zzadt zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
