package com.google.android.gms.internal.nearby;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzzf extends zzyl {
    static final zzzf zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzzf(objArr, 0, objArr, 0, 0);
    }

    zzzf(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzb = objArr;
        this.zze = i;
        this.zzc = objArr2;
        this.zzf = i2;
        this.zzg = i3;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.zzc;
            if (objArr.length != 0) {
                int iZza = zzxy.zza(obj.hashCode());
                while (true) {
                    int i = iZza & this.zzf;
                    Object obj2 = objArr[i];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iZza = i + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.nearby.zzyl, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.nearby.zzyl, com.google.android.gms.internal.nearby.zzyb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zze().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.nearby.zzyl, com.google.android.gms.internal.nearby.zzyb
    /* JADX INFO: renamed from: zza */
    public final zzzl iterator() {
        return zze().listIterator(0);
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
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final int zzg(Object[] objArr, int i) {
        Object[] objArr2 = this.zzb;
        int i2 = this.zzg;
        System.arraycopy(objArr2, 0, objArr, 0, i2);
        return i2;
    }

    @Override // com.google.android.gms.internal.nearby.zzyl
    final boolean zzo() {
        return true;
    }

    @Override // com.google.android.gms.internal.nearby.zzyl
    final zzyg zzp() {
        return zzyg.zzt(this.zzb, this.zzg);
    }
}
