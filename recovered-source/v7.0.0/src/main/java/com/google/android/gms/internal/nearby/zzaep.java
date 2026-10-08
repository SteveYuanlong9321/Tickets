package com.google.android.gms.internal.nearby;

import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaep extends zzaes {
    zzaep(String str, String str2, Character ch) {
        zzaen zzaenVar = new zzaen(str, str2.toCharArray());
        super(zzaenVar, ch);
        zzxd.zza(zzaenVar.zze().length == 64);
    }

    @Override // com.google.android.gms.internal.nearby.zzaes, com.google.android.gms.internal.nearby.zzaet
    final void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzxd.zzk(0, i2, bArr.length);
        for (int i4 = i2; i4 >= 3; i4 -= 3) {
            int i5 = bArr[i3] & UByte.MAX_VALUE;
            int i6 = bArr[i3 + 1] & UByte.MAX_VALUE;
            int i7 = bArr[i3 + 2] & UByte.MAX_VALUE;
            zzaen zzaenVar = this.zzb;
            int i8 = (i6 << 8) | (i5 << 16) | i7;
            appendable.append(zzaenVar.zza(i8 >>> 18));
            appendable.append(zzaenVar.zza((i8 >>> 12) & 63));
            appendable.append(zzaenVar.zza((i8 >>> 6) & 63));
            appendable.append(zzaenVar.zza(i8 & 63));
            i3 += 3;
        }
        if (i3 < i2) {
            zzg(appendable, bArr, i3, i2 - i3);
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzaes, com.google.android.gms.internal.nearby.zzaet
    final int zzb(byte[] bArr, CharSequence charSequence) throws zzaeq {
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
        int i = 0;
        int i2 = 0;
        while (i < charSequenceZzc.length()) {
            int i3 = i2 + 1;
            int iZzc = (zzaenVar.zzc(charSequenceZzc.charAt(i + 1)) << 12) | (zzaenVar.zzc(charSequenceZzc.charAt(i)) << 18);
            bArr[i2] = (byte) (iZzc >>> 16);
            int i4 = i + 2;
            if (i4 < charSequenceZzc.length()) {
                int i5 = i + 3;
                int iZzc2 = iZzc | (zzaenVar.zzc(charSequenceZzc.charAt(i4)) << 6);
                int i6 = i2 + 2;
                bArr[i3] = (byte) ((iZzc2 >>> 8) & 255);
                if (i5 < charSequenceZzc.length()) {
                    i += 4;
                    i2 += 3;
                    bArr[i6] = (byte) ((iZzc2 | zzaenVar.zzc(charSequenceZzc.charAt(i5))) & 255);
                } else {
                    i2 = i6;
                    i = i5;
                }
            } else {
                i = i4;
                i2 = i3;
            }
        }
        return i2;
    }
}
