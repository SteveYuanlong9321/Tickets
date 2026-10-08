package com.google.android.gms.internal.nearby;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzakm {
    private final zzakl zza;

    private zzakm(zzalz zzalzVar, Object obj, zzalz zzalzVar2, Object obj2) {
        this.zza = new zzakl(zzalzVar, "", zzalzVar2, obj2);
    }

    public static zzakm zza(zzalz zzalzVar, Object obj, zzalz zzalzVar2, Object obj2) {
        return new zzakm(zzalzVar, "", zzalzVar2, obj2);
    }

    static void zzb(zzaiu zzaiuVar, zzakl zzaklVar, Object obj, Object obj2) throws IOException {
        zzaje.zze(zzaiuVar, zzaklVar.zza, 1, obj);
        zzaje.zze(zzaiuVar, zzaklVar.zzc, 2, obj2);
    }

    static int zzc(zzakl zzaklVar, Object obj, Object obj2) {
        return zzaje.zzf(zzaklVar.zza, 1, obj) + zzaje.zzf(zzaklVar.zzc, 2, obj2);
    }

    public final int zzd(int i, Object obj, Object obj2) {
        int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i << 3) * 9;
        int iZzc = zzc(this.zza, obj, obj2);
        return ((352 - iNumberOfLeadingZeros) >>> 6) + ((352 - (Integer.numberOfLeadingZeros(iZzc) * 9)) >>> 6) + iZzc;
    }

    final zzakl zze() {
        return this.zza;
    }
}
