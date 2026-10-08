package com.google.android.gms.internal.nearby;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzadk {
    public static final /* synthetic */ int zza = 0;
    private static final Comparator zzb = new zzadd();
    private static final zzadk zzc = new zzadk(new zzadi(Collections.EMPTY_LIST));
    private final zzadi zzd;

    private zzadk(zzadi zzadiVar) {
        this.zzd = zzadiVar;
    }

    public static zzadk zza() {
        return zzc;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzadk) && ((zzadk) obj).zzd.equals(this.zzd);
    }

    public final int hashCode() {
        return ~this.zzd.hashCode();
    }

    public final String toString() {
        return this.zzd.toString();
    }

    public final Map zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        return this.zzd.isEmpty();
    }

    public final zzadk zzd(zzadk zzadkVar) {
        zzadi zzadiVar = zzadkVar.zzd;
        if (zzadiVar.isEmpty()) {
            return this;
        }
        zzadi zzadiVar2 = this.zzd;
        return zzadiVar2.isEmpty() ? zzadkVar : new zzadk(new zzadi(zzadiVar2, zzadiVar));
    }
}
