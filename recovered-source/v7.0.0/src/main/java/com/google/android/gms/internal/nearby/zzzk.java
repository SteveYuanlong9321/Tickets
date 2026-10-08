package com.google.android.gms.internal.nearby;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzzk {
    public static boolean zza(Comparator comparator, Iterable iterable) {
        Comparator comparator2;
        comparator.getClass();
        iterable.getClass();
        if (iterable instanceof SortedSet) {
            comparator2 = ((SortedSet) iterable).comparator();
            if (comparator2 == null) {
                comparator2 = zzyw.zza;
            }
        } else {
            if (!(iterable instanceof zzzj)) {
                return false;
            }
            comparator2 = ((zzzj) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
