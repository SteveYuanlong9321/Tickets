package com.google.android.gms.internal.nearby;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaw {
    private static final Map zza = new HashMap();
    private static final zzyj zzb;
    private static final zzh zzc;

    static {
        zzyi zzyiVar = new zzyi();
        zzyiVar.zza("NearbyConnections", zzh.NEARBY_CONNECTIONS);
        zzyiVar.zza("NearbyMediums", zzh.NEARBY_CONNECTIONS);
        zzyiVar.zza("NearbyMessages", zzh.NEARBY_MESSAGES);
        zzyiVar.zza("NearbySetup", zzh.NEARBY_SETUP);
        zzyiVar.zza("NearbySharing", zzh.NEARBY_SHARING);
        zzyiVar.zza("ExposureNotification", zzh.NEARBY_EXPOSURE_NOTIFICATION);
        zzyiVar.zza("NearbyFastPair", zzh.NEARBY_FAST_PAIR);
        zzyiVar.zza("NearbyDiscovery", zzh.NEARBY_FAST_PAIR);
        zzyiVar.zza("ENPromos", zzh.EXPOSURE_NOTIFICATION_PROMOS);
        zzyiVar.zza("NearbyPresence", zzh.NEARBY_PRESENCE);
        zzb = zzyiVar.zzb();
        zzc = zzh.NEARBY;
    }

    public static synchronized zzi zza(String str) {
        Map map = zza;
        zzi zziVar = (zzi) map.get("Nearby");
        if (zziVar != null) {
            return zziVar;
        }
        zzi zziVar2 = new zzi(zzacj.zzd("Nearby"), (zzh) zzb.getOrDefault("Nearby", zzc), null);
        map.put("Nearby", zziVar2);
        return zziVar2;
    }
}
