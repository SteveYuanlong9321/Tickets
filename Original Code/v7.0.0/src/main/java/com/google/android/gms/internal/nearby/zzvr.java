package com.google.android.gms.internal.nearby;

import java.util.HashMap;
import java.util.Random;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzvr {
    static {
        Math.abs(new Random().nextInt());
        new HashMap();
    }

    @JvmStatic
    public static final Runnable zza(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        return new zzvq(new Ref.ObjectRef(), zzup.zzb(false), runnable);
    }

    @JvmStatic
    public static final zzafp zzb(zzafp asyncCallable) {
        Intrinsics.checkNotNullParameter(asyncCallable, "asyncCallable");
        return new zzvo(zzup.zzb(false), asyncCallable);
    }

    @JvmStatic
    public static final zzafq zzc(zzafq asyncFunction) {
        Intrinsics.checkNotNullParameter(asyncFunction, "asyncFunction");
        return new zzvp(zzup.zzb(false), asyncFunction);
    }
}
