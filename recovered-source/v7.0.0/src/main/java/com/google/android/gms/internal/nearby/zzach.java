package com.google.android.gms.internal.nearby;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzach {
    private static final zzacj zza = zzb(zzacj.zzd);

    private static zzacj zzb(String[] strArr) {
        zzacp zzacpVar;
        try {
            zzacpVar = zzacq.zza;
        } catch (NoClassDefFoundError unused) {
            zzacpVar = null;
        }
        if (zzacpVar != null) {
            return zzacpVar;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            try {
                return (zzacj) Class.forName(str).getConstructor(null).newInstance(null);
            } catch (Throwable th) {
                th = th;
                sb.append('\n');
                sb.append(str);
                sb.append(": ");
                if (th instanceof InvocationTargetException) {
                    th = th.getCause();
                }
                sb.append(th);
            }
        }
        throw new IllegalStateException(sb.insert(0, "No logging platforms found:").toString());
    }
}
