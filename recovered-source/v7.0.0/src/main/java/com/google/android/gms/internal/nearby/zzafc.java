package com.google.android.gms.internal.nearby;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.google.android.gms.internal.mlkit_vision_barcode.zzec$$ExternalSyntheticBackportWithForwarding0;
import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzafc<V> extends zzahq implements zzagx<V> {
    private static final zza zza;
    static final Object zze = new Object();
    static final zzagw zzf = new zzagw(zzafb.class);
    static final boolean zzg;
    volatile zzafb.zzd listenersField;
    volatile Object valueField;
    volatile zze waitersField;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    abstract class zza {
        /* synthetic */ zza(byte[] bArr) {
        }

        abstract void zza(zze zzeVar, Thread thread);

        abstract void zzb(zze zzeVar, zze zzeVar2);

        abstract boolean zzc(zzafc zzafcVar, zze zzeVar, zze zzeVar2);

        abstract boolean zzd(zzafc zzafcVar, zzafb.zzd zzdVar, zzafb.zzd zzdVar2);

        abstract zze zze(zzafc zzafcVar, zze zzeVar);

        abstract zzafb.zzd zzf(zzafc zzafcVar, zzafb.zzd zzdVar);

        abstract boolean zzg(zzafc zzafcVar, Object obj, Object obj2);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    final class zzb extends zza {
        private static final AtomicReferenceFieldUpdater<zze, Thread> zza = AtomicReferenceFieldUpdater.newUpdater(zze.class, Thread.class, "thread");
        private static final AtomicReferenceFieldUpdater<zze, zze> zzb = AtomicReferenceFieldUpdater.newUpdater(zze.class, zze.class, "next");
        private static final AtomicReferenceFieldUpdater<? super zzafc<?>, zze> zzc = AtomicReferenceFieldUpdater.newUpdater(zzafc.class, zze.class, "waitersField");
        private static final AtomicReferenceFieldUpdater<? super zzafc<?>, zzafb.zzd> zzd = AtomicReferenceFieldUpdater.newUpdater(zzafc.class, zzafb.zzd.class, "listenersField");
        private static final AtomicReferenceFieldUpdater<? super zzafc<?>, Object> zze = AtomicReferenceFieldUpdater.newUpdater(zzafc.class, Object.class, "valueField");

        private zzb() {
            throw null;
        }

        /* synthetic */ zzb(byte[] bArr) {
            super(null);
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final void zza(zze zzeVar, Thread thread) {
            zza.lazySet(zzeVar, thread);
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final void zzb(zze zzeVar, zze zzeVar2) {
            zzb.lazySet(zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final boolean zzc(zzafc zzafcVar, zze zzeVar, zze zzeVar2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(zzc, zzafcVar, zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final boolean zzd(zzafc zzafcVar, zzafb.zzd zzdVar, zzafb.zzd zzdVar2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(zzd, zzafcVar, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final zze zze(zzafc zzafcVar, zze zzeVar) {
            return zzc.getAndSet(zzafcVar, zzeVar);
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final zzafb.zzd zzf(zzafc zzafcVar, zzafb.zzd zzdVar) {
            return zzd.getAndSet(zzafcVar, zzdVar);
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final boolean zzg(zzafc zzafcVar, Object obj, Object obj2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(zze, zzafcVar, obj, obj2);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    final class zzc extends zza {
        private zzc() {
            throw null;
        }

        /* synthetic */ zzc(byte[] bArr) {
            super(null);
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final void zza(zze zzeVar, Thread thread) {
            zzeVar.thread = thread;
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final void zzb(zze zzeVar, zze zzeVar2) {
            zzeVar.next = zzeVar2;
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final boolean zzc(zzafc zzafcVar, zze zzeVar, zze zzeVar2) {
            synchronized (zzafcVar) {
                if (zzafcVar.waitersField != zzeVar) {
                    return false;
                }
                zzafcVar.waitersField = zzeVar2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final boolean zzd(zzafc zzafcVar, zzafb.zzd zzdVar, zzafb.zzd zzdVar2) {
            synchronized (zzafcVar) {
                if (zzafcVar.listenersField != zzdVar) {
                    return false;
                }
                zzafcVar.listenersField = zzdVar2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final zze zze(zzafc zzafcVar, zze zzeVar) {
            zze zzeVar2;
            synchronized (zzafcVar) {
                zzeVar2 = zzafcVar.waitersField;
                if (zzeVar2 != zzeVar) {
                    zzafcVar.waitersField = zzeVar;
                }
            }
            return zzeVar2;
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final zzafb.zzd zzf(zzafc zzafcVar, zzafb.zzd zzdVar) {
            zzafb.zzd zzdVar2;
            synchronized (zzafcVar) {
                zzdVar2 = zzafcVar.listenersField;
                if (zzdVar2 != zzdVar) {
                    zzafcVar.listenersField = zzdVar;
                }
            }
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final boolean zzg(zzafc zzafcVar, Object obj, Object obj2) {
            synchronized (zzafcVar) {
                if (zzafcVar.valueField != obj) {
                    return false;
                }
                zzafcVar.valueField = obj2;
                return true;
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    final class zzd extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        static {
            Unsafe unsafeZzi;
            try {
                try {
                    unsafeZzi = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    try {
                        unsafeZzi = (Unsafe) Class.forName("java.security.AccessController").getMethod("doPrivileged", PrivilegedExceptionAction.class).invoke(null, zzafd.zza);
                    } catch (Exception unused2) {
                        unsafeZzi = zzi();
                        Unsafe unsafe = unsafeZzi;
                    }
                }
                try {
                    zzc = unsafeZzi.objectFieldOffset(zzafc.class.getDeclaredField("waitersField"));
                    zzb = unsafeZzi.objectFieldOffset(zzafc.class.getDeclaredField("listenersField"));
                    zzd = unsafeZzi.objectFieldOffset(zzafc.class.getDeclaredField("valueField"));
                    zze = unsafeZzi.objectFieldOffset(zze.class.getDeclaredField("thread"));
                    zzf = unsafeZzi.objectFieldOffset(zze.class.getDeclaredField("next"));
                    zza = unsafeZzi;
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            } catch (Exception e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2);
            }
        }

        private zzd() {
            throw null;
        }

        /* synthetic */ zzd(byte[] bArr) {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Unsafe zzi() throws Exception {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final void zza(zze zzeVar, Thread thread) {
            zza.putObject(zzeVar, zze, thread);
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final void zzb(zze zzeVar, zze zzeVar2) {
            zza.putObject(zzeVar, zzf, zzeVar2);
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final boolean zzc(zzafc zzafcVar, zze zzeVar, zze zzeVar2) {
            return zzec$$ExternalSyntheticBackportWithForwarding0.m(zza, zzafcVar, zzc, zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final boolean zzd(zzafc zzafcVar, zzafb.zzd zzdVar, zzafb.zzd zzdVar2) {
            return zzec$$ExternalSyntheticBackportWithForwarding0.m(zza, zzafcVar, zzb, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final zze zze(zzafc zzafcVar, zze zzeVar) {
            zze zzeVar2;
            do {
                zzeVar2 = zzafcVar.waitersField;
                if (zzeVar == zzeVar2) {
                    break;
                }
            } while (!zzc(zzafcVar, zzeVar2, zzeVar));
            return zzeVar2;
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final zzafb.zzd zzf(zzafc zzafcVar, zzafb.zzd zzdVar) {
            zzafb.zzd zzdVar2;
            do {
                zzdVar2 = zzafcVar.listenersField;
                if (zzdVar == zzdVar2) {
                    break;
                }
            } while (!zzd(zzafcVar, zzdVar2, zzdVar));
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.nearby.zzafc.zza
        final boolean zzg(zzafc zzafcVar, Object obj, Object obj2) {
            return zzec$$ExternalSyntheticBackportWithForwarding0.m(zza, zzafcVar, zzd, obj, obj2);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    final class zze {
        static final zze zza = new zze(false);
        volatile zze next;
        volatile Thread thread;

        zze() {
            zzafc.zzw(this, Thread.currentThread());
        }

        zze(boolean z) {
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zza zzcVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        zzg = z;
        String property = System.getProperty("java.runtime.name", "");
        byte[] bArr = null;
        if (property == null || property.contains("Android")) {
            try {
                zzcVar = new zzd(bArr);
            } catch (Error | Exception e) {
                try {
                    zzcVar = new zzb(bArr);
                    th = null;
                    th2 = e;
                } catch (Error | Exception e2) {
                    th = e2;
                    th2 = e;
                    zzcVar = new zzc(bArr);
                }
            }
        } else {
            try {
                zzcVar = new zzb(bArr);
            } catch (NoClassDefFoundError unused2) {
                zzcVar = new zzc(bArr);
            }
        }
        th = null;
        th2 = null;
        zza = zzcVar;
        if (th != null) {
            zzagw zzagwVar = zzf;
            zzagwVar.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            zzagwVar.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "AtomicReferenceFieldUpdaterAtomicHelper is broken!", th);
        }
    }

    zzafc() {
    }

    private final void zza(zze zzeVar) {
        zzeVar.thread = null;
        while (true) {
            zze zzeVar2 = this.waitersField;
            if (zzeVar2 != zze.zza) {
                zze zzeVar3 = null;
                while (zzeVar2 != null) {
                    zze zzeVar4 = zzeVar2.next;
                    if (zzeVar2.thread != null) {
                        zzeVar3 = zzeVar2;
                    } else if (zzeVar3 != null) {
                        zzeVar3.next = zzeVar4;
                        if (zzeVar3.thread == null) {
                        }
                    } else if (!zza.zzc(this, zzeVar2, zzeVar4)) {
                    }
                    zzeVar2 = zzeVar4;
                }
                return;
            }
            return;
        }
    }

    static boolean zzs(zzafc zzafcVar, Object obj, Object obj2) {
        return zza.zzg(zzafcVar, obj, obj2);
    }

    static /* synthetic */ void zzw(zze zzeVar, Thread thread) {
        zza.zza(zzeVar, thread);
    }

    final boolean zzq(zzafb.zzd zzdVar, zzafb.zzd zzdVar2) {
        return zza.zzd(this, zzdVar, zzdVar2);
    }

    final zzafb.zzd zzr(zzafb.zzd zzdVar) {
        return zza.zzf(this, zzdVar);
    }

    final void zzt() {
        for (zze zzeVarZze = zza.zze(this, zze.zza); zzeVarZze != null; zzeVarZze = zzeVarZze.next) {
            Thread thread = zzeVarZze.thread;
            if (thread != null) {
                zzeVarZze.thread = null;
                LockSupport.unpark(thread);
            }
        }
    }

    final Object zzu(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.valueField;
        if ((obj != null) && zzafb.zzi(obj)) {
            return zzafb.zzh(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            zze zzeVar = this.waitersField;
            if (zzeVar != zze.zza) {
                zze zzeVar2 = new zze();
                while (true) {
                    zza zzaVar = zza;
                    zzaVar.zzb(zzeVar2, zzeVar);
                    if (zzaVar.zzc(this, zzeVar, zzeVar2)) {
                        do {
                            LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                            if (Thread.interrupted()) {
                                zza(zzeVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.valueField;
                            if ((obj2 != null) && zzafb.zzi(obj2)) {
                                return zzafb.zzh(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        zza(zzeVar2);
                        break;
                    }
                    zzeVar = this.waitersField;
                    if (zzeVar == zze.zza) {
                    }
                }
            }
            return zzafb.zzh(Objects.requireNonNull(this.valueField));
        }
        while (nanos > 0) {
            Object obj3 = this.valueField;
            if ((obj3 != null) && zzafb.zzi(obj3)) {
                return zzafb.zzh(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
        String lowerCase2 = timeUnit.toString().toLowerCase(Locale.ROOT);
        StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 8 + String.valueOf(lowerCase2).length());
        sb.append("Waited ");
        sb.append(j);
        sb.append(" ");
        sb.append(lowerCase2);
        String string2 = sb.toString();
        if (nanos + 1000 < 0) {
            String strConcat = string2.concat(" (plus ");
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                StringBuilder sb2 = new StringBuilder(strConcat.length() + String.valueOf(jConvert).length() + 1 + String.valueOf(lowerCase).length());
                sb2.append(strConcat);
                sb2.append(jConvert);
                sb2.append(" ");
                sb2.append(lowerCase);
                String string3 = sb2.toString();
                if (z) {
                    string3 = string3.concat(",");
                }
                strConcat = string3.concat(" ");
            }
            if (z) {
                StringBuilder sb3 = new StringBuilder(strConcat.length() + String.valueOf(nanos2).length() + 13);
                sb3.append(strConcat);
                sb3.append(nanos2);
                sb3.append(" nanoseconds ");
                strConcat = sb3.toString();
            }
            string2 = strConcat.concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(string2.concat(" but future completed as timeout expired"));
        }
        StringBuilder sb4 = new StringBuilder(string2.length() + 5 + String.valueOf(string).length());
        sb4.append(string2);
        sb4.append(" for ");
        sb4.append(string);
        throw new TimeoutException(sb4.toString());
    }

    final Object zzv() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.valueField;
        if ((obj2 != null) && zzafb.zzi(obj2)) {
            return zzafb.zzh(obj2);
        }
        zze zzeVar = this.waitersField;
        if (zzeVar != zze.zza) {
            zze zzeVar2 = new zze();
            do {
                zza zzaVar = zza;
                zzaVar.zzb(zzeVar2, zzeVar);
                if (zzaVar.zzc(this, zzeVar, zzeVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zza(zzeVar2);
                            throw new InterruptedException();
                        }
                        obj = this.valueField;
                    } while (!((obj != null) & zzafb.zzi(obj)));
                    return zzafb.zzh(obj);
                }
                zzeVar = this.waitersField;
            } while (zzeVar != zze.zza);
        }
        return zzafb.zzh(Objects.requireNonNull(this.valueField));
    }
}
