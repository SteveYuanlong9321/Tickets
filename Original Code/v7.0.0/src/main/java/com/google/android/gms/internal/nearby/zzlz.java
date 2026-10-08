package com.google.android.gms.internal.nearby;

import java.io.File;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzlz {
    private final zzaet zza = zzaet.zzj();
    private final zzxn zzb;
    private final zzxn zzc;

    public zzlz(final zzaik zzaikVar, final String str, String str2) {
        this.zzb = zzxr.zza(new zzxn() { // from class: com.google.android.gms.internal.nearby.zzly
            @Override // com.google.android.gms.internal.nearby.zzxn
            public final /* synthetic */ Object zzbh() {
                return this.zza.zzb(zzaikVar);
            }
        });
        final String str3 = "";
        this.zzc = zzxr.zza(new zzxn(str, str3) { // from class: com.google.android.gms.internal.nearby.zzlx
            private final /* synthetic */ String zzb;
            private final /* synthetic */ String zzc = "";

            @Override // com.google.android.gms.internal.nearby.zzxn
            public final /* synthetic */ Object zzbh() {
                return this.zza.zzc(this.zzb, this.zzc);
            }
        });
    }

    public final File zza() {
        String str = (String) this.zzb.zzbh();
        String str2 = (String) this.zzc.zzbh();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length() + 3);
        sb.append(str);
        sb.append("/");
        sb.append(str2);
        sb.append(".pb");
        return new File(sb.toString());
    }

    final /* synthetic */ String zzb(zzaik zzaikVar) {
        byte[] bArrZzm = zzaikVar.zzm();
        return this.zza.zzh(bArrZzm, 0, bArrZzm.length);
    }

    final /* synthetic */ String zzc(String str, String str2) {
        zzaei zzaeiVarZza = zzaej.zza().zza().zza(str.getBytes());
        zzaeiVarZza.zze((byte) 0);
        byte[] bArrZzb = zzaeiVarZza.zza("".getBytes()).zzf().zzb();
        return this.zza.zzh(bArrZzb, 0, bArrZzb.length);
    }
}
