package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzaah implements zzaai {
    public static final zzaah zza = new zzaaf();

    public final String toString() {
        StringBuilder sb = new StringBuilder("LogSite{ class=");
        sb.append(zza());
        sb.append(", method=");
        sb.append(zzb());
        sb.append(", line=");
        sb.append(zzc());
        if (zzd() != null) {
            sb.append(", file=");
            sb.append(zzd());
        }
        if (zze() != null) {
            sb.append(", filePath=");
            sb.append(zze());
        }
        sb.append(" }");
        return sb.toString();
    }

    public abstract String zza();

    public abstract String zzb();

    public abstract int zzc();

    public abstract String zzd();

    public String zze() {
        return null;
    }
}
