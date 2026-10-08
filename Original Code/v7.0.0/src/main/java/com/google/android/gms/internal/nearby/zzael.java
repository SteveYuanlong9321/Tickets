package com.google.android.gms.internal.nearby;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzael extends zzaec implements Serializable {
    static final zzaeh zza = new zzael(0);
    private final int zzb = 0;

    static {
        int i = zzaej.zza;
    }

    zzael(int i) {
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzael)) {
            return false;
        }
        int i = ((zzael) obj).zzb;
        return true;
    }

    public final int hashCode() {
        return getClass().hashCode();
    }

    public final String toString() {
        return "Hashing.murmur3_128(0)";
    }

    @Override // com.google.android.gms.internal.nearby.zzaeh
    public final zzaei zza() {
        return new zzaek(0);
    }
}
