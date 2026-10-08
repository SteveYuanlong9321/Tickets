package com.google.android.gms.internal.nearby;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzqq {
    private final Context zza;
    private final zzrb zzb = new zzrb();

    /* synthetic */ zzqq(Context context, byte[] bArr) {
        zzrk.zza(context != null, "Context cannot be null", new Object[0]);
        this.zza = context.getApplicationContext();
    }

    public final zzqr zza() {
        return new zzqr(this, null);
    }

    final /* synthetic */ Context zzb() {
        return this.zza;
    }

    final /* synthetic */ zzrb zzc() {
        return this.zzb;
    }
}
