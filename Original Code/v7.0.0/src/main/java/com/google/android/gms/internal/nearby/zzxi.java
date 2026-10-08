package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzxi extends zzwq {
    final CharSequence zzb;
    final boolean zzc;
    int zzd = 0;
    int zze = Integer.MAX_VALUE;

    zzxi(zzxj zzxjVar, CharSequence charSequence) {
        this.zzc = zzxjVar.zze();
        this.zzb = charSequence;
    }

    @Override // com.google.android.gms.internal.nearby.zzwq
    protected final /* bridge */ /* synthetic */ Object zza() {
        int iZzd;
        int i = this.zzd;
        while (true) {
            int i2 = this.zzd;
            if (i2 == -1) {
                zzb();
                return null;
            }
            int iZzc = zzc(i2);
            if (iZzc == -1) {
                iZzc = this.zzb.length();
                this.zzd = -1;
                iZzd = -1;
            } else {
                iZzd = zzd(iZzc);
                this.zzd = iZzd;
            }
            if (iZzd == i) {
                int i3 = iZzd + 1;
                this.zzd = i3;
                if (i3 > this.zzb.length()) {
                    this.zzd = -1;
                }
            } else {
                if (i < iZzc) {
                    this.zzb.charAt(i);
                }
                if (i < iZzc) {
                    this.zzb.charAt(iZzc - 1);
                }
                if (!this.zzc || i != iZzc) {
                    int i4 = this.zze;
                    if (i4 == 1) {
                        CharSequence charSequence = this.zzb;
                        int length = charSequence.length();
                        this.zzd = -1;
                        if (length > i) {
                            charSequence.charAt(length - 1);
                        }
                        iZzc = length;
                    } else {
                        this.zze = i4 - 1;
                    }
                    return this.zzb.subSequence(i, iZzc).toString();
                }
                i = this.zzd;
            }
        }
    }

    abstract int zzc(int i);

    abstract int zzd(int i);
}
