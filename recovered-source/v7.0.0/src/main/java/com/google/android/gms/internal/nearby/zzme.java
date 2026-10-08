package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzme extends zzajo implements zzakt {
    private static final zzme zze;
    private int zzb;
    private boolean zzd;

    static {
        zzme zzmeVar = new zzme();
        zze = zzmeVar;
        zzajo.zzM(zzme.class, zzmeVar);
    }

    private zzme() {
    }

    public static zzme zzb() {
        return zze;
    }

    public final boolean zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.nearby.zzajo
    protected final Object zzc(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 2) {
            return zzN(zze, "\u0004\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဇ\u0000", new Object[]{"zzb", "zzd"});
        }
        if (i2 == 3) {
            return new zzme();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzmd(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        if (i2 != 6) {
            return null;
        }
        return zzajo.zzK(zzme.class);
    }
}
