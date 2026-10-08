package com.google.android.gms.internal.nearby;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzxr {
    public static zzxn zza(zzxn zzxnVar) {
        if ((zzxnVar instanceof zzxp) || (zzxnVar instanceof zzxo)) {
            return zzxnVar;
        }
        return zzxnVar instanceof Serializable ? new zzxo(zzxnVar) : new zzxp(zzxnVar);
    }

    public static zzxn zzb(Object obj) {
        return new zzxq(obj);
    }
}
