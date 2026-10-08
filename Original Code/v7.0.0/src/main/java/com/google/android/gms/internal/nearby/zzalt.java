package com.google.android.gms.internal.nearby;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalt {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class zzc;
    private static final boolean zzd;
    private static final zzals zze;
    private static final boolean zzf;

    static {
        boolean z;
        zzals zzalsVar;
        Unsafe unsafeZzn = zzn();
        zzb = unsafeZzn;
        int i = zzahy.zza;
        zzc = Memory.class;
        boolean zZzo = zzo(Long.TYPE);
        zzd = zZzo;
        boolean zZzo2 = zzo(Integer.TYPE);
        zzals zzalqVar = null;
        if (unsafeZzn != null) {
            if (zZzo) {
                zzalqVar = new zzalr(unsafeZzn);
            } else if (zZzo2) {
                zzalqVar = new zzalq(unsafeZzn);
            }
        }
        zze = zzalqVar;
        if (zzalqVar != null) {
            try {
                Class<?> cls = zzalqVar.zza.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                zzw();
            } catch (Throwable th) {
                zzt(th);
            }
        }
        zzals zzalsVar2 = zze;
        if (zzalsVar2 == null) {
            z = false;
        } else {
            try {
                Class<?> cls2 = zzalsVar2.zza.getClass();
                cls2.getMethod("objectFieldOffset", Field.class);
                cls2.getMethod("arrayBaseOffset", Class.class);
                cls2.getMethod("arrayIndexScale", Class.class);
                cls2.getMethod("getInt", Object.class, Long.TYPE);
                cls2.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
                cls2.getMethod("getLong", Object.class, Long.TYPE);
                cls2.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
                cls2.getMethod("getObject", Object.class, Long.TYPE);
                cls2.getMethod("putObject", Object.class, Long.TYPE, Object.class);
                z = true;
            } catch (Throwable th2) {
                zzt(th2);
                z = false;
            }
        }
        zzf = z;
        zzu(byte[].class);
        zzu(boolean[].class);
        zzv(boolean[].class);
        zzu(int[].class);
        zzv(int[].class);
        zzu(long[].class);
        zzv(long[].class);
        zzu(float[].class);
        zzv(float[].class);
        zzu(double[].class);
        zzv(double[].class);
        zzu(Object[].class);
        zzv(Object[].class);
        Field fieldZzw = zzw();
        if (fieldZzw != null && (zzalsVar = zze) != null) {
            zzalsVar.zza.objectFieldOffset(fieldZzw);
        }
        zza = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzalt() {
    }

    static Object zza(Class cls) {
        try {
            return zzb.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    static int zzb(Object obj, long j) {
        return zze.zza.getInt(obj, j);
    }

    static void zzc(Object obj, long j, int i) {
        zze.zza.putInt(obj, j, i);
    }

    static long zzd(Object obj, long j) {
        return zze.zza.getLong(obj, j);
    }

    static void zze(Object obj, long j, long j2) {
        zze.zza.putLong(obj, j, j2);
    }

    static boolean zzf(Object obj, long j) {
        return zze.zza(obj, j);
    }

    static void zzg(Object obj, long j, boolean z) {
        zze.zzb(obj, j, z);
    }

    static float zzh(Object obj, long j) {
        return zze.zzc(obj, j);
    }

    static void zzi(Object obj, long j, float f) {
        zze.zzd(obj, j, f);
    }

    static double zzj(Object obj, long j) {
        return zze.zze(obj, j);
    }

    static void zzk(Object obj, long j, double d) {
        zze.zzf(obj, j, d);
    }

    static Object zzl(Object obj, long j) {
        return zze.zza.getObject(obj, j);
    }

    static void zzm(Object obj, long j, Object obj2) {
        zze.zza.putObject(obj, j, obj2);
    }

    static Unsafe zzn() {
        Unsafe unsafe;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new zzalp());
        } catch (Throwable unused) {
            unsafe = null;
        }
        if (unsafe == null) {
            return null;
        }
        try {
            unsafe.arrayBaseOffset(byte[].class);
            return unsafe;
        } catch (Exception unused2) {
            Logger.getLogger(zzalt.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "getUnsafe", "As part of the planned removal, sun.misc.Unsafe is available in the current environment but configured to throw on use. Protobuf will continue without using it, but with slightly reduced performance. --sun-misc-unsafe-memory-access=allow is likely available to opt back in if desired. A later Protobuf version release will stop using sun.misc.Unsafe entirely.");
            return null;
        }
    }

    static boolean zzo(Class cls) {
        int i = zzahy.zza;
        try {
            Class cls2 = zzc;
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

    static /* synthetic */ boolean zzp(Object obj, long j) {
        return ((byte) ((zze.zza.getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    static /* synthetic */ boolean zzq(Object obj, long j) {
        return ((byte) ((zze.zza.getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    static /* synthetic */ void zzr(Object obj, long j, boolean z) {
        Unsafe unsafe = zze.zza;
        long j2 = (-4) & j;
        int i = unsafe.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        unsafe.putInt(obj, j2, ((z ? 1 : 0) << i2) | ((~(255 << i2)) & i));
    }

    static /* synthetic */ void zzs(Object obj, long j, boolean z) {
        Unsafe unsafe = zze.zza;
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        unsafe.putInt(obj, j2, ((z ? 1 : 0) << i) | ((~(255 << i)) & unsafe.getInt(obj, j2)));
    }

    static /* synthetic */ void zzt(Throwable th) {
        Logger.getLogger(zzalt.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    private static int zzu(Class cls) {
        if (zzf) {
            return zze.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzv(Class cls) {
        if (zzf) {
            return zze.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzw() {
        int i = zzahy.zza;
        Field fieldZzx = zzx(Buffer.class, "effectiveDirectAddress");
        if (fieldZzx != null) {
            return fieldZzx;
        }
        Field fieldZzx2 = zzx(Buffer.class, "address");
        if (fieldZzx2 == null || fieldZzx2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzx2;
    }

    private static Field zzx(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
