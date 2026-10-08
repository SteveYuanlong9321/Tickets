package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzml extends zzajo implements zzakt {
    private static final zzml zzf;
    private int zzb;
    private String zzd = "";
    private long zze;

    static {
        zzml zzmlVar = new zzml();
        zzf = zzmlVar;
        zzajo.zzM(zzml.class, zzmlVar);
    }

    private zzml() {
    }

    public static zzml zzd() {
        return zzf;
    }

    public final String zza() {
        return this.zzd;
    }

    public final long zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.nearby.zzajo
    protected final Object zzc(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 2) {
            return zzN(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzml();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzmk(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        if (i2 != 6) {
            return null;
        }
        return zzajo.zzK(zzml.class);
    }
}
