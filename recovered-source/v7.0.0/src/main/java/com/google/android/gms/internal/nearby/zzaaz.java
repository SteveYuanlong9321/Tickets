package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaaz implements zzaai {
    private final zzaai zza;
    private final Object zzb;

    private zzaaz(zzaai zzaaiVar, Object obj) {
        zzadx.zza(zzaaiVar, "log site key");
        this.zza = zzaaiVar;
        zzadx.zza(obj, "log site qualifier");
        this.zzb = obj;
    }

    static zzaai zza(zzaai zzaaiVar, Object obj) {
        return new zzaaz(zzaaiVar, obj);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaaz)) {
            return false;
        }
        zzaaz zzaazVar = (zzaaz) obj;
        return this.zza.equals(zzaazVar.zza) && this.zzb.equals(zzaazVar.zzb);
    }

    public final int hashCode() {
        return this.zza.hashCode() ^ this.zzb.hashCode();
    }

    public final String toString() {
        String string = this.zza.toString();
        int length = string.length();
        String string2 = this.zzb.toString();
        StringBuilder sb = new StringBuilder(length + 47 + string2.length() + 3);
        sb.append("SpecializedLogSiteKey{ delegate='");
        sb.append(string);
        sb.append("', qualifier='");
        sb.append(string2);
        sb.append("' }");
        return sb.toString();
    }
}
