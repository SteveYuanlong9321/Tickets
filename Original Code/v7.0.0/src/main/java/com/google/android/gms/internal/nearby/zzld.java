package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzld extends zzajo implements zzakt {
    private static final zzld zzf;
    private int zzb;
    private int zzd;
    private int zze;

    static {
        zzld zzldVar = new zzld();
        zzf = zzldVar;
        zzajo.zzM(zzld.class, zzldVar);
    }

    private zzld() {
    }

    public static zzlc zza() {
        return (zzlc) zzf.zzG();
    }

    @Override // com.google.android.gms.internal.nearby.zzajo
    protected final Object zzc(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 2) {
            return zzN(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzld();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzlc(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        if (i2 != 6) {
            return null;
        }
        return zzajo.zzK(zzld.class);
    }

    final /* synthetic */ void zzd(int i) {
        this.zzd = i - 2;
        this.zzb |= 1;
    }

    final /* synthetic */ void zze(int i) {
        this.zze = i == 1 ? zzaka.zza() : i - 2;
        this.zzb |= 2;
    }
}
