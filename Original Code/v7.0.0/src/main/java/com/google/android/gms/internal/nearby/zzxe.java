package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzxe extends zzxb {
    private final Object zza;

    zzxe(Object obj) {
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.nearby.zzxb
    public final boolean equals(Object obj) {
        if (obj instanceof zzxe) {
            return this.zza.equals(((zzxe) obj).zza);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.nearby.zzxb
    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String string = this.zza.toString();
        StringBuilder sb = new StringBuilder(string.length() + 13);
        sb.append("Optional.of(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzxb
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.nearby.zzxb
    public final Object zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzxb
    public final Object zzc(zzxn zzxnVar) {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzxb
    public final Object zzd() {
        return this.zza;
    }
}
