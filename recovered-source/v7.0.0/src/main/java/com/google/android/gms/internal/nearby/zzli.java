package com.google.android.gms.internal.nearby;

import androidx.camera.video.AudioStats;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzli extends zzajo implements zzakt {
    private static final zzli zzg;
    private int zzb;
    private Object zze;
    private int zzd = 0;
    private String zzf = "";

    static {
        zzli zzliVar = new zzli();
        zzg = zzliVar;
        zzajo.zzM(zzli.class, zzliVar);
    }

    private zzli() {
    }

    public static zzlh zzh() {
        return (zzlh) zzg.zzG();
    }

    public static zzli zzi() {
        return zzg;
    }

    public final String zza() {
        return this.zzf;
    }

    public final long zzb() {
        if (this.zzd == 1) {
            return ((Long) this.zze).longValue();
        }
        return 0L;
    }

    @Override // com.google.android.gms.internal.nearby.zzajo
    protected final Object zzc(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 2) {
            return zzN(zzg, "\u0004\u0006\u0001\u0001\u0001\n\u0006\u0000\u0000\u0000\u00018\u0000\u0002:\u0000\u00033\u0000\u0004;\u0000\u0005=\u0000\nဈ\u0000", new Object[]{"zze", "zzd", "zzb", "zzf"});
        }
        if (i2 == 3) {
            return new zzli();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzlh(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        if (i2 != 6) {
            return null;
        }
        return zzajo.zzK(zzli.class);
    }

    public final boolean zzd() {
        if (this.zzd == 2) {
            return ((Boolean) this.zze).booleanValue();
        }
        return false;
    }

    public final double zze() {
        return this.zzd == 3 ? ((Double) this.zze).doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public final String zzf() {
        return this.zzd == 4 ? (String) this.zze : "";
    }

    public final zzaik zzg() {
        return this.zzd == 5 ? (zzaik) this.zze : zzaik.zza;
    }

    final /* synthetic */ void zzj(String str) {
        Objects.requireNonNull(str);
        this.zzb |= 1;
        this.zzf = str;
    }

    final /* synthetic */ void zzk(long j) {
        this.zzd = 1;
        this.zze = Long.valueOf(j);
    }

    final /* synthetic */ void zzl(boolean z) {
        this.zzd = 2;
        this.zze = Boolean.valueOf(z);
    }

    final /* synthetic */ void zzm(double d) {
        this.zzd = 3;
        this.zze = Double.valueOf(d);
    }

    final /* synthetic */ void zzn(String str) {
        Objects.requireNonNull(str);
        this.zzd = 4;
        this.zze = str;
    }

    final /* synthetic */ void zzo(zzaik zzaikVar) {
        Objects.requireNonNull(zzaikVar);
        this.zzd = 5;
        this.zze = zzaikVar;
    }

    public final int zzq() {
        int i = this.zzd;
        if (i == 0) {
            return 6;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        i2 = 5;
                        if (i != 5) {
                            return 0;
                        }
                    }
                }
            }
        }
        return i2;
    }
}
