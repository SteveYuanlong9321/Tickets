package com.google.android.gms.internal.nearby;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzlg extends zzajo implements zzakt {
    private static final zzlg zzk;
    private int zzb;
    private String zzd = "";
    private zzaik zze = zzaik.zza;
    private String zzf = "";
    private zzajz zzg = zzQ();
    private zzajz zzh = zzQ();
    private boolean zzi;
    private long zzj;

    static {
        zzlg zzlgVar = new zzlg();
        zzk = zzlgVar;
        zzajo.zzM(zzlg.class, zzlgVar);
    }

    private zzlg() {
    }

    public static zzlf zzh() {
        return (zzlf) zzk.zzG();
    }

    public final String zza() {
        return this.zzd;
    }

    public final boolean zzb() {
        return (this.zzb & 2) != 0;
    }

    @Override // com.google.android.gms.internal.nearby.zzajo
    protected final Object zzc(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 2) {
            return zzN(zzk, "\u0004\u0007\u0000\u0001\u0001\t\u0007\u0000\u0002\u0000\u0001ဈ\u0002\u0002ဈ\u0000\u0003ည\u0001\u0004\u001b\u0005\u001a\bဇ\u0003\tဂ\u0004", new Object[]{"zzb", "zzf", "zzd", "zze", "zzg", zzli.class, "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzlg();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzlf(bArr);
        }
        if (i2 == 5) {
            return zzk;
        }
        if (i2 != 6) {
            return null;
        }
        return zzajo.zzK(zzlg.class);
    }

    public final zzaik zzd() {
        return this.zze;
    }

    public final String zze() {
        return this.zzf;
    }

    public final List zzf() {
        return this.zzg;
    }

    public final long zzg() {
        return this.zzj;
    }

    final /* synthetic */ void zzi(String str) {
        Objects.requireNonNull(str);
        this.zzb |= 1;
        this.zzd = str;
    }

    final /* synthetic */ void zzj(zzaik zzaikVar) {
        Objects.requireNonNull(zzaikVar);
        this.zzb |= 2;
        this.zze = zzaikVar;
    }

    final /* synthetic */ void zzk(String str) {
        Objects.requireNonNull(str);
        this.zzb |= 4;
        this.zzf = str;
    }

    final /* synthetic */ void zzl(zzli zzliVar) {
        Objects.requireNonNull(zzliVar);
        zzajz zzajzVar = this.zzg;
        if (!zzajzVar.zza()) {
            this.zzg = zzajo.zzR(zzajzVar);
        }
        this.zzg.add(zzliVar);
    }

    final /* synthetic */ void zzm(String str) {
        Objects.requireNonNull(str);
        zzajz zzajzVar = this.zzh;
        if (!zzajzVar.zza()) {
            this.zzh = zzajo.zzR(zzajzVar);
        }
        this.zzh.add(str);
    }

    final /* synthetic */ void zzn(boolean z) {
        this.zzb |= 8;
        this.zzi = z;
    }

    final /* synthetic */ void zzo(long j) {
        this.zzb |= 16;
        this.zzj = j;
    }
}
