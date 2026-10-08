package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzo extends zzan {
    final /* synthetic */ zzet zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzo(zzv zzvVar, zzet zzetVar) {
        super(null);
        this.zza = zzetVar;
        Objects.requireNonNull(zzvVar);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0047 A[PHI: r3
      0x0047: PHI (r3v1 int) = (r3v0 int), (r3v2 int) binds: [B:5:0x0041, B:7:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        zzet zzetVar = this.zza;
        ConnectionLifecycleCallback connectionLifecycleCallback = (ConnectionLifecycleCallback) obj;
        String strZza = zzetVar.zza();
        com.google.android.gms.nearby.connection.zzm zzmVar = new com.google.android.gms.nearby.connection.zzm();
        zzmVar.zza(zzetVar.zzb());
        zzmVar.zzb(zzetVar.zzc());
        zzmVar.zzc(zzetVar.zze());
        zzmVar.zzd(zzetVar.zzd());
        zzmVar.zze(zzetVar.zzf());
        zzmVar.zzf(zzetVar.zzg());
        int iZzh = zzetVar.zzh();
        int i = zzaw.zze;
        int i2 = 0;
        if (iZzh != 0) {
            int i3 = 1;
            if (iZzh != 1) {
                i3 = 2;
                if (iZzh == 2) {
                    i2 = i3;
                }
            } else {
                i2 = i3;
            }
        }
        zzmVar.zzg(i2);
        connectionLifecycleCallback.onConnectionInitiated(strZza, zzmVar.zzh());
    }
}
