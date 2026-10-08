package com.google.android.gms.internal.nearby;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmp extends zzajj implements zzakt {
    private zzmp() {
        throw null;
    }

    /* synthetic */ zzmp(byte[] bArr) {
        super(zzmq.zzf);
    }

    public final List zza() {
        return Collections.unmodifiableList(((zzmq) this.zza).zza());
    }

    public final zzmp zzb(String str) {
        zzi();
        ((zzmq) this.zza).zzd("");
        return this;
    }

    public final zzmp zzc(String str) {
        zzi();
        ((zzmq) this.zza).zze("");
        return this;
    }
}
