package com.example.tickets;

import android.content.Context;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;
import com.google.android.gms.tasks.OnFailureListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TicketShareManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/example/tickets/TicketShareManager$connectionLifecycleCallback$1", "Lcom/google/android/gms/nearby/connection/ConnectionLifecycleCallback;", "onConnectionInitiated", "", "endpointId", "", "connectionInfo", "Lcom/google/android/gms/nearby/connection/ConnectionInfo;", "onConnectionResult", "result", "Lcom/google/android/gms/nearby/connection/ConnectionResolution;", "onDisconnected", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TicketShareManager$connectionLifecycleCallback$1 extends ConnectionLifecycleCallback {
    TicketShareManager$connectionLifecycleCallback$1() {
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback, com.google.android.gms.nearby.connection.zza
    public void onConnectionInitiated(String endpointId, ConnectionInfo connectionInfo) {
        Intrinsics.checkNotNullParameter(endpointId, "endpointId");
        Intrinsics.checkNotNullParameter(connectionInfo, "connectionInfo");
        Context context = TicketShareManager.context;
        if (context == null) {
            return;
        }
        TicketShareManager ticketShareManager = TicketShareManager.INSTANCE;
        TicketShareManager.connectedEndpointId = endpointId;
        TicketShareManager.INSTANCE.postState(TicketShareManager.State.CONNECTING, "正在确认附近设备…");
        Nearby.getConnectionsClient(context).acceptConnection(endpointId, TicketShareManager.payloadCallback).addOnFailureListener(new OnFailureListener() { // from class: com.example.tickets.TicketShareManager$connectionLifecycleCallback$1$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                TicketShareManager$connectionLifecycleCallback$1.onConnectionInitiated$lambda$0(exc);
            }
        });
    }

    static final void onConnectionInitiated$lambda$0(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        TicketShareManager ticketShareManager = TicketShareManager.INSTANCE;
        TicketShareManager.State state = TicketShareManager.State.ERROR;
        String message = e.getMessage();
        if (message == null) {
            message = "未知错误";
        }
        ticketShareManager.postState(state, "连接确认失败：" + message);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback, com.google.android.gms.nearby.connection.zza
    public void onConnectionResult(String endpointId, ConnectionResolution result) {
        Unit unit;
        Intrinsics.checkNotNullParameter(endpointId, "endpointId");
        Intrinsics.checkNotNullParameter(result, "result");
        TicketShareManager ticketShareManager = TicketShareManager.INSTANCE;
        TicketShareManager.connectedEndpointId = endpointId;
        Context context = TicketShareManager.context;
        if (context == null) {
            return;
        }
        if (result.getStatus().isSuccess()) {
            if (TicketShareManager.wifiFallbackStarted) {
                TicketShareManager ticketShareManager2 = TicketShareManager.INSTANCE;
                TicketShareManager.wifiFallbackStarted = false;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    TicketShareManager$connectionLifecycleCallback$1 ticketShareManager$connectionLifecycleCallback$1 = this;
                    TicketWifiDirectTransport ticketWifiDirectTransport = TicketShareManager.wifiDirectTransport;
                    if (ticketWifiDirectTransport != null) {
                        ticketWifiDirectTransport.stop();
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    Result.m9536constructorimpl(unit);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m9536constructorimpl(ResultKt.createFailure(th));
                }
                TicketShareManager ticketShareManager3 = TicketShareManager.INSTANCE;
                TicketShareManager.wifiDirectTransport = null;
            }
            if (TicketShareManager.role != TicketShareManager.Role.RECEIVER) {
                if (TicketShareManager.nfcCompatibilityMode) {
                    TicketShareManager.INSTANCE.sendBytes(context, endpointId, "NFC_COMPAT_HELLO|" + TicketShareManager.sessionId + "|" + TicketShareManager.sessionToken);
                }
                TicketShareManager.INSTANCE.postState(TicketShareManager.State.SCANNED, "已感应到 / 检测到对方设备");
                return;
            }
            TicketShareManager.INSTANCE.sendBytes(context, endpointId, "SCANNED|" + TicketShareManager.sessionId + "|" + TicketShareManager.sessionToken);
            TicketShareManager.INSTANCE.postState(TicketShareManager.State.WAITING_SENDER_CONFIRM, "对方已连接，等待发送方确认…");
            return;
        }
        TicketShareManager.INSTANCE.postState(TicketShareManager.State.ERROR, "设备连接失败，请重新尝试。");
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback, com.google.android.gms.nearby.connection.zza
    public void onDisconnected(String endpointId) {
        Intrinsics.checkNotNullParameter(endpointId, "endpointId");
        if (TicketShareManager.INSTANCE.getUiState().getState() == TicketShareManager.State.SUCCESS || TicketShareManager.INSTANCE.getUiState().getState() == TicketShareManager.State.REJECTED) {
            return;
        }
        TicketShareManager.INSTANCE.postState(TicketShareManager.State.ERROR, "连接已断开，请重新尝试。");
    }
}
