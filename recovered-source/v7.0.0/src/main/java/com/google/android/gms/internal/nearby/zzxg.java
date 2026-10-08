package com.google.android.gms.internal.nearby;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzxg implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzxj zzb;

    zzxg(zzxj zzxjVar, CharSequence charSequence) {
        this.zza = charSequence;
        Objects.requireNonNull(zzxjVar);
        this.zzb = zzxjVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zzb.zzd(this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        zzxa.zza(sb, iterator(), ", ");
        sb.append(']');
        return sb.toString();
    }
}
