package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzaio {
    public static final /* synthetic */ int zze = 0;
    private static volatile int zzf = 100;
    int zza;
    int zzb;
    final int zzc = zzf;
    Object zzd;

    private zzaio() {
    }

    /* synthetic */ zzaio(byte[] bArr) {
    }

    public static zzaio zzL(InputStream inputStream, int i) {
        return inputStream == null ? zzM(zzaka.zza, 0, 0, false) : new zzain(inputStream, 4096, null);
    }

    static zzaio zzM(byte[] bArr, int i, int i2, boolean z) {
        zzaim zzaimVar = new zzaim(bArr, 0, 0, false, null);
        try {
            zzaimVar.zzC(0);
            return zzaimVar;
        } catch (zzakf e) {
            throw new IllegalArgumentException(e);
        }
    }

    static /* synthetic */ void zzQ(byte[] bArr, int i, int i2) {
        if ((bArr.length - i) - i2 < 0 || (i | i2) < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public abstract int zzC(int i) throws zzakf;

    public abstract void zzD(int i);

    public abstract int zzE();

    public abstract boolean zzF() throws IOException;

    public abstract int zzG();

    public abstract int zzJ(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzK(int i) throws IOException;

    public final void zzN() throws zzakf {
        if (this.zza + this.zzb >= this.zzc) {
            throw new zzakf("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }

    public final void zzO() throws zzakf {
        if (this.zzb == 0) {
            zzb(0);
        }
    }

    public final void zzP() throws IOException {
        boolean zZzc;
        do {
            int iZza = zza();
            if (iZza == 0) {
                return;
            }
            zzN();
            this.zzb++;
            zZzc = zzc(iZza);
            this.zzb--;
        } while (zZzc);
    }

    public abstract int zza() throws IOException;

    public abstract void zzb(int i) throws zzakf;

    public abstract boolean zzc(int i) throws IOException;

    public abstract double zzd() throws IOException;

    public abstract float zze() throws IOException;

    public abstract long zzf() throws IOException;

    public abstract long zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract long zzi() throws IOException;

    public abstract int zzj() throws IOException;

    public abstract boolean zzk() throws IOException;

    public abstract String zzl() throws IOException;

    public abstract String zzm() throws IOException;

    public abstract zzaik zzn() throws IOException;

    public abstract byte[] zzo() throws IOException;

    public abstract int zzp() throws IOException;

    public abstract int zzq() throws IOException;

    public abstract int zzr() throws IOException;

    public abstract long zzs() throws IOException;

    public abstract int zzt() throws IOException;

    public abstract long zzu() throws IOException;

    public abstract int zzx() throws IOException;

    public abstract long zzz() throws IOException;
}
