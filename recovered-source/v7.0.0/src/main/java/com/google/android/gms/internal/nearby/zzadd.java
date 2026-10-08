package com.google.android.gms.internal.nearby;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzadd implements Comparator {
    zzadd() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        zzadj zzadjVarZza = zzadj.zza(obj);
        zzadj zzadjVarZza2 = zzadj.zza(obj2);
        if (zzadjVarZza != zzadjVarZza2) {
            return zzadjVarZza.compareTo(zzadjVarZza2);
        }
        int iOrdinal = zzadjVarZza.ordinal();
        if (iOrdinal == 0) {
            return ((Boolean) obj).compareTo((Boolean) obj2);
        }
        if (iOrdinal == 1) {
            return ((String) obj).compareTo((String) obj2);
        }
        if (iOrdinal == 2) {
            return ((Long) obj).compareTo((Long) obj2);
        }
        if (iOrdinal == 3) {
            return ((Double) obj).compareTo((Double) obj2);
        }
        throw null;
    }
}
