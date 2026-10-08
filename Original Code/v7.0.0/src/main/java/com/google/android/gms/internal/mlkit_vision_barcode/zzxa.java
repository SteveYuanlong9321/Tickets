package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzxa {
    private static zzwz zza;

    public static synchronized zzwp zza(zzwh zzwhVar) {
        zzwz zzwzVar;
        zzwzVar = zza;
        if (zzwzVar == null) {
            zzwzVar = new zzwz(null);
            zza = zzwzVar;
        }
        return (zzwp) zzwzVar.get(zzwhVar);
    }

    public static synchronized zzwp zzb(String str) {
        return zza(zzwh.zzd(str).zzd());
    }
}
