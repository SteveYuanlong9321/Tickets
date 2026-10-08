package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbkj {
    public static int zba(int i, int i2, String str) {
        String strZba;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strZba = zbkp.zba("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException("negative size: " + i2);
            }
            strZba = zbkp.zba("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strZba);
    }

    public static int zbb(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(zbe(i, i2, "index"));
        }
        return i;
    }

    public static void zbc(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void zbd(int i, int i2, int i3) {
        String strZbe;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strZbe = zbe(i, i3, "start index");
            } else {
                strZbe = (i2 < 0 || i2 > i3) ? zbe(i2, i3, "end index") : zbkp.zba("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strZbe);
        }
    }

    private static String zbe(int i, int i2, String str) {
        if (i < 0) {
            return zbkp.zba("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return zbkp.zba("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }
}
