package com.google.android.gms.internal.nearby;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzabz {
    private static final zzabv zza = new zzabx();
    private static final zzabu zzb = new zzaby();

    public static zzabs zza(Set set) {
        zzabs zzabsVar = new zzabs(zza, null);
        zzabsVar.zza(zzb);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzabsVar.zzb((zzaaq) it.next());
        }
        return zzabsVar;
    }
}
