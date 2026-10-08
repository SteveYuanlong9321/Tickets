package com.google.android.gms.internal.nearby;

import androidx.camera.video.AudioStats;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzpq extends zzajo implements zzakt {
    private static final zzpq zzg;
    private int zzb;
    private Object zze;
    private int zzd = 0;
    private String zzf = "";

    static {
        zzpq zzpqVar = new zzpq();
        zzg = zzpqVar;
        zzajo.zzM(zzpq.class, zzpqVar);
    }

    private zzpq() {
    }

    public static zzpp zzh() {
        return (zzpp) zzg.zzG();
    }

    public final String zza() {
        return this.zzf;
    }

    public final long zzb() {
        if (this.zzd == 2) {
            return ((Long) this.zze).longValue();
        }
        return 0L;
    }

    @Override // com.google.android.gms.internal.nearby.zzajo
    protected final Object zzc(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 2) {
            return zzN(zzg, "\u0004\u0006\u0001\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u00025\u0000\u0003:\u0000\u00043\u0000\u0005;\u0000\u0006=\u0000", new Object[]{"zze", "zzd", "zzb", "zzf"});
        }
        if (i2 == 3) {
            return new zzpq();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzpp(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        if (i2 != 6) {
            return null;
        }
        return zzajo.zzK(zzpq.class);
    }

    public final boolean zzd() {
        if (this.zzd == 3) {
            return ((Boolean) this.zze).booleanValue();
        }
        return false;
    }

    public final double zze() {
        return this.zzd == 4 ? ((Double) this.zze).doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public final String zzf() {
        return this.zzd == 5 ? (String) this.zze : "";
    }

    public final zzaik zzg() {
        return this.zzd == 6 ? (zzaik) this.zze : zzaik.zza;
    }

    final /* synthetic */ void zzi(String str) {
        Objects.requireNonNull(str);
        this.zzb |= 1;
        this.zzf = str;
    }

    final /* synthetic */ void zzj(long j) {
        this.zzd = 2;
        this.zze = Long.valueOf(j);
    }

    final /* synthetic */ void zzk(boolean z) {
        this.zzd = 3;
        this.zze = Boolean.valueOf(z);
    }

    final /* synthetic */ void zzl(double d) {
        this.zzd = 4;
        this.zze = Double.valueOf(d);
    }

    final /* synthetic */ void zzm(String str) {
        Objects.requireNonNull(str);
        this.zzd = 5;
        this.zze = str;
    }

    final /* synthetic */ void zzn(zzaik zzaikVar) {
        Objects.requireNonNull(zzaikVar);
        this.zzd = 6;
        this.zze = zzaikVar;
    }

    public final int zzp() {
        int i = this.zzd;
        if (i == 0) {
            return 6;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 3;
        }
        if (i != 5) {
            return i != 6 ? 0 : 5;
        }
        return 4;
    }
}
