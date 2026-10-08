package com.google.android.gms.internal.nearby;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzzi extends zzyl {
    final transient Object zza;

    zzzi(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.nearby.zzyl, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.nearby.zzyl, com.google.android.gms.internal.nearby.zzyb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzyp(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String string = this.zza.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 2);
        sb.append("[");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzyl, com.google.android.gms.internal.nearby.zzyb
    /* JADX INFO: renamed from: zza */
    public final zzzl iterator() {
        return new zzyp(this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzyl, com.google.android.gms.internal.nearby.zzyb
    public final zzyg zze() {
        return zzyg.zzk(this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final int zzg(Object[] objArr, int i) {
        objArr[0] = this.zza;
        return 1;
    }
}
