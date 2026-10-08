package com.google.android.gms.internal.nearby;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbl {
    private final Map zza = new WeakHashMap();

    public final boolean zza(Object obj) {
        return zzc(obj) != null;
    }

    public final void zzb(Object obj, Object obj2) {
        this.zza.put(obj, new WeakReference(obj2));
    }

    public final Object zzc(Object obj) {
        WeakReference weakReference = (WeakReference) this.zza.get(obj);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void zzd(Object obj) {
        this.zza.remove(obj);
    }

    public final void zze() {
        this.zza.clear();
    }
}
