package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzabk {
    public static /* synthetic */ boolean zza(int i, zzaah zzaahVar, StringBuilder sb) {
        if (i - 1 != 0 || zzaahVar == zzaah.zza) {
            return false;
        }
        sb.append(zzaahVar.zza());
        sb.append('.');
        sb.append(zzaahVar.zzb());
        sb.append(':');
        sb.append(zzaahVar.zzc());
        return true;
    }
}
