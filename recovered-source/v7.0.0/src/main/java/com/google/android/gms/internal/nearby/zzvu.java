package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzvu {
    final long zza;
    private final zzvz zzb;

    protected zzvu() {
        this.zzb = null;
        this.zza = 0L;
    }

    zzvu(zzvz zzvzVar, zzvx zzvxVar) {
        this.zzb = zzvzVar;
        long j = zzvzVar.zza;
        this.zza = zzc(0L, zzvxVar.zzb);
        long j2 = zzvzVar.zzb;
    }

    private static native long zzc(long j, long j2);

    private static native void zzd(long j, long j2);

    private final native int zze(long j, long j2);

    private final native int zzf(long j, long j2);

    public final boolean equals(Object obj) {
        return (obj instanceof zzvu) && ((zzvu) obj).zza == this.zza;
    }

    protected final void finalize() throws Throwable {
        long j = this.zza;
        if (j != 0) {
            zzd(0L, j);
        }
        super.finalize();
    }

    public final int hashCode() {
        return Long.valueOf(this.zza).hashCode();
    }

    public final int zza() {
        long j = this.zzb.zza;
        int iZze = zze(0L, this.zza);
        int[] iArr = {1, 2, 3};
        for (int i = 0; i < 3; i++) {
            int i2 = iArr[i];
            int i3 = i2 - 1;
            if (i2 == 0) {
                throw null;
            }
            if (i3 == iZze) {
                return i2;
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(iZze).length() + 49);
        sb.append("Unexpected value for native TrackingState, value=");
        sb.append(iZze);
        throw new zzwb(sb.toString());
    }

    public final int zzb() {
        long j = this.zzb.zza;
        int iZzf = zzf(0L, this.zza);
        int[] iArr = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < 6; i++) {
            int i2 = iArr[i];
            int i3 = i2 - 1;
            if (i2 == 0) {
                throw null;
            }
            if (i3 == iZzf) {
                return i2;
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(iZzf).length() + 57);
        sb.append("Unexpected value for native TrackingFailureReason, value=");
        sb.append(iZzf);
        throw new zzwb(sb.toString());
    }
}
