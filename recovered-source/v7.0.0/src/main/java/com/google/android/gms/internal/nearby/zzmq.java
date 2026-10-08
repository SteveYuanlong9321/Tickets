package com.google.android.gms.internal.nearby;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmq extends zzajo implements zzakt {
    private static final zzmq zzf;
    private int zzb;
    private zzajz zzd = zzQ();
    private String zze = "";

    static {
        zzmq zzmqVar = new zzmq();
        zzf = zzmqVar;
        zzajo.zzM(zzmq.class, zzmqVar);
    }

    private zzmq() {
    }

    public static zzmq zzb() {
        return zzf;
    }

    public final List zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.nearby.zzajo
    protected final Object zzc(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 2) {
            return zzN(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001a\u0002ဈ\u0000", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzmq();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzmp(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        if (i2 != 6) {
            return null;
        }
        return zzajo.zzK(zzmq.class);
    }

    final /* synthetic */ void zzd(String str) {
        zzajz zzajzVar = this.zzd;
        if (!zzajzVar.zza()) {
            this.zzd = zzajo.zzR(zzajzVar);
        }
        this.zzd.add("");
    }

    final /* synthetic */ void zze(String str) {
        this.zzb |= 1;
        this.zze = "";
    }
}
