package com.google.android.gms.internal.nearby;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzyu {
    public static List zza(List list) {
        if (list instanceof zzyg) {
            return ((zzyg) list).zzh();
        }
        if (list instanceof zzyt) {
            return ((zzyt) list).zza();
        }
        return list instanceof RandomAccess ? new zzyr(list) : new zzyt(list);
    }
}
