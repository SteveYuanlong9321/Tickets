package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzpo extends zzajo implements zzakt {
    private static final zzpo zzi;
    private int zzb;
    private long zzg;
    private String zzd = "";
    private zzaik zze = zzaik.zza;
    private String zzf = "";
    private zzajz zzh = zzQ();

    static {
        zzpo zzpoVar = new zzpo();
        zzi = zzpoVar;
        zzajo.zzM(zzpo.class, zzpoVar);
    }

    private zzpo() {
    }

    public static zzpo zzh(InputStream inputStream, zzaiz zzaizVar) throws IOException {
        return (zzpo) zzajo.zzU(zzi, inputStream, zzaizVar);
    }

    public static zzpn zzi() {
        return (zzpn) zzi.zzG();
    }

    public static zzpo zzj() {
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
            return zzN(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005\u001b", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", zzpq.class});
        }
        if (i2 == 3) {
            return new zzpo();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzpn(bArr);
        }
        if (i2 == 5) {
            return zzi;
        }
        if (i2 != 6) {
            return null;
        }
        return zzajo.zzK(zzpo.class);
    }

    public final String zzd() {
        return this.zzf;
    }

    public final long zze() {
        return this.zzg;
    }

    public final List zzf() {
        return this.zzh;
    }

    public final int zzg() {
        return this.zzh.size();
    }

    final /* synthetic */ void zzk(String str) {
        Objects.requireNonNull(str);
        this.zzb |= 1;
        this.zzd = str;
    }

    final /* synthetic */ void zzl(zzaik zzaikVar) {
        Objects.requireNonNull(zzaikVar);
        this.zzb |= 2;
        this.zze = zzaikVar;
    }

    final /* synthetic */ void zzm(String str) {
        Objects.requireNonNull(str);
        this.zzb |= 4;
        this.zzf = str;
    }

    final /* synthetic */ void zzn(long j) {
        this.zzb |= 8;
        this.zzg = j;
    }

    final /* synthetic */ void zzo(zzpq zzpqVar) {
        Objects.requireNonNull(zzpqVar);
        zzajz zzajzVar = this.zzh;
        if (!zzajzVar.zza()) {
            this.zzh = zzajo.zzR(zzajzVar);
        }
        this.zzh.add(zzpqVar);
    }
}
