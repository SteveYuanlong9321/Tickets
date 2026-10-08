package com.google.android.gms.internal.nearby;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalg implements Iterator {
    final /* synthetic */ zzali zza;
    private int zzb;

    /* synthetic */ zzalg(zzali zzaliVar, byte[] bArr) {
        Objects.requireNonNull(zzaliVar);
        this.zza = zzaliVar;
        this.zzb = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zzali zzaliVar = this.zza;
        zzaliVar.zzd();
        return this.zzb + 1 < zzaliVar.zzg();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        zzali zzaliVar = this.zza;
        zzaliVar.zzd();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.zzb + 1;
        this.zzb = i;
        return (zzalf) zzaliVar.zzf()[i];
    }
}
