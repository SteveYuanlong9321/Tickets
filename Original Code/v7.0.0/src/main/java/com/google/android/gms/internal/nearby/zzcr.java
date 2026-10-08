package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.nearby.uwb.ArOdometryProvider;
import com.google.android.gms.nearby.uwb.PrecisionFindingConfig;
import com.google.android.gms.nearby.uwb.RangingParameters;
import com.google.android.gms.nearby.uwb.UwbStatusCodes;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import java.util.function.Consumer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcr {
    private static final String zza = "zzcr";
    private final zzhq zzb;
    private final zzjz zzc;
    private final TaskCompletionSource zzd;

    private zzcr(zzhq zzhqVar, zzjz zzjzVar, TaskCompletionSource taskCompletionSource) {
        this.zzb = zzhqVar;
        this.zzc = zzjzVar;
        this.zzd = taskCompletionSource;
    }

    static zzcr zza(zzhq zzhqVar, RangingParameters rangingParameters) throws ApiException {
        PrecisionFindingConfig precisionFindingConfig = rangingParameters.getPrecisionFindingConfig();
        if (precisionFindingConfig == null) {
            return zzf(zzhqVar, new Status(0));
        }
        if (rangingParameters.getUwbRangeDataNtfConfig().getRangeDataNtfConfigType() == 0) {
            return zzf(zzhqVar, new Status(0));
        }
        if (rangingParameters.getPeerDevices().size() != 1) {
            Log.w(zza, "Attempt to configure precision finding for multicast session");
            throw new ApiException(new Status(UwbStatusCodes.INVALID_API_CALL));
        }
        if (!PrecisionFindingConfig.zza.contains(Integer.valueOf(rangingParameters.getUwbConfigId()))) {
            Log.w(zza, "Attempt to configure precision finding for unsupported config id");
            throw new ApiException(new Status(UwbStatusCodes.INVALID_API_CALL));
        }
        ArOdometryProvider arOdometryProvider = precisionFindingConfig.getArOdometryProvider();
        if (arOdometryProvider != null) {
            return zzg(zzhqVar, new zzjz(arOdometryProvider.getSession(), arOdometryProvider.getGlContextThreadExecutor()));
        }
        try {
            return zzg(zzhqVar, new zzjz(zzhqVar.getApplicationContext()));
        } catch (zzwe unused) {
            throw new ApiException(new Status(UwbStatusCodes.ARCORE_APK_TOO_OLD));
        } catch (zzwf unused2) {
            throw new ApiException(new Status(UwbStatusCodes.ARCORE_NOT_INSTALLED));
        } catch (zzwg unused3) {
            return zzf(zzhqVar, new Status(UwbStatusCodes.ARCORE_DEVICE_NOT_COMPATIBLE));
        } catch (zzwi unused4) {
            return zzf(zzhqVar, new Status(UwbStatusCodes.ARCORE_SDK_TOO_OLD));
        }
    }

    private static zzcr zzf(zzhq zzhqVar, Status status) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (status.getStatusCode() == 0) {
            taskCompletionSource.setResult(null);
        } else {
            taskCompletionSource.setException(new ApiException(status));
        }
        return new zzcr(zzhqVar, null, taskCompletionSource);
    }

    private static zzcr zzg(zzhq zzhqVar, zzjz zzjzVar) {
        return new zzcr(zzhqVar, zzjzVar, new TaskCompletionSource());
    }

    final synchronized Task zzb() {
        return this.zzd.getTask();
    }

    final synchronized void zzc(zzeh zzehVar) {
        zzjz zzjzVar = this.zzc;
        if (zzjzVar == null) {
            return;
        }
        TaskCompletionSource taskCompletionSource = this.zzd;
        if (taskCompletionSource.getTask().isComplete()) {
            Log.w(zza, "Attempted to start odometry polling more than once");
            return;
        }
        zzjl zzjlVarZzb = zzehVar.zzb();
        Status status = new Status(zzehVar.zza());
        if (zzjlVarZzb == null) {
            if (status.getStatusCode() == 0) {
                taskCompletionSource.setResult(null);
                return;
            } else {
                taskCompletionSource.setException(new ApiException(status));
                return;
            }
        }
        try {
            final zzhq zzhqVar = this.zzb;
            Objects.requireNonNull(zzhqVar);
            zzjzVar.zza(new Consumer() { // from class: com.google.android.gms.internal.nearby.zzcq
                @Override // java.util.function.Consumer
                public final /* synthetic */ void accept(Object obj) {
                    final zzjk zzjkVar = (zzjk) obj;
                    zzhqVar.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhb
                        @Override // com.google.android.gms.common.api.internal.RemoteCall
                        public final /* synthetic */ void accept(Object obj2, Object obj3) throws RemoteException {
                            int i = zzhq.zza;
                            zzdj zzdjVar = (zzdj) ((zzgg) obj2).getService();
                            zzcn zzcnVar = new zzcn();
                            zzcnVar.zza(zzjkVar);
                            zzdjVar.zzr(zzcnVar.zzb());
                            ((TaskCompletionSource) obj3).setResult(null);
                        }
                    }).setFeatures(com.google.android.gms.nearby.zza.zzA).setMethodKey(1443).build());
                }
            }, zzjlVarZzb);
            taskCompletionSource.setResult(null);
        } catch (zzwa unused) {
            this.zzd.setException(new ApiException(new Status(UwbStatusCodes.ARCORE_CAMERA_NOT_AVAILABLE)));
        } catch (zzwc unused2) {
            this.zzd.setException(new ApiException(new Status(UwbStatusCodes.ARCORE_MISSING_GL_CONTEXT)));
        }
    }

    final synchronized void zzd() {
        zzjz zzjzVar = this.zzc;
        if (zzjzVar == null) {
            return;
        }
        if (this.zzd.getTask().isComplete()) {
            zzjzVar.zzc();
        } else {
            Log.w(zza, "Attempted to stop odometry polling before it started");
        }
    }

    final synchronized int zze(int i) {
        int i2 = 0;
        if (i == 0) {
            return 0;
        }
        int i3 = 8;
        if (i == 1) {
            zzjz zzjzVar = this.zzc;
            if (zzjzVar != null) {
                Integer numZzb = zzjzVar.zzb();
                Object[] objArr = {0, 1, 2, 3, 4, 5};
                if (numZzb != null) {
                    while (i2 < 6) {
                        Object obj = objArr[i2];
                        if (obj instanceof Class) {
                            if (((Class) obj).isInstance(numZzb)) {
                                break;
                            }
                            i2++;
                        } else {
                            if (obj.equals(numZzb)) {
                                break;
                            }
                            i2++;
                        }
                        return i3;
                    }
                    switch (i2) {
                        case 1:
                            i3 = 2;
                            break;
                        case 2:
                            i3 = 3;
                            break;
                        case 3:
                            i3 = 4;
                            break;
                        case 4:
                            i3 = 5;
                            break;
                        case 5:
                            i3 = 9;
                            break;
                    }
                    return i3;
                }
            }
        } else {
            if (i == 3) {
                return 6;
            }
            if (i == 4) {
                return 7;
            }
            if (i == 5) {
                return 8;
            }
        }
        i3 = 1;
        return i3;
    }
}
