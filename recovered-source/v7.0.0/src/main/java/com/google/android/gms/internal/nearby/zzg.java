package com.google.android.gms.internal.nearby;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzg {
    private static volatile zzg zza;
    private final List zzb = new CopyOnWriteArrayList();

    private zzg() {
    }

    public static zzg zza() {
        if (zza == null) {
            synchronized (zzg.class) {
                if (zza == null) {
                    zza = new zzg();
                }
            }
        }
        return zza;
    }

    public final void zzb(zzf zzfVar) {
        this.zzb.add(0, zzfVar);
    }
}
