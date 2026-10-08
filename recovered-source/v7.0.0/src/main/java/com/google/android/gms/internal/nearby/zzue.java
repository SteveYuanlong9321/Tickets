package com.google.android.gms.internal.nearby;

import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzue extends zzvm {
    private zzyg zza;
    private zzyg zzb;
    private UUID zzc;
    private long zzd;
    private byte zze;

    zzue() {
    }

    @Override // com.google.android.gms.internal.nearby.zzvm
    public final zzvm zza(zzyg zzygVar) {
        if (zzygVar == null) {
            throw new NullPointerException("Null spansNames");
        }
        this.zza = zzygVar;
        return this;
    }

    @Override // com.google.android.gms.internal.nearby.zzvm
    public final zzvm zzb(zzyg zzygVar) {
        if (zzygVar == null) {
            throw new NullPointerException("Null extras");
        }
        this.zzb = zzygVar;
        return this;
    }

    @Override // com.google.android.gms.internal.nearby.zzvm
    public final zzvm zzc(UUID uuid) {
        if (uuid == null) {
            throw new NullPointerException("Null rootTraceId");
        }
        this.zzc = uuid;
        return this;
    }

    @Override // com.google.android.gms.internal.nearby.zzvm
    public final zzvm zzd(long j) {
        this.zzd = -1L;
        this.zze = (byte) 1;
        return this;
    }

    @Override // com.google.android.gms.internal.nearby.zzvm
    public final zzvn zze() {
        zzyg zzygVar;
        zzyg zzygVar2;
        UUID uuid;
        if (this.zze == 1 && (zzygVar = this.zza) != null && (zzygVar2 = this.zzb) != null && (uuid = this.zzc) != null) {
            return new zzuf(zzygVar, zzygVar2, uuid, this.zzd, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" spansNames");
        }
        if (this.zzb == null) {
            sb.append(" extras");
        }
        if (this.zzc == null) {
            sb.append(" rootTraceId");
        }
        if (this.zze == 0) {
            sb.append(" rootDurationMs");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
