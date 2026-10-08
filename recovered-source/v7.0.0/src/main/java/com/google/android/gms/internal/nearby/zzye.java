package com.google.android.gms.internal.nearby;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzye extends zzyg {
    private final transient zzyg zza;

    zzye(zzyg zzygVar) {
        this.zza = zzygVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzyg, com.google.android.gms.internal.nearby.zzyb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.contains(obj);
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzyg zzygVar = this.zza;
        zzxd.zzi(i, zzygVar.size(), "index");
        return zzygVar.get((zzygVar.size() - 1) - i);
    }

    @Override // com.google.android.gms.internal.nearby.zzyg, java.util.List
    public final int indexOf(Object obj) {
        zzyg zzygVar = this.zza;
        int iLastIndexOf = zzygVar.lastIndexOf(obj);
        if (iLastIndexOf >= 0) {
            return (zzygVar.size() - 1) - iLastIndexOf;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.nearby.zzyg, java.util.List
    public final int lastIndexOf(Object obj) {
        zzyg zzygVar = this.zza;
        int iIndexOf = zzygVar.indexOf(obj);
        if (iIndexOf >= 0) {
            return (zzygVar.size() - 1) - iIndexOf;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.nearby.zzyg, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.nearby.zzyb
    final boolean zzf() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.nearby.zzyg
    public final zzyg zzh() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzyg
    /* JADX INFO: renamed from: zzi */
    public final zzyg subList(int i, int i2) {
        zzyg zzygVar = this.zza;
        zzxd.zzk(i, i2, zzygVar.size());
        return zzygVar.subList(zzygVar.size() - i2, zzygVar.size() - i).zzh();
    }
}
