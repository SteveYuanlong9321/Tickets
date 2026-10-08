package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.nearby.uwb.PreciseEstimateInfo;
import com.google.android.gms.nearby.uwb.RangingMeasurement;
import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.android.gms.nearby.uwb.RangingSessionCallback;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgy extends zzdo {
    final /* synthetic */ zzhq zza;
    private final ListenerHolder zzb;
    private final RangingSessionCallback zzc;
    private final zzcr zzd;

    zzgy(zzhq zzhqVar, RangingSessionCallback rangingSessionCallback, zzcr zzcrVar) {
        Objects.requireNonNull(zzhqVar);
        this.zza = zzhqVar;
        this.zzb = zzhqVar.registerListener(rangingSessionCallback, RangingSessionCallback.class.getName());
        this.zzc = rangingSessionCallback;
        this.zzd = zzcrVar;
    }

    private static final RangingMeasurement zzk(zzfc zzfcVar) {
        return new RangingMeasurement(zzfcVar.zza(), zzfcVar.zzb());
    }

    final /* synthetic */ void zzb(zzej zzejVar) {
        this.zzb.notifyListener(new zzgr(this, zzejVar));
    }

    final /* synthetic */ RangingPosition zzc(zzfh zzfhVar) {
        RangingMeasurement rangingMeasurementZzk = zzk(zzfhVar.zza());
        PreciseEstimateInfo preciseEstimateInfo = null;
        RangingMeasurement rangingMeasurementZzk2 = zzfhVar.zzb() != null ? zzk(zzfhVar.zzb()) : null;
        RangingMeasurement rangingMeasurementZzk3 = zzfhVar.zzc() != null ? zzk(zzfhVar.zzc()) : null;
        zzep zzepVarZzg = zzfhVar.zzg();
        if (zzepVarZzg != null) {
            preciseEstimateInfo = new PreciseEstimateInfo(zzepVarZzg.zza(), this.zzd.zze(zzepVarZzg.zzb()));
        }
        return new RangingPosition(rangingMeasurementZzk, rangingMeasurementZzk2, rangingMeasurementZzk3, zzfhVar.zzd(), zzfhVar.zze(), zzfhVar.zzf(), preciseEstimateInfo);
    }

    @Override // com.google.android.gms.internal.nearby.zzdp
    public final void zzd(final zzej zzejVar) {
        int i = zzhq.zza;
        final Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.nearby.zzgw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzb(zzejVar);
            }
        };
        this.zza.doRegisterEventListener(RegistrationMethods.builder().register(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzgx
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                runnable.run();
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).unregister(zzgv.zza).withHolder(this.zzb).setFeatures(com.google.android.gms.nearby.zza.zzA).setMethodKey(1304).build());
    }

    @Override // com.google.android.gms.internal.nearby.zzdp
    public final void zze(zzel zzelVar) {
        int i = zzhq.zza;
        this.zzb.notifyListener(new zzgs(this, zzelVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzdp
    public final void zzf(zzen zzenVar) {
        this.zzd.zzd();
        int i = zzhq.zza;
        this.zzb.notifyListener(new zzgt(this, zzenVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzdp
    public final void zzg(zzef zzefVar) {
        int i = zzhq.zza;
        this.zzb.notifyListener(new zzgu(this, zzefVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzdp
    public final void zzh(zzeh zzehVar) {
        this.zzd.zzc(zzehVar);
    }

    final /* synthetic */ RangingSessionCallback zzi() {
        return this.zzc;
    }
}
