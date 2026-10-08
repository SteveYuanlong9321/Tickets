package com.google.android.gms.internal.nearby;

import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzyo {
    public static Object zza(Iterable iterable, Object obj) {
        return zzyq.zza(((zzzg) iterable).zzd.listIterator(0), null);
    }

    public static Object zzb(Iterable iterable) {
        List list = (List) iterable;
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.get(list.size() - 1);
    }
}
