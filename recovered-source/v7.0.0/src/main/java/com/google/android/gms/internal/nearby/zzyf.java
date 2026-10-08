package com.google.android.gms.internal.nearby;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzyf extends zzyg {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzyg zzc;

    zzyf(zzyg zzygVar, int i, int i2) {
        Objects.requireNonNull(zzygVar);
        this.zzc = zzygVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzxd.zzi(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzyg, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final Object[] zzb() {
        return this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.nearby.zzyg
    /* JADX INFO: renamed from: zzi */
    public final zzyg subList(int i, int i2) {
        zzxd.zzk(i, i2, this.zzb);
        int i3 = this.zza;
        return this.zzc.subList(i + i3, i2 + i3);
    }
}
