package com.google.android.gms.internal.nearby;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzafo extends zzafb.zzf {
    private static final zzafl zza;
    private static final zzagw zzb = new zzagw(zzafo.class);
    volatile int remainingField;
    volatile Set<Throwable> seenExceptionsField = null;

    static {
        Throwable th;
        zzafl zzafnVar;
        byte[] bArr = null;
        try {
            zzafnVar = new zzafm(bArr);
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzafnVar = new zzafn(bArr);
        }
        zza = zzafnVar;
        if (th != null) {
            zzb.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    zzafo(int i) {
        this.remainingField = i;
    }

    final Set zzB() {
        Set<Throwable> set = this.seenExceptionsField;
        if (set != null) {
            return set;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzg(setNewSetFromMap);
        zza.zza(this, null, setNewSetFromMap);
        return (Set) Objects.requireNonNull(this.seenExceptionsField);
    }

    final int zzC() {
        return zza.zzb(this);
    }

    abstract void zzg(Set set);
}
