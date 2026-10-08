package com.google.android.gms.internal.nearby;

import com.google.android.gms.internal.nearby.zzajj;
import com.google.android.gms.internal.nearby.zzajo;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzajo<MessageT extends zzajo<MessageT, BuilderT>, BuilderT extends zzajj<MessageT, BuilderT>> extends zzahu<MessageT, BuilderT> {
    private static final ConcurrentMap zzd = new ConcurrentHashMap();
    private int zzb = -1;
    protected zzaln zzc = zzaln.zza();

    public static <T extends zzajo<T, ?>> zzakz<T> zzK(Class<T> cls) {
        ConcurrentMap concurrentMap = zzd;
        Object obj = concurrentMap.get(cls);
        if (obj == null) {
            zzL(cls);
            obj = concurrentMap.get(cls);
        }
        if (obj == null) {
            throw new IllegalStateException("Default instance cannot be null.");
        }
        if (obj instanceof zzakz) {
            return (zzakz) obj;
        }
        zzajk zzajkVar = new zzajk((zzajo) obj);
        return concurrentMap.replace(cls, obj, zzajkVar) ? zzajkVar : (zzakz) concurrentMap.get(cls);
    }

    static <T extends zzajo> T zzL(Class<T> cls) {
        ConcurrentMap concurrentMap = zzd;
        Object objZzbg = concurrentMap.get(cls);
        if (objZzbg == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                objZzbg = concurrentMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (objZzbg == null) {
            objZzbg = ((zzajo) zzalt.zza(cls)).zzbg();
            if (objZzbg == null) {
                throw new IllegalStateException();
            }
            concurrentMap.put(cls, objZzbg);
        }
        return objZzbg instanceof zzajo ? (T) objZzbg : (T) ((zzajk) objZzbg).zzc();
    }

    protected static void zzM(Class cls, zzajo zzajoVar) {
        zzajoVar.zzz();
        zzd.put(cls, zzajoVar);
    }

    protected static Object zzN(zzaks zzaksVar, String str, Object[] objArr) {
        return new zzalc(zzaksVar, str, objArr);
    }

    static Object zzO(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static zzajv zzP() {
        return zzajp.zzd();
    }

    protected static zzajz zzQ() {
        return zzalb.zzd();
    }

    protected static zzajz zzR(zzajz zzajzVar) {
        int size = zzajzVar.size();
        return zzajzVar.zzg(size + size);
    }

    static zzajo zzS(zzajo zzajoVar, zzaio zzaioVar, zzaiz zzaizVar) throws zzakf {
        zzajo zzajoVarZzD = zzajoVar.zzD();
        try {
            zzald zzaldVarZzb = zzala.zza().zzb(zzajoVarZzD.getClass());
            zzaldVarZzb.zzg(zzajoVarZzD, zzaip.zza(zzaioVar), zzaizVar);
            zzaldVarZzb.zzk(zzajoVarZzD);
            return zzajoVarZzD;
        } catch (zzakf e) {
            if (e.zzb()) {
                throw new zzakf(e);
            }
            throw e;
        } catch (zzall e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzakf) {
                throw ((zzakf) e3.getCause());
            }
            throw new zzakf(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzakf) {
                throw ((zzakf) e4.getCause());
            }
            throw e4;
        }
    }

    protected static zzajo zzT(zzajo zzajoVar, byte[] bArr, zzaiz zzaizVar) throws zzakf {
        zzajo zzajoVarZzf = zzf(zzajoVar, bArr, 0, bArr.length, zzaizVar);
        zzg(zzajoVarZzf);
        return zzajoVarZzf;
    }

    protected static zzajo zzU(zzajo zzajoVar, InputStream inputStream, zzaiz zzaizVar) throws zzakf {
        zzajo zzajoVarZzS = zzS(zzajoVar, zzaio.zzL(inputStream, 4096), zzaizVar);
        zzg(zzajoVarZzS);
        return zzajoVarZzS;
    }

    protected static zzajo zzV(zzajo zzajoVar, zzaio zzaioVar, zzaiz zzaizVar) throws zzakf {
        zzajo zzajoVarZzS = zzS(zzajoVar, zzaioVar, zzaizVar);
        zzg(zzajoVarZzS);
        return zzajoVarZzS;
    }

    private final int zzd(zzald zzaldVar) {
        if (zzaldVar != null) {
            return zzaldVar.zze(this);
        }
        return zzala.zza().zzb(getClass()).zze(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean zze(zzajo zzajoVar, boolean z) {
        Object objZzc = zzajoVar.zzc(1, null, null);
        if (objZzc == null) {
            return true;
        }
        if (objZzc instanceof Byte) {
            byte bByteValue = ((Byte) objZzc).byteValue();
            if (bByteValue == 1) {
                return true;
            }
            if (bByteValue == 0) {
                return false;
            }
        }
        boolean zZzl = zzala.zza().zzb(zzajoVar.getClass()).zzl(zzajoVar);
        if (z) {
            zzajoVar.zzc(2, true != zZzl ? null : zzajoVar, null);
        }
        return zZzl;
    }

    private static zzajo zzf(zzajo zzajoVar, byte[] bArr, int i, int i2, zzaiz zzaizVar) throws zzakf {
        if (i2 == 0) {
            return zzajoVar;
        }
        zzajo zzajoVarZzD = zzajoVar.zzD();
        try {
            zzald zzaldVarZzb = zzala.zza().zzb(zzajoVarZzD.getClass());
            zzaldVarZzb.zzj(zzajoVarZzD, bArr, 0, i2, new zzahz(zzaizVar));
            zzaldVarZzb.zzk(zzajoVarZzD);
            return zzajoVarZzD;
        } catch (zzakf e) {
            if (e.zzb()) {
                throw new zzakf(e);
            }
            throw e;
        } catch (zzall e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzakf) {
                throw ((zzakf) e3.getCause());
            }
            throw new zzakf(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private static zzajo zzg(zzajo zzajoVar) throws zzakf {
        if (zzajoVar == null || zze(zzajoVar, true)) {
            return zzajoVar;
        }
        throw new zzall(zzajoVar).zza();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzala.zza().zzb(getClass()).zzb(this, (zzajo) obj);
    }

    public final int hashCode() {
        if (zzy()) {
            return zzE();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzE = zzE();
        this.zza = iZzE;
        return iZzE;
    }

    public final String toString() {
        return zzaku.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.nearby.zzaks
    public final zzakz zzA() {
        return (zzakz) zzc(7, null, null);
    }

    @Override // com.google.android.gms.internal.nearby.zzakt
    /* JADX INFO: renamed from: zzB, reason: merged with bridge method [inline-methods] */
    public final zzajo zzbg() {
        return (zzajo) zzc(6, null, null);
    }

    @Override // com.google.android.gms.internal.nearby.zzaks
    /* JADX INFO: renamed from: zzC, reason: merged with bridge method [inline-methods] */
    public final zzajj zzbe() {
        return (zzajj) zzc(5, null, null);
    }

    final zzajo zzD() {
        return (zzajo) zzc(4, null, null);
    }

    final int zzE() {
        return zzala.zza().zzb(getClass()).zzc(this);
    }

    protected final void zzF() {
        zzala.zza().zzb(getClass()).zzk(this);
        zzz();
    }

    protected final zzajj zzG() {
        return (zzajj) zzc(5, null, null);
    }

    public final zzajj zzH() {
        zzajj zzajjVar = (zzajj) zzc(5, null, null);
        zzajjVar.zzo(this);
        return zzajjVar;
    }

    final void zzI(int i) {
        if (i >= 0) {
            this.zzb = i | (this.zzb & Integer.MIN_VALUE);
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 42);
        sb.append("serialized size must be non-negative, was ");
        sb.append(i);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.internal.nearby.zzaks
    public final int zzJ() {
        return zzx(null);
    }

    @Override // com.google.android.gms.internal.nearby.zzaks
    public final void zzbd(zzaiu zzaiuVar) throws IOException {
        zzala.zza().zzb(getClass()).zzf(this, zzaiv.zza(zzaiuVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzakt
    public final boolean zzbf() {
        return zze(this, true);
    }

    protected abstract Object zzc(int i, Object obj, Object obj2);

    final boolean zzy() {
        return this.zzb < 0;
    }

    final void zzz() {
        this.zzb &= Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.nearby.zzahu
    final int zzx(zzald zzaldVar) {
        if (!zzy()) {
            int i = this.zzb & Integer.MAX_VALUE;
            if (i != Integer.MAX_VALUE) {
                return i;
            }
            int iZzd = zzd(zzaldVar);
            zzI(iZzd);
            return iZzd;
        }
        int iZzd2 = zzd(zzaldVar);
        if (iZzd2 >= 0) {
            return iZzd2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(iZzd2).length() + 42);
        sb.append("serialized size must be non-negative, was ");
        sb.append(iZzd2);
        throw new IllegalStateException(sb.toString());
    }
}
