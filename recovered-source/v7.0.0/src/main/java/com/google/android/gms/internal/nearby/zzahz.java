package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzahz {
    public int zza;
    public long zzb;
    public Object zzc;
    public final zzaiz zzd;
    public int zze;

    zzahz() {
        int i = zzaiz.zzb;
        int i2 = zzahy.zza;
        this.zzd = zzaiz.zza;
    }

    static /* synthetic */ String zza(int i, int i2, byte b, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + b + String.valueOf(i).length());
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i);
        return sb.toString();
    }

    zzahz(zzaiz zzaizVar) {
        zzaizVar.getClass();
        this.zzd = zzaizVar;
    }
}
