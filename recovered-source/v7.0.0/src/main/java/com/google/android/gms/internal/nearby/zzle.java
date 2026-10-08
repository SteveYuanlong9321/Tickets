package com.google.android.gms.internal.nearby;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzle extends zzajo implements zzakt {
    private static final zzle zzg;
    private int zzb;
    private zzld zze;
    private String zzd = "";
    private String zzf = "";

    static {
        zzle zzleVar = new zzle();
        zzg = zzleVar;
        zzajo.zzM(zzle.class, zzleVar);
    }

    private zzle() {
    }

    public static zzlb zzb() {
        return (zzlb) zzg.zzG();
    }

    public final String zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.nearby.zzajo
    protected final Object zzc(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 2) {
            return zzN(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003ဈ\u0002", new Object[]{"zzb", "zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzle();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzlb(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        if (i2 != 6) {
            return null;
        }
        return zzajo.zzK(zzle.class);
    }

    final /* synthetic */ void zzd(String str) {
        Objects.requireNonNull(str);
        this.zzb |= 1;
        this.zzd = str;
    }

    final /* synthetic */ void zze(zzld zzldVar) {
        Objects.requireNonNull(zzldVar);
        this.zze = zzldVar;
        this.zzb |= 2;
    }

    final /* synthetic */ void zzf(String str) {
        Objects.requireNonNull(str);
        this.zzb |= 4;
        this.zzf = str;
    }
}
