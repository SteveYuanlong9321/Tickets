package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.nearby.uwb.RangingCapabilities;
import com.google.android.gms.nearby.uwb.RangingControleeParameters;
import com.google.android.gms.nearby.uwb.RangingParameters;
import com.google.android.gms.nearby.uwb.RangingSessionCallback;
import com.google.android.gms.nearby.uwb.UwbAddress;
import com.google.android.gms.nearby.uwb.UwbAvailabilityObserver;
import com.google.android.gms.nearby.uwb.UwbClient;
import com.google.android.gms.nearby.uwb.UwbComplexChannel;
import com.google.android.gms.nearby.uwb.UwbDevice;
import com.google.android.gms.nearby.uwb.UwbRangeDataNtfConfig;
import com.google.android.gms.nearby.uwb.UwbRangeLimitsConfig;
import com.google.android.gms.nearby.uwb.UwbStatusCodes;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhq extends GoogleApi implements UwbClient {
    public static final /* synthetic */ int zza = 0;
    private static final Api zzb = new Api("Nearby.UWB_API", new zzgk(), new Api.ClientKey());

    @Nullable
    private UwbAddress zzc;

    @Nullable
    private zzgq zzd;

    @Nullable
    private UwbComplexChannel zze;

    public zzhq(Context context, com.google.android.gms.nearby.uwb.zzc zzcVar) {
        super(context, (Api<com.google.android.gms.nearby.uwb.zzc>) zzb, zzcVar, GoogleApi.Settings.DEFAULT_SETTINGS);
        new HashMap();
    }

    static final /* synthetic */ zzyg zzi(int[] iArr) {
        int length;
        if (iArr == null || (length = iArr.length) == 0) {
            return zzyg.zzj();
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return zzyg.zzs(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public final void zzd(RangingSessionCallback rangingSessionCallback) {
        doUnregisterEventListener(ListenerHolders.createListenerKey(rangingSessionCallback, RangingSessionCallback.class.getName()), 1305);
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Void> addControlee(final UwbAddress uwbAddress) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhl
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                zzdj zzdjVar = (zzdj) ((zzgg) obj).getService();
                zzch zzchVar = new zzch();
                zzga zzgaVar = new zzga();
                zzgaVar.zza(uwbAddress.getAddress());
                zzchVar.zzb(zzgaVar.zzb());
                zzchVar.zza(new zzgp(this.zza, (TaskCompletionSource) obj2));
                zzdjVar.zzk(zzchVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzB).setMethodKey(1316).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Void> addControleeWithSessionParams(final RangingControleeParameters rangingControleeParameters) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhm
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                zzdj zzdjVar = (zzdj) ((zzgg) obj).getService();
                zzck zzckVar = new zzck();
                zzez zzezVar = new zzez();
                zzga zzgaVar = new zzga();
                RangingControleeParameters rangingControleeParameters2 = rangingControleeParameters;
                zzgaVar.zza(rangingControleeParameters2.getAddress().getAddress());
                zzezVar.zza(zzgaVar.zzb());
                zzezVar.zzb(rangingControleeParameters2.getSubSessionId());
                zzezVar.zzc(rangingControleeParameters2.getSubSessionKey());
                zzckVar.zzb(zzezVar.zzd());
                zzckVar.zza(new zzgp(this.zza, (TaskCompletionSource) obj2));
                zzdjVar.zzm(zzckVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzE).setMethodKey(1316).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<UwbComplexChannel> getComplexChannel() {
        if (((com.google.android.gms.nearby.uwb.zzc) getApiOptions()).zza() == 2) {
            return Tasks.forException(new ApiException(new Status(UwbStatusCodes.INVALID_API_CALL)));
        }
        UwbComplexChannel uwbComplexChannel = this.zze;
        return uwbComplexChannel != null ? Tasks.forResult(uwbComplexChannel) : doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhh
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                zzdj zzdjVar = (zzdj) ((zzgg) obj).getService();
                zzcw zzcwVar = new zzcw();
                zzcwVar.zza(new zzgo(this.zza, (TaskCompletionSource) obj2));
                zzdjVar.zzg(zzcwVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzA).setMethodKey(1303).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<UwbAddress> getLocalAddress() {
        UwbAddress uwbAddress = this.zzc;
        return uwbAddress != null ? Tasks.forResult(uwbAddress) : doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhg
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                zzdj zzdjVar = (zzdj) ((zzgg) obj).getService();
                zzcz zzczVar = new zzcz();
                zzczVar.zza(new zzgn(this.zza, (TaskCompletionSource) obj2));
                zzdjVar.zzf(zzczVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzA).setMethodKey(1302).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<RangingCapabilities> getRangingCapabilities() {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzgz
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                zzdj zzdjVar = (zzdj) ((zzgg) obj).getService();
                zzdc zzdcVar = new zzdc();
                zzdcVar.zza(new zzgm(this.zza, (TaskCompletionSource) obj2));
                zzdjVar.zze(zzdcVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzA).setMethodKey(1301).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Boolean> isAvailable() {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhp
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                zzdj zzdjVar = (zzdj) ((zzgg) obj).getService();
                zzec zzecVar = new zzec();
                zzecVar.zza(new zzgl(this.zza, (TaskCompletionSource) obj2));
                zzdjVar.zzd(zzecVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzA).setMethodKey(1300).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Void> reconfigureRangeDataNtf(final int i, final int i2, final int i3) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzha
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                zzdj zzdjVar = (zzdj) ((zzgg) obj).getService();
                zzfj zzfjVar = new zzfj();
                zzer zzerVar = new zzer();
                zzerVar.zza(i);
                zzerVar.zzb(i2);
                zzerVar.zzc(i3);
                zzfjVar.zzb(zzerVar.zzd());
                zzfjVar.zza(new zzgp(this.zza, (TaskCompletionSource) obj2));
                zzdjVar.zzo(zzfjVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzF).setMethodKey(1380).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Void> reconfigureRangingInterval(final int i) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzho
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                zzdj zzdjVar = (zzdj) ((zzgg) obj).getService();
                zzfm zzfmVar = new zzfm();
                zzfmVar.zzb(i);
                zzfmVar.zza(new zzgp(this.zza, (TaskCompletionSource) obj2));
                zzdjVar.zzn(zzfmVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzG).setMethodKey(1381).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Void> removeControlee(final UwbAddress uwbAddress) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhn
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                zzdj zzdjVar = (zzdj) ((zzgg) obj).getService();
                zzfp zzfpVar = new zzfp();
                zzga zzgaVar = new zzga();
                zzgaVar.zza(uwbAddress.getAddress());
                zzfpVar.zzb(zzgaVar.zzb());
                zzfpVar.zza(new zzgp(this.zza, (TaskCompletionSource) obj2));
                zzdjVar.zzl(zzfpVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzC).setMethodKey(1317).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Void> startRanging(final RangingParameters rangingParameters, RangingSessionCallback rangingSessionCallback) {
        final UwbAddress uwbAddress = this.zzc;
        UwbComplexChannel uwbComplexChannel = this.zze;
        if (uwbAddress == null) {
            return Tasks.forException(new ApiException(new Status(UwbStatusCodes.INVALID_API_CALL)));
        }
        if (uwbComplexChannel == null && rangingParameters.getComplexChannel() == null) {
            return Tasks.forException(new ApiException(new Status(UwbStatusCodes.INVALID_API_CALL)));
        }
        try {
            final zzcr zzcrVarZza = zzcr.zza(this, rangingParameters);
            final zzgy zzgyVar = new zzgy(this, rangingSessionCallback, zzcrVarZza);
            return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhi
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                    this.zza.zza(uwbAddress, rangingParameters, zzgyVar, (zzgg) obj, (TaskCompletionSource) obj2);
                }
            }).setMethodKey(1304).setFeatures(com.google.android.gms.nearby.zza.zzA).build()).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.gms.internal.nearby.zzhj
                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final /* synthetic */ Task then(Object obj) {
                    Task taskZzb = zzcrVarZza.zzb();
                    final zzhq zzhqVar = this.zza;
                    taskZzb.addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.internal.nearby.zzhf
                        @Override // com.google.android.gms.tasks.OnFailureListener
                        public final /* synthetic */ void onFailure(Exception exc) {
                            zzhqVar.doWrite(TaskApiCall.builder().run(zzhc.zza).setFeatures(com.google.android.gms.nearby.zza.zzA).setMethodKey(1444).build());
                        }
                    });
                    return taskZzb;
                }
            });
        } catch (ApiException e) {
            return Tasks.forException(e);
        }
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Void> stopRanging(final RangingSessionCallback rangingSessionCallback) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhk
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                this.zza.zzb(rangingSessionCallback, (zzgg) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(1305).setFeatures(com.google.android.gms.nearby.zza.zzA).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Void> subscribeToUwbAvailability(UwbAvailabilityObserver uwbAvailabilityObserver) {
        zzgq zzgqVar = this.zzd;
        if (zzgqVar != null) {
            doUnregisterEventListener(ListenerHolders.createListenerKey((UwbAvailabilityObserver) Objects.requireNonNull(zzgqVar.zzb()), UwbAvailabilityObserver.class.getName()), 1391);
            zzgq zzgqVar2 = (zzgq) Objects.requireNonNull(this.zzd);
            this.zzd = null;
            doWrite(TaskApiCall.builder().run(new zzhe(zzgqVar2)).setMethodKey(1391).setFeatures(com.google.android.gms.nearby.zza.zzA).build());
        }
        this.zzd = new zzgq(this, uwbAvailabilityObserver);
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhd
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                this.zza.zzc((zzgg) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(1390).setFeatures(com.google.android.gms.nearby.zza.zzA).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Void> unsubscribeFromUwbAvailability() {
        zzgq zzgqVar = this.zzd;
        if (zzgqVar == null) {
            return Tasks.forCanceled();
        }
        doUnregisterEventListener(ListenerHolders.createListenerKey((UwbAvailabilityObserver) Objects.requireNonNull(zzgqVar.zzb()), UwbAvailabilityObserver.class.getName()), 1391);
        zzgq zzgqVar2 = (zzgq) Objects.requireNonNull(this.zzd);
        this.zzd = null;
        return doWrite(TaskApiCall.builder().run(new zzhe(zzgqVar2)).setMethodKey(1391).setFeatures(com.google.android.gms.nearby.zza.zzA).build());
    }

    final /* synthetic */ void zza(UwbAddress uwbAddress, RangingParameters rangingParameters, zzgy zzgyVar, zzgg zzggVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzhs[] zzhsVarArr;
        zzdj zzdjVar = (zzdj) zzggVar.getService();
        zzfs zzfsVar = new zzfs();
        UwbComplexChannel uwbComplexChannel = this.zze;
        zzfe zzfeVar = new zzfe();
        zzfeVar.zzb(rangingParameters.getSessionId());
        zzfeVar.zza(rangingParameters.getUwbConfigId());
        zzfeVar.zze(rangingParameters.getRangingUpdateRate());
        int i = 0;
        if (rangingParameters.getPeerDevices().isEmpty()) {
            zzhsVarArr = new zzhs[0];
        } else {
            zzhsVarArr = new zzhs[rangingParameters.getPeerDevices().size()];
            for (UwbDevice uwbDevice : rangingParameters.getPeerDevices()) {
                zzhr zzhrVar = new zzhr();
                zzga zzgaVar = new zzga();
                zzgaVar.zza(uwbDevice.getAddress().getAddress());
                zzhrVar.zza(zzgaVar.zzb());
                zzhsVarArr[i] = zzhrVar.zzb();
                i++;
            }
        }
        zzfeVar.zzf(zzhsVarArr);
        zzhr zzhrVar2 = new zzhr();
        zzga zzgaVar2 = new zzga();
        zzgaVar2.zza(uwbAddress.getAddress());
        zzhrVar2.zza(zzgaVar2.zzb());
        zzfeVar.zzi(zzhrVar2.zzb());
        zzfeVar.zzk(rangingParameters.getSlotDuration());
        zzfeVar.zzl(rangingParameters.isAoaDisabled());
        zzfeVar.zzn(rangingParameters.getPrecisionFindingConfig());
        byte[] sessionKeyInfo = rangingParameters.getSessionKeyInfo();
        if (sessionKeyInfo != null) {
            zzfeVar.zzc(sessionKeyInfo);
        }
        UwbComplexChannel complexChannel = rangingParameters.getComplexChannel();
        if (complexChannel != null) {
            uwbComplexChannel = complexChannel;
        }
        if (uwbComplexChannel != null) {
            zzgh zzghVar = new zzgh();
            zzghVar.zza(uwbComplexChannel.getChannel());
            zzghVar.zzb(uwbComplexChannel.getPreambleIndex());
            zzfeVar.zzd(zzghVar.zzc());
        }
        UwbRangeDataNtfConfig uwbRangeDataNtfConfig = rangingParameters.getUwbRangeDataNtfConfig();
        if (uwbRangeDataNtfConfig == null) {
            uwbRangeDataNtfConfig = new UwbRangeDataNtfConfig.Builder().build();
        }
        zzer zzerVar = new zzer();
        zzerVar.zza(uwbRangeDataNtfConfig.getRangeDataNtfConfigType());
        zzerVar.zzb(uwbRangeDataNtfConfig.getNtfProximityNear());
        zzerVar.zzc(uwbRangeDataNtfConfig.getNtfProximityFar());
        zzfeVar.zzj(zzerVar.zzd());
        byte[] subSessionKeyInfo = rangingParameters.getSubSessionKeyInfo();
        if (subSessionKeyInfo != null) {
            zzfeVar.zzg(rangingParameters.getSubSessionId());
            zzfeVar.zzh(subSessionKeyInfo);
        }
        UwbRangeLimitsConfig uwbRangeLimitsConfigZza = rangingParameters.zza();
        zzeu zzeuVar = new zzeu();
        zzeuVar.zza(uwbRangeLimitsConfigZza.getRangeMaxNumberOfMeasurements());
        zzeuVar.zzb(uwbRangeLimitsConfigZza.getRangeMaxRangingRoundRetries());
        zzfeVar.zzm(zzeuVar.zzc());
        zzfsVar.zzb(zzfeVar.zzo());
        zzfsVar.zzc(zzgyVar);
        zzfsVar.zza(new zzgp(this, taskCompletionSource));
        zzdjVar.zzh(zzfsVar.zzd());
    }

    final /* synthetic */ void zzb(RangingSessionCallback rangingSessionCallback, zzgg zzggVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzdj zzdjVar = (zzdj) zzggVar.getService();
        zzfx zzfxVar = new zzfx();
        zzfxVar.zza(new zzgp(this, taskCompletionSource));
        zzdjVar.zzi(zzfxVar.zzb());
        zzd(rangingSessionCallback);
        this.zzc = null;
        this.zze = null;
    }

    final /* synthetic */ void zzc(zzgg zzggVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzdj zzdjVar = (zzdj) zzggVar.getService();
        zzgd zzgdVar = new zzgd();
        zzgdVar.zza((zzdy) Objects.requireNonNull(this.zzd));
        zzdjVar.zzp(zzgdVar.zzb());
        taskCompletionSource.setResult(null);
    }

    final /* synthetic */ UwbAddress zze() {
        return this.zzc;
    }

    final /* synthetic */ void zzf(UwbAddress uwbAddress) {
        this.zzc = uwbAddress;
    }

    final /* synthetic */ UwbComplexChannel zzg() {
        return this.zze;
    }

    final /* synthetic */ void zzh(UwbComplexChannel uwbComplexChannel) {
        this.zze = uwbComplexChannel;
    }
}
