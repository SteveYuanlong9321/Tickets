package com.google.android.gms.internal.nearby;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzym extends zzyk {
    private final Comparator zzd;

    public zzym(Comparator comparator) {
        this.zzd = comparator;
    }

    public final zzym zzd(Object obj) {
        super.zzc(obj);
        return this;
    }

    public final zzyn zze() {
        zzzg zzzgVar;
        Object[] objArrCopyOf = this.zza;
        int i = this.zzb;
        Comparator comparator = this.zzd;
        if (i == 0) {
            zzzgVar = zzyn.zzq(comparator);
        } else {
            zzyx.zza(objArrCopyOf, i);
            Arrays.sort(objArrCopyOf, 0, i, comparator);
            int i2 = 1;
            for (int i3 = 1; i3 < i; i3++) {
                Object obj = objArrCopyOf[i3];
                if (comparator.compare(obj, objArrCopyOf[i2 - 1]) != 0) {
                    objArrCopyOf[i2] = obj;
                    i2++;
                }
            }
            Arrays.fill(objArrCopyOf, i2, i, (Object) null);
            if (i2 < (objArrCopyOf.length >> 1)) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i2);
            }
            zzzgVar = new zzzg(zzyg.zzt(objArrCopyOf, i2), comparator);
        }
        this.zzb = zzzgVar.zzd.size();
        this.zzc = true;
        return zzzgVar;
    }
}
