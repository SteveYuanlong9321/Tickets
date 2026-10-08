package com.google.android.gms.internal.nearby;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzua extends zzafb {
    private zzuc zza;
    private final int zzb;

    /* synthetic */ zzua(zzuc zzucVar, int i, byte[] bArr) {
        this.zza = zzucVar;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.nearby.zzafb
    protected final void zzc() {
        zzub zzubVar;
        zzuc zzucVar = this.zza;
        this.zza = null;
        if (zzucVar != null && zzucVar.zze()) {
            do {
                zzubVar = (zzub) zzucVar.zzg().get();
                if (zzubVar == null) {
                    return;
                }
                if (zzubVar.zzf() > this.zzb) {
                    return;
                } else {
                    zzubVar.cancel(true);
                }
            } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(zzucVar.zzg(), zzubVar, null));
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzafb
    protected final String zzd() {
        zzafp zzafpVarZza;
        zzuc zzucVar = this.zza;
        if (zzucVar == null || (zzafpVarZza = zzucVar.zzf().zza()) == null) {
            return null;
        }
        String string = zzafpVarZza.toString();
        StringBuilder sb = new StringBuilder(string.length() + 11);
        sb.append("callable=[");
        sb.append(string);
        sb.append("]");
        String string2 = sb.toString();
        zzub zzubVar = (zzub) this.zza.zzg().get();
        if (zzubVar == null) {
            return string2;
        }
        int length = string2.length();
        String string3 = zzubVar.toString();
        StringBuilder sb2 = new StringBuilder(length + 9 + string3.length() + 1);
        sb2.append(string2);
        sb2.append(", trial=[");
        sb2.append(string3);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzafb
    protected final boolean zze(zzagx zzagxVar) {
        return super.zze(zzagxVar);
    }
}
