package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public enum zzaba {
    SMALL(10),
    MEDIUM(20),
    LARGE(50),
    FULL(-1),
    NONE(0);

    private final int zzf;

    zzaba(int i) {
        this.zzf = i;
    }

    final int zza() {
        return this.zzf;
    }
}
