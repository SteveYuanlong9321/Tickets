package com.google.android.gms.internal.nearby;

import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzvg {
    private final int[] zza;
    private final zzve zzb;
    private zzve zzc;
    private int zzd;
    private int zze;
    private int zzf;

    private zzvg(int[] iArr) {
        this.zza = iArr;
        zzve zzveVar = new zzve(-1, -1, null);
        this.zzb = zzveVar;
        this.zzc = zzveVar;
    }

    static zzvg zza(int[] iArr) {
        zzve zzveVar;
        zzvg zzvgVar = new zzvg(iArr);
        for (int i = 0; i < iArr.length; i++) {
            zzvgVar.zzf++;
            int[] iArr2 = zzvgVar.zza;
            int i2 = iArr2[i];
            while (true) {
                zzve zzveVar2 = null;
                while (true) {
                    if (zzvgVar.zzf <= 0) {
                        break;
                    }
                    int i3 = zzvgVar.zze;
                    zzveVar = zzvgVar.zzc;
                    if (i3 == 0) {
                        break;
                    }
                    int i4 = ((zzve) zzveVar.zzd.get(Integer.valueOf(iArr2[zzvgVar.zzd]))).zza;
                    int i5 = zzvgVar.zze;
                    if (iArr2[i4 + i5] == i2) {
                        if (zzveVar2 != null) {
                            zzveVar2.zzc = zzvgVar.zzc;
                        }
                        zzvgVar.zze = i5 + 1;
                        zzvgVar.zzb();
                        break;
                    }
                    zzve zzveVar3 = (zzve) zzvgVar.zzc.zzd.get(Integer.valueOf(iArr2[zzvgVar.zzd]));
                    int i6 = zzveVar3.zza;
                    zzve zzveVar4 = new zzve(i6, (zzvgVar.zze + i6) - 1, null);
                    zzvgVar.zzc.zzd.put(Integer.valueOf(iArr2[zzvgVar.zzd]), zzveVar4);
                    Map map = zzveVar4.zzd;
                    int i7 = zzveVar4.zzb + 1;
                    map.put(Integer.valueOf(iArr2[i7]), zzveVar3);
                    zzveVar3.zza = i7;
                    if (zzveVar2 != null) {
                        zzveVar2.zzc = zzveVar4;
                    }
                    map.put(Integer.valueOf(i2), new zzve(i, GroupFlagsKt.IsSubcompositionContextFlag, null));
                    zzvgVar.zzf--;
                    zzvgVar.zzc();
                    zzveVar2 = zzveVar4;
                }
                Map map2 = zzveVar.zzd;
                Integer numValueOf = Integer.valueOf(i2);
                if (map2.containsKey(numValueOf)) {
                    if (zzveVar2 != null) {
                        zzveVar2.zzc = zzvgVar.zzc;
                    }
                    zzvgVar.zzd = i;
                    zzvgVar.zze++;
                    zzvgVar.zzb();
                    break;
                }
                zzvgVar.zzc.zzd.put(numValueOf, new zzve(i, GroupFlagsKt.IsSubcompositionContextFlag, null));
                if (zzveVar2 != null) {
                    zzveVar2.zzc = zzvgVar.zzc;
                }
                zzvgVar.zzf--;
                zzvgVar.zzc();
            }
        }
        return zzvgVar;
    }

    private final void zze(zzve zzveVar, StringBuilder sb) {
        for (zzve zzveVar2 : zzveVar.zzd.values()) {
            sb.append("  ");
            sb.append(zzveVar);
            sb.append(" -> ");
            sb.append(zzveVar2);
            sb.append(" [label=\"");
            int[] iArr = this.zza;
            sb.append(Arrays.toString(Arrays.copyOfRange(iArr, zzveVar2.zza, Math.min(iArr.length, zzveVar2.zzb + 1))));
            sb.append("\"]\n");
            zze(zzveVar2, sb);
        }
    }

    private final boolean zzf(int i, int i2, int i3, int i4) {
        if (i >= 0 && i3 >= 0) {
            int[] iArr = this.zza;
            int length = iArr.length;
            int iMin = Math.min(length, i2);
            if (iMin - i == Math.min(length, i4) - i3) {
                for (int i5 = i; i5 <= iMin; i5++) {
                    if (iArr[i5] != iArr[(i3 + i5) - i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("digraph {\n");
        zze(this.zzb, sb);
        sb.append("}");
        return sb.toString();
    }

    final void zzb() {
        if (this.zze == 0) {
            return;
        }
        Map map = this.zzc.zzd;
        int[] iArr = this.zza;
        zzve zzveVar = (zzve) map.get(Integer.valueOf(iArr[this.zzd]));
        while (true) {
            int i = (zzveVar.zzb - zzveVar.zza) + 1;
            int i2 = this.zze;
            if (i > i2) {
                return;
            }
            int i3 = this.zzd + i;
            this.zzd = i3;
            this.zzc = zzveVar;
            int i4 = i2 - i;
            this.zze = i4;
            if (i4 > 0) {
                zzveVar = (zzve) zzveVar.zzd.get(Integer.valueOf(iArr[i3]));
            }
        }
    }

    final void zzc() {
        zzve zzveVar = this.zzc.zzc;
        if (zzveVar != null) {
            this.zzc = zzveVar;
        } else {
            this.zzc = this.zzb;
            int i = this.zze;
            if (i > 0) {
                this.zze = i - 1;
            }
            if (this.zzf > 0) {
                this.zzd++;
            }
        }
        zzb();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0065  */
    public final zzvf zzd() {
        int i;
        int i2;
        zzvd zzvdVar;
        ArrayDeque arrayDeque = new ArrayDeque();
        zzve zzveVar = this.zzb;
        zzvd zzvdVar2 = new zzvd(zzveVar, 0, -1, -1, null);
        arrayDeque.push(zzvdVar2);
        while (!arrayDeque.isEmpty()) {
            zzvd zzvdVar3 = (zzvd) arrayDeque.pop();
            for (zzve zzveVar2 : zzvdVar3.zzd.zzd.values()) {
                int i3 = zzvdVar3.zzb;
                int i4 = zzvdVar3.zzc;
                int i5 = zzveVar2.zza;
                int i6 = zzveVar2.zzb;
                if (zzf(i3, i4, i5, i6)) {
                    zzvdVar = new zzvd(zzveVar2, zzvdVar3.zza + 1, i3, i4, null);
                } else {
                    if (zzveVar2.zzd.isEmpty()) {
                        int i7 = zzveVar2.zza;
                        if (zzf(i3, i4, i7, (i7 + i4) - i3)) {
                            zzvdVar = new zzvd(zzveVar2, zzvdVar3.zza + 1, i3, i4, null);
                        }
                    }
                    zzvdVar = new zzvd(zzveVar2, 1, zzveVar2.zza, i6, null);
                }
                if (zzvdVar2.zza < zzvdVar.zza) {
                    zzvdVar2 = zzvdVar;
                }
                arrayDeque.push(zzvdVar);
            }
        }
        int[] iArr = this.zza;
        int iMin = Math.min(iArr.length, zzvdVar2.zzc + 1);
        int i8 = 0;
        loop2: while (true) {
            i = zzvdVar2.zzb;
            i2 = iMin - i;
            zzveVar = (zzve) zzveVar.zzd.get(Integer.valueOf(iArr[(i8 % i2) + i]));
            if (zzveVar == null) {
                break;
            }
            for (int i9 = zzveVar.zza; i9 < zzveVar.zzb + 1 && i9 < iArr.length; i9++) {
                if (iArr[(i8 % i2) + i] != iArr[i9]) {
                    break loop2;
                }
                i8++;
            }
        }
        return new zzvf(i, iMin, i8 / i2);
    }
}
