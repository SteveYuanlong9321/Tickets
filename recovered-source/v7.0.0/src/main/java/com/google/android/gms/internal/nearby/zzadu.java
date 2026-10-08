package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzadu extends RuntimeException {
    private zzadu(String str, String str2) {
        super(str);
    }

    public static zzadu zza(String str, String str2, int i, int i2) {
        return new zzadu(zze(str, str2, i, i2), str2);
    }

    public static zzadu zzb(String str, String str2, int i) {
        return new zzadu(zze(str, str2, i, i + 1), str2);
    }

    public static zzadu zzc(String str, String str2, int i) {
        return new zzadu(zze(str, str2, i, -1), str2);
    }

    public static zzadu zzd(String str, String str2) {
        return new zzadu(str, str2);
    }

    private static String zze(String str, String str2, int i, int i2) {
        if (i2 < 0) {
            i2 = str2.length();
        }
        StringBuilder sb = new StringBuilder(str);
        sb.append(": ");
        if (i > 8) {
            sb.append("...");
            sb.append((CharSequence) str2, i - 5, i);
        } else {
            sb.append((CharSequence) str2, 0, i);
        }
        sb.append('[');
        sb.append(str2.substring(i, i2));
        sb.append(']');
        if (str2.length() - i2 > 8) {
            sb.append((CharSequence) str2, i2, i2 + 5);
            sb.append("...");
        } else {
            sb.append((CharSequence) str2, i2, str2.length());
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return this;
    }
}
