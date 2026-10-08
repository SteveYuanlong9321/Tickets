package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzom {
    public static final /* synthetic */ int zza = 0;
    private static final zztr zzb = new zztr(zzms.zzb());
    private static final Object zzc = new Object();
    private static volatile zzsj zzd = null;

    static zzagx zza(zzkp zzkpVar, final String str, String str2) {
        zzsg zzsgVarZzh = zzsh.zzh();
        zzqt zzqtVarZza = zzqu.zza(zzkpVar.zzb());
        zzqtVarZza.zza("phenotype");
        zzqtVarZza.zzb("all_accounts.pb");
        zzsgVarZzh.zza(zzqtVarZza.zzc());
        zzsgVarZzh.zzb(zzms.zzb());
        zzsgVarZzh.zzc(zzb);
        zzsgVarZzh.zzf(false);
        zzsh zzshVarZzg = zzsgVarZzh.zzg();
        zzsj zzsjVarZzd = zzd;
        if (zzsjVarZzd == null) {
            synchronized (zzc) {
                zzsjVarZzd = zzd;
                if (zzsjVarZzd == null) {
                    zzsk zzskVar = new zzsk();
                    zzskVar.zza(zzkpVar.zzf());
                    zzskVar.zzb(zzkpVar.zzh());
                    zzskVar.zzc(zzsy.zza());
                    zzsjVarZzd = zzskVar.zzd();
                    zzd = zzsjVarZzd;
                }
            }
        }
        final String str3 = "";
        return zzsjVarZzd.zza(zzshVarZzg).zzb(new zzwx(str, str3) { // from class: com.google.android.gms.internal.nearby.zzol
            private final /* synthetic */ String zza;

            @Override // com.google.android.gms.internal.nearby.zzwx
            public final /* synthetic */ Object zza(Object obj) {
                zzms zzmsVar = (zzms) obj;
                int i = zzom.zza;
                String str4 = this.zza;
                zzmp zzmpVar = (zzmp) zzmsVar.zza(str4, zzmq.zzb()).zzH();
                if (!zzmpVar.zza().contains("")) {
                    zzmpVar.zzb("");
                }
                zzmr zzmrVar = (zzmr) zzmsVar.zzH();
                zzmpVar.zzc("");
                zzmrVar.zza(str4, (zzmq) zzmpVar.zzn());
                return (zzms) zzmrVar.zzn();
            }
        }, zzkpVar.zzf());
    }
}
