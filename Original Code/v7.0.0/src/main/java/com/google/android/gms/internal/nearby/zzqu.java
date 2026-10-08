package com.google.android.gms.internal.nearby;

import android.accounts.Account;
import android.content.Context;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzqu {
    public static final /* synthetic */ int zzb = 0;
    private static final Pattern zzc = Pattern.compile("[a-z]+(_[a-z]+)*");
    static final Account zza = zzqp.zza;
    private static final Set zzd = Collections.unmodifiableSet(new HashSet(Arrays.asList("default", "unused", "special", "reserved", "shared", "virtual", "managed")));

    static {
        Collections.unmodifiableSet(new HashSet(Arrays.asList("files", "cache", "managed", "directboot-files", "directboot-cache", "external")));
    }

    public static zzqt zza(Context context) {
        return new zzqt(context, null);
    }

    static void zzb(String str) {
        zzrk.zza(zzc.matcher("phenotype").matches(), "Module must match [a-z]+(_[a-z]+)*: %s", "phenotype");
        zzrk.zza(!zzd.contains("phenotype"), "Module name is reserved and cannot be used: %s", "phenotype");
    }
}
