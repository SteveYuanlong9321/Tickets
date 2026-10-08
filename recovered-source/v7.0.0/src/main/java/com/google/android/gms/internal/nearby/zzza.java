package com.google.android.gms.internal.nearby;

import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzza extends zzyg {
    final /* synthetic */ zzzb zza;

    zzza(zzzb zzzbVar) {
        Objects.requireNonNull(zzzbVar);
        this.zza = zzzbVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzzb zzzbVar = this.zza;
        zzxd.zzi(i, zzzbVar.zzr(), "index");
        int i2 = i + i;
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(zzzbVar.zzq()[i2]), Objects.requireNonNull(zzzbVar.zzq()[i2 + 1]));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    public final boolean zzf() {
        return true;
    }
}
