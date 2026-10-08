package com.example.tickets;

import android.content.Context;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.DiscoveredEndpointInfo;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TicketNearbyTransport.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/example/tickets/TicketNearbyTransport$endpointDiscoveryCallback$1", "Lcom/google/android/gms/nearby/connection/EndpointDiscoveryCallback;", "onEndpointFound", "", "endpointId", "", "info", "Lcom/google/android/gms/nearby/connection/DiscoveredEndpointInfo;", "onEndpointLost", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TicketNearbyTransport$endpointDiscoveryCallback$1 extends EndpointDiscoveryCallback {
    final /* synthetic */ TicketNearbyTransport this$0;

    @Override // com.google.android.gms.nearby.connection.EndpointDiscoveryCallback
    public void onEndpointLost(String endpointId) {
        Intrinsics.checkNotNullParameter(endpointId, "endpointId");
    }

    TicketNearbyTransport$endpointDiscoveryCallback$1(TicketNearbyTransport ticketNearbyTransport) {
        this.this$0 = ticketNearbyTransport;
    }

    @Override // com.google.android.gms.nearby.connection.EndpointDiscoveryCallback
    public void onEndpointFound(String endpointId, DiscoveredEndpointInfo info) {
        Intrinsics.checkNotNullParameter(endpointId, "endpointId");
        Intrinsics.checkNotNullParameter(info, "info");
        Context context = this.this$0.context;
        if (context == null) {
            return;
        }
        this.this$0.endpointId = endpointId;
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketNearbyTransport$endpointDiscoveryCallback$1 ticketNearbyTransport$endpointDiscoveryCallback$1 = this;
            Nearby.getConnectionsClient(context).stopDiscovery();
            Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        Task<Void> taskRequestConnection = Nearby.getConnectionsClient(context).requestConnection("Tickets", endpointId, this.this$0.connectionLifecycleCallback);
        final TicketNearbyTransport ticketNearbyTransport = this.this$0;
        taskRequestConnection.addOnFailureListener(new OnFailureListener() { // from class: com.example.tickets.TicketNearbyTransport$endpointDiscoveryCallback$1$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                TicketNearbyTransport$endpointDiscoveryCallback$1.onEndpointFound$lambda$1(ticketNearbyTransport, exc);
            }
        });
    }

    static final void onEndpointFound$lambda$1(TicketNearbyTransport ticketNearbyTransport, Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        TicketTransport.Callback callback = ticketNearbyTransport.callback;
        if (callback != null) {
            TicketTransport.Kind kind = TicketTransport.Kind.NEARBY;
            String message = e.getMessage();
            if (message == null) {
                message = "Nearby 请求连接失败";
            }
            callback.onError(kind, message);
        }
    }
}
