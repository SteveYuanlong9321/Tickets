package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public enum zzajf {
    DOUBLE(0, 1, zzakg.DOUBLE),
    FLOAT(1, 1, zzakg.FLOAT),
    INT64(2, 1, zzakg.LONG),
    UINT64(3, 1, zzakg.LONG),
    INT32(4, 1, zzakg.INT),
    FIXED64(5, 1, zzakg.LONG),
    FIXED32(6, 1, zzakg.INT),
    BOOL(7, 1, zzakg.BOOLEAN),
    STRING(8, 1, zzakg.STRING),
    MESSAGE(9, 1, zzakg.MESSAGE),
    BYTES(10, 1, zzakg.BYTE_STRING),
    UINT32(11, 1, zzakg.INT),
    ENUM(12, 1, zzakg.ENUM),
    SFIXED32(13, 1, zzakg.INT),
    SFIXED64(14, 1, zzakg.LONG),
    SINT32(15, 1, zzakg.INT),
    SINT64(16, 1, zzakg.LONG),
    GROUP(17, 1, zzakg.MESSAGE),
    DOUBLE_LIST(18, 2, zzakg.DOUBLE),
    FLOAT_LIST(19, 2, zzakg.FLOAT),
    INT64_LIST(20, 2, zzakg.LONG),
    UINT64_LIST(21, 2, zzakg.LONG),
    INT32_LIST(22, 2, zzakg.INT),
    FIXED64_LIST(23, 2, zzakg.LONG),
    FIXED32_LIST(24, 2, zzakg.INT),
    BOOL_LIST(25, 2, zzakg.BOOLEAN),
    STRING_LIST(26, 2, zzakg.STRING),
    MESSAGE_LIST(27, 2, zzakg.MESSAGE),
    BYTES_LIST(28, 2, zzakg.BYTE_STRING),
    UINT32_LIST(29, 2, zzakg.INT),
    ENUM_LIST(30, 2, zzakg.ENUM),
    SFIXED32_LIST(31, 2, zzakg.INT),
    SFIXED64_LIST(32, 2, zzakg.LONG),
    SINT32_LIST(33, 2, zzakg.INT),
    SINT64_LIST(34, 2, zzakg.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzakg.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzakg.FLOAT),
    INT64_LIST_PACKED(37, 3, zzakg.LONG),
    UINT64_LIST_PACKED(38, 3, zzakg.LONG),
    INT32_LIST_PACKED(39, 3, zzakg.INT),
    FIXED64_LIST_PACKED(40, 3, zzakg.LONG),
    FIXED32_LIST_PACKED(41, 3, zzakg.INT),
    BOOL_LIST_PACKED(42, 3, zzakg.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzakg.INT),
    ENUM_LIST_PACKED(44, 3, zzakg.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzakg.INT),
    SFIXED64_LIST_PACKED(46, 3, zzakg.LONG),
    SINT32_LIST_PACKED(47, 3, zzakg.INT),
    SINT64_LIST_PACKED(48, 3, zzakg.LONG),
    GROUP_LIST(49, 2, zzakg.MESSAGE),
    MAP(50, 4, zzakg.VOID);

    private static final zzajf[] zzaa;
    private final int zzZ;

    static {
        zzajf[] zzajfVarArrValues = values();
        zzaa = new zzajf[zzajfVarArrValues.length];
        for (zzajf zzajfVar : zzajfVarArrValues) {
            zzaa[zzajfVar.zzZ] = zzajfVar;
        }
    }

    zzajf(int i, int i2, zzakg zzakgVar) {
        this.zzZ = i;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            zzakgVar.zza();
        }
        if (i2 == 1) {
            zzakg zzakgVar2 = zzakg.VOID;
            zzakgVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzZ;
    }
}
