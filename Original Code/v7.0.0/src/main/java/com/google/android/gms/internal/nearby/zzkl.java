package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import androidx.collection.ArrayMap;
import java.io.File;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzkl {
    public static final /* synthetic */ int zza = 0;
    private static Boolean zzb;
    private static final ArrayMap zzc = new ArrayMap();

    public static File zza(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return filesDir;
        }
        SystemClock.sleep(100L);
        File filesDir2 = context.getFilesDir();
        if (filesDir2 != null) {
            return filesDir2;
        }
        throw new IllegalStateException("getFilesDir returned null twice.");
    }

    public static boolean zzb() {
        Boolean boolValueOf = zzb;
        if (boolValueOf == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                boolValueOf = Boolean.valueOf(Process.isIsolated());
                zzb = boolValueOf;
            } else {
                try {
                    Object objInvoke = Process.class.getMethod("isIsolated", null).invoke(Process.class, null);
                    if (objInvoke == null) {
                        throw null;
                    }
                    boolValueOf = (Boolean) objInvoke;
                    boolValueOf.booleanValue();
                    zzb = boolValueOf;
                } catch (ReflectiveOperationException unused) {
                    boolValueOf = false;
                    zzb = boolValueOf;
                }
            }
        }
        return boolValueOf.booleanValue();
    }

    public static synchronized Uri zzc(String str) {
        ArrayMap arrayMap = zzc;
        Uri uri = (Uri) arrayMap.get("com.google.android.gms.nearby");
        if (uri != null) {
            return uri;
        }
        String strEncode = Uri.encode("com.google.android.gms.nearby");
        String.valueOf(strEncode);
        Uri uri2 = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(strEncode)));
        arrayMap.put("com.google.android.gms.nearby", uri2);
        return uri2;
    }
}
