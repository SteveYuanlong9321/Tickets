package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzlp extends zzajo implements zzakt {
    private static final zzlp zzi;
    private int zzb;
    private long zzg;
    private zzakn zzh = zzakn.zza();
    private String zzd = "";
    private zzaik zze = zzaik.zza;
    private String zzf = "";

    static {
        zzlp zzlpVar = new zzlp();
        zzi = zzlpVar;
        zzajo.zzM(zzlp.class, zzlpVar);
    }

    private zzlp() {
    }

    public static zzlp zzh(zzaio zzaioVar, zzaiz zzaizVar) throws IOException {
        return (zzlp) zzajo.zzV(zzi, zzaioVar, zzaizVar);
    }

    public static zzlp zzi() {
        return zzi;
    }

    public final String zza() {
        return this.zzd;
    }

    public final zzaik zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.nearby.zzajo
    protected final Object zzc(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 2) {
            return zzN(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0001\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u00052", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", zzakm.zza(zzalz.STRING, "", zzalz.MESSAGE, zzli.zzi())});
        }
        if (i2 == 3) {
            return new zzlp();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzlo(bArr);
        }
        if (i2 == 5) {
            return zzi;
        }
        if (i2 != 6) {
            return null;
        }
        return zzajo.zzK(zzlp.class);
    }

    public final String zzd() {
        return this.zzf;
    }

    public final long zze() {
        return this.zzg;
    }

    public final int zzf() {
        return this.zzh.size();
    }

    public final Map zzg() {
        return Collections.unmodifiableMap(this.zzh);
    }
}
