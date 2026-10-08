package com.google.android.gms.nearby.internal.connection;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzar {
    private final String zza;
    private final long zzb;

    zzar(String str, long j) {
        this.zza = str;
        this.zzb = j;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzar) {
            zzar zzarVar = (zzar) obj;
            if (Objects.equals(this.zza, zzarVar.zza)) {
                if (Objects.equals(Long.valueOf(this.zzb), Long.valueOf(zzarVar.zzb))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, Long.valueOf(this.zzb));
    }

    public final String zza() {
        return this.zza;
    }
}
