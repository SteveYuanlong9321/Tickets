package com.google.android.gms.internal.nearby;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmr extends zzajj implements zzakt {
    private zzmr() {
        throw null;
    }

    /* synthetic */ zzmr(byte[] bArr) {
        super(zzms.zzd);
    }

    public final zzmr zza(String str, zzmq zzmqVar) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(zzmqVar);
        zzi();
        ((zzms) this.zza).zzd().put(str, zzmqVar);
        return this;
    }
}
