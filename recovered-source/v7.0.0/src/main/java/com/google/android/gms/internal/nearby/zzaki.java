package com.google.android.gms.internal.nearby;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaki {
    zzaki() {
    }

    public static final List zza(Object obj, long j) {
        zzajz zzajzVar = (zzajz) zzalt.zzl(obj, j);
        if (zzajzVar.zza()) {
            return zzajzVar;
        }
        int size = zzajzVar.size();
        zzajz zzajzVarZzg = zzajzVar.zzg(size == 0 ? 10 : size + size);
        zzalt.zzm(obj, j, zzajzVarZzg);
        return zzajzVarZzg;
    }
}
