package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaer extends zzaet {
    private final zzaet zza;
    private final String zzb = ":";

    zzaer(zzaet zzaetVar, String str, int i) {
        this.zza = zzaetVar;
    }

    public final String toString() {
        String string = this.zza.toString();
        int length = string.length();
        String str = this.zzb;
        StringBuilder sb = new StringBuilder(length + 16 + str.length() + 5);
        sb.append(string);
        sb.append(".withSeparator(\"");
        sb.append(str);
        sb.append("\", 2)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzaet
    final void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        this.zza.zza(new zzaem(2, appendable, this.zzb), bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.nearby.zzaet
    final int zzb(byte[] bArr, CharSequence charSequence) throws zzaeq {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i = 0; i < charSequence.length(); i++) {
            char cCharAt = charSequence.charAt(i);
            if (this.zzb.indexOf(cCharAt) < 0) {
                sb.append(cCharAt);
            }
        }
        return this.zza.zzb(bArr, sb);
    }

    @Override // com.google.android.gms.internal.nearby.zzaet
    final CharSequence zzc(CharSequence charSequence) {
        return this.zza.zzc(charSequence);
    }

    @Override // com.google.android.gms.internal.nearby.zzaet
    final int zzd(int i) {
        int iZzd = this.zza.zzd(i);
        return iZzd + (this.zzb.length() * zzaew.zzb(Math.max(0, iZzd - 1), 2, RoundingMode.FLOOR));
    }

    @Override // com.google.android.gms.internal.nearby.zzaet
    final int zze(int i) {
        return this.zza.zze(i);
    }

    @Override // com.google.android.gms.internal.nearby.zzaet
    public final zzaet zzf(String str, int i) {
        throw null;
    }
}
