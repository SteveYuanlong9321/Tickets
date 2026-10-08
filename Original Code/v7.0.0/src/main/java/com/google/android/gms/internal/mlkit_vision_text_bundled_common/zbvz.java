package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbvz {
    public static final /* synthetic */ int zba = 0;
    private static final zbwl zbb;

    static {
        int i = zbvu.zba;
        zbb = new zbwn();
    }

    public static void zbA(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbD(i, list, z);
    }

    public static void zbB(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbF(i, list, z);
    }

    public static void zbC(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbK(i, list, z);
    }

    public static void zbD(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbM(i, list, z);
    }

    static boolean zbE(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zba(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zbug)) {
            int iZbE = 0;
            while (i < size) {
                iZbE += zbtk.zbE(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZbE;
        }
        zbug zbugVar = (zbug) list;
        int iZbE2 = 0;
        while (i < size) {
            iZbE2 += zbtk.zbE(zbugVar.zbe(i));
            i++;
        }
        return iZbE2;
    }

    static int zbb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zbtk.zbD(i << 3) + 4);
    }

    static int zbc(List list) {
        return list.size() * 4;
    }

    static int zbd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zbtk.zbD(i << 3) + 8);
    }

    static int zbe(List list) {
        return list.size() * 8;
    }

    static int zbf(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zbug)) {
            int iZbE = 0;
            while (i < size) {
                iZbE += zbtk.zbE(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZbE;
        }
        zbug zbugVar = (zbug) list;
        int iZbE2 = 0;
        while (i < size) {
            iZbE2 += zbtk.zbE(zbugVar.zbe(i));
            i++;
        }
        return iZbE2;
    }

    static int zbg(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zbva)) {
            int iZbE = 0;
            while (i < size) {
                iZbE += zbtk.zbE(((Long) list.get(i)).longValue());
                i++;
            }
            return iZbE;
        }
        zbva zbvaVar = (zbva) list;
        int iZbE2 = 0;
        while (i < size) {
            iZbE2 += zbtk.zbE(zbvaVar.zbe(i));
            i++;
        }
        return iZbE2;
    }

    static int zbh(int i, Object obj, zbvx zbvxVar) {
        int i2 = i << 3;
        if (!(obj instanceof zbuw)) {
            return zbtk.zbD(i2) + zbtk.zbB((zbvm) obj, zbvxVar);
        }
        int iZbD = zbtk.zbD(i2);
        int iZba = ((zbuw) obj).zba();
        return iZbD + zbtk.zbD(iZba) + iZba;
    }

    static int zbi(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zbug)) {
            int iZbD = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZbD += zbtk.zbD((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iZbD;
        }
        zbug zbugVar = (zbug) list;
        int iZbD2 = 0;
        while (i < size) {
            int iZbe = zbugVar.zbe(i);
            iZbD2 += zbtk.zbD((iZbe >> 31) ^ (iZbe + iZbe));
            i++;
        }
        return iZbD2;
    }

    static int zbj(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zbva)) {
            int iZbE = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZbE += zbtk.zbE((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
            return iZbE;
        }
        zbva zbvaVar = (zbva) list;
        int iZbE2 = 0;
        while (i < size) {
            long jZbe = zbvaVar.zbe(i);
            iZbE2 += zbtk.zbE((jZbe >> 63) ^ (jZbe + jZbe));
            i++;
        }
        return iZbE2;
    }

    static int zbk(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zbug)) {
            int iZbD = 0;
            while (i < size) {
                iZbD += zbtk.zbD(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZbD;
        }
        zbug zbugVar = (zbug) list;
        int iZbD2 = 0;
        while (i < size) {
            iZbD2 += zbtk.zbD(zbugVar.zbe(i));
            i++;
        }
        return iZbD2;
    }

    static int zbl(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zbva)) {
            int iZbE = 0;
            while (i < size) {
                iZbE += zbtk.zbE(((Long) list.get(i)).longValue());
                i++;
            }
            return iZbE;
        }
        zbva zbvaVar = (zbva) list;
        int iZbE2 = 0;
        while (i < size) {
            iZbE2 += zbtk.zbE(zbvaVar.zbe(i));
            i++;
        }
        return iZbE2;
    }

    public static zbwl zbm() {
        return zbb;
    }

    static Object zbn(Object obj, int i, int i2, Object obj2, zbwl zbwlVar) {
        if (obj2 == null) {
            obj2 = zbwlVar.zba(obj);
        }
        ((zbwm) obj2).zbj(i << 3, Long.valueOf(i2));
        return obj2;
    }

    static void zbo(zbtq zbtqVar, Object obj, Object obj2) {
        zbtu zbtuVar = ((zbub) obj2).zbb;
        if (zbtuVar.zba.isEmpty()) {
            return;
        }
        ((zbub) obj).zbg().zbi(zbtuVar);
    }

    static void zbp(zbwl zbwlVar, Object obj, Object obj2) {
        zbuf zbufVar = (zbuf) obj;
        zbwm zbwmVarZbe = zbufVar.zbc;
        zbwm zbwmVar = ((zbuf) obj2).zbc;
        if (!zbwm.zbc().equals(zbwmVar)) {
            if (zbwm.zbc().equals(zbwmVarZbe)) {
                zbwmVarZbe = zbwm.zbe(zbwmVarZbe, zbwmVar);
            } else {
                zbwmVarZbe.zbd(zbwmVar);
            }
        }
        zbufVar.zbc = zbwmVarZbe;
    }

    public static void zbq(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbc(i, list, z);
    }

    public static void zbr(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbg(i, list, z);
    }

    public static void zbs(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbj(i, list, z);
    }

    public static void zbt(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbl(i, list, z);
    }

    public static void zbu(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbn(i, list, z);
    }

    public static void zbv(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbp(i, list, z);
    }

    public static void zbw(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbs(i, list, z);
    }

    public static void zbx(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbu(i, list, z);
    }

    public static void zby(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbz(i, list, z);
    }

    public static void zbz(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbB(i, list, z);
    }
}
