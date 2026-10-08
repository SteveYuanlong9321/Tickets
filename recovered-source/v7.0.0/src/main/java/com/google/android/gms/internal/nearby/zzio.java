package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzio implements ListenerHolder.Notifier {
    final /* synthetic */ byte[] zza;

    zzio(zzip zzipVar, byte[] bArr) {
        this.zza = bArr;
        Objects.requireNonNull(zzipVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        zzoe zzoeVar = (zzoe) obj;
        try {
            zzoeVar.zza(zzod.zzb(this.zza, zzaiz.zzb()));
        } catch (zzakf e) {
            zzoeVar.zzb(e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
