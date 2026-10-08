package com.google.android.gms.internal.nearby;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzxj {
    private final zzww zza;
    private final boolean zzb;
    private final zzxh zzc;

    private zzxj(zzxh zzxhVar, boolean z, zzww zzwwVar, int i) {
        this.zzc = zzxhVar;
        this.zzb = z;
        this.zza = zzwwVar;
    }

    public static zzxj zza(String str) {
        return new zzxj(new zzxh(new zzwt("+".charAt(0))), false, zzwv.zza, Integer.MAX_VALUE);
    }

    public final zzxj zzb() {
        return new zzxj(this.zzc, true, this.zza, Integer.MAX_VALUE);
    }

    final /* synthetic */ Iterator zzd(CharSequence charSequence) {
        return this.zzc.zza(this, charSequence);
    }

    final /* synthetic */ boolean zze() {
        return this.zzb;
    }

    public final Iterable zzc(CharSequence charSequence) {
        charSequence.getClass();
        return new zzxg(this, charSequence);
    }
}
