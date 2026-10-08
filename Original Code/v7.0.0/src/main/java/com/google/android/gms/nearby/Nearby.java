package com.google.android.gms.nearby;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.nearby.zzag;
import com.google.android.gms.internal.nearby.zzhq;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.ConnectionsOptions;
import com.google.android.gms.nearby.fastpair.FastPairClient;
import com.google.android.gms.nearby.internal.connection.zzch;
import com.google.android.gms.nearby.internal.connection.zzdg;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.internal.zzbf;
import com.google.android.gms.nearby.messages.internal.zzbv;
import com.google.android.gms.nearby.messages.internal.zzbw;
import com.google.android.gms.nearby.uwb.UwbClient;
import com.google.android.gms.nearby.uwb.zzb;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class Nearby {

    @Deprecated
    public static final Api<ConnectionsOptions> CONNECTIONS_API = new Api<>("Nearby.CONNECTIONS_API", zzdg.zzb, zzdg.zza);

    @Deprecated
    public static final Connections Connections = new zzdg();

    @Deprecated
    public static final Api<MessagesOptions> MESSAGES_API = new Api<>("Nearby.MESSAGES_API", zzbv.zzc, zzbv.zzb);

    @Deprecated
    public static final Messages Messages = zzbv.zza;

    static {
        int i = zzbw.zza;
    }

    private Nearby() {
    }

    public static final ConnectionsClient getConnectionsClient(Activity activity) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        return zzch.zzb(activity, null);
    }

    public static FastPairClient getFastPairClient(Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        return new zzag(context);
    }

    @Deprecated
    public static final MessagesClient getMessagesClient(Activity activity) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        return new zzbf(activity, (MessagesOptions) null);
    }

    public static UwbClient getUwbControleeClient(Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        zzb zzbVar = new zzb();
        zzbVar.zza(2);
        return new zzhq(context, zzbVar.zzb());
    }

    public static UwbClient getUwbControllerClient(Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        zzb zzbVar = new zzb();
        zzbVar.zza(1);
        return new zzhq(context, zzbVar.zzb());
    }

    public static final ConnectionsClient getConnectionsClient(Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        return zzch.zza(context, null);
    }

    @Deprecated
    public static final MessagesClient getMessagesClient(Activity activity, MessagesOptions messagesOptions) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        Preconditions.checkNotNull(messagesOptions, "Options must not be null");
        return new zzbf(activity, messagesOptions);
    }

    @Deprecated
    public static final MessagesClient getMessagesClient(Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        return new zzbf(context, (MessagesOptions) null);
    }

    @Deprecated
    public static final MessagesClient getMessagesClient(Context context, MessagesOptions messagesOptions) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(messagesOptions, "Options must not be null");
        return new zzbf(context, messagesOptions);
    }
}
