package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
enum zzadj {
    BOOLEAN,
    STRING,
    LONG,
    DOUBLE;

    static /* synthetic */ zzadj zza(Object obj) {
        if (obj instanceof String) {
            return STRING;
        }
        if (obj instanceof Boolean) {
            return BOOLEAN;
        }
        if (obj instanceof Long) {
            return LONG;
        }
        if (obj instanceof Double) {
            return DOUBLE;
        }
        String strValueOf = String.valueOf(obj.getClass());
        String.valueOf(strValueOf);
        throw new AssertionError("invalid tag type: ".concat(String.valueOf(strValueOf)));
    }
}
