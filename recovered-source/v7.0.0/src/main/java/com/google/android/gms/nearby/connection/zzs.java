package com.google.android.gms.nearby.connection;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public interface zzs {
    static String zza(int i) {
        if (i == 0) {
            return "UNKNOWN";
        }
        if (i != 1) {
            return i != 2 ? "OTHER" : "Secondary";
        }
        return "Main";
    }
}
