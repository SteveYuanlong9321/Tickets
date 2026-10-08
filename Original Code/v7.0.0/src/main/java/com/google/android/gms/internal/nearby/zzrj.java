package com.google.android.gms.internal.nearby;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrj {
    private static final Pattern zza = Pattern.compile("(\\w+).*");

    public static String zza(String str) {
        Matcher matcher = zza.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        String.valueOf(str);
        throw new IllegalArgumentException("Invalid fragment spec: ".concat(String.valueOf(str)));
    }

    @Nullable
    public static String zzb(List list) {
        if (list.isEmpty()) {
            return null;
        }
        zzzm zzzmVarListIterator = ((zzyg) list).listIterator(0);
        StringBuilder sb = new StringBuilder();
        zzxa.zza(sb, zzzmVarListIterator, "+");
        return "transform=".concat(sb.toString());
    }
}
