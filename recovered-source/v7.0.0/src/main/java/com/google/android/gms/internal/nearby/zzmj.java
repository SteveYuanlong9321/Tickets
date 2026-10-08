package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmj extends zzajo implements zzakt {
    private static final zzmj zzo;
    private int zzb;
    private boolean zze;
    private zzml zzj;
    private boolean zzk;
    private boolean zzl;
    private zzme zzm;
    private boolean zzn;
    private zzaik zzd = zzaik.zza;
    private String zzf = "";
    private zzajz zzg = zzQ();
    private zzajz zzh = zzQ();
    private zzajv zzi = zzP();

    static {
        zzmj zzmjVar = new zzmj();
        zzo = zzmjVar;
        zzajo.zzM(zzmj.class, zzmjVar);
    }

    private zzmj() {
    }

    public static zzmj zza() {
        return zzo;
    }

    @Override // com.google.android.gms.internal.nearby.zzajo
    protected final Object zzc(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 2) {
            return zzN(zzo, "\u0004\u000b\u0000\u0001\u0001\r\u000b\u0000\u0003\u0000\u0001ည\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004\u001a\u0005\u001a\u0007ࠬ\bဉ\u0003\nဇ\u0004\u000bဇ\u0005\fဉ\u0006\rဇ\u0007", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzahs.zzc(), "zzj", "zzk", "zzl", "zzm", "zzn"});
        }
        if (i2 == 3) {
            return new zzmj();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzmi(bArr);
        }
        if (i2 == 5) {
            return zzo;
        }
        if (i2 != 6) {
            return null;
        }
        return zzajo.zzK(zzmj.class);
    }
}
