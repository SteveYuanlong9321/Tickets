package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zziy extends GoogleApi {
    public static final /* synthetic */ int zza = 0;

    static {
        Pair.create(zzja.zza(0L), Tasks.forResult(null));
    }

    protected zziy(Context context) {
        super(context, (Api<Api.ApiOptions.NoOptions>) zzim.zza, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final Task zza(final String str, String str2, @Nullable String str3) {
        final String str4 = null;
        final String str5 = "";
        return doRead(TaskApiCall.builder().run(new RemoteCall(str, str5, str4) { // from class: com.google.android.gms.internal.nearby.zziw
            private final /* synthetic */ String zza;
            private final /* synthetic */ String zzb = "";

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                int i = zziy.zza;
                ((zzjh) ((zzji) obj).getService()).zzd(new zzix((TaskCompletionSource) obj2, null), this.zza, this.zzb, null);
            }
        }).build());
    }

    public final Task zzb(final String str) {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zziq
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                int i = zziy.zza;
                ((zzjh) ((zzji) obj).getService()).zze(new zzix((TaskCompletionSource) obj2, null), str);
            }
        }).build());
    }

    public final Task zzd() {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzit
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                ((zzjh) ((zzji) obj).getService()).zzg(new zzin(this.zza, (TaskCompletionSource) obj2));
            }
        }).setFeatures(zzic.zzi).setAutoResolveMissingFeatures(false).build());
    }

    public final Task zze(zzoe zzoeVar) throws Throwable {
        final String string;
        final ListenerHolder listenerHolderRegisterListener = registerListener(zzoeVar, "zzji");
        String myProcessName = ProcessUtils.getMyProcessName();
        if (myProcessName == null) {
            string = "__PH_INTERNAL__NO_PROCESS__";
        } else {
            int length = myProcessName.length() + 1;
            int iIdentityHashCode = System.identityHashCode(zzji.class);
            StringBuilder sb = new StringBuilder(length + String.valueOf(iIdentityHashCode).length());
            sb.append(myProcessName);
            sb.append("|");
            sb.append(iIdentityHashCode);
            string = sb.toString();
        }
        return doRegisterEventListener(RegistrationMethods.builder().withHolder(listenerHolderRegisterListener).register(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zziu
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                ((zzjh) ((zzji) obj).getService()).zzh(string, new zzip(this.zza, listenerHolderRegisterListener));
            }
        }).unregister(zziv.zza).setFeatures(zzic.zzd).setAutoResolveMissingFeatures(false).build());
    }

    public final Task zzc(final zzle zzleVar) {
        zzleVar.getClass();
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzir
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                int i = zziy.zza;
                ((zzjh) ((zzji) obj).getService()).zzf(new zzix((TaskCompletionSource) obj2, null), zzleVar.zzv());
            }
        }).setFeatures(zzic.zza).setAutoResolveMissingFeatures(false).build()).continueWithTask(zzahg.zza(), new Continuation() { // from class: com.google.android.gms.internal.nearby.zzis
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                Exception exception = task.getException();
                if (exception != null) {
                    Objects.requireNonNull(exception);
                    int i = 0;
                    while (true) {
                        Object[] objArr = {UnsupportedApiCallException.class, ApiException.class, ApiException.class};
                        while (i < 3) {
                            Object obj = objArr[i];
                            if (obj instanceof Class) {
                                if (((Class) obj).isInstance(exception)) {
                                    break;
                                }
                                i++;
                            } else {
                                if (obj.equals(exception)) {
                                    break;
                                }
                                i++;
                            }
                        }
                        zzle zzleVar2 = zzleVar;
                        zziy zziyVar = this.zza;
                        if (i == 0) {
                            return zziyVar.zzb(zzleVar2.zza());
                        }
                        if (i != 1) {
                            if (i == 2) {
                                ApiException apiException = (ApiException) exception;
                                if (apiException.getStatusCode() != 17) {
                                    i = 3;
                                } else {
                                    ConnectionResult connectionResult = apiException.getStatus().getConnectionResult();
                                    if (connectionResult != null && connectionResult.getErrorCode() == 26) {
                                        return zziyVar.zzb(zzleVar2.zza());
                                    }
                                }
                            }
                        } else {
                            if (((ApiException) exception).getStatusCode() == 29514) {
                                return zziyVar.zzb(zzleVar2.zza());
                            }
                            i = 2;
                        }
                    }
                }
                return task;
            }
        });
    }
}
