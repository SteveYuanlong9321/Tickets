package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzagm extends zzafb.zzf implements Runnable {
    private zzagx zza;

    zzagm(zzagx zzagxVar) {
        this.zza = zzagxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzagx zzagxVar = this.zza;
        if (zzagxVar != null) {
            zze(zzagxVar);
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzafb
    protected final void zzc() {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.nearby.zzafb
    protected final String zzd() {
        zzagx zzagxVar = this.zza;
        if (zzagxVar == null) {
            return null;
        }
        String string = zzagxVar.toString();
        StringBuilder sb = new StringBuilder(string.length() + 11);
        sb.append("delegate=[");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }
}
