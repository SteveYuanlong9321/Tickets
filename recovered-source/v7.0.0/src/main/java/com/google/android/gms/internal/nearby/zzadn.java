package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzadn {
    private final int zza;
    private final zzabg zzb;

    protected zzadn(zzabg zzabgVar, int i) {
        if (zzabgVar == null) {
            throw new IllegalArgumentException("format options cannot be null");
        }
        if (i >= 0) {
            this.zza = i;
            this.zzb = zzabgVar;
        } else {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 15);
            sb.append("invalid index: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    protected abstract void zzb(zzado zzadoVar, Object obj);

    public final int zzc() {
        return this.zza;
    }

    protected final zzabg zzd() {
        return this.zzb;
    }

    public final void zze(zzado zzadoVar, Object[] objArr) {
        int i = this.zza;
        if (i >= objArr.length) {
            zzadoVar.zze();
            return;
        }
        Object obj = objArr[i];
        if (obj != null) {
            zzb(zzadoVar, obj);
        } else {
            zzadoVar.zzf();
        }
    }
}
