package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzxa {
    public static final StringBuilder zza(StringBuilder sb, Iterator it, String str) {
        try {
            if (it.hasNext()) {
                sb.append(zzb(it.next(), str));
                while (it.hasNext()) {
                    sb.append((CharSequence) str);
                    sb.append(zzb(it.next(), str));
                }
            }
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    static final CharSequence zzb(Object obj, String str) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
