package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmh extends zzajo implements zzakt {
    private static final zzajw zzk = new zzmf();
    private static final zzmh zzq;
    private int zzb;
    private boolean zze;
    private long zzg;
    private zzml zzl;
    private boolean zzm;
    private boolean zzn;
    private zzme zzo;
    private boolean zzp;
    private zzaik zzd = zzaik.zza;
    private String zzf = "";
    private zzajz zzh = zzQ();
    private zzajz zzi = zzQ();
    private zzajv zzj = zzP();

    static {
        zzmh zzmhVar = new zzmh();
        zzq = zzmhVar;
        zzajo.zzM(zzmh.class, zzmhVar);
    }

    private zzmh() {
    }

    public static zzmh zzp(InputStream inputStream, zzaiz zzaizVar) throws IOException {
        return (zzmh) zzajo.zzU(zzq, inputStream, zzaizVar);
    }

    public static zzmg zzq() {
        return (zzmg) zzq.zzG();
    }

    public static zzmh zzr() {
        return zzq;
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final zzaik zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.nearby.zzajo
    protected final Object zzc(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 2) {
            return zzN(zzq, "\u0004\f\u0000\u0001\u0001\r\f\u0000\u0003\u0000\u0001ည\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005\u001a\u0006\u001a\u0007ࠬ\bဉ\u0004\nဇ\u0005\u000bဇ\u0006\fဉ\u0007\rဇ\b", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzahs.zzc(), "zzl", "zzm", "zzn", "zzo", "zzp"});
        }
        if (i2 == 3) {
            return new zzmh();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzmg(bArr);
        }
        if (i2 == 5) {
            return zzq;
        }
        if (i2 != 6) {
            return null;
        }
        return zzajo.zzK(zzmh.class);
    }

    public final boolean zzd() {
        return this.zze;
    }

    public final String zze() {
        return this.zzf;
    }

    public final long zzf() {
        return this.zzg;
    }

    public final List zzg() {
        return this.zzh;
    }

    public final List zzh() {
        return this.zzi;
    }

    public final List zzi() {
        return new zzajx(this.zzj, zzk);
    }

    public final boolean zzj() {
        return (this.zzb & 16) != 0;
    }

    public final zzml zzk() {
        zzml zzmlVar = this.zzl;
        return zzmlVar == null ? zzml.zzd() : zzmlVar;
    }

    public final boolean zzl() {
        return this.zzm;
    }

    public final boolean zzm() {
        return this.zzn;
    }

    public final zzme zzn() {
        zzme zzmeVar = this.zzo;
        return zzmeVar == null ? zzme.zzb() : zzmeVar;
    }

    public final boolean zzo() {
        return this.zzp;
    }

    final /* synthetic */ void zzs(long j) {
        this.zzb |= 8;
        this.zzg = j;
    }
}
