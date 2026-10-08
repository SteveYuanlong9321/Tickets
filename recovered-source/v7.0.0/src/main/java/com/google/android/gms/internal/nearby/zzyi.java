package com.google.android.gms.internal.nearby;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzyi {
    Object[] zza;
    int zzb;
    zzyh zzc;

    public zzyi() {
        this(4);
    }

    private final zzyj zzd(boolean z) {
        zzyh zzyhVar;
        zzyh zzyhVar2;
        if (z && (zzyhVar2 = this.zzc) != null) {
            throw zzyhVar2.zza();
        }
        zzze zzzeVarZzf = zzze.zzf(this.zzb, this.zza, this);
        if (!z || (zzyhVar = this.zzc) == null) {
            return zzzeVarZzf;
        }
        throw zzyhVar.zza();
    }

    public final zzyi zza(Object obj, Object obj2) {
        int i = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.zza = Arrays.copyOf(objArr, zzya.zzb(length, i2));
        }
        zzxw.zza(obj, obj2);
        Object[] objArr2 = this.zza;
        int i3 = this.zzb;
        int i4 = i3 + i3;
        objArr2[i4] = obj;
        objArr2[i4 + 1] = obj2;
        this.zzb = i3 + 1;
        return this;
    }

    public final zzyj zzb() {
        return zzd(true);
    }

    public final zzyj zzc() {
        return zzd(false);
    }

    zzyi(int i) {
        this.zza = new Object[i + i];
        this.zzb = 0;
    }
}
