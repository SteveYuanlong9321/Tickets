package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzwp extends zzxb {
    static final zzwp zza = new zzwp();

    private zzwp() {
    }

    @Override // com.google.android.gms.internal.nearby.zzxb
    public final boolean equals(Object obj) {
        return this == obj;
    }

    @Override // com.google.android.gms.internal.nearby.zzxb
    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.android.gms.internal.nearby.zzxb
    public final boolean zza() {
        return false;
    }

    @Override // com.google.android.gms.internal.nearby.zzxb
    public final Object zzb() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.android.gms.internal.nearby.zzxb
    public final Object zzc(zzxn zzxnVar) {
        return zzxnVar.zzbh();
    }

    @Override // com.google.android.gms.internal.nearby.zzxb
    public final Object zzd() {
        return null;
    }
}
