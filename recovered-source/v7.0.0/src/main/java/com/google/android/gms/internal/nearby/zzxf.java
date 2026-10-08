package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzxf extends zzxi {
    final /* synthetic */ zzww zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzxf(zzxj zzxjVar, CharSequence charSequence, zzww zzwwVar) {
        super(zzxjVar, charSequence);
        this.zza = zzwwVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzxi
    final int zzc(int i) {
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzxd.zzj(i, length, "index");
        while (i < length) {
            if (this.zza.zza(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.nearby.zzxi
    final int zzd(int i) {
        return i + 1;
    }
}
