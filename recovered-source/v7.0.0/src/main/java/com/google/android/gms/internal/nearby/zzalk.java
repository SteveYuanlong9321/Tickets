package com.google.android.gms.internal.nearby;

import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalk {
    public static final /* synthetic */ int zza = 0;
    private static final String[] zzb = new String[128];

    static {
        for (int i = 0; i <= 31; i++) {
            zzb[i] = String.format("\\%03o", Integer.valueOf(i));
        }
        String[] strArr = zzb;
        strArr[127] = "\\177";
        strArr[34] = "\\\"";
        strArr[39] = "\\'";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        strArr[7] = "\\a";
        strArr[11] = "\\v";
    }

    static String zza(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length);
        for (byte b : bArr) {
            if (b == 34) {
                sb.append("\\\"");
            } else if (b == 39) {
                sb.append("\\'");
            } else if (b != 92) {
                switch (b) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (b < 32 || b > 126) {
                            sb.append('\\');
                            sb.append((char) (((b >>> 6) & 3) + 48));
                            sb.append((char) (((b >>> 3) & 7) + 48));
                            sb.append((char) ((b & 7) + 48));
                        } else {
                            sb.append((char) b);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    static String zzb(String str) {
        int length = str.length();
        int i = 0;
        StringBuilder sb = null;
        int i2 = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt > 127) {
                return zza(str.getBytes(StandardCharsets.UTF_8));
            }
            int i3 = i + 1;
            String str2 = zzb[cCharAt];
            if (str2 != null) {
                if (sb == null) {
                    sb = new StringBuilder(length + 16);
                }
                if (i2 < i) {
                    sb.append((CharSequence) str, i2, i);
                }
                sb.append(str2);
                i2 = i3;
            }
            i = i3;
        }
        if (sb == null) {
            return str;
        }
        if (i2 < length) {
            sb.append((CharSequence) str, i2, length);
        }
        return sb.toString();
    }
}
