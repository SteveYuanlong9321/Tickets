package com.example.tickets;

import android.content.Context;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.DiscoveredEndpointInfo;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.tasks.OnFailureListener;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TicketShareManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/example/tickets/TicketShareManager$endpointDiscoveryCallback$1", "Lcom/google/android/gms/nearby/connection/EndpointDiscoveryCallback;", "onEndpointFound", "", "endpointId", "", "info", "Lcom/google/android/gms/nearby/connection/DiscoveredEndpointInfo;", "onEndpointLost", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TicketShareManager$endpointDiscoveryCallback$1 extends EndpointDiscoveryCallback {
    @Override // com.google.android.gms.nearby.connection.EndpointDiscoveryCallback
    public void onEndpointLost(String endpointId) {
        Intrinsics.checkNotNullParameter(endpointId, "endpointId");
    }

    TicketShareManager$endpointDiscoveryCallback$1() {
    }

    @Override // com.google.android.gms.nearby.connection.EndpointDiscoveryCallback
    public void onEndpointFound(String endpointId, DiscoveredEndpointInfo info) {
        Object objM9536constructorimpl;
        Intrinsics.checkNotNullParameter(endpointId, "endpointId");
        Intrinsics.checkNotNullParameter(info, "info");
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketShareManager$endpointDiscoveryCallback$1 ticketShareManager$endpointDiscoveryCallback$1 = this;
            byte[] endpointInfo = info.getEndpointInfo();
            Intrinsics.checkNotNullExpressionValue(endpointInfo, "getEndpointInfo(...)");
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            objM9536constructorimpl = Result.m9536constructorimpl(new String(endpointInfo, UTF_8));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
            objM9536constructorimpl = "";
        }
        String str = (String) objM9536constructorimpl;
        String str2 = "TICKETS_SHARE_V1|" + TicketShareManager.sessionId + "|" + TicketShareManager.sessionToken;
        boolean zStartsWith$default = StringsKt.startsWith$default(str, "TICKETS_NFC_COMPAT_V1|", false, 2, (Object) null);
        if (TicketShareManager.nfcCompatibilityMode) {
            if (!Intrinsics.areEqual(str, str2) && !zStartsWith$default) {
                return;
            }
        } else if (!Intrinsics.areEqual(str, str2) && (TicketShareManager.transport != TicketShareManager.Transport.NFC || !zStartsWith$default)) {
            return;
        }
        if (zStartsWith$default && StringsKt.isBlank(TicketShareManager.sessionId)) {
            List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.removePrefix(str, (CharSequence) "TICKETS_NFC_COMPAT_V1|"), new String[]{"|"}, false, 2, 2, (Object) null);
            if (listSplit$default.size() == 2 && !StringsKt.isBlank((CharSequence) listSplit$default.get(0)) && !StringsKt.isBlank((CharSequence) listSplit$default.get(1))) {
                TicketShareManager ticketShareManager = TicketShareManager.INSTANCE;
                TicketShareManager.sessionId = (String) listSplit$default.get(0);
                TicketShareManager ticketShareManager2 = TicketShareManager.INSTANCE;
                TicketShareManager.sessionToken = (String) listSplit$default.get(1);
            }
        }
        Context context = TicketShareManager.context;
        if (context == null) {
            return;
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            TicketShareManager$endpointDiscoveryCallback$1 ticketShareManager$endpointDiscoveryCallback$2 = this;
            Nearby.getConnectionsClient(context).stopDiscovery();
            Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th2));
        }
        TicketShareManager.INSTANCE.postState(TicketShareManager.State.CONNECTING, "已发现发送设备，正在建立连接…");
        Nearby.getConnectionsClient(context).requestConnection("Tickets", endpointId, TicketShareManager.connectionLifecycleCallback).addOnFailureListener(new OnFailureListener() { // from class: com.example.tickets.TicketShareManager$endpointDiscoveryCallback$1$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                TicketShareManager$endpointDiscoveryCallback$1.onEndpointFound$lambda$2(exc);
            }
        });
    }

    static final void onEndpointFound$lambda$2(Exception it) {
        Intrinsics.checkNotNullParameter(it, "it");
        TicketShareManager ticketShareManager = TicketShareManager.INSTANCE;
        TicketShareManager.State state = TicketShareManager.State.ERROR;
        String message = it.getMessage();
        if (message == null) {
            message = "未知错误";
        }
        ticketShareManager.postState(state, "Nearby 连接建立失败：" + message);
    }
}
