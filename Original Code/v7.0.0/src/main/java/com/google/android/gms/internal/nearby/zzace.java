package com.google.android.gms.internal.nearby;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzace extends zzacg {
    private final zzabp zza;
    private final zzabp zzb;
    private final int[] zzc;
    private final int zzd;

    /* JADX WARN: Code duplicated, block: B:25:0x0063  */
    /* synthetic */ zzace(zzabp zzabpVar, zzabp zzabpVar2, byte[] bArr) {
        super(null);
        this.zza = zzabpVar;
        this.zzb = zzabpVar2;
        int iZza = zzabpVar2.zza();
        zzadx.zzb(iZza <= 28, "metadata size too large");
        int[] iArr = new int[iZza];
        this.zzc = iArr;
        long j = 0;
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            zzaaq zzaaqVarZzd = zzd(i);
            long jZzi = zzaaqVarZzd.zzi() | j;
            if (jZzi == j) {
                int i3 = 0;
                while (true) {
                    if (i3 >= i2) {
                        i3 = -1;
                        break;
                    } else if (zzaaqVarZzd.equals(zzd(iArr[i3] & 31))) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 != -1) {
                    iArr[i3] = zzaaqVarZzd.zzf() ? iArr[i3] | (1 << (i + 4)) : i;
                } else {
                    iArr[i2] = i;
                    i2++;
                }
            } else {
                iArr[i2] = i;
                i2++;
            }
            i++;
            j = jZzi;
        }
        this.zzd = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final zzaaq zzd(int i) {
        zzabp zzabpVar = this.zza;
        int iZza = zzabpVar.zza();
        return i >= iZza ? this.zzb.zzb(i - iZza) : zzabpVar.zzb(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public final Object zze(int i) {
        zzabp zzabpVar = this.zza;
        int iZza = zzabpVar.zza();
        return i >= iZza ? this.zzb.zzc(i - iZza) : zzabpVar.zzc(i);
    }

    @Override // com.google.android.gms.internal.nearby.zzacg
    public final void zza(zzabw zzabwVar, Object obj) {
        for (int i = 0; i < this.zzd; i++) {
            int i2 = this.zzc[i];
            zzaaq zzaaqVarZzd = zzd(i2 & 31);
            if (zzaaqVarZzd.zzf()) {
                zzabwVar.zzb(zzaaqVarZzd, new zzacd(this, zzaaqVarZzd, i2, null), obj);
            } else {
                zzabwVar.zza(zzaaqVarZzd, zzaaqVarZzd.zze(zze(i2)), obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzacg
    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.nearby.zzacg
    public final Set zzc() {
        return new zzacc(this);
    }

    final /* synthetic */ int[] zzf() {
        return this.zzc;
    }

    final /* synthetic */ int zzg() {
        return this.zzd;
    }
}
