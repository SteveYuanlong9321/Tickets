package com.google.android.gms.nearby.internal.connection;

import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzr extends zzan {
    final /* synthetic */ zzer zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzr(zzv zzvVar, zzer zzerVar) {
        super(null);
        this.zza = zzerVar;
        Objects.requireNonNull(zzvVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        zzer zzerVar = this.zza;
        String strZza = zzerVar.zza();
        com.google.android.gms.nearby.connection.zze zzeVar = new com.google.android.gms.nearby.connection.zze();
        zzeVar.zza(zzerVar.zzb());
        zzeVar.zzb(zzerVar.zzh());
        zzeVar.zzc(zzerVar.zzc());
        zzeVar.zzd(zzerVar.zzd());
        zzeVar.zze(zzerVar.zze());
        zzeVar.zzf(zzerVar.zzf());
        zzeVar.zzg(zzerVar.zzg());
        zzeVar.zzh(zzerVar.zzi());
        zzeVar.zzi(zzerVar.zzj());
        zzeVar.zzj(zzerVar.zzk());
        zzeVar.zzk(zzerVar.zzl());
        zzeVar.zzl(zzerVar.zzm());
        ((ConnectionLifecycleCallback) obj).onBandwidthChanged(strZza, zzeVar.zzm());
    }
}
