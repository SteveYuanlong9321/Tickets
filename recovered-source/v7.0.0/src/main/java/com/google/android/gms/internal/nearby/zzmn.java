package com.google.android.gms.internal.nearby;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmn extends zzajo implements zzakt {
    private static final zzmn zzf;
    private int zzb;
    private zzmh zzd;
    private zzmj zze;

    static {
        zzmn zzmnVar = new zzmn();
        zzf = zzmnVar;
        zzajo.zzM(zzmn.class, zzmnVar);
    }

    private zzmn() {
    }

    public static zzmn zzd(byte[] bArr, zzaiz zzaizVar) throws zzakf {
        return (zzmn) zzajo.zzT(zzf, bArr, zzaizVar);
    }

    public static zzmm zze() {
        return (zzmm) zzf.zzG();
    }

    public final zzmh zza() {
        zzmh zzmhVar = this.zzd;
        return zzmhVar == null ? zzmh.zzr() : zzmhVar;
    }

    public final zzmj zzb() {
        zzmj zzmjVar = this.zze;
        return zzmjVar == null ? zzmj.zza() : zzmjVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzajo
    protected final Object zzc(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 2) {
            return zzN(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzmn();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzmm(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        if (i2 != 6) {
            return null;
        }
        return zzajo.zzK(zzmn.class);
    }

    final /* synthetic */ void zzf(zzmh zzmhVar) {
        Objects.requireNonNull(zzmhVar);
        this.zzd = zzmhVar;
        this.zzb |= 1;
    }
}
