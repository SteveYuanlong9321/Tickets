package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public enum zzalz {
    DOUBLE(zzama.DOUBLE, 1),
    FLOAT(zzama.FLOAT, 5),
    INT64(zzama.LONG, 0),
    UINT64(zzama.LONG, 0),
    INT32(zzama.INT, 0),
    FIXED64(zzama.LONG, 1),
    FIXED32(zzama.INT, 5),
    BOOL(zzama.BOOLEAN, 0),
    STRING(zzama.STRING, 2),
    GROUP(zzama.MESSAGE, 3),
    MESSAGE(zzama.MESSAGE, 2),
    BYTES(zzama.BYTE_STRING, 2),
    UINT32(zzama.INT, 0),
    ENUM(zzama.ENUM, 0),
    SFIXED32(zzama.INT, 5),
    SFIXED64(zzama.LONG, 1),
    SINT32(zzama.INT, 0),
    SINT64(zzama.LONG, 0);

    private final zzama zzs;
    private final int zzt;

    zzalz(zzama zzamaVar, int i) {
        this.zzs = zzamaVar;
        this.zzt = i;
    }

    public final zzama zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}
