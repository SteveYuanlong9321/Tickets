package com.google.android.gms.internal.nearby;

import java.util.AbstractList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzajx extends AbstractList {
    private final zzajv zza;

    public zzajx(zzajv zzajvVar, zzajw zzajwVar) {
        this.zza = zzajvVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        zzahs zzahsVarZzb = zzahs.zzb(this.zza.zzf(i));
        return zzahsVarZzb == null ? zzahs.UNKNOWN : zzahsVarZzb;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
