package com.google.android.gms.internal.nearby;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzzb extends zzyl {
    private final transient zzyj zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    zzzb(zzyj zzyjVar, Object[] objArr, int i, int i2) {
        this.zza = zzyjVar;
        this.zzb = objArr;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.nearby.zzyl, com.google.android.gms.internal.nearby.zzyb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zze().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zzyl, com.google.android.gms.internal.nearby.zzyb
    /* JADX INFO: renamed from: zza */
    public final zzzl iterator() {
        return zze().listIterator(0);
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final int zzg(Object[] objArr, int i) {
        return zze().zzg(objArr, 0);
    }

    @Override // com.google.android.gms.internal.nearby.zzyl
    final zzyg zzp() {
        return new zzza(this);
    }

    final /* synthetic */ Object[] zzq() {
        return this.zzb;
    }

    final /* synthetic */ int zzr() {
        return this.zzc;
    }
}
