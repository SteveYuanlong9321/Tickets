package com.google.android.gms.internal.nearby;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
class zzxz extends zzya {
    Object[] zza;
    int zzb;
    boolean zzc;

    zzxz(int i) {
        zzxw.zzb(i, "initialCapacity");
        this.zza = new Object[i];
        this.zzb = 0;
    }

    public final zzxz zza(Object obj) {
        obj.getClass();
        int length = this.zza.length;
        int iZzb = zzb(length, this.zzb + 1);
        if (iZzb > length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, iZzb);
            this.zzc = false;
        }
        Object[] objArr = this.zza;
        int i = this.zzb;
        this.zzb = i + 1;
        objArr[i] = obj;
        return this;
    }
}
