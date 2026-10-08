package com.google.android.gms.internal.nearby;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzadh extends AbstractSet {
    final int zza;
    final /* synthetic */ zzadi zzb;

    zzadh(zzadi zzadiVar, int i) {
        Objects.requireNonNull(zzadiVar);
        this.zzb = zzadiVar;
        this.zza = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return Arrays.binarySearch(this.zzb.zzb(), zzb(), zzc(), obj, this.zza == -1 ? zzadi.zza : zzadk.zzb) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzadg(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return zzc() - zzb();
    }

    final Object zza(int i) {
        return this.zzb.zzb()[zzb() + i];
    }

    final int zzb() {
        int i = this.zza;
        if (i == -1) {
            return 0;
        }
        return this.zzb.zzc()[i];
    }

    final int zzc() {
        return this.zzb.zzc()[this.zza + 1];
    }
}
