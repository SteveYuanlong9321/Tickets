package com.google.android.gms.internal.nearby;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzyc extends zzxz {
    public zzyc() {
        super(4);
    }

    public final zzyc zzc(Object obj) {
        super.zza(obj);
        return this;
    }

    public final zzyc zzd(Iterator it) {
        while (it.hasNext()) {
            super.zza(it.next());
        }
        return this;
    }

    public final zzyg zze() {
        this.zzc = true;
        return zzyg.zzt(this.zza, this.zzb);
    }

    zzyc(int i) {
        super(i);
    }
}
