package com.google.android.gms.internal.nearby;

import android.net.Uri;
import android.system.Os;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zztn {
    public static IOException zza(zzqo zzqoVar, Uri uri, IOException iOException, String str) {
        try {
            zzrl zzrlVarZzb = zzrl.zzb();
            zzrlVarZzb.zzc();
            File file = (File) zzqoVar.zza(uri, zzrlVarZzb);
            if (!file.exists()) {
                return zzb(file, iOException, str);
            }
            if (file.isFile()) {
                if (file.canRead()) {
                    return file.canWrite() ? zzb(file, iOException, str) : zzb(file, iOException, str);
                }
                return file.canWrite() ? zzb(file, iOException, str) : zzb(file, iOException, str);
            }
            if (file.canRead()) {
                return file.canWrite() ? zzb(file, iOException, str) : zzb(file, iOException, str);
            }
            return file.canWrite() ? zzb(file, iOException, str) : zzb(file, iOException, str);
        } catch (IOException unused) {
            return new IOException(iOException);
        }
    }

    private static IOException zzb(File file, IOException iOException, String str) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return zzc(file, iOException, str);
        }
        if (!parentFile.exists()) {
            return zzc(file, iOException, str);
        }
        if (parentFile.isDirectory()) {
            if (parentFile.canRead()) {
                return parentFile.canWrite() ? zzc(file, iOException, str) : zzc(file, iOException, str);
            }
            return parentFile.canWrite() ? zzc(file, iOException, str) : zzc(file, iOException, str);
        }
        if (parentFile.canRead()) {
            return parentFile.canWrite() ? zzc(file, iOException, str) : zzc(file, iOException, str);
        }
        return parentFile.canWrite() ? zzc(file, iOException, str) : zzc(file, iOException, str);
    }

    private static IOException zzc(File file, IOException iOException, String str) {
        String strConcat;
        try {
            String str2 = String.format(Locale.US, " canonical[%s] freeSpace[%d] protoName[%s]", file.getCanonicalPath(), Long.valueOf(file.getFreeSpace()), str);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 16);
            sb.append("Inoperable file:");
            sb.append(str2);
            strConcat = sb.toString();
            try {
                String str3 = String.format(Locale.US, " mode[%d]", Integer.valueOf(Os.stat(file.getCanonicalPath()).st_mode));
                StringBuilder sb2 = new StringBuilder(strConcat.length() + String.valueOf(str3).length());
                sb2.append(strConcat);
                sb2.append(str3);
                strConcat = sb2.toString();
            } catch (Exception unused) {
            }
        } catch (IOException unused2) {
            strConcat = "Inoperable file:".concat(" failed");
        }
        return new IOException(strConcat, iOException);
    }
}
