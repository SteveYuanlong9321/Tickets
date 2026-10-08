package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzoj extends zzajo implements zzakt {
    private static final zzoj zzk;
    private int zzb;
    private boolean zze;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private String zzd = "";
    private zzajz zzf = zzQ();

    static {
        zzoj zzojVar = new zzoj();
        zzk = zzojVar;
        zzajo.zzM(zzoj.class, zzojVar);
    }

    private zzoj() {
    }

    public static zzoj zzh(InputStream inputStream, zzaiz zzaizVar) throws IOException {
        return (zzoj) zzajo.zzU(zzk, inputStream, zzaizVar);
    }

    public final String zza() {
        return this.zzd;
    }

    public final boolean zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.nearby.zzajo
    protected final Object zzc(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 2) {
            return zzN(zzk, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003\u001a\u0004᠌\u0002\u0005ဇ\u0003\u0006ဇ\u0005\u0007ဇ\u0004", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", zzahs.zzc(), "zzh", "zzj", "zzi"});
        }
        if (i2 == 3) {
            return new zzoj();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzoi(bArr);
        }
        if (i2 == 5) {
            return zzk;
        }
        if (i2 != 6) {
            return null;
        }
        return zzajo.zzK(zzoj.class);
    }

    public final zzahs zzd() {
        zzahs zzahsVarZzb = zzahs.zzb(this.zzg);
        return zzahsVarZzb == null ? zzahs.UNKNOWN : zzahsVarZzb;
    }

    public final boolean zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        return this.zzj;
    }
}
