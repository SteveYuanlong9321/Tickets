package com.google.android.gms.internal.nearby;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzzc extends zzyl {
    private final transient zzyj zza;
    private final transient zzyg zzb;

    zzzc(zzyj zzyjVar, zzyg zzygVar) {
        this.zza = zzyjVar;
        this.zzb = zzygVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.nearby.zzyl, com.google.android.gms.internal.nearby.zzyb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.nearby.zzyl, com.google.android.gms.internal.nearby.zzyb
    /* JADX INFO: renamed from: zza */
    public final zzzl iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // com.google.android.gms.internal.nearby.zzyl, com.google.android.gms.internal.nearby.zzyb
    public final zzyg zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final int zzg(Object[] objArr, int i) {
        return this.zzb.zzg(objArr, 0);
    }
}
