package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;
import kotlin.UByte;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
class zzaes extends zzaet {
    final zzaen zzb;
    final Character zzc;

    zzaes(zzaen zzaenVar, Character ch) {
        this.zzb = zzaenVar;
        boolean z = true;
        if (ch != null) {
            ch.charValue();
            if (zzaenVar.zzd('=')) {
                z = false;
            }
        }
        zzxd.zzd(z, "Padding character %s was already in alphabet", ch);
        this.zzc = ch;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzaes) {
            zzaes zzaesVar = (zzaes) obj;
            if (this.zzb.equals(zzaesVar.zzb) && Objects.equals(this.zzc, zzaesVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode() ^ Objects.hashCode(this.zzc);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        zzaen zzaenVar = this.zzb;
        sb.append(zzaenVar);
        if (8 % zzaenVar.zzb != 0) {
            Character ch = this.zzc;
            if (ch == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(ch);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzaet
    void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzxd.zzk(0, i2, bArr.length);
        while (i3 < i2) {
            int i4 = this.zzb.zzd;
            zzg(appendable, bArr, i3, Math.min(i4, i2 - i3));
            i3 += i4;
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzaet
    int zzb(byte[] bArr, CharSequence charSequence) throws zzaeq {
        int i;
        CharSequence charSequenceZzc = zzc(charSequence);
        int length = charSequenceZzc.length();
        zzaen zzaenVar = this.zzb;
        if (!zzaenVar.zzb(length)) {
            int length2 = charSequenceZzc.length();
            StringBuilder sb = new StringBuilder(String.valueOf(length2).length() + 21);
            sb.append("Invalid input length ");
            sb.append(length2);
            throw new zzaeq(sb.toString());
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < charSequenceZzc.length()) {
            long jZzc = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                i = zzaenVar.zzc;
                if (i4 >= i) {
                    break;
                }
                jZzc <<= zzaenVar.zzb;
                if (i2 + i4 < charSequenceZzc.length()) {
                    jZzc |= (long) zzaenVar.zzc(charSequenceZzc.charAt(i5 + i2));
                    i5++;
                }
                i4++;
            }
            int i6 = zzaenVar.zzd;
            int i7 = i5 * zzaenVar.zzb;
            int i8 = (i6 - 1) * 8;
            while (i8 >= (i6 * 8) - i7) {
                bArr[i3] = (byte) ((jZzc >>> i8) & 255);
                i8 -= 8;
                i3++;
            }
            i2 += i;
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.nearby.zzaet
    final int zzd(int i) {
        zzaen zzaenVar = this.zzb;
        return zzaenVar.zzc * zzaew.zzb(i, zzaenVar.zzd, RoundingMode.CEILING);
    }

    @Override // com.google.android.gms.internal.nearby.zzaet
    final int zze(int i) {
        return (int) (((((long) this.zzb.zzb) * ((long) i)) + 7) / 8);
    }

    @Override // com.google.android.gms.internal.nearby.zzaet
    public final zzaet zzf(String str, int i) {
        for (int i2 = 0; i2 <= 0; i2++) {
            zzxd.zzd(true ^ this.zzb.zzd(":".charAt(i2)), "Separator (%s) cannot contain alphabet characters", ":");
        }
        Character ch = this.zzc;
        if (ch != null) {
            ch.charValue();
            zzxd.zzd(true, "Separator (%s) cannot contain padding character", ":");
        }
        return new zzaer(this, ":", 2);
    }

    final void zzg(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzxd.zzk(i, i + i2, bArr.length);
        zzaen zzaenVar = this.zzb;
        int i3 = zzaenVar.zzd;
        int i4 = 0;
        zzxd.zza(i2 <= i3);
        long j = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            j = (j | ((long) (bArr[i + i5] & UByte.MAX_VALUE))) << 8;
        }
        int i6 = (i2 + 1) * 8;
        int i7 = zzaenVar.zzb;
        while (i4 < i2 * 8) {
            appendable.append(zzaenVar.zza(zzaenVar.zza & ((int) (j >>> ((i6 - i7) - i4)))));
            i4 += i7;
        }
        Character ch = this.zzc;
        if (ch != null) {
            while (i4 < i3 * 8) {
                ch.charValue();
                appendable.append('=');
                i4 += i7;
            }
        }
    }

    zzaes(String str, String str2, Character ch) {
        this(new zzaen(str, str2.toCharArray()), ch);
    }

    @Override // com.google.android.gms.internal.nearby.zzaet
    final CharSequence zzc(CharSequence charSequence) {
        charSequence.getClass();
        Character ch = this.zzc;
        if (ch == null) {
            return charSequence;
        }
        ch.charValue();
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (charSequence.charAt(length) == '=');
        return charSequence.subSequence(0, length + 1);
    }
}
