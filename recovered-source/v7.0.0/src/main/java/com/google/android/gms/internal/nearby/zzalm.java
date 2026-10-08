package com.google.android.gms.internal.nearby;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzalm {
    private static volatile int zza = 100;

    zzalm() {
    }

    abstract void zza(Object obj, int i, long j);

    abstract void zzb(Object obj, int i, int i2);

    abstract void zzc(Object obj, int i, long j);

    abstract void zzd(Object obj, int i, zzaik zzaikVar);

    abstract void zze(Object obj, int i, Object obj2);

    abstract Object zzf();

    abstract Object zzg(Object obj);

    final boolean zzh(Object obj, zzaip zzaipVar, int i) throws IOException {
        int iZzc = zzaipVar.zzc();
        int i2 = iZzc >>> 3;
        int i3 = iZzc & 7;
        if (i3 == 0) {
            zza(obj, i2, zzaipVar.zzh());
            return true;
        }
        if (i3 == 1) {
            zzc(obj, i2, zzaipVar.zzj());
            return true;
        }
        if (i3 == 2) {
            zzd(obj, i2, zzaipVar.zzq());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                if (i != 0) {
                    return false;
                }
                throw new zzakf("Protocol message end-group tag did not match expected tag.");
            }
            if (i3 != 5) {
                throw new zzake("Protocol message tag had invalid wire type.");
            }
            zzb(obj, i2, zzaipVar.zzk());
            return true;
        }
        Object objZzf = zzf();
        int i4 = i2 << 3;
        int i5 = i + 1;
        if (i5 >= zza) {
            throw new zzakf("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (zzaipVar.zzb() != Integer.MAX_VALUE && zzh(objZzf, zzaipVar, i5)) {
        }
        if ((i4 | 4) != zzaipVar.zzc()) {
            throw new zzakf("Protocol message end-group tag did not match expected tag.");
        }
        zze(obj, i2, zzg(objZzf));
        return true;
    }
}
