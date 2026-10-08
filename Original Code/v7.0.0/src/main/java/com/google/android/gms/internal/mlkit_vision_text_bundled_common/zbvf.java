package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbvf {
    private final zbve zba;

    private zbvf(zbww zbwwVar, Object obj, zbww zbwwVar2, Object obj2) {
        this.zba = new zbve(zbwwVar, obj, zbwwVar2, obj2);
    }

    static int zbb(zbve zbveVar, Object obj, Object obj2) {
        return zbtu.zba(zbveVar.zba, 1, obj) + zbtu.zba(zbveVar.zbc, 2, obj2);
    }

    public static zbvf zbd(zbww zbwwVar, Object obj, zbww zbwwVar2, Object obj2) {
        return new zbvf(zbwwVar, obj, zbwwVar2, obj2);
    }

    static void zbe(zbtk zbtkVar, zbve zbveVar, Object obj, Object obj2) throws IOException {
        zbtu.zbk(zbtkVar, zbveVar.zba, 1, obj);
        zbtu.zbk(zbtkVar, zbveVar.zbc, 2, obj2);
    }

    public final int zba(int i, Object obj, Object obj2) {
        zbve zbveVar = this.zba;
        int iZbD = zbtk.zbD(i << 3);
        int iZbb = zbb(zbveVar, obj, obj2);
        return iZbD + zbtk.zbD(iZbb) + iZbb;
    }

    final zbve zbc() {
        return this.zba;
    }
}
