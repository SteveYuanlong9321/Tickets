package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzuo extends ThreadLocal {
    zzuo() {
    }

    @Override // java.lang.ThreadLocal
    protected final /* bridge */ /* synthetic */ Object initialValue() {
        zzvh zzvhVar = new zzvh(zzqh.zza(Thread.currentThread()));
        Thread threadCurrentThread = Thread.currentThread();
        synchronized (zzup.zze) {
            zzup.zze.put(threadCurrentThread, zzvhVar);
        }
        return zzvhVar;
    }
}
