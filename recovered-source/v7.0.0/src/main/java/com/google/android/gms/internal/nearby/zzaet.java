package com.google.android.gms.internal.nearby;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzaet {
    private static final zzaet zza;
    private static final zzaet zzb;

    static {
        new zzaep("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
        zza = new zzaep("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
        new zzaes("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
        new zzaes("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
        zzb = new zzaeo("base16()", "0123456789ABCDEF");
    }

    zzaet() {
    }

    public static zzaet zzj() {
        return zza;
    }

    public static zzaet zzk() {
        return zzb;
    }

    abstract void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException;

    abstract int zzb(byte[] bArr, CharSequence charSequence) throws zzaeq;

    CharSequence zzc(CharSequence charSequence) {
        throw null;
    }

    abstract int zzd(int i);

    abstract int zze(int i);

    public abstract zzaet zzf(String str, int i);

    public final String zzh(byte[] bArr, int i, int i2) {
        zzxd.zzk(0, i2, bArr.length);
        StringBuilder sb = new StringBuilder(zzd(i2));
        try {
            zza(sb, bArr, 0, i2);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] zzi(CharSequence charSequence) {
        try {
            CharSequence charSequenceZzc = zzc(charSequence);
            int iZze = zze(charSequenceZzc.length());
            byte[] bArr = new byte[iZze];
            int iZzb = zzb(bArr, charSequenceZzc);
            if (iZzb == iZze) {
                return bArr;
            }
            byte[] bArr2 = new byte[iZzb];
            System.arraycopy(bArr, 0, bArr2, 0, iZzb);
            return bArr2;
        } catch (zzaeq e) {
            throw new IllegalArgumentException(e);
        }
    }
}
