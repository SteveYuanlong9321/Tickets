package com.google.android.gms.internal.nearby;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaad extends zzabp {
    private Object[] zza = new Object[8];
    private int zzb = 0;

    zzaad() {
    }

    private final int zzh(zzaaq zzaaqVar) {
        for (int i = 0; i < this.zzb; i++) {
            if (this.zza[i + i].equals(zzaaqVar)) {
                return i;
            }
        }
        return -1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Metadata{");
        for (int i = 0; i < this.zzb; i++) {
            sb.append(" '");
            sb.append(zzb(i));
            sb.append("': ");
            sb.append(zzc(i));
        }
        sb.append(" }");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzabp
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzabp
    public final zzaaq zzb(int i) {
        if (i < this.zzb) {
            return (zzaaq) this.zza[i + i];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // com.google.android.gms.internal.nearby.zzabp
    public final Object zzc(int i) {
        if (i < this.zzb) {
            return this.zza[i + i + 1];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // com.google.android.gms.internal.nearby.zzabp
    public final Object zzd(zzaaq zzaaqVar) {
        int iZzh = zzh(zzaaqVar);
        if (iZzh != -1) {
            return zzaaqVar.zze(this.zza[iZzh + iZzh + 1]);
        }
        return null;
    }

    final void zze(zzaaq zzaaqVar, Object obj) {
        int iZzh;
        if (!zzaaqVar.zzf() && (iZzh = zzh(zzaaqVar)) != -1) {
            zzadx.zza(obj, "metadata value");
            this.zza[iZzh + iZzh + 1] = obj;
            return;
        }
        int i = this.zzb + 1;
        Object[] objArrCopyOf = this.zza;
        int length = objArrCopyOf.length;
        if (i + i > length) {
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, length + length);
            this.zza = objArrCopyOf;
        }
        int i2 = this.zzb;
        zzadx.zza(zzaaqVar, "metadata key");
        objArrCopyOf[i2 + i2] = zzaaqVar;
        Object[] objArr = this.zza;
        int i3 = this.zzb;
        zzadx.zza(obj, "metadata value");
        objArr[i3 + i3 + 1] = obj;
        this.zzb++;
    }

    final void zzf(zzaaq zzaaqVar) {
        int i;
        int iZzh = zzh(zzaaqVar);
        if (iZzh >= 0) {
            int i2 = iZzh + iZzh;
            int i3 = i2 + 2;
            while (true) {
                i = this.zzb;
                if (i3 >= i + i) {
                    break;
                }
                Object obj = this.zza[i3];
                if (!obj.equals(zzaaqVar)) {
                    Object[] objArr = this.zza;
                    objArr[i2] = obj;
                    objArr[i2 + 1] = objArr[i3 + 1];
                    i2 += 2;
                }
                i3 += 2;
            }
            this.zzb = i - ((i3 - i2) >> 1);
            while (i2 < i3) {
                this.zza[i2] = null;
                i2++;
            }
        }
    }
}
