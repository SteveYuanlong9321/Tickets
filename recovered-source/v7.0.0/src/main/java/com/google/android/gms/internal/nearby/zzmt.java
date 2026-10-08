package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzmt extends zzpg {
    private final zzmc zza;
    private final zzpk zzb;

    zzmt(zzmc zzmcVar, zzpk zzpkVar) {
        this.zza = zzmcVar;
        this.zzb = zzpkVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzpg) {
            zzpg zzpgVar = (zzpg) obj;
            zzmc zzmcVar = this.zza;
            if (zzmcVar != null ? zzmcVar.equals(zzpgVar.zza()) : zzpgVar.zza() == null) {
                if (this.zzb.equals(zzpgVar.zzb())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        zzpk zzpkVar = this.zzb;
        String strValueOf = String.valueOf(this.zza);
        String string = zzpkVar.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 52 + string.length() + 1);
        sb.append("SnapshotBlobAndResult{snapshotBlob=");
        sb.append(strValueOf);
        sb.append(", snapshotResult=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzpg
    final zzmc zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzpg
    final zzpk zzb() {
        return this.zzb;
    }

    public final int hashCode() {
        zzmc zzmcVar = this.zza;
        return this.zzb.hashCode() ^ (((zzmcVar == null ? 0 : zzmcVar.hashCode()) ^ 1000003) * 1000003);
    }
}
