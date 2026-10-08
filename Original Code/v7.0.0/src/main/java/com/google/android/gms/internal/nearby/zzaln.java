package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaln {
    private static final zzaln zza = new zzaln(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzaln() {
        this(0, new int[8], new Object[8], true);
    }

    private zzaln(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzaln zza() {
        return zza;
    }

    static zzaln zzb() {
        return new zzaln(0, new int[8], new Object[8], true);
    }

    static zzaln zzc(zzaln zzalnVar, zzaln zzalnVar2) {
        int i = zzalnVar.zzb + zzalnVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzalnVar.zzc, i);
        System.arraycopy(zzalnVar2.zzc, 0, iArrCopyOf, zzalnVar.zzb, zzalnVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzalnVar.zzd, i);
        System.arraycopy(zzalnVar2.zzd, 0, objArrCopyOf, zzalnVar.zzb, zzalnVar2.zzb);
        return new zzaln(i, iArrCopyOf, objArrCopyOf, true);
    }

    private final void zzm(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzaln)) {
            return false;
        }
        zzaln zzalnVar = (zzaln) obj;
        int i = this.zzb;
        if (i == zzalnVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzalnVar.zzc;
            for (int i2 = 0; i2 < i; i2++) {
                if (iArr[i2] == iArr2[i2]) {
                }
            }
            Object[] objArr = this.zzd;
            Object[] objArr2 = zzalnVar.zzd;
            int i3 = this.zzb;
            for (int i4 = 0; i4 < i3; i4++) {
                if (objArr[i4].equals(objArr2[i4])) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = ((i2 * 31) + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final void zzd() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zze() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    final void zzf(zzaiv zzaivVar) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzaivVar.zzv(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzg(zzaiv zzaivVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 >>> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    zzaivVar.zzc(i3, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    zzaivVar.zzj(i3, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    zzaivVar.zzn(i3, (zzaik) obj);
                } else if (i4 == 3) {
                    zzaivVar.zzt(i3);
                    ((zzaln) obj).zzg(zzaivVar);
                    zzaivVar.zzu(i3);
                } else {
                    if (i4 != 5) {
                        throw new RuntimeException(new zzake("Protocol message tag had invalid wire type."));
                    }
                    zzaivVar.zzk(i3, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final int zzh() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iNumberOfLeadingZeros = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2] >>> 3;
            zzaik zzaikVar = (zzaik) this.zzd[i2];
            int iNumberOfLeadingZeros2 = Integer.numberOfLeadingZeros(8) * 9;
            int iNumberOfLeadingZeros3 = Integer.numberOfLeadingZeros(16) * 9;
            int iNumberOfLeadingZeros4 = Integer.numberOfLeadingZeros(i3) * 9;
            int iNumberOfLeadingZeros5 = Integer.numberOfLeadingZeros(24) * 9;
            int iZzb = zzaikVar.zzb();
            int i4 = (352 - iNumberOfLeadingZeros2) >>> 6;
            iNumberOfLeadingZeros += i4 + i4 + ((352 - iNumberOfLeadingZeros3) >>> 6) + ((352 - iNumberOfLeadingZeros4) >>> 6) + ((352 - iNumberOfLeadingZeros5) >>> 6) + ((352 - (Integer.numberOfLeadingZeros(iZzb) * 9)) >>> 6) + iZzb;
        }
        this.zze = iNumberOfLeadingZeros;
        return iNumberOfLeadingZeros;
    }

    public final int zzi() {
        int iNumberOfLeadingZeros;
        int iNumberOfLeadingZeros2;
        int iNumberOfLeadingZeros3;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.zzd[i3]).longValue();
                    iNumberOfLeadingZeros3 = ((352 - (Integer.numberOfLeadingZeros(i5 << 3) * 9)) >>> 6) + 8;
                } else if (i6 == 2) {
                    int i7 = i5 << 3;
                    zzaik zzaikVar = (zzaik) this.zzd[i3];
                    int iNumberOfLeadingZeros4 = Integer.numberOfLeadingZeros(i7) * 9;
                    int iZzb = zzaikVar.zzb();
                    iNumberOfLeadingZeros3 = ((352 - iNumberOfLeadingZeros4) >>> 6) + ((352 - (Integer.numberOfLeadingZeros(iZzb) * 9)) >>> 6) + iZzb;
                } else if (i6 == 3) {
                    int iNumberOfLeadingZeros5 = Integer.numberOfLeadingZeros(i5 << 3) * 9;
                    iNumberOfLeadingZeros2 = ((zzaln) this.zzd[i3]).zzi();
                    int i8 = (352 - iNumberOfLeadingZeros5) >>> 6;
                    iNumberOfLeadingZeros = i8 + i8;
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(new zzake("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.zzd[i3]).intValue();
                    iNumberOfLeadingZeros3 = ((352 - (Integer.numberOfLeadingZeros(i5 << 3) * 9)) >>> 6) + 4;
                }
                i2 += iNumberOfLeadingZeros3;
            } else {
                int i9 = i5 << 3;
                long jLongValue = ((Long) this.zzd[i3]).longValue();
                iNumberOfLeadingZeros = (352 - (Integer.numberOfLeadingZeros(i9) * 9)) >>> 6;
                iNumberOfLeadingZeros2 = (640 - (Long.numberOfLeadingZeros(jLongValue) * 9)) >>> 6;
            }
            iNumberOfLeadingZeros3 = iNumberOfLeadingZeros + iNumberOfLeadingZeros2;
            i2 += iNumberOfLeadingZeros3;
        }
        this.zze = i2;
        return i2;
    }

    final void zzj(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzaku.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    final void zzk(int i, Object obj) {
        zze();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    final zzaln zzl(zzaln zzalnVar) {
        if (zzalnVar.equals(zza)) {
            return this;
        }
        zze();
        int i = this.zzb + zzalnVar.zzb;
        zzm(i);
        System.arraycopy(zzalnVar.zzc, 0, this.zzc, this.zzb, zzalnVar.zzb);
        System.arraycopy(zzalnVar.zzd, 0, this.zzd, this.zzb, zzalnVar.zzb);
        this.zzb = i;
        return this;
    }
}
