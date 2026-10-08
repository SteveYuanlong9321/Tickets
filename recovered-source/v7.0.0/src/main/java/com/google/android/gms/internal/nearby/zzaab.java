package com.google.android.gms.internal.nearby;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaab extends zzaaq {
    zzaab(String str, Class cls, boolean z) {
        super("tags", cls, false);
    }

    @Override // com.google.android.gms.internal.nearby.zzaaq
    public final /* bridge */ /* synthetic */ void zzb(Object obj, zzaap zzaapVar) {
        zzadk zzadkVar = (zzadk) obj;
        if (zzadkVar == null) {
            return;
        }
        for (Map.Entry entry : zzadkVar.zzb().entrySet()) {
            if (((Set) entry.getValue()).isEmpty()) {
                zzaapVar.zza((String) entry.getKey(), null);
            } else {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    zzaapVar.zza((String) entry.getKey(), it.next());
                }
            }
        }
    }
}
