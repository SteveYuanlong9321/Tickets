package com.google.android.gms.internal.nearby;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzxq implements Serializable, zzxn {
    final Object zza;

    zzxq(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzxq) {
            return Objects.equals(this.zza, ((zzxq) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza);
    }

    public final String toString() {
        String string = this.zza.toString();
        StringBuilder sb = new StringBuilder(string.length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzxn
    public final Object zzbh() {
        return this.zza;
    }
}
