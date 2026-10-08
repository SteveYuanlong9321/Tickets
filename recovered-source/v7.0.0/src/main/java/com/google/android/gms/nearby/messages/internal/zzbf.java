package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbf extends GoogleApi implements MessagesClient {
    public static final /* synthetic */ int zza = 0;
    private static final Api.ClientKey zzb;
    private static final Api.AbstractClientBuilder zzc;
    private static final Api zzd;
    private final int zze;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zzb = clientKey;
        zzai zzaiVar = new zzai();
        zzc = zzaiVar;
        zzd = new Api("Nearby.MESSAGES_API", zzaiVar, clientKey);
    }

    public zzbf(Activity activity, MessagesOptions messagesOptions) {
        super(activity, (Api<MessagesOptions>) zzd, messagesOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zze = 1;
        activity.getApplication().registerActivityLifecycleCallbacks(new zzan(activity, this, null));
    }

    private final ListenerHolder zzh(TaskCompletionSource taskCompletionSource) {
        return registerListener(new zzal(this, taskCompletionSource), Status.class.getName());
    }

    private final Task zzi(Object obj, int i) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Preconditions.checkNotNull(obj);
        doUnregisterEventListener(ListenerHolders.createListenerKey(obj, obj.getClass().getName()), i).addOnCompleteListener(new zzam(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private final ListenerHolder zzj(Object obj) {
        if (obj == null) {
            return null;
        }
        return registerListener(obj, obj.getClass().getName());
    }

    private final Task zzk(ListenerHolder listenerHolder, final zzao zzaoVar, final zzao zzaoVar2, int i) {
        return doRegisterEventListener(RegistrationMethods.builder().withHolder(listenerHolder).register(new RemoteCall() { // from class: com.google.android.gms.nearby.messages.internal.zzay
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                this.zza.zzd(zzaoVar, (zzah) obj, (TaskCompletionSource) obj2);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.nearby.messages.internal.zzaz
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                this.zza.zze(zzaoVar2, (zzah) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(i).build());
    }

    private final Task zzl(final zzao zzaoVar, int i) {
        return doWrite(TaskApiCall.builder().setMethodKey(i).run(new RemoteCall() { // from class: com.google.android.gms.nearby.messages.internal.zzaq
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                this.zza.zzf(zzaoVar, (zzah) obj, (TaskCompletionSource) obj2);
            }
        }).build());
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    protected final ClientSettings.Builder createClientSettingsBuilder() {
        ClientSettings.Builder builderCreateClientSettingsBuilder = super.createClientSettingsBuilder();
        if (getApiOptions() != null) {
            String str = ((MessagesOptions) getApiOptions()).zze;
        }
        return builderCreateClientSettingsBuilder;
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final void handleIntent(Intent intent, MessageListener messageListener) {
        com.google.android.gms.internal.nearby.zzbf.zzc(intent, messageListener);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> publish(Message message) {
        PublishOptions publishOptions = PublishOptions.DEFAULT;
        Preconditions.checkNotNull(message);
        Preconditions.checkNotNull(publishOptions);
        ListenerHolder listenerHolderZzj = zzj(message);
        return zzk(listenerHolderZzj, new zzba(this, message, new zzaj(this, zzj(publishOptions.getCallback()), listenerHolderZzj), publishOptions), new zzap(message), 1291);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> registerStatusCallback(StatusCallback statusCallback) {
        Preconditions.checkNotNull(statusCallback);
        final ListenerHolder listenerHolderZzj = zzj(statusCallback);
        return zzk(listenerHolderZzj, new zzao() { // from class: com.google.android.gms.nearby.messages.internal.zzav
            @Override // com.google.android.gms.nearby.messages.internal.zzao
            public final /* synthetic */ void zza(zzah zzahVar, ListenerHolder listenerHolder) throws RemoteException {
                int i = zzbf.zza;
                zzahVar.zzF(listenerHolder, listenerHolderZzj);
            }
        }, new zzao() { // from class: com.google.android.gms.nearby.messages.internal.zzaw
            @Override // com.google.android.gms.nearby.messages.internal.zzao
            public final /* synthetic */ void zza(zzah zzahVar, ListenerHolder listenerHolder) throws RemoteException {
                int i = zzbf.zza;
                zzahVar.zzG(listenerHolder, listenerHolderZzj);
            }
        }, 1270);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(PendingIntent pendingIntent) {
        SubscribeOptions subscribeOptions = SubscribeOptions.DEFAULT;
        Preconditions.checkNotNull(pendingIntent);
        Preconditions.checkNotNull(subscribeOptions);
        ListenerHolder listenerHolderZzj = zzj(subscribeOptions.getCallback());
        return zzl(new zzat(this, pendingIntent, listenerHolderZzj == null ? null : new zzbe(listenerHolderZzj), subscribeOptions), 1288);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unpublish(Message message) {
        Preconditions.checkNotNull(message);
        return zzi(message, 1290);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unregisterStatusCallback(StatusCallback statusCallback) {
        Preconditions.checkNotNull(statusCallback);
        return zzi(statusCallback, 1271);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unsubscribe(final PendingIntent pendingIntent) {
        Preconditions.checkNotNull(pendingIntent);
        return zzl(new zzao() { // from class: com.google.android.gms.nearby.messages.internal.zzau
            @Override // com.google.android.gms.nearby.messages.internal.zzao
            public final /* synthetic */ void zza(zzah zzahVar, ListenerHolder listenerHolder) throws RemoteException {
                int i = zzbf.zza;
                zzahVar.zzE(listenerHolder, pendingIntent);
            }
        }, 1287);
    }

    final /* synthetic */ void zza(Message message, zzbc zzbcVar, PublishOptions publishOptions, zzah zzahVar, ListenerHolder listenerHolder) {
        zzahVar.zzw(listenerHolder, new zzae(1, message), zzbcVar, publishOptions, this.zze);
    }

    final /* synthetic */ void zzb(ListenerHolder listenerHolder, zzbe zzbeVar, SubscribeOptions subscribeOptions, zzah zzahVar, ListenerHolder listenerHolder2) {
        zzahVar.zzz(listenerHolder2, listenerHolder, zzbeVar, subscribeOptions, null, this.zze);
    }

    final /* synthetic */ void zzc(PendingIntent pendingIntent, zzbe zzbeVar, SubscribeOptions subscribeOptions, zzah zzahVar, ListenerHolder listenerHolder) {
        zzahVar.zzB(listenerHolder, pendingIntent, zzbeVar, subscribeOptions, this.zze);
    }

    final /* synthetic */ void zzd(zzao zzaoVar, zzah zzahVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzaoVar.zza(zzahVar, zzh(taskCompletionSource));
    }

    final /* synthetic */ void zze(zzao zzaoVar, zzah zzahVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzaoVar.zza(zzahVar, zzh(taskCompletionSource));
    }

    final /* synthetic */ void zzf(zzao zzaoVar, zzah zzahVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzaoVar.zza(zzahVar, zzh(taskCompletionSource));
    }

    final /* synthetic */ void zzg(int i) {
        final int i2 = 1;
        zzl(new zzao(i2) { // from class: com.google.android.gms.nearby.messages.internal.zzax
            @Override // com.google.android.gms.nearby.messages.internal.zzao
            public final /* synthetic */ void zza(zzah zzahVar, ListenerHolder listenerHolder) throws RemoteException {
                int i3 = zzbf.zza;
                zzahVar.zzH(1);
            }
        }, 0);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unsubscribe(MessageListener messageListener) {
        Preconditions.checkNotNull(messageListener);
        return zzi(messageListener, 1286);
    }

    public zzbf(Context context, MessagesOptions messagesOptions) {
        super(context, (Api<MessagesOptions>) zzd, messagesOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zze = zzah.zzu(context);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(PendingIntent pendingIntent, SubscribeOptions subscribeOptions) {
        Preconditions.checkNotNull(pendingIntent);
        Preconditions.checkNotNull(subscribeOptions);
        ListenerHolder listenerHolderZzj = zzj(subscribeOptions.getCallback());
        return zzl(new zzat(this, pendingIntent, listenerHolderZzj == null ? null : new zzbe(listenerHolderZzj), subscribeOptions), 1288);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> publish(Message message, PublishOptions publishOptions) {
        Preconditions.checkNotNull(message);
        Preconditions.checkNotNull(publishOptions);
        ListenerHolder listenerHolderZzj = zzj(message);
        return zzk(listenerHolderZzj, new zzba(this, message, new zzaj(this, zzj(publishOptions.getCallback()), listenerHolderZzj), publishOptions), new zzap(message), 1291);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(MessageListener messageListener) {
        SubscribeOptions subscribeOptions = SubscribeOptions.DEFAULT;
        Preconditions.checkNotNull(messageListener);
        Preconditions.checkNotNull(subscribeOptions);
        Preconditions.checkArgument(subscribeOptions.getStrategy().zza() == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        ListenerHolder listenerHolderZzj = zzj(messageListener);
        ListenerHolder listenerHolderZzj2 = zzj(subscribeOptions.getCallback());
        return zzk(listenerHolderZzj, new zzar(this, listenerHolderZzj, new zzak(this, listenerHolderZzj2, listenerHolderZzj2), subscribeOptions), new zzas(listenerHolderZzj), 1289);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(MessageListener messageListener, SubscribeOptions subscribeOptions) {
        Preconditions.checkNotNull(messageListener);
        Preconditions.checkNotNull(subscribeOptions);
        Preconditions.checkArgument(subscribeOptions.getStrategy().zza() == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        ListenerHolder listenerHolderZzj = zzj(messageListener);
        ListenerHolder listenerHolderZzj2 = zzj(subscribeOptions.getCallback());
        return zzk(listenerHolderZzj, new zzar(this, listenerHolderZzj, new zzak(this, listenerHolderZzj2, listenerHolderZzj2), subscribeOptions), new zzas(listenerHolderZzj), 1289);
    }
}
