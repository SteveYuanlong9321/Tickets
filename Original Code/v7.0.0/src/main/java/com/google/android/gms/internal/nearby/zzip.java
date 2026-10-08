package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzip extends zzjb {
    final /* synthetic */ ListenerHolder zza;

    zzip(zziy zziyVar, ListenerHolder listenerHolder) {
        this.zza = listenerHolder;
        Objects.requireNonNull(zziyVar);
    }

    @Override // com.google.android.gms.internal.nearby.zzjc
    public final void zzb(byte[] bArr) {
        this.zza.notifyListener(new zzio(this, bArr));
    }
}
