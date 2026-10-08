package com.google.android.gms.internal.nearby;

import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaeo extends zzaes {
    final char[] zza;

    zzaeo(String str, String str2) {
        zzaen zzaenVar = new zzaen("base16()", new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'});
        super(zzaenVar, null);
        this.zza = new char[512];
        zzxd.zza(zzaenVar.zze().length == 16);
        for (int i = 0; i < 256; i++) {
            this.zza[i] = zzaenVar.zza(i >>> 4);
            this.zza[i | 256] = zzaenVar.zza(i & 15);
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzaes, com.google.android.gms.internal.nearby.zzaet
    final void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzxd.zzk(0, i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i3] & UByte.MAX_VALUE;
            char[] cArr = this.zza;
            appendable.append(cArr[i4]);
            appendable.append(cArr[i4 | 256]);
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzaes, com.google.android.gms.internal.nearby.zzaet
    final int zzb(byte[] bArr, CharSequence charSequence) throws zzaeq {
        if (charSequence.length() % 2 == 1) {
            int length = charSequence.length();
            StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 21);
            sb.append("Invalid input length ");
            sb.append(length);
            throw new zzaeq(sb.toString());
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            zzaen zzaenVar = this.zzb;
            bArr[i2] = (byte) (zzaenVar.zzc(charSequence.charAt(i + 1)) | (zzaenVar.zzc(charSequence.charAt(i)) << 4));
            i += 2;
            i2++;
        }
        return i2;
    }
}
