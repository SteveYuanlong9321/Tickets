package com.example.tickets;

import android.content.Context;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TicketNearbyTransport.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/example/tickets/TicketNearbyTransport$connectionLifecycleCallback$1", "Lcom/google/android/gms/nearby/connection/ConnectionLifecycleCallback;", "onConnectionInitiated", "", "endpointId", "", "connectionInfo", "Lcom/google/android/gms/nearby/connection/ConnectionInfo;", "onConnectionResult", "result", "Lcom/google/android/gms/nearby/connection/ConnectionResolution;", "onDisconnected", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TicketNearbyTransport$connectionLifecycleCallback$1 extends ConnectionLifecycleCallback {
    final /* synthetic */ TicketNearbyTransport this$0;

    TicketNearbyTransport$connectionLifecycleCallback$1(TicketNearbyTransport ticketNearbyTransport) {
        this.this$0 = ticketNearbyTransport;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback, com.google.android.gms.nearby.connection.zza
    public void onConnectionInitiated(String endpointId, ConnectionInfo connectionInfo) {
        Intrinsics.checkNotNullParameter(endpointId, "endpointId");
        Intrinsics.checkNotNullParameter(connectionInfo, "connectionInfo");
        Context context = this.this$0.context;
        if (context == null) {
            return;
        }
        this.this$0.endpointId = endpointId;
        Task<Void> taskAcceptConnection = Nearby.getConnectionsClient(context).acceptConnection(endpointId, this.this$0.payloadCallback);
        final TicketNearbyTransport ticketNearbyTransport = this.this$0;
        taskAcceptConnection.addOnFailureListener(new OnFailureListener() { // from class: com.example.tickets.TicketNearbyTransport$connectionLifecycleCallback$1$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                TicketNearbyTransport$connectionLifecycleCallback$1.onConnectionInitiated$lambda$0(ticketNearbyTransport, exc);
            }
        });
    }

    static final void onConnectionInitiated$lambda$0(TicketNearbyTransport ticketNearbyTransport, Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        TicketTransport.Callback callback = ticketNearbyTransport.callback;
        if (callback != null) {
            TicketTransport.Kind kind = TicketTransport.Kind.NEARBY;
            String message = e.getMessage();
            if (message == null) {
                message = "Nearby 接受连接失败";
            }
            callback.onError(kind, message);
        }
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback, com.google.android.gms.nearby.connection.zza
    public void onConnectionResult(String endpointId, ConnectionResolution result) {
        Intrinsics.checkNotNullParameter(endpointId, "endpointId");
        Intrinsics.checkNotNullParameter(result, "result");
        this.this$0.endpointId = endpointId;
        boolean zIsSuccess = result.getStatus().isSuccess();
        TicketNearbyTransport ticketNearbyTransport = this.this$0;
        if (zIsSuccess) {
            TicketTransport.Callback callback = ticketNearbyTransport.callback;
            if (callback != null) {
                callback.onConnected(TicketTransport.Kind.NEARBY);
                return;
            }
            return;
        }
        TicketTransport.Callback callback2 = ticketNearbyTransport.callback;
        if (callback2 != null) {
            callback2.onError(TicketTransport.Kind.NEARBY, "Nearby 连接失败：" + result.getStatus().getStatusCode());
        }
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback, com.google.android.gms.nearby.connection.zza
    public void onDisconnected(String endpointId) {
        Intrinsics.checkNotNullParameter(endpointId, "endpointId");
        if (Intrinsics.areEqual(this.this$0.endpointId, endpointId)) {
            this.this$0.endpointId = null;
        }
        TicketTransport.Callback callback = this.this$0.callback;
        if (callback != null) {
            callback.onDisconnected(TicketTransport.Kind.NEARBY);
        }
    }
}
