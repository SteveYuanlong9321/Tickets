package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbws {
    static final long zba;
    static final boolean zbb;
    private static final Unsafe zbc;
    private static final Class zbd;
    private static final boolean zbe;
    private static final zbwr zbf;
    private static final boolean zbg;
    private static final boolean zbh;

    /* JADX WARN: Code duplicated, block: B:11:0x003b  */
    static {
        boolean z;
        boolean z2;
        zbwr zbwrVar;
        Unsafe unsafeZbg = zbg();
        zbc = unsafeZbg;
        int i = zbsm.zba;
        zbd = Memory.class;
        boolean zZbv = zbv(Long.TYPE);
        zbe = zZbv;
        boolean zZbv2 = zbv(Integer.TYPE);
        zbwr zbwpVar = null;
        if (unsafeZbg != null) {
            if (zZbv) {
                zbwpVar = new zbwq(unsafeZbg);
            } else if (zZbv2) {
                zbwpVar = new zbwp(unsafeZbg);
            }
        }
        zbf = zbwpVar;
        if (zbwpVar == null) {
            z = false;
        } else {
            try {
                Class<?> cls = zbwpVar.zba.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                if (zbB() == null) {
                    z = false;
                } else {
                    z = true;
                }
            } catch (Throwable th) {
                zbh(th);
            }
        }
        zbg = z;
        zbwr zbwrVar2 = zbf;
        if (zbwrVar2 == null) {
            z2 = false;
        } else {
            try {
                Class<?> cls2 = zbwrVar2.zba.getClass();
                cls2.getMethod("objectFieldOffset", Field.class);
                cls2.getMethod("arrayBaseOffset", Class.class);
                cls2.getMethod("arrayIndexScale", Class.class);
                cls2.getMethod("getInt", Object.class, Long.TYPE);
                cls2.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
                cls2.getMethod("getLong", Object.class, Long.TYPE);
                cls2.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
                cls2.getMethod("getObject", Object.class, Long.TYPE);
                cls2.getMethod("putObject", Object.class, Long.TYPE, Object.class);
                z2 = true;
            } catch (Throwable th2) {
                zbh(th2);
                z2 = false;
            }
        }
        zbh = z2;
        zba = zbz(byte[].class);
        zbz(boolean[].class);
        zbA(boolean[].class);
        zbz(int[].class);
        zbA(int[].class);
        zbz(long[].class);
        zbA(long[].class);
        zbz(float[].class);
        zbA(float[].class);
        zbz(double[].class);
        zbA(double[].class);
        zbz(Object[].class);
        zbA(Object[].class);
        Field fieldZbB = zbB();
        if (fieldZbB != null && (zbwrVar = zbf) != null) {
            zbwrVar.zba.objectFieldOffset(fieldZbB);
        }
        zbb = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zbws() {
    }

    private static int zbA(Class cls) {
        if (zbh) {
            return zbf.zba.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zbB() {
        int i = zbsm.zba;
        Field fieldZbC = zbC(Buffer.class, "effectiveDirectAddress");
        if (fieldZbC != null) {
            return fieldZbC;
        }
        Field fieldZbC2 = zbC(Buffer.class, "address");
        if (fieldZbC2 == null || fieldZbC2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZbC2;
    }

    private static Field zbC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zbD(Object obj, long j, byte b) {
        zbwr zbwrVar = zbf;
        long j2 = (-4) & j;
        int i = zbwrVar.zba.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        zbwrVar.zba.putInt(obj, j2, ((255 & b) << i2) | (i & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zbE(Object obj, long j, byte b) {
        zbwr zbwrVar = zbf;
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        zbwrVar.zba.putInt(obj, j2, ((255 & b) << i) | (zbwrVar.zba.getInt(obj, j2) & (~(255 << i))));
    }

    static double zba(Object obj, long j) {
        return zbf.zba(obj, j);
    }

    static float zbb(Object obj, long j) {
        return zbf.zbb(obj, j);
    }

    static int zbc(Object obj, long j) {
        return zbf.zba.getInt(obj, j);
    }

    static long zbd(Object obj, long j) {
        return zbf.zba.getLong(obj, j);
    }

    static Object zbe(Class cls) {
        try {
            return zbc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    static Object zbf(Object obj, long j) {
        return zbf.zba.getObject(obj, j);
    }

    static Unsafe zbg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zbwo());
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* bridge */ /* synthetic */ void zbh(Throwable th) {
        Logger.getLogger(zbws.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    static void zbm(Object obj, long j, boolean z) {
        zbf.zbc(obj, j, z);
    }

    static void zbn(byte[] bArr, long j, byte b) {
        zbf.zbd(bArr, zba + j, b);
    }

    static void zbo(Object obj, long j, double d) {
        zbf.zbe(obj, j, d);
    }

    static void zbp(Object obj, long j, float f) {
        zbf.zbf(obj, j, f);
    }

    static void zbq(Object obj, long j, int i) {
        zbf.zba.putInt(obj, j, i);
    }

    static void zbr(Object obj, long j, long j2) {
        zbf.zba.putLong(obj, j, j2);
    }

    static void zbs(Object obj, long j, Object obj2) {
        zbf.zba.putObject(obj, j, obj2);
    }

    static /* bridge */ /* synthetic */ boolean zbt(Object obj, long j) {
        return ((byte) ((zbf.zba.getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    static /* bridge */ /* synthetic */ boolean zbu(Object obj, long j) {
        return ((byte) ((zbf.zba.getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    static boolean zbv(Class cls) {
        int i = zbsm.zba;
        try {
            Class cls2 = zbd;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean zbw(Object obj, long j) {
        return zbf.zbg(obj, j);
    }

    static boolean zbx() {
        return zbh;
    }

    static boolean zby() {
        return zbg;
    }

    private static int zbz(Class cls) {
        if (zbh) {
            return zbf.zba.arrayBaseOffset(cls);
        }
        return -1;
    }
}
