package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzabg {
    private static final long zza;
    private static final zzabg zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;

    static {
        long jCharAt = 0;
        for (int i = 0; i < 7; i++) {
            jCharAt |= (((long) i) + 1) << ((int) (((long) (" #(+,-0".charAt(i) - ' ')) * 3));
        }
        zza = jCharAt;
        zzb = new zzabg(0, -1, -1);
    }

    private zzabg(int i, int i2, int i3) {
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
    }

    public static zzabg zza() {
        return zzb;
    }

    static int zzc(String str, boolean z) {
        int i = true != z ? 0 : 128;
        for (int i2 = 0; i2 < str.length(); i2++) {
            int iZzm = zzm(str.charAt(i2));
            if (iZzm < 0) {
                throw new IllegalArgumentException("invalid flags: ".concat(str));
            }
            i |= 1 << iZzm;
        }
        return i;
    }

    private static int zzm(char c) {
        return ((int) ((zza >>> ((c - ' ') * 3)) & 7)) - 1;
    }

    private static int zzn(String str, int i, int i2) throws zzadu {
        if (i == i2) {
            throw zzadu.zzb("missing precision", str, i - 1);
        }
        int i3 = 0;
        for (int i4 = i; i4 < i2; i4++) {
            char cCharAt = (char) (str.charAt(i4) - '0');
            if (cCharAt >= '\n') {
                throw zzadu.zzb("invalid precision character", str, i4);
            }
            i3 = (i3 * 10) + cCharAt;
            if (i3 > 999999) {
                throw zzadu.zza("precision too large", str, i, i2);
            }
        }
        if (i3 != 0) {
            return i3;
        }
        if (i2 == i + 1) {
            return 0;
        }
        throw zzadu.zza("invalid precision", str, i, i2);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzabg) {
            zzabg zzabgVar = (zzabg) obj;
            if (zzabgVar.zzc == this.zzc && zzabgVar.zzd == this.zzd && zzabgVar.zze == this.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((this.zzc * 31) + this.zzd) * 31) + this.zze;
    }

    public final zzabg zzd(int i, boolean z, boolean z2) {
        if (!zze()) {
            int i2 = this.zzc;
            int i3 = i2 & 128;
            if (i3 == 0) {
                return zzb;
            }
            if (i3 != i2 || this.zzd != -1 || this.zze != -1) {
                return new zzabg(i3, -1, -1);
            }
        }
        return this;
    }

    public final boolean zze() {
        return this == zzb;
    }

    public final int zzf() {
        return this.zzd;
    }

    public final int zzg() {
        return this.zze;
    }

    public final boolean zzh(int i, boolean z) {
        int i2;
        if (zze()) {
            return true;
        }
        int i3 = this.zzc;
        if (((~i) & i3) != 0) {
            return false;
        }
        if (!z && this.zze != -1) {
            return false;
        }
        int i4 = this.zzd;
        if ((i3 & 9) == 9 || (i2 = i3 & 96) == 96) {
            return false;
        }
        return i2 == 0 || i4 != -1;
    }

    public final boolean zzi(zzabf zzabfVar) {
        return zzh(zzabfVar.zzd(), zzabfVar.zzc().zza());
    }

    public final int zzj() {
        return this.zzc;
    }

    public final boolean zzk() {
        return (this.zzc & 128) != 0;
    }

    public final StringBuilder zzl(StringBuilder sb) {
        if (!zze()) {
            int i = this.zzc;
            int i2 = 0;
            while (true) {
                int i3 = i & (-129);
                int i4 = 1 << i2;
                if (i4 > i3) {
                    break;
                }
                if ((i3 & i4) != 0) {
                    sb.append(" #(+,-0".charAt(i2));
                }
                i2++;
            }
            int i5 = this.zzd;
            if (i5 != -1) {
                sb.append(i5);
            }
            int i6 = this.zze;
            if (i6 != -1) {
                sb.append('.');
                sb.append(i6);
            }
        }
        return sb;
    }

    public static zzabg zzb(String str, int i, int i2, boolean z) throws zzadu {
        if (i == i2 && !z) {
            return zzb;
        }
        int i3 = true != z ? 0 : 128;
        while (i != i2) {
            int i4 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt < ' ' || cCharAt > '0') {
                if (cCharAt > '9') {
                    throw zzadu.zzb("invalid flag", str, i);
                }
                int i5 = cCharAt - '0';
                while (i4 != i2) {
                    int i6 = i4 + 1;
                    char cCharAt2 = str.charAt(i4);
                    if (cCharAt2 == '.') {
                        return new zzabg(i3, i5, zzn(str, i6, i2));
                    }
                    char c = (char) (cCharAt2 - '0');
                    if (c >= '\n') {
                        throw zzadu.zzb("invalid width character", str, i4);
                    }
                    i5 = (i5 * 10) + c;
                    if (i5 > 999999) {
                        throw zzadu.zza("width too large", str, i, i2);
                    }
                    i4 = i6;
                }
                return new zzabg(i3, i5, -1);
            }
            int iZzm = zzm(cCharAt);
            if (iZzm < 0) {
                if (cCharAt == '.') {
                    return new zzabg(i3, -1, zzn(str, i4, i2));
                }
                throw zzadu.zzb("invalid flag", str, i);
            }
            int i7 = 1 << iZzm;
            if ((i3 & i7) != 0) {
                throw zzadu.zzb("repeated flag", str, i);
            }
            i3 |= i7;
            i = i4;
        }
        return new zzabg(i3, -1, -1);
    }
}
