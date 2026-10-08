package com.google.android.gms.internal.nearby;

import java.util.Objects;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzzv extends zzzt implements zzzu {
    final /* synthetic */ zzzx zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzzv(zzzx zzzxVar, Level level, boolean z) {
        super(level, false);
        Objects.requireNonNull(zzzxVar);
        this.zza = zzzxVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzaae
    protected final /* synthetic */ zzzn zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzaae
    protected final /* bridge */ /* synthetic */ zzaan zzd() {
        return this;
    }
}
