package com.google.android.gms.internal.nearby;

import android.text.TextUtils;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzvn {
    zzvn() {
    }

    public final String toString() {
        return TextUtils.join(" -> ", zza());
    }

    public abstract zzyg zza();

    public abstract zzyg zzb();

    public abstract UUID zzc();

    public abstract long zzd();
}
