package com.google.android.gms.internal.nearby;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzve {
    int zza;
    final int zzb;
    zzve zzc;
    final Map zzd = new HashMap(0);

    zzve(int i, int i2, zzve zzveVar) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        this.zza = i;
        this.zzb = i2;
        this.zzc = null;
    }

    public final String toString() {
        int iIdentityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(iIdentityHashCode).length() + 4);
        sb.append("Node");
        sb.append(iIdentityHashCode);
        return sb.toString();
    }
}
