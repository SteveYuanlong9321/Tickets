package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzpi implements zzwx {
    static final /* synthetic */ zzpi zza = new zzpi();

    private /* synthetic */ zzpi() {
    }

    @Override // com.google.android.gms.internal.nearby.zzwx
    public final /* synthetic */ Object zza(Object obj) {
        zzlg zzlgVar = (zzlg) obj;
        zzpn zzpnVarZzi = zzpo.zzi();
        if (zzlgVar == null) {
            return (zzpo) zzpnVarZzi.zzn();
        }
        for (zzli zzliVar : zzlgVar.zzf()) {
            zzpp zzppVarZzh = zzpq.zzh();
            zzppVarZzh.zza(zzliVar.zza());
            int iZzq = zzliVar.zzq();
            int i = iZzq - 1;
            if (iZzq == 0) {
                throw null;
            }
            if (i == 0) {
                zzppVarZzh.zzb(zzliVar.zzb());
            } else if (i == 1) {
                zzppVarZzh.zzc(zzliVar.zzd());
            } else if (i == 2) {
                zzppVarZzh.zzd(zzliVar.zze());
            } else if (i == 3) {
                zzppVarZzh.zze(zzliVar.zzf());
            } else {
                if (i != 4) {
                    throw new IllegalStateException("No known flag type");
                }
                zzppVarZzh.zzf(zzliVar.zzg());
            }
            zzpnVarZzi.zze((zzpq) zzppVarZzh.zzn());
        }
        zzpnVarZzi.zzc(zzlgVar.zze());
        zzpnVarZzi.zza(zzlgVar.zza());
        zzpnVarZzi.zzd(zzlgVar.zzg());
        if (zzlgVar.zzb()) {
            zzpnVarZzi.zzb(zzlgVar.zzd());
        }
        return (zzpo) zzpnVarZzi.zzn();
    }
}
