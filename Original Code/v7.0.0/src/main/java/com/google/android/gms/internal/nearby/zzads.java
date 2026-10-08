package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzads {
    private final zzacl zza;
    private int zzb = 0;
    private int zzc = -1;

    public zzads(zzacl zzaclVar) {
        zzadx.zza(zzaclVar, "context");
        this.zza = zzaclVar;
    }

    protected abstract void zzb(int i, int i2, zzadn zzadnVar);

    protected abstract Object zzg();

    public final zzadt zzh() {
        return this.zza.zza();
    }

    public final String zzi() {
        return this.zza.zzb();
    }

    public final int zzj() {
        return this.zzc + 1;
    }

    public final void zzk(int i, int i2, zzadn zzadnVar) {
        if (zzadnVar.zzc() < 32) {
            this.zzb |= 1 << zzadnVar.zzc();
        }
        this.zzc = Math.max(this.zzc, zzadnVar.zzc());
        zzb(i, i2, zzadnVar);
    }

    public final Object zzl() {
        zzacl zzaclVar = this.zza;
        zzaclVar.zza().zzc(this);
        int i = this.zzb;
        if (((i + 1) & i) != 0 || (this.zzc > 31 && i != -1)) {
            throw zzadu.zzd(String.format("unreferenced arguments [first missing index=%d]", Integer.valueOf(Integer.numberOfTrailingZeros(~i))), zzaclVar.zzb());
        }
        return zzg();
    }
}
