package com.google.android.gms.internal.nearby;

import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzuf extends zzvn {
    private final zzyg zza;
    private final zzyg zzb;
    private final UUID zzc;
    private final long zzd;

    /* synthetic */ zzuf(zzyg zzygVar, zzyg zzygVar2, UUID uuid, long j, byte[] bArr) {
        this.zza = zzygVar;
        this.zzb = zzygVar2;
        this.zzc = uuid;
        this.zzd = j;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzvn) {
            zzvn zzvnVar = (zzvn) obj;
            if (this.zza.equals(zzvnVar.zza()) && this.zzb.equals(zzvnVar.zzb()) && this.zzc.equals(zzvnVar.zzc()) && this.zzd == zzvnVar.zzd()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode();
        long j = this.zzd;
        return ((int) (j ^ (j >>> 32))) ^ (iHashCode * 1000003);
    }

    @Override // com.google.android.gms.internal.nearby.zzvn
    public final zzyg zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzvn
    public final zzyg zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzvn
    public final UUID zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zzvn
    public final long zzd() {
        return this.zzd;
    }
}
