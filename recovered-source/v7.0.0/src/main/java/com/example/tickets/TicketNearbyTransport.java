package com.example.tickets;

import android.content.Context;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import com.google.android.gms.nearby.connection.Strategy;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TicketNearbyTransport.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004*\u0003\u0017\u001a\u001d\b\u0001\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e¨\u0006 "}, d2 = {"Lcom/example/tickets/TicketNearbyTransport;", "Lcom/example/tickets/TicketTransport;", "<init>", "()V", "context", "Landroid/content/Context;", "callback", "Lcom/example/tickets/TicketTransport$Callback;", "endpointId", "", "serverStarted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "clientStarted", "startServer", "", "startClient", "send", "bytes", "", "Lkotlin/Function1;", "", "stop", "endpointDiscoveryCallback", "com/example/tickets/TicketNearbyTransport$endpointDiscoveryCallback$1", "Lcom/example/tickets/TicketNearbyTransport$endpointDiscoveryCallback$1;", "connectionLifecycleCallback", "com/example/tickets/TicketNearbyTransport$connectionLifecycleCallback$1", "Lcom/example/tickets/TicketNearbyTransport$connectionLifecycleCallback$1;", "payloadCallback", "com/example/tickets/TicketNearbyTransport$payloadCallback$1", "Lcom/example/tickets/TicketNearbyTransport$payloadCallback$1;", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TicketNearbyTransport implements TicketTransport {
    private static final String ENDPOINT_NAME = "Tickets";
    private static final String SERVICE_ID = "com.example.tickets.share.transport.v1";
    private TicketTransport.Callback callback;
    private Context context;
    private String endpointId;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final AtomicBoolean serverStarted = new AtomicBoolean(false);
    private final AtomicBoolean clientStarted = new AtomicBoolean(false);
    private final TicketNearbyTransport$endpointDiscoveryCallback$1 endpointDiscoveryCallback = new TicketNearbyTransport$endpointDiscoveryCallback$1(this);
    private final TicketNearbyTransport$connectionLifecycleCallback$1 connectionLifecycleCallback = new TicketNearbyTransport$connectionLifecycleCallback$1(this);
    private final TicketNearbyTransport$payloadCallback$1 payloadCallback = new PayloadCallback() { // from class: com.example.tickets.TicketNearbyTransport$payloadCallback$1
        @Override // com.google.android.gms.nearby.connection.PayloadCallback
        public void onPayloadTransferUpdate(String endpointId, PayloadTransferUpdate update) {
            Intrinsics.checkNotNullParameter(endpointId, "endpointId");
            Intrinsics.checkNotNullParameter(update, "update");
        }

        @Override // com.google.android.gms.nearby.connection.PayloadCallback
        public void onPayloadReceived(String endpointId, Payload payload) {
            TicketTransport.Callback callback;
            Intrinsics.checkNotNullParameter(endpointId, "endpointId");
            Intrinsics.checkNotNullParameter(payload, "payload");
            byte[] bArrAsBytes = payload.asBytes();
            if (bArrAsBytes == null || (callback = this.this$0.callback) == null) {
                return;
            }
            callback.onBytesReceived(TicketTransport.Kind.NEARBY, bArrAsBytes);
        }
    };

    /* JADX INFO: compiled from: TicketNearbyTransport.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/tickets/TicketNearbyTransport$Companion;", "", "<init>", "()V", "SERVICE_ID", "", "ENDPOINT_NAME", "isAvailable", "", "context", "Landroid/content/Context;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isAvailable(Context context) {
            Object objM9536constructorimpl;
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                Nearby.getConnectionsClient(context.getApplicationContext());
                objM9536constructorimpl = Result.m9536constructorimpl(true);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
                objM9536constructorimpl = false;
            }
            return ((Boolean) objM9536constructorimpl).booleanValue();
        }
    }

    @Override // com.example.tickets.TicketTransport
    public void startServer(Context context, final TicketTransport.Callback callback) {
        Object objM9536constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        stop();
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.callback = callback;
        if (applicationContext == null) {
            return;
        }
        ConnectionsClient connectionsClient = Nearby.getConnectionsClient(applicationContext);
        Intrinsics.checkNotNullExpressionValue(connectionsClient, "getConnectionsClient(...)");
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketNearbyTransport ticketNearbyTransport = this;
            connectionsClient.stopAdvertising();
            Task<Void> taskStartAdvertising = connectionsClient.startAdvertising(ENDPOINT_NAME, SERVICE_ID, this.connectionLifecycleCallback, new AdvertisingOptions.Builder().setStrategy(Strategy.P2P_POINT_TO_POINT).build());
            final Function1 function1 = new Function1() { // from class: com.example.tickets.TicketNearbyTransport$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TicketNearbyTransport.startServer$lambda$3$lambda$0(this.f$0, callback, (Void) obj);
                }
            };
            objM9536constructorimpl = Result.m9536constructorimpl(taskStartAdvertising.addOnSuccessListener(new OnSuccessListener() { // from class: com.example.tickets.TicketNearbyTransport$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.example.tickets.TicketNearbyTransport$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    TicketNearbyTransport.startServer$lambda$3$lambda$2(callback, exc);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM9539exceptionOrNullimpl = Result.m9539exceptionOrNullimpl(objM9536constructorimpl);
        if (thM9539exceptionOrNullimpl != null) {
            TicketTransport.Kind kind = TicketTransport.Kind.NEARBY;
            String message = thM9539exceptionOrNullimpl.getMessage();
            if (message == null) {
                message = "Nearby 不可用";
            }
            callback.onError(kind, message);
        }
    }

    static final Unit startServer$lambda$3$lambda$0(TicketNearbyTransport ticketNearbyTransport, TicketTransport.Callback callback, Void r2) {
        ticketNearbyTransport.serverStarted.set(true);
        callback.onReady(TicketTransport.Kind.NEARBY);
        return Unit.INSTANCE;
    }

    static final void startServer$lambda$3$lambda$2(TicketTransport.Callback callback, Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        TicketTransport.Kind kind = TicketTransport.Kind.NEARBY;
        String message = e.getMessage();
        if (message == null) {
            message = "Nearby 广播启动失败";
        }
        callback.onError(kind, message);
    }

    @Override // com.example.tickets.TicketTransport
    public void startClient(Context context, final TicketTransport.Callback callback) {
        Object objM9536constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        stop();
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.callback = callback;
        if (applicationContext == null) {
            return;
        }
        ConnectionsClient connectionsClient = Nearby.getConnectionsClient(applicationContext);
        Intrinsics.checkNotNullExpressionValue(connectionsClient, "getConnectionsClient(...)");
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketNearbyTransport ticketNearbyTransport = this;
            connectionsClient.stopDiscovery();
            Task<Void> taskStartDiscovery = connectionsClient.startDiscovery(SERVICE_ID, this.endpointDiscoveryCallback, new DiscoveryOptions.Builder().setStrategy(Strategy.P2P_POINT_TO_POINT).build());
            final Function1 function1 = new Function1() { // from class: com.example.tickets.TicketNearbyTransport$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TicketNearbyTransport.startClient$lambda$8$lambda$5(this.f$0, callback, (Void) obj);
                }
            };
            objM9536constructorimpl = Result.m9536constructorimpl(taskStartDiscovery.addOnSuccessListener(new OnSuccessListener() { // from class: com.example.tickets.TicketNearbyTransport$$ExternalSyntheticLambda7
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.example.tickets.TicketNearbyTransport$$ExternalSyntheticLambda8
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    TicketNearbyTransport.startClient$lambda$8$lambda$7(callback, exc);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM9539exceptionOrNullimpl = Result.m9539exceptionOrNullimpl(objM9536constructorimpl);
        if (thM9539exceptionOrNullimpl != null) {
            TicketTransport.Kind kind = TicketTransport.Kind.NEARBY;
            String message = thM9539exceptionOrNullimpl.getMessage();
            if (message == null) {
                message = "Nearby 不可用";
            }
            callback.onError(kind, message);
        }
    }

    static final Unit startClient$lambda$8$lambda$5(TicketNearbyTransport ticketNearbyTransport, TicketTransport.Callback callback, Void r2) {
        ticketNearbyTransport.clientStarted.set(true);
        callback.onReady(TicketTransport.Kind.NEARBY);
        return Unit.INSTANCE;
    }

    static final void startClient$lambda$8$lambda$7(TicketTransport.Callback callback, Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        TicketTransport.Kind kind = TicketTransport.Kind.NEARBY;
        String message = e.getMessage();
        if (message == null) {
            message = "Nearby 搜索启动失败";
        }
        callback.onError(kind, message);
    }

    @Override // com.example.tickets.TicketTransport
    public void send(byte[] bytes, final Function1<? super Boolean, Unit> callback) {
        String str;
        Object objM9536constructorimpl;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Context context = this.context;
        String str2 = this.endpointId;
        if (context == null || (str = str2) == null || StringsKt.isBlank(str)) {
            if (callback != null) {
                callback.invoke(false);
                return;
            }
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketNearbyTransport ticketNearbyTransport = this;
            Task<Void> taskSendPayload = Nearby.getConnectionsClient(context).sendPayload(str2, Payload.fromBytes(bytes));
            final Function1 function1 = new Function1() { // from class: com.example.tickets.TicketNearbyTransport$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TicketNearbyTransport.send$lambda$13$lambda$10(callback, (Void) obj);
                }
            };
            objM9536constructorimpl = Result.m9536constructorimpl(taskSendPayload.addOnSuccessListener(new OnSuccessListener() { // from class: com.example.tickets.TicketNearbyTransport$$ExternalSyntheticLambda4
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.example.tickets.TicketNearbyTransport$$ExternalSyntheticLambda5
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    TicketNearbyTransport.send$lambda$13$lambda$12(callback, exc);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9539exceptionOrNullimpl(objM9536constructorimpl) == null || callback == null) {
            return;
        }
        callback.invoke(false);
    }

    static final Unit send$lambda$13$lambda$10(Function1 function1, Void r1) {
        if (function1 != null) {
            function1.invoke(true);
        }
        return Unit.INSTANCE;
    }

    static final void send$lambda$13$lambda$12(Function1 function1, Exception it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (function1 != null) {
            function1.invoke(false);
        }
    }

    @Override // com.example.tickets.TicketTransport
    public void stop() {
        Context context = this.context;
        if (context != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                TicketNearbyTransport ticketNearbyTransport = this;
                Nearby.getConnectionsClient(context).stopAdvertising();
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th));
            }
            try {
                Result.Companion companion3 = Result.INSTANCE;
                TicketNearbyTransport ticketNearbyTransport2 = this;
                Nearby.getConnectionsClient(context).stopDiscovery();
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th2));
            }
            try {
                Result.Companion companion5 = Result.INSTANCE;
                TicketNearbyTransport ticketNearbyTransport3 = this;
                Nearby.getConnectionsClient(context).stopAllEndpoints();
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th3));
            }
        }
        this.context = null;
        this.callback = null;
        this.endpointId = null;
        this.serverStarted.set(false);
        this.clientStarted.set(false);
    }
}
