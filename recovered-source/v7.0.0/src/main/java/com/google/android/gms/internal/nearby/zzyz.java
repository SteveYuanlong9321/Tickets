package com.google.android.gms.internal.nearby;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzyz extends zzyg {
    static final zzyg zza = new zzyz(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzyz(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzxd.zzi(i, this.zzc, "index");
        return Objects.requireNonNull(this.zzb[i]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.nearby.zzyg, com.google.android.gms.internal.nearby.zzyb
    final int zzg(Object[] objArr, int i) {
        Object[] objArr2 = this.zzb;
        int i2 = this.zzc;
        System.arraycopy(objArr2, 0, objArr, 0, i2);
        return i2;
    }
}
