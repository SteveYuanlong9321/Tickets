package com.google.android.gms.internal.nearby;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzod extends zzajo implements zzakt {
    private static final zzod zzd;
    private zzajz zzb = zzQ();

    static {
        zzod zzodVar = new zzod();
        zzd = zzodVar;
        zzajo.zzM(zzod.class, zzodVar);
    }

    private zzod() {
    }

    public static zzod zzb(byte[] bArr, zzaiz zzaizVar) throws zzakf {
        return (zzod) zzajo.zzT(zzd, bArr, zzaizVar);
    }

    public final List zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzajo
    protected final Object zzc(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 2) {
            return zzN(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzb"});
        }
        if (i2 == 3) {
            return new zzod();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzoc(bArr);
        }
        if (i2 == 5) {
            return zzd;
        }
        if (i2 != 6) {
            return null;
        }
        return zzajo.zzK(zzod.class);
    }
}
