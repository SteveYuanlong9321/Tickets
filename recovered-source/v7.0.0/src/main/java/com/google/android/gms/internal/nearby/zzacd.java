package com.google.android.gms.internal.nearby;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzacd implements Iterator {
    final /* synthetic */ zzace zza;
    private final zzaaq zzb;
    private int zzc;
    private int zzd;

    /* synthetic */ zzacd(zzace zzaceVar, zzaaq zzaaqVar, int i, byte[] bArr) {
        Objects.requireNonNull(zzaceVar);
        this.zza = zzaceVar;
        this.zzb = zzaaqVar;
        int i2 = i & 31;
        this.zzc = i2;
        this.zzd = i >>> (i2 + 5);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object objZze = this.zzb.zze(this.zza.zze(this.zzc));
        int i = this.zzd;
        if (i == 0) {
            this.zzc = -1;
            return objZze;
        }
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i) + 1;
        this.zzd >>>= iNumberOfTrailingZeros;
        this.zzc += iNumberOfTrailingZeros;
        return objZze;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
